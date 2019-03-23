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

public abstract class ItemHistoryBinding extends ViewDataBinding {
  @NonNull
  public final TextView hasInvoice;

  @NonNull
  public final TextView hasPic;

  @NonNull
  public final LinearLayout item;

  @NonNull
  public final TextView money;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView num;

  protected ItemHistoryBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView hasInvoice, TextView hasPic, LinearLayout item, TextView money,
      TextView name, TextView num) {
    super(_bindingComponent, _root, _localFieldCount);
    this.hasInvoice = hasInvoice;
    this.hasPic = hasPic;
    this.item = item;
    this.money = money;
    this.name = name;
    this.num = num;
  }

  @NonNull
  public static ItemHistoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemHistoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemHistoryBinding>inflate(inflater, com.bm.container.R.layout.item_history, root, attachToRoot, component);
  }

  @NonNull
  public static ItemHistoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemHistoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemHistoryBinding>inflate(inflater, com.bm.container.R.layout.item_history, null, false, component);
  }

  public static ItemHistoryBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemHistoryBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemHistoryBinding)bind(component, view, com.bm.container.R.layout.item_history);
  }
}
