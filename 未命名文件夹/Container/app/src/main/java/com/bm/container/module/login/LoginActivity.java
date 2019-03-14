package com.bm.container.module.login;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.NetHelper;
import com.bm.container.Tools.SpUtil;
import com.bm.container.Tools.Verify;
import com.bm.container.databinding.ActivityLoginBinding;
import com.bm.container.http.Api;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.login.bean.LoginBean;
import com.bm.container.module.market.SendSaleInfoActivity;

import io.reactivex.functions.Consumer;

/**
 * P3登录
 */
public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding binding;
    private Context context;
    public static String LOGIN = "LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        context = this;
        setTopbar();
        setLoading();
        autoLogin();
        setWantRegister();
        setForgetPwd();
        setLogin();
    }

    /**
     * 自动登录
     */
    private void autoLogin() {
        if (SpUtil.getBoolean(SpUtil.REMEMNBER, false)) {
            binding.phone.setText(SpUtil.getString(SpUtil.SAVEPHONE));
            binding.pwd.setText(SpUtil.getString(SpUtil.SAVEPWD));
            binding.remember.setChecked(true);
        }
    }

    /**
     * 登录
     */
    private void setLogin() {
        binding.login.setOnClickListener(view -> {
            if (!NetHelper.IsHaveInternet(LoginActivity.this)) {
                toast("未连接到网络.");
                return;
            }
            requestLogin();
        });
    }

    private void updateRegIdByUserId() {
        System.out.println("base----------regid------------->" + SpUtil.getString(SpUtil.REGID));
        System.out.println("base----------ID------------->" + SpUtil.getString(SpUtil.ID));
        Collection.updateRegIdByUserId(this,
                SpUtil.getString(SpUtil.REGID),
                SpUtil.getString(SpUtil.ID),
                baseBean -> {
                    requestVerifyUser();
                });
    }


    private void requestVerifyUser() {
        Collection.loginVerifyUser(this,
//                SpUtil.getString(SpUtil.REGID),
                null,
                SpUtil.getString(SpUtil.USERFLAG),
                SpUtil.getString(SpUtil.APPUSERTYPE),
                SpUtil.getString(SpUtil.ID), baseBean -> finishAc());
    }

    private void requestLogin() {

        if (Verify.login(binding.phone, binding.pwd)) {
            String tempPhone = binding.phone.getText().toString();
            String tempPwd = binding.pwd.getText().toString();
            Collection.login(this, tempPhone, tempPwd, baseBean -> {
                SpUtil.setBoolean(SpUtil.PAYSUCCESS, true);
                Block.loginSaveInfo(baseBean, tempPhone, tempPwd, binding.remember.isChecked());
//                    LoginActivity.this.requestVerifyUser();
                updateRegIdByUserId();
//                finishAc();
            });
        }

    }

    /**
     * 忘记密码
     */
    private void setForgetPwd() {
        binding.forgetPwd.setOnClickListener(view -> {
            Intent i = new Intent(context, ForgetPwdActivity.class);
            startAc(i);
        });
    }

    /**
     * 注册
     */
    private void setWantRegister() {
        binding.wantRegister.setOnClickListener(view -> {
            Intent i = new Intent(context, RegisterActivity.class);
            startAc(i);
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
        binding.topbar.title.setText(R.string.login_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }

}
