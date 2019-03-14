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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.bm.container.view.MultipleRadioGroup;
import com.hongtian.easyroundimageview.EasyRoundImageView;

public abstract class ActivitySendSaleInfoBinding extends ViewDataBinding {
  @NonNull
  public final TextView allMoney;

  @NonNull
  public final LinearLayout allMoneyModel;

  @NonNull
  public final RadioButton bid;

  @NonNull
  public final LinearLayout city;

  @NonNull
  public final TextView cityText;

  @NonNull
  public final LinearLayout country;

  @NonNull
  public final TextView countryText;

  @NonNull
  public final EditText editLowPrice;

  @NonNull
  public final EditText editRemarks;

  @NonNull
  public final EditText editTitleName;

  @NonNull
  public final EditText etAge;

  @NonNull
  public final EasyRoundImageView file0;

  @NonNull
  public final EasyRoundImageView file1;

  @NonNull
  public final EasyRoundImageView file2;

  @NonNull
  public final EasyRoundImageView file3;

  @NonNull
  public final EasyRoundImageView file4;

  @NonNull
  public final EasyRoundImageView file5;

  @NonNull
  public final RadioButton hasInvoice;

  @NonNull
  public final EditText inputMoney;

  @NonNull
  public final MultipleRadioGroup invoice;

  @NonNull
  public final ImageView ivDelete0;

  @NonNull
  public final ImageView ivDelete1;

  @NonNull
  public final ImageView ivDelete2;

  @NonNull
  public final ImageView ivDelete3;

  @NonNull
  public final ImageView ivDelete4;

  @NonNull
  public final ImageView ivDelete5;

  @NonNull
  public final LinearLayout llLowPrice;

  @NonNull
  public final LinearLayout money;

  @NonNull
  public final EditText moneyInput;

  @NonNull
  public final RadioButton noInvoice;

  @NonNull
  public final LinearLayout num;

  @NonNull
  public final EditText number;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final RadioButton sale;

  @NonNull
  public final MultipleRadioGroup saleOrBid;

  @NonNull
  public final MultipleRadioGroup specialCheck;

  @NonNull
  public final RadioButton specialCheckLeft;

  @NonNull
  public final LinearLayout status;

  @NonNull
  public final TextView statusText;

  @NonNull
  public final TextView sure;

  @NonNull
  public final TextView textViewpicTwo;

  @NonNull
  public final LinearLayout time;

  @NonNull
  public final TextView timeText;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final LinearLayout type;

  @NonNull
  public final LinearLayout typeAge;

  @NonNull
  public final TextView typeText;

  protected ActivitySendSaleInfoBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView allMoney, LinearLayout allMoneyModel, RadioButton bid,
      LinearLayout city, TextView cityText, LinearLayout country, TextView countryText,
      EditText editLowPrice, EditText editRemarks, EditText editTitleName, EditText etAge,
      EasyRoundImageView file0, EasyRoundImageView file1, EasyRoundImageView file2,
      EasyRoundImageView file3, EasyRoundImageView file4, EasyRoundImageView file5,
      RadioButton hasInvoice, EditText inputMoney, MultipleRadioGroup invoice, ImageView ivDelete0,
      ImageView ivDelete1, ImageView ivDelete2, ImageView ivDelete3, ImageView ivDelete4,
      ImageView ivDelete5, LinearLayout llLowPrice, LinearLayout money, EditText moneyInput,
      RadioButton noInvoice, LinearLayout num, EditText number, SwipeRefreshLayout refresh,
      RadioButton sale, MultipleRadioGroup saleOrBid, MultipleRadioGroup specialCheck,
      RadioButton specialCheckLeft, LinearLayout status, TextView statusText, TextView sure,
      TextView textViewpicTwo, LinearLayout time, TextView timeText, TopbarBinding topbar,
      LinearLayout type, LinearLayout typeAge, TextView typeText) {
    super(_bindingComponent, _root, _localFieldCount);
    this.allMoney = allMoney;
    this.allMoneyModel = allMoneyModel;
    this.bid = bid;
    this.city = city;
    this.cityText = cityText;
    this.country = country;
    this.countryText = countryText;
    this.editLowPrice = editLowPrice;
    this.editRemarks = editRemarks;
    this.editTitleName = editTitleName;
    this.etAge = etAge;
    this.file0 = file0;
    this.file1 = file1;
    this.file2 = file2;
    this.file3 = file3;
    this.file4 = file4;
    this.file5 = file5;
    this.hasInvoice = hasInvoice;
    this.inputMoney = inputMoney;
    this.invoice = invoice;
    this.ivDelete0 = ivDelete0;
    this.ivDelete1 = ivDelete1;
    this.ivDelete2 = ivDelete2;
    this.ivDelete3 = ivDelete3;
    this.ivDelete4 = ivDelete4;
    this.ivDelete5 = ivDelete5;
    this.llLowPrice = llLowPrice;
    this.money = money;
    this.moneyInput = moneyInput;
    this.noInvoice = noInvoice;
    this.num = num;
    this.number = number;
    this.refresh = refresh;
    this.sale = sale;
    this.saleOrBid = saleOrBid;
    this.specialCheck = specialCheck;
    this.specialCheckLeft = specialCheckLeft;
    this.status = status;
    this.statusText = statusText;
    this.sure = sure;
    this.textViewpicTwo = textViewpicTwo;
    this.time = time;
    this.timeText = timeText;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.type = type;
    this.typeAge = typeAge;
    this.typeText = typeText;
  }

  @NonNull
  public static ActivitySendSaleInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySendSaleInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySendSaleInfoBinding>inflate(inflater, com.bm.container.R.layout.activity_send_sale_info, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySendSaleInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySendSaleInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySendSaleInfoBinding>inflate(inflater, com.bm.container.R.layout.activity_send_sale_info, null, false, component);
  }

  public static ActivitySendSaleInfoBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySendSaleInfoBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySendSaleInfoBinding)bind(component, view, com.bm.container.R.layout.activity_send_sale_info);
  }
}
