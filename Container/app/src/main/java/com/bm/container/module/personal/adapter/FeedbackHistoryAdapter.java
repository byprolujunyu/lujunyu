package com.bm.container.module.personal.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bm.container.R;
import com.bm.container.databinding.ItemFeedbackHistoryBinding;
import com.bm.container.module.personal.bean.FeedbackListBean;

import java.util.ArrayList;

/**
 * @author nfmomo
 * <p>
 * //TODO 注解
 */
public class FeedbackHistoryAdapter extends BaseAdapter { //TODO 改类名
    private Context context;
    private ArrayList<FeedbackListBean.DataBean> col = new ArrayList<>();
    private ItemFeedbackHistoryBinding binding; //TODO 改binding类名
    private MoreCallback moreCallback;
    public SeeReply seeReply;

    public void setSeeReply(SeeReply seeReply) {
        this.seeReply = seeReply;
    }

    public interface SeeReply {
        void see(int positon);
    }

    public FeedbackHistoryAdapter(Context context, ArrayList<FeedbackListBean.DataBean> col) { //TODO 改类名,改实体名
        this.context = context;
        this.col = col;
    }

    public void setMoreCallback(MoreCallback moreCallback) {
        this.moreCallback = moreCallback;
    }

    interface MoreCallback {
        void more(int position, String id);
    }

    @Override
    public int getCount() {
        return col.size();
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
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_feedback_history, vg, false);//TODO 改布局文件
            contentView = binding.getRoot();
            contentView.setTag(binding);
        } else {
            binding = (ItemFeedbackHistoryBinding) contentView.getTag();//TODO 改binding类名
        }

        binding.content.setText(col.get(position).getContent());
        binding.time.setText(col.get(position).getCreateTime());

        binding.contentReply.setText(col.get(position).getFeedBackContent());
        binding.timeReply.setText(col.get(position).getUpdateTime());

        // shifou
        if (col.get(position).getStatus().equals("-100")) {
            binding.more.setText("收起");
            binding.modelReply.setVisibility(View.VISIBLE);
        } else {
            binding.more.setText("查看");
            binding.modelReply.setVisibility(View.GONE);
        }
        binding.more.setOnClickListener(v -> {
            if (seeReply != null) {
                seeReply.see(position);
            }
        });


        return contentView;
    }

}
