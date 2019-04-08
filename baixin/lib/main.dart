
import 'package:fluro/fluro.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_button/constants/index.dart';
import 'package:flutter_button/provide/category_goods_list.dart';
import 'package:flutter_button/provide/child_category.dart';
import 'package:flutter_button/provide/counter.dart';
import 'package:flutter_button/provide/fujilist_provide.dart';
import 'package:flutter_button/routers/application.dart';
import 'package:flutter_button/routers/routers.dart';

import 'package:flutter_button/service/service_method.dart';
import 'package:provide/provide.dart';
import 'package:flutter_button/widget/demo.dart';
import 'package:flutter_button/widget/loading.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter/services.dart';
import 'package:flutter/cupertino.dart';

void main() async {

  var providers = Providers();
  var childcategory = ChildCategory();
  var categoryGoodsList = CategoryGoodsProvide();
  var fujiListProvide = FujiListProvide();
  var counter = Counter();
  providers
    ..provide(Provider<Counter>.value(counter))
    ..provide(Provider<ChildCategory>.value(childcategory))
    ..provide(Provider<CategoryGoodsProvide>.value(categoryGoodsList))
    ..provide(Provider<FujiListProvide>.value(fujiListProvide));

  SystemChrome.setPreferredOrientations(
      [DeviceOrientation.portraitUp, DeviceOrientation.portraitDown]);
  saveSp(key: KString.isKey, str: '0');
  runApp(ProviderNode(
  child: MyApp(),
  providers: providers,
  ));
}

class MyApp extends StatelessWidget {
  showLoadingPage() {
    return Scaffold(
      body: LoadingPage(),
    );
  }

  @override
  Widget build(BuildContext context) {

    final router = new Router();
    Routers.configuerRouters(router);
    Application.router = router;

    return MaterialApp(
      onGenerateRoute: Application.router.generator,
      debugShowCheckedModeBanner: false,
      home: showLoadingPage(),
      theme: ThemeData(primaryColor: Colors.pink),
    );
  }
}
