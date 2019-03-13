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
import android.webkit.WebView;

public abstract class ActivityWebBinding extends ViewDataBinding {
  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final WebView web;

  protected ActivityWebBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, SwipeRefreshLayout refresh, TopbarBinding topbar, WebView web) {
    super(_bindingComponent, _root, _localFieldCount);
    this.refresh = refresh;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.web = web;
  }

  @NonNull
  public static ActivityWebBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityWebBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityWebBinding>inflate(inflater, com.bm.container.R.layout.activity_web, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityWebBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityWebBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityWebBinding>inflate(inflater, com.bm.container.R.layout.activity_web, null, false, component);
  }

  public static ActivityWebBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityWebBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityWebBinding)bind(component, view, com.bm.container.R.layout.activity_web);
  }
}
