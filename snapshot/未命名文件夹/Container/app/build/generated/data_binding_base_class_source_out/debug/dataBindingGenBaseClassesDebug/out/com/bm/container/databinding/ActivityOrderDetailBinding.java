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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.hongtian.easyroundimageview.EasyRoundImageView;

public abstract class ActivityOrderDetailBinding extends ViewDataBinding {
  @NonNull
  public final TextView allPrice;

  @NonNull
  public final CheckBox checkbox;

  @NonNull
  public final LinearLayout company;

  @NonNull
  public final LinearLayout companyInfo;

  @NonNull
  public final TextView count;

  @NonNull
  public final TextView invoiceContent;

  @NonNull
  public final TextView invoiceHead;

  @NonNull
  public final LinearLayout invoiceModel;

  @NonNull
  public final ImageView ivType;

  @NonNull
  public final TextView leftButton;

  @NonNull
  public final TextView location;

  @NonNull
  public final LinearLayout modelButton;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView num;

  @NonNull
  public final TextView orderId;

  @NonNull
  public final TextView payType;

  @NonNull
  public final LinearLayout person;

  @NonNull
  public final EasyRoundImageView pic;

  @NonNull
  public final RadioButton rbDanWei;

  @NonNull
  public final RadioButton rbGeTi;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final TextView rightButton;

  @NonNull
  public final TextView state;

  @NonNull
  public final TextView tip;

  @NonNull
  public final TextView tipTop;

  @NonNull
  public final TextView title;

  @NonNull
  public final TextView titleName;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final TextView tvAdd;

  @NonNull
  public final TextView tvBankIdText;

  @NonNull
  public final TextView tvBankName;

  @NonNull
  public final TextView tvDeliveryTime;

  @NonNull
  public final TextView tvInvoicePhone;

  @NonNull
  public final TextView tvOrderTime;

  @NonNull
  public final TextView tvPayTime;

  @NonNull
  public final View viewBackground;

  protected ActivityOrderDetailBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView allPrice, CheckBox checkbox, LinearLayout company,
      LinearLayout companyInfo, TextView count, TextView invoiceContent, TextView invoiceHead,
      LinearLayout invoiceModel, ImageView ivType, TextView leftButton, TextView location,
      LinearLayout modelButton, TextView name, TextView num, TextView orderId, TextView payType,
      LinearLayout person, EasyRoundImageView pic, RadioButton rbDanWei, RadioButton rbGeTi,
      SwipeRefreshLayout refresh, TextView rightButton, TextView state, TextView tip,
      TextView tipTop, TextView title, TextView titleName, TopbarBinding topbar, TextView tvAdd,
      TextView tvBankIdText, TextView tvBankName, TextView tvDeliveryTime, TextView tvInvoicePhone,
      TextView tvOrderTime, TextView tvPayTime, View viewBackground) {
    super(_bindingComponent, _root, _localFieldCount);
    this.allPrice = allPrice;
    this.checkbox = checkbox;
    this.company = company;
    this.companyInfo = companyInfo;
    this.count = count;
    this.invoiceContent = invoiceContent;
    this.invoiceHead = invoiceHead;
    this.invoiceModel = invoiceModel;
    this.ivType = ivType;
    this.leftButton = leftButton;
    this.location = location;
    this.modelButton = modelButton;
    this.name = name;
    this.num = num;
    this.orderId = orderId;
    this.payType = payType;
    this.person = person;
    this.pic = pic;
    this.rbDanWei = rbDanWei;
    this.rbGeTi = rbGeTi;
    this.refresh = refresh;
    this.rightButton = rightButton;
    this.state = state;
    this.tip = tip;
    this.tipTop = tipTop;
    this.title = title;
    this.titleName = titleName;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.tvAdd = tvAdd;
    this.tvBankIdText = tvBankIdText;
    this.tvBankName = tvBankName;
    this.tvDeliveryTime = tvDeliveryTime;
    this.tvInvoicePhone = tvInvoicePhone;
    this.tvOrderTime = tvOrderTime;
    this.tvPayTime = tvPayTime;
    this.viewBackground = viewBackground;
  }

  @NonNull
  public static ActivityOrderDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityOrderDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityOrderDetailBinding>inflate(inflater, com.bm.container.R.layout.activity_order_detail, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityOrderDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityOrderDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityOrderDetailBinding>inflate(inflater, com.bm.container.R.layout.activity_order_detail, null, false, component);
  }

  public static ActivityOrderDetailBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityOrderDetailBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityOrderDetailBinding)bind(component, view, com.bm.container.R.layout.activity_order_detail);
  }
}
