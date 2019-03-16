import 'dart:convert';
import 'dart:io';
import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_button/config/service_url.dart';
import 'package:flutter_button/detail/datail_page_new.dart';
import 'package:flutter_button/detail/detail_page.dart';
import 'package:flutter_button/page/category_page.dart';
import 'package:flutter_button/page/seracher.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_button/widget/hot_below.dart';
import 'package:flutter_button/widget/my_widget.dart';
import '../service/service_method.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_swiper/flutter_swiper.dart';
import 'package:flutter_easyrefresh/easy_refresh.dart';

class ShopInfoPage extends StatefulWidget {
  @override
  _ShopInfoPageState createState() => _ShopInfoPageState();
}

class _ShopInfoPageState extends State<ShopInfoPage> {
  List<Map> shopInfo = [];

  void _getShopInfo() {
    var formData = {'lon': '121.58592987060547', 'lat': '31.298776626586914'};
    request('integralGoodsShops', formData: formData).then((val) {
      var data = json.decode(val.toString());
      List<Map> newGoodsList = (data['data'] as List).cast();
      setState(() {
        shopInfo = newGoodsList;
      });
    });
  }

  Widget hotTitle = Container(
    margin: EdgeInsets.only(top: 10.0, bottom: 10.0),
    padding: EdgeInsets.all(5.0),
    alignment: Alignment.centerLeft,
    decoration: BoxDecoration(
        color: Colors.white,
        border: Border(bottom: BorderSide(width: 0.5, color: Colors.black45))),
    child: Text('请选择门店'),
  );

  Widget _wrapList() {
    if (shopInfo.length != 0) {
      return Container(
        height: shopInfo.length * ScreenUtil().setHeight(200),
        child: ListView.builder(
          itemBuilder: (BuildContext context, int index) {
            Map map = shopInfo[index];
            return _getItemUI(context, map);
          },
          itemCount: shopInfo.length,
        ),
      );
    } else {
      return Loading();
    }
  }

  Widget _shopInfo() {
    return SingleChildScrollView(child: Column(
      children: <Widget>[
        hotTitle,
        _wrapList(),
      ],
    ),);
  }

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return Scaffold(
      appBar: AppBar(
        title: Text('门店信息'),
        elevation: 0.0,
      ),
      body: _shopInfo(),
    );
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _getShopInfo();
  }

  Widget _getItemUI(BuildContext context, Map map) {
    return Container(
      margin: EdgeInsets.all(5.0),
      child: InkWell(
        child:Column(
          children: <Widget>[
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: <Widget>[
                Container(
                  height: ScreenUtil().setHeight(80),
                  width: ScreenUtil().setWidth(80),
                  child: Image.asset(
                    'images/shop.png',
                    fit: BoxFit.fill,
                  ),
                ),
                Container(
                  width: ScreenUtil().setWidth(300),
                  margin: EdgeInsets.all(5.0),
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.start,
                    children: <Widget>[
                      Container(
                        alignment: Alignment.centerLeft,
                        child: Text(map['shopName'],style: TextStyle(color: Colors.black,fontWeight: FontWeight.bold),),
                      ),
                      Container(
                        alignment: Alignment.centerLeft,
                        child: Text(map['shopAddress'],
                          maxLines:1,style: TextStyle(color: Colors.black45,fontSize: ScreenUtil().setSp(20)),),
                      ),
                    ],
                  ),
                ),
                Container(
                  child: Row(
                    children: <Widget>[
                      Container(
                        height: ScreenUtil().setHeight(50),
                        width: ScreenUtil().setWidth(50),
                        child: Image.asset('images/dizhi.png',fit: BoxFit.fill,),
                      ),
                      Container(
                        margin: EdgeInsets.all(5.0),
                        child: Text('700KM'),
                      ),
                    ],
                  ),
                ),

                Container(
                    width: ScreenUtil().setWidth(30),
                    height: ScreenUtil().setHeight(30),
                    margin: EdgeInsets.only(right: 10.0),
                    alignment: Alignment.center,
                    child: Image.asset(
                      'images/backgrey.png',
                      fit: BoxFit.fill,
                    )),
              ],
            ),
            Divider(color: Colors.black45,),
          ],
        )
      ),
    );
  }
}
