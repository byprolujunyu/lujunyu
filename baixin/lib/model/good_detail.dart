class GoodDetail{
  String name;
  String image;
  String goodsSerialNumber;
  String goodId;
  double price;
  double shopPrice;

  GoodDetail({this.goodId,this.name, this.goodsSerialNumber,this.image, this.price, this.shopPrice});

  GoodDetail.fromMap(Map<String,dynamic> map){
    this.goodId = map["goodsId"];
    this.name = map['goodsName'];
    this.image = map["comPic"];
    this.goodsSerialNumber = map["goodsSerialNumber"];
    this.price = map["presentPrice"];
    this.shopPrice = map["oriPrice"];
  }

}