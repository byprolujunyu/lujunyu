class User {
  String name;
  String image;
  int id;
  int count;
  double price;


  User({this.name, this.image, this.count, this.price});


  Map<String, dynamic> toMap() {
    var map = new Map<String, dynamic>();
    map.putIfAbsent("_name", () => name);
    map.putIfAbsent("_image", () => image);
    map.putIfAbsent("_id", () => id);
    map.putIfAbsent("_count", () => count);
    map.putIfAbsent("_price", () => price);
    return map;
  }


  User.fromMap(Map<String,dynamic> map){
    this.name = map["_name"];
    this.image = map["_image"];
    this.id = map["_id"];
    this.price = map["_price"];
    this.count = map["_count"];
  }

}