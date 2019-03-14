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

public abstract class ItemChestBinding extends ViewDataBinding {
  @NonNull
  public final TextView chest;

  @NonNull
  public final TextView delete;

  protected ItemChestBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView chest, TextView delete) {
    super(_bindingComponent, _root, _localFieldCount);
    this.chest = chest;
    this.delete = delete;
  }

  @NonNull
  public static ItemChestBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemChestBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemChestBinding>inflate(inflater, com.bm.container.R.layout.item_chest, root, attachToRoot, component);
  }

  @NonNull
  public static ItemChestBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemChestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemChestBinding>inflate(inflater, com.bm.container.R.layout.item_chest, null, false, component);
  }

  public static ItemChestBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemChestBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemChestBinding)bind(component, view, com.bm.container.R.layout.item_chest);
  }
}
