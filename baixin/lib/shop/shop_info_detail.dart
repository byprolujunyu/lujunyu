import 'dart:convert';
import 'dart:io';
import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_button/config/service_url.dart';
import 'package:flutter_button/detail/datail_page_new.dart';
import 'package:flutter_button/detail/detail_page.dart';
import 'package:flutter_button/model/shop_detail.dart';
import 'package:flutter_button/page/category_page.dart';
import 'package:flutter_button/page/seracher.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_button/widget/hot_below.dart';
import 'package:flutter_button/widget/my_widget.dart';
import '../service/service_method.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_swiper/flutter_swiper.dart';
import 'package:flutter_easyrefresh/easy_refresh.dart';

class ShopInfoDetailPage extends StatefulWidget {
  final String shopId;

  ShopInfoDetailPage({@required this.shopId});

  @override
  _ShopInfoDetailPageState createState() => _ShopInfoDetailPageState();
}

class _ShopInfoDetailPageState extends State<ShopInfoDetailPage> {
  ShopDetail _shopInfoDetail;
  bool init = false;

  void _getShopInfoDetail() {
    var formData = {'shopId': '${widget.shopId}'};
    request('shopInfoDetail', formData: formData).then((val) {
      var data = json.decode(val.toString());
      setState(() {
        try {
          _shopInfoDetail = ShopDetail.fromJson(data);
          init = true;
          print(_shopInfoDetail);
        } catch (e) {
          print(e);
        }
      });
    });
  }

  @override
  void initState() {
    super.initState();
    _getShopInfoDetail();
  }

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    try {
      return Scaffold(
          appBar: AppBar(
            title: Text('积分商城'),
            elevation: 0.0,
          ),
          body: init
              ? SingleChildScrollView(
                  child: Column(
                    children: <Widget>[
                      title(),
                      MyDivider(
                        height: ScreenUtil().setHeight(20),
                        color: Color.fromARGB(255, 240, 238, 238),
                      ),
                      middlePic(),
                      MyDivider(
                        height: ScreenUtil().setHeight(20),
                        color: Color.fromARGB(255, 240, 238, 238),
                      ),
                      MiddleOperation(),
                      PurpleWidget(
                        shopInfoDetail: _shopInfoDetail,
                      ),
                      BottomGoodsListWidget(
                        shopInfoDetail: _shopInfoDetail,
                      ),
                    ],
                  ),
                )
              : Center(
                  child: Loading(),
                ));
    } catch (e) {
      print(e);
    }
  }

  Widget title() {
    return Container(
      width: MediaQuery.of(context).size.width,
      height: ScreenUtil().setHeight(60),
      color: Colors.white,
      margin: EdgeInsets.all(10.0),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: <Widget>[
          Container(
            margin: EdgeInsets.all(5.0),
            alignment: Alignment.center,
            child: Text(
              '欢迎光临百姓生活+积分商城',
              style: TextStyle(color: Colors.black45),
            ),
          ),
          Container(
            width: ScreenUtil().setWidth(150),
            height: ScreenUtil().setHeight(100),
            margin: EdgeInsets.all(5.0),
            alignment: Alignment.center,
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(10),
              border: Border.all(color: Colors.pink),
            ),
            child: Text(
              '帮助说明',
              style: TextStyle(color: Colors.pink),
            ),
          ),
        ],
      ),
    );
  }

  Widget middlePic() {
    return Column(
      children: <Widget>[
        Container(
          child: Image.network('${_shopInfoDetail.data.activityInfo.iMAGE}'),
        ),
      ],
    );
  }
}

class MiddleOperation extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    try {
      return Container(
        height: ScreenUtil().setHeight(100),
        color: Colors.white,
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: <Widget>[
            Container(
              margin: EdgeInsets.all(5.0),
              child: Row(
                children: <Widget>[
                  Container(
                    width: ScreenUtil().setWidth(50),
                    height: ScreenUtil().setHeight(50),
                    child: Image.asset('images/binding.png'),
                  ),
                  Container(
                    margin: EdgeInsets.all(5.0),
                    child: Text('绑定会员卡'),
                  ),
                ],
              ),
            ),
//            Container(
//              height: ScreenUtil().setHeight(300),
//              margin: EdgeInsets.fromLTRB(30, 0, 0, 40),
//              decoration: BoxDecoration(
//                border: Border(right: BorderSide(color: Colors.black45,width: 3)),
//              ),
//            ),
            Container(
              margin: EdgeInsets.all(5.0),
              child: Row(
                children: <Widget>[
                  Container(
                    width: ScreenUtil().setWidth(50),
                    height: ScreenUtil().setHeight(50),
                    child: Image.asset('images/jilu.png'),
                  ),
                  Container(
                    margin: EdgeInsets.all(5.0),
                    child: Text('兑换记录'),
                  ),
                ],
              ),
            ),
          ],
        ),
      );
    } catch (e) {
      print(e);
    }
  }
}

//huodongzhuti.png
class PurpleWidget extends StatelessWidget {
  final ShopDetail shopInfoDetail;

  PurpleWidget({@required this.shopInfoDetail});

  @override
  Widget build(BuildContext context) {
    return Stack(
      children: <Widget>[
        Container(
          color: Color.fromARGB(255, 252, 213, 237),
          height: ScreenUtil().setHeight(110),
        ),
        Container(
            alignment: Alignment.center,
            height: ScreenUtil().setHeight(105),
            child: Padding(
              padding: EdgeInsets.all(5.0),
              child: Container(
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(5),
                ),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.start,
                  children: <Widget>[
                    Container(
                      height: ScreenUtil().setHeight(65),
                      width: ScreenUtil().setWidth(65),
                      margin: EdgeInsets.all(5.0),
                      child: Image.asset(
                        'images/huodongzhuti.png',
                        fit: BoxFit.fill,
                      ),
                    ),
                    Container(
                      width: ScreenUtil().setWidth(600),
                      child: Column(
                        children: <Widget>[
                          Container(
                            margin: EdgeInsets.only(left: 15.0),
                            alignment: Alignment.centerLeft,
                            child: Text(
                              '百姓量贩感恩月',
                              style: TextStyle(
                                  fontWeight: FontWeight.bold,
                                  fontSize: ScreenUtil().setSp(25)),
                            ),
                          ),
                          Container(
                              alignment: Alignment.centerLeft,
                              margin: EdgeInsets.only(left: 15.0),
                              child: Text(
                                  '从${shopInfoDetail.data.activityInfo.bEGINTIME2}到${shopInfoDetail.data.activityInfo.eNDTIME}')),
                        ],
                      ),
                    ),
                  ],
                ),
              ),
            )),
      ],
    );
  }
}

class BottomGoodsListWidget extends StatelessWidget {
  final ShopDetail shopInfoDetail;

  BottomGoodsListWidget({@required this.shopInfoDetail});

  @override
  Widget build(BuildContext context) {
    try {
      return Container(
        height:
            shopInfoDetail.data.goodsList.length * ScreenUtil().setHeight(350),
        child: GridView.count(
          crossAxisCount: 2,
          physics: new NeverScrollableScrollPhysics(),
          mainAxisSpacing: 5,
          crossAxisSpacing: 5,
          children: shopInfoDetail.data.goodsList.map((detail) {
            return _getUi(context, detail);
          }).toList(),
        ),
      );
    } catch (e) {
      print(e);
    }
  }

  Widget _getUi(BuildContext context, ShopDetail_GoodsList detail) {
    return SingleChildScrollView(
         physics: new NeverScrollableScrollPhysics(),
      child: Container(
        height: ScreenUtil().setHeight(500),
        child: Column(
          children: <Widget>[
            Container(
              height: ScreenUtil().setHeight(180),
              child: Image.network(
                detail.pICTURECOMPERSSPATH,
                fit: BoxFit.fill,
              ),
            ),
            Container(
              child: Text(detail.nAME),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: <Widget>[
                Row(
                  children: <Widget>[
                    Container(
                      margin: EdgeInsets.all(3.0),
                      height: ScreenUtil().setHeight(50),
                      width: ScreenUtil().setWidth(50),
                      child: Image.asset(
                        'images/jifen.png',
                        fit: BoxFit.fill,
                      ),
                    ),
                    Container(
                      margin: EdgeInsets.all(3.0),
                      child: Text('${detail.nEEDINTEGRAL}积分'),
                    )
                  ],
                ),
                Container(
                  margin: EdgeInsets.all(3.0),
                  height: ScreenUtil().setHeight(50),
                  width: ScreenUtil().setWidth(50),
                  child: Image.asset(
                    'images/add.png',
                    fit: BoxFit.fill,
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
