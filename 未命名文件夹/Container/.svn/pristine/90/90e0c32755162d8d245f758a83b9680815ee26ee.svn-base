package com.bm.container.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bm.container.R;


/**
 * 弹框dialog
 *
 * @author nfmomo
 */
public class AlertDialog extends Dialog {

    public AlertDialog(Context context) {
        super(context);
    }

    public AlertDialog(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {
        private Context context;
        private String title;
        private String content;
        private String positiveButtonText;
        private String negativeButtonText;
        private OnClickListener positiveButtonClickListener;
        private OnClickListener negativeButtonClickListener;

        private TextView tv_title;
        private TextView tv_content;
        private Button btn_positive;
        private Button btn_negative;
        private View v_btnline;

        private boolean mCancelable = true;
        private boolean gravity = false;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        /**
         * Sets whether the dialog is cancelable or not.  Default is true.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setCancelable(boolean cancelable) {
            this.mCancelable = cancelable;
            return this;
        }

        public Builder setContentGravity(boolean gravity) {
            this.gravity = gravity;
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

        public AlertDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final AlertDialog dialog = new AlertDialog(context, R.style.Dialog);
            dialog.setCancelable(mCancelable);
            View layout = inflater.inflate(R.layout.dialog_alert, null);

            tv_title = (TextView) layout.findViewById(R.id.tv_alert_title);
            tv_content = (TextView) layout.findViewById(R.id.tv_alert_content);
            btn_positive = (Button) layout.findViewById(R.id.btn_alert_positive);
            btn_negative = (Button) layout.findViewById(R.id.btn_alert_negative);
            v_btnline = layout.findViewById(R.id.v_btnline);

            if (title != null) {
                tv_title.setText(title);
            } else {
                tv_title.setVisibility(View.GONE);
            }

            if (gravity) {
                tv_content.setGravity(Gravity.LEFT);
                tv_content.setTextSize(12);
            }
            tv_content.setText(content);

            if (positiveButtonText != null) {
                btn_positive.setText(positiveButtonText);
                if (positiveButtonClickListener != null) {
                    btn_positive.setOnClickListener(v -> positiveButtonClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE));
                }
            } else {
                btn_positive.setVisibility(View.GONE);
                v_btnline.setVisibility(View.GONE);
            }
            if (negativeButtonText != null) {
                btn_negative.setText(negativeButtonText);
                if (negativeButtonClickListener != null) {
                    btn_negative.setOnClickListener(v -> negativeButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE));
                }
            } else {
                v_btnline.setVisibility(View.GONE);
                btn_negative.setVisibility(View.GONE);
            }

            dialog.setContentView(layout);
            return dialog;
        }

    }
}
