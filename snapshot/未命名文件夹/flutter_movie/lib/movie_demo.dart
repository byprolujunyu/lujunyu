import 'package:flutter/material.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter_movie/movie/douyin_grid.dart';
import 'dart:convert';
import 'dart:io';
import 'movie_filter.dart';
import 'movie_creation.dart';
import 'local_movies.dart';
import 'movie/list.dart';

class MyMovie extends StatefulWidget {
  @override
  _MyMovieState createState() => _MyMovieState();
}

class _MyMovieState extends State<MyMovie> {
  List<Widget> _pagelist = [
    new MovieList(mt: 'in_theaters'),
    new MovieList(mt: 'coming_soon'),
    new MovieList(mt: 'top250'),
    new DouyinGrid(),
  ];
  List<Widget> _tabs = [
    Tab(
      text: '正在热映',
      icon: Icon(Icons.movie_filter),
    ),
    Tab(
      text: '即将上映',
      icon: Icon(Icons.movie_creation),
    ),
    Tab(
      text: 'Top250',
      icon: Icon(Icons.local_movies),
    ),
    Tab(
      text: '我的抖音',
      icon: Icon(Icons.my_location),
    ),
  ];

  var title = Text(
    '电影列表',
    style: TextStyle(fontSize: 14),
  );

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: _tabs.length,
      child: Scaffold(
        appBar: AppBar(
          title: title,
          centerTitle: true,
          // leading: Icon(Icons.menu),
          actions: <Widget>[
            Container(
              margin: EdgeInsets.only(right: 20),
              child: IconButton(icon: Icon(Icons.search), onPressed: () {}),
            )
          ],
        ),
        body: TabBarView(
          // 3. 使用 DefaultTabController 之后，这里不再需要 controller 属性
          // controller: _controller,
          children: _pagelist,
        ),
        drawer: Drawer(
          child: Container(
            decoration: BoxDecoration(color: Colors.black87),
            child: ListView(
                // 消除顶部的灰色条区域
                padding: EdgeInsets.zero,
                children: <Widget>[
                  UserAccountsDrawerHeader(
                    accountName: Text('计亚茹'),
                    accountEmail: Text('liulongbin1314@outlook.com'),
                    currentAccountPicture: Container(
                      child: CircleAvatar(
                        backgroundImage: NetworkImage(
                          'http://oss-toplu1015.oss-cn-hangzhou.aliyuncs.com/flutter/1549521497406.jpg',
                        ),
                      ),
                      width: 20.0,
                      height: 20.0,
                    ),
                    decoration: BoxDecoration(
                      image: DecorationImage(
                        fit: BoxFit.cover,
                        image: NetworkImage(
                            'http://www.liulongbin.top:3005/images/bg1.jpg'),
                      ),
                    ),
                  ),
                  ListTile(
                    title: Text('用户反馈', style: TextStyle(color: Colors.white)),
                    trailing: Icon(Icons.feedback, color: Colors.white),
                  ),
                  ListTile(
                    title: Text('系统设置', style: TextStyle(color: Colors.white)),
                    trailing: Icon(Icons.settings, color: Colors.white),
                  ),
                  ListTile(
                    title: Text('我要发布', style: TextStyle(color: Colors.white)),
                    trailing: Icon(Icons.send, color: Colors.white),
                  ),
                  Divider(color: Colors.white30),
                  ListTile(
                    title: Text('注销', style: TextStyle(color: Colors.white)),
                    trailing: Icon(Icons.exit_to_app, color: Colors.white),
                  )
                ]),
          ),
        ),
        bottomNavigationBar: GestureDetector(
          child: Container(
            decoration: BoxDecoration(
                color: Colors.black,
                border: Border(top: BorderSide(color: Colors.grey, width: 1))),
            height: 50,
            child: TabBar(
              // 4. 使用 DefaultTabController 之后，这里不再需要 controller 属性
              // controller: _controller,
              tabs: _tabs,
              indicatorColor: Colors.red,
              labelStyle: TextStyle(height: 0, fontSize: 10),
            ),
          ),
          onTap: () {
            print("index");
          },
        ),
      ),
    );
  }
}
