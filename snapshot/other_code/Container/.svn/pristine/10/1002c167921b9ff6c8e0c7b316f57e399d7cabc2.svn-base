package com.bm.container.Tools;

import java.util.List;

import org.apache.http.NameValuePair;

import com.bm.container.wxapi.Constants;
import com.bm.container.wxapi.MD5;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import android.app.Activity;
import android.util.Log;

/**
 * @author nfmomo
 */
public class ThirdPart {

    // 微信支付
    // key
    public static final String APP_ID = "wx082bb9065793eab1";
    // 商户号
    public static final String MCH_ID = "1480136512";
    // API密钥，在商户平台设置
    public static final String API_KEY = "ft5fd5h42s1r4rh2rh1sgr1h2sdf2sG5";

    /**
     * 微信支付 参数由服务器接口给出
     *
     * @param activity     调用页，例：MainActivity.this
     * @param appId        微信公众账号ID
     * @param partnerId    商户号
     * @param prepayId     预支付交易会话ID
     * @param packageValue 扩展字段
     * @param nonceStr     随机字符串
     * @param timeStamp    时间戳
     */

    public static void wxPay(Activity activity, String appId, String partnerId, String prepayId, String packageValue,
                             String nonceStr, String timeStamp, String sign) {
        PayReq req = new PayReq();
        req.appId = appId;
        req.partnerId = partnerId;
        req.prepayId = prepayId;
        req.nonceStr = nonceStr;
        req.timeStamp = timeStamp;
        req.packageValue = packageValue;
        req.sign = sign;

        IWXAPI msgApi = WXAPIFactory.createWXAPI(activity, appId);
        msgApi.sendReq(req);
    }

    private static String genAppSign(StringBuffer sb2, List<NameValuePair> params) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < params.size(); i++) {
            sb.append(params.get(i).getName());
            sb.append('=');
            sb.append(params.get(i).getValue());
            sb.append('&');
        }
        sb.append("key=");
        sb.append(Constants.API_KEY);

        sb2.append("sign str\n" + sb.toString() + "\n\n");
        Log.e("sb", sb.toString());
        Log.e("sb2", sb2.toString());
        String appSign = MD5.getMessageDigest(sb.toString().getBytes()).toUpperCase();
        Log.e("orion", appSign);
        return appSign;
    }

}
