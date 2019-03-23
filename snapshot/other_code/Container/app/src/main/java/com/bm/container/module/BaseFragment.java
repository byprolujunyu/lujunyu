package com.bm.container.module;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toast;

import com.bm.container.R;
import com.bm.container.constants.ConstantsTag;
import com.bm.container.module.login.LoginActivity;
import com.bm.container.view.AlertDialog;
import com.bm.container.view.EmptyDialog;
import com.trello.rxlifecycle2.components.support.RxFragment;

import org.simple.eventbus.EventBus;

/**
 * Created by nfmomo on 17/2/27.
 */

public class BaseFragment extends RxFragment {

    private int loadingColor1;
    private int loadingColor2;
    private int loadingColor3;
    protected int[] loadingColors;
    private SwipeRefreshLayout swipeRefreshLayout;
    private EmptyDialog alert;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            EventBus.getDefault().register(this);
        } catch (NoClassDefFoundError ignored) {
        }
        initLoadingColor();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            EventBus.getDefault().register(this);
        } catch (NoClassDefFoundError ignored) {
        }
    }

    /**
     * 这里定义了loading的彩色效果
     */
    public void initLoadingColor() {
        loadingColor1 = getResources().getColor(R.color.colorPrimary);
        loadingColor2 = getResources().getColor(R.color.orange);
        loadingColor3 = getResources().getColor(R.color.grey_deep);
        loadingColors = new int[]{loadingColor1, loadingColor2, loadingColor3};
    }

    public void toast(String content) {
        Toast.makeText(getActivity(), content, Toast.LENGTH_SHORT).show();
    }

    public void toast(int content) {
        Toast.makeText(getActivity(), String.valueOf(content), Toast.LENGTH_SHORT).show();
    }

    /**
     * 带动画的跳转
     */
    public void startAc(Intent intent) {
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.activity_open_in, R.anim.activity_open_out);
    }

    /**
     * 带动画的跳转
     */
    public void startAcForResult(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode);
        getActivity().overridePendingTransition(R.anim.activity_open_in, R.anim.activity_open_out);
    }

    /**
     * 带动话的结束
     */
    public void finishAc() {
        getActivity().finish();
        getActivity().overridePendingTransition(R.anim.activity_close_in, R.anim.activity_close_out);
    }

    public void setLoading(SwipeRefreshLayout layout) {
        swipeRefreshLayout = layout;
    }

    public void showLoading() {
        if (swipeRefreshLayout != null && !swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(true);
            if (alert == null) {
                alert = new EmptyDialog.Builder(getActivity())// builder
                        .create();
            }
            alert.show();
        }
    }

    public void hideLoading() {
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
            if (alert.isShowing()) {
                alert.hide();
            }
        }
    }

    /**
     * 结束弹框
     */
    public void dialogFinish(String message) {
        AlertDialog alert = new AlertDialog.Builder(getActivity())// builder
                .setContent(message) //TODO 内容
                .setPositiveButton("确定", (mdialog, which) -> {
                    mdialog.dismiss();
                    finishAc();
                })
                .create();
        alert.show();
    }

    /**
     * 通知弹框
     *
     * @param message
     */
    public void dialog(String message) {
        AlertDialog alert = new AlertDialog.Builder(getActivity())// builder
                .setContent(message) //TODO 内容
                .setPositiveButton("确定", (mdialog, which) -> {
                    mdialog.dismiss();
                })
                .create();
        alert.show();
    }

    public void dialog(String message, boolean gravity) {
        AlertDialog alert = new AlertDialog.Builder(getActivity())// builder
                .setContent(message) //TODO 内容
                .setContentGravity(gravity)//内容居左显示
                .setPositiveButton("确定", (mdialog, which) -> {
                    mdialog.dismiss();
                })
                .create();
        alert.show();
    }

    /**
     * 登录弹框
     */
    public void dialogLogin() {
        AlertDialog alert = new AlertDialog.Builder(getActivity())// builder
                .setContent("您还未登录，请先去登录！")
                .setCancelable(false)
                .setPositiveButton("确定", (mdialog, which) -> {
                    mdialog.dismiss();
                    EventBus.getDefault().post("isFalse", ConstantsTag.IS_LOGIN_FALSE);
                    Intent i = new Intent(getActivity(), LoginActivity.class);
                    startAc(i);
                }).create();
        alert.show();
    }

}
