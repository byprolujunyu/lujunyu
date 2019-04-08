import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_fanxinren/model/lookup_model.dart';
import 'package:flutter_fanxinren/page/lookup/lookup_list.dart';
import 'package:flutter_fanxinren/provide/lookup_provide.dart';
import 'package:flutter_fanxinren/service/service_method.dart';
import 'package:provide/provide.dart';

class CatePage extends StatefulWidget {
  @override
  _CatePageState createState() => _CatePageState();
}

class _CatePageState extends State<CatePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: init
          ? Container(
              height: 2000,
              child: ListView.builder(
                itemBuilder: (context, index) {
                  return item(context, lookUpModel.data[index]);
                },
                itemCount: lookUpModel.data.length,
              ),
            )
          : Container(),
    );
  }

  int page = 1;

  bool init = false;

  @override
  void initState() {
    getResquest();
    super.initState();
  }

  LookUpModel lookUpModel;

  getResquest({uid = '689', uidios = '689'}) {
    var formData = {
      'curPage': '${page.toString()}',
      'uid': '${uid}',
      'uidios': '${uidios}'
    };
    print(formData);
    request('listAppFollowTask', formData: formData).then((val) {
      var data = json.decode(val.toString());
      print(data);
      setState(() {
        try {
          lookUpModel = LookUpModel.fromJson(data);
          init = true;
        } catch (e) {
          print(e);
        }
      });
    });
  }

  Widget item(BuildContext context, LookUpModel_Data data) {
    return Container(
      padding: EdgeInsets.all(8),
      child: Column(
        children: <Widget>[
          Container(
            child: Image.network(data.timage),
            height: 30,
            width: 30,
            decoration: BoxDecoration(borderRadius: BorderRadius.circular(100)),
          ),
        ],
      ),
    );
  }
}
