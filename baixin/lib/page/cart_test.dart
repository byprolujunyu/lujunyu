import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_button/constants/index.dart';
import 'package:flutter_button/db/db_helper.dart';
import 'package:flutter_button/model/cart_new.dart';
import 'package:flutter_button/model/cart_new.dart';
import 'package:flutter_button/data/cart.dart';
import 'package:flutter_button/model/count.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_button/pay/multi_pay.dart';
import 'package:flutter_button/utils/screen_util.dart';
import 'package:scoped_model/scoped_model.dart';
import '../service/service_method.dart';
class CartTest extends StatefulWidget {
  @override
  _CartTestState createState() => _CartTestState();
}

class _CartTestState extends State<CartTest> {
  List data = [];

  static const query = const MethodChannel("cart/query");
  static const delete = const MethodChannel("cart/delete");
  static const queryResult = const MethodChannel("cart/queryResult");

  CartListModelNew dmoldel;

  @override
  void initState() {
    super.initState();
    saveSp(key: KString.totalsumKey, str: dmoldel.sumTotal.toString());
    _query();
//    query.setMethodCallHandler((MethodCall call) {
//      var map = call.arguments;
//      setState(() {
//        data = map;
//        dmoldel = fromJson(data);
//      });
//    });
  }

  CartListModelNew fromJson(List list) {
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

  var db = new DataBaseHelper();

  Future _query() async {
//    await query.invokeMethod("query");

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
              width: ScreenUtil().setWidth(100), margin: EdgeInsets.all(10.0),
              height: ScreenUtil().setHeight(100),
              child: Image.network(
                'http://116.62.168.251:8090/empty_cart.png',
              ),
            ),
            Container( margin: EdgeInsets.all(10.0),
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
                  Navigator.of(context).pushAndRemoveUntil(
                      MaterialPageRoute(builder: (context) => IndexPage()),
                          (route) => route == null);
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
      child: Text('test',
          style: TextStyle(color: Color(0xFF313131), fontSize: 18)),
    );
  }
}

class CartListWidget extends StatelessWidget {
  CartListModelNew model;

  final BuildContext context;

  final Function refresh;

  CartListWidget({Key key, this.context, this.refresh}) : super(key: key);

  static const query = const MethodChannel("cart/query");
  static const delete = const MethodChannel("cart/delete");
  static const queryResult = const MethodChannel("cart/queryResult");

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

  var db = new DataBaseHelper();

  Future _delete(id) async {
    //await delete.invokeMethod("delete", id);
    await db.deleteUser(id);
    refresh();
    Navigator.pop(context);
  }

  @override
  Widget build(BuildContext context) {
    return ScopedModelDescendant<CartListModelNew>(
      builder: (context, child, model) {
        this.model = model;
        return Expanded(
          child: ListView.builder(
            padding: EdgeInsets.all(0),
            itemCount: model.itemsCount,
            itemExtent: 93,
            itemBuilder: (BuildContext context, int index) {
              CartItemModelNew item = model.items[index];
              return Dismissible(
                resizeDuration: Duration(milliseconds: 100),
                key: Key(item.productName),
                onDismissed: (direction) {
                  model.removeItem(index);
                  show(item.id);
                  Scaffold.of(context).showSnackBar(SnackBar(
                    content: Text("${item.productName}   成功移除"),
                    backgroundColor: KColorConstant.themeColor,
                    duration: Duration(seconds: 1),
                  ));
                },
                background: Container(color: KColorConstant.themeColor),
                child: CartItemWidget(model.items[index],
                    addCount: _addCount,
                    downCount: _downCount,
                    index: index,
                    switchChaned: _switchChanged),
              );
            },
          ),
        );
      },
    );
  }

  _switchChanged(int i) {
    model.switchSelect(i);
  }

  _addCount(int i) {
    model.addCount(i);
  }

  _downCount(int i) {
    model.downCount(i);
  }
}

class CartItemWidget extends StatelessWidget {
  final CartItemModelNew data;
  final int index;
  final Function(int i) switchChaned;
  final Function(int i) addCount;
  final Function(int i) downCount;

  CartItemWidget(this.data,
      {this.switchChaned, this.index, this.addCount, this.downCount});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: <Widget>[
          InkWell(
              onTap: () => switchChaned(index),
              child: Icon(
                data.isSelected
                    ? Icons.check_circle_outline
                    : Icons.radio_button_unchecked,
                color: KColorConstant.themeColor,
              )),
          Container(
            margin: EdgeInsets.only(
                left: ScreenUtil().setWidth(10),
                right: ScreenUtil().setWidth(8)),
            width: ScreenUtil().setWidth(100),
            height: ScreenUtil().setWidth(100),
            child: Image.network(data.imageUrl, fit: BoxFit.fill),
            decoration: BoxDecoration(
              border: Border(
                top: BorderSide(width: 1, color: Colors.black12),
                right: BorderSide(width: 1, color: Colors.black12),
                left: BorderSide(width: 1, color: Colors.black12),
                bottom: BorderSide(width: 1, color: Colors.black12),
              ),
            ),
          ),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: <Widget>[
                Container(
                  margin: EdgeInsets.only(top: 15.0),
                  child: Text(data.productName),
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    Text(
                      '￥${data.price}',
                      style: TextStyle(
                          fontSize: 14, color: KColorConstant.priceColor),
                    ),
                    Container(
                      margin: EdgeInsets.only(right: 20.0),
                      child: Row(
                        mainAxisSize: MainAxisSize.min,
                        children: <Widget>[
                          GestureDetector(
                            onTap: () => data.count > 1 && downCount(index),
                            child: Container(
                              width: ScreenUtil().setWidth(50),
                              height: ScreenUtil().setWidth(50),
                              decoration:
                                  BoxDecoration(border: _getRemoveBtBorder()),
                              child: Icon(Icons.remove,
                                  color: _getRemovebuttonColor()),
                            ),
                          ),
                          Container(
                              alignment: Alignment.center,
                              width: ScreenUtil().setWidth(50),
                              height: ScreenUtil().setWidth(50),
                              decoration: BoxDecoration(
                                  border: Border.all(
                                      color:
                                          KColorConstant.cartItemCountTxtColor,
                                      width: 1)),
                              child: Text(
                                data.count.toString(),
                                style: TextStyle(
                                    fontSize: 13,
                                    fontWeight: FontWeight.bold,
                                    color:
                                        KColorConstant.cartItemCountTxtColor),
                              )),
                          GestureDetector(
                            onTap: () =>
                                data.count < data.buyLimit && addCount(index),
                            child: Container(
                              alignment: Alignment.center,
                              width: ScreenUtil().setWidth(50),
                              height: ScreenUtil().setWidth(50),
                              decoration:
                                  BoxDecoration(border: _getAddBtBorder()),
                              child:
                                  Icon(Icons.add, color: _getAddbuttonColor()),
                            ),
                          ),
                        ],
                      ),
                    ),
                  ],
                )
              ],
            ),
          )
        ],
      ),
    );
  }

  Color _getRemovebuttonColor() {
    return data.count > 1
        ? KColorConstant.cartItemChangenumBtColor
        : KColorConstant.cartDisableColor;
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
    return data.count >= data.buyLimit
        ? KColorConstant.cartDisableColor
        : KColorConstant.cartItemCountTxtColor;
  }
}

class CartBottomWidget extends StatelessWidget {
  final CartListModelNew model;

  CartBottomWidget(this.model);

  @override
  Widget build(BuildContext context) {
    return ScopedModelDescendant<CartListModelNew>(
        builder: (context, child, model) {
      // this.model = model;
      return Container(
        height: ScreenUtil().setWidth(100),
        decoration: BoxDecoration(
            color: KColorConstant.cartBottomBgColor,
            border: Border(
                top: BorderSide(
                    width: 1, color: KColorConstant.divideLineColor))),
        padding: EdgeInsets.only(left: ScreenUtil().setWidth(60)),
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            Expanded(
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: <Widget>[
                  InkWell(
                      onTap: () => model.switchAllCheck(),
                      child: Row(
                        children: <Widget>[
                          Icon(
                            model.isAllchecked
                                ? Icons.check_circle_outline
                                : Icons.radio_button_unchecked,
                            color: KColorConstant.themeColor,
                          ),
                          Text(
                            KString.allSelectedTxt,
                            style: TextStyle(letterSpacing: 2),
                          )
                        ],
                      )),
                  Expanded(
                    child: _TotalWidget(
                      totalPrice: model.sumTotal,
                    ),
                  )
                ],
              ),
            ),
            InkWell(
              child: Container(
                alignment: Alignment.center,
                margin: EdgeInsets.only(left: 10),
                color: KColorConstant.goPayBtBgColor,
                width: ScreenUtil().setWidth(300),
                height: ScreenUtil().setWidth(100),
                child: Text(
                  '${KString.goPayTxt}(${model.totalCount})',
                  style: TextStyle(color: KColorConstant.goPayBtTxtColor),
                ),
              ),
              onTap: () {
                Navigator.of(context)
                    .push(MaterialPageRoute(builder: (BuildContext ctx) {
                  return MutliPayPage(model: model);
                }));
              },
            ),
          ],
        ),
      );
    });
  }

  CartListModelNew _getSelectedModel(CartListModelNew model) {
    List<CartItemModelNew> ms = [];
    model.items.map((item) {
      if (item.isSelected) {
        ms.add(item);
      }
    });
    return CartListModelNew(items: ms);
  }
}

class _TotalWidget extends StatefulWidget {
  final double totalPrice;

  _TotalWidget({Key key, this.totalPrice}) : super(key: key);

  @override
  State<StatefulWidget> createState() => _TotalWidgetState();
}

class _TotalWidgetState extends State<_TotalWidget>
    with SingleTickerProviderStateMixin {
  AnimationController _controller;
  Animation animation;

  @override
  void initState() {
    _controller = new AnimationController(
        vsync: this, duration: Duration(milliseconds: 1000));
    animation = Tween(begin: 0, end: widget.totalPrice).animate(_controller);
    _controller.forward();
    _controller.addListener(() => setState(() {}));
    super.initState();
  }

  @override
  void didUpdateWidget(_TotalWidget oldWidget) {
    animation = Tween(begin: oldWidget.totalPrice, end: widget.totalPrice)
        .animate(_controller);
    _controller.forward(from: 0);

    super.didUpdateWidget(oldWidget);
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.spaceAround,
      crossAxisAlignment: CrossAxisAlignment.end,
      children: <Widget>[
        RichText(
          text: TextSpan(
              text: KString.totalSumTxt + ":  ",
              style: DefaultTextStyle.of(context).style,
              children: [
                TextSpan(
                    text: '￥${animation.value.toStringAsFixed(2)}',
                    style: KfontConstant.cartBottomTotalPriceStyle)
              ]),
        )
      ],
    );
  }
}
