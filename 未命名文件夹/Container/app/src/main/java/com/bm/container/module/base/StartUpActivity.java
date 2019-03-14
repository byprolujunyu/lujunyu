package com.bm.container.module.base;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.bm.container.R;
import com.bm.container.Tools.SpUtil;
import com.bm.container.databinding.ActivityStartUpBinding;
import com.bm.container.module.BaseActivity;
import com.bm.container.service.ContainerNo;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * P1启动页
 */
public class StartUpActivity extends BaseActivity {
    private ActivityStartUpBinding binding;
    public static StartUpActivity instance;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start_up);
        instance = this;
        context = this;
        startContainerNo();
        setLoading();
    }

    /**
     * 读取箱号文件
     */
    private void startContainerNo() {
        Intent i = new Intent(this, ContainerNo.class);
        startService(i);
    }

    /**
     * 停顿两秒
     */
    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
//		binding.refresh.setRefreshing(true);
        Observable
                .timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    boolean guideVaule = SpUtil.getBoolean("guideVaule", false);
                    if (guideVaule) {
                        startAc(new Intent(context, MainActivity.class));
                        finishAc();
                    } else {
                        startAc(new Intent(context, SplashActivity.class));
                        finishAc();
                    }
//					binding.refresh.setRefreshing(false);
//					Intent i = new Intent(context, SplashActivity.class);
//					startAc(i);
//					finishAc();
                });
    }
}
