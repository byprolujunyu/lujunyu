import 'package:flutter/material.dart';
import 'package:flutter_button/widget/web_view.dart';
import 'package:flutter_html/flutter_html.dart';

class DetailTabWidget extends StatefulWidget {
  final String map;
  final Map m;

  DetailTabWidget({Key key, this.map, this.m}) : super(key: key);

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
        child: Column(
          children: <Widget>[
            Html(
              data: widget.map,
            ),

            Container(
              width: MediaQuery.of(context).size.width,
              height: MediaQuery.of(context).size.height,
              child: Image.network(widget.m['PICTURE_ADDRESS']),
            ),
          ],
        ),
      ));
    } catch (e) {
      print(e);
    }
  }
}
