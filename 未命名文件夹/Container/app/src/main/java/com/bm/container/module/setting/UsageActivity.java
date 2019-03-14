package com.bm.container.module.setting;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.bm.container.R;
import com.bm.container.databinding.UsageLayoutBinding;
import com.bm.container.module.BaseActivity;

/**
 * 合格使用方法
 * Created by kec on 2017/7/20.
 */

public class UsageActivity extends BaseActivity {

    private UsageLayoutBinding bindingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindingView = DataBindingUtil.setContentView(this, R.layout.usage_layout);

        setTopbar();

    }


    private void setTopbar() {
        bindingView.topbar.toolbar.setTitle("");
        bindingView.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        bindingView.topbar.title.setText("交易须知");
        setSupportActionBar(bindingView.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bindingView.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }

}
