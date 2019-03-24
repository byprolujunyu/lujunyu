import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_button/address/address_manage.dart';
import 'package:flutter_button/constants/index.dart';
import 'package:flutter_button/db/db_helper.dart';
import 'package:flutter_button/detail/detail_page.dart';
import 'package:flutter_button/model/cart_model.dart';
import 'package:flutter_button/model/good_detail.dart';
import 'package:flutter_button/page/cart_ios_page.dart';
import 'package:flutter_button/page/command_bottom.dart';
import 'package:flutter_button/page/detail_bottom.dart';
import 'package:flutter_button/page/index_main.dart';

import 'package:flutter_button/pay/pay_page.dart';
import 'package:flutter_button/widget/tabbar.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_button/widget/detail_info.dart';
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
  GoodDetail goodDetail;
  Map map;

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
        future: shopGoodsDetailImg(widget.goodsId),
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            var data = json.decode(snapshot.data.toString());
            print(data);
            map = data['data'];

            shopInfo = data['data']['goodInfo'];

            goodDetail = GoodDetail.fromMap(shopInfo);

            return Scaffold(
              appBar: AppBar(
                title: Text(shopInfo['goodsName']),
                elevation: 0.0,
              ),
              body: getMainWidget(),
            );
          } else {
            return Center(
              child: Loading(),
            );
          }
        });
  }

  Widget getMainWidget() {
    try {
      return SingleChildScrollView(
        child: Column(
          children: <Widget>[
            DetailPageInfo(detail: goodDetail),
            MiddleWidget(map),
            Container(
              child: MyDivider(
                height: 5,
                color: Colors.black12,
              ),
              margin: EdgeInsets.only(top: 5, bottom: 5),
            ),
            CountWidget(
              goodDetail: goodDetail,
            ),
          ],
        ),
      );
    } catch (e) {
      print(e);
    }
  }
}

class DetailPageInfo extends StatelessWidget {
  final GoodDetail detail;

  DetailPageInfo({@required this.detail});

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.start,
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Container(
            child: Center(
          child: Image.network(
            detail.image,
          ),
        )),
        Container(
          margin: EdgeInsets.all(20),
          child: Text(
            detail.name,
            style: TextStyle(
                fontWeight: FontWeight.bold, fontSize: ScreenUtil().setSp(30)),
          ),
        ),
        Container(
          margin: EdgeInsets.only(top: 1, left: 20),
          child: Text(
            "编号 ${detail.goodsSerialNumber}",
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
                  '￥${detail.price}0',
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
                  '￥${detail.shopPrice}0',
                  style: TextStyle(
                      color: Colors.black45,
                      decoration: TextDecoration.lineThrough,
                      fontSize: ScreenUtil().setSp(30)),
                ),
              ),
            ],
          ),
        ),
        Container(
          margin: EdgeInsets.fromLTRB(0, 12, 0, 12),
          child: DetailADDWidget(),
        ),
      ],
    );
  }
}

class SelectCountWidget extends StatefulWidget {
  final GoodDetail detail;

  SelectCountWidget({Key key, @required this.detail}) : super(key: key);

  @override
  _SelectCountWidgetState createState() => _SelectCountWidgetState();
}

class _SelectCountWidgetState extends State<SelectCountWidget> {
  int count = 1;

  var db = new DataBaseHelper();

  Future _add(User user) async {
    await db.saveUser(user).then((index) {});
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: SingleChildScrollView(
        child: Container(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Container(
                alignment: Alignment.centerLeft,
                margin: EdgeInsets.all(10.0),
                child: Text(
                  '购买数量',
                ),
              ),
              Container(
                child: Divider(),
              ),
              Container(
                padding: EdgeInsets.fromLTRB(10, 0, 10, 0),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  // mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Row(
                      mainAxisAlignment: MainAxisAlignment.start,
                      children: <Widget>[
                        GestureDetector(
                          onTap: () => {_dix_count()},
                          child: Container(
                            width: ScreenUtil().setWidth(50),
                            height: ScreenUtil().setHeight(50),
                            decoration:
                                BoxDecoration(border: _getRemoveBtBorder()),
                            child: Icon(Icons.remove,
                                color: _getRemovebuttonColor()),
                          ),
                        ),
                        Container(
                            alignment: Alignment.center,
                            width: ScreenUtil().setWidth(50),
                            height: ScreenUtil().setHeight(50),
                            decoration: BoxDecoration(
                                border: Border.all(
                                    color: KColorConstant.cartItemCountTxtColor,
                                    width: 1)),
                            child: Text(
                              '${count}',
                              style: TextStyle(
                                  fontSize: 13,
                                  fontWeight: FontWeight.bold,
                                  color: KColorConstant.cartItemCountTxtColor),
                            )),
                        GestureDetector(
                          onTap: () => {_add_count()},
                          child: Container(
                            alignment: Alignment.center,
                            width: ScreenUtil().setWidth(50),
                            height: ScreenUtil().setHeight(50),
                            decoration:
                                BoxDecoration(border: _getAddBtBorder()),
                            child: Icon(Icons.add, color: _getAddbuttonColor()),
                          ),
                        ),
                      ],
                    ),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: <Widget>[
                        Container(
                          margin: EdgeInsets.only(left: 10.0),
                          width: ScreenUtil().setWidth(210),
                          height: ScreenUtil().setHeight(60),
                          alignment: Alignment.center,
                          color: Colors.green,
                          child: InkWell(
                            onTap: () {
                              _add(new User(
                                  name: widget.detail.name,
                                  image: widget.detail.image,
                                  count: count,
                                  price: widget.detail.price));
                              Navigator.of(context).pushAndRemoveUntil(
                                  MaterialPageRoute(
                                      builder: (context) => IndexPage(
                                            item: 0,
                                            index: 2,
                                          )),
                                  (route) => route == null);
                            },
                            child: Text(
                              '确认加入购物车',
                              style: TextStyle(color: Colors.white),
                            ),
                          ),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  void _add_count() {
    setState(() {
      ++count;
    });
  }

  void _dix_count() {
    setState(() {
      --count;
    });
  }

  Color _getRemovebuttonColor() {
    return KColorConstant.cartItemCountTxtColor;
  }

  Border _getRemoveBtBorder() {
    return Border(
        bottom: BorderSide(width: 1, color: _getRemovebuttonColor()),
        top: BorderSide(width: 1, color: _getRemovebuttonColor()),
        left: BorderSide(width: 1, color: _getRemovebuttonColor()));
  }

  Border _getAddBtBorder() {
    return Border(
        bottom: BorderSide(width: 1, color: _getAddbuttonColor()),
        top: BorderSide(width: 1, color: _getAddbuttonColor()),
        right: BorderSide(width: 1, color: _getAddbuttonColor()));
  }

  _getAddbuttonColor() {
    return KColorConstant.cartItemCountTxtColor;
  }
}

class CountWidget extends StatelessWidget {
  final goodDetail;

  CountWidget({this.goodDetail});

  @override
  Widget build(BuildContext context) {
    return Container(
      width: ScreenUtil.screenWidth,
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: <Widget>[
          Expanded(
            child: InkWell(
              onTap: () {
                showBottomWidget(
                  context,
                  SelectCountWidget(detail: goodDetail),
                );
              },
              child: Container(
                height: ScreenUtil().setHeight(100),
                color: Colors.green,
                child: Center(
                  child: Text(
                    '加入购物车',
                    style: TextStyle(color: Colors.white),
                  ),
                ),
              ),
            ),
          ),
          Expanded(
            child: InkWell(
              onTap: () {
                Navigator.of(context)
                    .push(MaterialPageRoute(builder: (BuildContext ctx) {
                  return PayPage(
                    map1: goodDetail,
                  );
                }));
              },
              child: Container(
                height: ScreenUtil().setHeight(100),
                color: Colors.red,
                child: Center(
                  child: Text(
                    '立即购买',
                    style: TextStyle(color: Colors.white),
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

class MiddleWidget extends StatelessWidget {
  final Map map;

  MiddleWidget(this.map);

  List<Widget> _pagelist = [];
  List<Widget> _tabs = [
    Tab(
      text: '正在热映',
      icon: Icon(Icons.movie_filter),
    ),
    Tab(
      text: '即将上映',
      icon: Icon(Icons.movie_creation),
    ),
  ];

  @override
  Widget build(BuildContext context) {
    try {
      return get();
    } catch (e) {
      print(e);
    }
  }

  Widget get() {
    var m = map['goodInfo']['goodsDetail'];
    print(m);
    try {
      return Container(
        height: 400,
        child: DefaultTabController(
          length: 2,
          initialIndex: 0,
          child: Column(
            children: <Widget>[
              KTabBarWidget(),
              Expanded(
                child: TabBarView(
                  children: <Widget>[
                    DetailTabWidget(
                      map: m,
                      m: map['advertesPicture'],
                    ),
                    CommTabWidget(
                      ms: map['goodComments'],
                      map: map['advertesPicture'],
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      );
    } catch (e) {
      print(e);
    }
  }
}
