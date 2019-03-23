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

public abstract class ActivityIntroductionBinding extends ViewDataBinding {
  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final WebView web;

  protected ActivityIntroductionBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, SwipeRefreshLayout refresh, TopbarBinding topbar, WebView web) {
    super(_bindingComponent, _root, _localFieldCount);
    this.refresh = refresh;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.web = web;
  }

  @NonNull
  public static ActivityIntroductionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityIntroductionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityIntroductionBinding>inflate(inflater, com.bm.container.R.layout.activity_introduction, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityIntroductionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityIntroductionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityIntroductionBinding>inflate(inflater, com.bm.container.R.layout.activity_introduction, null, false, component);
  }

  public static ActivityIntroductionBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityIntroductionBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityIntroductionBinding)bind(component, view, com.bm.container.R.layout.activity_introduction);
  }
}
