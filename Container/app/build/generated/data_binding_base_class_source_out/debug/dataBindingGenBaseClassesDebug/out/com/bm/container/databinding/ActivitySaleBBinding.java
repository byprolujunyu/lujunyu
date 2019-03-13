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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bm.container.view.ExtraListView;
import com.bm.container.view.XEditText;

public abstract class ActivitySaleBBinding extends ViewDataBinding {
  @NonNull
  public final XEditText bankIdText;

  @NonNull
  public final EditText bankName;

  @NonNull
  public final ConvenientBanner banner;

  @NonNull
  public final CheckBox checkInvoice;

  @NonNull
  public final TextView company;

  @NonNull
  public final RadioButton companyCheck;

  @NonNull
  public final LinearLayout companyInfo;

  @NonNull
  public final EditText etAdd;

  @NonNull
  public final ExtraListView historyList;

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
  public final LinearLayout llPriceChoosed;

  @NonNull
  public final LinearLayout llStartPrice;

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
  public final TextView num;

  @NonNull
  public final EditText offerPrice;

  @NonNull
  public final TextView people;

  @NonNull
  public final TextView personal;

  @NonNull
  public final RadioButton personalCheck;

  @NonNull
  public final TextView priceChoosed;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final TextView restTime;

  @NonNull
  public final LinearLayout salerModel;

  @NonNull
  public final TextView specialChoosed;

  @NonNull
  public final TextView specialPriceChoosed;

  @NonNull
  public final TextView status;

  @NonNull
  public final Button sure;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final TextView textViewpic;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final TextView tvAge;

  @NonNull
  public final TextView tvIamge;

  @NonNull
  public final TextView tvRemark;

  @NonNull
  public final TextView tvStartPrice;

  @NonNull
  public final TextView tvStatus;

  @NonNull
  public final TextView tvTitleName;

  @NonNull
  public final TextView type;

  protected ActivitySaleBBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, XEditText bankIdText, EditText bankName, ConvenientBanner banner,
      CheckBox checkInvoice, TextView company, RadioButton companyCheck, LinearLayout companyInfo,
      EditText etAdd, ExtraListView historyList, LinearLayout invoiceBasicInformation,
      TextView invoiceChoosed, EditText invoiceContent, EditText invoiceHead,
      LinearLayout invoiceModel, EditText invoicePhone, TextView isGoing, ImageView ivType,
      LinearLayout llAge, LinearLayout llEtAdd, LinearLayout llInvoicePhone, LinearLayout llIsGoing,
      LinearLayout llPriceChoosed, LinearLayout llStartPrice, LinearLayout llStatus,
      LinearLayout llbankIdText, LinearLayout llbankName, LinearLayout llinvoiceContent,
      TextView location, TextView num, EditText offerPrice, TextView people, TextView personal,
      RadioButton personalCheck, TextView priceChoosed, SwipeRefreshLayout refresh,
      TextView restTime, LinearLayout salerModel, TextView specialChoosed,
      TextView specialPriceChoosed, TextView status, Button sure, TextView textView2,
      TextView textView7, TextView textView8, TextView textViewpic, TopbarBinding topbar,
      TextView tvAge, TextView tvIamge, TextView tvRemark, TextView tvStartPrice, TextView tvStatus,
      TextView tvTitleName, TextView type) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bankIdText = bankIdText;
    this.bankName = bankName;
    this.banner = banner;
    this.checkInvoice = checkInvoice;
    this.company = company;
    this.companyCheck = companyCheck;
    this.companyInfo = companyInfo;
    this.etAdd = etAdd;
    this.historyList = historyList;
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
    this.llPriceChoosed = llPriceChoosed;
    this.llStartPrice = llStartPrice;
    this.llStatus = llStatus;
    this.llbankIdText = llbankIdText;
    this.llbankName = llbankName;
    this.llinvoiceContent = llinvoiceContent;
    this.location = location;
    this.num = num;
    this.offerPrice = offerPrice;
    this.people = people;
    this.personal = personal;
    this.personalCheck = personalCheck;
    this.priceChoosed = priceChoosed;
    this.refresh = refresh;
    this.restTime = restTime;
    this.salerModel = salerModel;
    this.specialChoosed = specialChoosed;
    this.specialPriceChoosed = specialPriceChoosed;
    this.status = status;
    this.sure = sure;
    this.textView2 = textView2;
    this.textView7 = textView7;
    this.textView8 = textView8;
    this.textViewpic = textViewpic;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.tvAge = tvAge;
    this.tvIamge = tvIamge;
    this.tvRemark = tvRemark;
    this.tvStartPrice = tvStartPrice;
    this.tvStatus = tvStatus;
    this.tvTitleName = tvTitleName;
    this.type = type;
  }

  @NonNull
  public static ActivitySaleBBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySaleBBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySaleBBinding>inflate(inflater, com.bm.container.R.layout.activity_sale_b, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySaleBBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySaleBBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySaleBBinding>inflate(inflater, com.bm.container.R.layout.activity_sale_b, null, false, component);
  }

  public static ActivitySaleBBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySaleBBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySaleBBinding)bind(component, view, com.bm.container.R.layout.activity_sale_b);
  }
}
