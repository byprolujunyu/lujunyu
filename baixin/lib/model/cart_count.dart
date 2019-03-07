import 'package:scoped_model/scoped_model.dart';
class CartCount{
  int count;

  CartCount(this.count);


}

class CartCountModel extends Model {
  CartCount items;

  CartCountModel(this.items);


  addCount() {
    items.count = items.count + 1;
    notifyListeners();
  }

  downCount() {
    items.count = items.count - 1;
    notifyListeners();
  }
}