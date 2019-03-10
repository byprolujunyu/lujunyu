import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_button/db/db_helper.dart';
import 'package:flutter_button/db/todo.dart';
import 'package:flutter_button/model/cart_model.dart';
import 'package:flutter_button/page/cart_test.dart';
import 'package:flutter_button/constants/index.dart';
import 'package:flutter_button/db/db_util.dart';
import 'package:flutter_button/model/cart_new.dart';
import 'package:flutter_button/model/cart_new.dart';
import '../service/service_method.dart';
import 'package:flutter_button/data/cart.dart';
import 'package:flutter_button/model/count.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_button/utils/screen_util.dart';
import 'package:scoped_model/scoped_model.dart';
import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_button/constants/index.dart';
import 'package:flutter_button/db/db_util.dart';
import 'package:flutter_button/model/cart_new.dart';
import 'package:flutter_button/model/cart_new.dart';
import 'package:flutter_button/data/cart.dart';
import 'package:flutter_button/model/count.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_button/pay/multi_pay.dart';
import 'package:flutter_button/utils/screen_util.dart';
import 'package:scoped_model/scoped_model.dart';


class CartIosPage extends StatefulWidget {
  @override
  _CartIosPageState createState() => _CartIosPageState();
}

class _CartIosPageState extends State<CartIosPage> {
  CartListModelNew dmoldel;

  List data;

  var db = new DataBaseHelper();

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _query();
  }

  Future _query() async {
    try {
      var list = await db.getAllUsers();
      print(list);
      var model = fromJson(list);
      setState(() {
        dmoldel = model;
      });
    }catch (e) {
      return print('ERROR:======>${e}');
    }
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();


  }


  CartListModelNew fromJson(List<Map> list) {
    List<CartItemModelNew> items = [];
    for (Map json in list) {
      CartItemModelNew item = CartItemModelNew(
        price: json['_price'],
        count: json['_count'],
        imageUrl: json['_image'],
        productName: json['_name'],
        isDeleted: false,
        isSelected: true,
        buyLimit: 99,
        id: json['_id'],
      );
      items.add(item);
    }

    return CartListModelNew(items: items);
  }

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return Scaffold(
      appBar: AppBar(
        title: Text('购物车'),
        elevation: 0.0,
      ),
      body: dmoldel == null
          ? Container()
          : dmoldel.itemsCount == 0
          ? EmptyWidget()
          : ScopedModel<CartListModelNew>(
        model: dmoldel,
        child: Column(
          children: <Widget>[
            CartListWidget(
              refresh: _query,
              context: context,
            ),
            CartBottomWidget(dmoldel),
          ],
        ),
      ),
    );
  }

}


