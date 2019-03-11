//app的loading页面

import 'package:flutter/material.dart';
import 'package:flutter_button/page/index_main.dart';


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
        vsync: this, duration: Duration(milliseconds: 3000));
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

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Image.asset(
'images/bg_loading.jpg',
        fit: BoxFit.fill,
      ),
    );
  }
}
