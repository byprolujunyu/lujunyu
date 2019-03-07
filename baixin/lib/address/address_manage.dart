import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:flutter/services.dart';
import 'dart:async';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

class AddressPage extends StatefulWidget {
  @override
  _AddressPageState createState() => _AddressPageState();
}

class _AddressPageState extends State<AddressPage> {
  static const updateAddress = const MethodChannel("address/updateAddress");
  static const deleteAddress = const MethodChannel("address/deleteAddress");
  static const addAddress = const MethodChannel("address/addAddress");
  static const queryAddress = const MethodChannel("address/queryAddress");
  static const jumptoAddress = const MethodChannel("address/jumptoAddress");

  Future _query() async {
    await queryAddress.invokeMethod('queryAddress');
  }

  Future _add() async {
    await addAddress.invokeMethod('addAddress');
    _query();
  }

  Future _jump() async {
    await jumptoAddress.invokeMethod('jumptoAddress');
  }

  show(id) {
    showDialog<Null>(
      context: context,
      barrierDismissible: false,
      builder: (BuildContext context) {
        return new AlertDialog(
          title: new Text("是否删除该地址"),
          actions: <Widget>[
            new FlatButton(
              child: new Text('确定'),
              onPressed: () async {
                deleteAddress.invokeMethod('deleteAddress', id);
                _query();
                Navigator.pop(context);
              },
            ),
            new FlatButton(
              child: new Text('取消'),
              onPressed: () {
                Navigator.pop(context);
              },
            ),
          ],
        );
      },
    ).then((val) {});
  }

  List datas = [];

  @override
  void initState() {
    super.initState();
    _query();
    queryAddress.setMethodCallHandler((call) {
      var result = call.arguments;
      print(result);

      setState(() {
        datas = result;
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return Scaffold(
      appBar: AppBar(
        title: Text(
          '收货地址',
        ),
        elevation: 0.0,
//        actions: <Widget>[
//          IconButton(
//            icon: Icon(Icons.add),
//            onPressed: () {
//              _add();
//            },
//          ),
//        ],
      ),
      body: datas.length == 0
          ? Empty(add: _jump,)
          : HaveData(
              datas: datas,
              delete: _delete,
            ),
    );
  }

  Future _delete(id) async {
    show(id);
  }
}

class Empty extends StatelessWidget {

  final Function add;

  Empty({this.add});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
          child: Container(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Container(
              child: Text(
                '还没有收货地址哦',
                style: TextStyle(color: Colors.black26),
              ),
              margin: EdgeInsets.all(5.0),
            ),
            Container(
              alignment: Alignment.center,
              width: ScreenUtil().setWidth(150),
              height: ScreenUtil().setHeight(50),
              color: Colors.red,
              child: InkWell(
                child:Text(
                  '快去添加',
                  style: TextStyle(color: Colors.white),
                ),
                onTap: (){
                  add();
                },
              ),
            ),
          ],
        ),
      )),
    );
  }
}

class HaveData extends StatelessWidget {
  final List datas;

  final Function(int id) delete;

  HaveData({this.datas, this.delete});

  Widget getItem(context, map) {
    return Container(
        margin: EdgeInsets.all(10.0),
        child: Column(
          children: <Widget>[
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: <Widget>[
                Container(
                  child: Text(
                    '收件人:  ${map['_name']}',
                  ),
                ),
                Container(
                  child: Text(
                    '${map['_phone']}',
                  ),
                ),
              ],
            ),
            Container(
              width: ScreenUtil.screenWidth,
              child: Text('地址: ${map['_address']}'),
            ),
            Divider(),
            Container(
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: <Widget>[
                  Container(
                    child: Row(
                      children: <Widget>[
                        Container(
                          child: InkWell(
                              onTap: () => () {},
                              child: Icon(
                                map['isSelected'] == 1
                                    ? Icons.check_circle_outline
                                    : Icons.radio_button_unchecked,
                                color: Colors.red,
                              )),
                        ),
                        Container(
                          margin: EdgeInsets.only(left: 10.0),
                          child: Text(
                            '设置为默认',
                            style: TextStyle(color: Colors.black26),
                          ),
                        ),
                      ],
                    ),
                  ),
                  Container(
                    child: Row(
                      children: <Widget>[
                        Container(
                          child: Row(
                            children: <Widget>[
                              Container(
                                child: IconButton(
                                    icon: Icon(Icons.edit), onPressed: () {}),
                              ),
                              Container(
                                child: Text('编辑'),
                              ),
                            ],
                          ),
                        ),
                        Container(
                          child: Row(
                            children: <Widget>[
                              Container(
                                child: IconButton(
                                    icon: Image.asset('images/trash-gray.png'),
                                    onPressed: () {
                                      delete(map['_id']);
                                    }),
                              ),
                              Container(
                                child: Text('删除'),
                              ),
                            ],
                          ),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),
          ],
        ));
  }

  @override
  Widget build(BuildContext context) {
    return ListView(
        children: datas.map((map) {
      return getItem(context, map);
    }).toList());
  }
}
