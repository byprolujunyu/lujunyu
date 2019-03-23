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

public abstract class ItemMessageBinding extends ViewDataBinding {
  @NonNull
  public final TextView content;

  @NonNull
  public final TextView time;

  @NonNull
  public final TextView tvTitle;

  protected ItemMessageBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView content, TextView time, TextView tvTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    this.time = time;
    this.tvTitle = tvTitle;
  }

  @NonNull
  public static ItemMessageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMessageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMessageBinding>inflate(inflater, com.bm.container.R.layout.item_message, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMessageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMessageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMessageBinding>inflate(inflater, com.bm.container.R.layout.item_message, null, false, component);
  }

  public static ItemMessageBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemMessageBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemMessageBinding)bind(component, view, com.bm.container.R.layout.item_message);
  }
}
