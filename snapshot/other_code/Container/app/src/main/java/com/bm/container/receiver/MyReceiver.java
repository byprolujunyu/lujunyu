package com.bm.container.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.bm.container.Tools.Block;
import com.bm.container.Tools.NetHelper;
import com.bm.container.Tools.SpUtil;
import com.bm.container.module.base.MainActivity;
import com.bm.container.module.market.PurchaseAActivity;
import com.bm.container.module.market.SaleBActivity;
import com.bm.container.module.personal.BillOfLadingActivity;
import com.bm.container.module.personal.MessageActivity;
import com.bm.container.module.personal.MyOrderActivity;

import cn.jpush.android.api.JPushInterface;

import org.json.JSONObject;

/**
 * 自定义接收器
 * <p/>
 * nfmomo
 */
public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "极光推送";


    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
            SpUtil.setString(SpUtil.REGID, regId);
            Log.e(TAG, "注册成功--ID" + regId);
            verifyAll(context, bundle);

        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            Log.e(TAG, "自定义消息");
            verifyDefineMsg(context, bundle);

        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            Log.e(TAG, "通知");
            verifyNotification(context, bundle);
        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            Log.e(TAG, "点击推送");
            verifyAll(context, bundle);
            startIntent(context, bundle);
        } else {
            Log.e(TAG, "其他情况");
            verifyAll(context, bundle);
        }
    }

    private void verifyNotification(Context context, Bundle bundle) {
        String notificationTitle = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        Log.e(TAG, "EXTRA_NOTIFICATION_TITLE:" + notificationTitle);
        String alert = bundle.getString(JPushInterface.EXTRA_ALERT);
        Log.e(TAG, "EXTRA_ALERT:" + alert);
        String extra = bundle.getString(JPushInterface.EXTRA_EXTRA);
        Log.e(TAG, "EXTRA_EXTRA:" + extra);
    }

    private void verifyDefineMsg(Context context, Bundle bundle) {
        String title = bundle.getString(JPushInterface.EXTRA_TITLE);
        Log.e(TAG, "EXTRA_TITLE:" + title);
        String message = bundle.getString(JPushInterface.EXTRA_MESSAGE);
        Log.e(TAG, "EXTRA_MESSAGE:" + message);
        String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
        Log.e(TAG, "EXTRA_EXTRA:" + extras);
    }

    private void verifyAll(Context context, Bundle bundle) {

        String notificationTitle = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        Log.e(TAG, "EXTRA_NOTIFICATION_TITLE:" + notificationTitle);
        String alert = bundle.getString(JPushInterface.EXTRA_ALERT);
        Log.e(TAG, "EXTRA_ALERT:" + alert);
        String title = bundle.getString(JPushInterface.EXTRA_TITLE);
        Log.e(TAG, "EXTRA_TITLE:" + title);
        String message = bundle.getString(JPushInterface.EXTRA_MESSAGE);
        Log.e(TAG, "EXTRA_MESSAGE:" + message);
        String extra = bundle.getString(JPushInterface.EXTRA_EXTRA);
        Log.e(TAG, "EXTRA_EXTRA:" + extra);
    }


    private void startIntent(Context context, Bundle bundle) {

        try {
            String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
            JSONObject extraJson = new JSONObject(extras);
            int type = 0;
            String orderNo = "";
            String containerId = "";
            String cType = "";
            if (extraJson.has("type") && !TextUtils.isEmpty(extraJson.getString("type"))) {
                type = Integer.valueOf(extraJson.getString("type"));
            }
            if (extraJson.has("orderNo") && !TextUtils.isEmpty(extraJson.getString("orderNo"))) {
                orderNo = extraJson.getString("orderNo");
            }
            if (extraJson.has("containerId") && !TextUtils.isEmpty(extraJson.getString("containerId"))) {
                containerId = extraJson.getString("containerId");
            }
            if (extraJson.has("cType") && !TextUtils.isEmpty(extraJson.getString("cType"))) {
                cType = extraJson.getString("cType");
            }

            System.out.println("base-----type---->" + type);
            System.out.println("base-----orderNo---->" + orderNo);
            System.out.println("base-----containerId---->" + containerId);
            System.out.println("base-----cType---->" + cType);

            //1.跳转卖家提货单-卖家填写提货单
            // 2跳转订单列表-买家填写提货单
            // 3跳转卖家提货单-查看提货单

            Intent intent = new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            switch (type) {
                case 0://系统消息
                    intent.setClass(context, MessageActivity.class);
                    context.startActivity(intent);
                    break;
                case 1://卖家填写提货单
                    intent.setClass(context, BillOfLadingActivity.class);
                    intent.putExtra("type", "2");
                    intent.putExtra("orderNo", orderNo);
                    context.startActivity(intent);
                    break;
                case 2://买家填写提货单
                    intent.setClass(context, BillOfLadingActivity.class);
                    intent.putExtra("type", "0");
                    intent.putExtra("orderNo", orderNo);
                    context.startActivity(intent);
                    break;
                case 3://查看提货单
                    intent.setClass(context, BillOfLadingActivity.class);
                    intent.putExtra("type", "1");
                    intent.putExtra("orderNo", orderNo);
                    context.startActivity(intent);
                    break;
                case 4://我的订单
                    intent.setClass(context, MyOrderActivity.class);
                    context.startActivity(intent);
                    break;
                case 5://发布求购
//                    intent.setClass(context, PurchaseAActivity.class);
//                    intent.putExtra("containerId", containerId);
//                    context.startActivity(intent);
                    if (cType.equals("0")) {
                        intent.setClass(context, PurchaseAActivity.class);
                        intent.putExtra("containerId", containerId);

                    } else {
                        intent = new Intent(context, SaleBActivity.class);//出价
                        intent.putExtra("containerId", containerId);
                    }
                    context.startActivity(intent);
                    break;
                default:
                    break;
            }


//				if (extraJson.length() != 0) {
//					String testStatus = extraJson.get("testStatus").toString();
//					if (testStatus.equals("10")) {
//						SpUtil.setString(context, SpUtil.BODY, "10");
//					} else if (testStatus.equals("20")) {
//						SpUtil.setString(context, SpUtil.BODY, "20");
//					} else if (testStatus.equals("30")) {
//						SpUtil.setString(context, SpUtil.BODY, "30");
//					} else if (testStatus.equals("40")) {
//						SpUtil.setString(context, SpUtil.BODY, "40");
//					} else {
//						//如果推送值非约定,不能覆盖原有状态
//					}
//				}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
