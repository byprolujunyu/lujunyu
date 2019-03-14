package com.luck.pictureselector;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by toplu1015 on 2018/5/25.
 */

public class OkHttpUtils {

    static OkHttpClient client;

    static {
        client = new OkHttpClient();
    }

    interface OkHttpCallBack {
        void onSuccess(String name);

        void onFailed(Exception e);
    }

    public static void postNetwork(String uri, FormBody formBody, final OkHttpCallBack back) {
        client.newCall(getNormalRequest(uri, formBody)).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                back.onFailed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                back.onSuccess(response.body().string());
            }
        });
    }

    private static Request getNormalRequest(String uri, FormBody formBody) {
        FormBody f = formBody;
        Request r = new Request.Builder().url(uri).post(f).build();
        return r;
    }

    public static void updateMd5(Long id, String md5, final OkHttpCallBack back) {
        client.newCall(getRequest(id, md5)).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                back.onFailed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                back.onSuccess(response.body().string());
            }
        });
    }

    public static void updateDELETE(Long id, final OkHttpCallBack back) {
        client.newCall(getRequestDelete(id)).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                back.onFailed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                back.onSuccess(response.body().string());
            }
        });
    }

    public static void updateMeans(Long id, String means, final OkHttpCallBack back) {
        client.newCall(getRequestMeans(id, means)).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                back.onFailed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                back.onSuccess(response.body().string());
            }
        });
    }

    private static Request getRequest(Long id, String md5) {
        FormBody f = new FormBody.Builder()
                .add("id", id + "")
                .add("md5", md5)
                .build();
        Request r = new Request.Builder().url(UriConfig.URL_UPDATE_MD5).post(f).build();
        return null;
    }

    private static Request getRequestDelete(Long id) {
        FormBody f = new FormBody.Builder()
                .add("id", id + "")
                .build();
        Request r = new Request.Builder().url(UriConfig.URL_UPDATE_DELETE).post(f).build();
        return r;
    }

    private static Request getRequestMeans(Long id, String means) {
        FormBody f = new FormBody.Builder()
                .add("id", id + "")
                .add("means", means)
                .build();
        Request r = new Request.Builder().url(UriConfig.URL_UPDATE_MEANS).post(f).build();
        return r;
    }

    public static Map<String, String> createMap(String[] keys, String[] values) {
        if (keys.length != values.length)
            throw new IllegalArgumentException("参数错误");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }


    public static FormBody createParams(Map<String, String> params) {
        if (params == null) return null;
        FormBody.Builder f = new FormBody.Builder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            f.add(entry.getKey(), entry.getValue());
        }
        return f.build();
    }

}
