package com.bm.container.Tools;

import android.text.TextUtils;
import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    /**
     * 日期格式 yyyy-MM-dd
     */
    public final static String FORMAT_DATE = "yyyy-MM-dd";

    public final static String FORMAT_DATE_TWO = "yyy年MM月dd日";

    /**
     * 日期格式 hh:mm
     */
    public final static String FORMAT_TIME = "HH:mm";

    /**
     * 日期格式 hh:mm:ss
     */
    public static final String FORMAT_TIME_ALL = "HH:mm:ss";

    /**
     * 日期格式 yyyy-MM-dd hh:mm
     */
    public final static String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm";

    /**
     * 日期格式 MM月dd日 hh:mm
     */
    public final static String FORMAT_MONTH_DAY_TIME = "MM月dd日 HH:mm";

    /**
     * 日期格式 yyyy-MM-dd hh:mm:ss
     */
    public final static String FORMAT_DATE_TIME_ALL = "yyyy-MM-dd HH:mm:ss";
    private static final int YEAR = 365 * 24 * 60 * 60;// 年
    private static final int MONTH = 30 * 24 * 60 * 60;// 月
    private static final int DAY = 24 * 60 * 60;// 天
    private static final int HOUR = 60 * 60;// 小时
    private static final int MINUTE = 60;// 分钟

    public final static String FORMAT_DATE_TIME_ALL_TWO = "yyyy.MM.dd";

    private static final TimeZone TIME_ZONE = TimeZone.getTimeZone("GMT+8");

    private static SimpleDateFormat getDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.setTimeZone(TIME_ZONE);
        return simpleDateFormat;
    }

    /**
     * 根据时间戳获取描述性时间，如3分钟前，1天前
     *
     * @param timestamp 时间戳 单位为毫秒
     * @return 时间字符串
     */
    public static String getDescriptionTimeFromTimestamp(long timestamp) {
        long currentTime = System.currentTimeMillis();
        long timeGap = (currentTime - timestamp) / 1000;// 与现在时间相差秒数
        String timeStr = null;
        if (timeGap > YEAR) {
            timeStr = timeGap / YEAR + "年前";
        } else if (timeGap > MONTH) {
            timeStr = timeGap / MONTH + "个月前";
        } else if (timeGap > DAY) {// 1天以上
            timeStr = timeGap / DAY + "天前";
        } else if (timeGap > HOUR) {// 1小时-24小时
            timeStr = timeGap / HOUR + "小时前";
        } else if (timeGap > MINUTE) {// 1分钟-59分钟
            timeStr = timeGap / MINUTE + "分钟前";
        } else {// 1秒钟-59秒钟
            timeStr = "刚刚";
        }
        return timeStr;
    }

    /**
     * 根据消息记录获取对应的内容时间
     *
     * @param timestamp
     * @return
     */
    public static String getDescriptionTimeMsg(long timestamp) {
        long currentTime = System.currentTimeMillis();
        long timeGap = (currentTime - timestamp) / 1000;// 与现在时间相差秒数
        String timeStr = null;
        if (timeGap > YEAR) {
            timeStr = getFormatTimeFromTimestamp(timestamp, "yyyy-MM-dd HH:MM");
        } else if (timeGap > MONTH) {
            timeStr = getFormatTimeFromTimestamp(timestamp, "MM-dd HH:MM");
        } else if (timeGap > DAY) {// 1天以上
            timeStr = getFormatTimeFromTimestamp(timestamp, "MM-dd HH:MM");
        } else if (timeGap > HOUR) {// 1小时-24小时
            timeStr = getFormatTimeFromTimestamp(timestamp, "HH:MM");
        } else if (timeGap > MINUTE) {// 1分钟-59分钟
            timeStr = "";
        } else {// 1秒钟-59秒钟
            timeStr = "";
        }
        return timeStr;
    }

    /**
     * 根据时间戳获取指定格式的时间，如2011-11-30 08:40
     *
     * @param timestamp 时间戳 单位为毫秒
     * @param format    指定格式 如果为null或空串则使用默认格式"yyyy-MM-dd HH:MM"
     * @return String
     */
    public static String getFormatTimeFromTimestamp(long timestamp, String format) {

        String tempFormat;
        if (format == null || format.trim().isEmpty()) {
            Calendar calendar = Calendar.getInstance(TIME_ZONE);
            int currentYear = calendar.get(Calendar.YEAR);

            calendar.setTimeInMillis(timestamp);
            int timeYear = calendar.get(Calendar.YEAR);

            if (currentYear == timeYear) {// 如果为今年则不显示年份
                tempFormat = FORMAT_MONTH_DAY_TIME;
            } else {
                tempFormat = FORMAT_DATE_TIME;
            }
        } else {
            tempFormat = format;
        }
        return getStringFromDate(new Date(timestamp), tempFormat);
    }

    /**
     * 根据时间戳获取时间字符串，并根据指定的时间分割数partionSeconds来自动判断返回描述性时间还是指定格式的时间
     *
     * @param timestamp      时间戳 单位是毫秒
     * @param partionSeconds 时间分割线，当现在时间与指定的时间戳的秒数差大于这个分割线时则返回指定格式时间，否则返回描述性时间
     * @param format
     * @return
     */
    @SuppressWarnings("unused")
    public static String getMixTimeFromTimestamp(long timestamp, long partionSeconds, String format) {
        long currentTime = System.currentTimeMillis();
        long timeGap = (currentTime - timestamp) / 1000;// 与现在时间相差秒数
        if (timeGap <= partionSeconds) {
            return getDescriptionTimeFromTimestamp(timestamp);
        } else {
            return getFormatTimeFromTimestamp(timestamp, format);
        }
    }

    /**
     * 时间格式化 yyyy-MM-dd
     *
     * @param str 时间戳
     * @return 格式化后时间
     */
    public static String format(String str) {
        return format(Long.parseLong(str));
    }

    /**
     * 时间格式化 yyyy-MM-dd
     *
     * @param time 时间戳
     * @return 格式化后时间
     */
    public static String format(long time) {
        try {
            Calendar calendar = Calendar.getInstance(TIME_ZONE);
            calendar.setTimeInMillis(time);
            return DateFormat.format(FORMAT_DATE, calendar).toString();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取当前日期的指定格式的字符串
     *
     * @param format 指定的日期时间格式，若为null或""则使用指定的格式"yyyy-MM-dd HH:MM"
     * @return
     */
    public static String getCurrentTime(String format) {
        return getStringFromDate(new Date(), format);
    }

    /**
     * 将日期字符串以指定格式转换为Date
     *
     * @param timeStr 日期字符串
     * @param format  指定的日期格式，若为null或""则使用指定的格式"yyyy-MM-dd HH:MM"
     * @return
     */
    @SuppressWarnings("unused")
    public static Date getDateFromString(String timeStr, String format) {
        SimpleDateFormat simpleDateFormat = getDateFormat();
        if (format == null || format.trim().isEmpty()) {
            simpleDateFormat.applyPattern(FORMAT_DATE_TIME);
        } else {
            simpleDateFormat.applyPattern(format);
        }
        try {
            return simpleDateFormat.parse(timeStr);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * 将Date以指定格式转换为日期时间字符串
     *
     * @param date   日期
     * @param format 指定的日期时间格式，若为null或""则使用指定的格式"yyyy-MM-dd HH:MM"
     * @return
     */
    public static String getStringFromDate(Date date, String format) {
        SimpleDateFormat simpleDateFormat = getDateFormat();
        if (format == null || format.trim().isEmpty()) {
            simpleDateFormat.applyPattern(FORMAT_DATE_TIME);
        } else {
            simpleDateFormat.applyPattern(format);
        }
        return simpleDateFormat.format(date);
    }

    /**
     * 获取日期
     *
     * @return 年月日时分秒
     */
    public static String getTime() {
        SimpleDateFormat simpleDateFormat = getDateFormat();
        simpleDateFormat.applyPattern("yyyyMMddHHmmss");
        return simpleDateFormat.format(new Date());
    }

    /**
     * 秒转化为时分秒
     *
     * @param time
     * @return
     */
    @SuppressWarnings("unused")
    public static String getTime(long time) {
        long tempTime = time;
        StringBuffer buffer = new StringBuffer();

        long mins = tempTime / 60;
        long house = mins / 60;
        long min = mins % 60;
        long ss = tempTime % 60;

        if (house > 0) {
            buffer.append(house);
            buffer.append("小时");
        }

        if (house > 0 || min > 0) {
            buffer.append((min < 10 && house > 0) ? "0" + min : min);
            buffer.append("分");
        }

        buffer.append(ss < 10 ? "0" + ss : ss);
        buffer.append("秒");

        return buffer.toString();
    }

    /**
     * 秒转化为 -天-小时-分
     *
     * @param time
     * @return
     */
    @SuppressWarnings("unused")
    public static String formatTime(long time) {
        long tempTime = time;
        StringBuffer stringBuffer = new StringBuffer();

        long tempMins = tempTime / 60;// 总分钟

        long tempHouse = tempMins / 60;

        long day = tempHouse / 24;

        long house = tempHouse % 24;

        long min = tempMins % 60;

        long ss = tempTime % 60;

        stringBuffer.append(day);
        stringBuffer.append("天");
        stringBuffer.append(house < 10 ? "0" + house : house);
        stringBuffer.append("小时");
        stringBuffer.append(min < 10 ? "0" + min : min);
        stringBuffer.append("分");
        stringBuffer.append(ss < 10 ? "0" + ss : ss);
        stringBuffer.append("秒");
        return stringBuffer.toString();
    }


    public static Long getLongTime(String s) {

        if (TextUtils.isEmpty(s)) {
            return 0L;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(s);

            long time = date.getTime();
            return time;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0L;
        }

    }

}
