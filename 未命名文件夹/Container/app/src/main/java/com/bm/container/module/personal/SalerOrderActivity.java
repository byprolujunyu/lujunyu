package com.bm.container.module.personal;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.bm.container.R;
import com.bm.container.databinding.ActivitySalerOrderBinding;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.personal.adapter.SalerOrderAdapter;

/**
 * P7_4 卖家提货单
 */
public class SalerOrderActivity extends BaseActivity {
    private ActivitySalerOrderBinding binding;
    private Context context;
    private SalerOrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_saler_order);
        context = this;
        setTopbar();
        setLoading();
        setList();
    }

    private void setList() {
        adapter = new SalerOrderAdapter(context, null);
        binding.list.setAdapter(adapter);
    }

    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.salerorder_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }
}
