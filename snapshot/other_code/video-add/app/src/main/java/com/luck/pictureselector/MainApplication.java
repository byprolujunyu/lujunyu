//package com.luck.pictureselector;
//
//import android.app.Application;
//
//import com.alibaba.sdk.android.oss.ClientConfiguration;
//import com.alibaba.sdk.android.oss.OSS;
//import com.alibaba.sdk.android.oss.OSSClient;
//import com.alibaba.sdk.android.oss.common.OSSLog;
//import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
//import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
//
///**
// * Created by toplu1015 on 2018/5/23.
// */
//
//public class MainApplication extends Application
//{
//
//    public static OSS oss;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        initOSSConfig();
//    }
//
//    private void initOSSConfig(){
//        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(accessKey, screctKey);
//
//        ClientConfiguration conf = new ClientConfiguration();
//        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒
//        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒
//        conf.setMaxConcurrentRequest(5); // 最大并发请求书，默认5个
//        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次
//        if(BuildConfig.DEBUG){
//            OSSLog.enableLog();
//        }
//        oss = new OSSClient(getApplicationContext(), MainApplication.OSS_BUCKET_HOST_ID, credentialProvider, conf);
//    }
//}
