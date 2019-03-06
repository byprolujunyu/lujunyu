import "package:dio/dio.dart";
import 'dart:async';
import 'dart:io';
import '../config/service_url.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:flutter/material.dart';

Future getHomePageContent() async {
  try {
    print('开始获取首页数据...............');
    Response response;
    Dio dio = new Dio();
    dio.options.contentType =
        ContentType.parse("application/x-www-form-urlencoded");
    var formData = {'lon': '115.02932', 'lat': '35.76189'};
    response = await dio.post(servicePath['homePageContext'], data: formData);
    if (response.statusCode == 200) {
      return response.data;
    } else {
      throw Exception('后端接口出现异常，请检测代码和服务器情况.........');
    }
  } catch (e) {
    return print('ERROR:======>${e}');
  }
}

Future homePageBelowConten() async {
  try {
    print('开始获取首页列表数据...............');
    Response response;
    Dio dio = new Dio();
    dio.options.contentType =
        ContentType.parse("application/x-www-form-urlencoded");

    response = await dio.post(servicePath['homePageBelowConten']);
    if (response.statusCode == 200) {
      return response.data;
    } else {
      throw Exception('后端接口出现异常，请检测代码和服务器情况.........');
    }
  } catch (e) {
    return print('ERROR:======>${e}');
  }
}

void showShortToast(str) {
  Fluttertoast.showToast(
      msg: "${str}", toastLength: Toast.LENGTH_SHORT, timeInSecForIos: 1);
}

void showLongToast(str) {
  Fluttertoast.showToast(
      msg: "${str}", toastLength: Toast.LENGTH_LONG, timeInSecForIos: 1);
}

void showToast(str, int i) {
  Fluttertoast.showToast(
      msg: "${str}",
      toastLength: i == 0 ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG,
      timeInSecForIos: 1);
}

void alertDialog(BuildContext context, String str, String url) {
  if (Platform.isIOS) {
    makePhoneCall(url);
  } else {
    showDialog<Null>(
      context: context,
      barrierDismissible: false,
      builder: (BuildContext context) {
        return new AlertDialog(
          title: new Text(str),
          actions: <Widget>[
            new FlatButton(
              child: new Text('确定'),
              onPressed: () {
                makePhoneCall(url);
                Navigator.pop(context);
              },
            ),
            new FlatButton(
              child: new Text('取消'),
              onPressed: () {
                Navigator.pop(context);
              },
            ),
          ],
        );
      },
    ).then((val) {});
  }
}

Future<void> makePhoneCall(String url) async {
  if (await canLaunch(url)) {
    await launch(url);
  } else {
    throw 'Could not launch $url';
  }
}

void showBottomWidget(BuildContext context, Widget child) {
  showModalBottomSheet(
    context: context,
    builder: (BuildContext context) {
      return child;
    },
  );
}
