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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bm.container.view.XEditText;

public abstract class ActivityPurchaseEBinding extends ViewDataBinding {
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
  public final LinearLayout llEtAdd;

  @NonNull
  public final LinearLayout llInvoicePhone;

  @NonNull
  public final LinearLayout llIsGoing;

  @NonNull
  public final LinearLayout llbankIdText;

  @NonNull
  public final LinearLayout llbankName;

  @NonNull
  public final LinearLayout llinvoiceContent;

  @NonNull
  public final TextView location;

  @NonNull
  public final TextView num;

  @NonNull
  public final TextView numChoosed;

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
  public final TopbarBinding topbar;

  @NonNull
  public final TextView tvIamge;

  @NonNull
  public final TextView tvTitleName;

  @NonNull
  public final TextView type;

  @NonNull
  public final View view;

  protected ActivityPurchaseEBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView allPrice, XEditText bankIdText, EditText bankName,
      ConvenientBanner banner, TextView buy, CheckBox checkInvoice, RadioButton companyCheck,
      LinearLayout companyInfo, EditText etAdd, LinearLayout invoiceBasicInformation,
      TextView invoiceChoosed, EditText invoiceContent, EditText invoiceHead,
      LinearLayout invoiceModel, EditText invoicePhone, TextView isGoing, LinearLayout llEtAdd,
      LinearLayout llInvoicePhone, LinearLayout llIsGoing, LinearLayout llbankIdText,
      LinearLayout llbankName, LinearLayout llinvoiceContent, TextView location, TextView num,
      TextView numChoosed, TextView people, RadioButton personalCheck, TextView priceChoosed,
      SwipeRefreshLayout refresh, TextView restTime, TextView specialChoosed,
      TextView specialPriceChoosed, TextView status, TopbarBinding topbar, TextView tvIamge,
      TextView tvTitleName, TextView type, View view) {
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
    this.llEtAdd = llEtAdd;
    this.llInvoicePhone = llInvoicePhone;
    this.llIsGoing = llIsGoing;
    this.llbankIdText = llbankIdText;
    this.llbankName = llbankName;
    this.llinvoiceContent = llinvoiceContent;
    this.location = location;
    this.num = num;
    this.numChoosed = numChoosed;
    this.people = people;
    this.personalCheck = personalCheck;
    this.priceChoosed = priceChoosed;
    this.refresh = refresh;
    this.restTime = restTime;
    this.specialChoosed = specialChoosed;
    this.specialPriceChoosed = specialPriceChoosed;
    this.status = status;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.tvIamge = tvIamge;
    this.tvTitleName = tvTitleName;
    this.type = type;
    this.view = view;
  }

  @NonNull
  public static ActivityPurchaseEBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityPurchaseEBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityPurchaseEBinding>inflate(inflater, com.bm.container.R.layout.activity_purchase_e, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPurchaseEBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityPurchaseEBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityPurchaseEBinding>inflate(inflater, com.bm.container.R.layout.activity_purchase_e, null, false, component);
  }

  public static ActivityPurchaseEBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityPurchaseEBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityPurchaseEBinding)bind(component, view, com.bm.container.R.layout.activity_purchase_e);
  }
}
