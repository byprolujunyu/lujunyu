package ljy.com.flutterablum;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import net.arvin.selector.SelectorHelper;
import net.arvin.selector.data.ConstantData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends FlutterActivity {

    private static final String CHANNEL = "samples.flutter.io/battery";
    private static final String CHANNEL1 = "samples.flutter.io/ablum";
    private static final String CHANNEL2 = "samples.flutter.io/ablum_result";
    private static final String CHANNEL3 = "samples.flutter.io/ablum_result_upload";
    private static final String CHANNEL6 = "samples.flutter.io/platformClear";
    private static final String CHANNEL4 = "samples.flutter.io/actionsheet";
    private static final int REQUEST_ALBUM_OK = 100;
    private ArrayList<String> selectedPictures = new ArrayList<>();
    private static final String TAG = "MainActivity";
    Intent data;
    MethodChannel.Result result;
    OSS_Service oss_service;

    private String[] permissions = {Manifest.permission.CAMERA};
    private AlertDialog dialog;
    private String path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this);


        ActivityCompat.requestPermissions(this,

                new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.INTERNET}, 1);

        new MethodChannel(getFlutterView(), CHANNEL1).setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                getAblum();
            }
        });

        new MethodChannel(getFlutterView(),CHANNEL6).setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                selectedPictures.clear();
            }
        });

        new MethodChannel(getFlutterView(), CHANNEL3).setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                upload(methodCall);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }
        if (requestCode == 1001) {
            List<String> backPics = data.getStringArrayListExtra(ConstantData.KEY_BACK_PICTURES);
            if (backPics != null && backPics.size() > 0) {
                selectedPictures.clear();
                selectedPictures.addAll(backPics);
                sendResult(selectedPictures);
            }
        } else if (requestCode == 0x123) {

        }
    }

    void getAblum() {
        //   this.result = result;
        selectedPictures.clear();
        SelectorHelper.selectPictures(MainActivity.this, 9,
                true, selectedPictures, 1001);
    }

    void takephoto() {
        SelectorHelper.takePhoto(this, true, 0x123);
    }

    private void upload(MethodCall methodCall) {
        this.path = (String) methodCall.arguments;
        String path = (String) methodCall.arguments;
        new Thread(oss_service = new OSS_Service(MainActivity.this, path)).start();
        oss_service.setCall(new OSS_Service.CallBack() {
            @Override
            public void onSuccess(String name, String picName, String md5) {
                sendUploadResult(name);
                Log.d(TAG, "onSuccess: " + name);
            }

            @Override
            public void onFailure() {
                Log.d(TAG, "onFailure: ");
            }
        });

    }

    public static String getMD5Three(String path) {
        BigInteger bi = null;
        try {
            byte[] buffer = new byte[8192];
            int len = 0;
            MessageDigest md = MessageDigest.getInstance("MD5");
            File f = new File(path);
            FileInputStream fis = new FileInputStream(f);
            while ((len = fis.read(buffer)) != -1) {
                md.update(buffer, 0, len);
            }
            fis.close();
            byte[] b = md.digest();
            bi = new BigInteger(1, b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi.toString(16);
    }

    private void sendResult(Object o) {
        new MethodChannel(getFlutterView(), CHANNEL1).invokeMethod("getResult", o);
    }

    private void sendUploadResult(String o) {
        String md5Three = getMD5Three(path);
        RequestBody b = new FormBody.Builder()
                .add("id",Math.random()+"")
                .add("path", o)
                .add("description", "茹茹")
                .add("md5",md5Three)
                .add("random", UUID.randomUUID().toString())
                .build();

        Request request = new Request.Builder()
                .post(b)
                .url("http://47.96.78.67:3333/add/")
                .build();
        new OkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String string = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "上传ok", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        new MethodChannel(getFlutterView(), CHANNEL3).invokeMethod("uploadresult", o);
    }


    // 提示用户该请求权限的弹出框
    private void showDialogTipUserRequestPermission() {

        new AlertDialog.Builder(this)
                .setTitle("相册权限不可用")
                .setMessage("由于打开相册需要权限否则无法使用")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startRequestPermission();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setCancelable(false).show();
    }

    // 开始提交请求权限
    private void startRequestPermission() {
        ActivityCompat.requestPermissions(this, permissions, 321);
    }

}
