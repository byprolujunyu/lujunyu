package com.luck.pictureselector;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by toplu1015 on 2018/5/23.
 */

public class UploadFileVideo extends Thread {
    private String md5;
    private String fileName;
    private String randomStr;
    String filpath;
    Context context;
    private String path;
    private String mytime;
    private String filePicName;
    private String usercode;
    private VideoCallBack back;
    String name = "http://oss-toplu1015.oss-cn-hangzhou.aliyuncs.com/";
    private Handler mHandler;

    public void setmHandler(Handler mHandler) {
        this.mHandler = mHandler;
    }

    /**
     * @param filpath 视频文件地址
     * @param context
     */
    public UploadFileVideo(String filpath, Context context) {
        this.filpath = filpath;
        this.context = context;
        try {
            this.md5 = Base64Utils.getMd5ByFile(new File(filpath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        randomStr = java.util.UUID.randomUUID().toString();
        fileName = "video/" + randomStr + ".mp4";
        filePicName = "picture/" + randomStr + ".jpg";
    }

    public VideoCallBack getBack() {
        return back;
    }

    public void setBack(VideoCallBack back) {
        this.back = back;
    }

    public interface VideoCallBack {
        void onSuccess(String name, String picName, String md5);

        void onFailure();
    }

    @Override
    public void run() {
        String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId = "LTAI1hHwGmsLvt2j";
        String accessKeySecret = "ZUsmXEyBmR9pZT7mog8S7ktuwit1ou";

        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(
                accessKeyId, accessKeySecret);

        OSS oss = new OSSClient(context.getApplicationContext(), endpoint,
                credentialProvider);
        path = getBitmapsFromVideo(filpath);
        PutObjectRequest put = new PutObjectRequest("oss-toplu1015", fileName, filpath);
        PutObjectRequest putpic = new PutObjectRequest("oss-toplu1015", filePicName, path);
        try {
            PutObjectResult putResult = oss.putObject(put);
            PutObjectResult putResult2 = oss.putObject(putpic);

            App.oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {

                @Override
                public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {

                }

                @Override
                public void onFailure(PutObjectRequest putObjectRequest, ClientException e, ServiceException e1) {

                }
            });
            put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
                @Override
                public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                    Log.d("PutObject", "currentSize: " + currentSize + " totalSize: " + totalSize);
                }
            });

            handler.sendEmptyMessage(0x123);
            Log.d("PutObject", "UploadSuccess");
            Log.d("ETag", putResult.getETag());
            Log.d("RequestId", putResult.getRequestId());
        } catch (ServiceException e) {
            e.printStackTrace();
            if (back != null) {
                back.onFailure();
            }
        } catch (ClientException e) {
            e.printStackTrace();
            if (back != null) {
                back.onFailure();
            }
        }
    }

    public static String getMD5Three(String path) {
        BigInteger bi = null;
        try {
            byte[] buffer = new byte[8192];
            int len = 0;
            MessageDigest md = MessageDigest.getInstance("MD5");
            File f = new File(path);
            FileInputStream fis = new FileInputStream(f);
            while ((len = fis.read(buffer)) != -1) {
                md.update(buffer, 0, len);
            }
            fis.close();
            byte[] b = md.digest();
            bi = new BigInteger(1, b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi.toString(16);


    }

    public String MD5() {
        return getMD5Three(filpath);
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Toast.makeText(context, "uploadsuccess", Toast.LENGTH_SHORT).show();
            if (back != null) {
                back.onSuccess(name + fileName, name + filePicName, md5);
            }
            return false;
        }
    });

    public String getBitmapsFromVideo(String filpath) {
        File file = new File(filpath);
        String path = "";
        try {

            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            retriever.setDataSource(filpath);
            String time = retriever
                    .extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            Bitmap bitmap = retriever.getFrameAtTime(0,
                    MediaMetadataRetriever.OPTION_CLOSEST_SYNC);
            path = Environment.getExternalStorageDirectory().getAbsolutePath()
                    + File.separator + ".jpg";
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(path);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fos);
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
}
