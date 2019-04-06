import 'package:flutter/material.dart';
import 'package:flutter_button/address/address_ios_page.dart';
import 'package:flutter_button/model/address.dart';
import 'package:flutter_button/model/good_detail.dart';
import 'package:flutter_button/model/shop_detail.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_button/widget/address_line.dart';
import 'package:flutter_button/widget/my_widget.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_button/address/add_address.dart';
import 'package:flutter_button/db/db_helper_address.dart';

class PayPage extends StatefulWidget {
  final GoodDetail map1;
  final Map map;

  PayPage({Key key, this.map1, this.map}) : super(key: key);

  @override
  _PayPageState createState() => _PayPageState();
}

class _PayPageState extends State<PayPage> {
  var db = DataBaseHelper_address();

  @override
  void initState() {
    super.initState();
    getAddress();
  }

  Future getAddress() async {
    var result = await db.getDefAdd();
    print(result);
    Map map = result;
    var address = Address.fromMap(map);
    setState(() {
      add = address;
      init = true;
    });
  }

  Address add;

  bool init = false;

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
      backgroundColor: Color.fromARGB(255, 248, 247, 246),
      body: WillPopScope(
        child: Container(
          height: ScreenUtil.screenHeight,
          child: Column(
            children: <Widget>[
              Expanded(
                child: list(),
              ),
              buttom(),
            ],
          ),
        ),
        onWillPop: () {
//          Navigator.of(context).pushAndRemoveUntil(
//              MaterialPageRoute(builder: (context) => IndexPage()),
//              (route) => route == null);
          Navigator.pop(context);
        },
      ),
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
                    child: Text(
                      '￥ ${widget.map1.price}',
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

  //images/icon_weixinzhifu.png

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
              width: MediaQuery.of(context).size.width-ScreenUtil().setWidth(10),
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
            height: ScreenUtil().setHeight(80),
            width: ScreenUtil().setWidth(80),
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

  Widget list() {
    return Container(
      height: ScreenUtil.screenHeight,
      child: ListView(
        children: <Widget>[
          getAddressW(),
          MyDivider(
            height: ScreenUtil().setHeight(5),
            color: Color.fromARGB(255, 240, 238, 238),
          ),
          ProductInfo(
            pic: widget.map1.image,
            name: widget.map1.name,
            price: widget.map1.price,
            count: 1,
          ),
          MyDivider(
            height: ScreenUtil().setHeight(5),
            color: Color.fromARGB(255, 240, 238, 238),
          ),
          PayList(price: widget.map1.price),
          MyDivider(
            height: ScreenUtil().setHeight(5),
            color: Color.fromARGB(255, 240, 238, 238),
          ),
          tip(),
          MyDivider(
            height: ScreenUtil().setHeight(5),
            color: Colors.grey,
          ),
          zhifu(),
          MyDivider(
            height: ScreenUtil().setHeight(5),
            color: Colors.grey,
          ),
        ],
      ),
    );
  }

  Widget getAddressW() {
    return add != null
        ? Column(
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
          )
        : Column(
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
          );
  }
}

class AddressInfo extends StatelessWidget {
  final Address address;

  AddressInfo({Key key, @required this.address}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return addressInfo();
  }

  Widget addressInfo() {
    return Container(
      width: ScreenUtil.screenWidth,
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: <Widget>[
          Row(
            children: <Widget>[
              Container(
                margin: EdgeInsets.all(10.0),
                child: Icon(Icons.add_location),
              ),
              Container(
                margin: EdgeInsets.all(10.0),
                child: Column(
                  children: <Widget>[
                    Row(
                      children: <Widget>[
                        Container(
                          child: Text(address.name),
                        ),
                        Container(
                          margin: EdgeInsets.only(left: 10.0),
                          child: Text(address.phone),
                        ),
                      ],
                    ),
                    SingleChildScrollView(
                      child: Container(
                        margin: EdgeInsets.all(10.0),
                        child: Row(
                          children: <Widget>[
                            Container(
                              child: Text('${address.address}'),
                            ),
                            Container(
                              child: Text('${address.num}'),
                            ),
                          ],
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
          Container(
            margin: EdgeInsets.all(10.0),
            child: Icon(Icons.arrow_forward_ios),
          ),
        ],
      ),
    );
  }
}

class ProductInfo extends StatelessWidget {
  final String pic;
  final String name;
  final double price;
  final int count;

  ProductInfo({Key key, this.pic, this.name, this.price, this.count})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    double width = ScreenUtil.screenWidth;
    return Container(
      margin: EdgeInsets.only(top: 3.0),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: <Widget>[
          Container(
            margin: EdgeInsets.only(left: 10.0),
            width: ScreenUtil().setWidth(150),
            height: ScreenUtil().setHeight(150),
            child: Image.network(pic),
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
              name,
              style: TextStyle(fontSize: ScreenUtil().setSp(25)),
            ),
          ),
          Container(
            margin: EdgeInsets.only(right: 10.0),
            child: Column(
              children: <Widget>[
                Container(
                  child: Text(
                    '￥ ${price}0',
                    style: TextStyle(
                      fontSize: ScreenUtil().setSp(20),
                    ),
                  ),
                ),
                Container(
                  child: Text(
                    'X ${count}',
                    style: TextStyle(
                      fontSize: ScreenUtil().setSp(20),
                    ),
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
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
              trailing: Text('￥ ${price}0'),
            ),
          ),
          Divider(),
          Container(
            child: ListTile(
              title: Text("运费"),
              trailing: Text('￥ ${price}0'),
            ),
          ),
          Divider(),
          Container(
            child: ListTile(
              title: Text("实付金额"),
              trailing: Text('￥ ${price * 2}0'),
            ),
          ),
        ],
      ),
    );
  }
}
