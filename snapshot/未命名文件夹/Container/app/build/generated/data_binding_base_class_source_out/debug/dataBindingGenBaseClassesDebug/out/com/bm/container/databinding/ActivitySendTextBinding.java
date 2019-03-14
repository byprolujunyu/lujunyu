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
import android.widget.EditText;
import android.widget.TextView;

public abstract class ActivitySendTextBinding extends ViewDataBinding {
  @NonNull
  public final TextView count;

  @NonNull
  public final EditText input;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final Button sure;

  @NonNull
  public final TopbarBinding topbar;

  protected ActivitySendTextBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView count, EditText input, SwipeRefreshLayout refresh, Button sure,
      TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.count = count;
    this.input = input;
    this.refresh = refresh;
    this.sure = sure;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static ActivitySendTextBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySendTextBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySendTextBinding>inflate(inflater, com.bm.container.R.layout.activity_send_text, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySendTextBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySendTextBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySendTextBinding>inflate(inflater, com.bm.container.R.layout.activity_send_text, null, false, component);
  }

  public static ActivitySendTextBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySendTextBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySendTextBinding)bind(component, view, com.bm.container.R.layout.activity_send_text);
  }
}
