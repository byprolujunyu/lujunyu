import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class AdaWidget extends StatelessWidget {
  final Map map;

  AdaWidget({this.map});

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return new Material(
      //创建透明层
      type: MaterialType.transparency, //透明类型
      child: new Center(
        //保证控件居中效果
        child: Container(
          child: SizedBox(
            width: ScreenUtil().setWidth(500),
            height: ScreenUtil().setHeight(500),
            child: Column(
              children: <Widget>[
                Container(
                    width: ScreenUtil().setWidth(410),
                    height: ScreenUtil().setHeight(480),
                    child: Image.network('${map['PICTURE_ADDRESS']}')),
                Container(
                  margin:EdgeInsets.all(20.0),
                  width: ScreenUtil().setWidth(80),
                  height: ScreenUtil().setHeight(80),
                  child: Image.asset('images/close.png'),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
