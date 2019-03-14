import 'package:flutter/material.dart';
import 'package:flutter_button/db/db_helper.dart';
import 'package:flutter_button/db/db_helper_address.dart';
import 'package:flutter_button/model/address.dart';
import 'package:flutter_button/model/cart_model.dart';
import 'package:flutter_button/model/cart_new.dart';
import 'package:flutter_button/pay/pay_page.dart';
import 'package:flutter_button/widget/my_widget.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class MutliPayPage extends StatefulWidget {
  final CartListModelNew model;

  MutliPayPage({Key key, this.model}) : super(key: key);

  @override
  _MutliPayPageState createState() => _MutliPayPageState();
}

class _MutliPayPageState extends State<MutliPayPage> {
  List<CartItemModelNew> datas = [];

  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    _update();
    _getAddress();
  }

  Address add;

  bool init = false;

  var db = DataBaseHelper_address();

  Widget getAddressW() {
    return add != null
        ? Column(
            children: <Widget>[
              MyDivider(
                height: ScreenUtil().setHeight(20),
                color: Color.fromARGB(255, 240, 238, 238),
              ),
              AddressInfo(
                address: add,
              ),
              MyDivider(
                height: ScreenUtil().setHeight(20),
                color: Color.fromARGB(255, 240, 238, 238),
              ),
            ],
          )
        : Container();
  }

  Future _getAddress() async {
    var result = await db.getDefAdd();
    print(result);
    Map map = result;
    var address = Address.fromMap(map);
    setState(() {
      add = address;
      init = true;
    });
  }

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return Scaffold(
      appBar: AppBar(
        title: Text(
          '订单确认',
        ),
        elevation: 0.0,
      ),
      body: Container(
        margin: EdgeInsets.all(0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            getAddressW(),
            Expanded(
              child: PList(
                ms: widget.model.items,
              ),
              ),
            CountWidget(
              model: widget.model,
            ),
          ],
        ),
      ),
    );
  }

  var db1 = new DataBaseHelper();

  Future _update() async {
    var items = widget.model.items;
    await items.map((item) {
      db1.updateUser(get(item));
    });
  }

  User get(CartItemModelNew item) {
    return User(
        name: item.productName,
        image: item.imageUrl,
        count: item.count,
        price: item.price);
  }
}

class ProductListInfo extends StatelessWidget {
  final List<CartItemModelNew> datas;

  ProductListInfo({Key key, this.datas}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: ListView.builder(
          itemCount: datas.length,
          itemBuilder: (BuildContext context, int index) {
            CartItemModelNew m = datas[index];
            return Container(
              child: Image.network(m.imageUrl),
            );
          }),
    );
  }
}

class PayList extends StatelessWidget {
  final double price;

  PayList({Key key, this.price}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        children: <Widget>[
          Container(
            child: ListTile(
              title: Text("商品金额"),
              trailing:
                  Text('￥ ${price.toString().split(".")[1].substring(0, 1)}0'),
            ),
          ),
          Divider(),
          Container(
            child: ListTile(
              title: Text("运费"),
              trailing:
                  Text('￥ ${price.toString().split(".")[1].substring(0, 1)}0'),
            ),
          ),
          Divider(),
          Container(
            child: ListTile(
              title: Text("实付金额"),
              trailing:
                  Text('￥ ${price.toString().split(".")[1].substring(0, 1)}0'),
            ),
          ),
          Divider(),
          Container(
            margin: EdgeInsets.only(top: ScreenUtil().setHeight(140)),
            child: Center(
              child: InkWell(
                onTap: () {},
                child: Container(
                  width: ScreenUtil().setHeight(180),
                  height: ScreenUtil().setHeight(60),
                  color: Colors.red,
                  child: Center(
                    child: Text(
                      '去付款',
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}

class PList extends StatelessWidget {
  final List<CartItemModelNew> ms;

  PList({Key key, @required this.ms}) : super(key: key);

  Widget getItemUi(BuildContext context, CartItemModelNew map) {
    var c;
    try {
      c = Container(
        margin: EdgeInsets.only(top: 20),
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.start,
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: <Widget>[
            Container(
              margin: EdgeInsets.only(left: 10.0),
              width: ScreenUtil().setWidth(90),
              height: ScreenUtil().setHeight(90),
              child: Image.network(map.imageUrl),
              decoration: BoxDecoration(
                border: Border(
                  top: BorderSide(width: 1, color: Colors.black12),
                  right: BorderSide(width: 1, color: Colors.black12),
                  left: BorderSide(width: 1, color: Colors.black12),
                  bottom: BorderSide(width: 1, color: Colors.black12),
                ),
              ),
            ),
            Container(
              width: ScreenUtil().setWidth(300),
              margin: EdgeInsets.only(left: 10.0),
              child: Text(
                map.productName,
                style: TextStyle(fontSize: ScreenUtil().setSp(30)),
              ),
            ),
            Container(
              margin: EdgeInsets.only(right: 10.0),
              child: Column(
                children: <Widget>[
                  Container(
                    child: Text(
                      '￥ ${map.price}0',
                      style: TextStyle(
                        fontSize: ScreenUtil().setSp(25),
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Container(
                    child: Text(
                      'X ${map.count}',
                      style: TextStyle(
                        fontSize: ScreenUtil().setSp(25),
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            Divider(),
          ],
        ),
      );
    } catch (e) {
      print(e);
    }
    return c;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: ListView(
        children: ms.map((map) {
          return getItemUi(context, map);
        }).toList(),
      ),
    );
  }
}

class CountWidget extends StatelessWidget {
  final CartListModelNew model;

  CountWidget({Key key, this.model}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      height: ScreenUtil().setHeight(100),
      color: Colors.blue,
      width: ScreenUtil.screenWidth,
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: <Widget>[
          Container(
            margin: EdgeInsets.only(left: 10),
            child: Text(
              '共${model.totalCount}件商品',
              style: TextStyle(
                  color: Colors.white, fontSize: ScreenUtil().setSp(30)),
            ),
          ),
          Container(
            margin: EdgeInsets.only(right: 10),
            child: Text(
              '小计  : ￥${model.sumTotal}',
              style: TextStyle(
                  color: Colors.white, fontSize: ScreenUtil().setSp(30)),
            ),
          ),
        ],
      ),
    );
  }
}
