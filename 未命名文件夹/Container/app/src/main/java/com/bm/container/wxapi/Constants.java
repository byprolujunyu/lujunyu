package com.bm.container.wxapi;


import com.bm.container.Tools.ThirdPart;

public class Constants {

    // appid
    // 请同时修改 androidmanifest.xml里面，.PayActivityd里的属性<data
    // android:scheme="wxb4ba3c02aa476ea1"/>为新设置的appid
    public static final String APP_ID = ThirdPart.APP_ID;

    // 商户号
    public static final String MCH_ID = ThirdPart.MCH_ID;

    // API密钥，在商户平台设置
    public static final String API_KEY = ThirdPart.API_KEY;

}
