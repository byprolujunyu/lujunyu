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

public abstract class DialogChooseTypeBinding extends ViewDataBinding {
  @NonNull
  public final View buttomModel;

  @NonNull
  public final ListView cityList;

  @NonNull
  public final View leftModel;

  @NonNull
  public final View rightModel;

  @NonNull
  public final View topModel;

  protected DialogChooseTypeBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, View buttomModel, ListView cityList, View leftModel, View rightModel,
      View topModel) {
    super(_bindingComponent, _root, _localFieldCount);
    this.buttomModel = buttomModel;
    this.cityList = cityList;
    this.leftModel = leftModel;
    this.rightModel = rightModel;
    this.topModel = topModel;
  }

  @NonNull
  public static DialogChooseTypeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogChooseTypeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogChooseTypeBinding>inflate(inflater, com.bm.container.R.layout.dialog_choose_type, root, attachToRoot, component);
  }

  @NonNull
  public static DialogChooseTypeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogChooseTypeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogChooseTypeBinding>inflate(inflater, com.bm.container.R.layout.dialog_choose_type, null, false, component);
  }

  public static DialogChooseTypeBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DialogChooseTypeBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DialogChooseTypeBinding)bind(component, view, com.bm.container.R.layout.dialog_choose_type);
  }
}
