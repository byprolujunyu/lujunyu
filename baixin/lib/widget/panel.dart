import 'package:flip_panel/flip_panel.dart';
import 'package:flutter/material.dart';
final digits = [9,8,7,6,5,4,3,2,1,0];

class Panel extends StatefulWidget {
  @override
  _PanelState createState() => _PanelState();
}

class _PanelState extends State<Panel> {


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Center(
        child: Column(children: <Widget>[
          FlipPanel.builder(
            direction: FlipDirection.down,
            itemBuilder: (context, index) => Container(
              color: Colors.black,
              padding: const EdgeInsets.symmetric(horizontal: 6.0),
              child: Text(
                '${digits[index]}',
                style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 50.0,
                    color: Colors.white),
              ),
            ),
            itemsCount: digits.length,
            period: const Duration(milliseconds: 1000),
            loop: 1,
          ),


        ],)
      ),
    );
  }
}
