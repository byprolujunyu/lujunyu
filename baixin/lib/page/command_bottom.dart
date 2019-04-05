import 'package:dio/dio.dart';

import 'package:flutter/material.dart';
import 'package:flutter_button/service/service_method.dart';
import 'package:common_utils/common_utils.dart';

class CommTabWidget extends StatefulWidget {
  final Map map;
  final List ms;

  CommTabWidget({Key key, this.map, this.ms}) : super(key: key);

  @override
  _CommTabWidgetState createState() => _CommTabWidgetState();
}

class _CommTabWidgetState extends State<CommTabWidget> {
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    getTimes();
  }

  List times = [];

  void getTimes() {
    widget.ms.map((m) {
      requestLocal('47.96.78.67:9990/time/${m['discussTime']}').then((val) {
        setState(() {
          //m.putIfAbsent("time", () => val);
          times.add(val);
        });
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        children: <Widget>[
          Container(
            child: getCommendsList(),
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
    if (widget.ms.length != 0) {
      return Container(
        height: widget.ms.length * MediaQuery.of(context).size.height / 12,
        child: list(),
      );
    } else {
      return Container(
        child: Text('暂时还没有评论噢!'),
        margin: EdgeInsets.only(top: 15.0),
      );
    }
  }

  Widget list() {
    List<Widget> listWidget = widget.ms.map((val) {
      return getUi(context, val, 0);
    }).toList();
    return ListView.builder(
          physics: new NeverScrollableScrollPhysics(),
          itemBuilder: (context, index) {
            return getUi(context, widget.ms[index], index);
          },
          itemCount: widget.ms.length,
//      children: listWidget,
    );
  }

//comments
  //userName
  //discussTime
  Widget getUi(BuildContext context, m, index) {
    var c = convert(m['discussTime']);
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
          child: Text('${c}'),
        ),
      ],
    );
  }

  String convert(int date) {
    var def = DateFormat.DEFAULT;
    var dateTime = DateTime.fromMillisecondsSinceEpoch(date);
    var zhWeekDayByMs = DateUtil.getDateStrByDateTime(dateTime,
        format: DateFormat.YEAR_MONTH_DAY_HOUR_MINUTE);
    return zhWeekDayByMs;
  }
}
