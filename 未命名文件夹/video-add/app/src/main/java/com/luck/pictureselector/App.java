package com.luck.pictureselector;

import android.app.Application;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;


/**
 * author：luck
 * project：PictureSelector
 * package：com.luck.pictureselector
 * email：893855882@qq.com
 * data：2017/4/29
 */

public class App extends Application {
    private static ImageLoaderConfiguration configuration;
    private static DisplayImageOptions options;
    public static OSS oss;
    //OSS的Bucket
    public static final String OSS_BUCKET = "oss-toplu1015";
    //设置OSS数据中心域名或者cname域名
    public static final String OSS_BUCKET_HOST_ID = "oss-toplu1015.oss-cn-hangzhou.aliyuncs.com";
    //Key
    private static final String accessKey = "LTAI1hHwGmsLvt2j";
    private static final String screctKey = "ZUsmXEyBmR9pZT7mog8S7ktuwit1ou";

    @Override
    public void onCreate() {
        super.onCreate();
        initOSSConfig();
        setInitImageLoader();
    }

    /**
     * 初始化图片加载器
     */
    private void setInitImageLoader() {
        configuration = ImageLoaderConfiguration.createDefault(this);
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.moren_1) //设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.drawable.moren_1)//设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.moren_1)  //设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中
                .bitmapConfig(Bitmap.Config.RGB_565)//默认是ARGB_8888，使用RGB_565会比使用ARGB_8888少消耗2倍的内。
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)//设置图片以如何的编码方式显示
                .displayer(new FadeInBitmapDisplayer(100))//是否图片加载好后渐入的动画时间
                .build();
        ImageLoader.getInstance().init(configuration);
    }


    private void initOSSConfig() {
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(accessKey, screctKey);
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒
        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒
        conf.setMaxConcurrentRequest(5); // 最大并发请求书，默认5个
        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次
        if (BuildConfig.DEBUG) {
            OSSLog.enableLog();
        }
        oss = new OSSClient(getApplicationContext(), App.OSS_BUCKET_HOST_ID, credentialProvider, conf);
    }

    /**
     * 获得图片
     *
     * @param url
     * @param imageView
     */
    public static void getBitmap(String url, ImageView imageView) {
        ImageLoader.getInstance().displayImage(url, imageView, options);
    }

    /**
     * 获得图片and回调
     *
     * @param url
     * @param imageView
     */
    public static void getBitmap(String url, ImageView imageView, ImageLoadingListener listener) {
        ImageLoader.getInstance().displayImage(url, imageView, listener);
    }

    /**
     * 销毁图片加载器数据
     */
    public static void removeBitmap() {
        ImageLoader.getInstance().clearDiskCache();
        ImageLoader.getInstance().clearMemoryCache();
    }
}
