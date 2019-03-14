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

public abstract class ItemBuyHistoryBinding extends ViewDataBinding {
  @NonNull
  public final TextView invoice;

  @NonNull
  public final LinearLayout item;

  @NonNull
  public final TextView money;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView time;

  protected ItemBuyHistoryBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView invoice, LinearLayout item, TextView money, TextView name,
      TextView time) {
    super(_bindingComponent, _root, _localFieldCount);
    this.invoice = invoice;
    this.item = item;
    this.money = money;
    this.name = name;
    this.time = time;
  }

  @NonNull
  public static ItemBuyHistoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemBuyHistoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemBuyHistoryBinding>inflate(inflater, com.bm.container.R.layout.item_buy_history, root, attachToRoot, component);
  }

  @NonNull
  public static ItemBuyHistoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemBuyHistoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemBuyHistoryBinding>inflate(inflater, com.bm.container.R.layout.item_buy_history, null, false, component);
  }

  public static ItemBuyHistoryBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemBuyHistoryBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemBuyHistoryBinding)bind(component, view, com.bm.container.R.layout.item_buy_history);
  }
}
