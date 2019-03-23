package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class ActivityMyPostingBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView list;

  @NonNull
  public final LinearLayout modelReply;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final EditText reply;

  @NonNull
  public final View replyEmpty;

  @NonNull
  public final TextView send;

  @NonNull
  public final TopbarBinding topbar;

  protected ActivityMyPostingBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView list, LinearLayout modelReply, SwipeRefreshLayout refresh,
      EditText reply, View replyEmpty, TextView send, TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.list = list;
    this.modelReply = modelReply;
    this.refresh = refresh;
    this.reply = reply;
    this.replyEmpty = replyEmpty;
    this.send = send;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static ActivityMyPostingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMyPostingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMyPostingBinding>inflate(inflater, com.bm.container.R.layout.activity_my_posting, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMyPostingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMyPostingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMyPostingBinding>inflate(inflater, com.bm.container.R.layout.activity_my_posting, null, false, component);
  }

  public static ActivityMyPostingBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityMyPostingBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityMyPostingBinding)bind(component, view, com.bm.container.R.layout.activity_my_posting);
  }
}
