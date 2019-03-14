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
import android.widget.Button;

public abstract class ActivityPaySuccessBinding extends ViewDataBinding {
  @NonNull
  public final Button left;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final Button right;

  @NonNull
  public final TopbarBinding topbar;

  protected ActivityPaySuccessBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button left, SwipeRefreshLayout refresh, Button right,
      TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.left = left;
    this.refresh = refresh;
    this.right = right;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static ActivityPaySuccessBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityPaySuccessBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityPaySuccessBinding>inflate(inflater, com.bm.container.R.layout.activity_pay_success, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPaySuccessBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityPaySuccessBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityPaySuccessBinding>inflate(inflater, com.bm.container.R.layout.activity_pay_success, null, false, component);
  }

  public static ActivityPaySuccessBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityPaySuccessBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityPaySuccessBinding)bind(component, view, com.bm.container.R.layout.activity_pay_success);
  }
}
