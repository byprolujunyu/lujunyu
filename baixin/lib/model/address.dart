class Address {
  String name;
  int id;
  String phone;
  String address;
  String num;
  int isSelected;

  Address({this.name, this.phone, this.id,this.address, this.num, this.isSelected});

  Map<String, dynamic> toMap() {
    var map = new Map<String, dynamic>();
    map.putIfAbsent("_name", () => name);
    map.putIfAbsent("_phone", () => phone);
    map.putIfAbsent("_id", () => id);
    map.putIfAbsent("_address", () => address);
    map.putIfAbsent("_num", () => num);
    map.putIfAbsent("_isSelected", () => isSelected);
    return map;
  }

  Address.fromMap(Map<String, dynamic> map) {
    this.name = map['_name'];
    this.id = map['_id'];
    this.phone = map['_phone'];
    this.address = map['_address'];
    this.num = map['_num'];
    this.isSelected = map['_isSelected'];
  }
}
