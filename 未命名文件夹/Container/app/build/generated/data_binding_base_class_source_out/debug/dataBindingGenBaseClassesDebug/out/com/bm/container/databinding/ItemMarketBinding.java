package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hongtian.easyroundimageview.EasyRoundImageView;

public abstract class ItemMarketBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout item;

  @NonNull
  public final LinearLayout llPriceValue;

  @NonNull
  public final LinearLayout llStatus;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final LinearLayout llValueSaleNum;

  @NonNull
  public final LinearLayout llXiangStatus;

  @NonNull
  public final TextView location;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView nameSaleNum;

  @NonNull
  public final TextView people;

  @NonNull
  public final EasyRoundImageView pic;

  @NonNull
  public final TextView state;

  @NonNull
  public final TextView tip;

  @NonNull
  public final TextView tvStatus;

  @NonNull
  public final TextView tvTitleName;

  @NonNull
  public final ImageView tvType;

  @NonNull
  public final TextView type;

  @NonNull
  public final TextView value;

  @NonNull
  public final TextView valueSaleNum;

  @NonNull
  public final TextView xiangStatus;

  protected ItemMarketBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout item, LinearLayout llPriceValue, LinearLayout llStatus,
      LinearLayout llTitle, LinearLayout llValueSaleNum, LinearLayout llXiangStatus,
      TextView location, TextView name, TextView nameSaleNum, TextView people,
      EasyRoundImageView pic, TextView state, TextView tip, TextView tvStatus, TextView tvTitleName,
      ImageView tvType, TextView type, TextView value, TextView valueSaleNum,
      TextView xiangStatus) {
    super(_bindingComponent, _root, _localFieldCount);
    this.item = item;
    this.llPriceValue = llPriceValue;
    this.llStatus = llStatus;
    this.llTitle = llTitle;
    this.llValueSaleNum = llValueSaleNum;
    this.llXiangStatus = llXiangStatus;
    this.location = location;
    this.name = name;
    this.nameSaleNum = nameSaleNum;
    this.people = people;
    this.pic = pic;
    this.state = state;
    this.tip = tip;
    this.tvStatus = tvStatus;
    this.tvTitleName = tvTitleName;
    this.tvType = tvType;
    this.type = type;
    this.value = value;
    this.valueSaleNum = valueSaleNum;
    this.xiangStatus = xiangStatus;
  }

  @NonNull
  public static ItemMarketBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMarketBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMarketBinding>inflate(inflater, com.bm.container.R.layout.item_market, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMarketBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMarketBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMarketBinding>inflate(inflater, com.bm.container.R.layout.item_market, null, false, component);
  }

  public static ItemMarketBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemMarketBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemMarketBinding)bind(component, view, com.bm.container.R.layout.item_market);
  }
}
