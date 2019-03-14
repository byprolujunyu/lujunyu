package com.luck.pictureselector;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

/**
 * Created by toplu1015 on 2018/4/26.
 */

public class Upload implements Runnable {

    interface VideoCallBack {

        void notification(String result);

    }

    private String uri;
    private Context context;
    private String path;
    private String mytime;
    private String usercode;
    private VideoCallBack back;

    public Upload(String uri, Context context, VideoCallBack back) {
        super();
        this.uri = uri;
        this.context = context;
        this.back = back;

    }

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            return false;
        }
    });

    @Override
    public void run() {


//        getBitmapsFromVideo();

    }


}
