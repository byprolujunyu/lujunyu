import 'package:amap_base/amap_base.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_button/db/db_helper.dart';
import 'package:flutter_button/model/cart_model.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_button/pageOne.dart';
import 'package:flutter_button/widget/loading.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter/services.dart';
import 'package:flutter/cupertino.dart';

void main() async {
  SystemChrome.setPreferredOrientations(
      [DeviceOrientation.portraitUp, DeviceOrientation.portraitDown]);
  await AMap.init('377b8601bba3d52ee19734f80c6829fa');
  runApp(MyApp());
}


class MyApp extends StatelessWidget {
  showLoadingPage() {
    return Scaffold(
      body: LoadingPage(),
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: showLoadingPage(),
      theme: ThemeData(primaryColor: Colors.pink),
    );
  }
}
