import 'package:flutter/material.dart';
import 'package:flutter_button/widget/web_view.dart';
import 'package:flutter_html/flutter_html.dart';

class DetailTabWidget extends StatefulWidget {
  final String map;

  DetailTabWidget({Key key, this.map}) : super(key: key);

  @override
  _DetailTabWidgetState createState() => _DetailTabWidgetState();
}

class _DetailTabWidgetState extends State<DetailTabWidget> {
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    try {
      return SingleChildScrollView(
          child: Container(
            child: Html(
              data: widget.map,
            ),
          ));
    }catch(e){
      print(e);
    }
  }
}
