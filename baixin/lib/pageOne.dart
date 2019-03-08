import 'package:flutter/material.dart';
import 'package:flutter_swiper/flutter_swiper.dart';
import 'dart:ui';

class PageOne extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _PageOne();
}

class _PageOne extends State<PageOne> {
  ScrollController _scrollController;
  double offset = 0.0;

  void initState() {
    super.initState();
    _scrollController = ScrollController();
//    setState(() {
//      offset = _scrollController.offset;
//    });
  }

//  void dispose(){
//    _scrollController.dispose();
//    super.dispose();
//  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        elevation: 0,
        centerTitle: true,
        backgroundColor: Colors.green[300],
        title: Text(
          'CanBest教育',
          style: TextStyle(
            fontSize: 20.0,
            fontWeight: FontWeight.w500,
            color: Colors.green[50],
            letterSpacing: 2.0,
            wordSpacing: 2.0,
          ),
        ),
        actions: <Widget>[
          PopupMenuButton(
              icon: Icon(Icons.add_circle),
              itemBuilder: (BuildContext context) => <PopupMenuItem<String>>[
                    new PopupMenuItem(value: "选项一的内容", child: new Text("扫一扫")),
                    new PopupMenuItem(value: "选项二的内容", child: new Text("付款"))
                  ]),
        ],
      ),
      body:SingleChildScrollView(

        child: Container(
            height: 1500,
            child: Column(
          children: <Widget>[
            Swiper_demo(),
            List_demo(),
            Container(
              height: 1000,
            ),
          ],
        )),
      ),
    );
  }

// Widget banner(){
//   return new
// }
}

class List_demo extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: list(),
    );
  }

  Widget list() {
    return Expanded(child: new GridView.count(
      crossAxisCount: 4,
      crossAxisSpacing: 2,
      mainAxisSpacing: 2,
      children: <Widget>[
        IconButton(
          icon: Icon(Icons.cloud),
          onPressed: () {},
        ),
        Text('data'),
        IconButton(
          icon: Icon(Icons.cloud),
          onPressed: () {},
        ),
        Text('data'),
        IconButton(
          icon: Icon(Icons.cloud),
          onPressed: () {},
        ),
        Text('data'),
        IconButton(
          icon: Icon(Icons.cloud),
          onPressed: () {},
        ),
        Text('data'),
      ],
    ),);
  }
}

class Swiper_demo extends StatelessWidget {
  final List<String> _list = [
    'http://pic29.nipic.com/20130601/12122227_123051482000_2.jpg',
    'http://pic36.nipic.com/20131213/6704106_223232205107_2.png',
    'http://mpic.tiankong.com/0d5/395/0d53958028e0c25e20ea0aa851f5daad/640.jpg@%21670w'
  ];

  Swiper buildSwiper() {
    return Swiper(
      itemCount: _list.length,
      scrollDirection: Axis.horizontal,
      autoplay: true,
      controller: new SwiperController(),
      itemBuilder: (BuildContext context, int index) {
        return Image.network(
          _list[index],
          fit: BoxFit.cover,
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 200,
      child: buildSwiper(),
    );
  }
}
