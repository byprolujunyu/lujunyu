import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_fanxinren/model/lookup_model.dart';
import 'package:flutter_fanxinren/service/service_method.dart';



class LookUpProvide with ChangeNotifier {

 LookUpModel lookUpModel;

 int page = 1;

 addPage()
 {
   page ++;
 }

 getResquest({uid = '689',uidios = '689'}) async {
    var formData = {'curPage':'$page',
    'uid':'$uid',
    'uidios':'$uidios'};

   await request('listAppFollowTask',formData: formData).then((val){
      var data =  json.decode(val.toString());
      print(data);
      lookUpModel = LookUpModel.fromJson(data);
      notifyListeners();
    });
 }
}

