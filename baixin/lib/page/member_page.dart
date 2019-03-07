import 'package:flutter/material.dart';
import 'package:flutter_button/page/cart_test.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class MemberPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          '会员中心',
        ),
      ),
      body: Container(
        child: Column(
          children: <Widget>[
            UserInfoDrawer(),
            MyOrderUI(),
            CashState(),
            LoveUI(),
          ],
        ),
      ),
    );
  }
}

class UserInfoDrawer extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);

    print('设备宽度:${ScreenUtil.screenWidth}');
    print('设备高度:${ScreenUtil.screenHeight}');
    print('设备像素密度:${ScreenUtil.pixelRatio}');
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
            onTap: (){

            },
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
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        children: <Widget>[
          ListTile(
            title: Text('用户反馈', style: TextStyle(color: Colors.black)),
            trailing: Icon(Icons.feedback, color: Colors.black),
          ),
          ListTile(
            title: Text('系统设置', style: TextStyle(color: Colors.black)),
            trailing: Icon(Icons.settings, color: Colors.black),
          ),
          ListTile(
            title: Text('我要发布', style: TextStyle(color: Colors.black)),
            trailing: Icon(Icons.send, color: Colors.black),
          ),
          Divider(color: Colors.black45),
        ],
      ),
    );
  }
}
