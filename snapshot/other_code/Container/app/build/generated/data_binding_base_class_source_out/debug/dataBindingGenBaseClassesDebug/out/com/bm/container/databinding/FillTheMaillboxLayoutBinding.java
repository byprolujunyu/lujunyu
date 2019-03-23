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
import android.widget.ListView;
import android.widget.TextView;

public abstract class FillTheMaillboxLayoutBinding extends ViewDataBinding {
  @NonNull
  public final TextView addChest;

  @NonNull
  public final EditText inputChest;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final ListView listChest;

  @NonNull
  public final LinearLayout llButton;

  @NonNull
  public final TopbarBinding topbar;

  @NonNull
  public final TextView tvSubmit;

  protected FillTheMaillboxLayoutBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView addChest, EditText inputChest, LinearLayout linearLayout,
      ListView listChest, LinearLayout llButton, TopbarBinding topbar, TextView tvSubmit) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addChest = addChest;
    this.inputChest = inputChest;
    this.linearLayout = linearLayout;
    this.listChest = listChest;
    this.llButton = llButton;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.tvSubmit = tvSubmit;
  }

  @NonNull
  public static FillTheMaillboxLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FillTheMaillboxLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FillTheMaillboxLayoutBinding>inflate(inflater, com.bm.container.R.layout.fill_the_maillbox_layout, root, attachToRoot, component);
  }

  @NonNull
  public static FillTheMaillboxLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FillTheMaillboxLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FillTheMaillboxLayoutBinding>inflate(inflater, com.bm.container.R.layout.fill_the_maillbox_layout, null, false, component);
  }

  public static FillTheMaillboxLayoutBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FillTheMaillboxLayoutBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FillTheMaillboxLayoutBinding)bind(component, view, com.bm.container.R.layout.fill_the_maillbox_layout);
  }
}
