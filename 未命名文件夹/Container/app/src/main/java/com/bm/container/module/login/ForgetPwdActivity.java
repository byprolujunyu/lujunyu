package com.bm.container.module.login;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.NetHelper;
import com.bm.container.Tools.Verify;
import com.bm.container.databinding.ActivityForgetPwdBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;

/**
 * P3_4忘记密码
 */
public class ForgetPwdActivity extends BaseActivity {
    private ActivityForgetPwdBinding binding;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forget_pwd);
        context = this;
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
            if (!NetHelper.IsHaveInternet(ForgetPwdActivity.this)) {
                toast("未连接到网络.");
                return;
            }
            Block.countDownForget(this, binding.phone, binding.codeBtn);
        });
    }

    /**
     * 选择确定
     */
    private void setSure() {

        binding.sure.setOnClickListener(view -> {

            if (!NetHelper.IsHaveInternet(ForgetPwdActivity.this)) {
                toast("未连接到网络.");
                return;
            }

            if (Verify.forget(binding.phone, binding.verifyCode, binding.pwd1, binding.pwd2)) {
                String tempPhone = binding.phone.getText().toString();
                String tempPwd1 = binding.pwd1.getText().toString();
                Collection.changePwd(this, tempPhone, tempPwd1, baseBean -> {
                    dialogFinish("密码修改成功！");
                });
            }
        });
    }

    private void setLoading() {
        setLoading(binding.refresh);
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.forgetpwd_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }
}
