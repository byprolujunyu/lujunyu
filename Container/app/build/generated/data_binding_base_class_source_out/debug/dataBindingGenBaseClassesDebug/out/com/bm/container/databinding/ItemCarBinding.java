package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class ItemCarBinding extends ViewDataBinding {
  @NonNull
  public final TextView car;

  @NonNull
  public final EditText carno;

  @NonNull
  public final TextView delete;

  @NonNull
  public final LinearLayout lllayout;

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

  protected ItemCarBinding(DataBindingComponent _bindingComponent, View _root, int _localFieldCount,
      TextView car, EditText carno, TextView delete, LinearLayout lllayout, EditText name,
      EditText number, EditText phone, TextView textView3, TextView textView4, TextView time) {
    super(_bindingComponent, _root, _localFieldCount);
    this.car = car;
    this.carno = carno;
    this.delete = delete;
    this.lllayout = lllayout;
    this.name = name;
    this.number = number;
    this.phone = phone;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.time = time;
  }

  @NonNull
  public static ItemCarBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemCarBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemCarBinding>inflate(inflater, com.bm.container.R.layout.item_car, root, attachToRoot, component);
  }

  @NonNull
  public static ItemCarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemCarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemCarBinding>inflate(inflater, com.bm.container.R.layout.item_car, null, false, component);
  }

  public static ItemCarBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemCarBinding bind(@NonNull View view, @Nullable DataBindingComponent component) {
    return (ItemCarBinding)bind(component, view, com.bm.container.R.layout.item_car);
  }
}
