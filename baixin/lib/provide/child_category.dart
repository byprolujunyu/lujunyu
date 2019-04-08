import 'package:flutter/material.dart';
import '../model/category.dart';


class ChildCategory with ChangeNotifier {
  List<BxMallSubDto> childCategory = [];
  int childIndex = 0; // 子类高亮索引
  String categoryId = '4'; // 大类ID
  String subId = '';     // 小类ID
  int page = 1; // 列表页数
  String nomoreText = ''; // 显示没有数据时的文字

  // 大类切换索引
  getChild( List<BxMallSubDto> list, String id ){
    BxMallSubDto all =BxMallSubDto();

    childIndex = 0;
    categoryId = id;
    page = 1;
    nomoreText = '';

    all.mallSubId = '';
    all.mallCategoryId = '00';
    all.comments = 'null';
    all.mallSubName = "全部";

    childCategory = [all];
    childCategory.addAll( list );
    notifyListeners();
  }

  // 改变子类索引
  changeChildenIndex( int index, String id ){

    childIndex = index;
    subId = id;
    page = 1;
    nomoreText = '';

    notifyListeners();
  }

  // 增加page的方法
  addPage(){

    page++;

  }

  // 改变nomoretext的方法
  changeNomore( String text ){
    nomoreText =text;
    notifyListeners();
  }

  
}

