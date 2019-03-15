import 'package:flutter/material.dart';
import "package:pull_to_refresh/pull_to_refresh.dart";
import 'package:dio/dio.dart';

// import 'package:flutter_smart_park/config/list.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
// import 'package:flutter_smart_park/config/style.dart';

class NewsListItem2 extends StatefulWidget {
  final Widget child;

  NewsListItem2({Key key, this.child}) : super(key: key);

  _NewsListItem2State createState() => _NewsListItem2State();
}

class _NewsListItem2State extends State<NewsListItem2>
    with AutomaticKeepAliveClientMixin {
  int page = 1;
  RefreshController _refreshController;
  List list = [];

  @override
  bool get wantKeepAlive => true;

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 375, height: 667)..init(context);
    super.build(context);
    return new SmartRefresher(
      enablePullDown: false,
      enablePullUp: true,
      controller: _refreshController,
      onRefresh: _onRefresh,
      footerBuilder: _footerCreate,
      footerConfig: LoadConfig(triggerDistance: 10.0),
      child: new ListView.builder(
        itemCount: list.length,
        itemBuilder: (context, index) {
          return CardWidget();
        },
      ),
    );
  }

  @override
  void initState() {
    _getList();
    _refreshController = new RefreshController();
    super.initState();
  }

  void _onRefresh(bool up) {
    if (up) {
      new Future.delayed(const Duration(milliseconds: 1000)).then((val) {
        _refreshController.sendBack(true, RefreshStatus.completed);
      });
    } else {
      new Future.delayed(const Duration(milliseconds: 1000)).then((val) {
        _getList();
      });
    }
  }

  Widget _footerCreate(BuildContext context, int mode) {
    return new ClassicIndicator(
      mode: mode,
      refreshingText: '加载中...',
      idleIcon: const Icon(Icons.arrow_upward),
      idleText: '上拉加载更多',
      completeText: '加载完成',
    );
  }

  Future _getList() async {
    try {
      Dio dio = new Dio();
      print(page);
      // Response response = await dio.get(
      //   servicePath['TuWanList'],
      //   queryParameters: {
      //     'page': page.toString(),
      //   },
      // );

      setState(() {
        list.addAll(['', '', '']);
      });
      print("object");
      _refreshController.sendBack(false, RefreshStatus.idle);
      // if (response.data['data'].length <= 0) {
      //   _refreshController.sendBack(false, RefreshStatus.completed);
      // } else {
      //   _refreshController.sendBack(false, RefreshStatus.idle);
      // }
      page += 1;
    } catch (e) {
      print(e);
    }
  }
}

class CardWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
        child: Column(
      children: <Widget>[
        Container(
          width: MediaQuery.of(context).size.width,
          height: 50,
          child: Center(
            child: Text('data'),
          ),
        ),
        new Card(
          margin: EdgeInsets.all(ScreenUtil().setWidth(10)),
          child: new Container(
            padding: EdgeInsets.all(ScreenUtil().setWidth(10)),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start, //对齐属性
              mainAxisAlignment: MainAxisAlignment.center, //主轴排列方式
              children: <Widget>[
                new Text(
                  "广州市工业信息化委关于遴选供用电主题用电安全问题调研课题承担单位的公告。",
                  style: TextStyle(
                    color: Colors.blue,
                    fontSize: ScreenUtil(allowFontScaling: true).setSp(16),
                  ),
                ),
                new Container(
                  margin: EdgeInsets.fromLTRB(
                    0.0,
                    ScreenUtil().setWidth(15),
                    0.0,
                    ScreenUtil().setWidth(15),
                  ),
                  child: new Row(
                    children: <Widget>[
                      new Icon(
                        Icons.account_balance,
                        size: ScreenUtil(allowFontScaling: true).setSp(14),
                      ),
                      Expanded(
                        child: new Text(
                          "广州市工业和信息化委员会",
                          style: TextStyle(
                            color: Colors.blue,
                            fontSize:
                                ScreenUtil(allowFontScaling: true).setSp(14),
                          ),
                        ),
                      ),
                      new Text("2019-02-12"),
                    ],
                  ),
                ),
                ButtonTheme.bar(
                  child: new Row(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    mainAxisAlignment: MainAxisAlignment.start,
                    children: <Widget>[
                      new Icon(
                        Icons.attach_money,
                        size: ScreenUtil(allowFontScaling: true).setSp(14),
                      ),
                      new Text("补贴最高："),
                      new Text(
                        "1000万",
                        style: TextStyle(
                          color: Color(0xFFFF4D00),
                          fontSize:
                              ScreenUtil(allowFontScaling: true).setSp(18),
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      ],
    ));
  }
}
