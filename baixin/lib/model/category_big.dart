class CategoryBigModel {
  String mallCategoryId;    //类别编号
  String mallCategoryName;  //类别名称
  List<dynamic> bxMallSubDto;        //小类列表
  String image;             //类别图片
  Null comments;          //列表描述
  //构造函数
  CategoryBigModel({
    this.mallCategoryId,
    this.mallCategoryName,
    this.comments,
    this.image,
    this.bxMallSubDto
  });
  //工厂模式-用这种模式可以省略New关键字
  factory CategoryBigModel.fromJson(dynamic json){
    return CategoryBigModel(
        mallCategoryId:json['mallCategoryId'],
        mallCategoryName:json['mallCategoryName'],
        comments:json['comments'],
        image:json['image'],
        bxMallSubDto:json['bxMallSubDto']
    );
  }
}