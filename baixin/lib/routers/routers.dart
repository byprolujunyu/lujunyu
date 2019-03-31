import 'package:fluro/fluro.dart';
import 'package:flutter/material.dart';

import '../routers/router_handler.dart';

class Routers{
  static String root = '/';
  static String detailPage = '/detail';
  static void configuerRouters(Router router){
    router.notFoundHandler = Handler(
      handlerFunc: (BuildContext context, Map<String, dynamic> params){}
    );

    router.define(detailPage, handler: detailsHandler);
  }
}