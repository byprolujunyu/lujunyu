import 'package:flutter/material.dart';
import 'package:flutter_button/address/address_ios_page.dart';
import 'package:flutter_button/db/db_helper_address.dart';
import 'package:flutter_button/model/address.dart';
import 'package:flutter_button/page/index_main.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:city_pickers/city_pickers.dart';

class AddAddressPage2 extends StatefulWidget {
  final int id;

  AddAddressPage2({Key key, this.id}) : super(key: key);

  @override
  _AddAddressPage2State createState() => _AddAddressPage2State();
}

class _AddAddressPage2State extends State<AddAddressPage2> {
  DataBaseHelper_address db = DataBaseHelper_address();
  TextEditingController _nameController = TextEditingController();
  TextEditingController _phoneController = TextEditingController();
  TextEditingController _numController = TextEditingController();

  String _address = "";

  bool isSelected = false;

  bool init = true;

  bool isUpdate = false;

  @override
  void initState() {
    super.initState();
    _queryById();
  }

  Result result;

  show(context) async {
    try {
      Result temp = await CityPickers.showCityPicker(
        context: context,
        locationCode: '640221',
        height: ScreenUtil().setHeight(500),
      ).then((val) {
        var result = val.toString();
        print(result);
        setState(() {
          this.result = val;
        });
      });
    } catch (e) {
      print(e);
    }
  }

  Future _queryById() async {
    try {
      int id = widget.id;
      if (id != null) {
        var result = await db.getAdd(id);
        print(result);
        Map map = result[0];
        String name = map['_name'];
        String phone = map['_phone'];
        String num = map['_num'];
        String address = map['_address'];
        bool isS = map['_isSelected'] == 1 ? true : false;
        setState(() {
          isUpdate = true;
          isSelected = isS;
          _address = address;
          _nameController.text = name;
          _phoneController.text = phone;
          _numController.text = num;
        });
      }
    } catch (e) {
      print(e);
    }
  }

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return WillPopScope(
      child: Scaffold(
        appBar: AppBar(
          title: Text('地址管理'),
          elevation: 0.0,
        ),
        body: init
            ? SingleChildScrollView(
                physics: new NeverScrollableScrollPhysics(),
                child: Column(
                  children: <Widget>[
                    Container(
                      margin: EdgeInsets.only(left: 5),
                      child: TextField(
                        keyboardType: TextInputType.text,
                        decoration: InputDecoration(
                          border: InputBorder.none,
                          contentPadding: EdgeInsets.all(10.0),
                          icon: Text('姓名:'),
                          labelText: '请输入收货人姓名',
                        ),
                        controller: _nameController,
                        autofocus: false,
                      ),
                    ),
                    Divider(
                      color: Colors.black45,
                      height: 3,
                    ),
                    Container(
                      margin: EdgeInsets.only(left: 5),
                      child: TextField(
                        keyboardType: TextInputType.number,
                        decoration: InputDecoration(
                          border: InputBorder.none,
                          contentPadding: EdgeInsets.all(10.0),
                          icon: Text('电话:'),
                          labelText: '请输入11位手机号码',
                        ),
                        controller: _phoneController,
                        autofocus: false,
                      ),
                    ),
                    Divider(
                      color: Colors.black45,
                      height: 3,
                    ),
                    Container(
                      padding: EdgeInsets.fromLTRB(5.0, 15.0, 15.0, 15.0),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: <Widget>[
                          Row(
                            children: <Widget>[
                              Container(
                                child: Text('地址;'),
                              ),
                              InkWell(
                                child: Container(
                                  child: Text(
                                    result == null
                                        ? _address.length == 0?'点击选择收货地址':'${_address}'
                                        : '${result.provinceName}${result.cityName}${result.areaName}',
                                    style: TextStyle(
                                      color: Color.fromARGB(255, 125, 124, 125),
                                      fontSize: result != null
                                          ? ScreenUtil().setSp(20)
                                          : ScreenUtil().setSp(30),
                                    ),
                                  ),
                                  margin: EdgeInsets.only(
                                      left: ScreenUtil().setWidth(50)),
                                ),
                                onTap: () {
                                  show(context);
                                },
                              ),

                            ],
                          ),

                          Container(
                            margin: EdgeInsets.only(right: 5),
                            height: 30,
                            width: 30,
                            child: Image.asset(
                              'images/icon_addaddress_dizhi.png',
                              fit: BoxFit.fill,
                            ),
                          ),
                        ],
                      ),
                    ),
                    Divider(
                      color: Colors.black45,
                      height: 3,
                    ),
                    Container(
                      margin: EdgeInsets.only(left: 5),
                      child: TextField(
                        keyboardType: TextInputType.number,
                        decoration: InputDecoration(
                          border: InputBorder.none,
                          contentPadding: EdgeInsets.all(10.0),
                          icon: Text('门牌号:'),
                          labelText: '请输入详细地址',
                        ),
                        controller: _numController,
                        autofocus: false,
                      ),
                    ),
                    Divider(
                      color: Colors.black45,
                      height: 3,
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
                      child: GestureDetector(
                        child: Container(
                          height: ScreenUtil().setHeight(60),
                          width: ScreenUtil().setWidth(500),
                          color: Colors.red,
                          alignment: Alignment.center,
                          child: Text(
                            !isUpdate ? '提交地址' : '修改地址',
                            style: TextStyle(color: Colors.white),
                          ),
                        ),
                        onTap: () {
                          if (widget.id == null) {
                            var name = _nameController.text;
                            var ohone = _phoneController.text;
                            var num = _numController.text;
                            _add(Address(
                              name: name,
                              phone: ohone,
                              address:
                                  '${result.provinceName}${result.cityName}${result.areaName}',
                              id: widget.id,
                              num: num,
                              isSelected: isSelected ? 1 : 0,
                            )).then((onvalue) {
                              Navigator.of(context).push(MaterialPageRoute(
                                  builder: (context) => NewAddressPage()));
                            });
                          } else {
                            var name = _nameController.text;
                            var ohone = _phoneController.text;
                            var num = _numController.text;
                            _update(Address(
                              name: name,
                              phone: ohone,
                              address:
                                  '${result.provinceName}${result.cityName}${result.areaName}',
                              id: widget.id,
                              num: num,
                              isSelected: isSelected ? 1 : 0,
                            )).then((onValue) {
                              Navigator.of(context).push(MaterialPageRoute(
                                  builder: (context) => NewAddressPage()));
                            });
                          }
                        },
                      ),
                    ),
                  ],
                ),
              )
            : Center(
                child: Loading(),
              ),
      ),
      onWillPop: () {
        Navigator.of(context).pushAndRemoveUntil(
            MaterialPageRoute(builder: (context) => IndexPage()),
            (route) => route == null);
      },
    );
  }

  Future _add(address) async {
    await db.saveAddress(address);
  }

  Future _update(address) async {
    await db.updateAdd(address);
  }
}
