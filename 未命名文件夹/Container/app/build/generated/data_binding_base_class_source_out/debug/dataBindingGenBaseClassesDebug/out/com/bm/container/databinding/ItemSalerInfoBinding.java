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

public abstract class ItemSalerInfoBinding extends ViewDataBinding {
  @NonNull
  public final TextView state;

  protected ItemSalerInfoBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView state) {
    super(_bindingComponent, _root, _localFieldCount);
    this.state = state;
  }

  @NonNull
  public static ItemSalerInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemSalerInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemSalerInfoBinding>inflate(inflater, com.bm.container.R.layout.item_saler_info, root, attachToRoot, component);
  }

  @NonNull
  public static ItemSalerInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemSalerInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemSalerInfoBinding>inflate(inflater, com.bm.container.R.layout.item_saler_info, null, false, component);
  }

  public static ItemSalerInfoBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemSalerInfoBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemSalerInfoBinding)bind(component, view, com.bm.container.R.layout.item_saler_info);
  }
}
