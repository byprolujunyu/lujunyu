import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:flutter_button/constants/index.dart';
import 'package:flutter_button/detail/datail_page_new.dart';
import 'package:flutter_button/detail/detail_page.dart';
import 'package:flutter_button/fuji/youhui_pic.dart';
import 'package:flutter_button/page/category_page.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_button/page/seracher.dart';
import 'package:flutter_button/shop/shop_info.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_button/widget/ada_widget.dart';
import '../service/service_method.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_swiper/flutter_swiper.dart';
import 'package:flutter_easyrefresh/easy_refresh.dart';

class OrderCenterPage extends StatefulWidget {
  final int index;

  OrderCenterPage({this.index = 0});

  @override
  _OrderCenterPageState createState() => _OrderCenterPageState();
}

class _OrderCenterPageState extends State<OrderCenterPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('订单中心'),
        elevation: 0.0,
      ),
      body: DefaultTabController(
        length: 5,
        initialIndex: widget.index,
        child: Column(
          children: <Widget>[
            KTabBarWidget(),
            Expanded(
              child: TabBarView(
                children: <Widget>[
                  Center(
                    child: Text('全部'),
                  ),
                  Center(
                    child: Text('待付款'),
                  ),
                  Center(
                    child: Text('待发货'),
                  ),
                  Center(
                    child: Text('待收货'),
                  ),
                  Center(
                    child: Text('待评价'),
                  ),
                ],
              ),
            )
          ],
        ),
      ),
    );
  }
}

class KTabBarWidget extends StatelessWidget implements PreferredSizeWidget {
  get preferredSize {
    return Size.fromHeight(30);
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      width: MediaQuery.of(context).size.width,
      child: TabBar(
          indicatorColor: KColorConstant.themeColor,
          indicatorSize: TabBarIndicatorSize.label,
          isScrollable: true,
          labelColor: KColorConstant.themeColor,
          tabs: KString.ordertabs
              .map((i) => Container(
                    width: MediaQuery.of(context).size.width / 5,
                    height: 30.0,
                    child: new Tab(text: i),
                  ))
              .toList()),
    );
  }
}
