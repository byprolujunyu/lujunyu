import 'package:flutter/material.dart';
import 'package:flutter_movie/demo.dart';
import 'movie_demo.dart';
void main() => runApp(MyApp());
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primaryColor: Colors.pink
      ),
      home: MyMovie(),
    );
  }
}
