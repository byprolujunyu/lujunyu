package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bigkoo.convenientbanner.ConvenientBanner;

public abstract class ItemDiscussBannerBinding extends ViewDataBinding {
  @NonNull
  public final ConvenientBanner banner;

  protected ItemDiscussBannerBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConvenientBanner banner) {
    super(_bindingComponent, _root, _localFieldCount);
    this.banner = banner;
  }

  @NonNull
  public static ItemDiscussBannerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemDiscussBannerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemDiscussBannerBinding>inflate(inflater, com.bm.container.R.layout.item_discuss_banner, root, attachToRoot, component);
  }

  @NonNull
  public static ItemDiscussBannerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemDiscussBannerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemDiscussBannerBinding>inflate(inflater, com.bm.container.R.layout.item_discuss_banner, null, false, component);
  }

  public static ItemDiscussBannerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemDiscussBannerBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemDiscussBannerBinding)bind(component, view, com.bm.container.R.layout.item_discuss_banner);
  }
}
