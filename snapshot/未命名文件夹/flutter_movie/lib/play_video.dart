import 'package:dio/dio.dart';
import 'package:flutter_movie/play_params.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:video_player/video_player.dart';
import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';

class VideoApp extends StatefulWidget {
  Params p;

  VideoApp(this.p);

  @override
  _VideoAppState createState() => _VideoAppState();
}

class _VideoAppState extends State<VideoApp> {
  VideoPlayerController _controller;

  @override
  void initState() {
    super.initState();
    judge();
    String uri = widget.p.uri;
    print(uri);
    _controller = VideoPlayerController.network(uri)
      ..initialize().then((_) {
        // Ensure the first frame is shown after the video is initialized, even before the play button has been pressed.
        setState(() {
          init = true;
        });

        print('ok');
      });
  }

  bool clicked = false;

  // bool isSave = false;

  bool init = false;

  @override
  Widget build(BuildContext context) {
    icon = (widget.p.type == 0?Icon(Icons.live_tv):Icon(Icons.home));
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.purple,
        title: Container(
          child: ListView(
            children: <Widget>[
              Text(
                widget.p.means,
                style: TextStyle(),
              ),
            ],
            scrollDirection: Axis.horizontal,
          ),
          margin: EdgeInsets.all(15.0),
        ),
        actions: <Widget>[
          IconButton(
              icon: icon,
              onPressed: () {
                widget.p.type==0?
                _add():_delete();
              })
        ],
      ),
      body: Center(
        child: init
            ? AspectRatio(
                aspectRatio: _controller.value.aspectRatio,
                child: VideoPlayer(_controller),
              )
            : Container(
                child: Center(
                  child: new CircularProgressIndicator(
                    strokeWidth: 4.0,
                    backgroundColor: Colors.blue,
                    // value: 0.2,
                    valueColor: new AlwaysStoppedAnimation<Color>(Colors.red),
                  ),
                ),
              ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          setState(() {
            _controller.value.isPlaying
                ? _controller.pause()
                : _controller.play();
          });
        },
        child: Icon(
          _controller.value.isPlaying ? Icons.pause : Icons.play_arrow,
        ),
      ),
    );
  }

  @override
  void dispose() {
    super.dispose();
    _controller.dispose();
  }

  void _add() async {
    var response =
        await Dio().post("http://47.96.78.67:7070/video/save/${widget.p.id}/1");

    var result = response.data;

    print(result);

    if (result['data'] == 'ok') {
      showShortToast("收藏ok");
    } else {
      showShortToast("收藏失败");
    }
  }

  void _delete() async {
    var response =
        await Dio().post("http://47.96.78.67:7070/video/save/${widget.p.id}/0");

    var result = response.data;

    print(result);

    if (result['data'] == 'ok') {
      showShortToast("取消收藏ok");
    } else {
      showShortToast("取消收藏失败");
    }
  }

  var icon = Icon(Icons.live_tv);

  void judge() async {
    var response = await Dio()
        .post("http://47.96.78.67:7070/video/is/save/${widget.p.id}");

    var result = response.data;

    print(result);

    setState(() {

    });
  }

  void showShortToast(str) {
    Fluttertoast.showToast(
        msg: "${str}", toastLength: Toast.LENGTH_SHORT, timeInSecForIos: 1);
  }
}
