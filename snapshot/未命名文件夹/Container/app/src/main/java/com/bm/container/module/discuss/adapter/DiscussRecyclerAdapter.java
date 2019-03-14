package com.bm.container.module.discuss.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.Tools.SpUtil;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.base.WebActivity;
import com.bm.container.module.discuss.bean.BannerBean;
import com.bm.container.module.discuss.bean.DiscussListBean;
import com.bm.container.view.CircleImageView;
import com.bm.container.view.ExtraGridView;
import com.bm.container.view.ExtraListView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nfmomo on 17/4/14.
 */

public class DiscussRecyclerAdapter extends RecyclerView.Adapter<DiscussRecyclerAdapter.MyHolder> {
    //Type
    private int TYPE_NORMAL = 1000;
    private int TYPE_HEADER = 1001;
    //Data
    private Context context;
    private ArrayList<DiscussListBean.DataBean> col = new ArrayList<>(); //TODO 改实体名
    private List<BannerBean.DataBean> bannerCol = new ArrayList<>();
    //点击接口
    private DiscussAdapter.ReplyCallback replyCallback;
    //是否有轮播图
    private boolean hasBanner = true;

    public void setReplyCallback(DiscussAdapter.ReplyCallback replyCallback) {
        this.replyCallback = replyCallback;
    }

    public interface ReplyCallback {
        void reply(String id, String targetId, String targetName);
    }

    //点赞接口
    private ZanCallback zanCallback;

    public void setZanCallback(ZanCallback zanCallback) {
        this.zanCallback = zanCallback;
    }

    public interface ZanCallback {
        void reply(String id, int positon, boolean wantToZan);
    }

    public DiscussRecyclerAdapter(Context context, ArrayList<DiscussListBean.DataBean> col, List<BannerBean.DataBean> bannerCol, boolean hasBanner) {
        this.context = context;
        this.col = col;
        this.bannerCol = bannerCol;
        this.hasBanner = hasBanner;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && hasBanner) {
            return TYPE_HEADER;
        } else {
            return TYPE_NORMAL;
        }
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_NORMAL) {
            return new MyHolder(getLayout(R.layout.item_discuss, parent));
        } else {
            return new MyHolder(getLayout(R.layout.item_discuss_banner, parent));
        }
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        if (position != 0 || !hasBanner) {
            if (hasBanner) {
                --position;
            }
            int finalPosition = position;

            TextView name = (TextView) holder.itemView.findViewById(R.id.name);
            CircleImageView face = (CircleImageView) holder.itemView.findViewById(R.id.face);
            TextView content = (TextView) holder.itemView.findViewById(R.id.content);
            TextView all = (TextView) holder.itemView.findViewById(R.id.all);
            ExtraGridView image = (ExtraGridView) holder.itemView.findViewById(R.id.image);
            TextView zanNum = (TextView) holder.itemView.findViewById(R.id.zan_num);
            TextView replyNum = (TextView) holder.itemView.findViewById(R.id.reply_num);
            ExtraListView list = (ExtraListView) holder.itemView.findViewById(R.id.list);
            LinearLayout modelReply = (LinearLayout) holder.itemView.findViewById(R.id.model_reply);
            LinearLayout modelZan = (LinearLayout) holder.itemView.findViewById(R.id.model_zan);
            ImageView zanPic = (ImageView) holder.itemView.findViewById(R.id.zan_pic);
            RelativeLayout modelTop = (RelativeLayout) holder.itemView.findViewById(R.id.model_top);

            //头像
            Glide.with(context).load(Block.resolvePic(col.get(position).getHeadImageUrl())).placeholder(R.drawable.face).dontAnimate().into(face);
            //姓名
            name.setText(col.get(position).getCreateUserName());
            //点赞数
            zanNum.setText(col.get(position).getZanCount());
            if (col.get(position).getIsZan().equals("1")) {
                Glide.with(context).load(R.drawable.good).into(zanPic);
            } else {
                Glide.with(context).load(R.drawable.zan_empty).into(zanPic);
            }
            modelZan.setOnClickListener(v -> {
                if (zanCallback != null && col.get(finalPosition).getIsZan().equals("1")) {
                    zanCallback.reply(col.get(finalPosition).getId(), finalPosition, false);
                } else {
                    zanCallback.reply(col.get(finalPosition).getId(), finalPosition, true);
                }
            });
            //回帖数
            replyNum.setText(col.get(position).getCommentCount());
            modelReply.setOnClickListener(v -> {
                if (replyCallback != null) {
                    replyCallback.reply(col.get(finalPosition).getId(), "", "", col.get(finalPosition).getCreateUserName());
                }
            });
            //帖子内容
            String tempContent = col.get(position).getContent();
            content.setText(tempContent);
            if (tempContent.length() > 100) {
                all.setVisibility(View.VISIBLE);
                content.setText(tempContent.substring(0, 100));
            } else {
                all.setVisibility(View.GONE);
            }
            all.setOnClickListener(new DiscussRecyclerAdapter.MyAdapterListener(tempContent, all, content));
            //图片
            if (col.get(position).getImageUrl().isEmpty()) {
                image.setVisibility(View.GONE);
            } else {
                image.setVisibility(View.VISIBLE);
                ImageAdatper adatper = new ImageAdatper(context, col.get(position).getImageUrl());
                image.setAdapter(adatper);
            }
            //回复列表
            if (col.get(position).getCommentList().size() == 0) {
                list.setVisibility(View.GONE);
                modelTop.setVisibility(View.GONE);
            } else {
                list.setVisibility(View.VISIBLE);
                modelTop.setVisibility(View.VISIBLE);
                ReplyAdatper replyAdatper = new ReplyAdatper(context, col.get(position).getCommentList());
                replyAdatper.setReplyReplyCallback((targetId, targetName) -> {
                    if (!targetId.equals(SpUtil.getString(SpUtil.ID))) {
                        if (replyCallback != null) {
                            replyCallback.reply(col.get(finalPosition).getId(), targetId, targetName, col.get(finalPosition).getCreateUserName());
                        }
                    }
                });
                list.setAdapter(replyAdatper);
            }

        } else {
            ConvenientBanner banner = (ConvenientBanner) holder.itemView.findViewById(R.id.banner);

            if (null != bannerCol && bannerCol.size() > 1) {
                if (!banner.isTurning()) {
                    banner.startTurning(4000);
                }
            }

            Block.autoHeight(banner, (BaseActivity) context);
            banner.setPageIndicator(new int[]{R.drawable.circle_grey, R.drawable.circle_blue})
                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)

                    .setPages(new CBViewHolderCreator() {
                        @Override
                        public Object createHolder() {
                            return new BannerHolder();
                        }
                    }, bannerCol);
        }
    }

    @Override
    public int getItemCount() {
        if (hasBanner) {
            return col.size() + 1;
        } else {
            return col.size();
        }

    }

    private View getLayout(int layoutId, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(layoutId, parent, false);
    }


    public static class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);
        }
    }

    class MyAdapterListener implements View.OnClickListener {

        private TextView all;
        private TextView content;
        private String info;

        public MyAdapterListener(String info, TextView all, TextView content) {
            this.all = all;
            this.content = content;
            this.info = info;
        }

        @Override
        public void onClick(View v) {
            if (all.getText().equals("全部")) {
                all.setText("收起");
                content.setText(info);
            } else {
                all.setText("全部");
                content.setText(info.substring(0, 100));
            }
        }
    }

    public class BannerHolder implements Holder<BannerBean.DataBean> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
//			imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
//			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, BannerBean.DataBean data) {
            Glide.with(context).load(Block.resolvePic(data.getImageUrl())).placeholder(R.drawable.banner1).dontAnimate().into(imageView);
            imageView.setOnClickListener(v -> {
                Intent i = new Intent(context, WebActivity.class);
                i.putExtra("url", data.getLinkedUrl());
                ((BaseActivity) context).startAc(i);
            });
        }
    }

}
