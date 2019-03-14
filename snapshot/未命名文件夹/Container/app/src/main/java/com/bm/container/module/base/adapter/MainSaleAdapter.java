package com.bm.container.module.base.adapter;

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


public class MainSaleAdapter extends RecyclerView.Adapter<MainSaleAdapter.ViewHolder> {
    private ArrayList<InfoBean> col;
    private Context context;
    private SellBoxItemOnClick sellBoxItemOnClick;

    public MainSaleAdapter(Context context, ArrayList<InfoBean> col) {
        this.col = col;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return col.isEmpty() ? 0 : col.size();
    }

    @SuppressLint("InflateParams")
    @Override
    public MainSaleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int arg1) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, null);
        MainSaleAdapter.ViewHolder vh = new MainSaleAdapter.ViewHolder(view);

        vh.pic = (EasyRoundImageView) view.findViewById(R.id.pic);
        vh.status = (TextView) view.findViewById(R.id.status);
        vh.type = (TextView) view.findViewById(R.id.type);
        vh.money = (TextView) view.findViewById(R.id.money);
        vh.location = (TextView) view.findViewById(R.id.location);
        vh.people = (TextView) view.findViewById(R.id.people);
        vh.item = (LinearLayout) view.findViewById(R.id.item);

        vh.name = (TextView) view.findViewById(R.id.name);
        vh.llPriceValue = (LinearLayout) view.findViewById(R.id.ll_price_value);
        vh.llValueSaleNum = (LinearLayout) view.findViewById(R.id.ll_value_sale_num);
        vh.yuan = (TextView) view.findViewById(R.id.yuan);
        vh.valueSalenNum = (TextView) view.findViewById(R.id.value_sale_num);
        vh.titleName = (TextView) view.findViewById(R.id.titleName);
        vh.ivType = (ImageView) view.findViewById(R.id.iv_type);

        return vh;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final MainSaleAdapter.ViewHolder viewHolder, final int i) {

        InfoBean bean = col.get(i);

        viewHolder.titleName.setText(bean.getTitle());

        Glide.with(context).load(Block.listPic(bean.getImageUrl())).placeholder(R.drawable.pic_default).dontAnimate().into(viewHolder.pic);
        viewHolder.status.setText(bean.getContainerStatusName());


        viewHolder.type.setText(bean.getContainerTypeName());
        if (bean.getTradeType().equals("0")) {
//			viewHolder.money.setText(bean.getPrice());
            if (!TextUtils.isEmpty(bean.getPrice())) {
                viewHolder.money.setText(NumberUtils.formatDouble(Double.valueOf(bean.getPrice())) + "元");
            }
            viewHolder.yuan.setVisibility(View.VISIBLE);
        } else {
            viewHolder.money.setText("");
            viewHolder.yuan.setVisibility(View.GONE);
        }

        if (bean.getTradeType().equals("0")) {//销售中
            viewHolder.name.setText("报价金额:");
            viewHolder.status.setBackground(context.getResources().getDrawable(R.drawable.red));
        } else if (bean.getTradeType().equals("1")) {//投标中
            viewHolder.name.setText("投标底价:");
            viewHolder.money.setText(NumberUtils.formatDouble(Double.valueOf(bean.getStartPrice())) + "元");
            viewHolder.status.setBackground(context.getResources().getDrawable(R.drawable.orange));
        }

        if (!TextUtils.isEmpty(bean.getAppUserType())) {
            viewHolder.ivType.setVisibility(View.VISIBLE);
            if (bean.getAppUserType().equals("0")) {
                //个人
                viewHolder.ivType.setImageResource(R.drawable.user_work_state_lv3);
            } else if (bean.getAppUserType().equals("1")) {
                //公司
                viewHolder.ivType.setImageResource(R.drawable.user_work_state_lv4);
            }
        } else {
            viewHolder.ivType.setVisibility(View.GONE);
        }


        viewHolder.valueSalenNum.setText(bean.getCount() + "个");
        viewHolder.location.setText(bean.getCountryName() + "." + bean.getCityName());
        viewHolder.people.setText(bean.getScanCount());
        viewHolder.item.setOnClickListener(v -> {
//			Intent intent = null;
//			if (bean.getTradeType().equals("0")) {//出售
//				intent = new Intent(context, SaleAActivity.class);
//			} else {//竞标
//				intent = new Intent(context, SaleBActivity.class);
//			}
//			intent.putExtra("content", bean);
//			((MainActivity) context).startAc(intent);
//			System.out.println("base------>"+bean.getBillType());
            sellBoxItemOnClick.setOnClickListener(bean);
        });

    }

    public void setOnItemClick(SellBoxItemOnClick sellBoxItemOnClick) {
        this.sellBoxItemOnClick = sellBoxItemOnClick;
    }

    public interface SellBoxItemOnClick {
        void setOnClickListener(InfoBean bean);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private EasyRoundImageView pic;
        private TextView status;
        private TextView type;
        private TextView money;
        private TextView location;
        private TextView people;
        private LinearLayout item, llPriceValue, llValueSaleNum;
        private TextView yuan;
        private TextView valueSalenNum;
        private TextView titleName;
        public ImageView ivType;
        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}