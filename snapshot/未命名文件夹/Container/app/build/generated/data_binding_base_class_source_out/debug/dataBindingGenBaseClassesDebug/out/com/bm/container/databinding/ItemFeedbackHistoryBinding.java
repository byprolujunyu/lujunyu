package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class ItemFeedbackHistoryBinding extends ViewDataBinding {
  @NonNull
  public final TextView content;

  @NonNull
  public final TextView contentReply;

  @NonNull
  public final LinearLayout modelReply;

  @NonNull
  public final TextView more;

  @NonNull
  public final TextView time;

  @NonNull
  public final TextView timeReply;

  protected ItemFeedbackHistoryBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView content, TextView contentReply, LinearLayout modelReply,
      TextView more, TextView time, TextView timeReply) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    this.contentReply = contentReply;
    this.modelReply = modelReply;
    this.more = more;
    this.time = time;
    this.timeReply = timeReply;
  }

  @NonNull
  public static ItemFeedbackHistoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemFeedbackHistoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemFeedbackHistoryBinding>inflate(inflater, com.bm.container.R.layout.item_feedback_history, root, attachToRoot, component);
  }

  @NonNull
  public static ItemFeedbackHistoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemFeedbackHistoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemFeedbackHistoryBinding>inflate(inflater, com.bm.container.R.layout.item_feedback_history, null, false, component);
  }

  public static ItemFeedbackHistoryBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemFeedbackHistoryBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemFeedbackHistoryBinding)bind(component, view, com.bm.container.R.layout.item_feedback_history);
  }
}
