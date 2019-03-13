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
import android.widget.ImageView;

public abstract class ActivityStartUpBinding extends ViewDataBinding {
  @NonNull
  public final ImageView image;

  @NonNull
  public final SwipeRefreshLayout refresh;

  protected ActivityStartUpBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView image, SwipeRefreshLayout refresh) {
    super(_bindingComponent, _root, _localFieldCount);
    this.image = image;
    this.refresh = refresh;
  }

  @NonNull
  public static ActivityStartUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityStartUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityStartUpBinding>inflate(inflater, com.bm.container.R.layout.activity_start_up, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityStartUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityStartUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityStartUpBinding>inflate(inflater, com.bm.container.R.layout.activity_start_up, null, false, component);
  }

  public static ActivityStartUpBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityStartUpBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityStartUpBinding)bind(component, view, com.bm.container.R.layout.activity_start_up);
  }
}
