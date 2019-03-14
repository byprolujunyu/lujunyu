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

public abstract class ActivityForgetPwdBinding extends ViewDataBinding {
  @NonNull
  public final TextView codeBtn;

  @NonNull
  public final EditText phone;

  @NonNull
  public final EditText pwd1;

  @NonNull
  public final EditText pwd2;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final Button sure;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final EditText verifyCode;

  protected ActivityForgetPwdBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView codeBtn, EditText phone, EditText pwd1, EditText pwd2,
      SwipeRefreshLayout refresh, Button sure, TextView textView, TopbarBinding topbar,
      EditText verifyCode) {
    super(_bindingComponent, _root, _localFieldCount);
    this.codeBtn = codeBtn;
    this.phone = phone;
    this.pwd1 = pwd1;
    this.pwd2 = pwd2;
    this.refresh = refresh;
    this.sure = sure;
    this.textView = textView;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.verifyCode = verifyCode;
  }

  @NonNull
  public static ActivityForgetPwdBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityForgetPwdBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityForgetPwdBinding>inflate(inflater, com.bm.container.R.layout.activity_forget_pwd, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityForgetPwdBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityForgetPwdBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityForgetPwdBinding>inflate(inflater, com.bm.container.R.layout.activity_forget_pwd, null, false, component);
  }

  public static ActivityForgetPwdBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityForgetPwdBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityForgetPwdBinding)bind(component, view, com.bm.container.R.layout.activity_forget_pwd);
  }
}
