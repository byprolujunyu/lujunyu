import 'package:flutter/material.dart';
import 'package:flutter_trip/constants/index.dart';
import 'package:flutter_trip/pages/home_page.dart';
import 'package:flutter_trip/pages/my_page.dart';
import 'package:flutter_trip/pages/search_page.dart';
import 'package:flutter_trip/pages/travel_page.dart';

class TabNavigator extends StatefulWidget {
  @override
  _TabNavigatorState createState() => _TabNavigatorState();
}

class _TabNavigatorState extends State<TabNavigator> {
  final PageController _controller = PageController(
    initialPage: 0,
  );

  int currentIndex = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: PageView(
        controller: _controller,
        children: <Widget>[
          HomePage(),
          SearchPage(),
          TravelPage(),
          MyPage(),
        ],
      ),
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: currentIndex,
        onTap: (index){
          _controller.jumpToPage(index);
          setState(() {
            currentIndex = index;
          });
        },
        type: BottomNavigationBarType.fixed,
        items: [
          BottomNavigationBarItem(
            icon: Icon(
              Icons.home,
              color: KColorConstant.defeultColor,
            ),
            activeIcon: Icon(
              Icons.home,
              color: KColorConstant.activeColor,
            ),
            title: Text(
              KString.homeTxt,
              style: TextStyle(
                  color: currentIndex != 0
                      ? KColorConstant.defeultColor
                      : KColorConstant.activeColor),
            ),
          ),
          BottomNavigationBarItem(
            icon: Icon(
              Icons.search,
              color: KColorConstant.defeultColor,
            ),
            activeIcon: Icon(
              Icons.search,
              color: KColorConstant.activeColor,
            ),
            title: Text(
              KString.searchTxt,
              style: TextStyle(
                  color: currentIndex != 1
                      ? KColorConstant.defeultColor
                      : KColorConstant.activeColor),
            ),
          ),
          BottomNavigationBarItem(
            icon: Icon(
              Icons.camera_alt,
              color: KColorConstant.defeultColor,
            ),
            activeIcon: Icon(
              Icons.camera_alt,
              color: KColorConstant.activeColor,
            ),
            title: Text(
              KString.travelTxt,
              style: TextStyle(
                  color: currentIndex != 2
                      ? KColorConstant.defeultColor
                      : KColorConstant.activeColor),
            ),
          ),
          BottomNavigationBarItem(
            icon: Icon(
              Icons.account_circle,
              color: KColorConstant.defeultColor,
            ),
            activeIcon: Icon(
              Icons.account_circle,
              color: KColorConstant.activeColor,
            ),
            title: Text(
              KString.myTxt,
              style: TextStyle(
                  color: currentIndex != 3
                      ? KColorConstant.defeultColor
                      : KColorConstant.activeColor),
            ),
          ),
        ],
      ),
    );
  }
}
