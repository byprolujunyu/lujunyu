import 'dart:io';

import 'package:flutter/services.dart';
import 'package:flutter/material.dart';
import 'package:flutter_ablum/list_main.dart';
import 'package:flutter_ablum/upload_main.dart.dart';
import 'params.dart';
class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  var platform = MethodChannel("samole/open_ablum");
  static const platformAblum = const MethodChannel("samples.flutter.io/ablum");
  static const platformAUpload = const MethodChannel("samples.flutter.io/ablum_result_upload");

  List datas = List();



  Future<Null> _getCom() async {
    try {
      //      在通道上调用此方法
      await platformAblum.invokeMethod("ablum");
    } on PlatformException catch (e) {

    }
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    platformAblum.setMethodCallHandler((MethodCall call) {
      List data = call.arguments;
      print(data);
      setState(() {
        datas = data;
      });
    });
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
    setState(() {
      datas = List();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          '相册',
        ),
        actions: <Widget>[
          GestureDetector(
            onTap: () {_getCom();},
            child: Container(
              child:Image.asset(
                'images/ablum.png',
                width: 20,
                height: 20,
              ),
              margin: EdgeInsets.only(right:20.0),
            ),
          ),
          GestureDetector(
            child: Container(
              child: Icon(
                Icons.search,
              ),
              margin: EdgeInsets.only(right: 5.0),
            ),
            onTap: (){
              Navigator.of(context)
                  .push(MaterialPageRoute(builder: (BuildContext context) {
                return ListPage();
              }));
            },
          ),
        ],
      ),

      body: GridView.count(
        crossAxisCount: 4,
        padding: EdgeInsets.all(5.0),
        children: getWidges(),
      ),

    );
  }


  List<Widget> getWidges() {
    List<Widget> ws = List();
    if (datas != null && datas.length > 0) {
      for (String path in datas) {
        var w = GestureDetector(
          onTap: () {
            Navigator.of(context)
                .push(MaterialPageRoute(builder: (BuildContext context) {
              return Upload(Params(path, File(path)));
            }));
          },
          child: Container(
            margin: new EdgeInsets.all(5.0),
            child: Image.file(
              File(path),
              width: MediaQuery.of(context).size.width / 4,
              height: 200,
              fit: BoxFit.cover,
            ),
          ),
        );
        ws.add(w);
      }
    }
    return ws;
  }
}
