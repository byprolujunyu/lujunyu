package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hongtian.easyroundimageview.EasyRoundImageView;

public abstract class ItemSalerOrderBinding extends ViewDataBinding {
  @NonNull
  public final TextView count;

  @NonNull
  public final LinearLayout item;

  @NonNull
  public final TextView leftButton;

  @NonNull
  public final TextView location;

  @NonNull
  public final LinearLayout modelButton;

  @NonNull
  public final TextView name;

  @NonNull
  public final EasyRoundImageView pic;

  @NonNull
  public final TextView piece;

  @NonNull
  public final TextView rightButton;

  @NonNull
  public final TextView state;

  @NonNull
  public final TextView tip;

  @NonNull
  public final TextView tvAggregatePrice;

  @NonNull
  public final TextView tvHintIsShow;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvOrderCode;

  @NonNull
  public final TextView tvTitleName;

  protected ItemSalerOrderBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView count, LinearLayout item, TextView leftButton,
      TextView location, LinearLayout modelButton, TextView name, EasyRoundImageView pic,
      TextView piece, TextView rightButton, TextView state, TextView tip, TextView tvAggregatePrice,
      TextView tvHintIsShow, TextView tvName, TextView tvOrderCode, TextView tvTitleName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.count = count;
    this.item = item;
    this.leftButton = leftButton;
    this.location = location;
    this.modelButton = modelButton;
    this.name = name;
    this.pic = pic;
    this.piece = piece;
    this.rightButton = rightButton;
    this.state = state;
    this.tip = tip;
    this.tvAggregatePrice = tvAggregatePrice;
    this.tvHintIsShow = tvHintIsShow;
    this.tvName = tvName;
    this.tvOrderCode = tvOrderCode;
    this.tvTitleName = tvTitleName;
  }

  @NonNull
  public static ItemSalerOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemSalerOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemSalerOrderBinding>inflate(inflater, com.bm.container.R.layout.item_saler_order, root, attachToRoot, component);
  }

  @NonNull
  public static ItemSalerOrderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemSalerOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemSalerOrderBinding>inflate(inflater, com.bm.container.R.layout.item_saler_order, null, false, component);
  }

  public static ItemSalerOrderBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemSalerOrderBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemSalerOrderBinding)bind(component, view, com.bm.container.R.layout.item_saler_order);
  }
}
