package com.bm.container.module.market;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.NumberUtils;
import com.bm.container.Tools.Verify;
import com.bm.container.constants.ConstantsTag;
import com.bm.container.databinding.ActivityPurchaseEBinding;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.base.FangDaImgActivity;
import com.bm.container.module.market.bean.BuyContainerBean;
import com.bm.container.module.market.bean.InfoBean;
import com.bm.container.module.market.bean.OfferBean;
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
 * P5_2_5 商品详情界面(求购模块)正在进行
 * <p>
 * 选择出价后进入的界面
 */
public class PurchaseEActivity extends BaseActivity {
    private ActivityPurchaseEBinding binding;
    private Context context;
    private BuyContainerBean.DataBean content;
    private OfferBean choosed;
    private boolean isCheckedVaule = true;//是否是个人

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //收起键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_purchase_e);
        context = this;

        setLoading();
        setTopbar();
        setContent();
        setBuy();
    }

    /**
     * 内容显示
     */
    private void setContent() {
        content = getIntent().getExtras().getParcelable("content");
        choosed = getIntent().getExtras().getParcelable("choosed");

        if (!choosed.getImageUrl().isEmpty()) {
            binding.banner
                    .setPageIndicator(new int[]{R.drawable.circle_grey, R.drawable.circle_blue})
                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                    .setPages(() -> new BannerHolder(), Arrays.asList(choosed.getImageUrl().split(",")));


            ArrayList<String> banner = new ArrayList<>(Arrays.asList(choosed.getImageUrl().split(",")));

            if (null == banner || banner.size() <= 0) {
                binding.tvIamge.setVisibility(View.GONE);
            }

            binding.banner.setOnItemClickListener(position -> {
                String[] images = choosed.getImageUrl().split(",");
                Intent intent = new Intent(context, FangDaImgActivity.class);
                intent.putExtra("pic_position", position);
                Bundle b = new Bundle();
                b.putStringArray("img", images);
                intent.putExtras(b);
                context.startActivity(intent);
            });

        }

//		if (content.getTradeType().equals("0")||content.getContainerStatus().equals("1")){//销售中 或 正在进行中
//			binding.llIsGoing.setBackground(context.getResources().getDrawable(R.drawable.red_two));
//			binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.red));
//		}else if (content.getTradeType().equals("1")){//投标中
//			binding.llIsGoing.setBackground(context.getResources().getDrawable(R.drawable.orange_light));
//			binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.orange));
//		}

        if (content.getTradeType().equals("0")) {//销售中
            binding.llIsGoing.setBackground(context.getResources().getDrawable(R.drawable.red_two));
            binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.red));
        } else if (content.getTradeType().equals("1")) {//投标中
            binding.llIsGoing.setBackground(context.getResources().getDrawable(R.drawable.orange_light));
            binding.isGoing.setBackground(context.getResources().getDrawable(R.drawable.orange));
        }

        binding.tvTitleName.setText(content.getTitle());
        binding.isGoing.setText(content.getContainerStatusName());
        binding.location.setText(content.getCountryName() + "." + content.getCityName());
        binding.people.setText(content.getScanCount());
        binding.type.setText(content.getContainerTypeName());
        binding.status.setText(content.getStatusTypeName());
        binding.num.setText(content.getCount() + "个");
        Observable
                .interval(0, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(bindToLifecycle())
                .subscribe(aLong -> {
                    String countTime = Block.restTime(content.getDeadLineTime());
                    binding.restTime.setText(countTime);
                }, throwable -> {

                }, () -> {

                }, disposable -> {
                    String countTime = Block.restTime(content.getDeadLineTime());
                    if (countTime.isEmpty()) {
                        dialogFinish("交易记录已过期,请在列表中重新选择");
                        disposable.dispose();
                    } else {

                    }
                });

//		System.out.println("base---getPrice-->"+choosed.getPrice());
//		System.out.println("base---getSpecialPrice-->"+choosed.getSpecialPrice());

        binding.numChoosed.setText(choosed.getBidCount() + "个");
//		binding.priceChoosed.setText(choosed.getPrice() + "元");

        double priceVaule;
        if (!TextUtils.isEmpty(choosed.getSpecialPrice())) {
            priceVaule = Double.valueOf(choosed.getPrice()) - Double.valueOf(choosed.getSpecialPrice());
        } else {
            priceVaule = Double.valueOf(choosed.getPrice());
        }
        binding.priceChoosed.setText(NumberUtils.formatDouble(priceVaule) + "元");
        binding.specialChoosed.setText(choosed.getIsSpecialPrice().equals("1") ? "有特殊需求" : "无特殊需求");
        binding.specialPriceChoosed.setText(choosed.getSpecialPrice().isEmpty() ? "无" : choosed.getSpecialPrice() + "元");
        binding.invoiceChoosed.setText(choosed.getIsSupportBill().equals("1") ? "提供发票" : "不提供发票");
//		binding.allPrice.setText(Float.parseFloat(choosed.getPrice()) + Float.parseFloat(choosed.getIsSpecialPrice().equals("1") ? choosed.getSpecialPrice() : "0") + "元");
        binding.allPrice.setText(NumberUtils.formatDouble(Double.valueOf(choosed.getPrice())) + "元");

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


        //看是否提供发票
        if (choosed.getIsSupportBill().equals("1")) {
            binding.invoiceModel.setVisibility(View.VISIBLE);
            binding.view.setVisibility(View.GONE);
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
     * 购买
     */
    private void setBuy() {
        binding.buy.setOnClickListener(view -> {
            String head = binding.invoiceHead.getText().toString();
            String billNo = binding.invoiceContent.getText().toString();
            String bankName = binding.bankName.getText().toString();
            String bankIdText = binding.bankIdText.getText().toString();
            String etAdd = binding.etAdd.getText().toString();
            String invoicePhone = binding.invoicePhone.getText().toString();

            if (Verify.buyOrderBuy(binding.checkInvoice, isCheckedVaule, head, bankName, bankIdText, etAdd, invoicePhone, billNo)) {

                Intent i = new Intent(context, PayActivity.class);

                if (binding.checkInvoice.isChecked()) {

                    i.putExtra("head", head);
                    //提供发票
                    if (binding.personalCheck.isChecked()) {
                        i.putExtra("billType", "0");
                        i.putExtra("billName", "个人");
                    } else if (binding.companyCheck.isChecked()) {
                        i.putExtra("billType", "1");
                        i.putExtra("billName", "公司");
                        i.putExtra("billNo", billNo);
                        i.putExtra("bankName", bankName);
                        i.putExtra("bankIdText", bankIdText);
                        i.putExtra("etAdd", etAdd);
                        i.putExtra("invoicePhone", invoicePhone);
                    }
                }
                i.putExtra("orderType", "3");
                i.putExtra("checkInvoice", binding.checkInvoice.isChecked());
                i.putExtra("choosed", choosed);
                startAc(i);
            }
        });
        Log.e("sdjfl", "" + binding.checkInvoice.isChecked());
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
     * 定义banner的容器
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
