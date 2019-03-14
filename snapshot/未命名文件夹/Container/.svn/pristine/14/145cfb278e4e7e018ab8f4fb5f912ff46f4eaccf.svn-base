package com.bm.container.module.personal;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.CheckParamsUtils;
import com.bm.container.Tools.NumberUtils;
import com.bm.container.databinding.DeliveryOrderDetailBinding;
import com.bm.container.http.BaseBean;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.personal.bean.DeliveryNoteByBean;
import com.bm.container.module.personal.bean.DeliveryOrderBean;
import com.bm.container.module.personal.bean.OrderDetailBean;
import com.bm.container.module.personal.bean.OrderDetailBeanTwo;
import com.bm.container.view.OrderNoDialog;
import com.bumptech.glide.Glide;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 卖家提货单详情
 * Created by kec on 2017/6/22.
 */

public class DeliveryOrderDetailActivity extends BaseActivity {


    private DeliveryOrderDetailBinding bindView;

    private String ordeNo;

    private String orderStatus;//0 待填写 1 已填
    private String isSupportBill;
    private boolean isShow;//是否费用已结束

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView = DataBindingUtil.setContentView(this, R.layout.delivery_order_detail);
        setLoading();
        setTopbar();
        intentData();
        requestOrderInfoInitView();
    }

    private void intentData() {
        if (null != getIntent()) {
            ordeNo = getIntent().getStringExtra("orderNo");
            orderStatus = getIntent().getStringExtra("orderStatus");
            isSupportBill = getIntent().getStringExtra("isSupportBill");
            isShow = getIntent().getBooleanExtra("isShow", false);
        }

        bindView.tvHintIsShow.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }


    /**
     * 请求数据
     */
    private void requestOrderInfoInitView() {

//        Collection.getDeliveryNoteByOrderNo(this, ordeNo, new Consumer<DeliveryNoteByBean>() {
//            @Override
//            public void accept(DeliveryNoteByBean deliveryOrderBean) throws Exception {
//                initViews(deliveryOrderBean);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                hideLoading();
//                toast(throwable.getMessage());
//            }
//        });


        bindView.checkbox.setEnabled(false);
        bindView.rbGeTi.setEnabled(false);
        bindView.rbDanWei.setEnabled(false);
        bindView.rbGeTi.setChecked(false);
        bindView.rbDanWei.setChecked(false);

//        System.out.println("base-----------isSupportBill------------->"+isSupportBill);

        //无发票信息
        if (!TextUtils.isEmpty(isSupportBill) && isSupportBill.equals("1")) {

            //有发票信息
            Collection.getMyOrderDelivery(this, ordeNo, new Consumer<OrderDetailBean>() {
                @Override
                public void accept(OrderDetailBean deliveryOrderBean) throws Exception {
//                    bindView.tvHintIsShow.setVisibility(!TextUtils.isEmpty(deliveryOrderBean.getData().getOrderStatusType()) && deliveryOrderBean.getData().getOrderStatusType().equals("4") ? View.VISIBLE : View.GONE);
                    DeliveryOrderDetailActivity.this.initView(deliveryOrderBean);
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    DeliveryOrderDetailActivity.this.hideLoading();
                    toast(throwable.getMessage());
                }
            });

        } else
            Collection.getMyOrderDeliveryTwo(this, ordeNo, new Consumer<OrderDetailBeanTwo>() {
                @Override
                public void accept(OrderDetailBeanTwo content1) throws Exception {
//                    bindView.tvHintIsShow.setVisibility(!TextUtils.isEmpty(content1.getData().getOrderStatusType()) && content1.getData().getOrderStatusType().equals("4") ? View.VISIBLE : View.GONE);
                    DeliveryOrderDetailActivity.this.initViews(content1);
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    DeliveryOrderDetailActivity.this.hideLoading();
                    toast(throwable.getMessage());
                }
            });


    }


    private void initViews(OrderDetailBeanTwo content) {

        if (null == content) {
            return;
        }

        bindView.invoiceModel.setVisibility(View.GONE);

        Glide.with(this).load(Block.listPic(content.getData().getContainer().getImageUrl()))
                .placeholder(R.drawable.face)
                .into(bindView.pic);


        bindView.orderId.setText(content.getData().getOrderNo());

        if (content.getData().getOrderStatusType().equals("4")) {
            //已完成
            bindView.state.setText("已完成");
            bindView.rightButton.setText("发送提货单至堆场");
            bindView.rightButton.setVisibility(View.VISIBLE);
            bindView.leftButton.setText("查看提货单");
            bindView.leftButton.setVisibility(View.VISIBLE);
            bindView.tip.setText(getString(R.string.order_tip2));

            //查看提货单
            bindView.leftButton.setOnClickListener(v -> {
                Intent i = new Intent(DeliveryOrderDetailActivity.this, BillOfLadingActivity.class);
                i.putExtra("type", "1");
                i.putExtra("orderNo", ordeNo);
                startAc(i);
            });

            //发送提货单至堆场
            bindView.rightButton.setOnClickListener(v -> {
                showOrderNoDialog();
            });

        } else {

            int orderStatus = Integer.valueOf(content.getData().getIsDelivery());//0 待填写 1 已填

            if (orderStatus == 0) {
                bindView.state.setText("待填写");
                bindView.rightButton.setText("填写提货单");
                bindView.rightButton.setVisibility(View.VISIBLE);
                bindView.leftButton.setVisibility(View.GONE);

//            bindView.leftButton.setText("填写提货单");
                bindView.rightButton.setOnClickListener(v -> {
                    Intent i = new Intent(DeliveryOrderDetailActivity.this, BillOfLadingActivity.class);
                    i.putExtra("type", "2");
                    i.putExtra("orderNo", ordeNo);
                    startAc(i);
                    finishAc();
                });
            } else if (orderStatus == 1) {
                bindView.state.setText("已填写");
                bindView.rightButton.setText("发送提货单至堆场");
                bindView.rightButton.setVisibility(View.VISIBLE);
                bindView.leftButton.setText("查看提货单");
                bindView.leftButton.setVisibility(View.VISIBLE);
                bindView.tip.setText(getString(R.string.order_tip2));

                //查看提货单
                bindView.leftButton.setOnClickListener(v -> {
                    Intent i = new Intent(DeliveryOrderDetailActivity.this, BillOfLadingActivity.class);
                    i.putExtra("type", "1");
                    i.putExtra("orderNo", ordeNo);
                    startAc(i);
                });

                //发送提货单至堆场
                bindView.rightButton.setOnClickListener(v -> {
                    showOrderNoDialog();
                });
            }

        }


        bindView.tvTitleName.setText("标题:" + content.getData().getContainer().getTitle());
        bindView.title.setText("箱型:" + content.getData().getContainer().getContainerTypeName());

        if (!TextUtils.isEmpty(content.getData().getContainer().getStartPrice())) {
            bindView.name.setText("投标底价:" + NumberUtils.formatDouble(Double.valueOf(content.getData().getContainer().getStartPrice())) + "元");
        } else if (!TextUtils.isEmpty(content.getData().getContainer().getPrice())) {
            bindView.name.setText("报价金额:" + NumberUtils.formatDouble(Double.valueOf(content.getData().getContainer().getPrice())) + "元");
        } else if (!TextUtils.isEmpty(content.getData().getContainer().getStatusTypeName())) {
            bindView.name.setText("箱况:" + content.getData().getContainer().getStatusTypeName());
        }
        bindView.count.setText("数量:" + content.getData().getContainer().getCount() + "个");

        bindView.location.setText(content.getData().getContainer().getCountryName() + "." + content.getData().getContainer().getCityName());

        bindView.num.setText(content.getData().getCount());
        bindView.allPrice.setText(NumberUtils.formatDouble(Double.valueOf(content.getData().getPrice())) + "元");

        bindView.tvOrderTime.setText(content.getData().getCreateTime());//下单时间createTime
        bindView.tvPayTime.setText(content.getData().getFinishTime());//支付时间finishTime
        bindView.tvDeliveryTime.setText(content.getData().getReceiveTime());//收货时间receiveTime
        bindView.payType.setText(content.getData().getPayTypeName());//支付方式


    }


    private void initView(OrderDetailBean deliveryOrderBean) {

        if (null == deliveryOrderBean.getData()) {
            return;
        }
        if (null == deliveryOrderBean.getData().getContainer()) {
            return;
        }
        if (null == deliveryOrderBean.getData().getBuyOrder()) {
            return;
        }

        OrderDetailBean.DataBean.ContainerBean content_ = deliveryOrderBean.getData().getContainer();
        OrderDetailBean.DataBean.BuyOrderBean buyOrder = deliveryOrderBean.getData().getBuyOrder();


        Glide.with(this).load(Block.listPic(content_.getImageUrl()))
                .placeholder(R.drawable.face)
                .into(bindView.pic);


        bindView.orderId.setText(deliveryOrderBean.getData().getOrderNo());

        if (deliveryOrderBean.getData().getOrderStatusType().equals("4")) {
            //已完成
            bindView.state.setText("已完成");
            bindView.rightButton.setText("发送提货单至堆场");
            bindView.rightButton.setVisibility(View.VISIBLE);
            bindView.leftButton.setText("查看提货单");
            bindView.leftButton.setVisibility(View.VISIBLE);
            bindView.tip.setText(getString(R.string.order_tip2));

            //查看提货单
            bindView.leftButton.setOnClickListener(v -> {
                Intent i = new Intent(DeliveryOrderDetailActivity.this, BillOfLadingActivity.class);
                i.putExtra("type", "1");
                i.putExtra("orderNo", ordeNo);
                startAc(i);
            });

            //发送提货单至堆场
            bindView.rightButton.setOnClickListener(v -> {
                showOrderNoDialog();
            });

        } else {

            int orderStatus = Integer.valueOf(deliveryOrderBean.getData().getIsDelivery());//0 待填写 1 已填
            if (orderStatus == 0) {
                bindView.state.setText("待填写");
                bindView.rightButton.setText("填写提货单");
                bindView.rightButton.setVisibility(View.VISIBLE);
                bindView.leftButton.setVisibility(View.GONE);

//            bindView.leftButton.setText("填写提货单");
                bindView.rightButton.setOnClickListener(v -> {
                    Intent i = new Intent(DeliveryOrderDetailActivity.this, BillOfLadingActivity.class);
                    i.putExtra("type", "2");
                    i.putExtra("orderNo", ordeNo);
                    startAc(i);
                    finishAc();
                });
            } else if (orderStatus == 1) {
                bindView.state.setText("已填写");
                bindView.rightButton.setText("发送提货单至堆场");
                bindView.rightButton.setVisibility(View.VISIBLE);
                bindView.leftButton.setText("查看提货单");
                bindView.leftButton.setVisibility(View.VISIBLE);
                bindView.tip.setText(getString(R.string.order_tip2));

                //查看提货单
                bindView.leftButton.setOnClickListener(v -> {
                    Intent i = new Intent(DeliveryOrderDetailActivity.this, BillOfLadingActivity.class);
                    i.putExtra("type", "1");
                    i.putExtra("orderNo", ordeNo);
                    startAc(i);
                });

                //发送提货单至堆场
                bindView.rightButton.setOnClickListener(v -> {
                    showOrderNoDialog();
                });
            }

        }


        bindView.tvTitleName.setText("标题:" + content_.getTitle());
        bindView.title.setText("箱型:" + content_.getContainerTypeName());

        if (!TextUtils.isEmpty(content_.getStartPrice())) {
            bindView.name.setText("投标底价:" + NumberUtils.formatDouble(Double.valueOf(content_.getStartPrice())) + "元");
        } else if (!TextUtils.isEmpty(content_.getPrice())) {
            bindView.name.setText("报价金额:" + NumberUtils.formatDouble(Double.valueOf(content_.getPrice())) + "元");
        } else if (!TextUtils.isEmpty(content_.getStatusTypeName())) {
            bindView.name.setText("箱况:" + content_.getStatusTypeName());
        }
        bindView.count.setText("数量:" + content_.getCount() + "个");

        bindView.location.setText(content_.getCountryName() + "." + content_.getCityName());

        bindView.num.setText(content_.getCount());

        bindView.allPrice.setText(NumberUtils.formatDouble(Double.valueOf(buyOrder.getPrice())) + "元");

        bindView.tvOrderTime.setText(deliveryOrderBean.getData().getCreateTime());//下单时间createTime
        bindView.tvPayTime.setText(deliveryOrderBean.getData().getFinishTime());//支付时间finishTime
        bindView.tvDeliveryTime.setText(deliveryOrderBean.getData().getReceiveTime());//收货时间receiveTime
        bindView.payType.setText(deliveryOrderBean.getData().getPayTypeName());//支付方式


        if (!TextUtils.isEmpty(buyOrder.getBillCheque()) || !TextUtils.isEmpty(buyOrder.getBillType())) {
            bindView.invoiceModel.setVisibility(View.VISIBLE);
        } else {
            bindView.invoiceModel.setVisibility(View.GONE);
        }
        bindView.viewBackground.setVisibility(View.VISIBLE);

        if (buyOrder.getBillType().equals("0")) {
            //个人
            bindView.rbGeTi.setEnabled(true);
            bindView.rbGeTi.setChecked(true);
            bindView.rbDanWei.setChecked(false);
            bindView.companyInfo.setVisibility(View.GONE);
        } else if (buyOrder.getBillType().equals("1")) {
            //公司
            bindView.rbGeTi.setChecked(false);
            bindView.rbDanWei.setEnabled(true);
            bindView.rbDanWei.setChecked(true);
            bindView.companyInfo.setVisibility(View.VISIBLE);

        }


        //发票信息显示
        bindView.checkbox.setChecked(true);
        if (!TextUtils.isEmpty(buyOrder.getBillType())) {
            if (buyOrder.getBillType().equals("0")) {
                bindView.rbGeTi.setEnabled(true);
                bindView.rbGeTi.setChecked(true);
                bindView.rbDanWei.setChecked(false);
                bindView.companyInfo.setVisibility(View.GONE);
            } else if (buyOrder.getBillType().equals("1")) {
                bindView.rbGeTi.setChecked(false);
                bindView.rbDanWei.setEnabled(true);
                bindView.rbDanWei.setChecked(true);
                bindView.companyInfo.setVisibility(View.VISIBLE);

            }
        }

        if (!TextUtils.isEmpty(buyOrder.getBillCheque())) {
            bindView.invoiceHead.setText(buyOrder.getBillCheque());
        } else {
            bindView.invoiceHead.setText(buyOrder.getBillContent());
        }

        bindView.invoiceContent.setText(buyOrder.getBillNo());
//        bindView.tvBankName.setText(buyOrder.getBillBankAccount());
        bindView.tvBankName.setText(buyOrder.getBillAccountSource());
//        bindView.tvBankIdText.setText(buyOrder.getBillAccountSource());
        bindView.tvBankIdText.setText(buyOrder.getBillBankAccount());
        bindView.tvAdd.setText(buyOrder.getBillAddress());
        bindView.tvInvoicePhone.setText(buyOrder.getBillTelephone());

    }


    /**
     * 显示订单框
     */
    private void showOrderNoDialog() {
        OrderNoDialog alert = new OrderNoDialog.Builder(this)// builder
                .setIsShow(false)
                .setTitle("填写邮箱地址")
                .setPositiveButton((content, dialog) -> {

                    if (content.isEmpty()) {
                        toast("请填写邮箱地址");
                        return;
                    }

                    if (!CheckParamsUtils.checkEmail(content)) {
                        toast("请填写正确格式邮箱地址");
                        return;
                    }

                    dialog.dismiss();
                    Collection.requestSendDeliveryNote(this, ordeNo, content, new Consumer<BaseBean>() {
                        @Override
                        public void accept(BaseBean baseBean) throws Exception {
                            toast(baseBean.getMsg());
                        }
                    });
                })
                .setNegativeButton((content, dialog) -> {
                    dialog.dismiss();
                })
                .create();
        alert.show();
    }

    //邮箱验证
    public static boolean isEmail(String strEmail) {
        String strPattern = "^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
        if (TextUtils.isEmpty(strPattern)) {
            return false;
        } else {
            return strEmail.matches(strPattern);
        }
    }

    private void setLoading() {
        setLoading(bindView.refresh);
        bindView.refresh.setEnabled(false);
        bindView.refresh.setColorSchemeColors(loadingColors);

    }

    private void setTopbar() {
        bindView.topbar.toolbar.setTitle("");
        bindView.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        bindView.topbar.title.setText(R.string.salerorder_title);
        setSupportActionBar(bindView.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bindView.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }


}
