package com.bm.container.module.personal;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import com.bm.container.R;
import com.bm.container.databinding.DeliveryOrderLayoutBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.personal.adapter.SalerOrderAdapter;
import com.bm.container.module.personal.bean.DeliveryOrderBean;
import com.bm.container.module.personal.bean.TabEntityNew;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * 新建 卖家提货单列表
 * Created by kec on 2017/5/27.
 */

public class DeliveryOrderActivity extends BaseActivity {


    private DeliveryOrderLayoutBinding bindingViewLayout;
    private ArrayList<CustomTabEntity> entitys = new ArrayList<>();
    private ArrayList<DeliveryOrderBean.DataBean> col = new ArrayList<>();

    private String[] titles = {"全部", "待填写", "已填写"};

    private int[] mIconUnselectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private int[] mIconSelectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private SalerOrderAdapter adapter;
    private String type = "2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindingViewLayout = DataBindingUtil.setContentView(this, R.layout.delivery_order_layout);

        setLoading();
        setTopbar();
        initView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        requestList();
    }


    private void initView() {

        for (int i = 0; i < titles.length; i++) {
            entitys.add(new TabEntityNew(titles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        bindingViewLayout.tab.setTabData(entitys);


        bindingViewLayout.tab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (position == 0) {
                    type = "2";
                } else if (position == 1) {
                    type = "0";
                } else if (position == 2) {
                    type = "1";
                }
                requestList();
            }

            @Override
            public void onTabReselect(int position) {
            }
        });


        adapter = new SalerOrderAdapter(this, col);
        bindingViewLayout.list.setAdapter(adapter);

    }


    private void requestNoteRedPoint() {

        Collection.requestDeliveryNoteRedPoint(this, seeDeliveryOrderBean -> {

            if (null != seeDeliveryOrderBean.getData()) {
                setTabTitleMsg(0, seeDeliveryOrderBean.getData().getAllCount());
                setTabTitleMsg(1, seeDeliveryOrderBean.getData().getNoCount());
                setTabTitleMsg(2, seeDeliveryOrderBean.getData().getFinishCount());

            }

        }, throwable -> toast(throwable.getMessage()));

    }


    private void requestList() {
        col.clear();
        Collection.getDeliveryOrder(this, type, "", "", deliveryOrderBean -> {
            col.addAll(deliveryOrderBean.getData());
            adapter.notifyDataSetChanged();
            requestNoteRedPoint();
        }, throwable -> {
            adapter.notifyDataSetChanged();
            hideLoading();
            Log.e("请求失败", throwable.getMessage());
        });


    }


    private void setTabTitleMsg(int position, int mun) {

        bindingViewLayout.tab.showMsg(position, mun);

        if (mun <= 0) {
            bindingViewLayout.tab.hideMsg(position);
        } else if (mun > 0 && mun <= 9) {
            bindingViewLayout.tab.setMsgMargin(position, -5, 15);
        } else if (mun > 9 && mun <= 99) {
            bindingViewLayout.tab.setMsgMargin(position, -11, 15);
        } else if (mun > 99) {
            bindingViewLayout.tab.setMsgMargin(position, -15, 15);
        }

//        MsgView rtv_2_3 = bindingViewLayout.tab.getMsgView(4);
//        if (rtv_2_3 != null) {
//            rtv_2_3.setBackgroundColor(Color.parseColor("#6D8FB0"));
//        }

    }

    private void setLoading() {
        setLoading(bindingViewLayout.refresh);
        bindingViewLayout.refresh.setEnabled(true);
        bindingViewLayout.refresh.setColorSchemeColors(loadingColors);
        bindingViewLayout.refresh.setOnRefreshListener(() -> requestList());
    }

    private void setTopbar() {
        bindingViewLayout.titleBar.toolbar.setTitle("");
        bindingViewLayout.titleBar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        bindingViewLayout.titleBar.title.setText(R.string.salerorder_title);
        setSupportActionBar(bindingViewLayout.titleBar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bindingViewLayout.titleBar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }


}
