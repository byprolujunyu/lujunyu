class FujiListModel {
  String code;
  String message;
  List<FujiList_Data> data;

  FujiListModel({this.code, this.message, this.data});

  FujiListModel.fromJson(Map<String, dynamic> json) {
    code = json['code'];
    message = json['message'];
    if (json['data'] != null) {
      data = new List<FujiList_Data>();
      json['data'].forEach((v) {
        data.add(new FujiList_Data.fromJson(v));
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

class FujiList_Data {
  int onlineOffline;
  int voucherPrePrice;
  int voucherPrice;
  String voucherDesc;
  String voucherCat;
  int voucherState;
  String voucherTLimitStores;
  String voucherCode;
  String voucherEndDate;
  String voucherStartDate;

  FujiList_Data(
      {this.onlineOffline,
        this.voucherPrePrice,
        this.voucherPrice,
        this.voucherDesc,
        this.voucherCat,
        this.voucherState,
        this.voucherTLimitStores,
        this.voucherCode,
        this.voucherEndDate,
        this.voucherStartDate});

  FujiList_Data.fromJson(Map<String, dynamic> json) {
    onlineOffline = json['online_offline'];
    voucherPrePrice = json['voucher_pre_price'];
    voucherPrice = json['voucher_price'];
    voucherDesc = json['voucher_desc'];
    voucherCat = json['voucher_cat'];
    voucherState = json['voucher_state'];
    voucherTLimitStores = json['voucher_t_limit_stores'];
    voucherCode = json['voucher_code'];
    voucherEndDate = json['voucher_end_date'];
    voucherStartDate = json['voucher_start_date'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['online_offline'] = this.onlineOffline;
    data['voucher_pre_price'] = this.voucherPrePrice;
    data['voucher_price'] = this.voucherPrice;
    data['voucher_desc'] = this.voucherDesc;
    data['voucher_cat'] = this.voucherCat;
    data['voucher_state'] = this.voucherState;
    data['voucher_t_limit_stores'] = this.voucherTLimitStores;
    data['voucher_code'] = this.voucherCode;
    data['voucher_end_date'] = this.voucherEndDate;
    data['voucher_start_date'] = this.voucherStartDate;
    return data;
  }
}