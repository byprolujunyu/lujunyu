package com.luck.pictureselector;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.luck.pictureselector.MainActivity.genericClient;

/**
 * Created by toplu1015 on 2018/5/24.
 */
public class VideoActivity extends AppCompatActivity implements View.OnClickListener {
    Video v;

    @Override
    protected void onResume() {
        super.onResume();

    }

    private Button buttonDELETE;
    private Button buttonMEANS;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v);
        v = (Video) getIntent().getSerializableExtra("bean");
        Button button = null;
        buttonDELETE = (Button) findViewById(R.id.buttonDELETE);
        buttonMEANS = (Button) findViewById(R.id.buttonMEANS);
        button = (Button) findViewById(R.id.button);
        if (v.getMd5() == null || "".equals(v.getMd5())) {
            button.setEnabled(true);
        } else {
            button.setEnabled(false);
        }
        button.setOnClickListener(this);
        buttonDELETE.setOnClickListener(this);
        buttonMEANS.setOnClickListener(this);

        isGrantExternalRW(this);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(Uri.parse(v.getUri()));
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
//                Toast.makeText(VideoActivity.this, "播放完成了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static boolean isGrantExternalRW(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && activity.checkSelfPermission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            activity.requestPermissions(new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 1);

            return false;
        }

        return true;
    }

    String nameStr = "http://oss-toplu1015.oss-cn-hangzhou.aliyuncs.com/";


    private void download(String uri) {
        final String s = Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator + UUID.randomUUID().toString().substring(6) + ".mp4";
        DownloadUtil.get().download(uri, s, new DownloadUtil.OnDownloadListener() {
            @Override
            public void onDownloadSuccess(String name) {
                File file = new File(name);
                uploadMd5(file);
//                uploadOSS(name);
            }

            @Override
            public void onDownloading(int progress) {
                long id1 = Thread.currentThread().getId();
                System.out.println(id1);
            }

            @Override
            public void onDownloadFailed() {
                long id1 = Thread.currentThread().getId();
                System.out.println(id1);
            }
        });
    }

    private void uploadMd5(File file) {
        String md5 = null;
        try {
            md5 = Base64Utils.getMd5ByFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String id = v.getId();
        okhttp(id, md5);
    }

    private void okhttp(String id, String md5) {
        FormBody formBody = new FormBody.Builder()
                .add("id", id)
                .add("md5", md5)
                .build();

        OkHttpClient okHttpClient = genericClient();

        final Request request = new Request.Builder().post(formBody).url(UriConfig.URL_UPDATE_MD5).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                e.printStackTrace();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(VideoActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String s = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(VideoActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    private void uploadOSS(String name) {
        String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId = "LTAI1hHwGmsLvt2j";
        String accessKeySecret = "ZUsmXEyBmR9pZT7mog8S7ktuwit1ou";

        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(
                accessKeyId, accessKeySecret);

        OSS oss = new OSSClient(VideoActivity.this.getApplicationContext(), endpoint,
                credentialProvider);

        String bitmapsFromVideo = getBitmapsFromVideo(name);
        String path = "picture/" + UUID.randomUUID().toString() + ".jpg";
        PutObjectRequest put = new PutObjectRequest("oss-toplu1015", path, bitmapsFromVideo);
        try {

            PutObjectResult putResult = oss.putObject(put);

            Log.i("TAG", "onDownloadSuccess: ");

            okhttp(nameStr + path);
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            Log.e("RequestId", e.getRequestId());
            Log.e("ErrorCode", e.getErrorCode());
            Log.e("HostId", e.getHostId());
            Log.e("RawMessage", e.getRawMessage());
        }
    }

    private void okhttp(String s) {
        FormBody formBody = new FormBody.Builder()
                .add("id", v.getId())
                .add("imguri", s)
                .build();

        OkHttpClient okHttpClient = genericClient();

        final Request request = new Request.Builder()

                .post(formBody).url("http://116.62.168.251:8080/VideoOperation/video/update.do").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                e.printStackTrace();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(VideoActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String s = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(VideoActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    Handler mHandler = new Handler();

    public String getBitmapsFromVideo(String filpath) {
        File file = new File(filpath);
        String path = "";
        try {

            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            retriever.setDataSource(v.getUri(), new HashMap<String, String>());
            String time = retriever
                    .extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int seconds = Integer.valueOf(time) / 1000;
            for (int i = 1; i <= seconds; i++) {
                Bitmap bitmap = retriever.getFrameAtTime(i * 1000 * 1000,
                        MediaMetadataRetriever.OPTION_CLOSEST_SYNC);
                path = Environment.getExternalStorageDirectory().getAbsolutePath()
                        + File.separator + i + ".jpg";
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(path);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fos);
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }


    @Override
    public void onClick(View view) {
//        click();
        if (view == buttonDELETE) {
            delete();
        } else if (view == buttonMEANS) {
            means(view);
        }
    }

    private void means(View view) {
        alert_edit(view, new EditBack() {
            @Override
            public void onClick(String means) {
                OkHttpUtils.updateMeans(new Long(v.getId()), means, new OkHttpUtils.OkHttpCallBack() {
                    @Override
                    public void onSuccess(final String name) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(VideoActivity.this, name, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onFailed(final Exception e) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(VideoActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
    }

    private void delete() {
        OkHttpUtils.updateDELETE(new Long(v.getId()), new OkHttpUtils.OkHttpCallBack() {
            @Override
            public void onSuccess(final String name) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(VideoActivity.this, name, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }

            @Override
            public void onFailed(final Exception e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(VideoActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void click() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String id = v.getId();
                String uri = v.getUri();
                String md5ByFile = "";

                try {
//                    uri();
//                    URL url = new URL(uri);
//                    md5ByFile = Base64Utils.getMd5ByFile(new File(String.valueOf(url)));
                    Uri parse = Uri.parse(uri);
                    File file = uri2File(parse);
                    md5ByFile = Base64Utils.getMd5ByFile(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                okhttp(id, md5ByFile);
            }
        });
    }

    interface EditBack {
        void onClick(String means);
    }

    public void alert_edit(View view, final EditBack back) {
        final EditText et = new EditText(this);
        new AlertDialog.Builder(this).setTitle("请输入备注")
                .setIcon(android.R.drawable.sym_def_app_icon)
                .setView(et)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        back.onClick(et.getText().toString());
                    }
                }).setNegativeButton("取消", null).show();
    }

    void uri() throws Exception {
        URL url = new URL("http://127.0.0.1:8080/cfStruts2Ex2/");
        URLConnection urlConn = url.openConnection();

        System.out.println("Date: " + new Date(urlConn.getDate()));
        System.out.println("Content-Type: " + urlConn.getContentType());

        int length = urlConn.getContentLength();
        System.out.println("Content-Lentgth: " + length);

        if (length > 0) {
            System.out.println("========== Content ==========");
            InputStream input = urlConn.getInputStream();

            int i = length;
            int c;
            while ((c = input.read()) != -1 && --i > 0) {
                System.out.print((char) c);
            }
            input.close();
        } else {
            System.out.println("No Content.");
        }
    }

    private File uri2File(Uri uri) {
        String img_path;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor actualimagecursor = managedQuery(uri, proj, null,
                null, null);
        if (actualimagecursor == null) {
            img_path = uri.getPath();
        } else {
            int actual_image_column_index = actualimagecursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            actualimagecursor.moveToFirst();
            img_path = actualimagecursor
                    .getString(actual_image_column_index);
        }
        File file = new File(img_path);
        return file;
    }
}
