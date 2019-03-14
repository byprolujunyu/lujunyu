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

public abstract class ActivityRegisterBinding extends ViewDataBinding {
  @NonNull
  public final TextView agreement;

  @NonNull
  public final CheckBox checkbox;

  @NonNull
  public final EditText code;

  @NonNull
  public final TextView codeBtn;

  @NonNull
  public final Button next;

  @NonNull
  public final EditText phone;

  @NonNull
  public final EditText pwd1;

  @NonNull
  public final EditText pwd2;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final TopbarBinding topbar;

  protected ActivityRegisterBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView agreement, CheckBox checkbox, EditText code, TextView codeBtn,
      Button next, EditText phone, EditText pwd1, EditText pwd2, SwipeRefreshLayout refresh,
      TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.agreement = agreement;
    this.checkbox = checkbox;
    this.code = code;
    this.codeBtn = codeBtn;
    this.next = next;
    this.phone = phone;
    this.pwd1 = pwd1;
    this.pwd2 = pwd2;
    this.refresh = refresh;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityRegisterBinding>inflate(inflater, com.bm.container.R.layout.activity_register, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityRegisterBinding>inflate(inflater, com.bm.container.R.layout.activity_register, null, false, component);
  }

  public static ActivityRegisterBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityRegisterBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityRegisterBinding)bind(component, view, com.bm.container.R.layout.activity_register);
  }
}
