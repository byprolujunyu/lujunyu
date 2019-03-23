package com.bm.container.module.market.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.NumberUtils;
import com.bm.container.module.market.bean.InfoBean;
import com.bumptech.glide.Glide;
import com.hongtian.easyroundimageview.EasyRoundImageView;

import java.util.ArrayList;
import java.util.List;


public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.ViewHolder> {
    private List<InfoBean> col;
    private Context context;
    private ArrayList<String> tabs;
    private ItemOnClick temOnClick;

    public MarketAdapter(Context context, ArrayList<InfoBean> col, ArrayList<String> tabs) {
        this.col = col;
        this.context = context;
        this.tabs = tabs;
    }

    @Override
    public int getItemCount() {
        return col.isEmpty() ? 0 : col.size();
    }

    @SuppressLint("InflateParams")
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int arg1) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_market, null);
        ViewHolder vh = new ViewHolder(view);

        vh.pic = (EasyRoundImageView) view.findViewById(R.id.pic);
        vh.lPriceValue = (LinearLayout) view.findViewById(R.id.ll_price_value);
        vh.item = (LinearLayout) view.findViewById(R.id.item);
        vh.name = (TextView) view.findViewById(R.id.name);
        vh.value = (TextView) view.findViewById(R.id.value);
        vh.nameSaleNum = (TextView) view.findViewById(R.id.name_sale_num);
        vh.valueSaleNum = (TextView) view.findViewById(R.id.value_sale_num);
        vh.tip = (TextView) view.findViewById(R.id.tip);
        vh.state = (TextView) view.findViewById(R.id.state);
        vh.type = (TextView) view.findViewById(R.id.type);
        vh.location = (TextView) view.findViewById(R.id.location);
        vh.people = (TextView) view.findViewById(R.id.people);
        vh.tvTitleName = (TextView) view.findViewById(R.id.tvTitleName);
        vh.llTitle = (LinearLayout) view.findViewById(R.id.llTitle);
        vh.llValueSaleNum = (LinearLayout) view.findViewById(R.id.ll_value_sale_num);
        vh.llStatus = (LinearLayout) view.findViewById(R.id.ll_status);
        vh.ll_xiang_status = (LinearLayout) view.findViewById(R.id.ll_xiang_status);
        vh.tvStatus = (TextView) view.findViewById(R.id.tv_status);
        vh.xiang_status = (TextView) view.findViewById(R.id.xiang_status);
        vh.ivType = (ImageView) view.findViewById(R.id.tv_type);

        return vh;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder vh, final int i) {

        InfoBean bean = col.get(i);

        vh.tvTitleName.setText(bean.getTitle());


        if (tabs.get(0).equals("0")) {
            vh.name.setText("数量:");
            vh.tip.setText(R.string.market_tips_buy);
            vh.nameSaleNum.setVisibility(View.GONE);
            vh.valueSaleNum.setVisibility(View.GONE);
            vh.ll_xiang_status.setVisibility(View.VISIBLE);
            vh.state.setBackground(context.getResources().getDrawable(R.drawable.orange));
            vh.value.setText(bean.getCount() + "个");
            vh.xiang_status.setText(bean.getStatusTypeName());
        } else {
            vh.name.setText("报价金额:");
//            vh.tip.setText(R.string.market_tips_saler);
            vh.tip.setText(R.string.market_tips_buy);
            vh.nameSaleNum.setVisibility(View.VISIBLE);
            vh.valueSaleNum.setVisibility(View.VISIBLE);
            vh.ll_xiang_status.setVisibility(View.GONE);
            vh.state.setBackground(context.getResources().getDrawable(R.drawable.orange_light));
            if (bean.getPrice().isEmpty() || bean.getTradeType().equals("1")) {
                vh.value.setText("");
            } else {
//                vh.value.setText(bean.getPrice() + "元");
                vh.value.setText(NumberUtils.formatDouble(Double.valueOf(bean.getPrice())) + "元");
            }
            vh.valueSaleNum.setText(bean.getCount() + "个");
        }


        Glide.with(context).load(Block.listPic(bean.getImageUrl())).placeholder(R.drawable.pic_default).dontAnimate().into(vh.pic);

//        System.out.println("base--getTradeType->" + bean.getTradeType());
//        System.out.println("base--getContainerStatus->" + bean.getContainerStatus());
//        System.out.println("base--getContainerStatusName->" + bean.getContainerStatusName());

        if (bean.getContainerStatus().equals("1")) {//进行中
//            vh.state.setBackground(context.getResources().getDrawable(R.drawable.orange));
            vh.lPriceValue.setVisibility(View.VISIBLE);
//            vh.llValueSaleNum.setVisibility(View.GONE);
            if (bean.getType().equals("0")) {
                vh.state.setBackground(context.getResources().getDrawable(R.drawable.label_dr));
            } else if (bean.getType().equals("1")) {
                vh.state.setBackground(context.getResources().getDrawable(R.drawable.orange));
            }
        } else if (bean.getContainerStatus().equals("2")) {//投标中
            vh.name.setText("投标底价:");
            vh.value.setText(NumberUtils.formatDouble(Double.valueOf(bean.getStartPrice())) + "元");
            vh.state.setBackground(context.getResources().getDrawable(R.drawable.orange));
//            vh.lPriceValue.setVisibility(View.GONE);
//            vh.llValueSaleNum.setVisibility(View.VISIBLE);
        } else if (bean.getContainerStatus().equals("3")) {
            vh.state.setBackground(context.getResources().getDrawable(R.drawable.red));
            vh.lPriceValue.setVisibility(View.VISIBLE);
//            vh.llValueSaleNum.setVisibility(View.GONE);
        } else if (bean.getContainerStatus().equals("4")) {//未付款中
            vh.state.setBackground(context.getResources().getDrawable(R.drawable.red));
            vh.lPriceValue.setVisibility(View.VISIBLE);
//            vh.llValueSaleNum.setVisibility(View.GONE);
        } else if (bean.getContainerStatus().equals("5")) {//已完成
            vh.state.setBackground(context.getResources().getDrawable(R.drawable.red));
            vh.lPriceValue.setVisibility(View.VISIBLE);
        }

        if (!TextUtils.isEmpty(bean.getAppUserType())) {
            vh.ivType.setVisibility(View.VISIBLE);
            if (bean.getAppUserType().equals("0")) {
                //个人
                vh.ivType.setImageResource(R.drawable.user_work_state_lv3);
            } else if (bean.getAppUserType().equals("1")) {
                //公司
                vh.ivType.setImageResource(R.drawable.user_work_state_lv4);
            }
        } else {
            vh.ivType.setVisibility(View.GONE);
        }


        vh.state.setText(bean.getContainerStatusName());
        vh.type.setText(bean.getContainerTypeName());
        vh.location.setText(bean.getCountryName() + "." + bean.getCityName());
        vh.people.setText(bean.getScanCount());

        vh.llStatus.setVisibility(View.GONE);
//        if (!TextUtils.isEmpty(bean.getIsSuccess())) {
//            vh.llStatus.setVisibility(View.VISIBLE);
//            if (bean.getIsSuccess().equals("0")) {
//                vh.tvStatus.setText("进行中");
//            } else if (bean.getIsSuccess().equals("1")) {
//                vh.tvStatus.setText("购买成功");
//            } else if (bean.getIsSuccess().equals("2")) {
//                vh.tvStatus.setText("购买失败");
//            }
//
//        }


        vh.item.setOnClickListener(view -> {
            if (null != temOnClick) {
                temOnClick.setOnClickListener(col.get(i), tabs.get(0));
            }
        });

    }

    public void setItemOnClick(ItemOnClick itemOnClick) {
        this.temOnClick = itemOnClick;
    }

    public interface ItemOnClick {
        void setOnClickListener(InfoBean bean, String vaule);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout item;
        private LinearLayout llTitle, lPriceValue, llValueSaleNum;
        private TextView name, nameSaleNum;
        private TextView value, valueSaleNum;
        private TextView tip;
        private TextView state;
        private TextView type, location, people, tvTitleName;
        private EasyRoundImageView pic;
        public TextView tvStatus;
        public LinearLayout llStatus;
        public ImageView ivType;
        public LinearLayout ll_xiang_status;
        public TextView xiang_status;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}