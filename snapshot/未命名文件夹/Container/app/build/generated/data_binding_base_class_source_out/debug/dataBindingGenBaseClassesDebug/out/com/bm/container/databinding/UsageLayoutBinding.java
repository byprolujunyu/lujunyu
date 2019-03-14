package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public abstract class UsageLayoutBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final TopbarBinding topbar;

  protected UsageLayoutBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView imageView2, TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageView2 = imageView2;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static UsageLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static UsageLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<UsageLayoutBinding>inflate(inflater, com.bm.container.R.layout.usage_layout, root, attachToRoot, component);
  }

  @NonNull
  public static UsageLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static UsageLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<UsageLayoutBinding>inflate(inflater, com.bm.container.R.layout.usage_layout, null, false, component);
  }

  public static UsageLayoutBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static UsageLayoutBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (UsageLayoutBinding)bind(component, view, com.bm.container.R.layout.usage_layout);
  }
}
