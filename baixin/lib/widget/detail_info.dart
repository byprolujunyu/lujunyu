import 'package:flutter/material.dart';
import 'package:flutter_button/widget/my_widget.dart';

class DetailADDWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          MyDivider(
            height: 5,
            color: Colors.black12,
          ),
          Padding(
            padding: EdgeInsets.fromLTRB(5, 10, 5, 10),
            child: Text(
              '说明: >急速送达 >正品保证',
              style: TextStyle(color: Color.fromARGB(255, 162, 96, 97)),
            ),
          ),
          MyDivider(
            height: 5,
            color: Colors.black12,
          ),
        ],
      ),
    );
  }
}
