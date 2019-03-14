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

public abstract class ItemMyOrderBinding extends ViewDataBinding {
  @NonNull
  public final TextView allPrice;

  @NonNull
  public final TextView count;

  @NonNull
  public final LinearLayout item;

  @NonNull
  public final ImageView ivType;

  @NonNull
  public final TextView leftButton;

  @NonNull
  public final TextView location;

  @NonNull
  public final LinearLayout modelButton;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView num;

  @NonNull
  public final TextView orderId;

  @NonNull
  public final EasyRoundImageView pic;

  @NonNull
  public final TextView rightButton;

  @NonNull
  public final TextView state;

  @NonNull
  public final TextView title;

  @NonNull
  public final TextView titleName;

  @NonNull
  public final TextView tvHint;

  @NonNull
  public final TextView tvHintOne;

  @NonNull
  public final TextView tvRemind;

  protected ItemMyOrderBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView allPrice, TextView count, LinearLayout item, ImageView ivType,
      TextView leftButton, TextView location, LinearLayout modelButton, TextView name, TextView num,
      TextView orderId, EasyRoundImageView pic, TextView rightButton, TextView state,
      TextView title, TextView titleName, TextView tvHint, TextView tvHintOne, TextView tvRemind) {
    super(_bindingComponent, _root, _localFieldCount);
    this.allPrice = allPrice;
    this.count = count;
    this.item = item;
    this.ivType = ivType;
    this.leftButton = leftButton;
    this.location = location;
    this.modelButton = modelButton;
    this.name = name;
    this.num = num;
    this.orderId = orderId;
    this.pic = pic;
    this.rightButton = rightButton;
    this.state = state;
    this.title = title;
    this.titleName = titleName;
    this.tvHint = tvHint;
    this.tvHintOne = tvHintOne;
    this.tvRemind = tvRemind;
  }

  @NonNull
  public static ItemMyOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMyOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMyOrderBinding>inflate(inflater, com.bm.container.R.layout.item_my_order, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMyOrderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMyOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMyOrderBinding>inflate(inflater, com.bm.container.R.layout.item_my_order, null, false, component);
  }

  public static ItemMyOrderBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemMyOrderBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemMyOrderBinding)bind(component, view, com.bm.container.R.layout.item_my_order);
  }
}
