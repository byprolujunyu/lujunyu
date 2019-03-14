package com.bm.container.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class TopbarBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivTitle;

  @NonNull
  public final RelativeLayout leftModel;

  @NonNull
  public final ImageView rightIcon;

  @NonNull
  public final LinearLayout rightModel;

  @NonNull
  public final ImageView rightPoint;

  @NonNull
  public final TextView rightText;

  @NonNull
  public final LinearLayout rightTextModel;

  @NonNull
  public final TextView rightTextname;

  @NonNull
  public final TextView title;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final View viewOvle;

  protected TopbarBinding(DataBindingComponent _bindingComponent, View _root, int _localFieldCount,
      ImageView ivTitle, RelativeLayout leftModel, ImageView rightIcon, LinearLayout rightModel,
      ImageView rightPoint, TextView rightText, LinearLayout rightTextModel, TextView rightTextname,
      TextView title, Toolbar toolbar, View viewOvle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivTitle = ivTitle;
    this.leftModel = leftModel;
    this.rightIcon = rightIcon;
    this.rightModel = rightModel;
    this.rightPoint = rightPoint;
    this.rightText = rightText;
    this.rightTextModel = rightTextModel;
    this.rightTextname = rightTextname;
    this.title = title;
    this.toolbar = toolbar;
    this.viewOvle = viewOvle;
  }

  @NonNull
  public static TopbarBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static TopbarBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<TopbarBinding>inflate(inflater, com.bm.container.R.layout.topbar, root, attachToRoot, component);
  }

  @NonNull
  public static TopbarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static TopbarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<TopbarBinding>inflate(inflater, com.bm.container.R.layout.topbar, null, false, component);
  }

  public static TopbarBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static TopbarBinding bind(@NonNull View view, @Nullable DataBindingComponent component) {
    return (TopbarBinding)bind(component, view, com.bm.container.R.layout.topbar);
  }
}
