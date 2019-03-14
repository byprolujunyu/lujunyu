package com.bm.container.module.base;

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
import android.widget.AdapterView;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.NetHelper;
import com.bm.container.Tools.SpUtil;
import com.bm.container.databinding.FragmentMainBinding;
import com.bm.container.entity.UserMeesageEntity;
import com.bm.container.http.BaseBean;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.BaseFragment;
import com.bm.container.module.base.adapter.MainBuyAdapter;
import com.bm.container.module.base.adapter.MainBuyListAdapter;
import com.bm.container.module.base.adapter.MainSaleAdapter;
import com.bm.container.module.base.bean.MainBannerBean;
import com.bm.container.module.market.PurchaseAActivity;
import com.bm.container.module.market.SaleAActivity;
import com.bm.container.module.market.SaleBActivity;
import com.bm.container.module.market.SendSaleInfoActivity;
import com.bm.container.module.market.bean.InfoBean;
import com.bm.container.module.market.bean.SaleListBean;
import com.bm.container.module.personal.MessageActivity;
import com.bm.container.module.personal.MyOrderActivity;
import com.bm.container.module.personal.bean.UserInfoBean;
import com.bumptech.glide.Glide;
import com.flyco.tablayout.CommonTabLayout;

import java.util.ArrayList;

import io.reactivex.functions.Consumer;


/**
 * 碎片页 P4首页
 */

public class MainFragment extends BaseFragment {
    private FragmentMainBinding binding;
    private Context context;
    //    private MainBuyAdapter adapterBuy;
    private MainBuyListAdapter adapterBuy;
    private MainSaleAdapter adapterSale;
    private ArrayList<Integer> banners = new ArrayList<>();
    private CommonTabLayout layout;
    private ArrayList<InfoBean> colBuy = new ArrayList<>();
    private ArrayList<InfoBean> colSale = new ArrayList<>();

    public static MainFragment getInstance(CommonTabLayout layout) {
        MainFragment fragment = new MainFragment();
        fragment.layout = layout;
        return fragment;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            if (colBuy.size() == 0) {
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

//        //获取用户信息
//        Collection.userMessage(this, new Consumer<BaseBean>() {
//            @Override
//            public void accept(BaseBean userInfoBean) throws Exception {
//
//                if (!TextUtils.isEmpty(userInfoBean.getData().getAppUserType())) {
//                    if (userInfoBean.getData().getAppUserType().equals("0")) {
//                        binding.topbar.viewOvle.setVisibility(View.GONE);
//                    } else if (userInfoBean.getData().getAppUserType().equals("1")) {
//                        binding.topbar.viewOvle.setVisibility(View.VISIBLE);
//                    }
//                }
//
//                if (!TextUtils.isEmpty(userInfoBean.getData().getIsSysRed())) {
//                    if (userInfoBean.getData().getIsSysRed().equals("0")) {
//                        binding.topbar.rightPoint.setVisibility(View.GONE);
//                    } else if (userInfoBean.getData().getIsSysRed().equals("1")) {
//                        binding.topbar.rightPoint.setVisibility(View.VISIBLE);
//                    }
//                }
//
//            }
//        });
        requsetMessageDot();
    }


    private void requsetMessageDot() {


        //获取用户信息
        Collection.userMessage((BaseActivity) getActivity(), new Consumer<UserMeesageEntity>() {
            @Override
            public void accept(UserMeesageEntity meesageEntity) throws Exception {

                if (null != meesageEntity && null != meesageEntity.getData()) {

                    UserMeesageEntity.DataBean itemMessage = meesageEntity.getData();
                    if (!TextUtils.isEmpty(itemMessage.getOrderBuyCount()) && Integer.valueOf(itemMessage.getOrderBuyCount()) > 0) {
                        binding.topbar.viewOvle.setVisibility(View.VISIBLE);
                    } else {
                        binding.topbar.viewOvle.setVisibility(View.GONE);
                    }

                }

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                binding.topbar.viewOvle.setVisibility(View.GONE);
            }
        });


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        context = getActivity();

        initTopbar();
        setLoading();
        Block.autoHeight(binding.banner, (BaseActivity) context);
        initList();
        setFocus();
        setIWantToBuy();
        setIWantToSale();

        View view = binding.getRoot();
        view.setClickable(true);
        return binding.getRoot();
    }

    private void setIWantToSale() {
        binding.iWantToSale.setOnClickListener(view -> {

            if (!NetHelper.IsHaveInternet(getActivity())) {
                toast("未连接到网络.");
                return;
            }

            if (Block.checkLogin((MainActivity) context)) {
                if (Block.isBuyer()) {
                    dialog("您是买家身份，无法发布卖箱信息\n");
                } else {
//                    layout.setCurrentTab(1);
                    Intent i = new Intent(context, SendSaleInfoActivity.class);
                    startAc(i);
                }
            }
        });
    }

    private void setIWantToBuy() {
        binding.iWantToBuy.setOnClickListener(view -> {
            SpUtil.setBoolean(SpUtil.JUMPSALELIST, true);
            layout.setCurrentTab(1);
        });
    }

    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(true);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void initList() {
//        adapterBuy = new MainBuyAdapter(context, colBuy);
//        adapterBuy.setOnClick(onClickItem);
//        binding.listBuy.setLayoutManager(new LinearLayoutManager(context) {
//            @Override
//            public boolean canScrollVertically() {
//                return false;
//            }
//        });
//        binding.listBuy.setAdapter(adapterBuy);

        binding.listBuy.setFocusable(false);
        binding.listSale.setFocusable(false);

        adapterBuy = new MainBuyListAdapter(colBuy);
        binding.listBuy.setAdapter(adapterBuy);

        binding.listBuy.setOnItemClickListener((parent, view, position, id) -> {

            if (!NetHelper.IsHaveInternet(getActivity())) {
                toast("未连接到网络.");
                return;
            }

            InfoBean bean = (InfoBean) parent.getItemAtPosition(position);
            if (Block.checkLoginFragment(MainFragment.this) && null != bean) {
                if (null == bean) {
                    return;
                }
                if (SpUtil.getString(SpUtil.USERFLAG).equals("0") && (!bean.getCreateUser().equals(SpUtil.getString(SpUtil.ID)))) {
//                    ((BaseActivity) context).toast("您是买家身份\n无法查看其他买家发布的买箱信息\n");
                    dialog("您是买家身份\n无法查看其他买家发布的买箱信息\n如想查看具体信息，请使用卖家账号登录。", true);
                } else {
                    Intent intent = new Intent(context, PurchaseAActivity.class);
                    intent.putExtra("containerId", bean.getId());
                    intent.putExtra("content", bean);
                    ((MainActivity) context).startAc(intent);
                }
            }

        });

        adapterSale = new MainSaleAdapter(context, colSale);
        adapterSale.setOnItemClick(sellBoxItemOnClick);
        binding.listSale.setLayoutManager(new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        binding.listSale.setAdapter(adapterSale);

        binding.refresh.setOnRefreshListener(() -> {
            requestInfo();
        });
    }

    private void initTopbar() {
        binding.topbar.leftModel.setVisibility(View.VISIBLE);
        binding.topbar.rightModel.setVisibility(View.VISIBLE);
        binding.topbar.title.setText(R.string.main_title);
        binding.topbar.title.setVisibility(View.GONE);
        binding.topbar.ivTitle.setVisibility(View.VISIBLE);
        binding.topbar.leftModel.setOnClickListener(v -> {

            if (!NetHelper.IsHaveInternet(getActivity())) {
                toast("未连接到网络.");
                return;
            }

            if (Block.checkLogin((MainActivity) context)) {
                Intent i = new Intent(context, MyOrderActivity.class);
                startAc(i);
            }
        });
        binding.topbar.rightModel.setOnClickListener(v -> {

            if (!NetHelper.IsHaveInternet(getActivity())) {
                toast("未连接到网络.");
                return;
            }

            if (Block.checkLogin((MainActivity) context)) {
                Intent i = new Intent(context, MessageActivity.class);
                startAc(i);

            }
        });
    }

    private void setFocus() {
        //取消焦点
        binding.banner.setFocusable(true);
        binding.banner.setFocusableInTouchMode(true);
        binding.banner.requestFocus();
    }

    public class BannerHolder implements Holder<MainBannerBean.DataBean> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, MainBannerBean.DataBean data) {
            Glide.with(context).load(Block.resolvePic(data.getImageUrl())).placeholder(R.drawable.banner1).dontAnimate().into(imageView);

        }
    }

    private void requestInfo() {
        Collection.mainBanner(this, bean -> {

            if (null != bean.getData() && bean.getData().size() > 1) {
                binding.ivIamgetop.setVisibility(View.GONE);
                if (!binding.banner.isTurning()) {
                    binding.banner.startTurning(4000);
                }

                binding.banner
                        .setPageIndicator(new int[]{R.drawable.circle_grey, R.drawable.circle_blue})
                        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                        .setPages(() -> new BannerHolder(), bean.getData());

            } else if (null != bean.getData() && bean.getData().size() == 1) {

                binding.ivIamgetop.setVisibility(View.VISIBLE);
                binding.banner.setVisibility(View.GONE);
                Glide.with(context).load(Block.resolvePic(bean.getData().get(0).getImageUrl())).placeholder(R.drawable.banner0).dontAnimate().into(binding.ivIamgetop);

            }


        });
        Collection.mainBuyList(this, bean -> {
            colBuy.clear();
            colBuy.addAll(bean.getData());
            adapterBuy.notifyDataSetChanged();
        });
        Collection.mainSaleList(this, (SaleListBean bean) -> {
            colSale.clear();
            colSale.addAll(bean.getData());
            adapterSale.notifyDataSetChanged();
        });
    }

    /**
     * 买箱信息列表点击Itme 监听回掉
     */
    private MainBuyAdapter.OnClickItem onClickItem = new MainBuyAdapter.OnClickItem() {

        @Override
        public void setOnClickListener(InfoBean bean) {

            if (!NetHelper.IsHaveInternet(getActivity())) {
                toast("未连接到网络.");
                return;
            }

            if (Block.checkLoginFragment(MainFragment.this)) {
                if (null == bean) {
                    return;
                }
                if (SpUtil.getString(SpUtil.USERFLAG).equals("0") && (!bean.getCreateUser().equals(SpUtil.getString(SpUtil.ID)))) {
//                    ((BaseActivity) context).toast("您是买家身份\n无法查看其他买家发布的买箱信息\n");
                    dialog("您是买家身份\n无法查看其他买家发布的买箱信息\n如想查看具体信息，请使用卖家账号登录。", true);
                } else {
                    Intent intent = new Intent(context, PurchaseAActivity.class);
                    intent.putExtra("containerId", bean.getId());
                    intent.putExtra("content", bean);
                    ((MainActivity) context).startAc(intent);
                }
            }
        }
    };


    /**
     * 卖箱信息列表Item点击事件监听 回调
     */
    private MainSaleAdapter.SellBoxItemOnClick sellBoxItemOnClick = new MainSaleAdapter.SellBoxItemOnClick() {
        @Override
        public void setOnClickListener(InfoBean bean) {

            if (!NetHelper.IsHaveInternet(getActivity())) {
                toast("未连接到网络.");
                return;
            }

            if (Block.checkLoginFragment(MainFragment.this)) {
                if (null == bean) {
                    return;
                }
                Intent intent;
                if (bean.getTradeType().equals("0")) {//出售
                    intent = new Intent(context, SaleAActivity.class);
                } else {//竞标
                    intent = new Intent(context, SaleBActivity.class);
                }

                System.out.println("base---getAppUserType----->" + bean.getAppUserType());
                System.out.println("base---age----->" + bean.getAge());

                intent.putExtra("content", bean);
                intent.putExtra("titleName", bean.getTitle());
                intent.putExtra("remark", bean.getRemark());
                ((MainActivity) context).startAc(intent);
            }
        }
    };

}
