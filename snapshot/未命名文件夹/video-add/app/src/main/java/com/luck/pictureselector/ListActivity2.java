package com.luck.pictureselector;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

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
 * Created by toplu1015 on 2018/3/24.
 */

public class ListActivity2 extends ListActivity {
    private String means = "计亚茹";

    class Bean {
        String imguri;
        String means;
    }

    List<Bean> beans = new ArrayList<>();

    private static Handler mHandler = new Handler();
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = "http://116.62.168.251:8080/cloudnote/finds.do";
        listView = getListView();
        OkHttpClient client = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("means", means).build();

        Request r = new Request.Builder()
                .post(formBody)
                .url(url)
                .build();

        client.newCall(r).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String json = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("TAG", json);
                        try {
                            JSONArray array = new JSONArray(json);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);
                                String means = o.getString("means");
                                String imguri = o.getString("imguri");
                                Bean b = new Bean();
                                b.imguri = imguri;
                                b.means = means;
                                beans.add(b);
                            }
                            BaseAdapter adapter = new BaseAdapter() {
                                @Override
                                public int getCount() {
                                    return beans.size();
                                }

                                @Override
                                public Object getItem(int position) {
                                    return beans.get(position);
                                }

                                @Override
                                public long getItemId(int position) {
                                    return position;
                                }

                                @Override
                                public View getView(int position, View convertView, ViewGroup parent) {
                                    ViewHolder vh = null;
                                    if (convertView == null) {
                                        vh = new ViewHolder();
                                        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
                                        vh.img = (ImageView) convertView.findViewById(R.id.img);
                                        convertView.setTag(vh);
                                    } else {
                                        vh = (ViewHolder) convertView.getTag();
                                    }
                                    Glide.with(ListActivity2.this).load(beans.get(position).imguri).into(vh.img);
                                    return convertView;
                                }

                                class ViewHolder {
                                    ImageView img;
                                }
                            };
                            listView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Bean b = (Bean) l.getItemAtPosition(position);
        Toast.makeText(this, b.means, Toast.LENGTH_SHORT).show();
    }
}
