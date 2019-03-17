import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class AdaWidget extends StatelessWidget {
  final Map map;
  final Function(BuildContext context) remove;

  final BuildContext appC;

  AdaWidget({this.map, this.remove, this.appC});

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return MaterialApp(
      darkTheme: ThemeData.dark(),
      debugShowCheckedModeBanner: false,
      home: new Material(
        //theme: Theme.of(context, shadowThemeOnly: true),
        //创建透明层
        type: MaterialType.transparency,
        //透明类型
        child: new Center(
          //保证控件居中效果
          child: Opacity(
            opacity: 1,
            child: Container(
              child: SizedBox(
                width: ScreenUtil().setWidth(700),
                height: ScreenUtil().setHeight(700),
                child: Column(
                  children: <Widget>[
                    Container(
                        width: ScreenUtil().setWidth(410),
                        height: ScreenUtil().setHeight(480),
                        child: Image.network('${map['PICTURE_ADDRESS']}')),
                    GestureDetector(
                      child: Container(
                        margin: EdgeInsets.all(20.0),
                        width: ScreenUtil().setWidth(80),
                        height: ScreenUtil().setHeight(80),
                        child: Image.asset('images/close.png'),
                      ),
                      onTap: () {
                        remove(context);
                      },
                    ),
                  ],
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
