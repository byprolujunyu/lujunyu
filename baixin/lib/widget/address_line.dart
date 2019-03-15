import 'package:flutter/material.dart';

class AddressLine extends StatelessWidget {


  final double height;


  AddressLine({@required this.height});

  @override
  Widget build(BuildContext context) {
    return Container(
      width: MediaQuery
          .of(context)
          .size
          .width,
      height:height,
      child: Image.asset(
        'images/line.png',
        fit: BoxFit.fill,
      ),
    );
  }
}
