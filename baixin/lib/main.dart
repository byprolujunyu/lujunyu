import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter/services.dart';
import 'package:flutter/cupertino.dart';

void main() {
  //实例化数据库对象
  SystemChrome.setPreferredOrientations(
      [DeviceOrientation.portraitUp, DeviceOrientation.portraitDown]);
  runApp(MyApp());
}

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home:IndexPage(index: 0,),
      theme: ThemeData(primaryColor: Colors.pink),
    );
  }
}
