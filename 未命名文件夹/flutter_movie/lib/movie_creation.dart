import 'package:flutter/material.dart';
import 'dart:io';
import 'dart:convert';

class movie_creation extends StatefulWidget {
  @override
  _movie_creationState createState() => _movie_creationState();
}

class _movie_creationState extends State<movie_creation> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text(
           '即将上映',
        ),
      ),
    );
  }
}
