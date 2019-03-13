package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.flyco.tablayout.CommonTabLayout;

public abstract class DeliveryOrderLayoutBinding extends ViewDataBinding {
  @NonNull
  public final ListView list;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final CommonTabLayout tab;

  @NonNull
  public final TopbarBinding titleBar;

  protected DeliveryOrderLayoutBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ListView list, SwipeRefreshLayout refresh, CommonTabLayout tab,
      TopbarBinding titleBar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.list = list;
    this.refresh = refresh;
    this.tab = tab;
    this.titleBar = titleBar;
    setContainedBinding(this.titleBar);;
  }

  @NonNull
  public static DeliveryOrderLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DeliveryOrderLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DeliveryOrderLayoutBinding>inflate(inflater, com.bm.container.R.layout.delivery_order_layout, root, attachToRoot, component);
  }

  @NonNull
  public static DeliveryOrderLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DeliveryOrderLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DeliveryOrderLayoutBinding>inflate(inflater, com.bm.container.R.layout.delivery_order_layout, null, false, component);
  }

  public static DeliveryOrderLayoutBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DeliveryOrderLayoutBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DeliveryOrderLayoutBinding)bind(component, view, com.bm.container.R.layout.delivery_order_layout);
  }
}
