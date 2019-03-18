import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_bilibili/page/demo.dart';
import 'package:flutter_bilibili/page/index_page.dart';
import 'package:flutter_bilibili/page/my_page.dart';

void main() {

  SystemChrome.setPreferredOrientations(
      [DeviceOrientation.portraitUp, DeviceOrientation.portraitDown]);
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: MyPage(),
      theme: ThemeData(primaryColor: Colors.pink),
    );
  }
}
