import 'package:flutter/material.dart';
import 'package:flutter_fanxinren/model/lookup_model.dart';
import 'package:flutter_fanxinren/provide/lookup_provide.dart';
import 'package:provide/provide.dart';
import 'package:flutter_easyrefresh/easy_refresh.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class LookUpList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Provide<LookUpProvide>(
      builder: (context, child, val) {
        List dataList = val.lookUpModel.data;
        return Container(
          height: 2000,
          child: ListView.builder(
              itemCount: dataList.length,
              itemBuilder: (context, index) {
                return item(context, dataList[index]);
              }),
        );
      },
    );
  }

  Widget item(BuildContext context, LookUpModel_Data data) {
    return Container(
      padding: EdgeInsets.all(8),
      child: Column(
        children: <Widget>[
          Text(data.faddressexame),
        ],
      ),
    );
  }
}
