import 'package:flutter/material.dart';

class CommTabWidget extends StatefulWidget {
  CommTabWidget({Key key}):super(key:key);
  @override
  _CommTabWidgetState createState() => _CommTabWidgetState();
}

class _CommTabWidgetState extends State<CommTabWidget> {
  @override
  Widget build(BuildContext context) {
    return  Container(
      height: 200,
      width: MediaQuery.of(context).size.width,
      child: Center(
        child: Text('评论'),
      ),
    );
  }
}
