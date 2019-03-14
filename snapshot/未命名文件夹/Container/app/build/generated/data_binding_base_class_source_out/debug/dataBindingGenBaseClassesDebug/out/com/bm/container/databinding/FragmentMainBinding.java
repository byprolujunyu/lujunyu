package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bm.container.view.ListViewForScrollView;
import com.bm.container.view.MySwipeRefreshLayout;

public abstract class FragmentMainBinding extends ViewDataBinding {
  @NonNull
  public final ConvenientBanner banner;

  @NonNull
  public final LinearLayout iWantToBuy;

  @NonNull
  public final LinearLayout iWantToSale;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ImageView ivIamgetop;

  @NonNull
  public final ListViewForScrollView listBuy;

  @NonNull
  public final RecyclerView listSale;

  @NonNull
  public final MySwipeRefreshLayout refresh;

  @NonNull
  public final TopbarBinding topbar;

  protected FragmentMainBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConvenientBanner banner, LinearLayout iWantToBuy,
      LinearLayout iWantToSale, ImageView imageView, ImageView ivIamgetop,
      ListViewForScrollView listBuy, RecyclerView listSale, MySwipeRefreshLayout refresh,
      TopbarBinding topbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.banner = banner;
    this.iWantToBuy = iWantToBuy;
    this.iWantToSale = iWantToSale;
    this.imageView = imageView;
    this.ivIamgetop = ivIamgetop;
    this.listBuy = listBuy;
    this.listSale = listSale;
    this.refresh = refresh;
    this.topbar = topbar;
    setContainedBinding(this.topbar);;
  }

  @NonNull
  public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMainBinding>inflate(inflater, com.bm.container.R.layout.fragment_main, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMainBinding>inflate(inflater, com.bm.container.R.layout.fragment_main, null, false, component);
  }

  public static FragmentMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMainBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMainBinding)bind(component, view, com.bm.container.R.layout.fragment_main);
  }
}
