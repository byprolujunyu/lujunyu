import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:flutter_button/constants/index.dart';
import 'package:flutter_button/detail/datail_page_new.dart';
import 'package:flutter_button/detail/detail_page.dart';
import 'package:flutter_button/page/category_page.dart';
import 'package:flutter_button/page/seracher.dart';
import 'package:flutter_button/shop/shop_info.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_button/widget/ada_widget.dart';
import '../service/service_method.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter_swiper/flutter_swiper.dart';
import 'package:flutter_easyrefresh/easy_refresh.dart';
import 'package:flutter_html/flutter_html.dart';

class AboutPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return Scaffold(
      appBar: AppBar(
        title: Text('关于商城'),
        elevation: 0.0,
      ),
      body: FutureBuilder(
          future: getAboutUsInfo(),
          builder: (context, snapshot) {
            if (snapshot.hasData) {
              var data = json.decode(snapshot.data.toString());
              print(data);

              return SingleChildScrollView(
                child: Html(
                  data: data['data'],
                ),
              );
            } else {
              return Center(
                child: Loading(),
              );
            }
          }),
    );
  }
}
