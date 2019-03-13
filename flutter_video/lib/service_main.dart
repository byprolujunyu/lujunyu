import 'dart:io';
import 'package:carousel_slider/carousel_slider.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_video/params.dart';

class MainService extends StatefulWidget {
  @override
  _MainServiceState createState() => _MainServiceState();
}

class _MainServiceState extends State<MainService> {
  var platform = MethodChannel("samole/open_ablum");
  var platformVideo = MethodChannel("samole/open_video");
  List data = List();
  List uri_s = List();

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    platform.setMethodCallHandler((MethodCall c) {
      if (c.method == 'getResult') {
        var result = c.arguments;
        print(result);
        List ps = List();
        List uris = List();
        for(int i = 0;i<result.length;i++){
          Map map = result[i];
          print(map);
          map.forEach((key,value){
            ps.add(key);
            uris.add(value);
          });
        }
        setState(() {
          data = ps;
          uri_s = uris;
        });
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          '获取视频',
        ),
        actions: <Widget>[
          IconButton(
            icon: Icon(Icons.add),
            onPressed: () {
              _click();
            },
          ),
        ],
      ),
      body: GridView.count(
        crossAxisCount: 3,
        children: _getItem(),
      ),
    );
  }

  Future<Null> _click() async {
    await platform.invokeMethod("openAblumWithVideo");
  }

  Future<Null> _clickVideo(value) async {

    await platformVideo.invokeMethod("openVideo",value);
  }

  List<Widget> _getItem() {
    List<Widget> ws = List();
    for (int i = 0;i<data.length;i++) {
      var widget = GestureDetector(
        onTap: () {
          String path = data[i]+":"+uri_s[i];
          _clickVideo(path);
        },
        child: Container(
          child: Image.file(
            File(data[i]),
            width: MediaQuery.of(context).size.width / 4,
            height: 200,
            fit: BoxFit.cover,
          ),
          margin: EdgeInsets.all(5.0),
        )
      );
      ws.add(widget);
    }
    return ws;
  }
}
