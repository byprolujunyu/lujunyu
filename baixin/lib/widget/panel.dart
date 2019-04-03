import 'package:flip_panel/flip_panel.dart';
import 'package:flutter/material.dart';
import 'package:flutter_swiper/flutter_swiper.dart';

final digits = [
  'http://116.62.168.251:8090/7523e8c1-d349-4b82-92e4-c43414a2adf4.jpg',
  'http://116.62.168.251:8090/157487f7-d971-4fe5-af7e-d2027ea9fcb7.jpg',
  'http://116.62.168.251:8090/0b2fad9d-6f75-4e33-9917-b36df82c8670.jpg'
];

class Panel extends StatefulWidget {
  @override
  _PanelState createState() => _PanelState();
}

class _PanelState extends State<Panel> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Swiper(
      itemCount: digits.length,
      itemBuilder: (BuildContext context, int index) {
        return index != 2 ? onlyPic(index) : buttonPic();
      },
    ));
  }

  Widget onlyPic(index) {
    return Container(
      width: MediaQuery.of(context).size.width,
      height: MediaQuery.of(context).size.height,
      child: Image.network(
        '${digits[index]}',
        fit: BoxFit.fill,
      ),
    );
  }

  Widget buttonPic() {
    return Container(
      height: MediaQuery.of(context).size.height,
      width: MediaQuery.of(context).size.width,
      child: Stack(
        children: <Widget>[
          Container(
              height: MediaQuery.of(context).size.height,
              width: MediaQuery.of(context).size.width,
            child: Image.network('${digits[2]}',fit: BoxFit.fill,),
          ),
          RaisedButton(
            onPressed: () {},
            child: Container(color:Colors.grey,child: Text(
              '立即体验',
             
            ),),
          )
        ],
        alignment: FractionalOffset(0.5, 0.8),
      ),
    );
  }
}
