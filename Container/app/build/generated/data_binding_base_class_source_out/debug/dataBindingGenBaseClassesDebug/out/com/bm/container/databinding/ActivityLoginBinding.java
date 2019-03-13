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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public abstract class ActivityLoginBinding extends ViewDataBinding {
  @NonNull
  public final TextView forgetPwd;

  @NonNull
  public final Button login;

  @NonNull
  public final EditText phone;

  @NonNull
  public final EditText pwd;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final CheckBox remember;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final TextView wantRegister;

  protected ActivityLoginBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView forgetPwd, Button login, EditText phone, EditText pwd,
      SwipeRefreshLayout refresh, CheckBox remember, TopbarBinding topbar, TextView wantRegister) {
    super(_bindingComponent, _root, _localFieldCount);
    this.forgetPwd = forgetPwd;
    this.login = login;
    this.phone = phone;
    this.pwd = pwd;
    this.refresh = refresh;
    this.remember = remember;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.wantRegister = wantRegister;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLoginBinding>inflate(inflater, com.bm.container.R.layout.activity_login, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLoginBinding>inflate(inflater, com.bm.container.R.layout.activity_login, null, false, component);
  }

  public static ActivityLoginBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityLoginBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityLoginBinding)bind(component, view, com.bm.container.R.layout.activity_login);
  }
}
