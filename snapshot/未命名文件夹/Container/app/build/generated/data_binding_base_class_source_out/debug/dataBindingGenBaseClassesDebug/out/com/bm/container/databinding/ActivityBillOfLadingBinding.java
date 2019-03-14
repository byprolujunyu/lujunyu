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
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bm.container.view.ExtraListView;

public abstract class ActivityBillOfLadingBinding extends ViewDataBinding {
  @NonNull
  public final TextView addChest;

  @NonNull
  public final Button button;

  @NonNull
  public final LinearLayout checkGroup;

  @NonNull
  public final EditText deliveryTime;

  @NonNull
  public final EditText inputAddress;

  @NonNull
  public final EditText inputChest;

  @NonNull
  public final EditText inputCompanyEmail;

  @NonNull
  public final EditText inputCompanyName;

  @NonNull
  public final EditText inputEmail;

  @NonNull
  public final EditText inputMoney;

  @NonNull
  public final EditText inputName;

  @NonNull
  public final EditText inputNo;

  @NonNull
  public final EditText inputPhone;

  @NonNull
  public final EditText inputUser;

  @NonNull
  public final ItemCarBinding itemItemCar;

  @NonNull
  public final TextView leftButton;

  @NonNull
  public final ExtraListView list;

  @NonNull
  public final ExtraListView listChest;

  @NonNull
  public final LinearLayout llAdd;

  @NonNull
  public final LinearLayout llButton;

  @NonNull
  public final LinearLayout llList;

  @NonNull
  public final LinearLayout llName;

  @NonNull
  public final LinearLayout modelButton;

  @NonNull
  public final RadioButton money;

  @NonNull
  public final RadioButton noMoney;

  @NonNull
  public final TextView num;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final TextView rightButton;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final TextView title;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final TextView tvOrderNo;

  protected ActivityBillOfLadingBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView addChest, Button button, LinearLayout checkGroup,
      EditText deliveryTime, EditText inputAddress, EditText inputChest, EditText inputCompanyEmail,
      EditText inputCompanyName, EditText inputEmail, EditText inputMoney, EditText inputName,
      EditText inputNo, EditText inputPhone, EditText inputUser, ItemCarBinding itemItemCar,
      TextView leftButton, ExtraListView list, ExtraListView listChest, LinearLayout llAdd,
      LinearLayout llButton, LinearLayout llList, LinearLayout llName, LinearLayout modelButton,
      RadioButton money, RadioButton noMoney, TextView num, SwipeRefreshLayout refresh,
      TextView rightButton, ScrollView scrollView, TextView title, TopbarBinding topbar,
      TextView tvOrderNo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addChest = addChest;
    this.button = button;
    this.checkGroup = checkGroup;
    this.deliveryTime = deliveryTime;
    this.inputAddress = inputAddress;
    this.inputChest = inputChest;
    this.inputCompanyEmail = inputCompanyEmail;
    this.inputCompanyName = inputCompanyName;
    this.inputEmail = inputEmail;
    this.inputMoney = inputMoney;
    this.inputName = inputName;
    this.inputNo = inputNo;
    this.inputPhone = inputPhone;
    this.inputUser = inputUser;
    this.itemItemCar = itemItemCar;
    setContainedBinding(this.itemItemCar);;
    this.leftButton = leftButton;
    this.list = list;
    this.listChest = listChest;
    this.llAdd = llAdd;
    this.llButton = llButton;
    this.llList = llList;
    this.llName = llName;
    this.modelButton = modelButton;
    this.money = money;
    this.noMoney = noMoney;
    this.num = num;
    this.refresh = refresh;
    this.rightButton = rightButton;
    this.scrollView = scrollView;
    this.title = title;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.tvOrderNo = tvOrderNo;
  }

  @NonNull
  public static ActivityBillOfLadingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityBillOfLadingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityBillOfLadingBinding>inflate(inflater, com.bm.container.R.layout.activity_bill_of_lading, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityBillOfLadingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityBillOfLadingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityBillOfLadingBinding>inflate(inflater, com.bm.container.R.layout.activity_bill_of_lading, null, false, component);
  }

  public static ActivityBillOfLadingBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityBillOfLadingBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityBillOfLadingBinding)bind(component, view, com.bm.container.R.layout.activity_bill_of_lading);
  }
}
