package com.bm.container.Tools;

import java.math.BigDecimal;

/**
 * 数字工具转换类
 * User: yang
 * Date: 2016-03-30 09:19
 */
public class NumberUtils {

    /**
     * double为整数时不带小数点
     *
     * @param number
     * @return
     */
    public static String formatDouble(double number) {
        if (Math.round(number) - number == 0) {
            return String.valueOf((long) number);
        }
        return String.valueOf(number);
    }

    public static String roundToString(double d) {
        return new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static String roundToString(String s) {
        return new BigDecimal(s).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 将每三个数字加上逗号处理（通常使用金额方面的编辑）
     *
     * @param str 无逗号的数字
     * @return 加上逗号的数字
     */
    public static String addSeparator(String str) {
        return addSeparatorp(roundToString(str));
    }

    public static String addSeparator(double d) {
        return addSeparatorp(roundToString(d));
    }

    private static String addSeparatorp(String str) {
        try {
            // 将传进数字反转
            String reverseStr = new StringBuilder(str).reverse().toString();

            String left = "";
            if (reverseStr.contains(".")) {
                left = reverseStr.substring(0, reverseStr.indexOf(".") + 1);
                reverseStr = reverseStr.substring(reverseStr.indexOf(".") + 1, reverseStr.length());
            }

            String strTemp = "";
            for (int i = 0; i < reverseStr.length(); i++) {
                if (i * 3 + 3 > reverseStr.length()) {
                    strTemp += reverseStr.substring(i * 3, reverseStr.length());
                    break;
                }
                strTemp += reverseStr.substring(i * 3, i * 3 + 3) + ",";
            }
            // 将 【789,456,】 中最后一个【,】去除
            if (strTemp.endsWith(",")) {
                strTemp = strTemp.substring(0, strTemp.length() - 1);
            }

            // 将数字重新反转
            String resultStr = new StringBuilder(left + strTemp).reverse().toString();
            return resultStr;
        } catch (Exception e) {
            return str;
        }

    }
}
