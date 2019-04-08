import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:flutter_button/constants/index.dart';
import 'package:flutter_button/detail/datail_page_new.dart';
import 'package:flutter_button/detail/detail_page.dart';
import 'package:flutter_button/fuji/fuji_list.dart';
import 'package:flutter_button/fuji/fuji_pic_widget.dart';
import 'package:flutter_button/fuji/youhui_pic.dart';
import 'package:flutter_button/page/category_page.dart';
import 'package:flutter_button/page/seracher.dart';
import 'package:flutter_button/provide/fujilist_provide.dart';
import 'package:flutter_button/shop/shop_info.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_button/widget/ada_widget.dart';
import 'package:provide/provide.dart';
import '../service/service_method.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_swiper/flutter_swiper.dart';
import 'package:flutter_easyrefresh/easy_refresh.dart';

class FujiPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          '领取优惠券',
        ),
        elevation: 0.0,
      ),
      body: ListView(
         children: <Widget>[
           FujiPicPage(),
          // FujiLList(),
         ],
      ),
    );
  }
}
