package com.bm.container.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bm.container.R;
import com.bm.container.module.market.bean.OfferBuyBean;

/**
 * Created by kec on 2017/7/11.
 */

public class CommodityDetailsAlertDialog extends Dialog {


    public CommodityDetailsAlertDialog(Context context) {
        super(context);
    }


    public CommodityDetailsAlertDialog(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {

        private final Context context;
        private String title;
        private String content;
        private boolean mCancelable = true;
        private TextView tv_title;
        private TextView tvHintContent;
        private LinearLayout invoiceLinearLayout;
        private Button btn_positive;
        private Button btn_negative;
        private LinearLayout llinvoiceInfo;
        private TextView tvType;
        private TextView companyName;
        private TextView identificationNumber;
        private TextView bankName;
        private TextView bankNumber;
        private TextView companyAdd;
        private TextView companyPhone;
        private String positiveButtonText;
        private OnClickListener positiveButtonClickListener;
        private String negativeButtonText;
        private OnClickListener negativeButtonClickListener;
        private boolean isShowHint;
        private boolean isShowView;
        private OfferBuyBean beanItem;
        private LinearLayout llHintContent;


        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setIsShowHint(boolean isShowHint) {
            this.isShowHint = isShowHint;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setIsShowView(boolean isShowView) {
            this.isShowView = isShowView;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonText, OnClickListener listener) {
            this.positiveButtonText = positiveButtonText;
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonText, OnClickListener listener) {
            this.negativeButtonText = negativeButtonText;
            this.negativeButtonClickListener = listener;
            return this;
        }

        public Builder setInitView(OfferBuyBean beanItem) {
            this.beanItem = beanItem;
            return this;
        }


        public CommodityDetailsAlertDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final CommodityDetailsAlertDialog dialog = new CommodityDetailsAlertDialog(context, R.style.Dialog);
            dialog.setCancelable(mCancelable);
            View layout = inflater.inflate(R.layout.commodity_details_alertdialog, null);

            tv_title = (TextView) layout.findViewById(R.id.tv_alert_title);
            tvHintContent = (TextView) layout.findViewById(R.id.tvHintContent);
            llHintContent = (LinearLayout) layout.findViewById(R.id.llHintContent);
            invoiceLinearLayout = (LinearLayout) layout.findViewById(R.id.invoiceLinearLayout);
            tvType = (TextView) layout.findViewById(R.id.tvType);
            companyName = (TextView) layout.findViewById(R.id.companyName);
            identificationNumber = (TextView) layout.findViewById(R.id.identificationNumber);
            bankName = (TextView) layout.findViewById(R.id.bankName);
            bankNumber = (TextView) layout.findViewById(R.id.bankNumber);
            companyAdd = (TextView) layout.findViewById(R.id.companyAdd);
            companyPhone = (TextView) layout.findViewById(R.id.companyPhone);
            llinvoiceInfo = (LinearLayout) layout.findViewById(R.id.llinvoiceInfo);


            btn_positive = (Button) layout.findViewById(R.id.btn_alert_positive);
            btn_negative = (Button) layout.findViewById(R.id.btn_alert_negative);

            if (title != null) {
                tv_title.setText(title);
            } else {
                tv_title.setText("提示");
            }

            invoiceLinearLayout.setVisibility(View.GONE);//不显示发票信息
            if (isShowHint) {
                tvHintContent.setVisibility(View.VISIBLE);
                llHintContent.setVisibility(View.GONE);
            } else {
                tvHintContent.setVisibility(View.GONE);
                llHintContent.setVisibility(View.VISIBLE);
            }

            if (isShowView) {
                llinvoiceInfo.setVisibility(View.VISIBLE);
            } else {
                llinvoiceInfo.setVisibility(View.GONE);
            }


            if (positiveButtonText != null) {
                btn_positive.setText(positiveButtonText);
                if (positiveButtonClickListener != null) {
                    btn_positive.setOnClickListener(v -> positiveButtonClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE));
                }
            } else {
                btn_positive.setVisibility(View.GONE);
            }
            if (negativeButtonText != null) {
                btn_negative.setText(negativeButtonText);
                if (negativeButtonClickListener != null) {
                    btn_negative.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            negativeButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                        }
                    });
                }
            } else {
                btn_negative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }

            if (null != beanItem) {
                tvType.setText(beanItem.getBillTypeName());
                if (!TextUtils.isEmpty(beanItem.getBillCheque())) {
                    companyName.setText(beanItem.getBillCheque());
                } else {
                    companyName.setText(beanItem.getBillContent());
                }

                identificationNumber.setText(beanItem.getBillType());
                bankName.setText(beanItem.getBillAccountSource());
                bankNumber.setText(beanItem.getBillBankAccount());
                companyAdd.setText(beanItem.getBillAddress());
                companyPhone.setText(beanItem.getBillTelephone());
            }

            dialog.setContentView(layout);
            return dialog;
        }

    }

}

