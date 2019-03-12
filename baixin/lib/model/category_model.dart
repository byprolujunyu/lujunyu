import 'package:flutter_button/model/category_big.dart';

class CategoryBigListModel {
  List<CategoryBigModel> data;
  CategoryBigListModel(this.data);
  factory CategoryBigListModel.formJson(List json){
    return CategoryBigListModel(
        json.map((i)=>CategoryBigModel.fromJson((i))).toList()
    );
  }
}