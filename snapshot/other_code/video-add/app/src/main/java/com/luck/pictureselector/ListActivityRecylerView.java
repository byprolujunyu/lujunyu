package com.luck.pictureselector;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.luck.pictureselector.domain.RecylerViewEntity;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by toplu1015 on 2018/3/31.
 */

public class ListActivityRecylerView extends Activity {

    private RecyclerView recycler;

    private String url = "http://api.meituan.com/mmdb/movie/v2/list/rt/order/coming.json?ci=1&limit=12&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=xiaomi&utm_medium=android&utm_term=6.8.0&utm_content=868030022327462&net=255&dModel=MI%205&uuid=0894DE03C76F6045D55977B6D4E32B7F3C6AAB02F9CEA042987B380EC5687C43&lat=40.100673&lng=116.378619&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463704714271&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=1a0b4a9b-44ec-42fc-b110-ead68bcc2824&__skcy=sXcDKbGi20CGXQPPZvhCU3%2FkzdE%3D";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        recycler = (RecyclerView) findViewById(R.id.recycler);


        //联网获取数据
        getDataFromNet();

    }

    String json;

    private void getDataFromNet() {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        new OkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(json = response.body().string());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RecylerViewEntity entity = new Gson().fromJson(json, RecylerViewEntity.class);
                        Log.i("TAG", entity.toString());
                    }
                });
            }
        });
    }

    /**
     * 使用fastjson进行解析
     *
     * @param json
     */

    private JSONObject parseObject(String json) {
        return null;
    }

}

