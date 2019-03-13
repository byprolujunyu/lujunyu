package com.luck.pictureselector;

import android.app.Dialog;
import android.content.Context;

public class DialogUtils {
    static Dialog dialog;

    public static void show(Context context) {
        dialog = new NewLoadDialog(context, false, "正在加载中...");
        dialog.show();
    }

    public static void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
