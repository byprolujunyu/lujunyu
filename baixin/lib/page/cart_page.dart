import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
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

final Dio dio = new Dio();

class CartPage extends StatefulWidget {
  @override
  _CartPageState createState() => _CartPageState();
}

class _CartPageState extends State<CartPage> {
  static const query = const MethodChannel("cart/query");
  static const delete = const MethodChannel("cart/delete");
  static const queryResult = const MethodChannel("cart/queryResult");

  List data = [];
  CartListModelNew dmoldel;

  @override
  void initState() {
    super.initState();
    _query();
    query.setMethodCallHandler((MethodCall call) {
      var map = call.arguments;
      setState(() {
        data = map;
        dmoldel = fromJson(data);
      });
    });
  }

  CartListModelNew fromJson(List list) {
    List<CartItemModelNew> items = [];
   for(var json in list){
      CartItemModelNew item = CartItemModelNew(
        price: json['_price'],
        count: 1,
        imageUrl: json['_imageuri'],
        productName: json['_naem'],
        isDeleted: false,
        isSelected: true,
        buyLimit: 99,
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
        title: Text(
          '购物车',
        ),
        elevation: 0.0,
        actions: <Widget>[
          IconButton(
            icon: Icon(Icons.add),
            onPressed: () {

            },
          ),
        ],
      ),
      body: body(),
    );
  }

  Widget body() {
    return data.length > 0
        ? ListView.builder(
            itemCount: data.length,
            itemBuilder: (context, index) {
              return _getUIWidget(context, data[index]);
            },
          )
        : EmptyWidget();
  }

  Future _query() async {
    await query.invokeMethod("query");
  }

  Widget _getUIWidget(BuildContext context, Map map) {
    return Container(
      margin: EdgeInsets.all(15.0),
      child: SingleChildScrollView(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            InkWell(
              onTap: () => {},
              child: Icon(
                Icons.check_circle_outline,
                color: KColorConstant.themeColor,
              ),
            ),
            Container(
              margin: EdgeInsets.only(left: 10.0),
              width: ScreenUtil().setWidth(100),
              height: ScreenUtil().setHeight(100),
              child: Image.network(map['_imageuri']),
              decoration: BoxDecoration(
                border: Border(
                  top: BorderSide(width: 1, color: Colors.black12),
                  right: BorderSide(width: 1, color: Colors.black12),
                  left: BorderSide(width: 1, color: Colors.black12),
                  bottom: BorderSide(width: 1, color: Colors.black12),
                ),
              ),
            ),
            Column(
              children: <Widget>[
                Container(
                  width: ScreenUtil().setWidth(300),
                  margin: EdgeInsets.only(left: 10.0),
                  child: Text(
                    map['_naem'],
                    style: TextStyle(fontSize: ScreenUtil().setSp(25)),
                  ),
                ),
                Center(
                  child: Container(
                    child: Text(
                      '¥ ${map['_price']}0',
                      style: TextStyle(
                        fontSize: ScreenUtil().setSp(30),
                        color: Colors.red,
                      ),
                    ),
                  ),
                ),
              ],
            ),
            GestureDetector(
              onTap: () => {},
              child: Container(
                width: ScreenUtil().setWidth(50),
                height: ScreenUtil().setHeight(50),
                decoration: BoxDecoration(border: _getRemoveBtBorder()),
                child: Icon(Icons.remove, color: _getRemovebuttonColor()),
              ),
            ),
            Container(
                alignment: Alignment.center,
                width: ScreenUtil().setWidth(50),
                height: ScreenUtil().setHeight(50),
                decoration: BoxDecoration(
                    border: Border.all(
                        color: KColorConstant.cartItemCountTxtColor, width: 1)),
                child: Text(
                  '1',
                  style: TextStyle(
                      fontSize: 13,
                      fontWeight: FontWeight.bold,
                      color: KColorConstant.cartItemCountTxtColor),
                )),
            GestureDetector(
              onTap: () => {},
              child: Container(
                alignment: Alignment.center,
                width: ScreenUtil().setWidth(50),
                height: ScreenUtil().setHeight(50),
                decoration: BoxDecoration(border: _getAddBtBorder()),
                child: Icon(Icons.add, color: _getAddbuttonColor()),
              ),
            ),
            Container(
              margin: EdgeInsets.only(left: ScreenUtil().setWidth(10)),
              alignment: Alignment.center,
              width: ScreenUtil().setWidth(50),
              height: ScreenUtil().setHeight(50),
              child: InkWell(
                onTap: () {
                  show(map['_id']);
                },
                child: Image.asset(
                  "images/trash-gray.png",
                ),
              ),
            ),
          ],
        ),
        scrollDirection: Axis.horizontal,
      ),
    );
  }

  show(id) {
    showDialog<Null>(
      context: context,
      barrierDismissible: false,
      builder: (BuildContext context) {
        return new AlertDialog(
          title: new Text("是否删除该商品"),
          actions: <Widget>[
            new FlatButton(
              child: new Text('确定'),
              onPressed: () {
                _delete(id);
              },
            ),
            new FlatButton(
              child: new Text('取消'),
              onPressed: () {
                Navigator.pop(context);
              },
            ),
          ],
        );
      },
    ).then((val) {});
  }

  Future _delete(id) async {
    await delete.invokeMethod("delete", id);
    _query();
    Navigator.pop(context);
  }

  Color _getRemovebuttonColor() {
    return KColorConstant.cartItemChangenumBtColor;
  }

  Border _getRemoveBtBorder() {
    return Border(
        bottom: BorderSide(width: 1, color: _getRemovebuttonColor()),
        top: BorderSide(width: 1, color: _getRemovebuttonColor()),
        left: BorderSide(width: 1, color: _getRemovebuttonColor()));
  }

  Border _getAddBtBorder() {
    return Border(
        bottom: BorderSide(width: 1, color: _getAddbuttonColor()),
        top: BorderSide(width: 1, color: _getAddbuttonColor()),
        right: BorderSide(width: 1, color: _getAddbuttonColor()));
  }

  _getAddbuttonColor() {
    return KColorConstant.cartItemCountTxtColor;
  }
}

class CartListWidget extends StatelessWidget {
  final List data;

  CartListWidget({Key key, this.data}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container();
  }
}

class EmptyWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            Container(
              width: ScreenUtil().setWidth(300),
              height: ScreenUtil().setHeight(300),
              child: Image.network(
                'http://116.62.168.251:8090/empty_cart.png',
              ),
            ),
            Container(
              child: Text(
                '购物车还是空的,快去挑选商品吧',
              ),
            ),
            Container(
              margin: EdgeInsets.all(10.0),
              alignment: Alignment.center,
              width: ScreenUtil().setWidth(200),
              height: ScreenUtil().setHeight(50),
              color: Colors.red,
              child: InkWell(
                child: Text(
                  '随便逛逛',
                  style: TextStyle(
                    color: Colors.white,
                  ),
                ),
                onTap: () {
                  Navigator.of(context)
                      .push(MaterialPageRoute(builder: (BuildContext ctx) {
                    return IndexPage(
                      index: 0,
                    );
                  }));
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class TopBarWidget extends StatelessWidget {
  final String title;

  TopBarWidget(this.title);

  @override
  Widget build(BuildContext context) {
    final double statusBarHeight = MediaQuery.of(context).padding.top;
    return Container(
      padding: EdgeInsets.only(top: statusBarHeight),
      alignment: Alignment.center,
      height: statusBarHeight + Klength.topBarHeight,
      decoration: BoxDecoration(
          border:
              Border(bottom: BorderSide(color: Color(0xFFe1e1e1), width: 1))),
      child:
          Text(title, style: TextStyle(color: Color(0xFF313131), fontSize: 18)),
    );
  }
}
