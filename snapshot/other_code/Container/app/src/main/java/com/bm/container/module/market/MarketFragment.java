package com.bm.container.module.market;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.NetHelper;
import com.bm.container.Tools.SpUtil;
import com.bm.container.databinding.FragmentMarketBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.BaseFragment;
import com.bm.container.module.base.MainActivity;
import com.bm.container.module.login.bean.GetCityListBean;
import com.bm.container.module.market.adapter.MarketAdapter;
import com.bm.container.module.market.adapter.StatusBean;
import com.bm.container.module.market.adapter.TypeBean;
import com.bm.container.module.market.bean.BuyListBean;
import com.bm.container.module.market.bean.InfoBean;
import com.bm.container.module.market.bean.SaleListBean;
import com.bm.container.view.ChooseCityDialog;
import com.bm.container.view.ChooseStatusDialog;
import com.bm.container.view.ChooseTypeDialog;
import com.flyco.tablayout.CommonTabLayout;

import java.util.ArrayList;

import io.reactivex.functions.Consumer;

/**
 * 碎片页 P4首页
 */

public class MarketFragment extends BaseFragment {
    private FragmentMarketBinding binding;
    private Context context;
    private MarketAdapter adapter;
    private boolean leftTabSellected = true;
    private ChooseCityDialog cityDialog;
    private ChooseTypeDialog typeDialog;
    private Boolean isMoneyUp = false;
    private ArrayList<String> tabs = new ArrayList<>();
    private CommonTabLayout layout;
    private ArrayList<InfoBean> col = new ArrayList<>();
    private String cityId = "";
    private String typeId = "";
    private String choooseStatusId = "";//箱况id
    private String sort = "";
    private Animation rotate;
    private Animation rotateDown;
    private ChooseStatusDialog choooseStatusDialog;


    public static MarketFragment getInstance(CommonTabLayout layout) {
        MarketFragment fragment = new MarketFragment();
        fragment.layout = layout;
        return fragment;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            if (SpUtil.getBoolean(SpUtil.JUMPSALELIST, false)) {
                leftTabSellected = true;
                setTab();
                SpUtil.setBoolean(SpUtil.JUMPSALELIST, false);
            } else if (SpUtil.getBoolean(SpUtil.SELL_BOX_SUCCESSFULLY_RELEASED, false)) {
                leftTabSellected = true;
                setTab();
                SpUtil.setBoolean(SpUtil.SELL_BOX_SUCCESSFULLY_RELEASED, false);
            } else if (col.size() == 0) {
                requestInfo();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isHidden()) {
            requestInfo();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_market, container, false);
        context = getActivity();

        //创建动画
        rotate = AnimationUtils.loadAnimation(getActivity(), R.anim.arrow_up);
        rotateDown = AnimationUtils.loadAnimation(getActivity(), R.anim.arrow_down);

        setTopbar();
        setLoading();
        setList();
        initTab();
        initChooseCity();
        initChooseType();
        setStatus();
//		initChooseMoney();
        initSendInfo();
        initSort();


        View view = binding.getRoot();
        view.setClickable(true);
        return binding.getRoot();
    }

    private void initSort() {
        binding.choooseMoney.setOnClickListener(v -> {
            if (binding.choooseMoney.getVisibility() == View.VISIBLE) {
                if (sort.isEmpty()) {
                    sort = "0";
//                    binding.moneyDirection.setImageResource(R.drawable.up);
                    rotate.setInterpolator(new LinearInterpolator());
                    rotate.setFillAfter(true);
                    binding.moneyDirection.startAnimation(rotate);

                } else if (sort.equals("0")) {
                    sort = "1";
//                    binding.moneyDirection.setImageResource(R.drawable.down);
                    rotateDown.setInterpolator(new LinearInterpolator());
                    rotateDown.setFillAfter(true);
                    binding.moneyDirection.startAnimation(rotateDown);
                } else {
                    sort = "0";
//                    binding.moneyDirection.setImageResource(R.drawable.up);
                    rotate.setInterpolator(new LinearInterpolator());
                    rotate.setFillAfter(true);
                    binding.moneyDirection.startAnimation(rotate);
                }
                requestInfo();
            }
        });
    }


    /**
     * 状态
     */
    private void setStatus() {
        binding.choooseStatus.setOnClickListener(v -> {

            if (!NetHelper.IsHaveInternet(getActivity())) {
                toast("未连接到网络.");
                return;
            }

            Collection.containerStatus((BaseActivity) getActivity(), bean -> {

                ArrayList<String> statuses = new ArrayList<>();
                StatusBean.DataBean data = new StatusBean.DataBean();
                data.setValue("全部");
                data.setKey("");
                bean.getData().add(0, data);
                for (StatusBean.DataBean status : bean.getData()) {
                    statuses.add(status.getValue());
                }

                choooseStatusDialog = new ChooseStatusDialog.Builder(context)
                        .setCitys(statuses)
                        .setChooseListener((dialogInterface, i) -> {

                            String id = "";
                            for (StatusBean.DataBean status : bean.getData()) {
                                if (status.getValue().equals(statuses.get(i))) {
                                    id = status.getKey();
                                    break;
                                }
                            }
                            choooseStatusId = id;
                            binding.tvStatus.setText(i != 0 ? statuses.get(i) : "");
                            dialogInterface.dismiss();
                            rotateDown.setInterpolator(new LinearInterpolator());
                            rotateDown.setFillAfter(true);
                            binding.typeStatus.startAnimation(rotateDown);
                            requestInfo();
                        })
                        .setDismissListener((dialogInterface, i) -> {
                            dialogInterface.dismiss();
//                            binding.typeDirection.setImageResource(R.drawable.down);
                            rotateDown.setInterpolator(new LinearInterpolator());
                            rotateDown.setFillAfter(true);
                            binding.typeStatus.startAnimation(rotateDown);
                        })
                        .create();
                choooseStatusDialog.show();
                rotate.setInterpolator(new LinearInterpolator());
                rotate.setFillAfter(true);
                binding.typeStatus.startAnimation(rotate);


            });
        });
    }


    private void requestBuy() {
        String content = binding.topbar.input.getText().toString();
        Collection.buyList(this, cityId, typeId, choooseStatusId, content, bean -> {
            col.clear();
            col.addAll(bean.getData());
            adapter.notifyDataSetChanged();
            MarketFragment.this.hideLoading();
        }, throwable -> {
//            toast("没有更多信息");
            String userflag = SpUtil.getString(SpUtil.USERFLAG);
            if (!TextUtils.isEmpty(userflag) && userflag.equals("0")) {
                toast("您当前为买家身份，看不到交易市场其他买家的求购信息");
            } else {
                toast("没有更多信息");
            }
            col.clear();
            adapter.notifyDataSetChanged();
            hideLoading();
        });
    }

    private void requestSale() {
        String content = binding.topbar.input.getText().toString();
        Collection.saleList(this, cityId, typeId, choooseStatusId, sort, content, new Consumer<SaleListBean>() {
            @Override
            public void accept(SaleListBean bean) throws Exception {
                col.clear();
                col.addAll(bean.getData());
                adapter.notifyDataSetChanged();
                MarketFragment.this.hideLoading();
            }
        }, throwable -> {
            col.clear();
            adapter.notifyDataSetChanged();
            hideLoading();
        });
    }

    private void requestInfo() {
        if (tabs.get(0).equals("0")) {
            requestBuy();
        } else {
            requestSale();
        }
    }

    private void initSendInfo() {
        binding.floatModel.setOnClickListener(view -> {

            if (null == getActivity()) {
                return;
            }

            if (!NetHelper.IsHaveInternet(getActivity())) {
                toast("未连接到网络.");
                return;
            }

            if (Block.checkLogin((MainActivity) context)) {
                Intent i;
                if (leftTabSellected) {
                    i = new Intent(context, SendBuyInfoActivity.class);
                    startAc(i);
                } else {
                    if (Block.isBuyer()) {
                        dialog("您是买家身份，无法发布卖箱信息\n如果想卖箱，请重新注册卖家身份账号");
                    } else {
                        i = new Intent(context, SendSaleInfoActivity.class);
                        startAc(i);
                    }
                }

            }
        });
    }

//	private void initChooseMoney() {
//		binding.choooseMoney.setOnClickListener(view -> {
//			if (isMoneyUp) {
//				isMoneyUp = false;
//				binding.moneyDirection.setImageResource(R.drawable.down);
//			} else {
//				isMoneyUp = true;
//				binding.moneyDirection.setImageResource(R.drawable.up);
//			}
//		});
//	}

    /**
     * 箱型
     */
    private void initChooseType() {
        binding.choooseType.setOnClickListener(view -> {

            Collection.containerType(this, bean -> {
                ArrayList<String> types = new ArrayList<>();
                TypeBean.DataBean data = new TypeBean.DataBean();
                data.setValue("全部");
                data.setKey("");
                bean.getData().add(0, data);
                for (TypeBean.DataBean type : bean.getData()) {
                    types.add(type.getValue());
                }

                typeDialog = new ChooseTypeDialog.Builder(context)
                        .setCitys(types)
                        .setChooseListener((dialogInterface, i) -> {

                            String id = "";
                            for (TypeBean.DataBean type : bean.getData()) {
                                if (type.getValue().equals(types.get(i))) {
                                    id = type.getKey();
                                    break;
                                }
                            }
                            typeId = id;
                            binding.type.setText(i != 0 ? types.get(i) : "");
                            dialogInterface.dismiss();
//                            binding.typeDirection.setImageResource(R.drawable.down);
                            rotateDown.setInterpolator(new LinearInterpolator());
                            rotateDown.setFillAfter(true);
                            binding.typeDirection.startAnimation(rotateDown);
                            requestInfo();
                        })
                        .setDismissListener((dialogInterface, i) -> {
                            dialogInterface.dismiss();
//                            binding.typeDirection.setImageResource(R.drawable.down);
                            rotateDown.setInterpolator(new LinearInterpolator());
                            rotateDown.setFillAfter(true);
                            binding.typeDirection.startAnimation(rotateDown);
                        })
                        .create();
                typeDialog.show();
//                binding.typeDirection.setImageResource(R.drawable.up);
                rotate.setInterpolator(new LinearInterpolator());
                rotate.setFillAfter(true);
                binding.typeDirection.startAnimation(rotate);
            });

        });
    }

    /**
     * 获取国家获取下属城市
     */
    private void initChooseCity() {
        binding.choooseCity.setOnClickListener(view -> {

            binding.cityDirection.clearAnimation();

            Collection.getCityList(this, SpUtil.getString(SpUtil.COUNTRYID), bean -> {
                ArrayList<String> citys = new ArrayList<>();
                GetCityListBean.DataBean data = new GetCityListBean.DataBean();
                data.setCityName("全部");
                data.setId("");
                bean.getData().add(0, data);
                for (GetCityListBean.DataBean city : bean.getData()) {
                    citys.add(city.getCityName());
                }
                cityDialog = new ChooseCityDialog.Builder(context)
                        .setCitys(citys)
                        .setChooseListener((dialogInterface, i) -> {
                            String id = "";
                            for (GetCityListBean.DataBean city : bean.getData()) {
                                if (city.getCityName().equals(citys.get(i))) {
                                    id = city.getId();
                                    break;
                                }
                            }
                            cityId = id;
                            binding.city.setText(i != 0 ? citys.get(i) : "");
                            dialogInterface.dismiss();
//                            binding.cityDirection.setImageResource(R.drawable.down);
                            rotateDown.setInterpolator(new LinearInterpolator());
                            rotateDown.setFillAfter(true);
                            binding.cityDirection.startAnimation(rotateDown);
                            requestInfo();
                        })
                        .setDismissListener((dialogInterface, i) -> {
                            dialogInterface.dismiss();
//                            binding.cityDirection.setImageResource(R.drawable.down);
                            rotateDown.setInterpolator(new LinearInterpolator());
                            rotateDown.setFillAfter(true);
                            binding.cityDirection.startAnimation(rotateDown);
                        })
                        .create();
                cityDialog.show();
            });

//            binding.cityDirection.setImageResource(R.drawable.up);
            rotate.setInterpolator(new LinearInterpolator());
            rotate.setFillAfter(true);
            binding.cityDirection.startAnimation(rotate);

        });
    }


    private void initTab() {
        binding.tvOne.setTextColor(getResources().getColor(R.color.white));
        binding.tabBuy.setBackground(getResources().getDrawable(R.drawable.tab_left_checked));
        binding.tvTwo.setTextColor(getResources().getColor(R.color.colorPrimary));
        binding.tabSale.setBackground(getResources().getDrawable(R.drawable.tab_right_uncheck));

        binding.tabBuy.setOnClickListener(view -> {
            if (!leftTabSellected) {
                setTab();
            }
        });
        binding.tabSale.setOnClickListener(view -> {
            if (leftTabSellected) {
                setTab();
            }
        });
    }

    private void setTab() {
        if (leftTabSellected) {
            leftTabSellected = false;
            binding.tvOne.setTextColor(getResources().getColor(R.color.colorPrimary));
            binding.tabBuy.setBackground(getResources().getDrawable(R.drawable.tab_left_uncheck));
            binding.tvTwo.setTextColor(getResources().getColor(R.color.white));
            binding.tabSale.setBackground(getResources().getDrawable(R.drawable.tab_right_checked));

            binding.floatButtonTip.setText(R.string.market_floating_tip3);
            binding.choooseMoney.setVisibility(View.VISIBLE);
            binding.moneyDirection.setImageResource(R.drawable.down);
            cityId = "";
            typeId = "";
            sort = "";
            binding.city.setText("");
            binding.type.setText("");
            tabs.set(0, "1");
            requestInfo();

            binding.floatModel.setVisibility(View.GONE);
        } else {
            leftTabSellected = true;
            binding.tvOne.setTextColor(getResources().getColor(R.color.white));
            binding.tabBuy.setBackground(getResources().getDrawable(R.drawable.tab_left_checked));
            binding.tvTwo.setTextColor(getResources().getColor(R.color.colorPrimary));
            binding.tabSale.setBackground(getResources().getDrawable(R.drawable.tab_right_uncheck));

            binding.floatButtonTip.setText(R.string.market_floating_tip2);
            binding.choooseMoney.setVisibility(View.INVISIBLE);
            binding.moneyDirection.setImageResource(R.drawable.down);
            cityId = "";
            typeId = "";
            sort = "";
            binding.city.setText("");
            binding.type.setText("");
            tabs.set(0, "0");
            requestInfo();

            binding.floatModel.setVisibility(View.VISIBLE);
        }
    }

    private void setList() {
        tabs.add("0");
        adapter = new MarketAdapter(context, col, tabs);
        adapter.setItemOnClick(itemOnClick);
        binding.list.setLayoutManager(new LinearLayoutManager(context));
        binding.list.setAdapter(adapter);
        binding.refresh.setOnRefreshListener(() -> {
            requestInfo();
        });
    }


    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(true);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.search.setOnClickListener(v -> {

            if (TextUtils.isEmpty(binding.topbar.input.getText().toString().trim())) {
                toast("请输入您要搜索的内容~");
                return;
            }

            cityId = "";
            typeId = "";
            sort = "";
            binding.city.setText("");
            binding.type.setText("");
            requestInfo();
        });
    }

    private MarketAdapter.ItemOnClick itemOnClick = new MarketAdapter.ItemOnClick() {
        @Override
        public void setOnClickListener(InfoBean bean, String vaule) {

            if (NetHelper.IsHaveInternet(getActivity())) {
                startIntentActivity(bean, vaule);
            } else {
                toast("未连接到网络.");
            }


        }
    };

    private void startIntentActivity(InfoBean bean, String vaule) {
        if (Block.checkLoginFragment(MarketFragment.this)) {
            if (null == bean) {
                return;
            }
            Intent intent;
            if (vaule.equals("0")) {
                intent = new Intent(context, PurchaseAActivity.class);
                intent.putExtra("containerId", bean.getId());
            } else {
                if (bean.getTradeType().equals("0")) {//出售
                    intent = new Intent(context, SaleAActivity.class);//立即购买
                } else {//竞标
                    intent = new Intent(context, SaleBActivity.class);//出价
                }
            }
            intent.putExtra("content", bean);
            intent.putExtra("titleName", bean.getTitle());
            intent.putExtra("remark", bean.getRemark());
            ((BaseActivity) context).startAc(intent);
        }
    }


}
