package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public abstract class ItemBillOfLadingBinding extends ViewDataBinding {
  @NonNull
  public final Button button;

  @NonNull
  public final TextView car;

  @NonNull
  public final EditText carno;

  @NonNull
  public final TextView delete;

  @NonNull
  public final EditText inputCompanyEmail;

  @NonNull
  public final EditText inputCompanyName;

  @NonNull
  public final EditText name;

  @NonNull
  public final EditText number;

  @NonNull
  public final EditText phone;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView time;

  protected ItemBillOfLadingBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button button, TextView car, EditText carno, TextView delete,
      EditText inputCompanyEmail, EditText inputCompanyName, EditText name, EditText number,
      EditText phone, TextView textView3, TextView textView4, TextView time) {
    super(_bindingComponent, _root, _localFieldCount);
    this.button = button;
    this.car = car;
    this.carno = carno;
    this.delete = delete;
    this.inputCompanyEmail = inputCompanyEmail;
    this.inputCompanyName = inputCompanyName;
    this.name = name;
    this.number = number;
    this.phone = phone;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.time = time;
  }

  @NonNull
  public static ItemBillOfLadingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemBillOfLadingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemBillOfLadingBinding>inflate(inflater, com.bm.container.R.layout.item_bill_of_lading, root, attachToRoot, component);
  }

  @NonNull
  public static ItemBillOfLadingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemBillOfLadingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemBillOfLadingBinding>inflate(inflater, com.bm.container.R.layout.item_bill_of_lading, null, false, component);
  }

  public static ItemBillOfLadingBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemBillOfLadingBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemBillOfLadingBinding)bind(component, view, com.bm.container.R.layout.item_bill_of_lading);
  }
}
