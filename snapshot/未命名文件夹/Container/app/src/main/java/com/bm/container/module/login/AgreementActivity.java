package com.bm.container.module.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bm.container.R;
import com.bm.container.constants.ConstantsTag;
import com.bm.container.databinding.ActivityAgreementBinding;
import com.bm.container.module.BaseActivity;

import org.simple.eventbus.EventBus;

/**
 * P3_2注册协议
 */
public class AgreementActivity extends BaseActivity {
    private ActivityAgreementBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_agreement);
        setTopbar();
        setLoading();
        initWeb();
//		Collection.agreement(this, baseBean -> {
//			binding.web.loadUrl(baseBean.getData().toString());
//		});
        binding.web.loadUrl("http://www.findcontainer.cn/containerH5/agreement.html");
    }

    /**
     * 预留js交互方法
     */
    @JavascriptInterface
    public void back() {
//		binding.refresh.setRefreshing(true);
//		Observable
//				.timer(1, TimeUnit.SECONDS)
//				.subscribeOn(Schedulers.io())
//				.observeOn(AndroidSchedulers.mainThread())
//				.subscribe(aLong -> {
//					finishAc();
//					binding.refresh.setRefreshing(false);
//				});
        finishAc();
        EventBus.getDefault().post("isCheckedTrue", ConstantsTag.IS_CHECKED_TRUE);
    }

    /**
     * 设定网页
     */
    private void initWeb() {
        WebSettings webSettings = binding.web.getSettings();
        webSettings.setSavePassword(false);
        webSettings.setSaveFormData(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        binding.web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                binding.web.loadUrl(url);
                return true;
            }
        });
        binding.web.addJavascriptInterface(AgreementActivity.this, "interface");
    }

    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.agreement_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }

    /**
     * 如有视频，使用此方法停止播放
     */
    @Override
    protected void onPause() {
        binding.web.reload();
        super.onPause();
    }
}
