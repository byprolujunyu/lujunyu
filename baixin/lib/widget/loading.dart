//app的loading页面

import 'dart:async';

import 'package:fluro/fluro.dart';
import 'package:flutter/material.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_button/routers/application.dart';
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
        jump(context);
      }
    };
    _animationController
        .addStatusListener((status) => _animationStateListener(status));
    _animationController.forward();

    _startTimer();
  }

  @override
  void dispose() {
    super.dispose();
    _animationController.dispose();

    _cancelTimer();
  }

  /// 倒计时的计时器。
  Timer _timer;

  /// 当前倒计时的秒数。
  int _seconds = 5;

  String _verifyStr = '';

  /// 启动倒计时的计时器。
  void _startTimer() {
    // 计时器（`Timer`）组件的定期（`periodic`）构造函数，创建一个新的重复计时器。
    _timer = Timer.periodic(Duration(seconds: 1), (timer) {
      if (_seconds == 0) {
        _cancelTimer();
        setState(() {});
        return;
      }
      _seconds--;
      setState(() {
        _verifyStr = '$_seconds';
      });
    });
  }

  /// 取消倒计时的计时器。
  void _cancelTimer() {
    // 计时器（`Timer`）组件的取消（`cancel`）方法，取消计时器。
    _timer?.cancel();
  }

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
          width: ScreenUtil().setWidth(150),
          decoration: new BoxDecoration(color: Colors.black38),
          child: InkWell(
            child: Text(
              '跳过 $_verifyStr 秒',
              style: TextStyle(color: Colors.white),
            ),
            onTap: () {
            jump(context);

            },
          ),
        ),
      ],
      alignment: FractionalOffset(0.9, 0.1),
    );
  }

  jump(context){
    var transition = (BuildContext context,
        Animation<double> animation,
        Animation<double> secondaryAnimation,
        Widget child) {
      return new ScaleTransition(
        scale: animation,
        child: new RotationTransition(
          turns: animation,
          child: child,
        ),
      );
    };
    Application.router.navigateTo(context, '/',
        replace: true,
        transition: TransitionType.custom,
        transitionBuilder: transition,
        transitionDuration: const Duration(milliseconds: 600));
  }
}
