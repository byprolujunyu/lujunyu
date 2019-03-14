package com.bm.container.Tools;

import java.util.regex.Pattern;

public class CheckParamsUtils {

    /**
     * 校验手机号码格式
     *
     * @param mobile
     * @return
     */
    public static boolean checkMobile(final String mobile) {
        return Pattern.compile("^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$|17[0-9]{9}$").matcher(mobile).matches();
    }

    /**
     * 校验密码格式 (6~18位且不能有汉字或空格)
     *
     * @param password
     * @return
     */
    public static boolean checkPass(String password) {
        return Pattern.compile("^[^\\u4e00-\\u9fa5^ ]{6,18}$").matcher(password).matches();
    }

    /**
     * 校验邮箱格式
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        return Pattern
                .compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")
                .matcher(email).matches();
    }

    /**
     * 校验提现金额格式
     *
     * @param money
     * @return
     */
    public static boolean checkAmount(String money) {
        return Pattern.compile("^([2-9]|[1-9][0-9])\\d*00$").matcher(money).matches();
    }

}
