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
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class ActivitySettingBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout changePwd;

  @NonNull
  public final EditText etOfficialAccounts;

  @NonNull
  public final Button exit;

  @NonNull
  public final LinearLayout hotline;

  @NonNull
  public final LinearLayout introduction;

  @NonNull
  public final LinearLayout llAgreement;

  @NonNull
  public final LinearLayout llUsage;

  @NonNull
  public final TextView phone;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final TopbarBinding topbar;

  protected ActivitySettingBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout changePwd, EditText etOfficialAccounts, Button exit,
      LinearLayout hotline, LinearLayout introduction, LinearLayout llAgreement,
      LinearLayout llUsage, TextView phone, SwipeRefreshLayout refresh, TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.changePwd = changePwd;
    this.etOfficialAccounts = etOfficialAccounts;
    this.exit = exit;
    this.hotline = hotline;
    this.introduction = introduction;
    this.llAgreement = llAgreement;
    this.llUsage = llUsage;
    this.phone = phone;
    this.refresh = refresh;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static ActivitySettingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySettingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySettingBinding>inflate(inflater, com.bm.container.R.layout.activity_setting, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySettingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySettingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySettingBinding>inflate(inflater, com.bm.container.R.layout.activity_setting, null, false, component);
  }

  public static ActivitySettingBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySettingBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySettingBinding)bind(component, view, com.bm.container.R.layout.activity_setting);
  }
}
