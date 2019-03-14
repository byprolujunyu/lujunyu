package com.bm.container.module.setting;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.SpUtil;
import com.bm.container.Tools.Verify;
import com.bm.container.databinding.ActivityChangePwdBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;


/**
 * P8_1 修改密码
 */
public class ChangePwdActivity extends BaseActivity {
    private ActivityChangePwdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_change_pwd);

        setTopbar();
        setLoading();
        setCode();
        setSure();
    }

    /**
     * 验证码
     */
    private void setCode() {
        binding.codeBtn.setOnClickListener(v -> {
            if (Verify.change(binding.old, binding.pwd1, binding.pwd2)) {
                Block.countDownChange(this, binding.codeBtn);
            }
        });
    }

    /**
     * 提交
     */
    private void setSure() {
        binding.sure.setOnClickListener(view -> {
            if (Verify.change(binding.old, binding.pwd1, binding.pwd2, binding.code)) {
                Collection.changePwd(this, SpUtil.getString(SpUtil.PHONE), binding.pwd1.getText().toString(), baseBean -> {
                    SpUtil.setString(SpUtil.PWD, binding.pwd1.getText().toString());
                    dialogFinish("密码修改成功");
                });
            }
        });
    }

    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.change_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }
}
