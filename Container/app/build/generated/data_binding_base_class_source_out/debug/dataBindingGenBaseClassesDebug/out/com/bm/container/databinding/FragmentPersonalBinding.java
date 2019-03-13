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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bm.container.view.CircleImageView;

public abstract class FragmentPersonalBinding extends ViewDataBinding {
  @NonNull
  public final TextView bank;

  @NonNull
  public final TextView bankId;

  @NonNull
  public final TextView bankName;

  @NonNull
  public final LinearLayout buyerInfo;

  @NonNull
  public final ImageView changeInfo;

  @NonNull
  public final CircleImageView face;

  @NonNull
  public final LinearLayout feedback;

  @NonNull
  public final LinearLayout message;

  @NonNull
  public final LinearLayout modelBank;

  @NonNull
  public final RelativeLayout modelFace;

  @NonNull
  public final LinearLayout myOrder;

  @NonNull
  public final LinearLayout myPosting;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView nameTitle;

  @NonNull
  public final TextView phone;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final LinearLayout salerInfo;

  @NonNull
  public final LinearLayout salerOrder;

  @NonNull
  public final LinearLayout salerOrderModel;

  @NonNull
  public final ImageView setting;

  @NonNull
  public final TextView title;

  @NonNull
  public final TextView tvCancelCount;

  @NonNull
  public final TextView tvFinishCount;

  @NonNull
  public final TextView type;

  @NonNull
  public final TextView userId;

  @NonNull
  public final View viewOvle;

  @NonNull
  public final View viewOvleFour;

  @NonNull
  public final View viewOvleThree;

  @NonNull
  public final View viewOvleTwo;

  @NonNull
  public final View viewSalerInfoModel;

  @NonNull
  public final View viewSalerOrderModel;

  @NonNull
  public final View viewSettingMessage;

  protected FragmentPersonalBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView bank, TextView bankId, TextView bankName,
      LinearLayout buyerInfo, ImageView changeInfo, CircleImageView face, LinearLayout feedback,
      LinearLayout message, LinearLayout modelBank, RelativeLayout modelFace, LinearLayout myOrder,
      LinearLayout myPosting, TextView name, TextView nameTitle, TextView phone,
      SwipeRefreshLayout refresh, LinearLayout salerInfo, LinearLayout salerOrder,
      LinearLayout salerOrderModel, ImageView setting, TextView title, TextView tvCancelCount,
      TextView tvFinishCount, TextView type, TextView userId, View viewOvle, View viewOvleFour,
      View viewOvleThree, View viewOvleTwo, View viewSalerInfoModel, View viewSalerOrderModel,
      View viewSettingMessage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bank = bank;
    this.bankId = bankId;
    this.bankName = bankName;
    this.buyerInfo = buyerInfo;
    this.changeInfo = changeInfo;
    this.face = face;
    this.feedback = feedback;
    this.message = message;
    this.modelBank = modelBank;
    this.modelFace = modelFace;
    this.myOrder = myOrder;
    this.myPosting = myPosting;
    this.name = name;
    this.nameTitle = nameTitle;
    this.phone = phone;
    this.refresh = refresh;
    this.salerInfo = salerInfo;
    this.salerOrder = salerOrder;
    this.salerOrderModel = salerOrderModel;
    this.setting = setting;
    this.title = title;
    this.tvCancelCount = tvCancelCount;
    this.tvFinishCount = tvFinishCount;
    this.type = type;
    this.userId = userId;
    this.viewOvle = viewOvle;
    this.viewOvleFour = viewOvleFour;
    this.viewOvleThree = viewOvleThree;
    this.viewOvleTwo = viewOvleTwo;
    this.viewSalerInfoModel = viewSalerInfoModel;
    this.viewSalerOrderModel = viewSalerOrderModel;
    this.viewSettingMessage = viewSettingMessage;
  }

  @NonNull
  public static FragmentPersonalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentPersonalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentPersonalBinding>inflate(inflater, com.bm.container.R.layout.fragment_personal, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentPersonalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentPersonalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentPersonalBinding>inflate(inflater, com.bm.container.R.layout.fragment_personal, null, false, component);
  }

  public static FragmentPersonalBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentPersonalBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentPersonalBinding)bind(component, view, com.bm.container.R.layout.fragment_personal);
  }
}
