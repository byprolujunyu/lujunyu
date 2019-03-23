package com.bm.container.module.setting;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.SpUtil;
import com.bm.container.constants.ConstantsTag;
import com.bm.container.databinding.ActivitySettingBinding;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.base.WebActivity;
import com.bm.container.module.login.LoginActivity;

/**
 * P8 设置
 */
public class SettingActivity extends BaseActivity {
    private ActivitySettingBinding binding;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting);
        context = this;
        setTopbar();
        setLoading();
        initView();
        setExit();
        jumpChangePwd();
        jumpIntroduction();
        callPhone();
    }

    private void initView() {

        //搜箱用户注册协议
        binding.llAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, WebActivity.class);
                i.putExtra("url", ConstantsTag.htmlTopUrl + "agreementNoBet.html");
                i.putExtra("titleName", "搜箱用户使用协议");
                startAc(i);
            }
        });

        //合格使用方法
        binding.llUsage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startAc(new Intent(SettingActivity.this, UsageActivity.class));
                Intent i = new Intent(context, WebActivity.class);
                i.putExtra("url", ConstantsTag.htmlTopUrl + "userAgreement.html");
                i.putExtra("titleName", "交易须知");
                startAc(i);
            }
        });

    }

    /**
     * 热线电话
     */
    private void callPhone() {
        binding.hotline.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + binding.phone.getText().toString()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                toast("抱歉！当前未获得拨打电话权限，请到设置里设置应用拨打电话权限！");
                return;
            }
            startActivity(intent);
        });
    }

    /**
     * 跳转介绍
     */
    private void jumpIntroduction() {
        binding.introduction.setOnClickListener(view -> {
            Intent i = new Intent(context, IntroductionActivity.class);
            startAc(i);
        });
    }

    /**
     * 改密码
     */
    private void jumpChangePwd() {
        binding.changePwd.setOnClickListener(view -> {
            Intent i = new Intent(context, ChangePwdActivity.class);
            startAc(i);
        });
    }

    /**
     * 注销
     */
    private void setExit() {
        binding.exit.setOnClickListener(view -> {
            Block.deleteInfo();
            SpUtil.setBoolean(SpUtil.PAYSUCCESS, true);
            Intent i = new Intent(context, LoginActivity.class);
            startAc(i);
            finish();
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
        binding.topbar.title.setText(R.string.setting_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }
}
