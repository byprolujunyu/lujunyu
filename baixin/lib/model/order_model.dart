class OrderModel {
  String code;
  String message;
  List<OrderItem> data;

  OrderModel({this.code, this.message, this.data});

  OrderModel.fromJson(Map<String, dynamic> json) {
    code = json['code'];
    message = json['message'];
    if (json['data'] != null) {
      data = new List<OrderItem>();
      json['data'].forEach((v) {
        data.add(new OrderItem.fromJson(v));
      });
    }
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['code'] = this.code;
    data['message'] = this.message;
    if (this.data != null) {
      data['data'] = this.data.map((v) => v.toJson()).toList();
    }
    return data;
  }
}

class OrderItem {
  int sETTLEMENTWAY;
  String sHOPID;
  String sHOPNAME;
  List<SubOrder> subOrder;
  int sTATE;
  Null sETTLEMENTTIME;
  double totalPayment;
  String oRDERID;
  double totalFee;
  int dELIVERYFEES;
  Null sendPhone;
  int couponsFee;
  int oRDERTIME;
  int jIFENNUM;

  OrderItem(
      {this.sETTLEMENTWAY,
        this.sHOPID,
        this.sHOPNAME,
        this.subOrder,
        this.sTATE,
        this.sETTLEMENTTIME,
        this.totalPayment,
        this.oRDERID,
        this.totalFee,
        this.dELIVERYFEES,
        this.sendPhone,
        this.couponsFee,
        this.oRDERTIME,
        this.jIFENNUM});

  OrderItem.fromJson(Map<String, dynamic> json) {
    sETTLEMENTWAY = json['SETTLEMENT_WAY'];
    sHOPID = json['SHOP_ID'];
    sHOPNAME = json['SHOP_NAME'];
    if (json['subOrder'] != null) {
      subOrder = new List<SubOrder>();
      json['subOrder'].forEach((v) {
        subOrder.add(new SubOrder.fromJson(v));
      });
    }
    sTATE = json['STATE'];
    sETTLEMENTTIME = json['SETTLEMENT_TIME'];
    totalPayment = json['totalPayment'];
    oRDERID = json['ORDER_ID'];
    totalFee = json['totalFee'];
    dELIVERYFEES = json['DELIVERY_FEES'];
    sendPhone = json['sendPhone'];
    couponsFee = json['couponsFee'];
    oRDERTIME = json['ORDER_TIME'];
    jIFENNUM = json['JIFEN_NUM'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['SETTLEMENT_WAY'] = this.sETTLEMENTWAY;
    data['SHOP_ID'] = this.sHOPID;
    data['SHOP_NAME'] = this.sHOPNAME;
    if (this.subOrder != null) {
      data['subOrder'] = this.subOrder.map((v) => v.toJson()).toList();
    }
    data['STATE'] = this.sTATE;
    data['SETTLEMENT_TIME'] = this.sETTLEMENTTIME;
    data['totalPayment'] = this.totalPayment;
    data['ORDER_ID'] = this.oRDERID;
    data['totalFee'] = this.totalFee;
    data['DELIVERY_FEES'] = this.dELIVERYFEES;
    data['sendPhone'] = this.sendPhone;
    data['couponsFee'] = this.couponsFee;
    data['ORDER_TIME'] = this.oRDERTIME;
    data['JIFEN_NUM'] = this.jIFENNUM;
    return data;
  }
}

class SubOrder {
  double pAYMENT;
  int subOrderId;
  int bUYNUM;
  String gOODSID;
  String goodsNumber;
  String iMAGE1;
  String nAME;

  SubOrder(
      {this.pAYMENT,
        this.subOrderId,
        this.bUYNUM,
        this.gOODSID,
        this.goodsNumber,
        this.iMAGE1,
        this.nAME});

  SubOrder.fromJson(Map<String, dynamic> json) {
    pAYMENT = json['PAYMENT'];
    subOrderId = json['subOrderId'];
    bUYNUM = json['BUY_NUM'];
    gOODSID = json['GOODS_ID'];
    goodsNumber = json['goodsNumber'];
    iMAGE1 = json['IMAGE1'];
    nAME = json['NAME'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['PAYMENT'] = this.pAYMENT;
    data['subOrderId'] = this.subOrderId;
    data['BUY_NUM'] = this.bUYNUM;
    data['GOODS_ID'] = this.gOODSID;
    data['goodsNumber'] = this.goodsNumber;
    data['IMAGE1'] = this.iMAGE1;
    data['NAME'] = this.nAME;
    return data;
  }
}

