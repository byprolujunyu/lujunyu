import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_button/address/address_manage.dart';
import 'package:flutter_button/constants/index.dart';
import 'package:flutter_button/db/db_helper.dart';
import 'package:flutter_button/detail/detail_page.dart';
import 'package:flutter_button/model/cart_model.dart';
import 'package:flutter_button/model/good_detail.dart';
import 'package:flutter_button/model/new_details.dart';
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

  NewDetailModel detailModel;

  @override
  Widget build(BuildContext context) {
    String ID = widget.goodsId;
    return FutureBuilder(
        future: shopGoodsDetailImg(widget.goodsId),
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            var data = json.decode(snapshot.data.toString());
            print(data);

            detailModel = NewDetailModel.fromJson(data);
            print(detailModel);

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
      return Column(
        children: <Widget>[
          Expanded(
            child: Container(
              height: ScreenUtil().setHeight(1000),
              child: ListView(
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
                ],
              ),
            ),
          ),
          CountWidget(
            goodDetail: goodDetail,
          ),
        ],
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



class NumCountWidget extends StatefulWidget {
  final Function(BuildContext context) remove;
  final GoodDetail detail;

  NumCountWidget({@required this.remove, this.detail});

  @override
  _NumCountWidgetState createState() => _NumCountWidgetState();
}

class _NumCountWidgetState extends State<NumCountWidget> {
  int count = 1;

  var db = new DataBaseHelper();

  Future _add(User user) async {
    await db.saveUser(user).then((index) {});
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      height: ScreenUtil().setHeight(180),
      child: Container(
        child: Column(
          children: <Widget>[
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: <Widget>[
                Container(
                  padding: EdgeInsets.all(5),
                  child: Text('购买数量'),
                ),
                InkWell(
                  child: Container(
                    height: ScreenUtil().setHeight(50),
                    width: ScreenUtil().setWidth(50),
                    child: Image.asset(
                      'img/close.png',
                      fit: BoxFit.fill,
                    ),
                  ),
                  onTap: () {
                    widget.remove(context);
                  },
                ),
              ],
            ),
            Divider(
              height: 5,
              color: Colors.black26,
            ),
            Container(
              padding: EdgeInsets.fromLTRB(1, 3, 0, 3),
              child: Row(
                children: <Widget>[
                  Container(
                    child: Row(
                      children: <Widget>[
                        GestureDetector(
                          onTap: () => {_dix_count()},
                          child: Container(
                            height: ScreenUtil().setHeight(50),
                            width: ScreenUtil().setWidth(50),
                            alignment: Alignment.center,
                            child: Text(
                              '-',
                              style: TextStyle(color: Colors.white),
                            ),
                            decoration: BoxDecoration(
                              color: Colors.green,
                              borderRadius: BorderRadius.circular(100),
                            ),
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.only(left: 5),
                          height: ScreenUtil().setHeight(50),
                          width: ScreenUtil().setWidth(50),
                          alignment: Alignment.center,
                          child: Text('$count'),
                          decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(3),
                            border: Border.all(color: Colors.black26, width: 3),
                          ),
                        ),
                        GestureDetector(
                          onTap: () => {_add_count()},
                          child: Container(
                            margin: EdgeInsets.only(left: 5),
                            height: ScreenUtil().setHeight(50),
                            width: ScreenUtil().setWidth(50),
                            alignment: Alignment.center,
                            child: Text(
                              '+',
                              style: TextStyle(color: Colors.white),
                            ),
                            decoration: BoxDecoration(
                              color: Colors.green,
                              borderRadius: BorderRadius.circular(100),
                            ),
                          ),
                        ),
                        InkWell(
                          child: Container(
                            margin: EdgeInsets.only(left: 5),
                            height: ScreenUtil().setHeight(50),
                            width: ScreenUtil().setWidth(300),
                            alignment: Alignment.center,
                            child: Text(
                              '确定加入购物车',
                              style: TextStyle(color: Colors.white),
                            ),
                            decoration: BoxDecoration(
                              color: Colors.green,
                              borderRadius: BorderRadius.circular(5),
                            ),
                          ),
                          onTap: () {
                            _add(new User(
                                name: widget.detail.name,
                                image: widget.detail.image,
                                count: count,
                                price: widget.detail.price));

                            Navigator.pop(context);
//                            Navigator.of(context).pushAndRemoveUntil(
//                                MaterialPageRoute(
//                                    builder: (context) => IndexPage(
//                                          item: 0,
//                                          index: 2,
//                                        )),
//                                (route) => route == null);
                          },
                        ),
                        Container(),
                      ],
                    ),
                  )
                ],
              ),
            ),
          ],
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
            flex: 3,
            child: InkWell(
              child: Container(
                color: Colors.white,
                alignment: Alignment.center,
                child: Stack(
                  children: <Widget>[
                    Container(
                      height: ScreenUtil().setHeight(50),
                      width: ScreenUtil().setWidth(50),
                      child: Image.asset('images/icon_detai;_page_cart.png'),
                    ),
                    Container(
                      alignment: Alignment.center,
                      width: ScreenUtil().setWidth(30),
                      height: ScreenUtil().setHeight(30),
                      child: Text(
                        '99',
                        style: TextStyle(
                          fontSize: ScreenUtil().setSp(20),
                          color: Colors.white,
                        ),
                      ),
                      decoration: BoxDecoration(
                        color: Colors.red,
                        borderRadius: BorderRadius.circular(100),
                      ),
                    ),
                  ],
                  alignment: FractionalOffset(0.999, 0.001),
                ),
              ),
              onTap: () {
                Navigator.of(context).pushAndRemoveUntil(
                    MaterialPageRoute(
                        builder: (context) => IndexPage(
                              item: 0,
                              index: 2,
                            )),
                    (route) => route == null);
              },
            ),
          ),
          Expanded(
            flex: 7,
            child: InkWell(
              onTap: () {
                showBottomWidget(
                  context,
                  NumCountWidget(
                      remove: (context) {
                        Navigator.pop(context);
                      },
                      detail: goodDetail),
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
            flex: 7,
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
        height: ScreenUtil().setHeight(1000),
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
