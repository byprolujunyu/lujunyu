package com.bm.container.module.market;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.bm.container.R;
import com.bm.container.Tools.DataUtils;
import com.bm.container.Tools.NumberUtils;
import com.bm.container.Tools.PackageExists;
import com.bm.container.Tools.PayResult;
import com.bm.container.Tools.PayResultNew;
import com.bm.container.Tools.SpUtil;
import com.bm.container.Tools.ThirdPart;
import com.bm.container.constants.ConstantsTag;
import com.bm.container.databinding.ActivityPayBinding;
import com.bm.container.entity.AlipayBaenEntity;
import com.bm.container.entity.OrderEntity;
import com.bm.container.entity.SaveSaleOfferInfoEntity;
import com.bm.container.entity.WeiXinPayEntity;
import com.bm.container.http.BaseBean;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.market.bean.InfoBean;
import com.bm.container.module.market.bean.OfferBean;
import com.bm.container.module.personal.MyOrderActivity;
import com.bm.container.module.personal.OrderDetailActivity;
import com.bm.container.view.AlertDialog;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

import java.util.Map;
import java.util.Random;

import io.reactivex.functions.Consumer;

/**
 * P5_4 选择支付方式
 */
public class PayActivity extends BaseActivity {
    private ActivityPayBinding binding;
    private Context context;
    private InfoBean content;
    private OfferBean choosed;
    private String type = "1";//支付类型  1:weixin 2:zhifubao

    private String orderType;//1 :未生成订单  2：已生订单编
    private String orderNo;//已生成订单编号
    private String orderPrice;//已生成订单价格

    private String id = "";
    private boolean checkInvoice;//是否提供发票
    private String billType;//发票类型
    private String billName;//发票类型名称
    private String head;//发票抬头
    private String containerId;
    private String createUser;

    private String billNo = "";    //发票税号
    private String bankName = "";//银行名称
    private String bankIdText;//发票银行帐号
    private String etAdd;//发票地址
    private String invoicePhone;//公司电话


    private static final int SDK_PAY_FLAG = 1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResultNew payResult = new PayResultNew((String) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(PayActivity.this, "支付成功", Toast.LENGTH_SHORT).show();

                        EventBus.getDefault().post("payActiviyFinish", ConstantsTag.PAY_ACTIVIY_FINISH);

                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
//                        if (TextUtils.equals(resultStatus, "8000")) {
//                            toast("支付结果确认中");
//                        } else {
//                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
//                            toast("支付失败");
//                        }
                        EventBus.getDefault().post("cancelPay", ConstantsTag.PAY_ACTIVIY_FINISH);
                    }
                    break;
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pay);
        context = this;

        setTopbar();
        setLoading();
        setPay();
    }

    /**
     * 支付
     */
    private void setPay() {

        orderType = getIntent().getExtras().getString("orderType");

        if (!TextUtils.isEmpty(orderType) && orderType.equals("2")) {
            orderNo = getIntent().getExtras().getString("orderNo");
            orderPrice = getIntent().getExtras().getString("orderPrice");

            binding.tvPayPrice.setText(NumberUtils.formatDouble(Double.valueOf(orderPrice)) + "元");

        } else if (!TextUtils.isEmpty(orderType) && orderType.equals("3")) {

            choosed = getIntent().getExtras().getParcelable("choosed");
            checkInvoice = getIntent().getBooleanExtra("checkInvoice", false);
            billType = getIntent().getStringExtra("billType");
            billName = getIntent().getStringExtra("billName");

            head = getIntent().getStringExtra("head");
            billNo = getIntent().getStringExtra("billNo");
            bankName = getIntent().getExtras().getString("bankName");
            bankIdText = getIntent().getExtras().getString("bankIdText");
            etAdd = getIntent().getExtras().getString("etAdd");
            invoicePhone = getIntent().getExtras().getString("invoicePhone");

            binding.tvPayPrice.setText(NumberUtils.formatDouble(Double.valueOf(choosed.getPrice())) + "元");

        } else {
            content = getIntent().getExtras().getParcelable("content");
//            binding.tvPayPrice.setText(NumberUtils.formatDouble(Double.valueOf(content.getPrice())) + "元");
            String priceVaule = NumberUtils.formatDouble(Double.valueOf(content.getPrice().isEmpty() ? "0" : content.getPrice()) + Double.valueOf(content.getIsSpecialPrice().equals("1") ? content.getSpecialPrice() : "0"));
            binding.tvPayPrice.setText(priceVaule + "元");

        }


        binding.payModel.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == binding.weixin.getId()) {
                type = "1";
            } else if (checkedId == binding.alipay.getId()) {
                type = "2";
            }
        });

        //确认支付
        binding.pay.setOnClickListener(view -> {
            if (DataUtils.isFastClick()) {
                toast("您的操作过于频繁，请稍后！");
                return;
            }
            if (!TextUtils.isEmpty(orderType) && orderType.equals("2")) {
                //订单已生成  直接付款
//                requestGenerateOrder();
                requestPay(orderNo, orderPrice, getNextString(32), DataUtils.getTime());
            } else {
                //订单未生成
                requestSaveSaleOfferInfo();
            }
        });

    }

    /**
     * 保存出售出价表信息
     */
    private void requestSaveSaleOfferInfo() {

//        private String billNo = "";	//发票税号
//        private String bankName="";//银行名称
//        private String bankIdText;//发票银行帐号
//        private String etAdd;//发票地址
//        private String invoicePhone;//公司电话


        if (!TextUtils.isEmpty(orderType) && orderType.equals("3")) {

            if (null == choosed) {
                return;
            }

            createUser = choosed.getCreateUser();

            if (!checkInvoice) {
                //不提供发票信息

                Collection.saveSaleOfferInfo(this, "", "", "", "", "", choosed.getPrice(), choosed.getContainerId(), "", "", "", "", baseBean -> {
                    id = baseBean.getData().getId();
                    containerId = baseBean.getData().getContainerId();
//                    createUser = baseBean.getData().getCreateUser();
                    requestGenerateOrder();
                });

            } else {
                //有发票信息
                Collection.saveSaleOfferInfo(this, billType, billName, head, billNo, invoicePhone, choosed.getPrice(), choosed.getContainerId(),
                        billNo, bankName, bankIdText, etAdd, new Consumer<SaveSaleOfferInfoEntity>() {
                            @Override
                            public void accept(SaveSaleOfferInfoEntity baseBean) throws Exception {
                                id = baseBean.getData().getId();
                                containerId = baseBean.getData().getContainerId();
//                        createUser = baseBean.getData().getCreateUser();
                                requestGenerateOrder();
                            }
                        });

            }

        } else {

            if (null == content) {
                return;
            }

            Collection.saveSaleOfferInfo(this, content.getBillType(), content.getBillTypeName(), content.getBillCheque(),
                    content.getBillContent(), content.getBillTelephone(), content.getPrice(), content.getId(),
                    content.getBillNo(), content.getBillAccountSource(), content.getBillBankAccount(), content.getBillAddress(), baseBean -> {
                        id = baseBean.getData().getId();
                        requestGenerateOrder();
                    });
        }


    }


    /**
     * 请求支付 是否要生成买卖订单
     */
    private void requestGenerateOrder() {

        if (!TextUtils.isEmpty(orderType) && orderType.equals("3")) {
            //请求生成订单
            Collection.alipayOrder(PayActivity.this, type, containerId, SpUtil.getString(SpUtil.ID), createUser, null, id, null, baseBean -> {
                if (null != baseBean && null != baseBean.getData()) {

                    OrderEntity.DataBean dataBean = baseBean.getData();

                    orderNo = dataBean.getOrderNo();
                    PayActivity.this.requestPay(dataBean.getOrderNo(), dataBean.getPrice(), getNextString(32), DataUtils.getTime());

                }
            }, throwable -> {
                hideLoading();
                toast(throwable.getMessage());

            });
        } else {

            if (null == content) {
                return;
            }

            //请求生成订单
            Collection.alipayOrder(PayActivity.this, type, content.getId(), SpUtil.getString(SpUtil.ID), content.getCreateUser(), null, id, null, baseBean -> {
                if (null != baseBean && null != baseBean.getData()) {

                    OrderEntity.DataBean dataBean = baseBean.getData();

                    orderNo = dataBean.getOrderNo();
                    PayActivity.this.requestPay(dataBean.getOrderNo(), dataBean.getPrice(), getNextString(32), DataUtils.getTime());

                }
            }, throwable -> {
                hideLoading();
                toast(throwable.getMessage());

            });
        }

    }


    /**
     * 请求支付
     *
     * @param orderNo      订单编号
     * @param price        价格
     * @param randomString 随机字符串
     * @param timeStamp    时间戳
     */
    private void requestPay(String orderNo, String price, String randomString, String timeStamp) {

//        price = "0.01";

        double priceVaule = Double.valueOf(price) * 100f;
        int price_ = (int) (priceVaule);//TODO 支付金额


//        System.out.println("base------------------请求支付---------------------");
//        System.out.println("base--订单编号-->" + orderNo);
//        System.out.println("base--金额-->" + price_);
//        System.out.println("base--随机字符串-->" + getNextString(32));
//        System.out.println("base--时间戳-->" + DataUtils.getTime());


        if (type.equals("1")) {
            showLoading();
            //请求支付
            Collection.weiXinPay(PayActivity.this, orderNo, String.valueOf(price_), randomString, timeStamp, weiXinPayEntity -> {

                WeiXinPayEntity.DataBean data = weiXinPayEntity.getData();

                if (PackageExists.isWeixinAvilible(this)) {

                    ThirdPart.wxPay(PayActivity.this, data.getAppid(),
                            data.getPartnerid(), data.getPrepayid(), data.getPackageX()
                            , data.getNonceStr(), data.getTimestamp(), data.getSign());

                } else {
                    toast("请安装微信客户端.");
                }


            });
        } else if (type.equals("2")) {

            Collection.alipayPay(PayActivity.this, orderNo, new Consumer<AlipayBaenEntity>() {
                @Override
                public void accept(AlipayBaenEntity baseBean) throws Exception {
                    alipay(baseBean.getData());
                }
            });

        }

    }


    /**
     * 支付宝
     */
    private void alipay(String orderInfo) {
        Runnable payRunnable = () -> {
//			PayTask alipay = new PayTask(PayActivity.this);
//			Map<String, String> result = alipay.payV2(orderInfo, true);
//
//			Message msg = new Message();
//			msg.what = SDK_PAY_FLAG;
//			msg.obj = result;
//			handler.sendMessage(msg);

            // 构造PayTask 对象
            PayTask alipay = new PayTask(PayActivity.this);
            // 调用支付接口，获取支付结果
            String result = alipay.pay(orderInfo, true);
            Message msg = new Message();
            msg.what = SDK_PAY_FLAG;
            msg.obj = result;
            handler.sendMessage(msg);

        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.pay_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }


    /**
     * 参数为生成的字符串的长度，根据给定的char集合生成字符串
     *
     * @param length 字符串的长度
     * @return
     */
    public String getNextString(int length) {

        char[] chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Random random = new Random();

        char[] data = new char[length];

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length);
            data[i] = chars[index];
        }
        String s = new String(data);
        return s;
    }

    private void showD(String message) {
        //跳转到订单详情
        AlertDialog alert = new AlertDialog.Builder(this)// builder
                .setCancelable(false)
                .setContent(message) //TODO 内容
                .setPositiveButton("确定", (mdialog, which) -> {
                    System.out.println("base---------orderNo--0--------->" + orderNo);
                    Intent i = new Intent(PayActivity.this, OrderDetailActivity.class);
                    i.putExtra("orderNo", orderNo);
                    startAc(i);
                    finishAc();
                    mdialog.dismiss();
                })
                .create();
        alert.show();
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = ConstantsTag.PAY_ACTIVIY_FINISH)
    private void finishActivity(String string) {

        if (!TextUtils.isEmpty(string) && string.equals("payActiviyFinish")) {
            finishAc();
        } else if (!TextUtils.isEmpty(string) && string.equals("cancelPay")) {
            showD("支付失败!");
        }

    }

}
