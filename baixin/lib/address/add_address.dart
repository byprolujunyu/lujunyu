import 'package:flutter/material.dart';
import 'package:flutter_button/address/address_ios_page.dart';
import 'package:flutter_button/db/db_helper_address.dart';
import 'package:flutter_button/model/address.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class AddAddressPage extends StatefulWidget {
  @override
  _AddAddressPageState createState() => _AddAddressPageState();
}

class _AddAddressPageState extends State<AddAddressPage> {
  DataBaseHelper_address db = DataBaseHelper_address();
  TextEditingController _nameController = TextEditingController();
  TextEditingController _phoneController = TextEditingController();
  TextEditingController _numController = TextEditingController();

  String _address = "";
  bool isSelected = false;

  bool init = true;

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return Scaffold(
      appBar: AppBar(
        title: Text('地址管理'),
        elevation: 0.0,
      ),
      body: init
          ? SingleChildScrollView(
              physics: new NeverScrollableScrollPhysics(),
              child: Column(
                children: <Widget>[
                  Padding(
                    padding: EdgeInsets.only(top: 50, left: 20, right: 20),
                    child: TextField(
                      controller: _nameController,
                      maxLines: 1,
                      autofocus: true,
                      decoration: InputDecoration(
                        icon: Icon(Icons.account_circle),
                        filled: true,
                        border: UnderlineInputBorder(),
                        labelText: "请输入收货人姓名",
                      ),
                    ),
                  ),
                  Padding(
                    padding: EdgeInsets.only(top: 20, left: 20, right: 20),
                    child: TextField(
                      controller: _phoneController,
                      maxLines: 1,
                      keyboardType: TextInputType.number,
                      decoration: InputDecoration(
                        icon: Icon(Icons.phone),
                        filled: true,
                        border: UnderlineInputBorder(),
                        labelText: "请输入11位手机号码",
                      ),
                    ),
                  ),
                  Padding(
                    padding: EdgeInsets.only(top: 20, left: 20, right: 20),
                    child: Container(
                      alignment: Alignment.center,
                      child: InkWell(
                        child: Text(
                          '点击选择收货地址',
                          style: TextStyle(
                              color: Colors.white, fontWeight: FontWeight.bold),
                        ),
                      ),
                      height: ScreenUtil().setHeight(80),
                      width: ScreenUtil().setWidth(300),
                      color: Colors.pink,
                    ),
                  ),
                  Padding(
                    padding: EdgeInsets.only(top: 20, left: 20, right: 20),
                    child: TextField(
                      controller: _numController,
                      maxLines: 1,
                      keyboardType: TextInputType.text,
                      decoration: InputDecoration(
                        icon: Icon(Icons.add_location),
                        filled: true,
                        border: UnderlineInputBorder(),
                        labelText: "请输入详细地址",
                      ),
                    ),
                  ),
                  Padding(
                    padding: EdgeInsets.only(top: 20, left: 20, right: 20),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.end,
                      children: <Widget>[
                        Container(
                          alignment: Alignment.center,
                          child: InkWell(
                            child: Icon(
                              isSelected
                                  ? Icons.check_circle_outline
                                  : Icons.radio_button_unchecked,
                            ),
                            onTap: () {
                              setState(() {
                                isSelected = !isSelected;
                              });
                            },
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.only(left: 10.0),
                          alignment: Alignment.center,
                          child: Text('设为默认'),
                        ),
                      ],
                    ),
                  ),
                  Padding(
                    padding: EdgeInsets.only(top: 100, left: 20, right: 20),
                    child: Container(
                      height: ScreenUtil().setHeight(60),
                      width: ScreenUtil().setWidth(500),
                      color: Colors.red,
                      child: Center(
                        child: InkWell(
                          child: Text(
                            '提交地址',
                            style: TextStyle(color: Colors.white),
                          ),
                          onTap: () async {
                            try {
                              setState(() {
                                init = false;
                              });
                              _add();
                              Navigator.of(context).pushAndRemoveUntil(
                                  MaterialPageRoute(
                                      builder: (context) => NewAddressPage()),
                                  (route) => route == null);
                            } catch (e) {
                              print(e);
                            }
                          },
                        ),
                      ),
                    ),
                  ),
                ],
              ),
            )
          : Center(
              child: Loading(),
            ),
    );
  }

  Future _add() async {
    await db.saveAddress(Address(
      name: _nameController.text,
      phone: _phoneController.text,
      address: '上海市浦东新区',
      num: _numController.text,
      isSelected: isSelected ? 1 : 0,
    )).then((onvalue){
      setState(() {
        init = true;
      });
    });
  }
}
