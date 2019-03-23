package com.bm.container.module.login.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bm.container.R;
import com.bm.container.module.base.Entity.CityEntity;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ContactsViewHolder> {

    private List<CityEntity> col;

    private ChooseCity chooseCity;

    public void setChooseCity(ChooseCity chooseCity) {
        this.chooseCity = chooseCity;
    }

    public interface ChooseCity {
        void chooose(String city, String id, boolean reCity);
    }

    public CityAdapter(List<CityEntity> col) {
        this.col = col;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_city, null);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {

//        System.out.println("base-0-->"+position);
//        System.out.println("base-0-->"+col.get(position).getCityName());

        if (position != 0 && col.get(position).getFirstWord().charAt(0) == col.get(position - 1).getFirstWord().charAt(0)) {
            holder.abc.setVisibility(View.GONE);
        } else {
            holder.abc.setText("" + col.get(position).getFirstWord().charAt(0));
            holder.abc.setVisibility(View.VISIBLE);
        }

        if (position != 0 && col.get(position).getClick()) {
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
                chooseCity.chooose(col.get(position).getCityName(), col.get(position).getId(), col.get(position).getClick());
            }
        });

    }

    @Override
    public int getItemCount() {
        return col.size();
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
