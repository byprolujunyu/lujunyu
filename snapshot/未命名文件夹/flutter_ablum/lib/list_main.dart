import 'package:carousel_slider/carousel_slider.dart';
import 'package:flutter/material.dart';
import 'package:dio/dio.dart';

class ListPage extends StatefulWidget {
  @override
  _ListState createState() => _ListState();
}

class _ListState extends State<ListPage> {
  List data = List();

  bool init = false;


  void _getListData() async {
    var response = await Dio().get("http://47.96.78.67:3333/queryAll");
    var result = response.data;
    print(result);
    setState(() {
      data = result["data"];
      init = true;
    });
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _getListData();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          "图片",
        ),
      ),
      body: init?Container(
        child: CarouselSlider(
          items: getWidges(),
          height: 400.0,
          autoPlay: false,
        ),
        padding: EdgeInsets.only(top: 50.0),
      ):Container(
        child: Center(
          child: new CircularProgressIndicator(
            strokeWidth: 4.0,
            backgroundColor: Colors.blue,
            // value: 0.2,
            valueColor: new AlwaysStoppedAnimation<Color>(Colors.red),
          ),
        ),
      ),
    );
  }

  List<Widget> getWidges() {
    List<Widget> ws = List();
    for (var value in data) {
      print(value);
      var w =  Image.network(
        '${value["path"]}',
        fit: BoxFit.cover,

      );
      ws.add(w);
    }
    return ws;
  }
}
