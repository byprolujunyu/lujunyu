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

public abstract class ActivityChangePwdBinding extends ViewDataBinding {
  @NonNull
  public final EditText code;

  @NonNull
  public final TextView codeBtn;

  @NonNull
  public final EditText old;

  @NonNull
  public final EditText pwd1;

  @NonNull
  public final EditText pwd2;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final Button sure;

  @NonNull
  public final TopbarBinding topbar;

  protected ActivityChangePwdBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText code, TextView codeBtn, EditText old, EditText pwd1,
      EditText pwd2, SwipeRefreshLayout refresh, Button sure, TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.code = code;
    this.codeBtn = codeBtn;
    this.old = old;
    this.pwd1 = pwd1;
    this.pwd2 = pwd2;
    this.refresh = refresh;
    this.sure = sure;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static ActivityChangePwdBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityChangePwdBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityChangePwdBinding>inflate(inflater, com.bm.container.R.layout.activity_change_pwd, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityChangePwdBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityChangePwdBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityChangePwdBinding>inflate(inflater, com.bm.container.R.layout.activity_change_pwd, null, false, component);
  }

  public static ActivityChangePwdBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityChangePwdBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityChangePwdBinding)bind(component, view, com.bm.container.R.layout.activity_change_pwd);
  }
}
