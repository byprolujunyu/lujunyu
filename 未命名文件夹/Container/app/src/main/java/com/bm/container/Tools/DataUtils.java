package com.bm.container.Tools;

/**
 * Created by kec on 2017/5/31.
 */

public class DataUtils {

    /**
     * 获取一个时间戳
     *
     * @return
     */
    public static String getTime() {

        long time = System.currentTimeMillis() / 1000;//获取系统时间的10位的时间戳

        String str = String.valueOf(time);

        return str;

    }


    private static long lastClickTime;

    /**
     * 防止按钮连续点击事件
     *
     * @return
     */
    public synchronized static boolean isFastClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

}
