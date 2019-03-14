package com.bm.container.module.discuss;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.WindowManager;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.databinding.ActivitySendImageBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.discuss.adapter.ChooseImageAdatper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 发帖
 */
public class SendImageActivity extends BaseActivity {
    private ActivitySendImageBinding binding;
    private Context context;
    private List<File> allFiles = new ArrayList<>();
    private ChooseImageAdatper adatper;
    public static String POSTING = "POSTING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //收起键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_send_image);
        context = this;
        setTopbar();
        setLoading();
        setInput();
        initImage();
        initSend();
    }

    /**
     * 输入框输入
     */
    private void setInput() {
        binding.input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.count.setText(s.length() + "/200字");
                s.length();
            }
        });
    }

    /**
     * 发布
     */
    private void initSend() {
        binding.sure.setOnClickListener(v -> {
            if (binding.input.getText().toString().isEmpty()) {
                toast("请输入发帖内容");
            } else if (allFiles.size() == 0) {
                toast("请选择图片");
            } else {
                Collection.comment(this, binding.input.getText().toString(), allFiles, baseBean -> {
                    dialogFinish("上传成功");
                });
            }
        });
    }

    /**
     * 选图
     */
    private void initImage() {
        adatper = new ChooseImageAdatper(context, allFiles);
        adatper.setDeleteCallback(position -> {
            allFiles.remove(position);
            adatper.notifyDataSetChanged();
        });
        binding.image.setAdapter(adatper);
    }

    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.send_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }

    /**
     * 选图后压缩加载
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        showLoading();
        List<File> pics = Block.resolvePic(this, requestCode, resultCode, data, files -> {
            Log.e("压缩", "成功了！");
            allFiles.addAll(files);
            adatper.notifyDataSetChanged();
            hideLoading();
        }, throwable -> {
            Log.e("压缩失败", "压缩失败");
            hideLoading();
        });
    }
}
