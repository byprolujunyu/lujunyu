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

class SearchP extends StatefulWidget {
  final String text;

  SearchP({this.text});

  @override
  _SearchPState createState() => _SearchPState();
}

class _SearchPState extends State<SearchP> {
  GlobalKey<RefreshHeaderState> _headerKeyGrid =
      new GlobalKey<RefreshHeaderState>();
  GlobalKey<RefreshFooterState> _footerKeyGrid =
      new GlobalKey<RefreshFooterState>();

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _getSerachGoods();
  }

  //火爆商品接口
  void _getSerachGoods() {
    var formPage = {"text": "酒", "page": page, "category": ""};
    request('searachGoods', formData: formPage).then((val) {
      var data = json.decode(val.toString());
      List<Map> newGoodsList = (data['data'] as List).cast();
      setState(() {
        ms.addAll(newGoodsList);
        page++;
      });
    });
  }

  Map mapToMap2(Map m) {
    Map newM = Map();
    newM.putIfAbsent("goodsName", () => m['goodsName']);
    newM.putIfAbsent("image", () => m['image']);
    newM.putIfAbsent("presentPrice", () => m['PRESENT_PRICE']);
    newM.putIfAbsent("oriPrice", () => m['price']);
    newM.putIfAbsent("goodsId", () => m['goodsId']);
    return newM;
  }

  Widget _wrapList() {
    if (ms.length != 0) {
      List<Widget> listWidget = ms.map((val) {
        return InkWell(
            onTap: () {
              var map = mapToMap2(val);
              Navigator.of(context)
                  .push(MaterialPageRoute(builder: (BuildContext ctx) {
                return DetailPage(
                  map: map,
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
                    val['goodsName'],
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                    style: TextStyle(
                        color: Colors.pink, fontSize: ScreenUtil().setSp(26)),
                  ),
                  Row(
                    children: <Widget>[
                      Text('￥${val['PRESENT_PRICE']}'),
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

      return Loading();
    }
  }

  List<Map> ms = [];

  int page = 1;

  //火爆专区组合
  Widget _seracherGoods() {
    return Container(
        child: Column(
      children: <Widget>[
        _wrapList(),
      ],
    ));
  }

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);

    return Scaffold(
      appBar: AppBar(
        title: Text('搜索'),
        elevation: 0.0,
      ),
      body: EasyRefresh(
        child: ListView(
          children: <Widget>[
            Center(
              child: Text('搜索'),
            ),
            _seracherGoods(),
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
          _getSerachGoods();
        },
      ),
    );
  }
}
