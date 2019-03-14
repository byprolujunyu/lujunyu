package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hongtian.easyroundimageview.EasyRoundImageView;

public abstract class ItemImageBinding extends ViewDataBinding {
  @NonNull
  public final EasyRoundImageView image;

  protected ItemImageBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EasyRoundImageView image) {
    super(_bindingComponent, _root, _localFieldCount);
    this.image = image;
  }

  @NonNull
  public static ItemImageBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemImageBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemImageBinding>inflate(inflater, com.bm.container.R.layout.item_image, root, attachToRoot, component);
  }

  @NonNull
  public static ItemImageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemImageBinding>inflate(inflater, com.bm.container.R.layout.item_image, null, false, component);
  }

  public static ItemImageBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemImageBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemImageBinding)bind(component, view, com.bm.container.R.layout.item_image);
  }
}
