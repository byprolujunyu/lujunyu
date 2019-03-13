package com.bm.container.module.base.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.module.market.bean.InfoBean;
import com.bumptech.glide.Glide;
import com.hongtian.easyroundimageview.EasyRoundImageView;

import java.util.ArrayList;

/**
 * 首页最新买箱信息列表
 */
public class MainBuyAdapter extends RecyclerView.Adapter<MainBuyAdapter.ViewHolder> {
    private ArrayList<InfoBean> col;
    private Context context;
    private OnClickItem onClickItem;

    public MainBuyAdapter(Context context, ArrayList<InfoBean> col) {
        this.col = col;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return col.isEmpty() ? 0 : col.size();
    }

    @SuppressLint("InflateParams")
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int arg1) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_buy, null);
        ViewHolder vh = new ViewHolder(view);

        vh.pic = (EasyRoundImageView) view.findViewById(R.id.pic);
        vh.status = (TextView) view.findViewById(R.id.status);
        vh.type = (TextView) view.findViewById(R.id.type);
        vh.num = (TextView) view.findViewById(R.id.num);
        vh.location = (TextView) view.findViewById(R.id.location);
        vh.people = (TextView) view.findViewById(R.id.people);
        vh.tvTitleName = (TextView) view.findViewById(R.id.tvTitleName);
        vh.item = (LinearLayout) view.findViewById(R.id.item);

        return vh;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        InfoBean bean = col.get(i);

        Glide.with(context).load(Block.listPic(bean.getImageUrl())).placeholder(R.drawable.pic_default).dontAnimate().into(viewHolder.pic);

        if (bean.getContainerStatus().equals("1")) {//正在进行中
            viewHolder.status.setBackground(context.getResources().getDrawable(R.drawable.orange));
        } else {
            viewHolder.status.setBackground(context.getResources().getDrawable(R.drawable.orange));
        }
        viewHolder.tvTitleName.setText(bean.getTitle());
        viewHolder.status.setText(bean.getContainerStatusName());
        viewHolder.type.setText(bean.getContainerTypeName());
        viewHolder.num.setText(bean.getCount());
        viewHolder.location.setText(bean.getCountryName() + "." + bean.getCityName());
        viewHolder.people.setText(bean.getScanCount());
        viewHolder.item.setOnClickListener(v -> {
//			if (SpUtil.getString(SpUtil.USERFLAG).equals("0") && (!bean.getCreateUser().equals(SpUtil.getString(SpUtil.ID)))) {
//				((BaseActivity) context).toast("您是买家身份\n无法查看其他买家发布的买箱信息");
//			} else {
//				Intent intent = null;
//				intent = new Intent(context, PurchaseAActivity.class);
//				intent.putExtra("content", bean);
//				((MainActivity) context).startAc(intent);
//			}
            onClickItem.setOnClickListener(bean);
        });
    }

    public void setOnClick(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }

    public interface OnClickItem {
        void setOnClickListener(InfoBean bean);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private EasyRoundImageView pic;
        private TextView status;
        private TextView type;
        private TextView num;
        private TextView location;
        private TextView people;
        private LinearLayout item;
        public TextView tvTitleName;

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}