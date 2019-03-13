import 'package:flutter/material.dart';
import 'dart:io';
import 'dart:convert';

class local_movies extends StatefulWidget {
  @override
  _local_moviesState createState() => _local_moviesState();
}

class _local_moviesState extends State<local_movies> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text(
          'Top250',
        ),
      ),
    );
  }
}
