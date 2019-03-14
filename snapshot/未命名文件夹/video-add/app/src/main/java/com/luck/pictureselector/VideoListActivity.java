package com.luck.pictureselector;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by toplu1015 on 2018/5/24.
 */

public class VideoListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final int QUERY_LIST = 0x123;
    private ListView listVideo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        listVideo = (ListView) findViewById(R.id.listVideo);
        listVideo.setOnItemClickListener(this);
    }

    static final String IP = "http://116.62.168.251:8080/VideoOperation/video/";

    @Override
    protected void onResume() {
        super.onResume();
        okhttp();
    }

    private void okhttp() {
        new OkHttpClient().newCall(getRequest()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                json = response.body().string();
                mHandler.sendEmptyMessage(QUERY_LIST);
            }
        });
    }

    private Request getRequest() {
        Request r = new Request.Builder()
                .url(IP + "queryList.do").build();
        return r;
    }

    String json = "";

    List<Video> vs;

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case QUERY_LIST:
                    vs = new ArrayList<>();
                    try {
                        JSONArray ary = new JSONArray(json);
                        for (int i = 0; i < ary.length(); i++) {
                            JSONObject o = ary.getJSONObject(i);
                            String means = o.getString("means");
                            String id = o.getString("id");
                            String uri = o.getString("uri");
                            String date = o.getString("date");
                            String imguri = o.getString("imguri");
                            int flagDelete = o.getInt("flagDelete");
                            Video v = new Video(id, uri, date, flagDelete, means, imguri);
                            vs.add(v);
                        }
                        BaseAdapter adapter = new BaseAdapter() {
                            @Override
                            public int getCount() {
                                return vs.size();
                            }

                            @Override
                            public Object getItem(int position) {
                                return vs.get(position);
                            }

                            @Override
                            public long getItemId(int position) {
                                return position;
                            }

                            @Override
                            public View getView(int position, View convertView, ViewGroup parent) {
                                ViewHolder vh;
                                if (convertView == null) {
                                    vh = new ViewHolder();
                                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, null);
                                    vh.name = (TextView) convertView.findViewById(R.id.text);
                                    vh.img = (ImageView) convertView.findViewById(R.id.imageView);
                                    convertView.setTag(vh);
                                } else {
                                    vh = (ViewHolder) convertView.getTag();
                                }
                                vh.name.setText(vs.get(position).getMeans());
                                Glide.with(parent.getContext()).load(vs.get(position).getImguri()).into(vh.img);
                                return convertView;
                            }

                            class ViewHolder {
                                TextView name;
                                ImageView img;
                            }
                        };
                        listVideo.setAdapter(adapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
            }
            return false;
        }
    });


    void f(Object obj) {
        Log.i("TAG", "f: " + obj.getClass().getName());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Video v = (Video) parent.getItemAtPosition(position);
        Intent intent = new Intent(this, VideoActivity.class);
        intent.putExtra("bean", v);
        startActivity(intent);
    }
}
