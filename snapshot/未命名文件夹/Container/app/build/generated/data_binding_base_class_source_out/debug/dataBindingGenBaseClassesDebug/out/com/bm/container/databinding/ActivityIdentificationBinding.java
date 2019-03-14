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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.bm.container.view.ExtraGridView;
import com.bm.container.view.XEditText;

public abstract class ActivityIdentificationBinding extends ViewDataBinding {
  @NonNull
  public final TextView add;

  @NonNull
  public final LinearLayout address;

  @NonNull
  public final LinearLayout bank;

  @NonNull
  public final LinearLayout bankId;

  @NonNull
  public final LinearLayout bankIdName;

  @NonNull
  public final XEditText bankIdText;

  @NonNull
  public final EditText bankNameText;

  @NonNull
  public final TextView bankText;

  @NonNull
  public final RadioButton buyer;

  @NonNull
  public final LinearLayout choooseCity;

  @NonNull
  public final TextView chooseCityTip;

  @NonNull
  public final LinearLayout city;

  @NonNull
  public final TextView cityText;

  @NonNull
  public final RadioButton company;

  @NonNull
  public final LinearLayout companyAddress;

  @NonNull
  public final EditText companyAddressText;

  @NonNull
  public final LinearLayout companyLegalEntity;

  @NonNull
  public final LinearLayout companyName;

  @NonNull
  public final EditText companyNameText;

  @NonNull
  public final LinearLayout companyPersonInCharge;

  @NonNull
  public final EditText companyPersonInChargeText;

  @NonNull
  public final LinearLayout companyPhone;

  @NonNull
  public final EditText companyPhoneText;

  @NonNull
  public final LinearLayout country;

  @NonNull
  public final TextView countryText;

  @NonNull
  public final TextView delete;

  @NonNull
  public final LinearLayout focus;

  @NonNull
  public final ExtraGridView gridview;

  @NonNull
  public final TextView id;

  @NonNull
  public final ImageView ivAddBusinessLicense;

  @NonNull
  public final ImageView ivAddPositive;

  @NonNull
  public final ImageView ivAddTheOtherSide;

  @NonNull
  public final LinearLayout llBusinessLicense;

  @NonNull
  public final LinearLayout llIdentity;

  @NonNull
  public final LinearLayout name;

  @NonNull
  public final EditText nameText;

  @NonNull
  public final RadioButton personal;

  @NonNull
  public final LinearLayout phone;

  @NonNull
  public final EditText phoneText;

  @NonNull
  public final LinearLayout qq;

  @NonNull
  public final EditText qqText;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final Button register;

  @NonNull
  public final RadioButton seller;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final TextView tvInfo;

  @NonNull
  public final TextView tvUserId;

  @NonNull
  public final View viewllBusinessLicense;

  @NonNull
  public final LinearLayout weixin;

  @NonNull
  public final EditText weixinText;

  protected ActivityIdentificationBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView add, LinearLayout address, LinearLayout bank,
      LinearLayout bankId, LinearLayout bankIdName, XEditText bankIdText, EditText bankNameText,
      TextView bankText, RadioButton buyer, LinearLayout choooseCity, TextView chooseCityTip,
      LinearLayout city, TextView cityText, RadioButton company, LinearLayout companyAddress,
      EditText companyAddressText, LinearLayout companyLegalEntity, LinearLayout companyName,
      EditText companyNameText, LinearLayout companyPersonInCharge,
      EditText companyPersonInChargeText, LinearLayout companyPhone, EditText companyPhoneText,
      LinearLayout country, TextView countryText, TextView delete, LinearLayout focus,
      ExtraGridView gridview, TextView id, ImageView ivAddBusinessLicense, ImageView ivAddPositive,
      ImageView ivAddTheOtherSide, LinearLayout llBusinessLicense, LinearLayout llIdentity,
      LinearLayout name, EditText nameText, RadioButton personal, LinearLayout phone,
      EditText phoneText, LinearLayout qq, EditText qqText, SwipeRefreshLayout refresh,
      Button register, RadioButton seller, TopbarBinding topbar, TextView tvInfo, TextView tvUserId,
      View viewllBusinessLicense, LinearLayout weixin, EditText weixinText) {
    super(_bindingComponent, _root, _localFieldCount);
    this.add = add;
    this.address = address;
    this.bank = bank;
    this.bankId = bankId;
    this.bankIdName = bankIdName;
    this.bankIdText = bankIdText;
    this.bankNameText = bankNameText;
    this.bankText = bankText;
    this.buyer = buyer;
    this.choooseCity = choooseCity;
    this.chooseCityTip = chooseCityTip;
    this.city = city;
    this.cityText = cityText;
    this.company = company;
    this.companyAddress = companyAddress;
    this.companyAddressText = companyAddressText;
    this.companyLegalEntity = companyLegalEntity;
    this.companyName = companyName;
    this.companyNameText = companyNameText;
    this.companyPersonInCharge = companyPersonInCharge;
    this.companyPersonInChargeText = companyPersonInChargeText;
    this.companyPhone = companyPhone;
    this.companyPhoneText = companyPhoneText;
    this.country = country;
    this.countryText = countryText;
    this.delete = delete;
    this.focus = focus;
    this.gridview = gridview;
    this.id = id;
    this.ivAddBusinessLicense = ivAddBusinessLicense;
    this.ivAddPositive = ivAddPositive;
    this.ivAddTheOtherSide = ivAddTheOtherSide;
    this.llBusinessLicense = llBusinessLicense;
    this.llIdentity = llIdentity;
    this.name = name;
    this.nameText = nameText;
    this.personal = personal;
    this.phone = phone;
    this.phoneText = phoneText;
    this.qq = qq;
    this.qqText = qqText;
    this.refresh = refresh;
    this.register = register;
    this.seller = seller;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.tvInfo = tvInfo;
    this.tvUserId = tvUserId;
    this.viewllBusinessLicense = viewllBusinessLicense;
    this.weixin = weixin;
    this.weixinText = weixinText;
  }

  @NonNull
  public static ActivityIdentificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityIdentificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityIdentificationBinding>inflate(inflater, com.bm.container.R.layout.activity_identification, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityIdentificationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityIdentificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityIdentificationBinding>inflate(inflater, com.bm.container.R.layout.activity_identification, null, false, component);
  }

  public static ActivityIdentificationBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityIdentificationBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityIdentificationBinding)bind(component, view, com.bm.container.R.layout.activity_identification);
  }
}
