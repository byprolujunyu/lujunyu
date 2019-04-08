import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:flutter_button/constants/index.dart';
import 'package:flutter_button/detail/datail_page_new.dart';
import 'package:flutter_button/detail/detail_page.dart';
import 'package:flutter_button/fuji/fuji_pic_list_widget.dart';
import 'package:flutter_button/fuji/fuji_pic_widget.dart';
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
class FujiLList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    FutureBuilder(
        future: _getBackInfo(context),
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            return  Column(
                children: <Widget>[
                  FujiPicListWidget(),
                ],
            );
          } else {
            return Center(
              child: Loading(),
            );
          }
        });
  }

  Future _getBackInfo(BuildContext context) async {
    await Provide.value<FujiListProvide>(context).getRequest('da290bbcbcff4c1dbd662e15d5808150',1);
    return '完成加载';
  }
}
