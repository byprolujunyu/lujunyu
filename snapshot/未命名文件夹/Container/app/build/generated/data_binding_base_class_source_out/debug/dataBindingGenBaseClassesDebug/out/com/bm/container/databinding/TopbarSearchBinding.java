package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public abstract class TopbarSearchBinding extends ViewDataBinding {
  @NonNull
  public final TextInputEditText input;

  @NonNull
  public final Button search;

  @NonNull
  public final Toolbar toolbar;

  protected TopbarSearchBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextInputEditText input, Button search, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.input = input;
    this.search = search;
    this.toolbar = toolbar;
  }

  @NonNull
  public static TopbarSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static TopbarSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<TopbarSearchBinding>inflate(inflater, com.bm.container.R.layout.topbar_search, root, attachToRoot, component);
  }

  @NonNull
  public static TopbarSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static TopbarSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<TopbarSearchBinding>inflate(inflater, com.bm.container.R.layout.topbar_search, null, false, component);
  }

  public static TopbarSearchBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static TopbarSearchBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (TopbarSearchBinding)bind(component, view, com.bm.container.R.layout.topbar_search);
  }
}
