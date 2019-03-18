import 'package:flutter/material.dart';

class DemoList extends StatelessWidget {
  final List str1 = ['姓名', '工号', '手机号', '所在城市'];

  final List c1 = ['623465', '623465', '623465', '623465'];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: ListView.builder(itemBuilder: (BuildContext c, int index) {
        return getUI(c, index);
      }),
    );
  }

  Widget getUI(BuildContext c, int index) {
    String name = str1[index];
    String name1 = c1[index];
    return InkWell(
        child: Column(
      children: <Widget>[
        Container(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: <Widget>[
              Container(
                child: Text(name),
              ),
              Row(
                children: <Widget>[
                  Container(
                    child: Text(name1),
                  ),
                  Container(
                    child: Icon(Icons.arrow_forward_ios),
                  ),
                ],
              )
            ],
          ),
          margin: EdgeInsets.all(10.0),
        ),
        Divider(),
      ],
    ));
  }
}
