package com.bm.container.module.personal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.DateUtils;
import com.bm.container.Tools.NumberUtils;
import com.bm.container.databinding.ActivityOrderDetailBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.market.PayActivity;
import com.bm.container.module.personal.bean.DeliveryNoteByBean;
import com.bm.container.module.personal.bean.OrderBean;
import com.bm.container.module.personal.bean.OrderDetailBean;
import com.bumptech.glide.Glide;
import com.ta.utdid2.android.utils.StringUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * P7_3_1 待付款订单详情 0
 * P7_3_2 已付款订单详情 1
 * P7_3_3 待提货订单详情 2
 * P7_3_4 已完成订单详情 3
 * P7_4_1 已付款订单详情 4
 * P7_4_2 待提货订单详情 5
 */
public class OrderDetailActivity extends BaseActivity {
    private ActivityOrderDetailBinding binding;
    private Context context;
    private String type;
    //    private OrderBean content;
    private String orderNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_detail);
        context = this;

        OrderBean content = getIntent().getExtras().getParcelable("content");
        if (null == content) {
            orderNo = getIntent().getStringExtra("orderNo");
        } else {
            orderNo = content.getOrderNo();
        }

        setTopbar();
        setLoading();
//        setType();
        requestOrderInfoInitView();
    }

    /**
     * 请求数据
     */
    private void requestOrderInfoInitView() {

        binding.checkbox.setEnabled(false);
        binding.rbGeTi.setEnabled(false);
        binding.rbDanWei.setEnabled(false);
        binding.rbGeTi.setChecked(false);
        binding.rbDanWei.setChecked(false);

//        System.out.println("base---------getIsSupportBill----------->"+content.getContainer().getIsSupportBill());
//        System.out.println("base---------orderNo--1--------->"+orderNo);

//        if (!TextUtils.isEmpty(content.getContainer().getIsSupportBill()) && content.getContainer().getIsSupportBill().equals("1")) {
        //根据订单号获取订单详情
        Collection.getMyOrderDelivery(this, orderNo, new Consumer<OrderDetailBean>() {
            @Override
            public void accept(OrderDetailBean deliveryOrderBean) throws Exception {
                initViews(deliveryOrderBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                hideLoading();
                toast(throwable.getMessage());
            }
        });

//        } else {
//            //无发票
//            setContent();
//
//        }

    }

    /**
     * 有发票信息 初始化布局
     *
     * @param deliveryOrderBean
     */
    private void initViews(OrderDetailBean deliveryOrderBean) {

        if (null == deliveryOrderBean.getData()) {
            return;
        }
        if (null == deliveryOrderBean.getData().getContainer()) {
            return;
        }
        if (null == deliveryOrderBean.getData().getBuyOrder()) {
            return;
        }

        setType(deliveryOrderBean);

        OrderDetailBean.DataBean.ContainerBean content_ = deliveryOrderBean.getData().getContainer();
        OrderDetailBean.DataBean.BuyOrderBean buyOrder = deliveryOrderBean.getData().getBuyOrder();

        binding.orderId.setText(deliveryOrderBean.getData().getOrderNo());
        binding.titleName.setText("标题:" + content_.getTitle());
        Glide.with(context).load(Block.listPic(content_.getImageUrl())).placeholder(R.drawable.face).into(binding.pic);
        binding.title.setText("箱型:" + content_.getContainerTypeName());

        if (!TextUtils.isEmpty(deliveryOrderBean.getData().getContainer().getStartPrice())) {
            binding.name.setText("投标底价:" + NumberUtils.formatDouble(Double.valueOf(deliveryOrderBean.getData().getContainer().getStartPrice())) + "元");
        } else if (!TextUtils.isEmpty(deliveryOrderBean.getData().getContainer().getPrice())) {
            binding.name.setText("报价金额:" + NumberUtils.formatDouble(Double.valueOf(deliveryOrderBean.getData().getContainer().getPrice())) + "元");
        } else if (!TextUtils.isEmpty(deliveryOrderBean.getData().getContainer().getStatusTypeName())) {
            binding.name.setText("箱况:" + deliveryOrderBean.getData().getContainer().getStatusTypeName());
        }
        binding.count.setText("数量:" + deliveryOrderBean.getData().getCount() + "个");

        binding.location.setText(content_.getCountryName() + "." + content_.getCityName());
        binding.num.setText(content_.getCount());

        binding.allPrice.setText(buyOrder.getPrice() + "元");

        binding.payType.setText(deliveryOrderBean.getData().getPayTypeName());


        if (!TextUtils.isEmpty(deliveryOrderBean.getData().getPaidUserInfo().getAppUserType())) {
            binding.ivType.setVisibility(View.VISIBLE);
            if (deliveryOrderBean.getData().getPaidUserInfo().getAppUserType().equals("0")) {
                //个人
                binding.ivType.setImageResource(R.drawable.user_work_state_lv3);
            } else if (deliveryOrderBean.getData().getPaidUserInfo().getAppUserType().equals("1")) {
                //公司
                binding.ivType.setImageResource(R.drawable.user_work_state_lv4);
            }
        } else {
            binding.ivType.setVisibility(View.GONE);
        }

        //有发票
//        System.out.println("base---------billCheque------->" + buyOrder.getBillCheque());
//        System.out.println("base---------billContent------->" + buyOrder.getBillContent());
//        System.out.println("base---------billType------->" + buyOrder.getBillType());
//        System.out.println("base---------billTypeName------->" + buyOrder.getBillTypeName());
//        System.out.println("base---------billNo------->" + buyOrder.getBillNo());
//        System.out.println("base---------billBankAccount------->" + buyOrder.getBillBankAccount());
//        System.out.println("base---------billAccountSource------->" + buyOrder.getBillAccountSource());
//        System.out.println("base---------billAddress------->" + buyOrder.getBillAddress());
//        System.out.println("base---------billTelephone------->" + buyOrder.getBillTelephone());


        binding.checkbox.setChecked(true);
        if (!TextUtils.isEmpty(buyOrder.getBillType())) {
            if (buyOrder.getBillType().equals("0")) {
                binding.rbGeTi.setEnabled(true);
                binding.rbGeTi.setChecked(true);
                binding.rbDanWei.setChecked(false);
                binding.invoiceModel.setVisibility(View.VISIBLE);
                binding.viewBackground.setVisibility(View.VISIBLE);
                binding.companyInfo.setVisibility(View.GONE);
            } else if (buyOrder.getBillType().equals("1")) {
                binding.rbGeTi.setChecked(false);
                binding.rbDanWei.setEnabled(true);
                binding.rbDanWei.setChecked(true);
                binding.invoiceModel.setVisibility(View.VISIBLE);
                binding.viewBackground.setVisibility(View.VISIBLE);
                binding.companyInfo.setVisibility(View.VISIBLE);

            }
        } else {
            binding.invoiceModel.setVisibility(View.GONE);
            binding.viewBackground.setVisibility(View.VISIBLE);
        }


        if (!TextUtils.isEmpty(buyOrder.getBillCheque())) {
            binding.invoiceHead.setText(buyOrder.getBillCheque());
        } else {
            binding.invoiceHead.setText(buyOrder.getBillContent());
        }

        binding.invoiceContent.setText(buyOrder.getBillNo());
//        binding.tvBankName.setText(buyOrder.getBillBankAccount());
        binding.tvBankName.setText(buyOrder.getBillAccountSource());
//        binding.tvBankIdText.setText(buyOrder.getBillAccountSource());
        binding.tvBankIdText.setText(buyOrder.getBillBankAccount());
        binding.tvAdd.setText(buyOrder.getBillAddress());
        binding.tvInvoicePhone.setText(buyOrder.getBillTelephone());

    }

    /**
     * 内容
     */
//    private void setContent() {
//
//        if (null == content) {
//            return;
//        }
//
//
//        binding.titleName.setText(content.getContainer().getTitle());
//        binding.orderId.setText(content.getOrderNo());
//        Glide.with(context).load(Block.listPic(content.getContainer().getImageUrl())).placeholder(R.drawable.face).into(binding.pic);
//        binding.title.setText(content.getContainer().getContainerTypeName());
//        binding.location.setText(content.getContainer().getCountryName() + "." + content.getContainer().getCityName());
//        binding.num.setText(content.getCount());
//        binding.allPrice.setText(content.getPrice() + "元");
//        binding.payType.setText(content.getPayTypeName());
//
//
//        if (content.getContainer().getBillType().isEmpty()) {
//            binding.invoiceModel.setVisibility(View.GONE);
//            binding.viewBackground.setVisibility(View.VISIBLE);
//        }
//
//    }

    /**
     * 类型
     */
    private void setType(OrderDetailBean deliveryOrderBean) {


//        if (null == content || StringUtils.isEmpty(content.getOrderStatusType())) {
//            return;
//        }
        switch (deliveryOrderBean.getData().getOrderStatusType()) {
            case "1":
                type = "0";
                break;
            case "2":
                type = "1";
                break;
            case "3":
                type = "2";
                break;
            case "4":
                type = "3";
                break;
        }


        binding.tvOrderTime.setText(deliveryOrderBean.getData().getContainer().getCreateTime());
//        binding.tvPayTime.setText(content.getReceiveTime());
        binding.tvPayTime.setText(deliveryOrderBean.getData().getFinishTime());
        binding.tvDeliveryTime.setText(deliveryOrderBean.getData().getReceiveTime());

        binding.tipTop.setVisibility(View.GONE);

        binding.state.setText(deliveryOrderBean.getData().getOrderStatusTypeName());
        //  3*（24*60*60*1000）
        //  36*（60*60*1000）
        Observable
                .interval(0, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(bindToLifecycle())
                .subscribe(aLong -> {
//                    String countTime = Block.restTime(deliveryOrderBean.getData().getContainer().getDeadLineTime());
//                    long time = DateUtils.getLongTime(deliveryOrderBean.getData().getCreateTime()) + 259200000;
                    long time = DateUtils.getLongTime(deliveryOrderBean.getData().getCreateTime()) + 36 * 60 * 60 * 1000;//
                    String timestamp = DateUtils.getFormatTimeFromTimestamp(time, DateUtils.FORMAT_DATE_TIME_ALL);
                    String countTime = Block.restTime(timestamp);
//                    System.out.println("base-------getCreateTime--------->" + deliveryOrderBean.getData().getCreateTime());
//                    System.out.println("base-------time--------->" + time);
//                    System.out.println("base-------timestamp--------->" + timestamp);
//                    System.out.println("base-------countTime--------->" + countTime);
                    binding.tipTop.setText("请在" + countTime + "内完成付款，晚了将失去购买机会哦~");
                }, throwable -> {

                }, () -> {

                }, disposable -> {
//                    String countTime = Block.restTime(deliveryOrderBean.getData().getContainer().getDeadLineTime());

                    long time = DateUtils.getLongTime(deliveryOrderBean.getData().getCreateTime()) + 36 * 60 * 60 * 1000;//
                    String timestamp = DateUtils.getFormatTimeFromTimestamp(time, DateUtils.FORMAT_DATE_TIME_ALL);
                    String countTime = Block.restTime(timestamp);
                    if (countTime.isEmpty()) {

                        //待付款
                        if (deliveryOrderBean.getData().getOrderStatusType().equals("1")) {
                            binding.tipTop.setVisibility(View.GONE);
                            Collection.cancelOrder(this, deliveryOrderBean.getData().getOrderNo(), baseBean -> {
                                dialogFinish("交易记录已过期,请在列表中重新选择");
                                disposable.dispose();
                            });
                        }

                    } else {

                    }
                });


        if (type.equals("0") && !deliveryOrderBean.getData().getIsDelivery().equals("1")) {
//            binding.tipTop.setText("请在"+Block.restTime(content.getContainer().getDeadLineTime())+"内完成付款，晚了将失去购买机会哦~");
            binding.tipTop.setVisibility(View.VISIBLE);
//            binding.state.setText("待付款");
            binding.state.setTextColor(getResources().getColor(R.color.daifukuan));
            binding.tip.setVisibility(View.GONE);
            binding.modelButton.setVisibility(View.VISIBLE);
            binding.leftButton.setVisibility(View.VISIBLE);
            binding.leftButton.setText("取消订单");
            binding.rightButton.setVisibility(View.VISIBLE);
            binding.rightButton.setText("立即付款");

            //立即支付
            binding.rightButton.setOnClickListener(v -> {
                Intent i = new Intent(context, PayActivity.class);
                i.putExtra("orderType", "2");
                i.putExtra("orderNo", deliveryOrderBean.getData().getOrderNo());
                i.putExtra("orderPrice", deliveryOrderBean.getData().getPrice());
                finishAc();
                startAc(i);
            });

            //取消订单
            binding.leftButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog("是否取消当前订单？", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            OrderDetailActivity.this.cancelOrder(deliveryOrderBean.getData().getOrderNo());

                        }
                    });


                }
            });

        } else if (type.equals("1") && !deliveryOrderBean.getData().getIsDelivery().equals("1")) {
//            binding.state.setText("已付款");
            binding.state.setTextColor(getResources().getColor(R.color.yifukuan));
            binding.tip.setVisibility(View.GONE);
            binding.modelButton.setVisibility(View.GONE);
        } else if (type.equals("2") && !deliveryOrderBean.getData().getIsDelivery().equals("1")) {
//            binding.state.setText("待提货");
            binding.state.setTextColor(getResources().getColor(R.color.daitihuo));
            binding.tip.setVisibility(View.VISIBLE);
            binding.modelButton.setVisibility(View.VISIBLE);
            binding.rightButton.setVisibility(View.VISIBLE);
            binding.rightButton.setText("填写提货单");
            binding.rightButton.setOnClickListener(view -> {
                Intent i = new Intent(context, BillOfLadingActivity.class);
                i.putExtra("type", "0");
                i.putExtra("orderNo", deliveryOrderBean.getData().getOrderNo());
                i.putExtra("orderStatus", deliveryOrderBean.getData().getIsDelivery());
                startAc(i);
                finishAc();
            });
//            binding.leftButton.setVisibility(View.VISIBLE);
//            binding.leftButton.setText("已收货");
            binding.leftButton.setVisibility(View.GONE);
            binding.tipTop.setVisibility(View.GONE);
        } else if (type.equals("3") || deliveryOrderBean.getData().getIsDelivery().equals("1")) {
//            binding.state.setText("已完成");
            if (deliveryOrderBean.getData().getIsDelivery().equals("1")) {
                binding.state.setTextColor(getResources().getColor(R.color.yiwancheng));
            } else if (deliveryOrderBean.getData().getIsDelivery().equals("0")) {
                binding.state.setTextColor(getResources().getColor(R.color.daitihuo));
            }
            binding.tip.setVisibility(View.GONE);
            binding.modelButton.setVisibility(View.VISIBLE);
            binding.leftButton.setVisibility(View.GONE);
            binding.rightButton.setVisibility(View.VISIBLE);
            binding.rightButton.setText("查看提货单");
            binding.rightButton.setOnClickListener(view -> {
                Intent i = new Intent(context, BillOfLadingActivity.class);
                i.putExtra("type", "1");
                i.putExtra("orderNo", deliveryOrderBean.getData().getOrderNo());
                i.putExtra("orderStatus", deliveryOrderBean.getData().getIsDelivery());
                i.putExtra("typeStatus", true);
                startAc(i);
            });
        } else if (type.equals("4") && !deliveryOrderBean.getData().getIsDelivery().equals("1")) {
//            binding.state.setText("已付款");
            binding.state.setTextColor(getResources().getColor(R.color.yifukuan));
            binding.tip.setVisibility(View.GONE);
            binding.modelButton.setVisibility(View.VISIBLE);
            binding.leftButton.setVisibility(View.GONE);
            binding.rightButton.setVisibility(View.VISIBLE);
            binding.rightButton.setText("填写提货单");
            binding.rightButton.setOnClickListener(view -> {
                Intent i = new Intent(context, BillOfLadingActivity.class);
                i.putExtra("type", "2");
                i.putExtra("orderNo", deliveryOrderBean.getData().getOrderNo());
                i.putExtra("orderStatus", deliveryOrderBean.getData().getIsDelivery());
                startAc(i);
            });
        } else if (type.equals("5") || deliveryOrderBean.getData().getIsDelivery().equals("1")) {
//            binding.state.setText("待提货");
            binding.state.setTextColor(getResources().getColor(R.color.daitihuo));
            binding.tip.setVisibility(View.VISIBLE);
            binding.tip.setVisibility(View.VISIBLE);
            binding.modelButton.setVisibility(View.VISIBLE);
            binding.leftButton.setVisibility(View.VISIBLE);
            binding.leftButton.setText("查看提货单");
            binding.leftButton.setOnClickListener(view -> {
                Intent i = new Intent(context, BillOfLadingActivity.class);
                i.putExtra("type", "3");
                i.putExtra("orderNo", deliveryOrderBean.getData().getOrderNo());
                i.putExtra("orderStatus", deliveryOrderBean.getData().getIsDelivery());
                i.putExtra("typeStatus", true);
                startAc(i);
            });
            binding.rightButton.setVisibility(View.VISIBLE);
            binding.rightButton.setText("发送提货单至堆场");
            binding.tipTop.setVisibility(View.GONE);
        }
    }


    /**
     * 取消订单
     */
    private void cancelOrder(String orderNo) {

        Collection.cancelOrder(this, orderNo, baseBean -> {
            toast("取消成功");
            finishAc();
        });
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.order_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }

    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }
}
