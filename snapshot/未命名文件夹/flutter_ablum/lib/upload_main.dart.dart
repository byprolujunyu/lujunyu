import 'dart:io';
import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'dart:async';
import 'dart:io';
import 'package:flutter/services.dart';
import 'package:carousel_slider/carousel_slider.dart';
import 'params.dart';

Dio dio = Dio();

class Upload extends StatefulWidget {
  File f;

  String path;

  Params p;

  Upload(this.p);

  @override
  _UploadState createState() => _UploadState();
}

class _UploadState extends State<Upload> {
  static const platformAUpload = const MethodChannel("samples.flutter.io/ablum_result_upload");
  static const platformClear = const MethodChannel("samples.flutter.io/platformClear");

  String result = "";

  bool init = false;

  Future<Null> _upload() async {
    try {
      String path = widget.p.path;
      await platformAUpload.invokeMethod("upload", path);
    } on PlatformException catch (e) {}
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    platformAUpload.setMethodCallHandler((MethodCall call) {
      String _path = call.arguments;
      setState(() {
        result = _path;
      });
      _uploadPath();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          '上传照片',
        ),
        actions: <Widget>[
          IconButton(
            icon: Icon(Icons.feedback),
            onPressed: () {
              _upload();
            },
          ),
        ],
      ),
      body: Container(
        child: CarouselSlider(
          items: getWidges(),
          height: 400.0,
          autoPlay: false,
        ),
        padding: EdgeInsets.only(top: 50.0),
      ),
    );
  }

  List<Widget> getWidges() {
    List<Widget> ws = List();
    File file = widget.p.f;
    var w = GestureDetector(
      onTap: () {},
      child: Container(
        margin: new EdgeInsets.symmetric(horizontal: 5.0),
        child: Image.file(
          file,
          width: MediaQuery.of(context).size.width,
          fit: BoxFit.cover,
        ),
      ),
    );
    ws.add(w);
    return ws;
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
    print('dispose');

    clear();
  }

  Future clear () async {
    await platformClear.invokeMethod("clear");
  }

  void _uploadPath() async {
    await dio.post("http://47.96.78.67/WebService/addPhoto");
  }
}
