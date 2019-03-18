import 'package:flutter/material.dart';

class CommTabWidget extends StatefulWidget {
  final Map map;
  final List ms;

  CommTabWidget({Key key, this.map, this.ms}) : super(key: key);

  @override
  _CommTabWidgetState createState() => _CommTabWidgetState();
}

class _CommTabWidgetState extends State<CommTabWidget> {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        children: <Widget>[
          Container(
            child: getCommendsList(),
            margin: EdgeInsets.all(5.0),
          ),
          Container(
            width: MediaQuery.of(context).size.width,
            height: MediaQuery.of(context).size.height,
            child: Image.network(widget.map['PICTURE_ADDRESS']),
          ),
        ],
      ),
    );
  }

  Widget getCommendsList() {
    if (widget.ms != null) {
      return Container(
        height: widget.ms.length * MediaQuery.of(context).size.height / 7,
        child: ListView.builder(
          itemBuilder: (context, index) {
            return getUi(context, widget.ms[index]);
          },
       itemCount: widget.ms.length, ),
      );
    }else if(widget.ms == null||widget.ms.length==0){
      return Text('暂时还没有评论噢!');
    }
  }

//comments
  //userName
  //discussTime
  Widget getUi(BuildContext context, m) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.start,
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Container(
          margin: EdgeInsets.all(5.0),
          child: Text('${m['userName']}'),
        ),
        Container(
          margin: EdgeInsets.all(5.0),
          child: Text('${m['comments']}'),
        ),
        Container(
          margin: EdgeInsets.all(5.0),
          child: Text('${m['discussTime']}'),
        ),
      ],
    );
  }
}
