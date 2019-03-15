import 'package:flutter/material.dart';
import 'package:flutter_button/address/address_ios_page.dart';
import 'package:flutter_button/page/cart_test.dart';
import 'package:flutter_button/widget/my_widget.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import '../service/service_method.dart';

class MemberPage extends StatelessWidget {
  final List<String> strs = ['领取优惠券', '已领取优惠券', '地址管理'];

  final List<String> icons = [
    'images/youhuiquan.png',
    'images/youhuiquan.png',
    'images/dizhi.png'
  ];

  final List<String> strs2 = ['客服电话', '关于商城'];

  final List<String> icons2 = ['images/kefudianhua.png', 'images/guanyu.png'];

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return Scaffold(
      appBar: AppBar(
        title: Text(
          '会员中心',
        ),
        elevation: 0.0,
      ),
      body: SingleChildScrollView(
        child: Container(
          child: Column(
            children: <Widget>[
              UserInfoDrawer(),
              MyOrderUI(),
              CashState(),
              list(),
            ],
          ),
        ),
      ),
    );
  }

  Widget list() {
    try {
      return Column(
        children: <Widget>[
          MyDivider(
            height: ScreenUtil().setHeight(20),
            color: Color.fromARGB(255, 240, 238, 238),
          ),
          LoveUI(
            names: strs,
            icons: icons,
          ),
          MyDivider(
            height: ScreenUtil().setHeight(20),
            color: Color.fromARGB(255, 240, 238, 238),
          ),
          LoveUI(
            names: strs2,
            icons: icons2,
          ),
          MyDivider(
            height: ScreenUtil().setHeight(20),
            color: Color.fromARGB(255, 240, 238, 238),
          ),
        ],
      );
    } catch (e) {
      print(e);
    }
  }
}

class UserInfoDrawer extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: ScreenUtil().setHeight(350),
      child: UserAccountsDrawerHeader(
        accountName: Text('计亚茹'),
        accountEmail: Text('prettyruru@outlook.com'),
        currentAccountPicture: Container(
          child: InkWell(
            child: CircleAvatar(
              backgroundImage: NetworkImage(
                  "http://oss-toplu1015.oss-cn-hangzhou.aliyuncs.com/flutter/1549681968817.jpg"),
            ),
            onTap: () {},
          ),
          width: ScreenUtil().setWidth(20),
          height: ScreenUtil().setHeight(20),
        ),
        decoration: BoxDecoration(
          image: DecorationImage(
            fit: BoxFit.cover,
            image:
                NetworkImage('http://www.liulongbin.top:3005/images/bg1.jpg'),
          ),
        ),
      ),
      margin: EdgeInsets.only(bottom: ScreenUtil().setHeight(5)),
    );
  }
}

class MyOrderUI extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        children: <Widget>[
          Container(
            child: Row(
              children: <Widget>[
                Container(
                  margin: EdgeInsets.all(ScreenUtil().setWidth(10)),
                  width: ScreenUtil().setWidth(50),
                  height: ScreenUtil().setHeight(50),
                  child: Image.asset(
                    'images/member/order.png',
                    fit: BoxFit.fill,
                  ),
                ),
                Container(
                  child: Text('我的订单'),
                ),
              ],
            ),
            margin: EdgeInsets.only(bottom: ScreenUtil().setHeight(5)),
          ),
        ],
      ),
    );
  }
}

class CashState extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.only(bottom: 10.0),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: <Widget>[
          Container(
            child: Column(
              children: <Widget>[
                Container(
                  width: ScreenUtil().setWidth(55),
                  height: ScreenUtil().setHeight(55),
                  child: Image.asset(
                    'images/member/daifukuan.png',
                    fit: BoxFit.fill,
                  ),
                ),
                Container(
                  child: Text('待付款'),
                ),
              ],
            ),
          ),
          Container(
            child: Column(
              children: <Widget>[
                Container(
                  width: ScreenUtil().setWidth(55),
                  height: ScreenUtil().setHeight(55),
                  child: Image.asset(
                    'images/member/daifahuo.png',
                    fit: BoxFit.fill,
                  ),
                ),
                Container(
                  child: Text('待发货'),
                ),
              ],
            ),
          ),
          Container(
            child: Column(
              children: <Widget>[
                Container(
                  width: ScreenUtil().setWidth(55),
                  height: ScreenUtil().setHeight(55),
                  child: Image.asset(
                    'images/member/daishouhuo.png',
                    fit: BoxFit.fill,
                  ),
                ),
                Container(
                  child: Text('待收货'),
                ),
              ],
            ),
          ),
          Container(
            child: Column(
              children: <Widget>[
                Container(
                  width: ScreenUtil().setWidth(55),
                  height: ScreenUtil().setHeight(55),
                  child: Image.asset(
                    'images/member/daipingjia.png',
                    fit: BoxFit.fill,
                  ),
                ),
                Container(
                  child: Text('待评价'),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}

class LoveUI extends StatelessWidget {
  final List<String> names;
  final List<String> icons;

  LoveUI({Key key, @required this.names, @required this.icons})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      height: names.length == 3
          ? ScreenUtil().setHeight(270)
          : ScreenUtil().setHeight(180),
      child: ListView.builder(
        itemBuilder: _getListUi,
        itemCount: names.length,
        physics: new NeverScrollableScrollPhysics(),
      ),
    );
  }

  final String iconName = 'images/backgrey.png';

  Widget _getListUi(BuildContext context, int index) {
    return Container(
      child: InkWell(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: <Widget>[
            Row(
              children: <Widget>[
                Container(
                  margin: EdgeInsets.all(10.0),
                  width: ScreenUtil().setWidth(50),
                  height: ScreenUtil().setHeight(50),
                  child: Image.asset(
                    icons[index],
                    fit: BoxFit.fill,
                  ),
                ),
                Container(
                  margin: EdgeInsets.only(bottom: 10.0, top: 10.0),
                  child: Text(names[index]),
                ),
              ],
            ),
            Container(
                width: ScreenUtil().setWidth(30),
                height: ScreenUtil().setHeight(30),
                margin: EdgeInsets.only(right: 10.0),
                alignment: Alignment.center,
                child: Image.asset(
                  '$iconName',
                  fit: BoxFit.fill,
                )),
          ],
        ),
        onTap: () async {
          if (names[index] == '地址管理') {
            Navigator.of(context)
                .push(MaterialPageRoute(builder: (BuildContext ctx) {
              return NewAddressPage();
            }));
          }

          if (names[index] == '客服电话') {
            await callLeaderPhone(context);
          }
        },
      ),
    );
  }
}
