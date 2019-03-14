//import 'dart:io';
//import 'package:dio/dio.dart';
//import 'package:flutter/material.dart';
//import 'dart:async';
//import 'dart:io';
//import 'package:flutter/services.dart';
//import 'package:carousel_slider/carousel_slider.dart';
//import 'params.dart';
//
//class RowTest extends StatefulWidget {
//  List files = List();
//
//  RowTest(this.files);
//
//  @override
//  _RowTestState createState() => _RowTestState();
//}
//
//class _RowTestState extends State<RowTest> {
//  static const platformAUpload =
//      const MethodChannel("samples.flutter.io/ablum_result_upload");
//  String result = "";
//
//  @override
//  void initState() {
//    // TODO: implement initState
//    super.initState();
//    platformAUpload.setMethodCallHandler((MethodCall call) {
//      String _path = call.arguments;
//      setState(() {
//        result = _path;
//      });
//    });
//  }
//
//  @override
//  Widget build(BuildContext context) {
//    return Scaffold(
//      appBar: AppBar(
//        title: Text(
//          '上传照片',
//        ),
//        actions: <Widget>[
//          IconButton(
//            icon: Icon(Icons.feedback),
//            onPressed: () {
//              _upload();
//            },
//          ),
//        ],
//      ),
//      body: Container(
//        child: CarouselSlider(
//          items: getWidges(),
//          height: 400.0,
//          autoPlay: false,
//        ),
//        padding: EdgeInsets.only(top: 50.0),
//      ),
//    );
//  }
//
//  Future<Null> _upload() async {
//    try {
//      String path = widget.p.path;
//      await platformAUpload.invokeMethod("upload", path);
//    } on PlatformException catch (e) {}
//  }
//
//  List<Widget> getWidges() {}
//}
