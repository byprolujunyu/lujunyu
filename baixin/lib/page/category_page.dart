import 'package:flutter/material.dart';
import 'dart:io';
import 'package:dio/dio.dart';
import 'package:flutter/services.dart';
import 'package:flutter_button/detail/datail_page_new.dart';
import 'package:flutter_button/detail/detail_page.dart';
import 'package:flutter_button/model/categoryGoods.dart';
import 'package:flutter_button/provide/category_goods_list.dart';
import 'package:flutter_button/provide/child_category.dart';
import 'package:flutter_button/routers/application.dart';
import 'package:flutter_button/service/service_method.dart';
import 'package:flutter_easyrefresh/easy_refresh.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:provide/provide.dart';
import 'dart:async';
import 'dart:convert';
import "package:pull_to_refresh/pull_to_refresh.dart";
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_button/config/service_url.dart';

class CategoryPage extends StatefulWidget {
  int item;

  CategoryPage({Key key, this.item}) : super(key: key);

  @override
  _CategoryPageState createState() => _CategoryPageState();
}

class _CategoryPageState extends State<CategoryPage> {
  List categoryList; // 第一级导航
  List secondCategoryList; //第二级导航
  int firstCategoryIndex = 0; //一级导航的索引
  int secondCategoryIndex = 0; //二级导航菜单
  String categoryId; //选中的一级分类的ID
  String categorySubId = ""; //选中的二级分类ID
  int page = 1; //现在商品的页数
  List goodList = []; //商品的列表
  RefreshController _refreshController;
  int isDioCount = 0;
  bool isLoad = true;
  static const query = const MethodChannel("cart/query");

  @override
  void initState() {
    super.initState();

    categoryList = [];
    secondCategoryList = [];
    _refreshController = new RefreshController();
  }

  void _getCategory() async {
    try {
      if (isDioCount < 1) {
        print('类别请求开始==============>');
        Response response;
        Dio dio = new Dio();
        dio.options.contentType =
            ContentType.parse("application/x-www-form-urlencoded");
        response = await dio.post(servicePath['getCategory']);
        if (response.statusCode == 200) {
          var data = json.decode(response.data);

          setState(() {
            categoryList = (data['data'] as List).cast();
            isDioCount++;
            categoryId = categoryList[0]['mallCategoryId'];
          });
          //得到二级分类列表
          if (secondCategoryList.length <= 0) {
            _changeSecondCategory(categoryList[0]['bxMallSubDto']);
            _getGoodsList();
          }

          firstCategoryIndex = widget.item;
          jumo(firstCategoryIndex);
        } else {
          throw Exception('Faild to laod post');
        }
      }
    } catch (e) {
      return print(e);
    }
  }

  //左侧导航菜单的返回方法
  Widget _leftNavBar(BuildContext context) {
    _getCategory();

    if (categoryList.length <= 0) {
      return Center(
        child: Text('加载中'),
      );
    } else {
      return Container(
        width: ScreenUtil().setWidth(180),
        height: ScreenUtil().setHeight(1794),
        decoration: BoxDecoration(
            color: Colors.white,
            border: Border(right: BorderSide(width: 1, color: Colors.black12))),
        child: ListView.builder(
          itemCount: categoryList.length,
          itemBuilder: (context, index) {
            return _leftInkWell(index);
          },
        ),
      );
    }
  }

  static const MethodChannel jump = MethodChannel("detail/jump");

  Future _jumpFun(json) async {
    await jump.invokeMethod('jump', json);
  }

  //得到商品列表数据的方法
  void _getGoodsList() {
    _refreshController.sendBack(true, RefreshStatus.idle);
    if (isLoad) {
      try {
        setState(() {
          isLoad = false;
        });

        Future(() async {
          Response response;
          Dio dio = new Dio();
          dio.options.contentType =
              ContentType.parse("application/x-www-form-urlencoded");
          var dataPara = {
            'categoryId': categoryId,
            'categorySubId': categorySubId,
            'page': page
          };
          response =
              await dio.post(servicePath['getMallGoods'], data: dataPara);
          print(response);
          if (response.statusCode == 200) {
            var data = json.decode(response.data);
            if (data['data'] != null) {
              //判断是否还有数据
              List<Map> newGoodsList = (data['data'] as List).cast();

              setState(() {
                goodList.addAll(newGoodsList);
              });
              page++;
              _refreshController.sendBack(false, RefreshStatus.canRefresh);
            } else {
              //没有更多数据了，把样式进行设置
              _refreshController.sendBack(false, RefreshStatus.noMore);
            }
          } else {
            _refreshController.sendBack(false, RefreshStatus.completed);
            throw Exception('Falid to laod post');
          }
        }).then((val) {
          setState(() {
            isLoad = true;
          });
        });
      } catch (e) {
        _refreshController.sendBack(false, RefreshStatus.completed);
        return print('ERROR:==============>${e}');
      }
    } else {
      return print('没有加载......');
    }
  }

  //商品列表，使用了上拉加载更多

  Widget _goodsList() {
    //需要放置一个带有宽高的容器
    return Container(
      width: ScreenUtil().setWidth(569),
      height: ScreenUtil().setHeight(1007),
      child: SmartRefresher(
          enablePullDown: false,
          enablePullUp: true,
          controller: _refreshController,
          onRefresh: _onRefresh,
          onOffsetChange: _onOffsetCallback,
          enableOverScroll: isLoad,
          child: ListView(
            children: goodList.map((item) {
              return _goodsItem(item);
            }).toList(),
          )),
    );
  }

  Future netWork(String goodId) async {
    Response response;
    Dio dio = new Dio();
    dio.options.contentType =
        ContentType.parse("application/x-www-form-urlencoded");
    var formData = {'goodId': goodId};
    response =
        await dio.post(servicePath['shopGoodsDetailImg'], data: formData);
    if (response.statusCode == 200) {
      return json.decode(response.data);
    }
  }

  Widget _goodsItem(Map goodsItem) {
    return Container(
      // height: ScreenUtil().setHeight(200),

      child: InkWell(
        onTap: () {
          var id = goodsItem['goodsId'];
          Application.router.navigateTo(context, '/detail?id=$id');
        },
        child: Container(
          color: Colors.white,
          child: Column(
            children: <Widget>[
              SingleChildScrollView(
                child: Row(
                  children: <Widget>[
                    Container(
                      margin: EdgeInsets.only(left: 10),
                      width: ScreenUtil().setWidth(180),
                      height: ScreenUtil().setHeight(180),
                      child: Image.network(
                        '${goodsItem['image']}',
                        fit: BoxFit.fill,
                      ),
                    ),
                    Container(
                      child: Column(
                        children: <Widget>[
                          Container(
                            width: ScreenUtil().setWidth(300),
                            child: Text(
                              goodsItem['goodsName'],
                              maxLines: 2,
                              overflow: TextOverflow.ellipsis,
                              style:
                                  TextStyle(fontSize: ScreenUtil().setSp(30)),
                            ),
                          ),
                          Container(
                            width: ScreenUtil().setWidth(370),
                            margin: EdgeInsets.only(
                              top: 20,
                            ),
                            child: Row(
                              children: <Widget>[
                                Text(
                                  "价格：￥${goodsItem['presentPrice']}",
                                  style: TextStyle(
                                      color: Colors.pink,
                                      fontSize: ScreenUtil().setSp(30)),
                                ),
                                Text(
                                  "￥${goodsItem['oriPrice']}",
                                  style: TextStyle(
                                      color: Colors.black26,
                                      decoration: TextDecoration.lineThrough),
                                )
                              ],
                            ),
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
                scrollDirection:Axis.horizontal,
              ),
              Divider(
                height: 5,
                color: Colors.black26,
              )
            ],
          ),
        ),
      ),
    );
  }

  //上拉回掉方法
  void _onOffsetCallback(bool isUp, double offset) {
    if (isUp) {
      _refreshController.sendBack(true, RefreshStatus.idle);
    } else {
      if (page > 1) {
        _getGoodsList();
      } else {
        _refreshController.sendBack(true, RefreshStatus.idle);
      }
    }
  }

  //下拉刷新
  void _onRefresh(bool up) {}

  //一级导航菜单，分离出来，为了实现点击高亮显示
  Widget _leftInkWell(int index) {
    bool isClick = false;
    //对比自己的索引和选中的索引是不是一个，如果是就要高亮显示
    //如果不是就不高亮显示
    if (index == firstCategoryIndex) {
      isClick = true;
    }
    return InkWell(
      onTap: () {
        jumo(index);
      },
      child: Container(
        height: ScreenUtil().setHeight(100),
        padding: EdgeInsets.only(left: 10, top: 20),
        child: Container(
          child: SingleChildScrollView(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Text(
                  '${categoryList[index]['mallCategoryName']}',
                  style: TextStyle(fontSize: 16),
                ),
                Container(
                  height: ScreenUtil().setHeight(10),
                ),
              ],
            ),
          ),
        ),
        decoration: BoxDecoration(
            color: isClick ? Color.fromRGBO(244, 245, 245, 1.0) : Colors.white,
            border:
                Border(bottom: BorderSide(width: 1, color: Colors.black12))),
      ),
    );
  }

  void jumo(int index) {
    isLoad = true;
    _refreshController.sendBack(false, RefreshStatus.idle);
    setState(() {
      categoryId = categoryList[index]['mallCategoryId'];
      categorySubId = "";
      page = 1;
      firstCategoryIndex = index;
      goodList = [];
      secondCategoryIndex = 0;
      _changeSecondCategory(categoryList[index]['bxMallSubDto']);
      _getGoodsList();
    });
  }

  //改变二级菜单状态的方法
  void _changeSecondCategory(List newList) {
    if (newList[0]['mallSubName'] != '全部') {
      setState(() {
        Map newMap = {'mallSubName': '全部', 'mallSubId': ''};
        newList.insert(0, newMap);
        secondCategoryList = newList;
      });
    } else {
      setState(() {
        secondCategoryList = newList;
      });
    }
  }

  //右侧小类导航菜单
  Widget _rightNavBar(BuildContext context) {
    if (secondCategoryList.length <= 0) {
      return Text('正在加载');
    } else {
      return Container(
        width: ScreenUtil().setWidth(569),
        height: ScreenUtil().setHeight(80),
        decoration: BoxDecoration(
            color: Colors.white,
            border:
                Border(bottom: BorderSide(width: 1, color: Colors.black12))),
        child: ListView.builder(
          scrollDirection: Axis.horizontal,
          itemCount: secondCategoryList.length,
          itemBuilder: (context, index) {
            return _rightInkWell(index, secondCategoryList);
          },
        ),
      );
    }
  }

  Widget _rightInkWell(int index, List secondCategoryList) {
    bool isClick = false;

    if (index == secondCategoryIndex) {
      isClick = true;
    }

    return InkWell(
      onTap: () {
        _refreshController.sendBack(false, RefreshStatus.idle);
        setState(() {
          isLoad = true;
          secondCategoryIndex = index;
          categorySubId = secondCategoryList[index]['mallSubId'];
          page = 1;
          goodList = [];
          _getGoodsList();
        });
      },
      child: Container(
          decoration: BoxDecoration(
              color:
                  isClick ? Color.fromRGBO(244, 245, 245, 1.0) : Colors.white,
              border:
                  Border(right: BorderSide(width: 1, color: Colors.black12))),
          height: ScreenUtil().setHeight(80),
          width: ScreenUtil().setWidth(140),
          child: Center(
            child: Text(secondCategoryList[index]['mallSubName']),
          )),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Scaffold(
        appBar: AppBar(
          title: Text('商品分类'),
          elevation: 0.0,
        ),
        backgroundColor: Color.fromRGBO(244, 245, 245, 1.0),
        body: Container(
          child: Row(
            children: <Widget>[
              _leftNavBar(context),
              SingleChildScrollView(
                child: Column(
                  children: <Widget>[_rightNavBar(context), _goodsList()],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

// 商品列表
class CatrgoryGoods extends StatefulWidget {
  _CatrgoryGoodsState createState() => _CatrgoryGoodsState();
}

class _CatrgoryGoodsState extends State<CatrgoryGoods> {
  GlobalKey<RefreshFooterState> _footerKey = GlobalKey<RefreshFooterState>();

  var scrollController = new ScrollController();

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Provide<CategoryGoodsProvide>(
      builder: (context, child, data) {
        try {
          if (Provide.value<ChildCategory>(context).page == 1) {
            // 列表位置置顶
            scrollController.jumpTo(0.0);
          }
        } catch (e) {
          // 第一次进入页面加载.......
          print("第一次初始化....${e}");
        }

        if (data.goodslist.length > 0) {
          return Expanded(
              child: Container(
                  width: ScreenUtil().setWidth(570),
                  child: EasyRefresh(
                    refreshFooter: ClassicsFooter(
                        key: _footerKey,
                        bgColor: Colors.white,
                        textColor: Colors.pink,
                        moreInfoColor: Colors.pink,
                        showMore: true,
                        noMoreText:
                            Provide.value<ChildCategory>(context).nomoreText,
                        moreInfo: '加载中',
                        loadReadyText: '上拉加载....'),
                    child: ListView.builder(
                      controller: scrollController,
                      itemCount: data.goodslist.length,
                      itemBuilder: (context, index) {
                        return _listItem(data.goodslist, index);
                      },
                    ),
                    loadMore: () async {
                      print("上拉加载更多.....");
                      _getMoreList();
                    },
                  )));
        } else {
          return Text("暂时没有数据......");
        }
      },
    );
  }

  void _getMoreList() async {
    Provide.value<ChildCategory>(context).addPage();

    var data = {
      'categoryId': Provide.value<ChildCategory>(context).categoryId,
      'categorySubId': Provide.value<ChildCategory>(context).subId,
      'page': Provide.value<ChildCategory>(context).page
    };

    await request('getMallGoods', formData: data).then((res) {
      var data = json.decode(res.toString());
      CategoryGoddsModel goodsList = CategoryGoddsModel.fromJson(data);
      if (goodsList.data == null) {
        Fluttertoast.showToast(
            msg: "已经到底了.",
            toastLength: Toast.LENGTH_SHORT,
            gravity: ToastGravity.BOTTOM,
            backgroundColor: Colors.pink,
            textColor: Colors.white);
        Provide.value<ChildCategory>(context).changeNomore("没有更多了.....");
      } else {
        Provide.value<CategoryGoodsProvide>(context)
            .getMoreList(goodsList.data);
      }
    });
  }

  Widget _goodsImage(List newList, int index) {
    return Container(
      width: ScreenUtil().setWidth(200),
      child: Image.network(newList[index].image),
    );
  }

  Widget _goodsName(List newList, int index) {
    return Container(
      padding: EdgeInsets.all(5.0),
      width: ScreenUtil().setWidth(370),
      child: Text(
        newList[index].goodsName,
        maxLines: 2,
        overflow: TextOverflow.ellipsis,
        style: TextStyle(fontSize: ScreenUtil().setSp(28)),
      ),
    );
  }

  Widget _goodsPrise(List newList, int index) {
    return Container(
        width: ScreenUtil().setWidth(370),
        margin: EdgeInsets.only(
          top: 20,
        ),
        child: Row(
          children: <Widget>[
            Text(
              "价格：￥${newList[index].presentPrice}",
              style: TextStyle(
                  color: Colors.pink, fontSize: ScreenUtil().setSp(30)),
            ),
            Text(
              "￥${newList[index].oriPrice}",
              style: TextStyle(
                  color: Colors.black26,
                  decoration: TextDecoration.lineThrough),
            )
          ],
        ));
  }

  Widget _listItem(List newList, int index) {
    return InkWell(
      onTap: () {},
      child: Container(
        padding: EdgeInsets.only(top: 5.0, bottom: 5.0),
        decoration: BoxDecoration(
            color: Colors.white,
            border:
                Border(bottom: BorderSide(width: 1.0, color: Colors.black12))),
        child: InkWell(
          child: Row(
            children: <Widget>[
              _goodsImage(newList, index),
              Column(
                children: <Widget>[
                  _goodsName(newList, index),
                  _goodsPrise(newList, index)
                ],
              )
            ],
          ),
          onTap: () {
            // jumpDetail(context, newList[index].goodsId);
          },
        ),
      ),
    );
  }
}
