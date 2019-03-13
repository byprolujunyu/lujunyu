package com.bm.container.http;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.reactivex.functions.Function;

/**
 * 基础json的处理，还未使用
 * <p>
 * Created by nfmomo on 17/1/11.
 */

public class BaseConverter<T> implements Function<BaseBean, T> {

    @Override
    public T apply(BaseBean baseBean) throws Exception {
        String status = baseBean.getStatus();
        String message = baseBean.getMsg();
        String data = new Gson().toJson(baseBean.getData());

        //对请求进行判断
        if (status.equals("0")) {//请求失败
            Log.e("接口请求失败", "message");
            throw new RuntimeException(message);
        } else {//请求成功
            Log.e("接口请求成功", data);
            if (data.equals("null") || data.isEmpty()) {
                throw new RuntimeException("empty");
            } else {
                data = data.replaceAll(":null", ":\"\"");
                data = data.replaceAll("\\[null,", "\\[");
                data = data.replaceAll("\\[null]", "\\[\\]");
                data = data.replaceAll(",null,", ",");
                data = data.replaceAll(",null\\]", "\\]");
                return new Gson().fromJson(data, new TypeToken<T>() {
                }.getType());
            }
        }
    }
}
