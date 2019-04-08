import 'package:flutter/material.dart';
import 'package:flutter_fanxinren/page/index_page.dart';
import 'package:flutter_fanxinren/provide/counter.dart';
import 'package:flutter/material.dart';
import 'package:fluro/fluro.dart';
import 'package:flutter_fanxinren/routers/application.dart';
import 'package:flutter_fanxinren/routers/routers.dart';
import 'package:provide/provide.dart';

void main() {
  var providers = Providers();

  var counter = Counter();

  providers..provide(Provider<Counter>.value(counter));

  runApp(ProviderNode(
    child: MyApp(),
    providers: providers,
  ));
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final router = new Router();
    Routers.configuerRouters(router);
    Application.router = router;

    return Container(
      child: MaterialApp(
        title: "百姓生活+",
        onGenerateRoute: Application.router.generator,
        debugShowCheckedModeBanner: false,
        theme: ThemeData(primaryColor: Colors.pink),
        home: IndexPage(),
      ),
    );
  }
}
