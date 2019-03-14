package com.bm.container.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.bm.container.Tools.SpUtil;
import com.bm.container.constants.ConstantsTag;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.market.PaySuccessActivity;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.simple.eventbus.EventBus;


public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler, OnClickListener {

    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        api = WXAPIFactory.createWXAPI(this, Constants.APP_ID);

        api.handleIntent(getIntent(), this);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {// 支付回调结果

        if (resp.errCode == BaseResp.ErrCode.ERR_OK) {
            SpUtil.setString(SpUtil.ISPAYED, "1");
//			Toast.makeText(this, "支付成功", Toast.LENGTH_LONG).show();
            EventBus.getDefault().post("payActiviyFinish", ConstantsTag.PAY_ACTIVIY_FINISH);
            Intent i = new Intent(this, PaySuccessActivity.class);
            startActivity(i);
        } else if (resp.errCode == BaseResp.ErrCode.ERR_USER_CANCEL) {
            SpUtil.setString(SpUtil.ISPAYED, "0");
            EventBus.getDefault().post("cancelPay", ConstantsTag.PAY_ACTIVIY_FINISH);
//			Toast.makeText(this, "支付取消", Toast.LENGTH_LONG).show();
        } else {
            SpUtil.setString(SpUtil.ISPAYED, "0");
            EventBus.getDefault().post("cancelPay", ConstantsTag.PAY_ABOLISH_FINISH);
//			Toast.makeText(this, "支付失败", Toast.LENGTH_LONG).show();
        }
        finish();

    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        finish();
    }
}