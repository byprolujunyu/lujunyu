package com.luck.pictureselector;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.support.annotation.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by toplu1015 on 2018/5/25.
 */

public class Md5Service
        extends IntentService {

    public Md5Service() {
        super("md5");
    }


    List<Video> ls;

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        ls = new ArrayList<>();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        okHttp();
    }

    private void okHttp() {
        new OkHttpClient().newCall(getRequest()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println();
                String json = response.body().string();
                try {
                    ls = GsonUtils.jsonToArrayList(json, Video.class);
                    System.out.println(ls);

                    //for (int i = 0; i < ls.size(); i++) {
                    final String s = Environment.getExternalStorageDirectory().getAbsolutePath()
                            + File.separator + UUID.randomUUID().toString().substring(6) + ".mp4";
                    DownloadUtil.get().download(ls.get(0).getUri(), s, new DownloadUtil.OnDownloadListener() {
                        @Override
                        public void onDownloadSuccess(String fileName) {
                            File f = new File(fileName);
                            System.out.println(f);
                            String md5 = "";
                            try {
                                md5 = getMd5ByFile(f);
                                OkHttpUtils.updateMd5(new Long(ls.get(0).getId()), md5, new OkHttpUtils.OkHttpCallBack() {
                                    @Override
                                    public void onSuccess(String name) {
                                        System.out.println(name);
                                    }

                                    @Override
                                    public void onFailed(Exception e) {
                                        e.printStackTrace();
                                    }
                                });
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onDownloading(int progress) {

                        }

                        @Override
                        public void onDownloadFailed() {

                        }
                    });
                    //}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static String getMd5ByFile(File file) throws FileNotFoundException {
        String value = null;
        FileInputStream in = new FileInputStream(file);
        try {
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    private Request getRequest() {
        Request.Builder rb = new Request.Builder();
        rb.url(UriConfig.URL_FIND_ALL).get();
        return rb.build();
    }
}
