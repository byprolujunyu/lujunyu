import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_button/model/order_model.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import '../service/service_method.dart';
import '../constants/index.dart';
import 'package:flutter_easyrefresh/easy_refresh.dart';

class OrderAllPage extends StatefulWidget {
  String orderlx = "0";

  OrderAllPage({this.orderlx = "0"});

  @override
  _OrderAllPageState createState() => _OrderAllPageState();
}

class _OrderAllPageState extends State<OrderAllPage> {
  int page = 1;
  List<OrderItem> orderList = [];
String name;
  @override
  void initState() {
    _getOrderList();

    setState(() {

    });
    super.initState();
  }

  void _getOrderList() {
    var formData = {
      'userId': 'da290bbcbcff4c1dbd662e15d5808150',
      'state': '${widget.orderlx}',
      'currentPage': '$page'
    };
    request('getMyOrders', formData: formData).then((val) {
      var data = json.decode(val.toString());
      String jsonStr = val;
      print(data);
      var orderModel = OrderModel.fromJson(data);
      setState(() {
        orderList.addAll(orderModel.data);
        page++;
      });
    });
  }

  Widget _wrapList() {
    if (orderList.length != 0) {
      List<Widget> listWidget = orderList.map((val) {
        return Container(
          color: Colors.white,
          height: ScreenUtil().setHeight(700),
          child: Column(
            children: <Widget>[
              Container(
                margin: EdgeInsets.all(5),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    Container(child: Text(val.sHOPNAME),),
               //     Container(child: Text(),),
                  ],
                ),
              ),
            ],
          ),
        );
      }).toList();
      return Wrap(
        children: listWidget,
        spacing: 2,
      );
    } else {
      return Container();
    }
  }

  @override
  Widget build(BuildContext context) {
    return EasyRefresh(
      child: ListView(
        //padding: EdgeInsets.zero,
        children: <Widget>[
          _wrapList(),
        ],
      ),
      refreshFooter: ClassicsFooter(
          key: _footerKeyGrid,
          bgColor: Colors.white,
          textColor: Colors.pink,
          moreInfoColor: Colors.pink,
          showMore: true,
          noMoreText: '',
          loadText: '',
          //loadReadyText:'',
          loadingText: '',
          loadedText: '',
          moreInfo: '加载中',
          loadReadyText: '上拉加载....'),
      refreshHeader: ClassicsHeader(
        key: _headerKeyGrid,
        bgColor: Colors.white,
        textColor: Colors.pink,
        moreInfoColor: Colors.pink,
        moreInfo: '加载中',
        refreshReadyText: '下拉加载....',
        refreshText: '下拉加载....',
        refreshedText: '加载完成...',
      ),
      onRefresh: () {
        setState(() {
          page = 1;
          _getOrderList();
        });
      },
      loadMore: () async {
        _getOrderList();
      },
    );
  }

  GlobalKey<RefreshHeaderState> _headerKeyGrid =
      new GlobalKey<RefreshHeaderState>();
  GlobalKey<RefreshFooterState> _footerKeyGrid =
      new GlobalKey<RefreshFooterState>();
}
