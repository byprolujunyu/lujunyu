import 'package:flutter/material.dart';
import 'package:flutter_button/model/address.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_button/widget/my_widget.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_button/address/add_address.dart';
import 'package:flutter_button/db/db_helper_address.dart';

class PayPage extends StatefulWidget {
  final Map map;

  PayPage({Key key, this.map}) : super(key: key);

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
        body: Container(
          child: SingleChildScrollView(
            child: Column(
              children: <Widget>[
                getAddressW(),
                MyDivider(
                  height: ScreenUtil().setHeight(20),
                  color: Color.fromARGB(255, 240, 238, 238),
                ),
                ProductInfo(
                  pic: widget.map['image'],
                  name: widget.map['goodsName'],
                  price: widget.map['presentPrice'],
                  count: 1,
                ),
                MyDivider(
                  height: ScreenUtil().setHeight(20),
                  color: Color.fromARGB(255, 240, 238, 238),
                ),
                PayList(price: widget.map['presentPrice']),
              ],
            ),
          ),
        ));
  }

  Widget getAddressW() {
    return add != null
        ? AddressInfo(
      address: add,
    )
        : Container();
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
                        child:Row(
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
            margin:EdgeInsets.all(10.0),
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
            width: ScreenUtil().setWidth(90),
            height: ScreenUtil().setHeight(90),
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
