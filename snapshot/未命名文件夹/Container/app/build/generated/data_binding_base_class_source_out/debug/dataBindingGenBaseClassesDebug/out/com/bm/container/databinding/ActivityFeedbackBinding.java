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

public abstract class ActivityFeedbackBinding extends ViewDataBinding {
  @NonNull
  public final EditText content;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final Button sure;

  @NonNull
  public final TopbarBinding topbar;

  protected ActivityFeedbackBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText content, SwipeRefreshLayout refresh, Button sure,
      TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    this.refresh = refresh;
    this.sure = sure;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static ActivityFeedbackBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFeedbackBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFeedbackBinding>inflate(inflater, com.bm.container.R.layout.activity_feedback, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFeedbackBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFeedbackBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFeedbackBinding>inflate(inflater, com.bm.container.R.layout.activity_feedback, null, false, component);
  }

  public static ActivityFeedbackBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityFeedbackBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityFeedbackBinding)bind(component, view, com.bm.container.R.layout.activity_feedback);
  }
}
