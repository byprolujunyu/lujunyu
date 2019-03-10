import 'package:flutter/material.dart';
import 'package:flutter_button/constants/index.dart';

class KTabBarWidget extends StatelessWidget implements PreferredSizeWidget {
  get preferredSize {
    return Size.fromHeight(30);
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.only(top:20),
      color: Colors.white,
      width: MediaQuery.of(context).size.width,
      child: TabBar(
          indicatorColor: KColorConstant.themeColor,
          indicatorSize: TabBarIndicatorSize.label,
          isScrollable: true,
          labelColor: KColorConstant.themeColor,
          tabs: KString.tabs
              .map((i) => Container(
                    width: MediaQuery.of(context).size.width/2,
                    height: 30.0,
                    child: new Tab(text: i),
                  ))
              .toList()),
    );
  }
}
