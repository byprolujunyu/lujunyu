import 'package:flutter/material.dart';
import 'package:flutter_button/address/add_address.dart';
import 'package:flutter_button/db/db_helper_address.dart';
import 'package:flutter_button/model/address.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class NewAddressPage extends StatefulWidget {
  @override
  _NewAddressPageState createState() => _NewAddressPageState();
}

class _NewAddressPageState extends State<NewAddressPage> {
  DataBaseHelper_address db = DataBaseHelper_address();
  List datas = [];

  @override
  void initState() {
    super.initState();
    _query();
  }

  Future _query() async {
    var list = await db.getAllAdds();
    print(list);
    List<Address> as = fromJson(list);
    setState(() {
      datas = as;
    });
  }

  Future _add() async {
    try {
      await db.saveAddress(
        Address(
          name: '杨霖',
          phone: '14782002531',
          address: '静安区阳城路',
          num: '101弄41号101',
          isSelected: 1,
        ),
      );
      await db.saveAddress(
        Address(
          name: '何晓萍',
          phone: '13564389123',
          address: '上海市松江区九亭街道',
          num: '10号402室',
          isSelected: 0,
        ),
      );
      await db.saveAddress(
        Address(
          name: '曾三保',
          phone: '17602134437',
          address: '宝山区泗塘六村',
          num: '69号401室',
          isSelected: 0,
        ),
      );
      _query();
    } catch (e) {
      print(e);
    }
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
                await db.deleteAdd(id);
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

  Future _jump() async {
    print('setAddress');
    Navigator.of(context).push(MaterialPageRoute(builder: (BuildContext ctx) {
      return AddAddressPage();
    }));
  }

  Future _delete(id) async {
    show(id);
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
        actions: <Widget>[
          IconButton(
            onPressed: () {
              Navigator.of(context)
                  .push(MaterialPageRoute(builder: (BuildContext ctx) {
                return AddAddressPage();
              }));
            },
            icon: Icon(Icons.add),
          ),
        ],
      ),
      body: datas.length == 0
          ? Empty(
              add: _jump,
            )
          : HaveData(
              datas: datas,
              delete: _delete,
            ),
    );
  }

  List<Address> fromJson(List list) {
    List<Address> as = [];
    for (Map m in list) {
      Address a = Address.fromMap(m);
      as.add(a);
    }
    return as;
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
                child: Text(
                  '快去添加',
                  style: TextStyle(color: Colors.white),
                ),
                onTap: () {
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

  Widget getItem(context, Address map) {
    return Container(
        margin: EdgeInsets.all(10.0),
        child: Column(
          children: <Widget>[
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: <Widget>[
                Container(
                  child: Text(
                    '收件人:  ${map.name}',
                  ),
                ),
                Container(
                  child: Text(
                    '${map.phone}',
                  ),
                ),
              ],
            ),
            Container(
              width: ScreenUtil.screenWidth,
              child: Text('地址: ${map.address}${map.num}'),
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
                                map.isSelected == 1
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
                          child: InkWell(
                            child: Row(
                              children: <Widget>[
                                Container(
                                  child: IconButton(
                                    icon: Icon(Icons.edit),
                                    onPressed: () {

                                    },
                                  ),
                                ),
                                Container(
                                  child: Text('编辑'),
                                ),
                              ],
                            ),
                            onTap:
                            (){
                              Navigator.of(context).push(
                                MaterialPageRoute(
                                  builder: (BuildContext ctx) {
                                    return AddAddressPage(
                                      id: map.id,
                                    );
                                  },
                                ),
                              );
                            },
                          ),
                        ),
                        Container(
                          child: InkWell(
                            child: Row(
                              children: <Widget>[
                                Container(
                                  child: IconButton(
                                      icon:
                                          Image.asset('images/trash-gray.png'),
                                      onPressed: () {}),
                                ),
                                Container(
                                  child: Text('删除'),
                                ),
                              ],
                            ),
                            onTap: () {
                              delete(map.id);
                            },
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
