import 'package:flutter/material.dart';
import 'package:flutter_button/address/address_ios_page.dart';
import 'package:flutter_button/db/db_helper.dart';
import 'package:flutter_button/db/db_helper_address.dart';
import 'package:flutter_button/model/address.dart';
import 'package:flutter_button/model/cart_model.dart';
import 'package:flutter_button/model/cart_new.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_button/pay/pay_page.dart';
import 'package:flutter_button/widget/address_line.dart';
import 'package:flutter_button/widget/my_widget.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import '../service/service_method.dart';
import 'package:flutter_button/constants/index.dart';

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

  Widget line() {
    return MyDivider(
      height: ScreenUtil().setHeight(15),
      color: Color.fromARGB(255, 238, 237, 236),
    );
  }

  Widget zhifu() {
    return Container(
      height: ScreenUtil().setHeight(140),
      padding: EdgeInsets.all(9),
      alignment: Alignment.center,
      color: Colors.white,
      child: Row(
        mainAxisAlignment: MainAxisAlignment.start,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: <Widget>[
          Container(
            height: 30,
            width: 30,
            child: Image.asset(
              'images/icon_weixinzhifu.png',
              fit: BoxFit.fill,
            ),
          ),
          Container(
            margin: EdgeInsets.only(left: 5),
            child: Text(
              '微信支付',
              style: TextStyle(
                fontWeight: FontWeight.bold,
              ),
            ),
          ),
        ],
      ),
    );
  }

  Widget tip() {
    return SingleChildScrollView(
      child: Container(
        color: Colors.white,
        child: Wrap(
          children: <Widget>[
            Text(
              '温馨提示',
              style: TextStyle(
                  color: Color.fromARGB(255, 179, 49, 114),
                  fontWeight: FontWeight.bold),
            ),
            Container(
              width:
                  MediaQuery.of(context).size.width - ScreenUtil().setWidth(10),
              child: Text(
                ' 普通商品，订单满10.00元免配送费;最快15分钟送达;晚上8:30以后下的订单，第二天早晨8点开始统-配送，给您带来的不便敬请谅解，祝您购物愉快:)预购商品会根据活动规则及时为你配送',
                style:
                    TextStyle(color: Colors.black, fontWeight: FontWeight.bold),
                maxLines: 4,
              ),
            ),
          ],
        ),
      ),
      scrollDirection: Axis.horizontal,
    );
  }

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return Scaffold(
      backgroundColor: Color.fromARGB(255, 248, 247, 246),
      appBar: AppBar(
        title: Text(
          '订单确认',
        ),
        elevation: 0.0,
      ),
      body: WillPopScope(
          child: Container(
            margin: EdgeInsets.all(0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                Expanded(
                  child: list(),
                ),
                buttom(),
              ],
            ),
          ),
          onWillPop: () {
//            Navigator.of(context).pushAndRemoveUntil(
//                MaterialPageRoute(builder: (context) => IndexPage()),
//                (route) => route == null);
          Navigator.pop(context);
          }),
    );
  }

  Widget buttom() {
    return Container(
      height: ScreenUtil().setHeight(130),
      color: Color.fromARGB(255, 240, 238, 240),
      child: Container(
        padding: EdgeInsets.all(5),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            Container(
              margin: EdgeInsets.only(left: 8),
              child: Row(
                children: <Widget>[
                  Container(
                    child: Text(
                      '合计:',
                      style: TextStyle(
                          fontWeight: FontWeight.bold,
                          fontSize: ScreenUtil().setSp(30)),
                    ),
                  ),
                  Container(
                    margin: EdgeInsets.only(left: 5),
                    child: Text(
                      '￥ ${widget.model.sumTotal.floor()}.00',
                      style: TextStyle(
                          fontWeight: FontWeight.bold, color: Colors.red),
                    ),
                  ),
                ],
              ),
            ),
            Container(
              margin: EdgeInsets.only(right: 8),
              height: ScreenUtil().setHeight(80),
              width: ScreenUtil().setWidth(180),
              alignment: Alignment.center,
              child: Text(
                '去付款',
                style: TextStyle(color: Colors.white),
              ),
              decoration: BoxDecoration(
                  color: Colors.red, borderRadius: BorderRadius.circular(5)),
            ),
          ],
        ),
      ),
    );
  }

  Widget list() {
    return Container(
      height: ScreenUtil.screenHeight,
      child: ListView(
        children: <Widget>[
          getAddressW(),
          line(),
          PList(
            ms: widget.model.items,
          ),
          line(),
          PayList(price: widget.model.sumTotal.floor().toDouble(),),
          line(),
          tip(),
          line(),
          zhifu(),
        ],
      ),
    );
  }  Widget getAddressW() {
    return add != null
        ? Container(
      color: Colors.white,
      child: Column(
        children: <Widget>[
          AddressLine(
            height: ScreenUtil().setHeight(5),
          ),
          AddressInfo(
            address: add,
          ),
          AddressLine(
            height: ScreenUtil().setHeight(5),
          ),
        ],
      ),
    )
        : Container(
        color: Colors.white,
        child: Column(
          children: <Widget>[
            AddressLine(
              height: ScreenUtil().setHeight(5),
            ),
            InkWell(
              child: Container(
                height: 20,
                margin: EdgeInsets.all(5.0),
                child: Text('需要默认地址>去添加!'),
              ),
              onTap: () {
                Navigator.of(context)
                    .push(MaterialPageRoute(builder: (BuildContext ctx) {
                  return NewAddressPage();
                }));
              },
            ),
            AddressLine(
              height: ScreenUtil().setHeight(5),
            ),
          ],
        ));
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


class PList extends StatelessWidget {
  final List<CartItemModelNew> ms;

  PList({Key key, @required this.ms}) : super(key: key);

  Widget getItemUi(BuildContext context, CartItemModelNew map) {
    var c;
    try {
      c = Container(
        margin: EdgeInsets.all(8),
        //margin: EdgeInsets.only(top: 20),
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
            Divider(
              height: 5,
              color: Colors.black26,
            ),
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
      color: Colors.white,
      child: Wrap(
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
              '小计  : ￥${model.sumTotal.floor()}',
              style: TextStyle(
                  color: Colors.white, fontSize: ScreenUtil().setSp(30)),
            ),
          ),
        ],
      ),
    );
  }

  String get() {
    getSp(key: KString.totalsumKey).then((value) {
      return value;
    });
  }
}
