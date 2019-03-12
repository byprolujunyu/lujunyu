import 'package:amap_base/amap_base.dart';
import 'package:flutter/material.dart';
import 'package:flutter_button/address/address_ios_page.dart';
import 'package:flutter_button/db/db_helper_address.dart';
import 'package:flutter_button/model/address.dart';
import 'package:flutter_button/utils/loading_progress.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

class AddressMap extends StatefulWidget {
  @override
  _AddressMapState createState() => _AddressMapState();
}

class _AddressMapState extends State<AddressMap>
    with AutomaticKeepAliveClientMixin {
  MyLocationStyle _myLocationStyle = MyLocationStyle();

  @override
  void initState() {
    super.initState();
    _amapLocation.init();
    // TODO: implement initState
  }

  final _amapLocation = AMapLocation();

  List<Location> _result = [];

  AMapController _controller;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('位置'),
        elevation: 0.0,
      ),
      body: Container(
          child: Column(
        children: <Widget>[
          Flexible(
            child: AMapView(
              onAMapViewCreated: (controller) {
                _controller = controller;
              },
              amapOptions: AMapOptions(
                compassEnabled: false,
                zoomControlsEnabled: true,
                logoPosition: LOGO_POSITION_BOTTOM_CENTER,
                camera: CameraPosition(
                  target: LatLng(40.851827, 111.801637),
                  zoom: 15,
                ),
              ),
            ),
          ),
          Flexible(
            child: Builder(builder: (context) {
              return ListView(
                children: <Widget>[
                  Row(
                    mainAxisAlignment: MainAxisAlignment.end,
                    children: <Widget>[
                      Padding(
                        child: IconButton(
                            icon: Icon(Icons.add_location),
                            onPressed: () {
                              _updateMyLocationStyle(context,
                                  showMyLocation: true);
                            }),
                        padding: EdgeInsets.only(right: 10.0),
                      ),
                      Container(
                        child: Text("定位"),
                        margin: EdgeInsets.only(right: 20.0),
                      ),
                    ],
                  ),
                ],
              );
            }),
          ),
        ],
      )),
    );
  }

  void _updateMyLocationStyle(
    BuildContext context, {
    String myLocationIcon,
    double anchorU,
    double anchorV,
    Color radiusFillColor,
    Color strokeColor,
    double strokeWidth,
    int myLocationType,
    int interval,
    bool showMyLocation,
    bool showsAccuracyRing,
    bool showsHeadingIndicator,
    Color locationDotBgColor,
    Color locationDotFillColor,
    bool enablePulseAnnimation,
    String image,
  }) async {
    if (await Permissions().requestPermission()) {
      _myLocationStyle = _myLocationStyle.copyWith(
        myLocationIcon: myLocationIcon,
        anchorU: anchorU,
        anchorV: anchorV,
        radiusFillColor: radiusFillColor,
        strokeColor: strokeColor,
        strokeWidth: strokeWidth,
        myLocationType: myLocationType,
        interval: interval,
        showMyLocation: showMyLocation,
        showsAccuracyRing: showsAccuracyRing,
        showsHeadingIndicator: showsHeadingIndicator,
        locationDotBgColor: locationDotBgColor,
        locationDotFillColor: locationDotFillColor,
        enablePulseAnnimation: enablePulseAnnimation,
        image: image,
      );
      _controller.setMyLocationStyle(_myLocationStyle);
    } else {}
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
    _amapLocation.stopLocate();
  }

  @override
  // TODO: implement wantKeepAlive
  bool get wantKeepAlive => true;
}
