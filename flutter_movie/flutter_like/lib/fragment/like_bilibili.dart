\import 'package:flutter/material.dart';
import 'package:dio/dio.dart';

Dio dio = Dio();

class Like extends StatefulWidget {
  @override
  _LikeState createState() => _LikeState();
}

class _LikeState extends State<Like> {
  double height;

  double width;

  int pageSize = 10;

  int page = 1;
  int total = 0;
  List mList = [];

  _getVideoList() async {
    int offset = (page - 1) * pageSize;
    var response =
        await dio.get("http://116.62.168.251:8000/video/query/1/100");
    var result = response.data;
    print(result);
    setState(() {
      mList = result['rows'];
      total = result['total'];
    });
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _getVideoList();
  }

  @override
  Widget build(BuildContext context) {
    width = MediaQuery.of(context).size.width;
    height = MediaQuery.of(context).size.height;

    return Scaffold(
      appBar: AppBar(
        title: Row(
          children: <Widget>[
            CircleAvatar(
              radius: width / 28,
              backgroundImage: AssetImage(
                'images/img_column_article_cover.png',
              ),
            ),
            Container(
              width: width / 2.5,
              child: Icon(Icons.search),
              height: 30,
              alignment: Alignment.centerLeft,
              padding: EdgeInsets.only(left: 6.0),
              margin: EdgeInsets.only(left: 10.0),
              decoration: BoxDecoration(
                color: Color.fromARGB(255, 232, 123, 168),
                borderRadius: BorderRadius.all(
                  Radius.circular(20.0),
                ),
              ),
            ),
          ],
        ),
        elevation: 0.0,
      ),
      body: GridView.count(
        crossAxisCount: 3,
        crossAxisSpacing: 10.0,
        children: getView(),
      ),
//      ListView.builder(itemCount: mList.length, itemBuilder: itemBuilder),
//      drawer: Drawer(
//
//      ),
    );
  }

  Widget itemBuilder(BuildContext context, int i) {
    Map item = mList[i];
    return GestureDetector(
      onTap: () {},
      child: Container(
        child: Card(
          child: Image.network(
            "${item['imguri']}",
            height: 100,
            width: 100,
          ),
        ),
      ),
    );
  }

  List<Widget> getView() {
    List<Widget> ws = List();
    for (var value in mList) {
      Map item = value;
      var g = GestureDetector(
        onTap: () {
          print(item);
        },
        child: Container(
          child: Card(
            child: Image.network(
              "${item['imguri']}",
              height: 300,
              width: 300,
            ),
          ),
        ),
      );
      ws.add(g);
    }
    return ws;
  }
}
