import 'dart:convert';
import 'dart:io';
import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_button/config/service_url.dart';
import 'package:flutter_button/detail/datail_page_new.dart';
import 'package:flutter_button/detail/detail_page.dart';
import 'package:flutter_button/page/category_page.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_button/widget/hot_below.dart';
import 'package:flutter_button/widget/my_widget.dart';
import '../service/service_method.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_swiper/flutter_swiper.dart';
import 'package:flutter_easyrefresh/easy_refresh.dart';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage>
    with AutomaticKeepAliveClientMixin {
  int page = 1;
  List<Map> hotGoodsList = [];

  //火爆商品接口
  void _getHotGoods() {
    var formPage = {'page': page};
    request('homePageBelowConten', formData: formPage).then((val) {
      var data = json.decode(val.toString());
      List<Map> newGoodsList = (data['data'] as List).cast();
      setState(() {
        hotGoodsList.addAll(newGoodsList);
        page++;
      });
    });
  }

  Map mapToMap2(Map m) {
    Map newM = Map();
    newM.putIfAbsent("goodsName", () => m['name']);
    newM.putIfAbsent("image", () => m['image']);
    newM.putIfAbsent("presentPrice", () => m['mallPrice']);
    newM.putIfAbsent("oriPrice", () => m['price']);
    newM.putIfAbsent("goodsId", () => '火爆商品');
    return newM;
  }

  Widget hotTitle = Container(
    margin: EdgeInsets.only(top: 10.0),
    padding: EdgeInsets.all(5.0),
    alignment: Alignment.center,
    decoration: BoxDecoration(
        color: Colors.white,
        border: Border(bottom: BorderSide(width: 0.5, color: Colors.black12))),
    child: Text(
      '火爆专区',
      style: TextStyle(color: Colors.pink),
    ),
  );
  GlobalKey<RefreshHeaderState> _headerKeyGrid =
      new GlobalKey<RefreshHeaderState>();
  GlobalKey<RefreshFooterState> _footerKeyGrid =
      new GlobalKey<RefreshFooterState>();

  Widget _wrapList() {
    if (hotGoodsList.length != 0) {
      List<Widget> listWidget = hotGoodsList.map((val) {
        return InkWell(
            onTap: () {
              Map newM = mapToMap2(val);

              Navigator.of(context)
                  .push(MaterialPageRoute(builder: (BuildContext ctx) {
                return DetailPage(
                  map: newM,
                );
              }));
            },
            child: Container(
              width: ScreenUtil().setWidth(372),
              color: Colors.white,
              padding: EdgeInsets.all(5.0),
              margin: EdgeInsets.only(bottom: 3.0),
              child: Column(
                children: <Widget>[
                  Image.network(
                    val['image'],
                    width: ScreenUtil().setWidth(375),
                  ),
                  Text(
                    val['name'],
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                    style: TextStyle(
                        color: Colors.pink, fontSize: ScreenUtil().setSp(26)),
                  ),
                  Row(
                    children: <Widget>[
                      Text('￥${val['mallPrice']}'),
                      Text(
                        '￥${val['price']}',
                        style: TextStyle(
                            color: Colors.black26,
                            decoration: TextDecoration.lineThrough),
                      )
                    ],
                  )
                ],
              ),
            ));
      }).toList();
      return Wrap(
        spacing: 2,
        children: listWidget,
      );
    } else {
      return Center(
        child: Loading(),
      );
    }
  }

  //火爆专区组合
  Widget _hotGoods() {
    return Container(
        child: Column(
      children: <Widget>[
        hotTitle,
        _wrapList(),
      ],
    ));
  }

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return Scaffold(
        appBar: AppBar(
          title: Text('百姓生活+'),
          elevation: 0.0,
          actions: <Widget>[],
        ),
        body: FutureBuilder(
          future: getHomePageContent(),
          builder: (context, snapshot) {
            if (snapshot.hasData) {
              var data = json.decode(snapshot.data.toString());
              List<Map> swiperDataList =
                  (data['data']['slides'] as List).cast();
              List<Map> navigatorList =
                  (data['data']['category'] as List).cast(); //类别列表
              List<Map> recommendList =
                  (data['data']['recommend'] as List).cast(); //推荐列表
              List<Map> floor1 = (data['data']['floor1'] as List).cast(); //推荐列表
              List<Map> floor2 = (data['data']['floor2'] as List).cast(); //推荐列表
              List<Map> floor3 = (data['data']['floor3'] as List).cast(); //推荐列表
              String adPicture =
                  data['data']['advertesPicture']['PICTURE_ADDRESS'];
              Map leaderInfo = data['data']['shopInfo'];
              Map fp3 = data['data']['floor3Pic'];
              Map fp2 = data['data']['floor2Pic'];
              Map fp1 = data['data']['floor1Pic'];

              String integralMallPic =
                  data['data']['integralMallPic']['PICTURE_ADDRESS'];
              String newUser = data['data']['newUser']['PICTURE_ADDRESS'];
              String saoma = data['data']['saoma']['PICTURE_ADDRESS'];

              if (navigatorList.length > 10) {
                navigatorList.removeRange(10, navigatorList.length);
              }
              // 顶部轮播组件数
              //页面顶部轮播组件

              return EasyRefresh(
                child: ListView(
                  children: <Widget>[
                    SwiperDiy(
                      swiperDataList: swiperDataList,
                    ),
                    TopNavigator(
                      navigatorList: navigatorList,
                    ),

                    AdBanner(
                      adPicture: adPicture,
                    ),
                    LeaderView(
                      leaderInfo: leaderInfo,
                    ),
                    MiddleAd(
                      saoma: saoma,
                      integralMallPic: integralMallPic,
                      newUser: newUser,
                    ),
                    RecommendUI(
                      recommendList: recommendList,
                    ),
                    FloorPic(
                      floorPic: fp1,
                    ),
                    Floor(floor: floor1),
                    FloorPic(
                      floorPic: fp2,
                    ),
                    Floor(floor: floor2),
                    FloorPic(
                      floorPic: fp3,
                    ),
                    Floor(floor: floor3),
                    // HotUI(),
                    // HotUI(),
                    _hotGoods(),
                  ],
                ),
                refreshFooter: ClassicsFooter(
                    key: _footerKeyGrid,
                    bgColor: Colors.white,
                    textColor: Colors.pink,
                    moreInfoColor: Colors.pink,
                    showMore: true,
                    noMoreText: '',
                    moreInfo: '加载中',
                    loadReadyText: '上拉加载....'),
                loadMore: () async {
                  _getHotGoods();
                },
              );
            } else {
              return Center(
                child: Loading(),
              );
            }
          },
        ));
  }

  @override
  // TODO: implement wantKeepAlive
  bool get wantKeepAlive => true;
}

// 首页轮播组件编写
class SwiperDiy extends StatelessWidget {
  final List swiperDataList;

  SwiperDiy({Key key, this.swiperDataList}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      height: ScreenUtil().setHeight(333),
      width: ScreenUtil().setWidth(750),
      child: Swiper(
        itemBuilder: (BuildContext context, int index) {
          return Image.network("${swiperDataList[index]['image']}",
              fit: BoxFit.fill);
        },
        itemCount: swiperDataList.length,
        pagination: new SwiperPagination(),
        autoplay: true,
      ),
    );
  }
}

class TopNavigator extends StatelessWidget {
  final List navigatorList;

  TopNavigator({Key key, this.navigatorList}) : super(key: key);

  Widget _gridViewItemUI(BuildContext context, item) {
    return InkWell(
      onTap: () {
        jump(item['mallCategoryName'], context);
      },
      child: Column(
        children: <Widget>[
          Image.network(
            item['image'],
            width: ScreenUtil().setWidth(95),
            fit: BoxFit.fill,
          ),
          Text(item['mallCategoryName'])
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      height: ScreenUtil().setHeight(320),
      child: GridView.count(
        physics: new NeverScrollableScrollPhysics(),
        crossAxisCount: 5,
        padding: EdgeInsets.all(4.0),
        children: navigatorList.map((item) {
          return _gridViewItemUI(context, item);
        }).toList(),
      ),
    );
  }

  void jump(str, BuildContext context) {
    switch (str) {
      case "白酒":
        Navigator.of(context)
            .push(MaterialPageRoute(builder: (BuildContext ctx) {
          return CategoryPage(
            item: 0,
          );
        }));
        break;
      case "啤酒":
        Navigator.of(context)
            .push(MaterialPageRoute(builder: (BuildContext ctx) {
          return CategoryPage(
            item: 1,
          );
        }));
        break;
      case "葡萄酒":
        Navigator.of(context)
            .push(MaterialPageRoute(builder: (BuildContext ctx) {
          return CategoryPage(
            item: 2,
          );
        }));
        break;
      case "清酒洋酒":
        Navigator.of(context)
            .push(MaterialPageRoute(builder: (BuildContext ctx) {
          return CategoryPage(
            item: 3,
          );
        }));
        break;
      case "保健酒":
        Navigator.of(context)
            .push(MaterialPageRoute(builder: (BuildContext ctx) {
          return CategoryPage(
            item: 4,
          );
        }));
        break;
      case "预调酒":
        Navigator.of(context)
            .push(MaterialPageRoute(builder: (BuildContext ctx) {
          return CategoryPage(
            item: 5,
          );
        }));
        break;
      case "下酒小菜":
        Navigator.of(context)
            .push(MaterialPageRoute(builder: (BuildContext ctx) {
          return CategoryPage(
            item: 6,
          );
        }));
        break;
      case "饮料":
        Navigator.of(context)
            .push(MaterialPageRoute(builder: (BuildContext ctx) {
          return CategoryPage(
            item: 7,
          );
        }));
        break;
      case "乳制品":
        Navigator.of(context)
            .push(MaterialPageRoute(builder: (BuildContext ctx) {
          return CategoryPage(
            item: 8,
          );
        }));
        break;
      case "休闲零食":
        Navigator.of(context)
            .push(MaterialPageRoute(builder: (BuildContext ctx) {
          return CategoryPage(
            item: 9,
          );
        }));
        break;
    }
  }
}

class AdBanner extends StatelessWidget {
  final String adPicture;

  AdBanner({Key key, this.adPicture}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Image.network(adPicture),
    );
  }
}

class LeaderView extends StatelessWidget {
  final Map leaderInfo;

  LeaderView({Key key, this.leaderInfo}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: InkWell(
        onTap: () {
          String leaderP = 'tel:' + leaderInfo['leaderPhone'];
          alertDialog(context, "是否拨打店长电话", leaderP);
        },
        child: Image.network(leaderInfo['leaderImage']),
      ),
    );
  }
}

class RecommendUI extends StatelessWidget {
  List recommendList;

  RecommendUI({Key key, this.recommendList}) : super(key: key);

  Widget _gridViewItemUI(BuildContext context, item) {
    return InkWell(
      onTap: () {},
      child: SingleChildScrollView(
        child: Column(
          children: <Widget>[
            Image.network(
              item['image'],
              width: ScreenUtil().setWidth(180),
              fit: BoxFit.fill,
            ),
            Text(
              '￥ ' + item['mallPrice'].toString() + '0',
              style: TextStyle(fontSize: ScreenUtil().setSp(25)),
            ),
            Text('￥ ' + item['price'].toString() + '0',
                style: TextStyle(fontSize: ScreenUtil().setSp(18))),
          ],
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.start,
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Container(
          margin: EdgeInsets.all(ScreenUtil().setWidth(30)),
          child: Text(
            '商品推荐',
            style: TextStyle(
              fontSize: ScreenUtil().setSp(25),
              fontWeight: FontWeight.bold,
              color: Colors.pink,
            ),
          ),
        ),
        Container(
          child: Divider(
            color: Colors.black45,
            height: ScreenUtil().setHeight(20),
          ),
          margin: EdgeInsets.all(ScreenUtil().setHeight(15)),
        ),
        Container(
          child: GridView.count(
            physics: new NeverScrollableScrollPhysics(),
            crossAxisCount: 3,
            children: recommendList.map((item) {
              return _gridViewItemUI(context, item);
            }).toList(),
          ),
          height: ScreenUtil().setHeight(300),
        ),
      ],
    );
  }
}

class FloorPic extends StatelessWidget {
  final Map floorPic;

  FloorPic({Key key, this.floorPic}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: InkWell(
        child: Image.network(
          floorPic['PICTURE_ADDRESS'],
        ),
        onTap: () {
          Navigator.of(context).push(
            MaterialPageRoute(builder: (BuildContext ctx) {
              return CategoryPage(
                item: floorPic['TO_PLACE'] == '4'
                    ? 0
                    : floorPic['TO_PLACE'] != '4' ? 0 : 1,
              );
            }),
          );
        },
      ),
    );
  }
}

class Floor extends StatelessWidget {
  List<Map> floor;

  Floor({Key key, this.floor}) : super(key: key);

  void jumpDetail(context, String goodsid) {
//    Navigator.of(context).push(MaterialPageRoute(builder: (BuildContext ctx) {
//      return DetailPageNew(
//        goodsId: goodsid,
//      );
//    }));
  }

//DetailPageNew
  @override
  Widget build(BuildContext context) {
    int width = ScreenUtil.getInstance().width;
    return Container(
      child: Row(
        children: <Widget>[
          Expanded(
            child: Column(
              children: <Widget>[
                Container(
                    height: ScreenUtil().setHeight(400),
                    child: InkWell(
                      child: Image.network(
                        floor[0]['image'],
                      ),
                      onTap: () {
                        jumpDetail(context, floor[0]['goodsId']);
                      },
                    )),
                Container(
                    height: ScreenUtil().setHeight(200),
                    child: InkWell(
                      child: Image.network(
                        floor[1]['image'],
                      ),
                      onTap: () {
                        jumpDetail(context, floor[1]['goodsId']);
                      },
                    )),
              ],
            ),
          ),
          Expanded(
            child: Column(
              children: <Widget>[
                Container(
                    padding: EdgeInsets.zero,
                    height: ScreenUtil().setHeight(200),
                    child: InkWell(
                      child: Image.network(
                        floor[2]['image'],
                      ),
                      onTap: () {
                        jumpDetail(context, floor[2]['goodsId']);
                      },
                    )),
                Container(
                    padding: EdgeInsets.zero,
                    height: ScreenUtil().setHeight(200),
                    child: InkWell(
                      child: Image.network(
                        floor[3]['image'],
                      ),
                      onTap: () {
                        jumpDetail(context, floor[3]['goodsId']);
                      },
                    )),
                Container(
                    padding: EdgeInsets.zero,
                    height: ScreenUtil().setHeight(200),
                    width: width.toDouble() / 2,
                    child: InkWell(
                      child: Image.network(
                        floor[4]['image'],
                      ),
                      onTap: () {
                        jumpDetail(context, floor[4]['goodsId']);
                      },
                    )),
              ],
            ),
          ),
        ],
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        mainAxisSize: MainAxisSize.min,
      ),
    );
  }
}

class MiddleAd extends StatelessWidget {
  final String saoma;

  final String integralMallPic;

  final String newUser;

  MiddleAd({Key key, this.saoma, this.integralMallPic, this.newUser})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Row(
        children: <Widget>[
          Container(
              child: Expanded(
            child: Image.network(saoma),
          )),
          Container(
              child: Expanded(
            child: Image.network(integralMallPic),
          )),
          Container(
              child: Expanded(
            child: Image.network(newUser),
          )),
        ],
      ),
    );
  }
}

class HotGoods extends StatefulWidget {
  @override
  _HotGoodsState createState() => _HotGoodsState();
}

class _HotGoodsState extends State<HotGoods> {
  @override
  Widget build(BuildContext context) {
    return Container();
  }
}
