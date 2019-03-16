class ShopDetail {
  String code;
  String message;
  ShopDetail_Data data;

  ShopDetail({this.code, this.message, this.data});

  ShopDetail.fromJson(Map<String, dynamic> json) {
    code = json['code'];
    message = json['message'];
    data = json['data'] != null ? new ShopDetail_Data.fromJson(json['data']) : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['code'] = this.code;
    data['message'] = this.message;
    if (this.data != null) {
      data['data'] = this.data.toJson();
    }
    return data;
  }
}

class ShopDetail_Data {
  List<ShopDetail_GoodsList> goodsList;
  ShopDetail_ActivityInfo activityInfo;

  ShopDetail_Data({this.goodsList, this.activityInfo});

  ShopDetail_Data.fromJson(Map<String, dynamic> json) {
    if (json['goodsList'] != null) {
      goodsList = new List<ShopDetail_GoodsList>();
      json['goodsList'].forEach((v) {
        goodsList.add(new ShopDetail_GoodsList.fromJson(v));
      });
    }
    activityInfo = json['activityInfo'] != null
        ? new ShopDetail_ActivityInfo.fromJson(json['activityInfo'])
        : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.goodsList != null) {
      data['goodsList'] = this.goodsList.map((v) => v.toJson()).toList();
    }
    if (this.activityInfo != null) {
      data['activityInfo'] = this.activityInfo.toJson();
    }
    return data;
  }
}

class ShopDetail_GoodsList {
  double sELLMONEY;
  String pICTURECOMPERSSPATH;
  int nEEDINTEGRAL;
  String gOODID;
  String nAME;

  ShopDetail_GoodsList(
      {this.sELLMONEY,
        this.pICTURECOMPERSSPATH,
        this.nEEDINTEGRAL,
        this.gOODID,
        this.nAME});

  ShopDetail_GoodsList.fromJson(Map<String, dynamic> json) {
    sELLMONEY = json['SELL_MONEY'];
    pICTURECOMPERSSPATH = json['PICTURE_COMPERSS_PATH'];
    nEEDINTEGRAL = json['NEED_INTEGRAL'];
    gOODID = json['GOOD_ID'];
    nAME = json['NAME'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['SELL_MONEY'] = this.sELLMONEY;
    data['PICTURE_COMPERSS_PATH'] = this.pICTURECOMPERSSPATH;
    data['NEED_INTEGRAL'] = this.nEEDINTEGRAL;
    data['GOOD_ID'] = this.gOODID;
    data['NAME'] = this.nAME;
    return data;
  }
}

class ShopDetail_ActivityInfo {
  String aCTIVITYNAME;
  int bEGINTIME;
  int lIMITAMOUNT;
  String eNDTIME;
  String iMAGE;
  String bEGINTIME2;
  int pARTICIPATETIMES;
  int eNDTIME2;
  int iSSEND;
  int sTATE;
  String aCTIVITYID;

  ShopDetail_ActivityInfo(
      {this.aCTIVITYNAME,
        this.bEGINTIME,
        this.lIMITAMOUNT,
        this.eNDTIME,
        this.iMAGE,
        this.bEGINTIME2,
        this.pARTICIPATETIMES,
        this.eNDTIME2,
        this.iSSEND,
        this.sTATE,
        this.aCTIVITYID});

  ShopDetail_ActivityInfo.fromJson(Map<String, dynamic> json) {
    aCTIVITYNAME = json['ACTIVITY_NAME'];
    bEGINTIME = json['BEGINTIME'];
    lIMITAMOUNT = json['LIMIT_AMOUNT'];
    eNDTIME = json['END_TIME'];
    iMAGE = json['IMAGE'];
    bEGINTIME2 = json['BEGIN_TIME'];
    pARTICIPATETIMES = json['PARTICIPATE_TIMES'];
    eNDTIME2 = json['ENDTIME'];
    iSSEND = json['IS_SEND'];
    sTATE = json['STATE'];
    aCTIVITYID = json['ACTIVITY_ID'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['ACTIVITY_NAME'] = this.aCTIVITYNAME;
    data['BEGINTIME'] = this.bEGINTIME;
    data['LIMIT_AMOUNT'] = this.lIMITAMOUNT;
    data['END_TIME'] = this.eNDTIME2;
    data['IMAGE'] = this.iMAGE;
    data['BEGIN_TIME'] = this.bEGINTIME;
    data['PARTICIPATE_TIMES'] = this.pARTICIPATETIMES;
    data['ENDTIME'] = this.eNDTIME2;
    data['IS_SEND'] = this.iSSEND;
    data['STATE'] = this.sTATE;
    data['ACTIVITY_ID'] = this.aCTIVITYID;
    return data;
  }
}