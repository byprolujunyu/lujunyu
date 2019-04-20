import 'dart:convert';
import 'package:fluro/fluro.dart';
import 'package:flutter/material.dart';
import 'package:flutter_button/constants/index.dart';
import 'package:flutter_button/detail/datail_page_new.dart';
import 'package:flutter_button/detail/detail_page.dart';
import 'package:flutter_button/fuji/fuji_page.dart';
import 'package:flutter_button/page/category_page.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_button/page/seracher.dart';
import 'package:flutter_button/page/speak_page.dart';
import 'package:flutter_button/routers/application.dart';
import 'package:flutter_button/shop/shop_info.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_button/widget/ada_widget.dart';
import '../service/service_method.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_swiper/flutter_swiper.dart';
import 'package:flutter_easyrefresh/easy_refresh.dart';

jump(@required context, @required goodid) {
  Application.router.navigateTo(context, '/detail?id=$goodid',
      transition: TransitionType.nativeModal);
}

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage>
    with AutomaticKeepAliveClientMixin {
  int page = 1;
  List<Map> hotGoodsList = [];
  TextEditingController _numController = TextEditingController();

  Map adaData;

  bool showAda = false;

  OverlayEntry ov;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _getAdaData();
  }

  bool init = true;

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

  void _getAdaData() {
    request('ada').then((val) {
      var data = json.decode(val.toString());
      print(data);
      Map fp3 = data['data'];
      setState(() {
        adaData = fp3;
      });
    });
  }

  Widget searchBar() {
    try {
      return Container(
        color: Colors.white70,
        child: SingleChildScrollView(
          scrollDirection: Axis.horizontal,
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: <Widget>[
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: <Widget>[
                  Container(
                      width: ScreenUtil().setWidth(50),
                      height: ScreenUtil().setHeight(50),
                      margin:
                          EdgeInsets.only(top: 15.0, left: 15.0, bottom: 15.0),
                      child: Image.asset('images/backgrey.png')),
//                  Expanded(
//                    child: Container(
//                     // width: ScreenUtil().setWidth(550),
//                      child: TextField(
//                        controller: _numController,
//                        maxLines: 1,
//                        keyboardType: TextInputType.text,
//                        decoration: InputDecoration(
//                          filled: true,
//                          labelText: "请输入你要查询的商品",
//                        ),
//                        autofocus: false,
//                      ),
//                    ),
//                  ),
                  _wrapTap(
                      Container(
                        margin: EdgeInsets.all(8),
                        child: Icon(
                          Icons.mic,
                          size: 22,
                          color: Colors.blue,
                        ),
                      ),
                      () {  Navigator.of(context)
                          .push(MaterialPageRoute(builder: (BuildContext ctx) {
                        return SpeakPage();
                      }));})
                ],
              ),
              InkWell(
                child: Container(
                  alignment: Alignment.center,
                  margin: EdgeInsets.only(right: 15.0),
                  width: ScreenUtil().setWidth(80),
                  height: ScreenUtil().setHeight(50),
                  child: Text(
                    '搜索',
                    style: TextStyle(color: Colors.pink),
                  ),
                  decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(3.0),
                    border: Border.all(color: Colors.white, width: 1.0),
                  ),
                ),
                onTap: () {
                  var text = _numController.text;
                  if (text == null || text.length == 0) {
                    showShortToast('搜索为空', index: 1);
                  } else {
                    Navigator.of(context)
                        .push(MaterialPageRoute(builder: (BuildContext ctx) {
                      return SearchP(
                        text: text,
                      );
                    }));
                  }
                },
              ),
            ],
          ),
        ),
      );
    } catch (e) {
      print(e);
    }
  }

  _wrapTap(Widget child, void Function() callback) {
    return GestureDetector(
      onTap: () {
        if (callback != null) callback();
      },
      child: child,
    );
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

//images/huobao.png
  Widget hotTitle = Container(
    margin: EdgeInsets.only(top: 10.0),
    padding: EdgeInsets.all(5.0),
    alignment: Alignment.center,
    decoration: BoxDecoration(
        color: Colors.white,
        border: Border(bottom: BorderSide(width: 0.5, color: Colors.black45))),
    child: Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        Container(
            margin: EdgeInsets.all(5.0),
            height: ScreenUtil().setHeight(50),
            width: ScreenUtil().setWidth(50),
            child: Image.asset(
              'images/huobao.png',
              fit: BoxFit.fill,
            )),
        Container(
          margin: EdgeInsets.only(top: 5.0, bottom: 5.0),
          child: Text(
            '火爆专区',
            style: TextStyle(color: Colors.pink),
          ),
        ),
      ],
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
              var id = val['goodsId'];
              jump(context, id);
            },
            child: Container(
              width: ScreenUtil().setWidth(350),
              color: Colors.white,
              padding: EdgeInsets.all(5.0),
              margin: EdgeInsets.only(bottom: 3.0),
              child: Column(
                children: <Widget>[
                  Image.network(
                    val['image'],
                    width: ScreenUtil().setWidth(345),
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
      return Container();
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
        body: Center(
          child: Container(
            // padding: const EdgeInsets.all(8.0),
            child: FutureBuilder(
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
                  List<Map> floor1 =
                      (data['data']['floor1'] as List).cast(); //推荐列表
                  List<Map> floor2 =
                      (data['data']['floor2'] as List).cast(); //推荐列表
                  List<Map> floor3 =
                      (data['data']['floor3'] as List).cast(); //推荐列表
                  String adPicture =
                      data['data']['advertesPicture']['PICTURE_ADDRESS'];
                  Map leaderInfo = data['data']['shopInfo'];
                  Map fp3 = data['data']['floor3Pic'];
                  Map fp2 = data['data']['floor2Pic'];
                  Map fp1 = data['data']['floor1Pic'];

                  String floor1Title =
                      data['data']['floor1Pic']['PICTURE_ADDRESS']; //楼层1的标题图片
                  String floor2Title =
                      data['data']['floor2Pic']['PICTURE_ADDRESS']; //楼层1的标题图片
                  String floor3Title =
                      data['data']['floor3Pic']['PICTURE_ADDRESS']; //楼层1的标题图片

                  String integralMallPic =
                      data['data']['integralMallPic']['PICTURE_ADDRESS'];
                  String newUser = data['data']['newUser']['PICTURE_ADDRESS'];
                  String saoma = data['data']['saoma']['PICTURE_ADDRESS'];

                  if (navigatorList.length > 10) {
                    navigatorList.removeRange(10, navigatorList.length);
                  }

                  getSp(key: KString.isKey).then((value) {
                    if (value == '0') {
                      showDialog<Null>(
                          context: context,
                          barrierDismissible: false,
                          builder: (BuildContext context) {
                            return AdaWidget(
                              map: adaData,
                              remove: (context) {
                                Navigator.pop(context);

                                saveSp(key: KString.isKey, str: '1');
                              },
                            );
                          });
                    }
                  });
                  // 顶部轮播组件数
                  //页面顶部轮播组件

                  return EasyRefresh(
                    child: ListView(
                      children: <Widget>[
                        searchBar(),
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
                          adaData: adaData,
                        ),
                        RecommendUI(
                          recommendList: recommendList,
                        ),
                        FloorPic(
                          floorPic: fp1,
                        ),
                        FloorContent(floorGoodsList: floor1),
                        FloorPic(
                          floorPic: fp2,
                        ),
                        FloorContent(floorGoodsList: floor2),
                        FloorPic(
                          floorPic: fp3,
                        ),
                        FloorContent(floorGoodsList: floor3),
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
                    refreshHeader: ClassicsHeader(
                      key: _headerKeyGrid,
                      bgColor: Colors.white,
                      textColor: Colors.pink,
                      moreInfoColor: Colors.pink,
                    ),
                    onRefresh: () {},
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
            ),
          ),
        ));
  }

  void _remove(context) {
    ov.remove();
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
          return InkWell(
            child: Image.network("${swiperDataList[index]['image']}",
                fit: BoxFit.fill),
            onTap: () {
              Application.router.navigateTo(
                  context, '/detail?id=${swiperDataList[index]['goodsId']}',
                  transition: TransitionType.fadeIn);
            },
          );
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
    return Container(
      padding: EdgeInsets.all(5),
      width: MediaQuery.of(context).size.width / 5,
      child: InkWell(
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
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      // height: ScreenUtil().setHeight(320),
      child: Wrap(
        //  physics: new NeverScrollableScrollPhysics(),
        // crossAxisCount: 5,
        //padding: EdgeInsets.all(4.0),
        children: navigatorList.map((item) {
          return _gridViewItemUI(context, item);
        }).toList(),
      ),
    );
  }

  void jump(str, BuildContext context) {
    switch (str) {
      case "白酒":
        Navigator.of(context).pushAndRemoveUntil(
            MaterialPageRoute(
                builder: (context) => IndexPage(
                      item: 0,
                      index: 1,
                    )),
            (route) => route == null);
        break;
      case "啤酒":
        Navigator.of(context).pushAndRemoveUntil(
            MaterialPageRoute(
                builder: (context) => IndexPage(
                      item: 1,
                      index: 1,
                    )),
            (route) => route == null);
        break;
      case "葡萄酒":
        Navigator.of(context).pushAndRemoveUntil(
            MaterialPageRoute(
                builder: (context) => IndexPage(
                      item: 2,
                      index: 1,
                    )),
            (route) => route == null);
        break;
      case "清酒洋酒":
        Navigator.of(context).pushAndRemoveUntil(
            MaterialPageRoute(
                builder: (context) => IndexPage(
                      item: 3,
                      index: 1,
                    )),
            (route) => route == null);
        break;
      case "保健酒":
        Navigator.of(context).pushAndRemoveUntil(
            MaterialPageRoute(
                builder: (context) => IndexPage(
                      item: 4,
                      index: 1,
                    )),
            (route) => route == null);
        break;
      case "预调酒":
        Navigator.of(context).pushAndRemoveUntil(
            MaterialPageRoute(
                builder: (context) => IndexPage(
                      item: 5,
                      index: 1,
                    )),
            (route) => route == null);
        break;
      case "下酒小菜":
        Navigator.of(context).pushAndRemoveUntil(
            MaterialPageRoute(
                builder: (context) => IndexPage(
                      item: 6,
                      index: 1,
                    )),
            (route) => route == null);
        break;
      case "饮料":
        Navigator.of(context).pushAndRemoveUntil(
            MaterialPageRoute(
                builder: (context) => IndexPage(
                      item: 7,
                      index: 1,
                    )),
            (route) => route == null);
        break;
      case "乳制品":
        Navigator.of(context).pushAndRemoveUntil(
            MaterialPageRoute(
                builder: (context) => IndexPage(
                      item: 8,
                      index: 1,
                    )),
            (route) => route == null);
        break;
      case "休闲零食":
        Navigator.of(context).pushAndRemoveUntil(
            MaterialPageRoute(
                builder: (context) => IndexPage(
                      item: 9,
                      index: 1,
                    )),
            (route) => route == null);
        break;
    }
  }
}

class AdBanner extends StatelessWidget {
  final String adPicture;

  AdBanner({Key key, this.adPicture}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return InkWell(
      child: Image.network(adPicture),
      onTap: () {
        Navigator.of(context)
            .push(MaterialPageRoute(builder: (BuildContext ctx) {
          return FujiPage();
        }));
      },
    );
  }
}

class LeaderView extends StatelessWidget {
  final Map leaderInfo;

  LeaderView({Key key, this.leaderInfo}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    saveInSp(leaderInfo['leaderPhone']);
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
      onTap: () {
        //todo
        var goodid = item['goodsId'];
        jump(context, goodid);
      },
      child: SingleChildScrollView(
        physics: new NeverScrollableScrollPhysics(),
        child: Container(
          width: MediaQuery.of(context).size.width / 3,
          child: Column(
            children: <Widget>[
              Image.network(
                item['image'],
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
          decoration: BoxDecoration(
            border: Border(
              left: BorderSide(color: Colors.black12, width: 1),
              right: BorderSide(color: Colors.black12, width: 1),
            ),
          ),
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
          margin: EdgeInsets.only(left: 5),
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
          child: Wrap(
            //     physics: new NeverScrollableScrollPhysics(),
            //        crossAxisCount: 3,
            children: recommendList.map((item) {
              return _gridViewItemUI(context, item);
            }).toList(),
          ),
          //        height: ScreenUtil().setHeight(300),
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
          Navigator.of(context).pushAndRemoveUntil(
              MaterialPageRoute(
                  builder: (context) => IndexPage(
                        item: floorPic['TO_PLACE'] == '4'
                            ? 0
                            : floorPic['TO_PLACE'] != '4' ? 0 : 1,
                        index: 1,
                      )),
              (route) => route == null);
        },
      ),
    );
  }
}

class Floor extends StatelessWidget {
  List<Map> floor;

  Floor({Key key, this.floor}) : super(key: key);

  void jumpDetail(context, String goodsid) {
    jump(context, goodsid);
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

  final Function show;

  final Map adaData;

  OverlayEntry ov;

  MiddleAd(
      {Key key,
      this.saoma,
      this.integralMallPic,
      this.newUser,
      this.show,
      this.adaData})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    ov = new OverlayEntry(builder: (context) {
      return AdaWidget(
        remove: _remove,
        map: adaData,
        appC: context,
      );
    });
    return Container(
      child: SingleChildScrollView(
          physics: new NeverScrollableScrollPhysics(),
          scrollDirection: Axis.horizontal,
          child: Row(
            children: <Widget>[
              InkWell(
                onTap: () {
                  Navigator.of(context)
                      .push(MaterialPageRoute(builder: (BuildContext ctx) {
                    return FujiPage();
                  }));
                },
                child: Container(
                  width: MediaQuery.of(context).size.width / 3,
                  child: Image.network(saoma),
                ),
              ),
              InkWell(
                child: Container(
                  width: MediaQuery.of(context).size.width / 3,
                  child: Image.network(integralMallPic),
                ),
                onTap: () {
                  Navigator.of(context)
                      .push(MaterialPageRoute(builder: (BuildContext ctx) {
                    return ShopInfoPage();
                  }));
                },
              ),
              InkWell(
                child: Container(
                  width: MediaQuery.of(context).size.width / 3,
                  child: Image.network(newUser),
                ),
                onTap: () {
                  showDialog<Null>(
                      context: context,
                      barrierDismissible: false,
                      builder: (BuildContext context) {
                        return AdaWidget(
                          map: adaData,
                          remove: (context) {
                            Navigator.pop(context);
                          },
                        );
                      });
                },
              ),
            ],
          )),
    );
  }

  void _remove(context) {
    ov.remove();
  }

//  _show() {
//    if (adaData != null) {
//      return Center(
//        child: AdaWidget(
//          map: adaData,
//        ),
//      );
//    }
//  }
}

//楼层商品组件
class FloorContent extends StatelessWidget {
  final List floorGoodsList;

  FloorContent({Key key, this.floorGoodsList}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        children: <Widget>[_firstRow(context), _otherGoods(context)],
      ),
    );
  }

  Widget _firstRow(context) {
    return Row(
      children: <Widget>[
        _goodsItem(context, floorGoodsList[0]),
        Column(
          children: <Widget>[
            _goodsItem(context, floorGoodsList[1]),
            _goodsItem(context, floorGoodsList[2]),
          ],
        )
      ],
    );
  }

  Widget _otherGoods(context) {
    return Row(
      children: <Widget>[
        _goodsItem(context, floorGoodsList[3]),
        _goodsItem(context, floorGoodsList[4]),
      ],
    );
  }

  Widget _goodsItem(context, Map goods) {
    return Container(
      width: ScreenUtil().setWidth(375),
      child: InkWell(
        onTap: () {
          Application.router
              .navigateTo(context, "/detail?id=${goods['goodsId']}");
        },
        child: Image.network(goods['image']),
      ),
    );
  }
}
