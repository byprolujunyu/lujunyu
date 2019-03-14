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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.bm.container.view.MultipleRadioGroup;

public abstract class ActivityPayBinding extends ViewDataBinding {
  @NonNull
  public final RadioButton alipay;

  @NonNull
  public final LinearLayout changePwd;

  @NonNull
  public final LinearLayout hotline;

  @NonNull
  public final LinearLayout introduction;

  @NonNull
  public final Button pay;

  @NonNull
  public final MultipleRadioGroup payModel;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final TextView tvPayPrice;

  @NonNull
  public final RadioButton weixin;

  protected ActivityPayBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RadioButton alipay, LinearLayout changePwd, LinearLayout hotline,
      LinearLayout introduction, Button pay, MultipleRadioGroup payModel,
      SwipeRefreshLayout refresh, TopbarBinding topbar, TextView tvPayPrice, RadioButton weixin) {
    super(_bindingComponent, _root, _localFieldCount);
    this.alipay = alipay;
    this.changePwd = changePwd;
    this.hotline = hotline;
    this.introduction = introduction;
    this.pay = pay;
    this.payModel = payModel;
    this.refresh = refresh;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.tvPayPrice = tvPayPrice;
    this.weixin = weixin;
  }

  @NonNull
  public static ActivityPayBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityPayBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityPayBinding>inflate(inflater, com.bm.container.R.layout.activity_pay, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPayBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityPayBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityPayBinding>inflate(inflater, com.bm.container.R.layout.activity_pay, null, false, component);
  }

  public static ActivityPayBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityPayBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityPayBinding)bind(component, view, com.bm.container.R.layout.activity_pay);
  }
}
