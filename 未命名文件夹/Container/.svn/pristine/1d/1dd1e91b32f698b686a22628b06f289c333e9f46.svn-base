package com.bm.container.module.login.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bm.container.R;
import com.bm.container.module.base.Entity.CityEntity;

import java.util.List;

public class MyCityAdapter extends BaseAdapter {

    private List<CityEntity> col;

    private ChooseCity chooseCity;


    public MyCityAdapter(List<CityEntity> col) {
        this.col = col;
    }

    @Override
    public int getCount() {
        return null != col ? col.size() : 0;
    }

    @Override
    public CityEntity getItem(int position) {
        return null != col ? col.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ContactsViewHolder holder;
        if (null == convertView) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, null);
            holder = new ContactsViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ContactsViewHolder) convertView.getTag();
        }


        if (position != 0 && getItem(position).getFirstWord().charAt(0) == col.get(position - 1).getFirstWord().charAt(0)) {
            holder.abc.setVisibility(View.GONE);
        } else {
            holder.abc.setText("" + getItem(position).getFirstWord().charAt(0));
            holder.abc.setVisibility(View.VISIBLE);
        }

        if (getItem(position).getClick()) {
            holder.ivClick.setImageResource(R.drawable.checked_square);
        } else {
            holder.ivClick.setImageResource(R.drawable.unchecked_square);
        }

        holder.city.setText(col.get(position).getCityName());
        holder.llcity.setOnClickListener(view -> {
            if (chooseCity != null) {
//                System.out.println("base-1-position->"+position);
//                System.out.println("base-1-getId->"+col.get(position).getId());
//                System.out.println("base-1-getCityName->"+col.get(position).getCityName());
//                System.out.println("base-1-getClick->"+col.get(position).getClick());
//                chooseCity.chooose(col.get(position).getCityName(), col.get(position).getId(), col.get(position).getClick());
                chooseCity.chooose(getItem(position));
            }
        });

        return convertView;
    }


    public void setChooseCity(ChooseCity chooseCity) {
        this.chooseCity = chooseCity;
    }

    public interface ChooseCity {
        void chooose(CityEntity cityEntity);
    }


    class ContactsViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout llcity;
        public ImageView ivClick;
        public TextView abc;
        public TextView city;

        public ContactsViewHolder(View itemView) {
            super(itemView);
            abc = (TextView) itemView.findViewById(R.id.abc);
            city = (TextView) itemView.findViewById(R.id.city);
            llcity = (LinearLayout) itemView.findViewById(R.id.llcity);
            ivClick = (ImageView) itemView.findViewById(R.id.ivClick);
        }
    }
}
