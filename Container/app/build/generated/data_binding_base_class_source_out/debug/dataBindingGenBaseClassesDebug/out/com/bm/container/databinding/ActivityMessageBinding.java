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
import com.bm.container.view.ExtraListView;

public abstract class ActivityMessageBinding extends ViewDataBinding {
  @NonNull
  public final ExtraListView list;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final TopbarBinding topbar;

  protected ActivityMessageBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ExtraListView list, SwipeRefreshLayout refresh, TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.list = list;
    this.refresh = refresh;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static ActivityMessageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMessageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMessageBinding>inflate(inflater, com.bm.container.R.layout.activity_message, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMessageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMessageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMessageBinding>inflate(inflater, com.bm.container.R.layout.activity_message, null, false, component);
  }

  public static ActivityMessageBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityMessageBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityMessageBinding)bind(component, view, com.bm.container.R.layout.activity_message);
  }
}
