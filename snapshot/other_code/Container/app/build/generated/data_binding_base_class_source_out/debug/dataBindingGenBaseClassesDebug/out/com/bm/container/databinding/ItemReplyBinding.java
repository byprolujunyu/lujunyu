package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class ItemReplyBinding extends ViewDataBinding {
  @NonNull
  public final TextView reply;

  protected ItemReplyBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView reply) {
    super(_bindingComponent, _root, _localFieldCount);
    this.reply = reply;
  }

  @NonNull
  public static ItemReplyBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemReplyBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemReplyBinding>inflate(inflater, com.bm.container.R.layout.item_reply, root, attachToRoot, component);
  }

  @NonNull
  public static ItemReplyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemReplyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemReplyBinding>inflate(inflater, com.bm.container.R.layout.item_reply, null, false, component);
  }

  public static ItemReplyBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemReplyBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemReplyBinding)bind(component, view, com.bm.container.R.layout.item_reply);
  }
}
