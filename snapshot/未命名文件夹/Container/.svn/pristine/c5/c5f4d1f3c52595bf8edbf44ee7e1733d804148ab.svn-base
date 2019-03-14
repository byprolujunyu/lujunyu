package com.bm.container.view;

import android.app.Dialog;
import android.content.Context;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bm.container.R;

/**
 * Created by nfmomo on 17/5/9.
 */

public class OrderNoDialog extends Dialog {
    public OrderNoDialog(Context context) {
        super(context);
    }

    public OrderNoDialog(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {
        private Context context;
        private String title;
        private String content;
        private String positiveButtonText;
        private String negativeButtonText;

        private EditText input;
        private TextView tv_title;
        private Button btn_positive;
        private Button btn_negative;
        private View v_btnline;
        private GetContent positiveContent;
        private GetContent negativeContent;
        private TextView tv_alert_content;
        private boolean isShow = true;


        public interface GetContent {
            void getContent(String content, OrderNoDialog dialog);
        }

        public Builder(Context context) {
            this.context = context;
        }

        public OrderNoDialog.Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public OrderNoDialog.Builder setPositiveButton(GetContent content) {
            this.positiveContent = content;
            return this;
        }

        public OrderNoDialog.Builder setNegativeButton(GetContent content) {
            this.negativeContent = content;
            return this;
        }

        public OrderNoDialog.Builder setIsShow(boolean isShow) {
            this.isShow = isShow;
            return this;
        }

        public OrderNoDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final OrderNoDialog dialog = new OrderNoDialog(context, R.style.Dialog);
            View layout = inflater.inflate(R.layout.dialog_order_no, null);

            input = (EditText) layout.findViewById(R.id.input);
            tv_alert_content = (TextView) layout.findViewById(R.id.tv_alert_content);
            tv_title = (TextView) layout.findViewById(R.id.tv_alert_title);
            btn_positive = (Button) layout.findViewById(R.id.btn_alert_positive);
            btn_negative = (Button) layout.findViewById(R.id.btn_alert_negative);
            v_btnline = layout.findViewById(R.id.v_btnline);

            if (isShow) {
                tv_alert_content.setVisibility(View.VISIBLE);
            } else {
                tv_alert_content.setVisibility(View.GONE);
                input.setHint("请输入邮箱");
                input.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
            }

            if (title != null) {
                tv_title.setText(title);
            } else {
                tv_title.setVisibility(View.GONE);
            }


            btn_positive.setOnClickListener(v -> {
                if (positiveContent != null) {
                    positiveContent.getContent(input.getText().toString(), dialog);
                }
            });


            btn_negative.setOnClickListener(v -> {
                if (negativeContent != null) {
                    negativeContent.getContent(input.getText().toString(), dialog);
                }
            });


            dialog.setContentView(layout);
            return dialog;
        }

    }

}
