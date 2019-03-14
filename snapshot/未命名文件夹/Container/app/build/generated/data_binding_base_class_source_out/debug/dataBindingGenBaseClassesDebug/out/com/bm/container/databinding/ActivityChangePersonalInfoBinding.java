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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bm.container.view.CircleImageView;
import com.bm.container.view.ExtraGridView;
import com.bm.container.view.XEditText;

public abstract class ActivityChangePersonalInfoBinding extends ViewDataBinding {
  @NonNull
  public final TextView add;

  @NonNull
  public final EditText address;

  @NonNull
  public final TextView bank;

  @NonNull
  public final XEditText bankId;

  @NonNull
  public final EditText bankName;

  @NonNull
  public final CheckBox checkbox;

  @NonNull
  public final TextView chooseCityTip;

  @NonNull
  public final TextView delete;

  @NonNull
  public final CircleImageView face;

  @NonNull
  public final ExtraGridView gridview;

  @NonNull
  public final LinearLayout modelBank;

  @NonNull
  public final LinearLayout modelContack;

  @NonNull
  public final EditText name;

  @NonNull
  public final EditText qq;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final Button register;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final EditText weixin;

  protected ActivityChangePersonalInfoBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView add, EditText address, TextView bank, XEditText bankId,
      EditText bankName, CheckBox checkbox, TextView chooseCityTip, TextView delete,
      CircleImageView face, ExtraGridView gridview, LinearLayout modelBank,
      LinearLayout modelContack, EditText name, EditText qq, SwipeRefreshLayout refresh,
      Button register, TopbarBinding topbar, EditText weixin) {
    super(_bindingComponent, _root, _localFieldCount);
    this.add = add;
    this.address = address;
    this.bank = bank;
    this.bankId = bankId;
    this.bankName = bankName;
    this.checkbox = checkbox;
    this.chooseCityTip = chooseCityTip;
    this.delete = delete;
    this.face = face;
    this.gridview = gridview;
    this.modelBank = modelBank;
    this.modelContack = modelContack;
    this.name = name;
    this.qq = qq;
    this.refresh = refresh;
    this.register = register;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.weixin = weixin;
  }

  @NonNull
  public static ActivityChangePersonalInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityChangePersonalInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityChangePersonalInfoBinding>inflate(inflater, com.bm.container.R.layout.activity_change_personal_info, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityChangePersonalInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityChangePersonalInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityChangePersonalInfoBinding>inflate(inflater, com.bm.container.R.layout.activity_change_personal_info, null, false, component);
  }

  public static ActivityChangePersonalInfoBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityChangePersonalInfoBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityChangePersonalInfoBinding)bind(component, view, com.bm.container.R.layout.activity_change_personal_info);
  }
}
