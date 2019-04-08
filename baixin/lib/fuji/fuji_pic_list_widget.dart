import 'package:flutter/material.dart';
import 'package:flutter_button/model/fuji_list_model.dart';
import 'package:flutter_button/provide/fujilist_provide.dart';

import 'package:provide/provide.dart';

import 'package:flutter_screenutil/flutter_screenutil.dart';

class FujiPicListWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Provide<FujiListProvide>(
        builder: (context, child, val) {
          var fujiList = val.fujiListModel.data;
          return toWrapList(context, fujiList);
        }
    );
  }

  Widget toWrapList(context, fujiList) {
    if (fujiList != null) {
      List<Widget> listWidget = fujiList.map((val) {
        return item(context, val);
      });
      return Wrap(
        children: listWidget,
        spacing: 2,
      );
    }
  }

  Widget item(BuildContext context, FujiList_Data data) {
    return Container(width: MediaQuery
        .of(context)
        .size
        .width, child: Text(data.voucherDesc),);
  }
}
