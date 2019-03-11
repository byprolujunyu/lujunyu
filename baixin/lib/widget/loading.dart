//app的loading页面

import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class LoadingPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return LoadingPageState();
  }
}

class LoadingPageState extends State<LoadingPage>
    with TickerProviderStateMixin {
  AnimationController _animationController;
  Animation<double> alpha;
  var _animationStateListener;

  @override
  void initState() {
    super.initState();
    _animationController = AnimationController(
        vsync: this, duration: Duration(milliseconds: 5000));
    _animationStateListener = (status) {
      if (status == AnimationStatus.completed) {
        //动画结束时跳转新页面
        Navigator.of(context).pushAndRemoveUntil(
            MaterialPageRoute(builder: (context) => IndexPage()),
            (route) => route == null);
      }
    };
    _animationController
        .addStatusListener((status) => _animationStateListener(status));
    _animationController.forward();
  }

  @override
  void dispose() {
    super.dispose();
    _animationController.dispose();
  }


  /// 倒计时的计时器。
  Timer _timer;
  /// 当前倒计时的秒数。
  int _seconds;

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return Stack(
      children: <Widget>[
        Container(
          width: MediaQuery.of(context).size.width,
          height: MediaQuery.of(context).size.height,
          child: Image.asset(
            'images/bg_loading.jpg',
            fit: BoxFit.fill,
          ),
        ),
        Container(
          alignment: Alignment.center,
          height: ScreenUtil().setHeight(50),
          width: ScreenUtil().setWidth(100),
          decoration: new BoxDecoration(color: Colors.black38),
          child: InkWell(
            child: Text(
              '跳过',
              style: TextStyle(color: Colors.white),
            ),

            onTap: (){
              Navigator.of(context)
                  .push(MaterialPageRoute(builder: (BuildContext ctx) {
                return IndexPage();
              }));
            },
          ),
        ),
      ],
      alignment: FractionalOffset(0.9, 0.1),
    );
  }
}
