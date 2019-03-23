package com.bm.container.module.discuss.adapter;

/**
 * Created by nfmomo on 17/3/3.
 */

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.bm.container.R;
import com.bm.container.Tools.Block;
import com.bm.container.databinding.ItemChooseImageBinding;
import com.bm.container.module.discuss.SendImageActivity;
import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nfmomo
 * <p>
 * //TODO 注解
 */
public class ChooseImageAdatper extends BaseAdapter { //TODO 改类名
    private Context context;
    private List<File> col = new ArrayList<>(); //TODO 改实体名
    private ItemChooseImageBinding binding; //TODO 改binding类名
    private DeleteCallback deleteCallback;

    public void setDeleteCallback(DeleteCallback deleteCallback) {
        this.deleteCallback = deleteCallback;
    }

    public interface DeleteCallback {
        void delete(int position);
    }

    public ChooseImageAdatper(Context context, List<File> col) { //TODO 改类名,改实体名
        this.context = context;
        this.col = col;
    }

    @Override
    public int getCount() {
        if (col.size() == 9) {
            return 9;
        } else {
            return col.size() + 1;
        }
//		return 1;
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
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_choose_image, vg, false);//TODO 改布局文件
            contentView = binding.getRoot();
            contentView.setTag(binding);
        } else {
            binding = (ItemChooseImageBinding) contentView.getTag();//TODO 改binding类名
        }


        if ((col.size() != 9 && position != col.size())) {
            int myPosition = position;
            Glide.with(context).load(col.get(myPosition)).into(binding.image);
            binding.delete.setVisibility(View.VISIBLE);
            binding.delete.setOnClickListener(v -> {
                if (deleteCallback != null) {
                    deleteCallback.delete(myPosition);
                }
            });
        } else if (col.size() == 9) {
            Glide.with(context).load(col.get(position)).into(binding.image);
            binding.delete.setVisibility(View.VISIBLE);
            binding.delete.setOnClickListener(v -> {
                if (deleteCallback != null) {
                    deleteCallback.delete(position);
                }
            });
            binding.image.setOnClickListener(v -> {

            });
        } else {
            Glide.with(context).load(R.drawable.choose_pic).into(binding.image);
            binding.delete.setVisibility(View.GONE);
            binding.image.setOnClickListener(v -> {
                try {
                    Block.getPic((SendImageActivity) context, (9 - col.size()));
                } catch (Exception e) {
                    Toast.makeText(context, "操作失败.", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            });
        }

        return contentView;
    }

}

