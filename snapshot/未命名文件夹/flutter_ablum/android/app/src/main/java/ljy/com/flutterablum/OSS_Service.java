package ljy.com.flutterablum;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;

import java.util.Random;
import java.util.UUID;

public class OSS_Service implements Constants, Runnable {

    Context context;
    String path;
    CallBack call;
    private String randomStr;
    private String fileName;

    public void setCall(CallBack call) {
        this.call = call;
    }

    public OSS_Service(Context context, String path) {
        this.context = context;
        this.path = path;
        String s = "" + System.currentTimeMillis();
        int number = new Random().nextInt(100);
        randomStr = java.util.UUID.randomUUID().toString().substring(0,5)+""+number;
        fileName = "flutter/" + s + ".jpg";
    }

    @Override
    public void run() {
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(
                accessKeyId, accessKeySecret);
        OSS oss = new OSSClient(context.getApplicationContext(), endpoint,
                credentialProvider);


        PutObjectRequest put = new PutObjectRequest("oss-toplu1015", fileName, path);

        try {
            PutObjectResult putResult = oss.putObject(put);

            handler.sendEmptyMessage(0x123);
            Log.d("PutObject", "UploadSuccess");
            Log.d("ETag", putResult.getETag());
            Log.d("RequestId", putResult.getRequestId());
        } catch (ClientException e) {
            e.printStackTrace();
            if (call != null) {
                call.onFailure();
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            if (call != null) {
                call.onFailure();
            }
        }
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            if (call != null) {
                call.onSuccess(na me + fileName, "","");
            }
            return false;
        }
    });

    public interface CallBack {
        void onSuccess(String name, String picName, String md5);

        void onFailure();
    }
}
