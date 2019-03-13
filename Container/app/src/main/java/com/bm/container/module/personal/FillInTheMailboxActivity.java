package com.bm.container.module.personal;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.bm.container.R;
import com.bm.container.databinding.FillTheMaillboxLayoutBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.personal.adapter.ChestAdapter;

import java.util.ArrayList;

/**
 * Created by kec on 2017/7/10.
 */

public class FillInTheMailboxActivity extends BaseActivity {

    private FillTheMaillboxLayoutBinding bindView;

    private ArrayList<String> colChest = new ArrayList<>();
    private ChestAdapter adapterChest;
    private String orderNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView = DataBindingUtil.setContentView(this, R.layout.fill_the_maillbox_layout);
        setTopbar();

        if (null != getIntent()) {
            orderNo = getIntent().getStringExtra("orderNo");
        }

        addChest();

        deleteChest();

        //t提交
        bindView.tvSubmit.setOnClickListener(v -> {

            String containerNo = "";
            if (null != colChest && colChest.size() > 0) {
                for (int i = 0; i < colChest.size(); i++) {
                    containerNo = containerNo + colChest.get(i) + ",";
                }
            }

            if (containerNo.isEmpty()) {
                toast("请填写箱号");
            } else {
                Collection.changContainerNo(FillInTheMailboxActivity.this, orderNo, containerNo, baseBean -> {
                    if (!TextUtils.isEmpty(baseBean.getMsg()) && !baseBean.getMsg().equals("订单已完成")) {
                        FillInTheMailboxActivity.this.dialogFinish("订单已完成");
                    } else {
                        FillInTheMailboxActivity.this.dialogFinish(baseBean.getMsg());
                    }
                });

            }

        });

    }


    private void addChest() {
        bindView.addChest.setOnClickListener(view -> {
            if (bindView.inputChest.getText().toString().isEmpty()) {
                toast("请填入箱号");
            } else {
                colChest.add(bindView.inputChest.getText().toString());
                adapterChest.notifyDataSetChanged();
                bindView.inputChest.setText("");
            }

        });
    }

    private void deleteChest() {
        adapterChest = new ChestAdapter(this, colChest, "2");
        adapterChest.setDeleteInterface(position -> {
            colChest.remove(position);
            adapterChest.notifyDataSetChanged();
        });
        bindView.listChest.setAdapter(adapterChest);
    }


    private void setTopbar() {
        bindView.topbar.toolbar.setTitle("");
        bindView.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        bindView.topbar.title.setText(R.string.tianjiaxianghao);
        setSupportActionBar(bindView.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bindView.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }

}
