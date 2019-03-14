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
import android.widget.FrameLayout;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bm.container.view.ExtraListView;
import com.bm.container.view.PullDownView;
import com.bm.container.view.PullUpView;

public abstract class ActivityPurchaseBBinding extends ViewDataBinding {
  @NonNull
  public final ConvenientBanner banner;

  @NonNull
  public final FrameLayout framlayout;

  @NonNull
  public final ExtraListView historyList;

  @NonNull
  public final PullUpView more;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final Button sure;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final PullDownView up;

  protected ActivityPurchaseBBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConvenientBanner banner, FrameLayout framlayout,
      ExtraListView historyList, PullUpView more, SwipeRefreshLayout refresh, Button sure,
      TopbarBinding topbar, PullDownView up) {
    super(_bindingComponent, _root, _localFieldCount);
    this.banner = banner;
    this.framlayout = framlayout;
    this.historyList = historyList;
    this.more = more;
    this.refresh = refresh;
    this.sure = sure;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.up = up;
  }

  @NonNull
  public static ActivityPurchaseBBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityPurchaseBBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityPurchaseBBinding>inflate(inflater, com.bm.container.R.layout.activity_purchase_b, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPurchaseBBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityPurchaseBBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityPurchaseBBinding>inflate(inflater, com.bm.container.R.layout.activity_purchase_b, null, false, component);
  }

  public static ActivityPurchaseBBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityPurchaseBBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityPurchaseBBinding)bind(component, view, com.bm.container.R.layout.activity_purchase_b);
  }
}
