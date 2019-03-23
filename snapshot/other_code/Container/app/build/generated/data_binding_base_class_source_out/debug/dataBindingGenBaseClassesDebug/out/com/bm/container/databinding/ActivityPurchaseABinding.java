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
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bm.container.view.ExtraListView;
import com.bm.container.view.MultipleRadioGroup;
import com.bm.container.view.PullDownView;
import com.bm.container.view.PullUpView;
import com.hongtian.easyroundimageview.EasyRoundImageView;

public abstract class ActivityPurchaseABinding extends ViewDataBinding {
  @NonNull
  public final ConvenientBanner banner;

  @NonNull
  public final MultipleRadioGroup checkGroup;

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
  public final FrameLayout framlayout;

  @NonNull
  public final ExtraListView historyList;

  @NonNull
  public final EditText inputMoney;

  @NonNull
  public final EditText inputNumber;

  @NonNull
  public final RadioButton invoice;

  @NonNull
  public final TextView isGoing;

  @NonNull
  public final ImageView ivType;

  @NonNull
  public final LinearLayout llAge;

  @NonNull
  public final LinearLayout llIsGoing;

  @NonNull
  public final LinearLayout llStartPrice;

  @NonNull
  public final LinearLayout llStatus;

  @NonNull
  public final TextView location;

  @NonNull
  public final RadioButton money;

  @NonNull
  public final PullUpView more;

  @NonNull
  public final RadioButton noInvoice;

  @NonNull
  public final RadioButton noMoney;

  @NonNull
  public final TextView num;

  @NonNull
  public final TextView people;

  @NonNull
  public final EditText price;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final MultipleRadioGroup require;

  @NonNull
  public final TextView restTime;

  @NonNull
  public final LinearLayout salerModel;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final TextView special;

  @NonNull
  public final TextView status;

  @NonNull
  public final Button sure;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView9;

  @NonNull
  public final TextView textViewpic;

  @NonNull
  public final TextView textViewpicTwo;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final TextView tvAge;

  @NonNull
  public final TextView tvStartPrice;

  @NonNull
  public final TextView tvStatus;

  @NonNull
  public final TextView tvTitleName;

  @NonNull
  public final TextView type;

  @NonNull
  public final PullDownView up;

  @NonNull
  public final WebView web;

  protected ActivityPurchaseABinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConvenientBanner banner, MultipleRadioGroup checkGroup,
      EasyRoundImageView file0, EasyRoundImageView file1, EasyRoundImageView file2,
      EasyRoundImageView file3, EasyRoundImageView file4, EasyRoundImageView file5,
      FrameLayout framlayout, ExtraListView historyList, EditText inputMoney, EditText inputNumber,
      RadioButton invoice, TextView isGoing, ImageView ivType, LinearLayout llAge,
      LinearLayout llIsGoing, LinearLayout llStartPrice, LinearLayout llStatus, TextView location,
      RadioButton money, PullUpView more, RadioButton noInvoice, RadioButton noMoney, TextView num,
      TextView people, EditText price, SwipeRefreshLayout refresh, MultipleRadioGroup require,
      TextView restTime, LinearLayout salerModel, ScrollView scrollView, TextView special,
      TextView status, Button sure, TextView textView2, TextView textView6, TextView textView7,
      TextView textView9, TextView textViewpic, TextView textViewpicTwo, TopbarBinding topbar,
      TextView tvAge, TextView tvStartPrice, TextView tvStatus, TextView tvTitleName, TextView type,
      PullDownView up, WebView web) {
    super(_bindingComponent, _root, _localFieldCount);
    this.banner = banner;
    this.checkGroup = checkGroup;
    this.file0 = file0;
    this.file1 = file1;
    this.file2 = file2;
    this.file3 = file3;
    this.file4 = file4;
    this.file5 = file5;
    this.framlayout = framlayout;
    this.historyList = historyList;
    this.inputMoney = inputMoney;
    this.inputNumber = inputNumber;
    this.invoice = invoice;
    this.isGoing = isGoing;
    this.ivType = ivType;
    this.llAge = llAge;
    this.llIsGoing = llIsGoing;
    this.llStartPrice = llStartPrice;
    this.llStatus = llStatus;
    this.location = location;
    this.money = money;
    this.more = more;
    this.noInvoice = noInvoice;
    this.noMoney = noMoney;
    this.num = num;
    this.people = people;
    this.price = price;
    this.refresh = refresh;
    this.require = require;
    this.restTime = restTime;
    this.salerModel = salerModel;
    this.scrollView = scrollView;
    this.special = special;
    this.status = status;
    this.sure = sure;
    this.textView2 = textView2;
    this.textView6 = textView6;
    this.textView7 = textView7;
    this.textView9 = textView9;
    this.textViewpic = textViewpic;
    this.textViewpicTwo = textViewpicTwo;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.tvAge = tvAge;
    this.tvStartPrice = tvStartPrice;
    this.tvStatus = tvStatus;
    this.tvTitleName = tvTitleName;
    this.type = type;
    this.up = up;
    this.web = web;
  }

  @NonNull
  public static ActivityPurchaseABinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityPurchaseABinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityPurchaseABinding>inflate(inflater, com.bm.container.R.layout.activity_purchase_a, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPurchaseABinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityPurchaseABinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityPurchaseABinding>inflate(inflater, com.bm.container.R.layout.activity_purchase_a, null, false, component);
  }

  public static ActivityPurchaseABinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityPurchaseABinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityPurchaseABinding)bind(component, view, com.bm.container.R.layout.activity_purchase_a);
  }
}
