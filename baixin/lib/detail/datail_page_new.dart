import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_button/address/address_manage.dart';
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

  final Map map;

  DetailPageNew({Key key, this.map}) : super(key: key);
  @override
  _DetailPageNewState createState() => _DetailPageNewState();
}

class _DetailPageNewState extends State<DetailPageNew> {

  List<Widget> _pagelist = [];

  @override
  Widget build(BuildContext context) {
    Map map = widget.map;
    return FutureBuilder(
        future: shopGoodsDetailImg(map['goodsId']),
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            var data = json.decode(snapshot.data.toString());

            Map shopInfo = data['data']['goodInfo'];

            setState(() {
              _pagelist = [
                DetailTabWidget(
                  uri: shopInfo['goodsDetail'],
                ),
                CommTabWidget(),
              ];
            });

            return DefaultTabController(
              length: 2,
              initialIndex: 0,
              child: Scaffold(
                appBar: AppBar(
                  title: Text(map['goodsName']),
                  elevation: 0.0,
                ),
                body: Column(
                  children: <Widget>[
                    DetailPageInfo(map: shopInfo),
                    KTabBarWidget(),
                    Expanded(
                      child: TabBarView(
                        children: _pagelist,
                      ),
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
        });
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
