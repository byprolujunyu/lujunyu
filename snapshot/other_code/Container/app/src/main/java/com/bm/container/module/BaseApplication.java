package com.bm.container.module;

import android.app.Application;
import android.content.Context;

import cn.jpush.android.api.JPushInterface;
import io.realm.Realm;

/**
 * Created by nfmomo on 16/12/21.
 */

public class BaseApplication extends Application {
    public static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        Realm.init(this);
        // 极光推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
