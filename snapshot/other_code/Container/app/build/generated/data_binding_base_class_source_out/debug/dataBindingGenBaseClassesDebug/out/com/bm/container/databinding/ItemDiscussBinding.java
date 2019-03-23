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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bm.container.view.CircleImageView;
import com.bm.container.view.ExtraGridView;
import com.bm.container.view.ExtraListView;

public abstract class ItemDiscussBinding extends ViewDataBinding {
  @NonNull
  public final TextView all;

  @NonNull
  public final TextView content;

  @NonNull
  public final CircleImageView face;

  @NonNull
  public final ExtraGridView image;

  @NonNull
  public final ExtraListView list;

  @NonNull
  public final LinearLayout modelReply;

  @NonNull
  public final RelativeLayout modelTop;

  @NonNull
  public final LinearLayout modelZan;

  @NonNull
  public final TextView name;

  @NonNull
  public final ImageView replyImg;

  @NonNull
  public final TextView replyNum;

  @NonNull
  public final TextView zanNum;

  @NonNull
  public final ImageView zanPic;

  protected ItemDiscussBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView all, TextView content, CircleImageView face,
      ExtraGridView image, ExtraListView list, LinearLayout modelReply, RelativeLayout modelTop,
      LinearLayout modelZan, TextView name, ImageView replyImg, TextView replyNum, TextView zanNum,
      ImageView zanPic) {
    super(_bindingComponent, _root, _localFieldCount);
    this.all = all;
    this.content = content;
    this.face = face;
    this.image = image;
    this.list = list;
    this.modelReply = modelReply;
    this.modelTop = modelTop;
    this.modelZan = modelZan;
    this.name = name;
    this.replyImg = replyImg;
    this.replyNum = replyNum;
    this.zanNum = zanNum;
    this.zanPic = zanPic;
  }

  @NonNull
  public static ItemDiscussBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemDiscussBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemDiscussBinding>inflate(inflater, com.bm.container.R.layout.item_discuss, root, attachToRoot, component);
  }

  @NonNull
  public static ItemDiscussBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemDiscussBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemDiscussBinding>inflate(inflater, com.bm.container.R.layout.item_discuss, null, false, component);
  }

  public static ItemDiscussBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemDiscussBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemDiscussBinding)bind(component, view, com.bm.container.R.layout.item_discuss);
  }
}
