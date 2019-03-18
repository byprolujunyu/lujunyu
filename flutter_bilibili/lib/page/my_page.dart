/**
 * 《Flutter从入门到进阶-实战携程网App》
 * 课程地址：
 * https://coding.imooc.com/class/321.html
 * 课程代码、文档：
 * https://git.imooc.com/coding-321/
 * 课程辅导答疑区：
 * http://coding.imooc.com/learn/qa/321.html
 */
import 'package:flutter/material.dart';

class MyPage extends StatefulWidget {
  @override
  _MyPageState createState() => _MyPageState();
}

class _MyPageState extends State<MyPage> {
  final List str1 = ['姓名', '工号', '手机号', '所在城市'];
  final List c1 = ['623465', '623465', '623465', '623465'];

  @override
  Widget build(BuildContext context) {
    Widget image = Container();
    Widget item = new Flex(
      direction: Axis.horizontal,
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: <Widget>[
        new Container(
          width: 40,
          height: 46,
          color: Colors.red,
          child: Center(
            child: new Text(
              "我的",
            ),
          ),
        ),
      ],
    );
    Widget bottomButtom = new Container(
      child: Container(
        child: Text(
          "确定",
          style: TextStyle(color: Colors.red),
        ),
        color: Color.fromARGB(255, 012, 255, 255),
      ),
    );

    Widget listItem = new Scaffold(
      appBar: AppBar(),
      body: ListView.builder(itemBuilder: (BuildContext c, int index) {
        return getItem(c, index);
      }),
    );
    return ListView(
      padding: const EdgeInsets.fromLTRB(0.0, 10.0, 0.0, 0.0),
      children: <Widget>[image, item, bottomButtom, listItem],
    );
  }

  _print() {
    print("点击了我");
  }

  Widget getItem(BuildContext c, int index) {
    String name = str1[index];
    String name1 = c1[index];
  }
}
