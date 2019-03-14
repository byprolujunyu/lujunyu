package com.bm.container.module.personal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import com.bm.container.R;
import com.bm.container.databinding.ActivityMyOrderBinding;
import com.bm.container.http.Collection;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.market.PayActivity;
import com.bm.container.module.personal.adapter.MyOrderAdapter;
import com.bm.container.module.personal.bean.OrderBean;
import com.bm.container.view.OrderNoDialog;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * P7_3 我的订单
 */
public class MyOrderActivity extends BaseActivity {

    private ActivityMyOrderBinding binding;
    private Context context;
    private MyOrderAdapter adapter;
    private ArrayList<CustomTabEntity> entitys = new ArrayList<>();
    private String[] titles = {"全部", "待付款", "已付款", "待提货", "已完成"};
    private String type = "";
    private ArrayList<OrderBean> col = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_order);
        context = this;
        setTopbar();
        setLoading();
        setTab();
        setList();

    }


    @Override
    protected void onResume() {
        super.onResume();
        requestList();
        requestNoteRedPoint();
    }

    private void requestNoteRedPoint() {

        Collection.requestContainerOrderRedPoint(this, seeDeliveryOrderBean -> {

            if (null != seeDeliveryOrderBean.getData()) {
                setTabTitleMsg(0, seeDeliveryOrderBean.getData().getAllCount());
                setTabTitleMsg(1, seeDeliveryOrderBean.getData().getNoCount());
                setTabTitleMsg(2, seeDeliveryOrderBean.getData().getOkCount());
                setTabTitleMsg(3, seeDeliveryOrderBean.getData().getDeliveryCount());
                setTabTitleMsg(4, seeDeliveryOrderBean.getData().getFinishCount());
            }

        });

    }

    /**
     * 请求列表
     */
    private void requestList() {
        Collection.getOrderList(this, type, orderBean -> {
            col.clear();
            col.addAll(orderBean.getData());
            adapter.notifyDataSetChanged();
        }, throwable -> {
            col.clear();
            adapter.notifyDataSetChanged();
            MyOrderActivity.this.hideLoading();
            Log.e("请求失败", throwable.getMessage());
        });
    }


    /**
     * 标签设定
     */
    private void setTab() {
        for (int i = 0; i < 5; i++) {
            entitys.add(new TabEntity(titles[i]));
        }
        binding.tab.setTabData(entitys);
        binding.tab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (position == 0) {
                    type = "";
                } else {
                    type = position + "";
                }
                requestList();
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }

    /**
     * 定义标签实体
     */
    class TabEntity implements CustomTabEntity {
        private String title;

        public TabEntity(String title) {
            this.title = title;
        }

        @Override
        public String getTabTitle() {
            return title;
        }

        @Override
        public int getTabSelectedIcon() {
            return R.mipmap.ic_launcher;
        }

        @Override
        public int getTabUnselectedIcon() {
            return R.mipmap.ic_launcher;
        }
    }

    /**
     * 设定列表
     */
    private void setList() {
        adapter = new MyOrderAdapter(context, col);
        adapter.setSetClick((type1, bean) -> {
            if (type1 == 0) {
                cancelOrder(bean);
            } else if (type1 == 1) {
//                showOrderNoDialog(bean);
                Intent intent = new Intent(MyOrderActivity.this, FillInTheMailboxActivity.class);
                intent.putExtra("orderNo", bean.getOrderNo());
                startAc(intent);
            } else if (type1 == 2) {
                Intent i = new Intent(MyOrderActivity.this, PayActivity.class);
                i.putExtra("orderType", "2");
                i.putExtra("orderNo", bean.getOrderNo());
                i.putExtra("orderPrice", bean.getPrice());
                startAc(i);
            } else if (type1 == 3) {
                //催单
                requestRemind(bean.getOrderNo());
            } else if (type1 == 4) {
                //填写提货单
                Intent i = new Intent(context, BillOfLadingActivity.class);
                i.putExtra("type", "0");
                i.putExtra("orderNo", bean.getOrderNo());
                i.putExtra("orderStatus", bean.getIsDelivery());
                startAc(i);
            }
        });
        binding.list.setAdapter(adapter);
    }

    /**
     * 请求催单
     */
    private void requestRemind(String orderNo) {

        Collection.requestRemind(this, orderNo, orderBean -> {

//            toast(orderBean.getMsg());
            dialog("催单成功，请勿连续催单！谢谢配合！");

        }, throwable -> {
            toast(throwable.getMessage());
        });

    }

    /**
     * 显示订单框
     */
    private void showOrderNoDialog(OrderBean bean) {
        OrderNoDialog alert = new OrderNoDialog.Builder(this)// builder
                .setTitle("填写箱号") //TODO 标题
                .setPositiveButton((content, dialog) -> {
                    if (content.isEmpty()) {
                        toast("请填写箱号");
                    } else {
                        Collection.changContainerNo(MyOrderActivity.this, bean.getOrderNo(), content, baseBean -> {
                            dialog.dismiss();
                            MyOrderActivity.this.dialog(baseBean.getMsg());
                            requestList();
                        });

                    }
                })
                .setNegativeButton((content, dialog) -> {
                    dialog.dismiss();
                })
                .create();
        alert.show();
    }

    /**
     * 取消订单
     */
    private void cancelOrder(OrderBean bean) {

        dialog("是否取消当前订单？", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Collection.cancelOrder(MyOrderActivity.this, bean.getOrderNo(), baseBean -> {
                    dialog.dismiss();
                    requestList();
                    requestNoteRedPoint();
                    dialog("取消成功");
                });

            }
        });


    }

    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(true);
        binding.refresh.setColorSchemeColors(loadingColors);
        binding.refresh.setOnRefreshListener(() -> requestList());
    }

    private void setTopbar() {
        binding.topbar.toolbar.setTitle("");
        binding.topbar.toolbar.setNavigationIcon(R.drawable.toolbar_back);
        binding.topbar.title.setText(R.string.myorder_title);
        setSupportActionBar(binding.topbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.topbar.toolbar.setNavigationOnClickListener(view -> finishAc());
    }


    private void setTabTitleMsg(int position, int mun) {

        binding.tab.showMsg(position, mun);

        if (mun <= 0) {
            binding.tab.hideMsg(position);
        } else if (mun > 0 && mun <= 9) {
            binding.tab.setMsgMargin(position, -5, 15);
        } else if (mun > 9 && mun <= 99) {
            binding.tab.setMsgMargin(position, -11, 15);
        } else if (mun > 99) {
            binding.tab.setMsgMargin(position, -15, 15);
        }

//        MsgView rtv_2_3 = bindingViewLayout.tab.getMsgView(4);
//        if (rtv_2_3 != null) {
//            rtv_2_3.setBackgroundColor(Color.parseColor("#6D8FB0"));
//        }

    }

}
