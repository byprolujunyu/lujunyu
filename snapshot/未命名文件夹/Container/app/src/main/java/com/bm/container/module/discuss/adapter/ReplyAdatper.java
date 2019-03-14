package com.bm.container.module.discuss.adapter;

/**
 * Created by nfmomo on 17/3/3.
 */

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bm.container.R;
import com.bm.container.databinding.ItemReplyBinding;
import com.bm.container.module.discuss.bean.DiscussListBean;
import com.bm.container.view.TextUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nfmomo
 * <p>
 * //TODO 注解
 */
public class ReplyAdatper extends BaseAdapter { //TODO 改类名
    private Context context;
    private List<DiscussListBean.DataBean.CommentListBean> col = new ArrayList<>(); //TODO 改实体名
    private ItemReplyBinding binding; //TODO 改binding类名

    private ReplyReplyCallback replyCallback;

    public void setReplyReplyCallback(ReplyReplyCallback replyCallback) {
        this.replyCallback = replyCallback;
    }

    public interface ReplyReplyCallback {
        void reply(String targetId, String targetName);
    }


    public ReplyAdatper(Context context, List<DiscussListBean.DataBean.CommentListBean> col) { //TODO 改类名,改实体名
        this.context = context;
        this.col = col;
    }

    @Override
    public int getCount() {
        Log.e("数量", "" + col.size());
        return col.size();
//		return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View contentView, ViewGroup vg) {

        if (contentView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_reply, vg, false);//TODO 改布局文件
            contentView = binding.getRoot();
            contentView.setTag(binding);
        } else {
            binding = (ItemReplyBinding) contentView.getTag();//TODO 改binding类名
        }

        ArrayList<String> str_list = new ArrayList<>();
        ArrayList<Integer> color_list = new ArrayList<>();

        binding.reply.setOnClickListener(v -> {
            if (replyCallback != null) {
                replyCallback.reply(col.get(position).getCreateUser(), col.get(position).getCreateUserName());
            }
        });

        if (col.get(position).getTargetUserName().isEmpty()) {
            str_list.add(col.get(position).getCreateUserName() + ": ");
            color_list.add(context.getResources().getColor(R.color.colorPrimary));
            str_list.add(col.get(position).getContent());
            color_list.add(context.getResources().getColor(R.color.grey_deep));
            TextUtil.setText(context, binding.reply, str_list, color_list, null);
        } else {
            str_list.add(col.get(position).getCreateUserName());
            color_list.add(context.getResources().getColor(R.color.colorPrimary));
            str_list.add("回复");
            color_list.add(context.getResources().getColor(R.color.grey_deep));
            str_list.add(col.get(position).getTargetUserName() + ": ");
            color_list.add(context.getResources().getColor(R.color.colorPrimary));
            str_list.add(col.get(position).getContent());
            color_list.add(context.getResources().getColor(R.color.grey_deep));
            TextUtil.setText(context, binding.reply, str_list, color_list, null);
        }
        return contentView;
    }

}

