package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ItemFeedbackHistoryListBinding extends ViewDataBinding {
  protected ItemFeedbackHistoryListBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  @NonNull
  public static ItemFeedbackHistoryListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemFeedbackHistoryListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemFeedbackHistoryListBinding>inflate(inflater, com.bm.container.R.layout.item_feedback_history_list, root, attachToRoot, component);
  }

  @NonNull
  public static ItemFeedbackHistoryListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemFeedbackHistoryListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemFeedbackHistoryListBinding>inflate(inflater, com.bm.container.R.layout.item_feedback_history_list, null, false, component);
  }

  public static ItemFeedbackHistoryListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemFeedbackHistoryListBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemFeedbackHistoryListBinding)bind(component, view, com.bm.container.R.layout.item_feedback_history_list);
  }
}
