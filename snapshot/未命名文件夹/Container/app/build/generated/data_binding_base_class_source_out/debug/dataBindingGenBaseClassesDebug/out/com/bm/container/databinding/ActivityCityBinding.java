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
import com.bm.container.view.MyWaveSideBar;

public abstract class ActivityCityBinding extends ViewDataBinding {
  @NonNull
  public final ListView list;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final MyWaveSideBar sideBar;

  @NonNull
  public final TopbarBinding topbar;

  protected ActivityCityBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ListView list, SwipeRefreshLayout refresh, MyWaveSideBar sideBar,
      TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.list = list;
    this.refresh = refresh;
    this.sideBar = sideBar;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static ActivityCityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityCityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityCityBinding>inflate(inflater, com.bm.container.R.layout.activity_city, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityCityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityCityBinding>inflate(inflater, com.bm.container.R.layout.activity_city, null, false, component);
  }

  public static ActivityCityBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityCityBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityCityBinding)bind(component, view, com.bm.container.R.layout.activity_city);
  }
}
