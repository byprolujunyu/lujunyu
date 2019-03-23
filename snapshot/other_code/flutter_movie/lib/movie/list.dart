import 'package:flutter/material.dart';
import 'package:dio/dio.dart';
import 'detail.dart';
import 'web_view.dart';
import 'package:flutter_easyrefresh/easy_refresh.dart';
import 'package:marquee_flutter/marquee_flutter.dart';

Dio dio = new Dio();

class MovieList extends StatefulWidget {
  MovieList({Key key, @required this.mt}) : super(key: key);
  final String mt;

  @override
  _MovieListState createState() => _MovieListState();
}

class _MovieListState extends State<MovieList> with AutomaticKeepAliveClientMixin {
  int page = 1;
  int pageSize = 10;
  List mList = new List();
  List autorList = new List();
  var total = 0;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _getMovieList();
  }

  _getMovieList() async {
    int offset = (page - 1) * pageSize;
    var response = await dio.get(
        'http://www.liulongbin.top:3005/api/v2/movie/${widget.mt}?start=$offset&count=$pageSize');
    var result = response.data;
    print(result);

    setState(() {
      mList.addAll(result['subjects']);
      total = result['total'];
    });
  }

  _getMovieDetail(movie_id, movie_title) async {
    var response = await dio
        .get('http://www.liulongbin.top:3005/api/v2/movie/subject/$movie_id');
    var result = response.data;

    String mobelUri = result["mobile_url"];
    Navigator.of(context).push(MaterialPageRoute(builder: (BuildContext ctx) {
      return NewsWebPage(mobelUri, movie_title);
    }));
  }

  GlobalKey<RefreshHeaderState> _headerKeyList =
      new GlobalKey<RefreshHeaderState>();
  GlobalKey<RefreshFooterState> _footerKeyList =
      new GlobalKey<RefreshFooterState>();
  GlobalKey<RefreshHeaderState> _headerKeyGrid =
      new GlobalKey<RefreshHeaderState>();
  GlobalKey<RefreshFooterState> _footerKeyGrid =
      new GlobalKey<RefreshFooterState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body:  new EasyRefresh(
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
        onRefresh: () async {
          setState(() {
            page = 1;
          });

          _getMovieList();
        },
        loadMore: () async {
          setState(() {
            page = page + 1;
          });

          _getMovieList();
        },
        child: ListView.builder(
          itemCount: mList.length,
          itemBuilder: (BuildContext context, int i) {
            Map item = mList[i];
            List autors = item['casts'];
            return GestureDetector(
              onTap: () {
                print(item['id']);
                _getMovieDetail(item['id'], item['title']);
              },
              child: Container(
                height: 200,
                decoration: BoxDecoration(
//              color: Colors.red,
                  border: Border(
                    top: BorderSide(
                      color: Colors.black12,
                    ),
                  ),
                ),
                child: Row(
                  children: <Widget>[
                    FadeInImage.assetNetwork(
                      placeholder: "images/celebrity-default-medium.png",
                      image: "${item['images']['small']}",
                      width: 130.0,
                      height: 180.0,
                      fit: BoxFit.cover,
                    ),
                    Container(
                      height: 200,
                      padding: EdgeInsets.only(left: 10.0),
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.spaceAround,
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: <Widget>[
                          Text(
                            "电影名称:  ${item['title']}",
                            style: TextStyle(
                              fontSize: 12,
                            ),
                          ),
                          Text("上映时间： ${item['year']}年"),
                          Text("电影类型： ${item['genres'].join(', ')}"),
                          Text("豆瓣评分： ${item['rating']['average']} 分"),
                          Text("主要演员："),
                          Container(
                            child: Row(children: getAutorList(item)),
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
              ),
            );
          },
        ),
      ),
    );
  }

  List<Widget> getAutorList(item) {
    return List.generate(
        item['casts'].length,
        (int index) => Container(
              margin: EdgeInsets.symmetric(vertical: 0, horizontal: 5),
              child: CircleAvatar(
                backgroundImage: NetworkImage(item['casts'][index]['avatars'] ==
                        null
                    ? 'https://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png'
                    : item['casts'][index]['avatars']['small']),
              ),
            ));
  }

  @override
  // TODO: implement wantKeepAlive
  bool get wantKeepAlive => true;
}
