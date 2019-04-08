import 'package:flutter/material.dart';
import 'dart:convert';
import '../service/service_method.dart';
import '../model/fuji_list_model.dart';

class FujiListProvide with ChangeNotifier {
  FujiListModel fujiListModel;

  String picUrl;

  getRequest(String userid, int page) async {
    var formData = {
      'userId': '$userid',
      'scene': '',
      'page': '$page',
    };
    await request('fujiCouponsGetByself', formData: formData).then((val) {
      var responseData = json.decode(val.toString());
      print(responseData);
      fujiListModel = FujiListModel.fromJson(responseData);
      notifyListeners();
    });
  }

  getRequestPic() async {
    await request('fujiCouponsPic').then((val){
      var responseData = json.decode(val.toString());
      print(responseData);
      picUrl = responseData['data']['PICTURE_ADDRESS'];
      notifyListeners();
    });
  }
}
