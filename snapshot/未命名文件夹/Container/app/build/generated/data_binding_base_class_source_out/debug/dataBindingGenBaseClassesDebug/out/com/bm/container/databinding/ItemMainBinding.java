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

public abstract class ItemMainBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout item;

  @NonNull
  public final ImageView ivType;

  @NonNull
  public final LinearLayout llPriceValue;

  @NonNull
  public final LinearLayout llValueSaleNum;

  @NonNull
  public final TextView location;

  @NonNull
  public final TextView money;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView nameSaleNum;

  @NonNull
  public final TextView people;

  @NonNull
  public final EasyRoundImageView pic;

  @NonNull
  public final TextView status;

  @NonNull
  public final TextView titleName;

  @NonNull
  public final TextView type;

  @NonNull
  public final TextView valueSaleNum;

  @NonNull
  public final TextView yuan;

  protected ItemMainBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout item, ImageView ivType, LinearLayout llPriceValue,
      LinearLayout llValueSaleNum, TextView location, TextView money, TextView name,
      TextView nameSaleNum, TextView people, EasyRoundImageView pic, TextView status,
      TextView titleName, TextView type, TextView valueSaleNum, TextView yuan) {
    super(_bindingComponent, _root, _localFieldCount);
    this.item = item;
    this.ivType = ivType;
    this.llPriceValue = llPriceValue;
    this.llValueSaleNum = llValueSaleNum;
    this.location = location;
    this.money = money;
    this.name = name;
    this.nameSaleNum = nameSaleNum;
    this.people = people;
    this.pic = pic;
    this.status = status;
    this.titleName = titleName;
    this.type = type;
    this.valueSaleNum = valueSaleNum;
    this.yuan = yuan;
  }

  @NonNull
  public static ItemMainBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMainBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMainBinding>inflate(inflater, com.bm.container.R.layout.item_main, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMainBinding>inflate(inflater, com.bm.container.R.layout.item_main, null, false, component);
  }

  public static ItemMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemMainBinding bind(@NonNull View view, @Nullable DataBindingComponent component) {
    return (ItemMainBinding)bind(component, view, com.bm.container.R.layout.item_main);
  }
}
