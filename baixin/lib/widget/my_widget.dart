import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class MyDivider extends StatelessWidget {
  final Color color;

  final double height;

  MyDivider({Key key, this.color, this.height}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: ScreenUtil.screenWidth,
      height: height,
      color: color,
      margin: EdgeInsets.only(top: 5.0, bottom: 5.0),
    );
  }
}