import 'package:flutter/material.dart';
import 'package:flutter_button/widget/web_view.dart';

class DetailTabWidget extends StatefulWidget {
  final String uri;

  DetailTabWidget({Key key, this.uri}) : super(key: key);

  @override
  _DetailTabWidgetState createState() => _DetailTabWidgetState();
}

class _DetailTabWidgetState extends State<DetailTabWidget> {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Container(
        width: MediaQuery.of(context).size.width,
        child: NewsWebPage(news_url: widget.uri,),
      ),
    );
  }
}
