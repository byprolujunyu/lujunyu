package com.bm.container.module.personal.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bm.container.R;
import com.bm.container.databinding.ItemFeedbackHistoryListBinding;
import com.bm.container.http.BaseBean;

import java.util.ArrayList;

/**
 * @author nfmomo
 * <p>
 * //TODO 注解
 */
public class FeedbackHistoryListAdapter extends BaseAdapter { //TODO 改类名
    private Context context;
    private ArrayList<BaseBean> col = new ArrayList<BaseBean>(); //TODO 改实体名
    private ItemFeedbackHistoryListBinding binding; //TODO 改binding类名

    public FeedbackHistoryListAdapter(Context context, ArrayList<BaseBean> col) { //TODO 改类名,改实体名
        this.context = context;
        this.col = col;
    }

    @Override
    public int getCount() {
//		return col.size();
        return 2;
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
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_feedback_history_list, vg, false);//TODO 改布局文件
            contentView = binding.getRoot();
            contentView.setTag(binding);
        } else {
            binding = (ItemFeedbackHistoryListBinding) contentView.getTag();//TODO 改binding类名
        }


        return contentView;
    }

}
