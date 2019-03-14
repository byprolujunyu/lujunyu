package com.luck.pictureselector;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Map;

public abstract class BaseActivity extends AppCompatActivity {

    protected Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(getResourceId());
        setView();
        setData();
        setOperation();
    }

    protected abstract void setView();

    protected abstract void setOperation();

    protected abstract void setData();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    protected abstract int getResourceId();

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            onHandleMsg(msg);
            return false;
        }
    });

    protected Map<String, String> createMap(String[] keys, String[] values) {

        return OkHttpUtils.createMap(keys, values);
    }

    protected void getData(final int what, String uri, Map<String, String> params) {
        OkHttpUtils.postNetwork(uri, OkHttpUtils.createParams(params), new OkHttpUtils.OkHttpCallBack() {
            @Override
            public void onSuccess(String name) {
                Message msg = Message.obtain();
                msg.obj = name;
                msg.what = what;
                mHandler.sendMessage(msg);
            }

            @Override
            public void onFailed(Exception e) {
                Message msg = Message.obtain();
                msg.obj = e.getMessage();
                msg.what = what;
                mHandler.sendMessage(msg);
            }
        });
    }

    protected abstract void onHandleMsg(Message msg);
}
