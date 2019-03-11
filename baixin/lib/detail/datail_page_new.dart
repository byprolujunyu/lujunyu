import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_button/address/address_manage.dart';
import 'package:flutter_button/detail/detail_page.dart';
import 'package:flutter_button/page/cart_test.dart';
import 'package:flutter_button/constants/color.dart';
import 'package:flutter_button/page/cart_page.dart';
import 'package:flutter_button/page/command_bottom.dart';
import 'package:flutter_button/page/detail_bottom.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_button/pay/pay_page.dart';
import 'package:flutter_button/tabbar.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_button/widget/my_widget.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter/services.dart';
import '../service/service_method.dart';
import 'package:flutter_swiper/flutter_swiper.dart';

class DetailPageNew extends StatefulWidget {
  final String goodsId;

  DetailPageNew({Key key, @required this.goodsId}) : super(key: key);

  @override
  _DetailPageNewState createState() => _DetailPageNewState();
}

class _DetailPageNewState extends State<DetailPageNew> {
  Map shopInfo;

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
        future: shopGoodsDetailImg(widget.goodsId),
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            var data = json.decode(snapshot.data.toString());

            shopInfo = data['data']['goodInfo'];

            return Scaffold(
              appBar: AppBar(
                title: Text(shopInfo['goodsName']),
                elevation: 0.0,
              ),
              body: SingleChildScrollView(
                child: Column(
                  children: <Widget>[
                    DetailPageInfo(map: shopInfo),
                    getCashWidget(),
                  ],
                ),
              ),
            );
          } else {
            return Center(
              child: Loading(),
            );
          }
        });
  }

  Widget getCashWidget() {
    return Container(
      margin: EdgeInsets.only(top: ScreenUtil().setHeight(100)),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          InkWell(
            onTap: () {
              showBottomWidget(
                context,
                SelectCountWidget(map: shopInfo),
              );
            },
            child: Container(
              width: ScreenUtil().setHeight(180),
              height: ScreenUtil().setHeight(60),
              color: Colors.green,
              child: Center(
                child: Text(
                  '加入购物车',
                  style: TextStyle(color: Colors.white),
                ),
              ),
            ),
          ),
          InkWell(
            onTap: () {
              Navigator.of(context)
                  .push(MaterialPageRoute(builder: (BuildContext ctx) {
                return PayPage(
                  map: shopInfo,
                );
              }));
            },
            child: Container(
              width: ScreenUtil().setHeight(180),
              height: ScreenUtil().setHeight(60),
              color: Colors.red,
              child: Center(
                child: Text(
                  '立即购买',
                  style: TextStyle(color: Colors.white),
                ),
              ),
            ),
          )
        ],
      ),
    );
  }
}

class DetailPageInfo extends StatelessWidget {
  final Map map;

  DetailPageInfo({this.map});

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Container(
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
      ),
    );
  }
}
