import 'package:flutter/material.dart';
import 'package:flutter_swiper/flutter_swiper.dart';
import 'package:dio/dio.dart';
import 'package:flutter_trip/constants/index.dart';
import 'package:flutter_trip/widget/loading_progress.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:http/http.dart' as http;
const APPBAR_SCROLL_OFFSET = 100;

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  List data = [];

  bool init = false;

  double appBarAlpha = 0;

  @override
  void initState() {
    super.initState();
    _getSwiperUIData();
  }

  Future _getSwiperUIData() async {
    var response = await Dio().get(KString.douyu_api_3);
    var result = response.data;
    print(result);
    setState(() {
      data = result['data'];
      init = true;
    });
  }

  @override
  Widget build(BuildContext context) {
    ScreenUtil.instance = ScreenUtil(width: 750, height: 1334)..init(context);
    return Scaffold(
      body: init
          ? Stack(
              children: <Widget>[
                Center(
                  child: MediaQuery.removePadding(
                    removeTop: true,
                    context: context,
                    child: NotificationListener(
                      onNotification: (scroll) {
                        if (scroll is ScrollNotification && scroll.depth == 0) {
                          _onScroll(scroll.metrics.pixels);
                        }
                      },
                      child: ListView(
                        //    padding: EdgeInsets.all(0),
                        children: <Widget>[
                          Container(
                            height: ScreenUtil().setHeight(333),
                            child: Swiper(
                              autoplay: true,
                              itemCount: data.length,
                              itemBuilder: (BuildContext context, int index) {
                                return Image.network(
                                  "${data[index]['pic_url']}",
                                  fit: BoxFit.fill,
                                );
                              },
                              pagination: SwiperPagination(),
                            ),
                          ),
                          Container(
                            height: 1600,
                          ),
                        ],
                      ),
                    ),
                  ),
                ),
                Opacity(
                  opacity: appBarAlpha,
                  child: Container(
                    height: ScreenUtil().setHeight(120),
                    decoration: BoxDecoration(color: Colors.white),
                    child: Center(
                      child: Padding(
                        padding: EdgeInsets.only(top: 20),
                        child: Text(
                          KString.homeTxt,
                        ),
                      ),
                    ),
                  ),
                ),
              ],
            )
          : Container(
              child: Center(
                child: Loading(),
              ),
            ),
    );
  }

  void _onScroll(offset) {
    print(offset);
    double alpha = offset / APPBAR_SCROLL_OFFSET;
    if (alpha < 0) {
      alpha = 0;
    } else if (alpha > 1) {
      alpha = 1;
    }
    setState(() {
      appBarAlpha = alpha;
    });
    print(appBarAlpha);
  }
}
