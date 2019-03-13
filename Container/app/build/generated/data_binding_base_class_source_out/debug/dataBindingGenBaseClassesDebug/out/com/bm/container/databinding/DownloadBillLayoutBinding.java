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
import android.widget.TextView;

public abstract class DownloadBillLayoutBinding extends ViewDataBinding {
  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final TextView tvButton;

  @NonNull
  public final WebView webView;

  protected DownloadBillLayoutBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, SwipeRefreshLayout refresh, TopbarBinding topbar, TextView tvButton,
      WebView webView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.refresh = refresh;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.tvButton = tvButton;
    this.webView = webView;
  }

  @NonNull
  public static DownloadBillLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DownloadBillLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DownloadBillLayoutBinding>inflate(inflater, com.bm.container.R.layout.download_bill_layout, root, attachToRoot, component);
  }

  @NonNull
  public static DownloadBillLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DownloadBillLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DownloadBillLayoutBinding>inflate(inflater, com.bm.container.R.layout.download_bill_layout, null, false, component);
  }

  public static DownloadBillLayoutBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DownloadBillLayoutBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DownloadBillLayoutBinding)bind(component, view, com.bm.container.R.layout.download_bill_layout);
  }
}
