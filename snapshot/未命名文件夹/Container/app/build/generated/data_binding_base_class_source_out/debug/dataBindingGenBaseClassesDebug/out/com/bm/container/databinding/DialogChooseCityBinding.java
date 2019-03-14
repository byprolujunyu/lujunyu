package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public abstract class DialogChooseCityBinding extends ViewDataBinding {
  @NonNull
  public final View buttomModel;

  @NonNull
  public final ListView cityList;

  @NonNull
  public final View rightModel;

  @NonNull
  public final View topModel;

  protected DialogChooseCityBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, View buttomModel, ListView cityList, View rightModel, View topModel) {
    super(_bindingComponent, _root, _localFieldCount);
    this.buttomModel = buttomModel;
    this.cityList = cityList;
    this.rightModel = rightModel;
    this.topModel = topModel;
  }

  @NonNull
  public static DialogChooseCityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogChooseCityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogChooseCityBinding>inflate(inflater, com.bm.container.R.layout.dialog_choose_city, root, attachToRoot, component);
  }

  @NonNull
  public static DialogChooseCityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogChooseCityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogChooseCityBinding>inflate(inflater, com.bm.container.R.layout.dialog_choose_city, null, false, component);
  }

  public static DialogChooseCityBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DialogChooseCityBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DialogChooseCityBinding)bind(component, view, com.bm.container.R.layout.dialog_choose_city);
  }
}
