import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_button/address/address_manage.dart';
import 'package:flutter_button/page/cart_test.dart';
import 'package:flutter_button/constants/color.dart';
import 'package:flutter_button/page/cart_page.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_button/pay/pay_page.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter/services.dart';
import '../service/service_method.dart';
import 'package:flutter_swiper/flutter_swiper.dart';

class DetailPageNew extends StatelessWidget {
  final String goodId;
  final String goodName;

  DetailPageNew({Key key, this.goodId, this.goodName}) : super(key: key);

  static const MethodChannel jump = MethodChannel("detail/jump");

  Future _jumpFun(json) async {
    await jump.invokeMethod('jump', json);
  }

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return Scaffold(
      appBar: AppBar(
        title: Text('$goodName'),
        elevation: 0.0,
      ),
      body: FutureBuilder(
        future: shopGoodsDetailImg(goodId),
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            var data = json.decode(snapshot.data.toString());
            print(data);
            Map shopInfo = data['data']['goodInfo'];
            return SingleChildScrollView(
              child: Container(
                child: Column(
                  children: <Widget>[
                     DetailPageInfo(
                      map: shopInfo,
                    ),

                  ],
                ),
              ),
            );
          } else {
            return Center(
              child: Loading(),
            );
          }
        },
      ),
    );
  }
}

class BottomPayWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: ScreenUtil().setHeight(300),
      width: ScreenUtil.screenWidth,
      color: Colors.black12,
    );
  }
}

class DetailPageInfo extends StatelessWidget {
  final Map map;

  DetailPageInfo({this.map});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          Container(
              child: Center(
            child: Image.network(
              map['comPic'],
            ),
          )),
          Container(
            margin: EdgeInsets.all(20),
            child: Text(
              map['goodsName'],
              style: TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: ScreenUtil().setSp(30)),
            ),
          ),
          Container(
            margin: EdgeInsets.only(top: 1, left: 20),
            child: Text(
              "编号 ${map['goodsSerialNumber']}",
              style: TextStyle(
                  color: Colors.black26, fontSize: ScreenUtil().setSp(25)),
            ),
          ),
          Container(
            margin: EdgeInsets.only(top: 8, left: 20),
            child: Row(
              children: <Widget>[
                Container(
                  child: Text(
                    '￥${map['presentPrice']}0',
                    style: TextStyle(
                        color: Colors.red,
                        fontWeight: FontWeight.bold,
                        fontSize: ScreenUtil().setSp(30)),
                  ),
                ),
                Container(
                  margin: EdgeInsets.only(left: 10),
                  child: Text('市场价:'),
                ),
                Container(
                  child: Text(
                    '￥${map['oriPrice']}0',
                    style: TextStyle(
                        color: Colors.black45,
                        decoration: TextDecoration.lineThrough,
                        fontSize: ScreenUtil().setSp(30)),
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

class BottomTabWidget extends StatefulWidget {
  final Map map;

  BottomTabWidget({this.map});

  @override
  _BottomTabWidgetState createState() => _BottomTabWidgetState();
}

class _BottomTabWidgetState extends State<BottomTabWidget> {
  final PageController _controller = PageController(
    initialPage: 0,
  );
  int currentIndex = 0;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: PageView(
        children: <Widget>[
          DetailTabWidget(),
          CommTabWidget(),
        ],
        controller: _controller,
      ),
    );
  }
}

class DetailTabWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 300,
      child: Center(
        child: Text('详情'),
      ),
    );
  }
}

class CommTabWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 300,
      child: Center(
        child: Text('评论'),
      ),
    );
  }
}
