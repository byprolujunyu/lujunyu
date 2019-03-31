import 'package:fluro/fluro.dart';
import 'package:flutter/material.dart';
import 'package:flutter_button/detail/datail_page_new.dart';
import 'package:flutter_button/order/order_center.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_button/pay/multi_pay.dart';
import 'package:flutter_button/widget/panel.dart';


Handler detailsHandler = Handler(
  handlerFunc: (BuildContext context, Map<String, dynamic> params) {
    return DetailPageNew(goodsId: params['id'][0],);
  },
);
Handler orderHandler = Handler(
  handlerFunc: (BuildContext context, Map<String, dynamic> params) {
    return OrderCenterPage(index: params['index'][0],);
  },
);
Handler mutliPayHandler = Handler(
  handlerFunc: (BuildContext context, Map<String, dynamic> params) {
    return MutliPayPage(model: params['model'][0],);
  },
);

Handler rootHandler = Handler(
  handlerFunc: (context,params) {
    return IndexPage();
  },
);

Handler panelHandler = Handler(
  handlerFunc: (context,params){
    return Panel();
  }
);