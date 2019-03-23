package com.bm.container.module.personal;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.databinding.ActivityQrBinding;
import com.bm.container.module.BaseActivity;
import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * P7_3_3_2 提货单二维码界面
 */
public class QRActivity extends BaseActivity {
    private static final int TAG_PERMISSION = 22;
    private ActivityQrBinding binding;
    private Context context;
    private String qRCodeUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_qr);
        context = this;

        if (null != getIntent()) {
            qRCodeUrl = getIntent().getStringExtra("qRCodeUrl");
        }

        setLoading();
        setTopbar();

        Glide.with(context).load(Block.listPic(qRCodeUrl)).placeholder(R.drawable.face).into(binding.qRCodeUrl);

        binding.button.setOnClickListener(v -> {

            if (TextUtils.isEmpty(qRCodeUrl)) {
                toast("当前未加载到二维码,请稍候再试！");
                return;
            }

            saveImageToGallery(QRActivity.this, binding.qRCodeUrl);

        });

    }


    public void saveImageToGallery(Context context, ImageView imageView) {

        imageView.setDrawingCacheEnabled(true);//开启catch，开启之后才能获取ImageView中的bitmap

        Bitmap bmp = imageView.getDrawingCache();

        // 首先保存图片
        File appDir = new File(Environment.getExternalStorageDirectory(), "Boohee");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        imageView.setDrawingCacheEnabled(false);

        // 最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        toast("下载成功，并保存到相册！");
    }


    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.qr_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case TAG_PERMISSION: {
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(QRActivity.this, "allow", Toast.LENGTH_SHORT).show();
//                    saveImageToSysAlbum(binding.qRCodeUrl);
//                } else {
//                    Toast.makeText(QRActivity.this, "deny", Toast.LENGTH_SHORT).show();
//                }
//                return;
//            }
//        }
//    }

}
