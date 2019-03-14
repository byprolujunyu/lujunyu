import 'package:flutter/material.dart';
import 'service_main.dart';
void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primaryColor: Colors.black,
        primaryColorLight: Colors.white,
      ),
      debugShowCheckedModeBanner: false,
      home: Demo(),
    );
  }
}


class Demo extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Container(
        margin: EdgeInsets.only(top:200),
        child: Row(
          children: <Widget>[
            Container(child:Text('123',)),
            Container(
              width: 50,
                height: 40,

                child:SingleChildScrollView(

                    scrollDirection:Axis.horizontal,child: Text('12333344444444444444',)),)
          ],
        ),
      ),
    );
  }
}

