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
import com.bm.container.view.ExtraGridView;

public abstract class ActivitySendImageBinding extends ViewDataBinding {
  @NonNull
  public final TextView count;

  @NonNull
  public final ExtraGridView image;

  @NonNull
  public final EditText input;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final Button sure;

  @NonNull
  public final TopbarBinding topbar;

  protected ActivitySendImageBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView count, ExtraGridView image, EditText input,
      SwipeRefreshLayout refresh, Button sure, TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.count = count;
    this.image = image;
    this.input = input;
    this.refresh = refresh;
    this.sure = sure;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static ActivitySendImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySendImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySendImageBinding>inflate(inflater, com.bm.container.R.layout.activity_send_image, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySendImageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySendImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySendImageBinding>inflate(inflater, com.bm.container.R.layout.activity_send_image, null, false, component);
  }

  public static ActivitySendImageBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySendImageBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySendImageBinding)bind(component, view, com.bm.container.R.layout.activity_send_image);
  }
}
