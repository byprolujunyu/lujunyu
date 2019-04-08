
import 'package:flutter/material.dart';
import 'package:flutter_button/provide/fujilist_provide.dart';

import 'package:provide/provide.dart';

import 'package:flutter_screenutil/flutter_screenutil.dart';


class FujiPicWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Provide<FujiListProvide>(
      builder: (context, child, val) {
        return Column(
            mainAxisAlignment: MainAxisAlignment.start,
            children: <Widget>[
              Container(
                height: MediaQuery.of(context).size.height / 4,
                width: MediaQuery.of(context).size.width,
                child: Image.network(
                  val.picUrl,
                  fit: BoxFit.fill,
                ),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.end,
                children: <Widget>[
                  Container(
                    decoration: BoxDecoration(
                      color: Colors.pink,
                      borderRadius: BorderRadius.circular(8),
                    ),
                    alignment: Alignment.center,
                    width: ScreenUtil().setWidth(200),
                    height: ScreenUtil().setHeight(80),
                    margin: EdgeInsets.all(5.0),
                    child: Text(
                      '使用优惠券',
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                ],
              ),
            ],
        );
      },
    );
  }
}
