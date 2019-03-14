import 'package:flutter/material.dart';
import 'package:dio/dio.dart';

Dio dio = new Dio();

class MovieDetail extends StatefulWidget {
  @override
  _MovieDetailState createState() => _MovieDetailState();

  String movie_id;

  String movie_title;

  MovieDetail(this.movie_id, this.movie_title);
}

class _MovieDetailState extends State<MovieDetail> {
  var data;

  _getMovieDetail() async {
    var response = await dio.get(
        'http://www.liulongbin.top:3005/api/v2/movie/subject/${widget.movie_id}');
    var result = response.data;
    print(result);
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _getMovieDetail();
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.movie_title),
        centerTitle: true,
        backgroundColor: Colors.pinkAccent,
      ),
//      body:
    );
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();


  }
}
