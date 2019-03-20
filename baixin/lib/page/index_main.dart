import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_button/page/cart_ios_page.dart';
import 'package:flutter_button/page/cart_test.dart';

import 'home_page.dart';
import 'category_page.dart';
import 'cart_page.dart';
import 'member_page.dart';

class IndexPage extends StatefulWidget {
  @override
  _IndexPageState createState() => _IndexPageState();

  int index = 0;
  int item = 0;

  IndexPage({Key key, this.index = 0, this.item = 0}) : super(key: key);
}

class _IndexPageState extends State<IndexPage> {
  List<Widget> _pagelist = [];

  int currentIndex = 0;
  var currentPage;

  PageController _pageController;

  @override
  void initState() {
    currentIndex = widget.index;
    var item = widget.item;

    _pagelist = [
      HomePage(),
      CategoryPage(
        item: item,
      ),
      CartIosPage(),
      MemberPage()
    ];
    currentPage = _pagelist[currentIndex];
    _pageController = new PageController()
      ..addListener(() {
        if (currentPage != _pageController.page.round()) {
          setState(() {
            currentPage = _pageController.page.round();
          });
        }
      });
    super.initState();
  }

  final List<BottomNavigationBarItem> bottomTabs = [
    BottomNavigationBarItem(icon: Icon(CupertinoIcons.home), title: Text('首页')),
    BottomNavigationBarItem(
        icon: Icon(CupertinoIcons.search), title: Text('分类')),
    BottomNavigationBarItem(
        icon: Icon(CupertinoIcons.shopping_cart), title: Text('购物车')),
    BottomNavigationBarItem(
        icon: Icon(CupertinoIcons.profile_circled), title: Text('会员中心')),
  ];

  List<Widget> _tabs = [
    Tab(
      text: '首页',
      icon: Icon(CupertinoIcons.home),
    ),
    Tab(
      text: '分类',
      icon: Icon(CupertinoIcons.search),
    ),
    Tab(
      text: '购物车',
      icon: Icon(CupertinoIcons.shopping_cart),
    ),
    Tab(
      text: '会员中心',
      icon: Icon(CupertinoIcons.profile_circled),
    ),
  ];

//   WillPopScope(
//          child: Scaffold(
//            backgroundColor: Color.fromRGBO(244, 245, 245, 1.0),
//            bottomNavigationBar: BottomNavigationBar(
//              type: BottomNavigationBarType.fixed,
//              currentIndex: currentIndex,
//              items: bottomTabs,
//              onTap: (index) {
//                setState(() {
//                  currentIndex = index;
//                  currentPage = _pagelist[currentIndex];
//                });
//              },
//            ),
//            body: currentPage,
//          ),
//          onWillPop: () {
//            print("pop");
//          });

  @override
  Widget build(BuildContext context) {
    return WillPopScope(
        child: Scaffold(
            backgroundColor: Color.fromRGBO(244, 245, 245, 1.0),
            bottomNavigationBar: BottomNavigationBar(
              type: BottomNavigationBarType.fixed,
              currentIndex: currentIndex,
              items: bottomTabs,
              onTap: (index) {
                setState(() {
                  currentIndex = index;
                  currentPage = _pagelist[currentIndex];
                });
              },
            ),
            body: IndexedStack(
              index: currentIndex,
              children: _pagelist,
            )),
        onWillPop: () {
          print("pop");
        });
  }
}
