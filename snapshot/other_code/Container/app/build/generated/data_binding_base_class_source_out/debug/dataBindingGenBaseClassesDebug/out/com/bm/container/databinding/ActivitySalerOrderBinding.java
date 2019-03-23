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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class ActivitySalerOrderBinding extends ViewDataBinding {
  @NonNull
  public final ListView list;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final ImageView tab1Line;

  @NonNull
  public final RelativeLayout tab1Model;

  @NonNull
  public final TextView tab1Num;

  @NonNull
  public final TextView tab1Text;

  @NonNull
  public final ImageView tab2Line;

  @NonNull
  public final RelativeLayout tab2Model;

  @NonNull
  public final TextView tab2Num;

  @NonNull
  public final TextView tab2Text;

  @NonNull
  public final ImageView tab3Line;

  @NonNull
  public final RelativeLayout tab3Model;

  @NonNull
  public final TextView tab3Num;

  @NonNull
  public final TextView tab3Text;

  @NonNull
  public final TopbarBinding topbar;

  protected ActivitySalerOrderBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ListView list, SwipeRefreshLayout refresh, ImageView tab1Line,
      RelativeLayout tab1Model, TextView tab1Num, TextView tab1Text, ImageView tab2Line,
      RelativeLayout tab2Model, TextView tab2Num, TextView tab2Text, ImageView tab3Line,
      RelativeLayout tab3Model, TextView tab3Num, TextView tab3Text, TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.list = list;
    this.refresh = refresh;
    this.tab1Line = tab1Line;
    this.tab1Model = tab1Model;
    this.tab1Num = tab1Num;
    this.tab1Text = tab1Text;
    this.tab2Line = tab2Line;
    this.tab2Model = tab2Model;
    this.tab2Num = tab2Num;
    this.tab2Text = tab2Text;
    this.tab3Line = tab3Line;
    this.tab3Model = tab3Model;
    this.tab3Num = tab3Num;
    this.tab3Text = tab3Text;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static ActivitySalerOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySalerOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySalerOrderBinding>inflate(inflater, com.bm.container.R.layout.activity_saler_order, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySalerOrderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySalerOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySalerOrderBinding>inflate(inflater, com.bm.container.R.layout.activity_saler_order, null, false, component);
  }

  public static ActivitySalerOrderBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySalerOrderBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySalerOrderBinding)bind(component, view, com.bm.container.R.layout.activity_saler_order);
  }
}
