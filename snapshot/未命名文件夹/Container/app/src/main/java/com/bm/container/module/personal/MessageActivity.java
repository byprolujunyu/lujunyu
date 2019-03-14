package com.bm.container.module.personal;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.bm.container.R;
import com.bm.container.databinding.ActivityMessageBinding;
import com.bm.container.http.BaseBean;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.personal.adapter.MessageAdapter;
import com.bm.container.module.personal.bean.MessageList;

import java.util.ArrayList;

import io.reactivex.functions.Consumer;

/**
 * P7_7 系统消息
 */
public class MessageActivity extends BaseActivity {
    private ActivityMessageBinding binding;
    private Context context;
    private MessageAdapter adapter;
    private ArrayList<MessageList.DataBean> col = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_message);
        context = this;

        setTopbar();
        setLoading();
        setList();
        getList();

        requestMesssage();

    }

    private void requestMesssage() {

        //获取用户信息
        Collection.messageClick(this, new Consumer<BaseBean>() {
            @Override
            public void accept(BaseBean userInfoBean) throws Exception {

            }
        });

    }

    /**
     * 获取列表
     */
    private void getList() {
        Collection.messageList(this, bean -> {
            col.clear();
            col.addAll(bean.getData());
            adapter.notifyDataSetChanged();
        });
    }


    private void setList() {
        adapter = new MessageAdapter(context, col);
        binding.list.setAdapter(adapter);
        binding.refresh.setOnRefreshListener(() -> {
            getList();
        });

    }

    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(true);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.message_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }

}
