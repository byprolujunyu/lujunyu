package com.bm.container.module.market;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.DateUtils;
import com.bm.container.Tools.NumberUtils;
import com.bm.container.Tools.SpUtil;
import com.bm.container.Tools.Verify;
import com.bm.container.databinding.ActivitySaleBBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.base.FangDaImgActivity;
import com.bm.container.module.market.adapter.HistoryBuyAdapter;
import com.bm.container.module.market.bean.InfoBean;
import com.bm.container.module.market.bean.OfferBuyBean;
import com.bm.container.module.market.bean.SaleContainerBean;
import com.bm.container.view.AlertDialog;
import com.bm.container.view.CommodityDetailsAlertDialog;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * P5_3_2 商品详情界面(出售)正在进行 (未含价格[买家出价界面])
 * 以上界面定义为a版，不用看了
 * <p>
 * 根据接口和新的需求
 * 现合并为卖家自己进入看到的信息和别人进入看到的信息
 */
public class SaleBActivity extends BaseActivity {
    private ActivitySaleBBinding binding;
    private Context context;
    private HistoryBuyAdapter adapter;
    //    private InfoBean content;
    private ArrayList<OfferBuyBean> col = new ArrayList<>();
    private String imyself = "1";
    private ArrayList<String> choosed = new ArrayList<>();
    private String containerId;//选中出价记录列表里当前条目的containerId
    private String paidUser;//传选一条里面的createUser
    private String saleNo;//	传选中一条的id
    private boolean isCheckedVaule = true;//是否是个人
    private CommodityDetailsAlertDialog alertDialog;
    private boolean isShowHint;//弹框是否要显示 发票信息内容
    private OfferBuyBean beanItem;//选中单个记录
    private String orderId;
    private SaleContainerBean.DataBean itenBean;
    private String isSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //收起键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sale_b);
        context = this;

        setLoading();
        setTopbar();

        if (null != getIntent()) {
            InfoBean content = getIntent().getExtras().getParcelable("content");
            if (null == content) {
                orderId = getIntent().getStringExtra("containerId");
            } else {
                orderId = content.getId();
            }
            isSuccess = getIntent().getStringExtra("isSuccess");
        }

        requesetBrowser(orderId);

    }

    /**
     * 请求浏览量（围观人数）
     */
    private void requesetBrowser(String orderId) {
        if (orderId.isEmpty()) {
            return;
        }
        Collection.requesetSellBox(this, orderId, new Consumer<SaleContainerBean>() {
            @Override
            public void accept(SaleContainerBean buyContainerBean) throws Exception {
                if (null != buyContainerBean && null != buyContainerBean.getData()) {
                    itenBean = buyContainerBean.getData();
                    setList();
                    setContent();
                    setBuy();
                }
            }
        }, throwable -> {
            toast(throwable.getMessage());
        });
    }


    /**
     * 出价列表
     */
    private void getOfferList() {
        if (imyself.equals("1")) {
            Collection.getAllOfferBuyList(this, itenBean.getId(), offerBean -> {
                col.clear();
                col.addAll(offerBean.getData());
                adapter.notifyDataSetChanged();
            });
        } else {
            Collection.getOfferBuyList(this, itenBean.getId(), offerBean -> {
                col.clear();
                col.addAll(offerBean.getData());
                adapter.notifyDataSetChanged();
            });
        }

    }


    private void setList() {

        binding.historyList.setFocusable(false);

        choosed.add("-1");
        adapter = new HistoryBuyAdapter(context, col, choosed);
        binding.historyList.setAdapter(adapter);
        binding.historyList.setOnItemClickListener((parent, view, position, id) -> {
            if (imyself.equals("1")) {
                choosed.clear();
                choosed.add("" + position);
                adapter.notifyDataSetChanged();
                beanItem = col.get(position);

                if (!TextUtils.isEmpty(beanItem.getBillType())) {
                    if (beanItem.getBillType().equals("0")) {
                        isCheckedVaule = true;
                    } else {
                        isCheckedVaule = false;
                    }
                }

//                binding.invoiceHead.setText(bean.getBillCheque());
//                binding.invoiceContent.setText(bean.getBillContent());
//				binding.invoicePhone.setText(bean.getBillTelephone());

                if (TextUtils.isEmpty(beanItem.getBillTypeName())) {
                    isShowHint = true;
                } else {
                    isShowHint = false;
                }

                containerId = beanItem.getContainerId();
                paidUser = beanItem.getCreateUser();
                saleNo = beanItem.getId();
            }
        });
    }

    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(true);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.purchase_title2);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }

    /**
     * 内容加载
     */
    private void setContent() {

        binding.llStatus.setVisibility(View.GONE);
        if (!TextUtils.isEmpty(isSuccess)) {
            binding.llStatus.setVisibility(View.VISIBLE);
            if (isSuccess.equals("0")) {
                binding.tvStatus.setText("进行中");
            } else if (isSuccess.equals("1")) {
                binding.tvStatus.setText("购买成功");
            } else if (isSuccess.equals("2")) {
                binding.tvStatus.setText("购买失败");
            }
        }

        if (itenBean.getCreateUser().equals(SpUtil.getString(SpUtil.ID))) {//自己
            imyself = "1";
        } else {//他人
            imyself = "0";
        }

        if (imyself.equals("1")) {
            binding.salerModel.setVisibility(View.GONE);
            binding.sure.setText("确认订单");
            binding.checkInvoice.setVisibility(View.GONE);
            binding.personal.setVisibility(View.GONE);
            binding.personalCheck.setVisibility(View.GONE);
            binding.company.setVisibility(View.GONE);
            binding.companyCheck.setVisibility(View.GONE);
        } else {
            binding.salerModel.setVisibility(View.VISIBLE);
            binding.sure.setText("我要出价");
        }
        if (!itenBean.getImageUrl().isEmpty()) {

            ArrayList<String> banner = new ArrayList<>(Arrays.asList(itenBean.getImageUrl().split(",")));

            if (null != banner && banner.size() > 1) {
                if (!binding.banner.isTurning()) {
                    binding.banner.startTurning(4000);
                }
            }

            if (null == banner || banner.size() <= 0) {
                binding.tvIamge.setVisibility(View.GONE);
            }

            binding.banner
                    .setPageIndicator(new int[]{R.drawable.circle_grey, R.drawable.circle_blue})
                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                    .setPages(() -> new BannerHolder(), banner);

            binding.banner.setOnItemClickListener(position -> {
                String[] images = itenBean.getImageUrl().split(",");
                Intent intent = new Intent(context, FangDaImgActivity.class);
                intent.putExtra("pic_position", position);
                Bundle b = new Bundle();
                b.putStringArray("img", images);
                intent.putExtras(b);
                context.startActivity(intent);
            });

        } else {
            binding.tvIamge.setVisibility(View.GONE);
        }


        binding.llPriceChoosed.setVisibility(View.GONE);
        if (itenBean.getContainerStatus().equals("1")) {//进行中  投标中(买箱)
            binding.llIsGoing.setBackground(context.getResources().getDrawable(R.drawable.label_dr_two));
            binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.label_dr));
        } else if (itenBean.getContainerStatus().equals("2")) {//投标中（卖箱）
            binding.llIsGoing.setBackground(context.getResources().getDrawable(R.drawable.orange_light));
            binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.orange));
        } else if (itenBean.getContainerStatus().equals("3")) {//销售中
            binding.llIsGoing.setBackground(context.getResources().getDrawable(R.drawable.red_two));
            binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.red));
            binding.llPriceChoosed.setVisibility(View.VISIBLE);
        } else if (itenBean.getContainerStatus().equals("4")) {//未付款中
            binding.llIsGoing.setBackground(context.getResources().getDrawable(R.drawable.red_two));
            binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.red));
            binding.llPriceChoosed.setVisibility(View.VISIBLE);
        } else if (itenBean.getContainerStatus().equals("5")) {//已完成
            binding.llIsGoing.setBackground(null);
            binding.restTime.setVisibility(View.GONE);
            binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.red));
        } else if (itenBean.getContainerStatus().equals("6")) {//已结束
            binding.llIsGoing.setVisibility(View.GONE);
            binding.restTime.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(itenBean.getAppUserType())) {
            binding.ivType.setVisibility(View.VISIBLE);
            if (itenBean.getAppUserType().equals("0")) {
                //个人
                binding.ivType.setImageResource(R.drawable.user_work_state_lv3);
            } else if (itenBean.getAppUserType().equals("1")) {
                //公司
                binding.ivType.setImageResource(R.drawable.user_work_state_lv4);
            }
        } else {
            binding.ivType.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(itenBean.getAge())) {
            binding.llAge.setVisibility(View.VISIBLE);
            binding.tvAge.setText(itenBean.getAge() + "年");
        } else {
            binding.llAge.setVisibility(View.GONE);
        }

        binding.tvTitleName.setText(itenBean.getTitle());
        binding.tvRemark.setText(itenBean.getRemark());
        binding.isGoing.setText(itenBean.getContainerStatusName());
        binding.location.setText(itenBean.getCountryName() + "." + itenBean.getCityName());
        binding.people.setText(itenBean.getScanCount());
        binding.type.setText(itenBean.getContainerTypeName());
        binding.status.setText(itenBean.getStatusTypeName());
        binding.num.setText(itenBean.getCount() + "个");
        if (!TextUtils.isEmpty(itenBean.getStartPrice())) {
            binding.tvStartPrice.setText(NumberUtils.formatDouble(Double.valueOf(itenBean.getStartPrice())) + "元");
            binding.llStartPrice.setVisibility(View.VISIBLE);
        } else {
            binding.llStartPrice.setVisibility(View.GONE);
        }


        getOfferList();

        if (!itenBean.getContainerStatus().equals("5") && !itenBean.getContainerStatus().equals("6")) {

            Observable
                    .interval(0, 1, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .compose(bindToLifecycle())
                    .subscribe(aLong -> {
//                    String countTime = Block.restTime(itenBean.getDeadLineTime());
//                    binding.restTime.setText(countTime);

                        String countTime;
                        //未付款中
                        if (itenBean.getContainerStatus().equals("4")) {
                            long time = DateUtils.getLongTime(itenBean.getCreateTime()) + 36 * 60 * 60 * 1000;//
                            String timestamp = DateUtils.getFormatTimeFromTimestamp(time, DateUtils.FORMAT_DATE_TIME_ALL);
                            countTime = Block.restTime(timestamp);
                        } else {
                            countTime = Block.restTime(itenBean.getDeadLineTime());
                        }
                        binding.restTime.setText(countTime);

                    }, throwable -> {

                    }, () -> {

                    }, disposable -> {
//                        String countTime = Block.restTime(itenBean.getDeadLineTime());

                        String countTime;

                        if (itenBean.getContainerStatus().equals("4")) {
                            long time = DateUtils.getLongTime(itenBean.getCreateTime()) + 36 * 60 * 60 * 1000;//
                            String timestamp = DateUtils.getFormatTimeFromTimestamp(time, DateUtils.FORMAT_DATE_TIME_ALL);
                            countTime = Block.restTime(timestamp);
                        } else {
                            countTime = Block.restTime(itenBean.getDeadLineTime());
                        }

                        if (countTime.isEmpty()) {
                            dialogFinish("交易记录已过期,请在列表中重新选择");
                            disposable.dispose();
                        } else {

                        }
                    });

        }


        if (isCheckedVaule) {
            binding.invoiceBasicInformation.setVisibility(View.VISIBLE);
            binding.companyInfo.setVisibility(View.GONE);
        } else {
            binding.invoiceBasicInformation.setVisibility(View.VISIBLE);
            binding.companyInfo.setVisibility(View.VISIBLE);
        }
        binding.bankIdText.setPattern(new int[]{4, 4, 4, 4, 3});
        binding.bankIdText.setSeparator(" ");
        binding.bankIdText.setCustomizeMarkerEnable(false);

        binding.specialChoosed.setText(itenBean.getIsSpecialPrice().equals("1") ? "有特殊需求" : "无特殊需求");
        binding.specialPriceChoosed.setText(itenBean.getSpecialPrice().isEmpty() ? "无" : NumberUtils.formatDouble(Double.valueOf(itenBean.getSpecialPrice())) + "元");
        binding.invoiceChoosed.setText(itenBean.getIsSupportBill().equals("1") ? "提供发票" : "不提供发票");

        if (itenBean.getIsSupportBill().equals("1")) {
            if (imyself.equals("1")) {
                binding.invoiceModel.setVisibility(View.GONE);
            } else {
                binding.invoiceModel.setVisibility(View.VISIBLE);
            }
            binding.checkInvoice.setEnabled(true);
            setInputEable(false);
            binding.checkInvoice.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    setInputEable(true);
                } else {
                    setInputEable(false);
                    binding.invoiceHead.setText("");
                    binding.invoiceContent.setText("");
                    binding.bankName.setText("");
                    binding.bankIdText.setText("");
                    binding.etAdd.setText("");
                    binding.invoicePhone.setText("");
                }
            });
        } else {
            binding.invoiceModel.setVisibility(View.GONE);
            binding.checkInvoice.setEnabled(false);
            setInputEable(false);
        }

        binding.refresh.setOnRefreshListener(() -> getOfferList());


    }

    /**
     * 是否可输入
     */
    private void setInputEable(boolean inputEnable) {

        binding.personalCheck.setEnabled(inputEnable);
        binding.companyCheck.setEnabled(inputEnable);
        binding.invoiceHead.setEnabled(inputEnable);
        binding.invoiceContent.setEnabled(inputEnable);
        binding.bankName.setEnabled(inputEnable);
        binding.bankIdText.setEnabled(inputEnable);
        binding.etAdd.setEnabled(inputEnable);
        binding.invoicePhone.setEnabled(inputEnable);

        binding.personalCheck.setBackgroundResource(inputEnable ? R.color.white : R.drawable.unchecked_square);
        binding.companyCheck.setBackgroundResource(inputEnable ? R.color.white : R.drawable.unchecked_square);
        binding.invoiceBasicInformation.setBackgroundResource(inputEnable ? R.drawable.round_corner_grey_border : R.drawable.round_corner_grey_border_two);
        binding.llinvoiceContent.setBackgroundResource(inputEnable ? R.drawable.round_corner_grey_border : R.drawable.round_corner_grey_border_two);
        binding.llbankName.setBackgroundResource(inputEnable ? R.drawable.round_corner_grey_border : R.drawable.round_corner_grey_border_two);
        binding.llbankIdText.setBackgroundResource(inputEnable ? R.drawable.round_corner_grey_border : R.drawable.round_corner_grey_border_two);
        binding.llEtAdd.setBackgroundResource(inputEnable ? R.drawable.round_corner_grey_border : R.drawable.round_corner_grey_border_two);
        binding.llInvoicePhone.setBackgroundResource(inputEnable ? R.drawable.round_corner_grey_border : R.drawable.round_corner_grey_border_two);


        binding.personalCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                isCheckedVaule = isChecked;
                binding.invoiceBasicInformation.setVisibility(View.VISIBLE);
                binding.companyInfo.setVisibility(View.GONE);
            } else {
                binding.invoiceBasicInformation.setVisibility(View.VISIBLE);
                binding.companyInfo.setVisibility(View.VISIBLE);
            }
        });

        binding.companyCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                isCheckedVaule = false;
                binding.invoiceBasicInformation.setVisibility(View.VISIBLE);
                binding.companyInfo.setVisibility(View.VISIBLE);
            } else {
                binding.invoiceBasicInformation.setVisibility(View.VISIBLE);
                binding.companyInfo.setVisibility(View.GONE);
            }
        });

    }

    /**
     * 购买行为
     */
    private void setBuy() {
        binding.sure.setOnClickListener(v -> {

            if (imyself.equals("1")) {

                if (choosed.get(0).equals("-1")) {

                    dialog("请先选择买家出价");

                } else {

                    if (itenBean.getContainerStatus().equals("4") || itenBean.getContainerStatus().equals("5")) {
                        //未付款中
                        toast("等待买家付款中，请勿重新选择。如超时未付款，您将可重新选择价格。");
                        return;
                    }


                    if (!TextUtils.isEmpty(itenBean.getIsSupportBill()) && itenBean.getIsSupportBill().equals("1")) {
                        //需要提供发票
                        alertDialog = new CommodityDetailsAlertDialog.Builder(SaleBActivity.this)
                                .setInitView(beanItem)
                                .setIsShowHint(isShowHint)
                                .setIsShowView(!isCheckedVaule)
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        requestGenerateOrder(containerId, paidUser, saleNo);
                                    }
                                }).create();

                        if (!alertDialog.isShowing()) {
                            alertDialog.show();
                        }

                    } else {
                        //不需要提供发票
                        requestGenerateOrder(containerId, paidUser, saleNo);
                    }
//                    requestGenerateOrder(containerId, paidUser, saleNo);
                }

            } else {
                //我要出价
//                String type = binding.personalCheck.isChecked() ? "0" : "1";
                String type = "";
                if (binding.checkInvoice.isChecked()) {
                    if (binding.personalCheck.isChecked()) {
                        type = "0";
                    } else if (binding.companyCheck.isChecked()) {
                        type = "1";
                    } else {
                        toast("请勾选个人或单位");
                        return;
                    }
                }

                String head = binding.invoiceHead.getText().toString();
                String content = binding.invoiceContent.getText().toString();
                String bankName = binding.bankName.getText().toString();
                String bankIdText = binding.bankIdText.getText().toString();
                String etAdd = binding.etAdd.getText().toString();
                String invoicePhone = binding.invoicePhone.getText().toString();

                String price = binding.offerPrice.getText().toString();

                if (Verify.offerPrice(binding.checkInvoice, isCheckedVaule, head, bankName, bankIdText, etAdd, invoicePhone, content, price)) {

                    if (!TextUtils.isEmpty(this.itenBean.getStartPrice())) {
                        if (Double.valueOf(price) <= Double.valueOf(this.itenBean.getStartPrice())) {
                            toast("出价必须大于投标底价" + this.itenBean.getStartPrice() + "元");
                            return;
                        }
                    }

                    String finalType = type;
                    dialog("注：竞标方仅可对出售商品进行1次含税出价，如有特殊费用，请累计。请诚信出价,并对自己的出价负责", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();

                            if (binding.checkInvoice.isChecked()) {

                                if (finalType.equals("0")) {//个人
                                    requestBid(finalType, "", "", price, head, "", "", "");
                                } else if (finalType.equals("1")) {//单位
                                    requestBid(finalType, content, invoicePhone, price, head, bankName, bankIdText, etAdd);
                                }

                            } else {
                                //不需要发票信息

                                requestBid("", "", "", price, "", "", "", "");
                            }

                        }
                    });


//                    Collection.buyOrder(this, this.content.getId(), type, head, content, invoicePhone, price,
//                            head, bankName, bankIdText, etAdd, baseBean -> {
//                                getOfferList();
//                                dialog("成功出价！");
//                                SpUtil.setBoolean(SpUtil.SUCCESSFUL_BID_SUCCESS, true);
//                            });
                }
            }

        });
    }


    /**
     * 出价
     */
    private void requestBid(String type, String content, String invoicePhone, String price, String head, String bankName, String bankIdText, String etAdd) {


        Collection.buyOrder(this, this.itenBean.getId(), type, head, content, invoicePhone, price,
                head, bankName, bankIdText, etAdd, baseBean -> {
                    getOfferList();
//                    dialogFinish("成功出价！");
                    dialogFinish(baseBean.getMsg());
                    SpUtil.setBoolean(SpUtil.SUCCESSFUL_BID_SUCCESS, true);
                });


    }


    /**
     * 请求生成订单
     *
     * @param containerId 传选中一条的containerId
     * @param paidUser    传选一条里面的createUser
     * @param saleNo      传选中一条的id
     */
    private void requestGenerateOrder(String containerId, String paidUser, String saleNo) {

//		System.out.println("base------containerId--------->"+containerId);
//		System.out.println("base------paidUser--------->"+paidUser);
//		System.out.println("base------saleNo--------->"+saleNo);

        Collection.alipayOrder(this, "1", containerId, paidUser, SpUtil.getString(SpUtil.ID), "", saleNo, null, baseBean -> {
            toast("操作成功");
            finishAc();
        }, throwable -> {

            toast(throwable.getMessage());

        });

    }

    /**
     * 轮播图容器
     */
    public class BannerHolder implements Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Glide.with(context).load(Block.resolvePic(data)).placeholder(R.drawable.banner0).dontAnimate().into(imageView);

        }
    }
}
