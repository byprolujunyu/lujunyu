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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bm.container.view.XEditText;

public abstract class ActivitySaleABinding extends ViewDataBinding {
  @NonNull
  public final TextView allPrice;

  @NonNull
  public final XEditText bankIdText;

  @NonNull
  public final EditText bankName;

  @NonNull
  public final ConvenientBanner banner;

  @NonNull
  public final TextView buy;

  @NonNull
  public final CheckBox checkInvoice;

  @NonNull
  public final RadioButton companyCheck;

  @NonNull
  public final LinearLayout companyInfo;

  @NonNull
  public final EditText etAdd;

  @NonNull
  public final LinearLayout invoiceBasicInformation;

  @NonNull
  public final TextView invoiceChoosed;

  @NonNull
  public final EditText invoiceContent;

  @NonNull
  public final EditText invoiceHead;

  @NonNull
  public final LinearLayout invoiceModel;

  @NonNull
  public final EditText invoicePhone;

  @NonNull
  public final TextView isGoing;

  @NonNull
  public final ImageView ivType;

  @NonNull
  public final LinearLayout llAge;

  @NonNull
  public final LinearLayout llEtAdd;

  @NonNull
  public final LinearLayout llInvoicePhone;

  @NonNull
  public final LinearLayout llIsGoing;

  @NonNull
  public final LinearLayout llSpecial;

  @NonNull
  public final LinearLayout llStatus;

  @NonNull
  public final LinearLayout llbankIdText;

  @NonNull
  public final LinearLayout llbankName;

  @NonNull
  public final LinearLayout llinvoiceContent;

  @NonNull
  public final TextView location;

  @NonNull
  public final LinearLayout model;

  @NonNull
  public final TextView num;

  @NonNull
  public final TextView people;

  @NonNull
  public final RadioButton personalCheck;

  @NonNull
  public final TextView priceChoosed;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final TextView restTime;

  @NonNull
  public final TextView specialChoosed;

  @NonNull
  public final TextView specialPriceChoosed;

  @NonNull
  public final TextView status;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final TextView tvAge;

  @NonNull
  public final TextView tvIamge;

  @NonNull
  public final TextView tvRemark;

  @NonNull
  public final TextView tvStatus;

  @NonNull
  public final TextView tvTitleName;

  @NonNull
  public final TextView type;

  @NonNull
  public final View view;

  protected ActivitySaleABinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView allPrice, XEditText bankIdText, EditText bankName,
      ConvenientBanner banner, TextView buy, CheckBox checkInvoice, RadioButton companyCheck,
      LinearLayout companyInfo, EditText etAdd, LinearLayout invoiceBasicInformation,
      TextView invoiceChoosed, EditText invoiceContent, EditText invoiceHead,
      LinearLayout invoiceModel, EditText invoicePhone, TextView isGoing, ImageView ivType,
      LinearLayout llAge, LinearLayout llEtAdd, LinearLayout llInvoicePhone, LinearLayout llIsGoing,
      LinearLayout llSpecial, LinearLayout llStatus, LinearLayout llbankIdText,
      LinearLayout llbankName, LinearLayout llinvoiceContent, TextView location, LinearLayout model,
      TextView num, TextView people, RadioButton personalCheck, TextView priceChoosed,
      SwipeRefreshLayout refresh, TextView restTime, TextView specialChoosed,
      TextView specialPriceChoosed, TextView status, TextView textView2, TopbarBinding topbar,
      TextView tvAge, TextView tvIamge, TextView tvRemark, TextView tvStatus, TextView tvTitleName,
      TextView type, View view) {
    super(_bindingComponent, _root, _localFieldCount);
    this.allPrice = allPrice;
    this.bankIdText = bankIdText;
    this.bankName = bankName;
    this.banner = banner;
    this.buy = buy;
    this.checkInvoice = checkInvoice;
    this.companyCheck = companyCheck;
    this.companyInfo = companyInfo;
    this.etAdd = etAdd;
    this.invoiceBasicInformation = invoiceBasicInformation;
    this.invoiceChoosed = invoiceChoosed;
    this.invoiceContent = invoiceContent;
    this.invoiceHead = invoiceHead;
    this.invoiceModel = invoiceModel;
    this.invoicePhone = invoicePhone;
    this.isGoing = isGoing;
    this.ivType = ivType;
    this.llAge = llAge;
    this.llEtAdd = llEtAdd;
    this.llInvoicePhone = llInvoicePhone;
    this.llIsGoing = llIsGoing;
    this.llSpecial = llSpecial;
    this.llStatus = llStatus;
    this.llbankIdText = llbankIdText;
    this.llbankName = llbankName;
    this.llinvoiceContent = llinvoiceContent;
    this.location = location;
    this.model = model;
    this.num = num;
    this.people = people;
    this.personalCheck = personalCheck;
    this.priceChoosed = priceChoosed;
    this.refresh = refresh;
    this.restTime = restTime;
    this.specialChoosed = specialChoosed;
    this.specialPriceChoosed = specialPriceChoosed;
    this.status = status;
    this.textView2 = textView2;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.tvAge = tvAge;
    this.tvIamge = tvIamge;
    this.tvRemark = tvRemark;
    this.tvStatus = tvStatus;
    this.tvTitleName = tvTitleName;
    this.type = type;
    this.view = view;
  }

  @NonNull
  public static ActivitySaleABinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySaleABinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySaleABinding>inflate(inflater, com.bm.container.R.layout.activity_sale_a, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySaleABinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySaleABinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySaleABinding>inflate(inflater, com.bm.container.R.layout.activity_sale_a, null, false, component);
  }

  public static ActivitySaleABinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySaleABinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySaleABinding)bind(component, view, com.bm.container.R.layout.activity_sale_a);
  }
}
