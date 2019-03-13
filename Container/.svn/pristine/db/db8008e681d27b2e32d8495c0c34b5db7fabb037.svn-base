package com.bm.container.module.market;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.DateUtils;
import com.bm.container.Tools.NumberUtils;
import com.bm.container.Tools.SpUtil;
import com.bm.container.Tools.Verify;
import com.bm.container.constants.ConstantsTag;
import com.bm.container.databinding.ActivitySaleABinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.base.FangDaImgActivity;
import com.bm.container.module.market.bean.InfoBean;
import com.bumptech.glide.Glide;

import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * P5_3_1 商品详情界面(出售)正在进行(含价格界面)
 * 以上界面定义为a版，不用看了
 * <p>
 * 根据接口和新的需求
 * 现合并为卖家自己进入看到的信息和别人进入看到的信息
 */
public class SaleAActivity extends BaseActivity {
    private ActivitySaleABinding binding;
    private Context context;
    private InfoBean content;
    private boolean isCheckedVaule = true;//是否是个人


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //收起键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sale_a);
        context = this;

        setLoading();
        setTopbar();
        setContent();
        requesetBrowser(content.getId());
        setBuy();

    }


    /**
     * 请求浏览量（围观人数）
     */
    private void requesetBrowser(String orderId) {
        if (orderId.isEmpty()) {
            return;
        }
        Collection.requesetSellBox(this, orderId, buyContainerBean -> {
        }, throwable -> {
        });
    }

    /**
     * 加载信息
     */
    private void setContent() {

        content = getIntent().getExtras().getParcelable("content");
        String isSuccess = getIntent().getStringExtra("isSuccess");

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


        if (content.getCreateUser().equals(SpUtil.getString(SpUtil.ID))) {//自己
            binding.model.setVisibility(View.GONE);
        } else {//他人
            binding.model.setVisibility(View.VISIBLE);
        }

        if (!content.getImageUrl().isEmpty()) {

            ArrayList<String> banner = new ArrayList<>(Arrays.asList(content.getImageUrl().split(",")));

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
                    .setPages(new CBViewHolderCreator() {
                        @Override
                        public Object createHolder() {
                            return new BannerHolder();
                        }
                    }, banner);

            binding.banner.setOnItemClickListener(position -> {
                String[] images = content.getImageUrl().split(",");
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

//        if (content.getTradeType().equals("0")) {//销售中
//            binding.llIsGoing.setBackground(context.getResources().getDrawable(R.drawable.red_two));
//            binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.red));
//        } else if (content.getTradeType().equals("1")) {//投标中
//            binding.llIsGoing.setBackground(context.getResources().getDrawable(R.drawable.orange_light));
//            binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.orange));
//        }

        if (content.getContainerStatus().equals("1")) {//进行中  投标中(买箱)
            binding.llIsGoing.setBackground(context.getResources().getDrawable(R.drawable.label_dr_two));
            binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.label_dr));
        } else if (content.getContainerStatus().equals("2")) {//投标中（卖箱）
            binding.llIsGoing.setBackground(context.getResources().getDrawable(R.drawable.orange_light));
            binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.orange));
        } else if (content.getContainerStatus().equals("3")) {//销售中
            binding.llIsGoing.setBackground(context.getResources().getDrawable(R.drawable.red_two));
            binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.red));
        } else if (content.getContainerStatus().equals("4")) {//未付款中
            binding.llIsGoing.setBackground(context.getResources().getDrawable(R.drawable.red_two));
            binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.red));
        } else if (content.getContainerStatus().equals("5")) {//已完成
            binding.llIsGoing.setBackground(null);
            binding.restTime.setVisibility(View.GONE);
            binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.red));
        } else if (content.getContainerStatus().equals("6")) {//已结束
            binding.llIsGoing.setVisibility(View.GONE);
            binding.restTime.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(content.getAppUserType())) {
            binding.ivType.setVisibility(View.VISIBLE);
            if (content.getAppUserType().equals("0")) {
                //个人
                binding.ivType.setImageResource(R.drawable.user_work_state_lv3);
            } else if (content.getAppUserType().equals("1")) {
                //公司
                binding.ivType.setImageResource(R.drawable.user_work_state_lv4);
            }
        } else {
            binding.ivType.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(content.getAge())) {
            binding.llAge.setVisibility(View.VISIBLE);
            binding.tvAge.setText(content.getAge() + "年");
        } else {
            binding.llAge.setVisibility(View.GONE);
        }

        binding.tvTitleName.setText(content.getTitle());
        binding.tvRemark.setText(content.getRemark());
        binding.isGoing.setText(content.getContainerStatusName());
        binding.location.setText(content.getCountryName() + "." + content.getCityName());
        binding.people.setText(content.getScanCount());
        binding.type.setText(content.getContainerTypeName());
        binding.status.setText(content.getStatusTypeName());
        binding.num.setText(content.getCount() + "个");

        if (!content.getContainerStatus().equals("5") && !content.getContainerStatus().equals("6")) {

            Observable
                    .interval(0, 1, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .compose(bindToLifecycle())
                    .subscribe(aLong -> {

                        String countTime = "";
                        //未付款中
                        if (content.getContainerStatus().equals("4")) {
                            long time = DateUtils.getLongTime(content.getCreateTime()) + 36 * 60 * 60 * 1000;//
                            String timestamp = DateUtils.getFormatTimeFromTimestamp(time, DateUtils.FORMAT_DATE_TIME_ALL);
                            countTime = Block.restTime(timestamp);
                        } else {
                            countTime = Block.restTime(content.getDeadLineTime());
                        }
                        binding.restTime.setText(countTime);

                    }, throwable -> {

                    }, () -> {

                    }, disposable -> {
//                        String countTime = Block.restTime(content.getDeadLineTime());
                        String countTime;

                        if (content.getContainerStatus().equals("4")) {
                            long time = DateUtils.getLongTime(content.getCreateTime()) + 36 * 60 * 60 * 1000;//
                            String timestamp = DateUtils.getFormatTimeFromTimestamp(time, DateUtils.FORMAT_DATE_TIME_ALL);
                            countTime = Block.restTime(timestamp);
                        } else {
                            countTime = Block.restTime(content.getDeadLineTime());
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

        if (!TextUtils.isEmpty(content.getPrice())) {
            binding.priceChoosed.setText(NumberUtils.formatDouble(Double.valueOf(content.getPrice())) + "元");
        }
        binding.specialChoosed.setText(content.getIsSpecialPrice().equals("1") ? "有特殊需求" : "无特殊需求");
        if (content.getSpecialPrice().isEmpty()) {
            binding.llSpecial.setVisibility(View.GONE);
        } else {
            binding.llSpecial.setVisibility(View.VISIBLE);
            binding.specialPriceChoosed.setText(content.getSpecialPrice() + "元");
        }
        binding.invoiceChoosed.setText(content.getIsSupportBill().equals("1") ? "提供发票" : "不提供发票");


//        System.out.println("base-------getPrice------------>" + content.getPrice());
//        System.out.println("base--------getIsSpecialPrice----------->" + content.getIsSpecialPrice());
//        System.out.println("base-------getSpecialPrice------------>" + content.getSpecialPrice());
        String priceVaule;
        if (!TextUtils.isEmpty(content.getPrice()) && !TextUtils.isEmpty(content.getSpecialPrice())) {
            priceVaule = NumberUtils.formatDouble(Double.valueOf(content.getPrice()) + Double.valueOf(content.getIsSpecialPrice().equals("1") ? content.getSpecialPrice() : "0"));
        } else if (!TextUtils.isEmpty(content.getPrice()) && TextUtils.isEmpty(content.getSpecialPrice())) {
            priceVaule = NumberUtils.formatDouble(Double.valueOf(content.getPrice()));
        } else if (!TextUtils.isEmpty(content.getSpecialPrice()) && TextUtils.isEmpty(content.getPrice())) {
            priceVaule = NumberUtils.formatDouble(Double.valueOf(content.getSpecialPrice()));
        } else {
            priceVaule = "0";
        }

//        String priceVaule = NumberUtils.formatDouble(Double.valueOf(content.getPrice().isEmpty() ? "0" : content.getPrice()) + Double.valueOf(content.getIsSpecialPrice().equals("1") ? content.getSpecialPrice() : "0"));
        binding.allPrice.setText(priceVaule + "元");
        if (content.getIsSupportBill().equals("1")) {
            binding.invoiceModel.setVisibility(View.VISIBLE);
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
            binding.view.setVisibility(View.VISIBLE);
            binding.checkInvoice.setEnabled(false);
            setInputEable(false);
        }
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
        binding.buy.setOnClickListener(view -> {
//			String type = binding.personalCheck.isChecked() ? "0" : "1";

            String type = "";//发票类型 个人of是单位
            String typeName = "";// 个人of是单位
            if (binding.checkInvoice.isChecked()) {
                if (binding.personalCheck.isChecked()) {
                    type = "0";
                    typeName = "个人";
                } else if (binding.companyCheck.isChecked()) {
                    type = "1";
                    typeName = "公司";
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

            String price = Float.parseFloat(this.content.getPrice()) + Float.parseFloat(this.content.getIsSpecialPrice().equals("1") ? this.content.getSpecialPrice() : "0") + "";

            if (Verify.buyOrderBuy(binding.checkInvoice, isCheckedVaule, head, bankName, bankIdText, etAdd, invoicePhone, content)) {
//				Collection.buyOrder(this, this.content.getId(), type, head, content, "", price, baseBean -> {
//					Intent i = new Intent(context, PayActivity.class);
////					i.putExtra("id", this.content.getId());
////					i.putExtra("owner", this.content.getCreateUser());
//					i.putExtra("content", this.content);
//					startAc(i);
//				});

//                @Field("billType") String Type, //发票类型
//                @Field("billTypeName") String name, //发票类型名称
//                @Field("billCheque") String top, //发票抬头
//                @Field("billContent") String content, //发票内容
//                @Field("billTelephone") String phone, //发票电话
//                @Field("price") String money, //价格
//                @Field("containerId") String no,//卖箱信息编号
//                @Field("createUser") String user,//创建人信息
//
//                @Field("billNo") String billNo,//发票税号
//                @Field("billBankAccount") String billBankAccount,//发票银行帐号
//                @Field("billAccountSource") String billAccountSource,//发票帐号开户行
//                @Field("billAddress") String billAddress //发票地址

                if (this.content.getContainerStatus().equals("4") || this.content.getContainerStatus().equals("5")) {
                    //未付款中
                    toast("当前买箱信息已经生产订单，不能再次购买");
                    return;
                }

                Intent intent = new Intent(context, PayActivity.class);
                if (binding.checkInvoice.isChecked()) {
                    //需要发票信息
                    this.content.setBillType(type);
                    this.content.setBillTypeName(typeName);
                    this.content.setBillContent(head);
                    this.content.setBillCheque(head);
                    this.content.setBillTelephone(invoicePhone);

                    this.content.setBillNo(content);
                    this.content.setBillBankAccount(bankName);
                    this.content.setBillAccountSource(bankIdText);
                    this.content.setBillAddress(etAdd);
                    intent.putExtra("content", this.content);
                    intent.putExtra("orderType", "1");
                } else {
                    //不需要发票
                    intent.putExtra("content", this.content);

                }

                startAc(intent);
            }

        });
    }


    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
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
     * 轮播图的容器
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

    @Subscriber(mode = ThreadMode.MAIN, tag = ConstantsTag.PAY_ACTIVIY_FINISH)
    private void finishActivity(String string) {

        if (!TextUtils.isEmpty(string)) {
            finishAc();
        }

    }

}
