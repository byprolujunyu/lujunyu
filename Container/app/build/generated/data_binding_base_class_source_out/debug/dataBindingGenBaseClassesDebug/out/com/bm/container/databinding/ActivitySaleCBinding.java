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
import android.widget.TextView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bm.container.view.ExtraListView;

public abstract class ActivitySaleCBinding extends ViewDataBinding {
  @NonNull
  public final ConvenientBanner banner;

  @NonNull
  public final CheckBox checkbox;

  @NonNull
  public final EditText editText3;

  @NonNull
  public final ExtraListView historyList;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final Button sure;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final TopbarBinding topbar;

  protected ActivitySaleCBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConvenientBanner banner, CheckBox checkbox, EditText editText3,
      ExtraListView historyList, SwipeRefreshLayout refresh, Button sure, TextView textView8,
      TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.banner = banner;
    this.checkbox = checkbox;
    this.editText3 = editText3;
    this.historyList = historyList;
    this.refresh = refresh;
    this.sure = sure;
    this.textView8 = textView8;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static ActivitySaleCBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySaleCBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySaleCBinding>inflate(inflater, com.bm.container.R.layout.activity_sale_c, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySaleCBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySaleCBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySaleCBinding>inflate(inflater, com.bm.container.R.layout.activity_sale_c, null, false, component);
  }

  public static ActivitySaleCBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySaleCBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySaleCBinding)bind(component, view, com.bm.container.R.layout.activity_sale_c);
  }
}
