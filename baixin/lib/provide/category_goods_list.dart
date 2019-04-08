import 'package:flutter/material.dart';
import '../model/categoryGoods.dart';


class CategoryGoodsProvide with ChangeNotifier {

  List<CategoryListData> goodslist = [];

  // 点击大类时，更新商品列表
  getGoodsList( List<CategoryListData> list ){
    goodslist = list;
    notifyListeners();
  }

  // 获取更多
  getMoreList( List<CategoryListData> list ){
    goodslist.addAll(list);
    notifyListeners();
  }
  
}












