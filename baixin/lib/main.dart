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

void main() {
  SystemChrome.setPreferredOrientations(
      [DeviceOrientation.portraitUp, DeviceOrientation.portraitDown]);
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  showLoadingPage() {
    return LoadingPage();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home:showLoadingPage(),
      theme: ThemeData(primaryColor: Colors.pink),
    );
  }
}

