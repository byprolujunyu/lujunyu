package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class FragmentMarketBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout choooseCity;

  @NonNull
  public final RelativeLayout choooseMoney;

  @NonNull
  public final RelativeLayout choooseStatus;

  @NonNull
  public final RelativeLayout choooseType;

  @NonNull
  public final TextView city;

  @NonNull
  public final ImageView cityDirection;

  @NonNull
  public final TextView floatButtonTip;

  @NonNull
  public final RelativeLayout floatModel;

  @NonNull
  public final RecyclerView list;

  @NonNull
  public final TextView money;

  @NonNull
  public final ImageView moneyDirection;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final LinearLayout tabBuy;

  @NonNull
  public final LinearLayout tabSale;

  @NonNull
  public final TopbarSearchBinding topbar;

  @NonNull
  public final TextView tvOne;

  @NonNull
  public final TextView tvStatus;

  @NonNull
  public final TextView tvTwo;

  @NonNull
  public final TextView type;

  @NonNull
  public final ImageView typeDirection;

  @NonNull
  public final ImageView typeStatus;

  @NonNull
  public final View viewOne;

  @NonNull
  public final View viewTwo;

  protected FragmentMarketBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RelativeLayout choooseCity, RelativeLayout choooseMoney,
      RelativeLayout choooseStatus, RelativeLayout choooseType, TextView city,
      ImageView cityDirection, TextView floatButtonTip, RelativeLayout floatModel,
      RecyclerView list, TextView money, ImageView moneyDirection, SwipeRefreshLayout refresh,
      LinearLayout tabBuy, LinearLayout tabSale, TopbarSearchBinding topbar, TextView tvOne,
      TextView tvStatus, TextView tvTwo, TextView type, ImageView typeDirection,
      ImageView typeStatus, View viewOne, View viewTwo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.choooseCity = choooseCity;
    this.choooseMoney = choooseMoney;
    this.choooseStatus = choooseStatus;
    this.choooseType = choooseType;
    this.city = city;
    this.cityDirection = cityDirection;
    this.floatButtonTip = floatButtonTip;
    this.floatModel = floatModel;
    this.list = list;
    this.money = money;
    this.moneyDirection = moneyDirection;
    this.refresh = refresh;
    this.tabBuy = tabBuy;
    this.tabSale = tabSale;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
    this.tvOne = tvOne;
    this.tvStatus = tvStatus;
    this.tvTwo = tvTwo;
    this.type = type;
    this.typeDirection = typeDirection;
    this.typeStatus = typeStatus;
    this.viewOne = viewOne;
    this.viewTwo = viewTwo;
  }

  @NonNull
  public static FragmentMarketBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMarketBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMarketBinding>inflate(inflater, com.bm.container.R.layout.fragment_market, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMarketBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMarketBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMarketBinding>inflate(inflater, com.bm.container.R.layout.fragment_market, null, false, component);
  }

  public static FragmentMarketBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMarketBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMarketBinding)bind(component, view, com.bm.container.R.layout.fragment_market);
  }
}
