package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class ItemChooseCityBinding extends ViewDataBinding {
  @NonNull
  public final TextView item;

  protected ItemChooseCityBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView item) {
    super(_bindingComponent, _root, _localFieldCount);
    this.item = item;
  }

  @NonNull
  public static ItemChooseCityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemChooseCityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemChooseCityBinding>inflate(inflater, com.bm.container.R.layout.item_choose_city, root, attachToRoot, component);
  }

  @NonNull
  public static ItemChooseCityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemChooseCityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemChooseCityBinding>inflate(inflater, com.bm.container.R.layout.item_choose_city, null, false, component);
  }

  public static ItemChooseCityBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemChooseCityBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemChooseCityBinding)bind(component, view, com.bm.container.R.layout.item_choose_city);
  }
}
