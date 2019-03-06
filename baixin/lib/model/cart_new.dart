

import 'package:scoped_model/scoped_model.dart';

class CartItemModelNew {
  String productName;
  int buyLimit;
  int count;
  String imageUrl;
  bool isSelected;
  bool isDeleted;
  double  price;
  int id;
  CartItemModelNew(
      { this.id,
        this.productName,
        this.count,
        this.buyLimit,
        this.imageUrl,
        this.price,
        this.isDeleted,
        this.isSelected});
}

class CartListModelNew extends Model {
  List<CartItemModelNew> items;

  CartListModelNew({this.items});



  get itemsCount {
    return this.items.length;
  }

  bool get isAllchecked {
    return items.every((i) => i.isSelected);
  }

  switchAllCheck() {
    if (this.isAllchecked) {
      items.forEach((i) => i.isSelected = false);
    } else {
      items.forEach((i) => i.isSelected = true);
    }
    notifyListeners();
  }

  double get sumTotal {
    double total = 0;
    items.forEach((item) {
      if (item.isDeleted == false && item.isSelected == true) {
        total = item.price * item.count + total;
      }
    });
    return total;
  }

  addCount(int index) {
    items[index].count = items[index].count + 1;
    notifyListeners();
  }

  downCount(int index) {
    items[index].count = items[index].count - 1;
    notifyListeners();
  }

  removeItem(index) {
    items.removeAt(index);
    notifyListeners();
  }

  switchSelect(i) {
    items[i].isSelected = !items[i].isSelected;
    notifyListeners();
  }

  get totalCount {
    int count = 0;
    items.forEach((item) {
      if (item.isDeleted == false && item.isSelected == true) {
        count = item.count + count;
      }
    });
    return count;
  }
}
