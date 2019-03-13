import 'package:flutter/material.dart';
import 'package:dio/dio.dart';
Dio dio = new Dio();
class MyHome extends StatefulWidget {
  @override
  _MyHomeState createState() => _MyHomeState();
}

class _MyHomeState extends State<MyHome> {
  var result;
  Map item;
@override
  void initState() {
    // TODO: implement initState
    super.initState();
    _getCircleImage();
  }

 _getCircleImage() async{
  var resppnse = await dio.get("http://47.96.78.67:8000/query/4");

  setState(() {
    result = resppnse.data;
  });
 }

  @override
  Widget build(BuildContext context) {
  List data = item['data'];
    return Scaffold(
        appBar: AppBar(
          title: GestureDetector(
            onTap: () {
              print('appbar');
            },
            child: Text(
              'flutter',
              style: TextStyle(
                fontSize: 30.0,
              ),
            ),
          ),
          centerTitle: true,
        ),
        body: ListView(
          children: <Widget>[
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: _getCIW(data),
            ),
          ],
        ));
  }

 List<Widget> _getCIW(List data){
   List<Widget> ws = List();
    for(var item in data){
      var c = Column(
        children: <Widget>[
          //Text('hello'),
          CircleAvatar(
            backgroundImage: NetworkImage(
              "${item['path']}",
            ),
          ),
          Text("$item['description']"),
        ],
      );
      ws.add(c);
    }
  }
}
