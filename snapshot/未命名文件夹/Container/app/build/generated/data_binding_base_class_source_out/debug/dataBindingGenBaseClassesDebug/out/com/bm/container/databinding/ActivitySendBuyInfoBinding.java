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
import android.widget.TextView;

public abstract class ActivitySendBuyInfoBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout city;

  @NonNull
  public final TextView cityText;

  @NonNull
  public final LinearLayout country;

  @NonNull
  public final TextView countryText;

  @NonNull
  public final EditText editTitleName;

  @NonNull
  public final EditText etAge;

  @NonNull
  public final LinearLayout num;

  @NonNull
  public final EditText number;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final EditText special;

  @NonNull
  public final LinearLayout status;

  @NonNull
  public final TextView statusText;

  @NonNull
  public final Button sure;

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

  protected ActivitySendBuyInfoBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout city, TextView cityText, LinearLayout country,
      TextView countryText, EditText editTitleName, EditText etAge, LinearLayout num,
      EditText number, SwipeRefreshLayout refresh, EditText special, LinearLayout status,
      TextView statusText, Button sure, LinearLayout time, TextView timeText, TopbarBinding topbar,
      LinearLayout type, LinearLayout typeAge, TextView typeText) {
    super(_bindingComponent, _root, _localFieldCount);
    this.city = city;
    this.cityText = cityText;
    this.country = country;
    this.countryText = countryText;
    this.editTitleName = editTitleName;
    this.etAge = etAge;
    this.num = num;
    this.number = number;
    this.refresh = refresh;
    this.special = special;
    this.status = status;
    this.statusText = statusText;
    this.sure = sure;
    this.time = time;
    this.timeText = timeText;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.type = type;
    this.typeAge = typeAge;
    this.typeText = typeText;
  }

  @NonNull
  public static ActivitySendBuyInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySendBuyInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySendBuyInfoBinding>inflate(inflater, com.bm.container.R.layout.activity_send_buy_info, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySendBuyInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySendBuyInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySendBuyInfoBinding>inflate(inflater, com.bm.container.R.layout.activity_send_buy_info, null, false, component);
  }

  public static ActivitySendBuyInfoBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySendBuyInfoBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySendBuyInfoBinding)bind(component, view, com.bm.container.R.layout.activity_send_buy_info);
  }
}
