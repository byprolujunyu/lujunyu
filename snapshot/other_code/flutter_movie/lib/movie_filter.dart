import 'package:flutter/material.dart';
import 'dart:io';
import 'dart:convert';
class movie_filter extends StatefulWidget {
  @override
  _movie_filterState createState() => _movie_filterState();
}

class _movie_filterState extends State<movie_filter> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text(
          '正在热映',
        ),
      ),
    );
  }
}
