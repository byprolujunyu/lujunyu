package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class ItemBuyerInfoBinding extends ViewDataBinding {
  @NonNull
  public final TextView state;

  protected ItemBuyerInfoBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView state) {
    super(_bindingComponent, _root, _localFieldCount);
    this.state = state;
  }

  @NonNull
  public static ItemBuyerInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemBuyerInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemBuyerInfoBinding>inflate(inflater, com.bm.container.R.layout.item_buyer_info, root, attachToRoot, component);
  }

  @NonNull
  public static ItemBuyerInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemBuyerInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemBuyerInfoBinding>inflate(inflater, com.bm.container.R.layout.item_buyer_info, null, false, component);
  }

  public static ItemBuyerInfoBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemBuyerInfoBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemBuyerInfoBinding)bind(component, view, com.bm.container.R.layout.item_buyer_info);
  }
}
