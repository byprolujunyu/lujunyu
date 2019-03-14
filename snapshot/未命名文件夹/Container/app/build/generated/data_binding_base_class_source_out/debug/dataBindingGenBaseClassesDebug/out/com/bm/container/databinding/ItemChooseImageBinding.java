package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.hongtian.easyroundimageview.EasyRoundImageView;

public abstract class ItemChooseImageBinding extends ViewDataBinding {
  @NonNull
  public final ImageView delete;

  @NonNull
  public final EasyRoundImageView image;

  protected ItemChooseImageBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView delete, EasyRoundImageView image) {
    super(_bindingComponent, _root, _localFieldCount);
    this.delete = delete;
    this.image = image;
  }

  @NonNull
  public static ItemChooseImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemChooseImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemChooseImageBinding>inflate(inflater, com.bm.container.R.layout.item_choose_image, root, attachToRoot, component);
  }

  @NonNull
  public static ItemChooseImageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemChooseImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemChooseImageBinding>inflate(inflater, com.bm.container.R.layout.item_choose_image, null, false, component);
  }

  public static ItemChooseImageBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemChooseImageBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemChooseImageBinding)bind(component, view, com.bm.container.R.layout.item_choose_image);
  }
}
