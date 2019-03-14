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

public abstract class ItemMainBuyBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout item;

  @NonNull
  public final ImageView ivType;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final TextView location;

  @NonNull
  public final TextView num;

  @NonNull
  public final TextView people;

  @NonNull
  public final EasyRoundImageView pic;

  @NonNull
  public final TextView status;

  @NonNull
  public final TextView tvStatus;

  @NonNull
  public final TextView tvTitleName;

  @NonNull
  public final TextView type;

  protected ItemMainBuyBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout item, ImageView ivType, LinearLayout llTitle,
      TextView location, TextView num, TextView people, EasyRoundImageView pic, TextView status,
      TextView tvStatus, TextView tvTitleName, TextView type) {
    super(_bindingComponent, _root, _localFieldCount);
    this.item = item;
    this.ivType = ivType;
    this.llTitle = llTitle;
    this.location = location;
    this.num = num;
    this.people = people;
    this.pic = pic;
    this.status = status;
    this.tvStatus = tvStatus;
    this.tvTitleName = tvTitleName;
    this.type = type;
  }

  @NonNull
  public static ItemMainBuyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMainBuyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMainBuyBinding>inflate(inflater, com.bm.container.R.layout.item_main_buy, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMainBuyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMainBuyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMainBuyBinding>inflate(inflater, com.bm.container.R.layout.item_main_buy, null, false, component);
  }

  public static ItemMainBuyBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemMainBuyBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemMainBuyBinding)bind(component, view, com.bm.container.R.layout.item_main_buy);
  }
}
