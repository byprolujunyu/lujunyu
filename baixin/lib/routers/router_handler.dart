import 'package:fluro/fluro.dart';
import 'package:flutter/material.dart';
import 'package:flutter_button/detail/datail_page_new.dart';


Handler detailsHandler = Handler(
  handlerFunc: (BuildContext context, Map<String, dynamic> params) {
    return DetailPageNew(goodsId: params['id'][0],);
  },
);
