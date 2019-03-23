import 'package:flutter/material.dart';
import 'my_home.dart';
import 'package:flutter_like/fragment/like_bilibili.dart';
void main() => runApp(MyApp());
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme:ThemeData(
          primaryColor:Colors.pinkAccent,
      ),
      home: Like(),
    );
  }
}
