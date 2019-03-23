package com.bm.container;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.bm.container.databinding.ActivityAgreementBindingImpl;
import com.bm.container.databinding.ActivityBillOfLadingBindingImpl;
import com.bm.container.databinding.ActivityBuyerInfoBindingImpl;
import com.bm.container.databinding.ActivityChangeCompanyInfoBindingImpl;
import com.bm.container.databinding.ActivityChangePersonalInfoBindingImpl;
import com.bm.container.databinding.ActivityChangePwdBindingImpl;
import com.bm.container.databinding.ActivityCityBindingImpl;
import com.bm.container.databinding.ActivityFeedbackBindingImpl;
import com.bm.container.databinding.ActivityFeedbackHistoryBindingImpl;
import com.bm.container.databinding.ActivityForgetPwdBindingImpl;
import com.bm.container.databinding.ActivityIdentificationBindingImpl;
import com.bm.container.databinding.ActivityIntroductionBindingImpl;
import com.bm.container.databinding.ActivityLoginBindingImpl;
import com.bm.container.databinding.ActivityMainBindingImpl;
import com.bm.container.databinding.ActivityMessageBindingImpl;
import com.bm.container.databinding.ActivityMyOrderBindingImpl;
import com.bm.container.databinding.ActivityMyPostingBindingImpl;
import com.bm.container.databinding.ActivityOrderDetailBindingImpl;
import com.bm.container.databinding.ActivityPayBindingImpl;
import com.bm.container.databinding.ActivityPaySuccessBindingImpl;
import com.bm.container.databinding.ActivityPurchaseABindingImpl;
import com.bm.container.databinding.ActivityPurchaseBBindingImpl;
import com.bm.container.databinding.ActivityPurchaseEBindingImpl;
import com.bm.container.databinding.ActivityQrBindingImpl;
import com.bm.container.databinding.ActivityRegisterBindingImpl;
import com.bm.container.databinding.ActivitySaleABindingImpl;
import com.bm.container.databinding.ActivitySaleBBindingImpl;
import com.bm.container.databinding.ActivitySaleCBindingImpl;
import com.bm.container.databinding.ActivitySalerInfoBindingImpl;
import com.bm.container.databinding.ActivitySalerOrderBindingImpl;
import com.bm.container.databinding.ActivitySendBuyInfoBindingImpl;
import com.bm.container.databinding.ActivitySendImageBindingImpl;
import com.bm.container.databinding.ActivitySendSaleInfoBindingImpl;
import com.bm.container.databinding.ActivitySendTextBindingImpl;
import com.bm.container.databinding.ActivitySettingBindingImpl;
import com.bm.container.databinding.ActivitySplashBindingImpl;
import com.bm.container.databinding.ActivityStartUpBindingImpl;
import com.bm.container.databinding.ActivityWebBindingImpl;
import com.bm.container.databinding.DeliveryOrderDetailBindingImpl;
import com.bm.container.databinding.DeliveryOrderLayoutBindingImpl;
import com.bm.container.databinding.DialogChooseCityBindingImpl;
import com.bm.container.databinding.DialogChooseStatusBindingImpl;
import com.bm.container.databinding.DialogChooseTypeBindingImpl;
import com.bm.container.databinding.DownloadBillLayoutBindingImpl;
import com.bm.container.databinding.FillTheMaillboxLayoutBindingImpl;
import com.bm.container.databinding.FragmentDiscussBindingImpl;
import com.bm.container.databinding.FragmentMainBindingImpl;
import com.bm.container.databinding.FragmentMarketBindingImpl;
import com.bm.container.databinding.FragmentPersonalBindingImpl;
import com.bm.container.databinding.ItemBillOfLadingBindingImpl;
import com.bm.container.databinding.ItemBuyHistoryBindingImpl;
import com.bm.container.databinding.ItemBuyerInfoBindingImpl;
import com.bm.container.databinding.ItemCarBindingImpl;
import com.bm.container.databinding.ItemChestBindingImpl;
import com.bm.container.databinding.ItemChooseCityBindingImpl;
import com.bm.container.databinding.ItemChooseImageBindingImpl;
import com.bm.container.databinding.ItemDiscussBannerBindingImpl;
import com.bm.container.databinding.ItemDiscussBindingImpl;
import com.bm.container.databinding.ItemFeedbackHistoryBindingImpl;
import com.bm.container.databinding.ItemFeedbackHistoryListBindingImpl;
import com.bm.container.databinding.ItemHistoryBindingImpl;
import com.bm.container.databinding.ItemImageBindingImpl;
import com.bm.container.databinding.ItemMainBindingImpl;
import com.bm.container.databinding.ItemMainBuyBindingImpl;
import com.bm.container.databinding.ItemMarketBindingImpl;
import com.bm.container.databinding.ItemMessageBindingImpl;
import com.bm.container.databinding.ItemMyOrderBindingImpl;
import com.bm.container.databinding.ItemReplyBindingImpl;
import com.bm.container.databinding.ItemSalerInfoBindingImpl;
import com.bm.container.databinding.ItemSalerOrderBindingImpl;
import com.bm.container.databinding.TopbarBindingImpl;
import com.bm.container.databinding.TopbarSearchBindingImpl;
import com.bm.container.databinding.UsageLayoutBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;

@Generated("Android Data Binding")
public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYAGREEMENT = 1;

  private static final int LAYOUT_ACTIVITYBILLOFLADING = 2;

  private static final int LAYOUT_ACTIVITYBUYERINFO = 3;

  private static final int LAYOUT_ACTIVITYCHANGECOMPANYINFO = 4;

  private static final int LAYOUT_ACTIVITYCHANGEPERSONALINFO = 5;

  private static final int LAYOUT_ACTIVITYCHANGEPWD = 6;

  private static final int LAYOUT_ACTIVITYCITY = 7;

  private static final int LAYOUT_ACTIVITYFEEDBACK = 8;

  private static final int LAYOUT_ACTIVITYFEEDBACKHISTORY = 9;

  private static final int LAYOUT_ACTIVITYFORGETPWD = 10;

  private static final int LAYOUT_ACTIVITYIDENTIFICATION = 11;

  private static final int LAYOUT_ACTIVITYINTRODUCTION = 12;

  private static final int LAYOUT_ACTIVITYLOGIN = 13;

  private static final int LAYOUT_ACTIVITYMAIN = 14;

  private static final int LAYOUT_ACTIVITYMESSAGE = 15;

  private static final int LAYOUT_ACTIVITYMYORDER = 16;

  private static final int LAYOUT_ACTIVITYMYPOSTING = 17;

  private static final int LAYOUT_ACTIVITYORDERDETAIL = 18;

  private static final int LAYOUT_ACTIVITYPAY = 19;

  private static final int LAYOUT_ACTIVITYPAYSUCCESS = 20;

  private static final int LAYOUT_ACTIVITYPURCHASEA = 21;

  private static final int LAYOUT_ACTIVITYPURCHASEB = 22;

  private static final int LAYOUT_ACTIVITYPURCHASEE = 23;

  private static final int LAYOUT_ACTIVITYQR = 24;

  private static final int LAYOUT_ACTIVITYREGISTER = 25;

  private static final int LAYOUT_ACTIVITYSALEA = 26;

  private static final int LAYOUT_ACTIVITYSALEB = 27;

  private static final int LAYOUT_ACTIVITYSALEC = 28;

  private static final int LAYOUT_ACTIVITYSALERINFO = 29;

  private static final int LAYOUT_ACTIVITYSALERORDER = 30;

  private static final int LAYOUT_ACTIVITYSENDBUYINFO = 31;

  private static final int LAYOUT_ACTIVITYSENDIMAGE = 32;

  private static final int LAYOUT_ACTIVITYSENDSALEINFO = 33;

  private static final int LAYOUT_ACTIVITYSENDTEXT = 34;

  private static final int LAYOUT_ACTIVITYSETTING = 35;

  private static final int LAYOUT_ACTIVITYSPLASH = 36;

  private static final int LAYOUT_ACTIVITYSTARTUP = 37;

  private static final int LAYOUT_ACTIVITYWEB = 38;

  private static final int LAYOUT_DELIVERYORDERDETAIL = 39;

  private static final int LAYOUT_DELIVERYORDERLAYOUT = 40;

  private static final int LAYOUT_DIALOGCHOOSECITY = 41;

  private static final int LAYOUT_DIALOGCHOOSESTATUS = 42;

  private static final int LAYOUT_DIALOGCHOOSETYPE = 43;

  private static final int LAYOUT_DOWNLOADBILLLAYOUT = 44;

  private static final int LAYOUT_FILLTHEMAILLBOXLAYOUT = 45;

  private static final int LAYOUT_FRAGMENTDISCUSS = 46;

  private static final int LAYOUT_FRAGMENTMAIN = 47;

  private static final int LAYOUT_FRAGMENTMARKET = 48;

  private static final int LAYOUT_FRAGMENTPERSONAL = 49;

  private static final int LAYOUT_ITEMBILLOFLADING = 50;

  private static final int LAYOUT_ITEMBUYHISTORY = 51;

  private static final int LAYOUT_ITEMBUYERINFO = 52;

  private static final int LAYOUT_ITEMCAR = 53;

  private static final int LAYOUT_ITEMCHEST = 54;

  private static final int LAYOUT_ITEMCHOOSECITY = 55;

  private static final int LAYOUT_ITEMCHOOSEIMAGE = 56;

  private static final int LAYOUT_ITEMDISCUSS = 57;

  private static final int LAYOUT_ITEMDISCUSSBANNER = 58;

  private static final int LAYOUT_ITEMFEEDBACKHISTORY = 59;

  private static final int LAYOUT_ITEMFEEDBACKHISTORYLIST = 60;

  private static final int LAYOUT_ITEMHISTORY = 61;

  private static final int LAYOUT_ITEMIMAGE = 62;

  private static final int LAYOUT_ITEMMAIN = 63;

  private static final int LAYOUT_ITEMMAINBUY = 64;

  private static final int LAYOUT_ITEMMARKET = 65;

  private static final int LAYOUT_ITEMMESSAGE = 66;

  private static final int LAYOUT_ITEMMYORDER = 67;

  private static final int LAYOUT_ITEMREPLY = 68;

  private static final int LAYOUT_ITEMSALERINFO = 69;

  private static final int LAYOUT_ITEMSALERORDER = 70;

  private static final int LAYOUT_TOPBAR = 71;

  private static final int LAYOUT_TOPBARSEARCH = 72;

  private static final int LAYOUT_USAGELAYOUT = 73;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(73);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_agreement, LAYOUT_ACTIVITYAGREEMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_bill_of_lading, LAYOUT_ACTIVITYBILLOFLADING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_buyer_info, LAYOUT_ACTIVITYBUYERINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_change_company_info, LAYOUT_ACTIVITYCHANGECOMPANYINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_change_personal_info, LAYOUT_ACTIVITYCHANGEPERSONALINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_change_pwd, LAYOUT_ACTIVITYCHANGEPWD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_city, LAYOUT_ACTIVITYCITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_feedback, LAYOUT_ACTIVITYFEEDBACK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_feedback_history, LAYOUT_ACTIVITYFEEDBACKHISTORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_forget_pwd, LAYOUT_ACTIVITYFORGETPWD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_identification, LAYOUT_ACTIVITYIDENTIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_introduction, LAYOUT_ACTIVITYINTRODUCTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_message, LAYOUT_ACTIVITYMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_my_order, LAYOUT_ACTIVITYMYORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_my_posting, LAYOUT_ACTIVITYMYPOSTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_order_detail, LAYOUT_ACTIVITYORDERDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_pay, LAYOUT_ACTIVITYPAY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_pay_success, LAYOUT_ACTIVITYPAYSUCCESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_purchase_a, LAYOUT_ACTIVITYPURCHASEA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_purchase_b, LAYOUT_ACTIVITYPURCHASEB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_purchase_e, LAYOUT_ACTIVITYPURCHASEE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_qr, LAYOUT_ACTIVITYQR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_register, LAYOUT_ACTIVITYREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_sale_a, LAYOUT_ACTIVITYSALEA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_sale_b, LAYOUT_ACTIVITYSALEB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_sale_c, LAYOUT_ACTIVITYSALEC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_saler_info, LAYOUT_ACTIVITYSALERINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_saler_order, LAYOUT_ACTIVITYSALERORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_send_buy_info, LAYOUT_ACTIVITYSENDBUYINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_send_image, LAYOUT_ACTIVITYSENDIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_send_sale_info, LAYOUT_ACTIVITYSENDSALEINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_send_text, LAYOUT_ACTIVITYSENDTEXT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_setting, LAYOUT_ACTIVITYSETTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_start_up, LAYOUT_ACTIVITYSTARTUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.activity_web, LAYOUT_ACTIVITYWEB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.delivery_order_detail, LAYOUT_DELIVERYORDERDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.delivery_order_layout, LAYOUT_DELIVERYORDERLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.dialog_choose_city, LAYOUT_DIALOGCHOOSECITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.dialog_choose_status, LAYOUT_DIALOGCHOOSESTATUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.dialog_choose_type, LAYOUT_DIALOGCHOOSETYPE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.download_bill_layout, LAYOUT_DOWNLOADBILLLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.fill_the_maillbox_layout, LAYOUT_FILLTHEMAILLBOXLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.fragment_discuss, LAYOUT_FRAGMENTDISCUSS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.fragment_main, LAYOUT_FRAGMENTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.fragment_market, LAYOUT_FRAGMENTMARKET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.fragment_personal, LAYOUT_FRAGMENTPERSONAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_bill_of_lading, LAYOUT_ITEMBILLOFLADING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_buy_history, LAYOUT_ITEMBUYHISTORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_buyer_info, LAYOUT_ITEMBUYERINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_car, LAYOUT_ITEMCAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_chest, LAYOUT_ITEMCHEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_choose_city, LAYOUT_ITEMCHOOSECITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_choose_image, LAYOUT_ITEMCHOOSEIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_discuss, LAYOUT_ITEMDISCUSS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_discuss_banner, LAYOUT_ITEMDISCUSSBANNER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_feedback_history, LAYOUT_ITEMFEEDBACKHISTORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_feedback_history_list, LAYOUT_ITEMFEEDBACKHISTORYLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_history, LAYOUT_ITEMHISTORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_image, LAYOUT_ITEMIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_main, LAYOUT_ITEMMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_main_buy, LAYOUT_ITEMMAINBUY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_market, LAYOUT_ITEMMARKET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_message, LAYOUT_ITEMMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_my_order, LAYOUT_ITEMMYORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_reply, LAYOUT_ITEMREPLY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_saler_info, LAYOUT_ITEMSALERINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.item_saler_order, LAYOUT_ITEMSALERORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.topbar, LAYOUT_TOPBAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.topbar_search, LAYOUT_TOPBARSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bm.container.R.layout.usage_layout, LAYOUT_USAGELAYOUT);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYAGREEMENT: {
        if ("layout/activity_agreement_0".equals(tag)) {
          return new ActivityAgreementBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_agreement is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBILLOFLADING: {
        if ("layout/activity_bill_of_lading_0".equals(tag)) {
          return new ActivityBillOfLadingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_bill_of_lading is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBUYERINFO: {
        if ("layout/activity_buyer_info_0".equals(tag)) {
          return new ActivityBuyerInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_buyer_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHANGECOMPANYINFO: {
        if ("layout/activity_change_company_info_0".equals(tag)) {
          return new ActivityChangeCompanyInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_change_company_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHANGEPERSONALINFO: {
        if ("layout/activity_change_personal_info_0".equals(tag)) {
          return new ActivityChangePersonalInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_change_personal_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHANGEPWD: {
        if ("layout/activity_change_pwd_0".equals(tag)) {
          return new ActivityChangePwdBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_change_pwd is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCITY: {
        if ("layout/activity_city_0".equals(tag)) {
          return new ActivityCityBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_city is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFEEDBACK: {
        if ("layout/activity_feedback_0".equals(tag)) {
          return new ActivityFeedbackBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_feedback is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFEEDBACKHISTORY: {
        if ("layout/activity_feedback_history_0".equals(tag)) {
          return new ActivityFeedbackHistoryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_feedback_history is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFORGETPWD: {
        if ("layout/activity_forget_pwd_0".equals(tag)) {
          return new ActivityForgetPwdBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_forget_pwd is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYIDENTIFICATION: {
        if ("layout/activity_identification_0".equals(tag)) {
          return new ActivityIdentificationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_identification is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYINTRODUCTION: {
        if ("layout/activity_introduction_0".equals(tag)) {
          return new ActivityIntroductionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_introduction is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYLOGIN: {
        if ("layout/activity_login_0".equals(tag)) {
          return new ActivityLoginBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMAIN: {
        if ("layout/activity_main_0".equals(tag)) {
          return new ActivityMainBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMESSAGE: {
        if ("layout/activity_message_0".equals(tag)) {
          return new ActivityMessageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_message is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYORDER: {
        if ("layout/activity_my_order_0".equals(tag)) {
          return new ActivityMyOrderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_order is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYPOSTING: {
        if ("layout/activity_my_posting_0".equals(tag)) {
          return new ActivityMyPostingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_posting is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYORDERDETAIL: {
        if ("layout/activity_order_detail_0".equals(tag)) {
          return new ActivityOrderDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_order_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPAY: {
        if ("layout/activity_pay_0".equals(tag)) {
          return new ActivityPayBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_pay is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPAYSUCCESS: {
        if ("layout/activity_pay_success_0".equals(tag)) {
          return new ActivityPaySuccessBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_pay_success is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPURCHASEA: {
        if ("layout/activity_purchase_a_0".equals(tag)) {
          return new ActivityPurchaseABindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_purchase_a is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPURCHASEB: {
        if ("layout/activity_purchase_b_0".equals(tag)) {
          return new ActivityPurchaseBBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_purchase_b is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPURCHASEE: {
        if ("layout/activity_purchase_e_0".equals(tag)) {
          return new ActivityPurchaseEBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_purchase_e is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYQR: {
        if ("layout/activity_qr_0".equals(tag)) {
          return new ActivityQrBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_qr is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYREGISTER: {
        if ("layout/activity_register_0".equals(tag)) {
          return new ActivityRegisterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_register is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSALEA: {
        if ("layout/activity_sale_a_0".equals(tag)) {
          return new ActivitySaleABindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_sale_a is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSALEB: {
        if ("layout/activity_sale_b_0".equals(tag)) {
          return new ActivitySaleBBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_sale_b is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSALEC: {
        if ("layout/activity_sale_c_0".equals(tag)) {
          return new ActivitySaleCBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_sale_c is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSALERINFO: {
        if ("layout/activity_saler_info_0".equals(tag)) {
          return new ActivitySalerInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_saler_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSALERORDER: {
        if ("layout/activity_saler_order_0".equals(tag)) {
          return new ActivitySalerOrderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_saler_order is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSENDBUYINFO: {
        if ("layout/activity_send_buy_info_0".equals(tag)) {
          return new ActivitySendBuyInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_send_buy_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSENDIMAGE: {
        if ("layout/activity_send_image_0".equals(tag)) {
          return new ActivitySendImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_send_image is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSENDSALEINFO: {
        if ("layout/activity_send_sale_info_0".equals(tag)) {
          return new ActivitySendSaleInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_send_sale_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSENDTEXT: {
        if ("layout/activity_send_text_0".equals(tag)) {
          return new ActivitySendTextBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_send_text is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSETTING: {
        if ("layout/activity_setting_0".equals(tag)) {
          return new ActivitySettingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_setting is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSPLASH: {
        if ("layout/activity_splash_0".equals(tag)) {
          return new ActivitySplashBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSTARTUP: {
        if ("layout/activity_start_up_0".equals(tag)) {
          return new ActivityStartUpBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_start_up is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYWEB: {
        if ("layout/activity_web_0".equals(tag)) {
          return new ActivityWebBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_web is invalid. Received: " + tag);
      }
      case  LAYOUT_DELIVERYORDERDETAIL: {
        if ("layout/delivery_order_detail_0".equals(tag)) {
          return new DeliveryOrderDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for delivery_order_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_DELIVERYORDERLAYOUT: {
        if ("layout/delivery_order_layout_0".equals(tag)) {
          return new DeliveryOrderLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for delivery_order_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGCHOOSECITY: {
        if ("layout/dialog_choose_city_0".equals(tag)) {
          return new DialogChooseCityBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_choose_city is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGCHOOSESTATUS: {
        if ("layout/dialog_choose_status_0".equals(tag)) {
          return new DialogChooseStatusBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_choose_status is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGCHOOSETYPE: {
        if ("layout/dialog_choose_type_0".equals(tag)) {
          return new DialogChooseTypeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_choose_type is invalid. Received: " + tag);
      }
      case  LAYOUT_DOWNLOADBILLLAYOUT: {
        if ("layout/download_bill_layout_0".equals(tag)) {
          return new DownloadBillLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for download_bill_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_FILLTHEMAILLBOXLAYOUT: {
        if ("layout/fill_the_maillbox_layout_0".equals(tag)) {
          return new FillTheMaillboxLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fill_the_maillbox_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTDISCUSS: {
        if ("layout/fragment_discuss_0".equals(tag)) {
          return new FragmentDiscussBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_discuss is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMAIN: {
        if ("layout/fragment_main_0".equals(tag)) {
          return new FragmentMainBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_main is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMARKET: {
        if ("layout/fragment_market_0".equals(tag)) {
          return new FragmentMarketBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_market is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPERSONAL: {
        if ("layout/fragment_personal_0".equals(tag)) {
          return new FragmentPersonalBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_personal is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMBILLOFLADING: {
        if ("layout/item_bill_of_lading_0".equals(tag)) {
          return new ItemBillOfLadingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_bill_of_lading is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ITEMBUYHISTORY: {
        if ("layout/item_buy_history_0".equals(tag)) {
          return new ItemBuyHistoryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_buy_history is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMBUYERINFO: {
        if ("layout/item_buyer_info_0".equals(tag)) {
          return new ItemBuyerInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_buyer_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCAR: {
        if ("layout/item_car_0".equals(tag)) {
          return new ItemCarBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_car is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCHEST: {
        if ("layout/item_chest_0".equals(tag)) {
          return new ItemChestBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_chest is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCHOOSECITY: {
        if ("layout/item_choose_city_0".equals(tag)) {
          return new ItemChooseCityBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_choose_city is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCHOOSEIMAGE: {
        if ("layout/item_choose_image_0".equals(tag)) {
          return new ItemChooseImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_choose_image is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMDISCUSS: {
        if ("layout/item_discuss_0".equals(tag)) {
          return new ItemDiscussBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_discuss is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMDISCUSSBANNER: {
        if ("layout/item_discuss_banner_0".equals(tag)) {
          return new ItemDiscussBannerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_discuss_banner is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMFEEDBACKHISTORY: {
        if ("layout/item_feedback_history_0".equals(tag)) {
          return new ItemFeedbackHistoryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_feedback_history is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMFEEDBACKHISTORYLIST: {
        if ("layout/item_feedback_history_list_0".equals(tag)) {
          return new ItemFeedbackHistoryListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_feedback_history_list is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMHISTORY: {
        if ("layout/item_history_0".equals(tag)) {
          return new ItemHistoryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_history is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMIMAGE: {
        if ("layout/item_image_0".equals(tag)) {
          return new ItemImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_image is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMAIN: {
        if ("layout/item_main_0".equals(tag)) {
          return new ItemMainBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_main is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMAINBUY: {
        if ("layout/item_main_buy_0".equals(tag)) {
          return new ItemMainBuyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_main_buy is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMARKET: {
        if ("layout/item_market_0".equals(tag)) {
          return new ItemMarketBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_market is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMESSAGE: {
        if ("layout/item_message_0".equals(tag)) {
          return new ItemMessageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_message is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMYORDER: {
        if ("layout/item_my_order_0".equals(tag)) {
          return new ItemMyOrderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_my_order is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMREPLY: {
        if ("layout/item_reply_0".equals(tag)) {
          return new ItemReplyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_reply is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSALERINFO: {
        if ("layout/item_saler_info_0".equals(tag)) {
          return new ItemSalerInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_saler_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSALERORDER: {
        if ("layout/item_saler_order_0".equals(tag)) {
          return new ItemSalerOrderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_saler_order is invalid. Received: " + tag);
      }
      case  LAYOUT_TOPBAR: {
        if ("layout/topbar_0".equals(tag)) {
          return new TopbarBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for topbar is invalid. Received: " + tag);
      }
      case  LAYOUT_TOPBARSEARCH: {
        if ("layout/topbar_search_0".equals(tag)) {
          return new TopbarSearchBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for topbar_search is invalid. Received: " + tag);
      }
      case  LAYOUT_USAGELAYOUT: {
        if ("layout/usage_layout_0".equals(tag)) {
          return new UsageLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for usage_layout is invalid. Received: " + tag);
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      // find which method will have it. -1 is necessary becausefirst id starts with 1;
      int methodIndex = (localizedLayoutId - 1) / 50;
      switch(methodIndex) {
        case 0: {
          return internalGetViewDataBinding0(component, view, localizedLayoutId, tag);
        }
        case 1: {
          return internalGetViewDataBinding1(component, view, localizedLayoutId, tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(73);

    static {
      sKeys.put("layout/activity_agreement_0", com.bm.container.R.layout.activity_agreement);
      sKeys.put("layout/activity_bill_of_lading_0", com.bm.container.R.layout.activity_bill_of_lading);
      sKeys.put("layout/activity_buyer_info_0", com.bm.container.R.layout.activity_buyer_info);
      sKeys.put("layout/activity_change_company_info_0", com.bm.container.R.layout.activity_change_company_info);
      sKeys.put("layout/activity_change_personal_info_0", com.bm.container.R.layout.activity_change_personal_info);
      sKeys.put("layout/activity_change_pwd_0", com.bm.container.R.layout.activity_change_pwd);
      sKeys.put("layout/activity_city_0", com.bm.container.R.layout.activity_city);
      sKeys.put("layout/activity_feedback_0", com.bm.container.R.layout.activity_feedback);
      sKeys.put("layout/activity_feedback_history_0", com.bm.container.R.layout.activity_feedback_history);
      sKeys.put("layout/activity_forget_pwd_0", com.bm.container.R.layout.activity_forget_pwd);
      sKeys.put("layout/activity_identification_0", com.bm.container.R.layout.activity_identification);
      sKeys.put("layout/activity_introduction_0", com.bm.container.R.layout.activity_introduction);
      sKeys.put("layout/activity_login_0", com.bm.container.R.layout.activity_login);
      sKeys.put("layout/activity_main_0", com.bm.container.R.layout.activity_main);
      sKeys.put("layout/activity_message_0", com.bm.container.R.layout.activity_message);
      sKeys.put("layout/activity_my_order_0", com.bm.container.R.layout.activity_my_order);
      sKeys.put("layout/activity_my_posting_0", com.bm.container.R.layout.activity_my_posting);
      sKeys.put("layout/activity_order_detail_0", com.bm.container.R.layout.activity_order_detail);
      sKeys.put("layout/activity_pay_0", com.bm.container.R.layout.activity_pay);
      sKeys.put("layout/activity_pay_success_0", com.bm.container.R.layout.activity_pay_success);
      sKeys.put("layout/activity_purchase_a_0", com.bm.container.R.layout.activity_purchase_a);
      sKeys.put("layout/activity_purchase_b_0", com.bm.container.R.layout.activity_purchase_b);
      sKeys.put("layout/activity_purchase_e_0", com.bm.container.R.layout.activity_purchase_e);
      sKeys.put("layout/activity_qr_0", com.bm.container.R.layout.activity_qr);
      sKeys.put("layout/activity_register_0", com.bm.container.R.layout.activity_register);
      sKeys.put("layout/activity_sale_a_0", com.bm.container.R.layout.activity_sale_a);
      sKeys.put("layout/activity_sale_b_0", com.bm.container.R.layout.activity_sale_b);
      sKeys.put("layout/activity_sale_c_0", com.bm.container.R.layout.activity_sale_c);
      sKeys.put("layout/activity_saler_info_0", com.bm.container.R.layout.activity_saler_info);
      sKeys.put("layout/activity_saler_order_0", com.bm.container.R.layout.activity_saler_order);
      sKeys.put("layout/activity_send_buy_info_0", com.bm.container.R.layout.activity_send_buy_info);
      sKeys.put("layout/activity_send_image_0", com.bm.container.R.layout.activity_send_image);
      sKeys.put("layout/activity_send_sale_info_0", com.bm.container.R.layout.activity_send_sale_info);
      sKeys.put("layout/activity_send_text_0", com.bm.container.R.layout.activity_send_text);
      sKeys.put("layout/activity_setting_0", com.bm.container.R.layout.activity_setting);
      sKeys.put("layout/activity_splash_0", com.bm.container.R.layout.activity_splash);
      sKeys.put("layout/activity_start_up_0", com.bm.container.R.layout.activity_start_up);
      sKeys.put("layout/activity_web_0", com.bm.container.R.layout.activity_web);
      sKeys.put("layout/delivery_order_detail_0", com.bm.container.R.layout.delivery_order_detail);
      sKeys.put("layout/delivery_order_layout_0", com.bm.container.R.layout.delivery_order_layout);
      sKeys.put("layout/dialog_choose_city_0", com.bm.container.R.layout.dialog_choose_city);
      sKeys.put("layout/dialog_choose_status_0", com.bm.container.R.layout.dialog_choose_status);
      sKeys.put("layout/dialog_choose_type_0", com.bm.container.R.layout.dialog_choose_type);
      sKeys.put("layout/download_bill_layout_0", com.bm.container.R.layout.download_bill_layout);
      sKeys.put("layout/fill_the_maillbox_layout_0", com.bm.container.R.layout.fill_the_maillbox_layout);
      sKeys.put("layout/fragment_discuss_0", com.bm.container.R.layout.fragment_discuss);
      sKeys.put("layout/fragment_main_0", com.bm.container.R.layout.fragment_main);
      sKeys.put("layout/fragment_market_0", com.bm.container.R.layout.fragment_market);
      sKeys.put("layout/fragment_personal_0", com.bm.container.R.layout.fragment_personal);
      sKeys.put("layout/item_bill_of_lading_0", com.bm.container.R.layout.item_bill_of_lading);
      sKeys.put("layout/item_buy_history_0", com.bm.container.R.layout.item_buy_history);
      sKeys.put("layout/item_buyer_info_0", com.bm.container.R.layout.item_buyer_info);
      sKeys.put("layout/item_car_0", com.bm.container.R.layout.item_car);
      sKeys.put("layout/item_chest_0", com.bm.container.R.layout.item_chest);
      sKeys.put("layout/item_choose_city_0", com.bm.container.R.layout.item_choose_city);
      sKeys.put("layout/item_choose_image_0", com.bm.container.R.layout.item_choose_image);
      sKeys.put("layout/item_discuss_0", com.bm.container.R.layout.item_discuss);
      sKeys.put("layout/item_discuss_banner_0", com.bm.container.R.layout.item_discuss_banner);
      sKeys.put("layout/item_feedback_history_0", com.bm.container.R.layout.item_feedback_history);
      sKeys.put("layout/item_feedback_history_list_0", com.bm.container.R.layout.item_feedback_history_list);
      sKeys.put("layout/item_history_0", com.bm.container.R.layout.item_history);
      sKeys.put("layout/item_image_0", com.bm.container.R.layout.item_image);
      sKeys.put("layout/item_main_0", com.bm.container.R.layout.item_main);
      sKeys.put("layout/item_main_buy_0", com.bm.container.R.layout.item_main_buy);
      sKeys.put("layout/item_market_0", com.bm.container.R.layout.item_market);
      sKeys.put("layout/item_message_0", com.bm.container.R.layout.item_message);
      sKeys.put("layout/item_my_order_0", com.bm.container.R.layout.item_my_order);
      sKeys.put("layout/item_reply_0", com.bm.container.R.layout.item_reply);
      sKeys.put("layout/item_saler_info_0", com.bm.container.R.layout.item_saler_info);
      sKeys.put("layout/item_saler_order_0", com.bm.container.R.layout.item_saler_order);
      sKeys.put("layout/topbar_0", com.bm.container.R.layout.topbar);
      sKeys.put("layout/topbar_search_0", com.bm.container.R.layout.topbar_search);
      sKeys.put("layout/usage_layout_0", com.bm.container.R.layout.usage_layout);
    }
  }
}
