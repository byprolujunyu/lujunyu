//package com.luck.pictureselector;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.view.Display;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.WindowManager;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
///**
// * Created by toplu1015 on 2018/2/19.
// */
//
//public abstract class AlertDialog_Input {
//    private Context context;
//    private Dialog dialog;
//    private LinearLayout lLayout_bg;
//    private TextView txt_title;
//    private TextView txt_msg;
//    private Button btn_neg;
//    private Button btn_pos;
//    private ImageView img_line;
//    private Display display;
//    private boolean showTitle = false;
//    private boolean showMsg = false;
//    private boolean showPosBtn = false;
//    private boolean showNegBtn = false;
//
//    public AlertDialog_Input(Context context) {
//        this.context = context;
//        WindowManager windowManager = (WindowManager) context
//                .getSystemService(Context.WINDOW_SERVICE);
//        display = windowManager.getDefaultDisplay();
//    }
//
//    public AlertDialog_Input builder() {
//        // 获取Dialog布局
//        View view = LayoutInflater.from(context).inflate(
//                R.layout.view_alertdialog, null);
//
//        // 获取自定义Dialog布局中的控件
//        lLayout_bg = (LinearLayout) view.findViewById(R.id.lLayout_bg);
//        txt_title = (TextView) view.findViewById(R.id.txt_title);
//        txt_title.setVisibility(View.GONE);
//        txt_msg = (TextView) view.findViewById(R.id.txt_msg);
//        txt_msg.setVisibility(View.GONE);
//        btn_neg = (Button) view.findViewById(R.id.btn_neg);
//        btn_neg.setVisibility(View.GONE);
//        btn_pos = (Button) view.findViewById(R.id.btn_pos);
//        btn_pos.setVisibility(View.GONE);
//        img_line = (ImageView) view.findViewById(R.id.img_line);
//        img_line.setVisibility(View.GONE);
//
//        // 定义Dialog布局和参数
//        dialog = new Dialog(context, R.style.AlertDialogStyle);
//        dialog.setContentView(view);
//
//        // 调整dialog背景大小
//        lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display
//                .getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));
//
//        return this;
//    }
//
//    public EditText myInputBuilder() {
//        View view = LayoutInflater.from(context).inflate(
//                R.layout.view_alertdialog_input, null);
//        LinearLayout layout = (LinearLayout) view.findViewById(R.id.lLayout_bg);
//        final EditText etmsg = (EditText) view.findViewById(R.id.txt_et);
//        Button sure = (Button) view.findViewById(R.id.btn_pos);
//        Button cancel = (Button) view.findViewById(R.id.btn_neg);
//
//        sure.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                sureOnClick(v, etmsg.getText().toString().trim());
//            }
//        });
//        cancel.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        layout.setLayoutParams(new FrameLayout.LayoutParams((int) (display
//                .getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));
//        dialog = new Dialog(context, R.style.AlertDialogStyle);
//        dialog.setContentView(view);
//        myShow();
//        return etmsg;
//    }
//
//    public EditText write() {
//        View view = LayoutInflater.from(context).inflate(
//                R.layout.view_alertdialog_write, null);
//        LinearLayout layout = (LinearLayout) view.findViewById(R.id.lLayout_bg);
//        final EditText etmsg = (EditText) view.findViewById(R.id.txt_et);
//        Button sure = (Button) view.findViewById(R.id.btn_pos);
//        Button cancel = (Button) view.findViewById(R.id.btn_neg);
//
//        sure.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                sureOnClick(v, etmsg.getText().toString().trim());
//            }
//        });
//        cancel.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        layout.setLayoutParams(new FrameLayout.LayoutParams((int) (display
//                .getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));
//        dialog = new Dialog(context, R.style.AlertDialogStyle);
//        dialog.setContentView(view);
//        myShow();
//        return etmsg;
//    }
//
//    public abstract void sureOnClick(View v, String string);
//
//    /**
//     * 归还钥匙布局dialog
//     *
//     * @param l  确认点击监听
//     * @param l2 取消点击监听
//     * @return 返回diglog本身
//     */
//    public AlertDialog_Input myBuilder(View.OnClickListener l, View.OnClickListener l2) {
//        View view = LayoutInflater.from(context).inflate(
//                R.layout.dialog_key_style, null);
//
//        LinearLayout layout = (LinearLayout) view.findViewById(R.id.mainLayout);
//        Button sure = (Button) view.findViewById(R.id.sure);
//        Button cancel = (Button) view.findViewById(R.id.cancel);
//        ImageView close = (ImageView) view.findViewById(R.id.close);
//
//        sure.setOnClickListener(l);
//        cancel.setOnClickListener(l2);
//        close.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog = new Dialog(context, R.style.AlertDialogStyle);
//        dialog.setContentView(view);
//        layout.setLayoutParams(new FrameLayout.LayoutParams((int) (display
//                .getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));
//        return this;
//    }
//
//    public AlertDialog_Input setTitle(String title) {
//        showTitle = true;
//        if ("".equals(title)) {
//            txt_title.setText("标题");
//        } else {
//            txt_title.setText(title);
//        }
//        return this;
//    }
//
//    public AlertDialog_Input setMsg(String msg) {
//        showMsg = true;
//        if ("".equals(msg)) {
//            txt_msg.setText("内容");
//        } else {
//            txt_msg.setText(msg);
//        }
//        return this;
//    }
//
//    public AlertDialog_Input setCancelable(boolean cancel) {
//        dialog.setCancelable(cancel);
//        return this;
//    }
//
//    public AlertDialog_Input setPositiveButton(String text,
//                                               final View.OnClickListener listener) {
//        showPosBtn = true;
//        if ("".equals(text)) {
//            btn_pos.setText("确定");
//        } else {
//            btn_pos.setText(text);
//        }
//        btn_pos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onClick(v);
//                dialog.dismiss();
//            }
//        });
//        return this;
//    }
//
//    public AlertDialog_Input setNegativeButton(String text,
//                                               final View.OnClickListener listener) {
//        showNegBtn = true;
//        if ("".equals(text)) {
//            btn_neg.setText("取消");
//        } else {
//            btn_neg.setText(text);
//        }
//        btn_neg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onClick(v);
//                dialog.dismiss();
//            }
//        });
//        return this;
//    }
//
//    private void setLayout() {
//
//        try {
//            if (!showTitle && !showMsg) {
//                txt_title.setText("提示");
//                txt_title.setVisibility(View.VISIBLE);
//            }
//
//            if (showTitle) {
//                txt_title.setVisibility(View.VISIBLE);
//            }
//
//            if (showMsg) {
//                txt_msg.setVisibility(View.VISIBLE);
//            }
//
//            if (!showPosBtn && !showNegBtn) {
//                btn_pos.setText("确定");
//                btn_pos.setVisibility(View.VISIBLE);
//                btn_pos.setBackgroundResource(R.drawable.alertdialog_single_selector);
//                btn_pos.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.dismiss();
//                    }
//                });
//            }
//
//            if (showPosBtn && showNegBtn) {
//                btn_pos.setVisibility(View.VISIBLE);
//                btn_pos.setBackgroundResource(R.drawable.alertdialog_right_selector);
//                btn_neg.setVisibility(View.VISIBLE);
//                btn_neg.setBackgroundResource(R.drawable.alertdialog_left_selector);
//                img_line.setVisibility(View.VISIBLE);
//            }
//
//            if (showPosBtn && !showNegBtn) {
//                btn_pos.setVisibility(View.VISIBLE);
//                btn_pos.setBackgroundResource(R.drawable.alertdialog_single_selector);
//            }
//
//            if (!showPosBtn && showNegBtn) {
//                btn_neg.setVisibility(View.VISIBLE);
//                btn_neg.setBackgroundResource(R.drawable.alertdialog_single_selector);
//            }
//
//        } catch (OutOfMemoryError e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void show() {
//        setLayout();
//        dialog.show();
//    }
//
//    public void myShow() {
//        dialog.show();
//    }
//
//    public void dismiss() {
//        dialog.dismiss();
//    }
//}
