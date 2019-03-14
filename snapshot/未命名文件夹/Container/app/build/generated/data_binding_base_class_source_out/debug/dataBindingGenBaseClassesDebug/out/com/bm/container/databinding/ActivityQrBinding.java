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
import android.widget.ImageView;

public abstract class ActivityQrBinding extends ViewDataBinding {
  @NonNull
  public final Button button;

  @NonNull
  public final ImageView qRCodeUrl;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final TopbarBinding topbar;

  protected ActivityQrBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button button, ImageView qRCodeUrl, SwipeRefreshLayout refresh,
      TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.button = button;
    this.qRCodeUrl = qRCodeUrl;
    this.refresh = refresh;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static ActivityQrBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityQrBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityQrBinding>inflate(inflater, com.bm.container.R.layout.activity_qr, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityQrBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityQrBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityQrBinding>inflate(inflater, com.bm.container.R.layout.activity_qr, null, false, component);
  }

  public static ActivityQrBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityQrBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityQrBinding)bind(component, view, com.bm.container.R.layout.activity_qr);
  }
}
