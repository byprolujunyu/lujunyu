import 'package:flutter/material.dart';
import 'package:flutter_button/model/cart_new.dart';
import 'package:flutter_button/widget/my_widget.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class MutliPayPage extends StatefulWidget {
  final CartListModelNew model;

  MutliPayPage({Key key, this.model}) : super(key: key);

  @override
  _MutliPayPageState createState() => _MutliPayPageState();
}

class _MutliPayPageState extends State<MutliPayPage> {
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
              MyDivider(
                height: ScreenUtil().setHeight(20),
                color: Color.fromARGB(255, 240, 238, 238),
              ),
//              ProductListInfo(
//                datas: _getList(),
//              ),
              MyDivider(
                height: ScreenUtil().setHeight(20),
                color: Color.fromARGB(255, 240, 238, 238),
              ),
              PayList(price: widget.model.sumTotal),
            ],
          ),
        ),
      ),
    );
  }

  List<CartItemModelNew> _getList() {
    CartListModelNew model = widget.model;
    List<CartItemModelNew> ms = [];
    for (var m in model.items) {
      ms.add(m);
    }
    return ms;
  }
}

class ProductListInfo extends StatelessWidget {
  final List<CartItemModelNew> datas;

  ProductListInfo({Key key, this.datas}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: ListView(
        children: datas.map((map) {
          return getItemUi(context, map);
        }).toList(),
      ),
    );
  }

  Widget getItemUi(BuildContext context, CartItemModelNew map) {
    return Container(
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
              style: TextStyle(fontSize: ScreenUtil().setSp(25)),
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
                      fontSize: ScreenUtil().setSp(20),
                    ),
                  ),
                ),
                Container(
                  child: Text(
                    'X ${map.count}',
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
              trailing: Text('￥ ${price.toString().split(".")[1].substring(0,1)}0'),
            ),
          ),
          Divider(),
          Container(
            child: ListTile(
              title: Text("运费"),
              trailing: Text('￥ ${price.toString().split(".")[1].substring(0,1)}0'),
            ),
          ),
          Divider(),
          Container(
            child: ListTile(
              title: Text("实付金额"),
              trailing: Text('￥ ${price.toString().split(".")[1].substring(0,1)}0'),
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
