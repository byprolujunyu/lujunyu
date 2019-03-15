import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class IndexTabBarDepartment extends StatefulWidget {
  @override
  _IndexTabBarDepartmentState createState() => _IndexTabBarDepartmentState();
}

class _IndexTabBarDepartmentState extends State<IndexTabBarDepartment>
    with TickerProviderStateMixin {
  final List myTabs = ['全部科室', '儿科', '皮肤科', '妇产科', '泌尿科', '神经科'];

  TabController _controller;

  void initState() {
    super.initState();
    _controller = TabController(length: myTabs.length, vsync: this);
  }

  @override
  void dispose() {
    // TODO: implement dispose
    _controller.dispose();
    super.dispose();
  }

  Widget tab() {

    try {
      return Column(
        children: <Widget>[
          TabBar(
            controller: _controller,
            isScrollable: true,
            labelColor: Color.fromRGBO(39, 196, 143, 1),
            unselectedLabelColor: Color.fromRGBO(69, 81, 84, 1),
            indicatorColor: Color.fromRGBO(39, 196, 143, 1),
            tabs: myTabs.map((v) {
              return Container(
                height: ScreenUtil.getInstance().setHeight(118),
                child: Center(
                  child: Text(v),
                ),
              );
            }).toList(),
          ),
          Expanded(
            child: TabBarView(
              controller: _controller,
              children: <Widget>[
                Container(
                  child: Text('data1'),
                ),

              ],
            ),
          )
        ],
      );
    } catch (e) {
      print(e);
    }
  }

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return tab();
  }
}
