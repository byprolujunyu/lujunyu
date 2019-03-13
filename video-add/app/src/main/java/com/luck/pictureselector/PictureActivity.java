package com.luck.pictureselector;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.luck.pictureselector.adapter.PicListAdapter;
import com.luck.pictureselector.domain.Names;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by toplu1015 on 2018/2/19.
 */

public class PictureActivity extends Activity implements AdapterView.OnItemLongClickListener {
    PicListAdapter adapter;
    List<Names> ns = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        ListView lsv = (ListView) findViewById(R.id.listView);
        lsv.setAdapter(adapter = new PicListAdapter(ns));
        lsv.setOnItemLongClickListener(this);
        f();
    }

    String nowPage = "34";

    void f() {
        OkHttpClient client = new OkHttpClient();
        FormBody form = new FormBody.Builder()
                .add("pageSize", "10")
                .add("nowPage", nowPage)
                .build();
        Request r = new Request.Builder()
                .url("http://116.62.168.251:8080/WebTest/GetNamesList")
                .post(form)
                .build();

        client.newCall(r).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());
            }

            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                System.out.println(string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONArray ary = new JSONArray(string);
                            for (int i = 0; i < ary.length(); i++) {
                                JSONObject o = ary.getJSONObject(i);
                                String id = o.getString("id");
                                String name = o.getString("name");
                                String position = o.getString("position");
                                String picuri = o.getString("picuri");
                                Names names = new Names();
                                names.setId(new Long(id));
                                names.setName(name);
                                names.setPosition(position);
                                names.setPicuri(picuri);
                                ns.add(names);
                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } finally {

                        }
                    }
                });
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Names n = (Names) parent.getItemAtPosition(position);
        Toast.makeText(this, n.getId() + "", Toast.LENGTH_SHORT).show();
        return false;
    }
}
