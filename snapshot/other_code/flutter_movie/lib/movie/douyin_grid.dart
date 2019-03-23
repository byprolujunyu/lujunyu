import 'package:flutter/material.dart';
import 'package:dio/dio.dart';
import 'package:flutter_movie/play_params.dart';
import 'package:flutter_movie/play_video.dart';
import 'detail.dart';
import 'web_view.dart';
import 'package:flutter_easyrefresh/easy_refresh.dart';
import 'package:marquee_flutter/marquee_flutter.dart';

Dio dio = new Dio();

class DouyinGrid extends StatefulWidget {
  @override
  _DouyinGridState createState() => _DouyinGridState();
}

class _DouyinGridState extends State<DouyinGrid>  with AutomaticKeepAliveClientMixin {
  List datas = List();
  GlobalKey<RefreshHeaderState> _headerKeyList =
      new GlobalKey<RefreshHeaderState>();
  GlobalKey<RefreshFooterState> _footerKeyList =
      new GlobalKey<RefreshFooterState>();
  GlobalKey<RefreshHeaderState> _headerKeyGrid =
      new GlobalKey<RefreshHeaderState>();
  GlobalKey<RefreshFooterState> _footerKeyGrid =
      new GlobalKey<RefreshFooterState>();
  TabController _tabController;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _getData();
  }

  double width;
  double height;

  String findItemAll = "http://47.96.78.67:7070/video/page/";

  int pageSize = 18;
  int page = 1;

  bool init = false;

  Future _getData() async {
    setState(() {
      init = false;
    });
    var response = await Dio().get(findItemAll + "${page}/${pageSize}");
    var result = response.data;
    print(result);

    setState(() {
      datas.addAll(result['data']);
      init = true;
    });
  }

  @override
  Widget build(BuildContext context) {
    width = MediaQuery.of(context).size.width;
    height = MediaQuery.of(context).size.height;
    return new EasyRefresh(
      refreshHeader: ClassicsHeader(
        key: _headerKeyGrid,
        bgColor: Colors.transparent,
        textColor: Colors.black,
      ),
      refreshFooter: ClassicsFooter(
          key: _footerKeyGrid,
          loadHeight: 50.0,
          textColor: Colors.black,
          bgColor: Colors.transparent),
      child: GridView.builder(
        //ListView的Item
        itemCount: datas.length,
        gridDelegate:
            SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 3),
        itemBuilder: (BuildContext context, int index) {
          String url = datas[index]['imguri'];
          String time = datas[index]['createtime'];
          String means = datas[index]['means'];
          String uri = datas[index]['uri'];
          int id = datas[index]['id'];
          int isSave = datas[index]['isSave'];
          return Container(
            child: GestureDetector(
              child: Stack(
                children: <Widget>[
                  Container(
                    child: Image(
                      image: new NetworkImage(url),
                      fit: BoxFit.fill,
                    ),
                    width: width / 3,
                  ),
                  Container(
                    child: Text(
                      '${time}',
                      style: TextStyle(
                        fontSize: 10,
                        color: Colors.black,
                      ),
                    ),
                    decoration: new BoxDecoration(color: Colors.white70),
                  ),
                ],
                alignment: FractionalOffset(1.0, 0.0),
              ),
              onTap: () {
                Navigator.of(context)
                    .push(MaterialPageRoute(builder: (BuildContext ctx) {
                  return VideoApp(Params(id,url,uri,means,isSave,0));
                }));
              },
            ),
            margin: EdgeInsets.all(5.0),
          );
        },
      ),
      onRefresh: () async {
        setState(() {
          page = 1;
        });

        _getData();
      },
      loadMore: () async {
        setState(() {
          page = page + 1;
        });

        _getData();
      },
    );
  }

  @override
  // TODO: implement wantKeepAlive
  bool get wantKeepAlive => true;
}
