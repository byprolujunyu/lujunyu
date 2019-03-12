import 'dart:convert';

class Location {
  num accuracy;
  String adCode;
  String address;
  num altitude;
  String aoiName;
  num bearing;
  String buildingId;
  String city;
  String cityCode;
  String coordType;
  String country;
  String district;
  num errorCode;
  String errorInfo;
  num floor;
  num gpsAccuracyStatus;
  bool isFixLastLocation;
  bool isMock;
  bool isOffset;
  num latitude;
  String locationDetail;
  LocationQualityReport locationQualityReport;
  num locationType;
  num longitude;
  String poiName;
  String provider;
  String province;
  num satellites;
  num speed;
  String street;
  String streetNum;
  num trustedLevel;

  Location({
    this.accuracy,
    this.adCode,
    this.address,
    this.altitude,
    this.aoiName,
    this.bearing,
    this.buildingId,
    this.city,
    this.cityCode,
    this.coordType,
    this.country,
    this.district,
    this.errorCode,
    this.errorInfo,
    this.floor,
    this.gpsAccuracyStatus,
    this.isFixLastLocation,
    this.isMock,
    this.isOffset,
    this.latitude,
    this.locationDetail,
    this.locationQualityReport,
    this.locationType,
    this.longitude,
    this.poiName,
    this.provider,
    this.province,
    this.satellites,
    this.speed,
    this.street,
    this.streetNum,
    this.trustedLevel,
  });

  Location.fromJson(Map<String, dynamic> json) {
    accuracy = json['accuracy'] as num;
    adCode = json['adCode'] as String;
    address = json['address'] as String;
    altitude = json['altitude'] as num;
    aoiName = json['aoiName'] as String;
    bearing = json['bearing'] as num;
    buildingId = json['buildingId'] as String;
    city = json['city'] as String;
    cityCode = json['cityCode'] as String;
    coordType = json['coordType'] as String;
    country = json['country'] as String;
    district = json['district'] as String;
    errorCode = json['errorCode'] as int;
    errorInfo = json['errorInfo'] as String;
    floor = json['floor'] as int;
    gpsAccuracyStatus = json['gpsAccuracyStatus'] as int;
    isFixLastLocation = json['isFixLastLocation'] as bool;
    isMock = json['isMock'] as bool;
    isOffset = json['isOffset'] as bool;
    latitude = json['latitude'] as num;
    locationDetail = json['locationDetail'] as String;
    locationQualityReport = json['locationQualityReport'] != null
        ? LocationQualityReport.fromJson(json['locationQualityReport'])
        : null;
    locationType = json['locationType'] as int;
    longitude = json['longitude'] as num;
    poiName = json['poiName'] as String;
    provider = json['provider'] as String;
    province = json['province'] as String;
    satellites = json['satellites'] as int;
    speed = json['speed'] as num;
    street = json['street'] as String;
    streetNum = json['streetNum'] as String;
    trustedLevel = json['trustedLevel'] as int;
  }

  Map<String, dynamic> toJson() {
    final data = <String, dynamic>{};
    data['accuracy'] = this.accuracy;
    data['adCode'] = this.adCode;
    data['address'] = this.address;
    data['altitude'] = this.altitude;
    data['aoiName'] = this.aoiName;
    data['bearing'] = this.bearing;
    data['buildingId'] = this.buildingId;
    data['city'] = this.city;
    data['cityCode'] = this.cityCode;
    data['coordType'] = this.coordType;
    data['country'] = this.country;
    data['district'] = this.district;
    data['errorCode'] = this.errorCode;
    data['errorInfo'] = this.errorInfo;
    data['floor'] = this.floor;
    data['gpsAccuracyStatus'] = this.gpsAccuracyStatus;
    data['isFixLastLocation'] = this.isFixLastLocation;
    data['isMock'] = this.isMock;
    data['isOffset'] = this.isOffset;
    data['latitude'] = this.latitude;
    data['locationDetail'] = this.locationDetail;
    if (this.locationQualityReport != null) {
      data['locationQualityReport'] = this.locationQualityReport.toJson();
    }
    data['locationType'] = this.locationType;
    data['longitude'] = this.longitude;
    data['poiName'] = this.poiName;
    data['provider'] = this.provider;
    data['province'] = this.province;
    data['satellites'] = this.satellites;
    data['speed'] = this.speed;
    data['street'] = this.street;
    data['streetNum'] = this.streetNum;
    data['trustedLevel'] = this.trustedLevel;
    return data;
  }

  Location copyWith({
    num accuracy,
    String adCode,
    String address,
    num altitude,
    String aoiName,
    num bearing,
    String buildingId,
    String city,
    String cityCode,
    String coordType,
    String country,
    String district,
    num errorCode,
    String errorInfo,
    String floor,
    num gpsAccuracyStatus,
    bool isFixLastLocation,
    bool isMock,
    bool isOffset,
    num latitude,
    String locationDetail,
    LocationQualityReport locationQualityReport,
    num locationType,
    num longitude,
    String poiName,
    String provider,
    String province,
    num satellites,
    num speed,
    String street,
    String streetNum,
    num trustedLevel,
  }) {
    return Location(
      accuracy: accuracy ?? this.accuracy,
      adCode: adCode ?? this.adCode,
      address: address ?? this.address,
      altitude: altitude ?? this.altitude,
      aoiName: aoiName ?? this.aoiName,
      bearing: bearing ?? this.bearing,
      buildingId: buildingId ?? this.buildingId,
      city: city ?? this.city,
      cityCode: cityCode ?? this.cityCode,
      coordType: coordType ?? this.coordType,
      country: country ?? this.country,
      district: district ?? this.district,
      errorCode: errorCode ?? this.errorCode,
      errorInfo: errorInfo ?? this.errorInfo,
      floor: floor ?? this.floor,
      gpsAccuracyStatus: gpsAccuracyStatus ?? this.gpsAccuracyStatus,
      isFixLastLocation: isFixLastLocation ?? this.isFixLastLocation,
      isMock: isMock ?? this.isMock,
      isOffset: isOffset ?? this.isOffset,
      latitude: latitude ?? this.latitude,
      locationDetail: locationDetail ?? this.locationDetail,
      locationQualityReport:
          locationQualityReport ?? this.locationQualityReport,
      locationType: locationType ?? this.locationType,
      longitude: longitude ?? this.longitude,
      poiName: poiName ?? this.poiName,
      provider: provider ?? this.provider,
      province: province ?? this.province,
      satellites: satellites ?? this.satellites,
      speed: speed ?? this.speed,
      street: street ?? this.street,
      streetNum: streetNum ?? this.streetNum,
      trustedLevel: trustedLevel ?? this.trustedLevel,
    );
  }

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is Location &&
          runtimeType == other.runtimeType &&
          accuracy == other.accuracy &&
          adCode == other.adCode &&
          address == other.address &&
          altitude == other.altitude &&
          aoiName == other.aoiName &&
          bearing == other.bearing &&
          buildingId == other.buildingId &&
          city == other.city &&
          cityCode == other.cityCode &&
          coordType == other.coordType &&
          country == other.country &&
          district == other.district &&
          errorCode == other.errorCode &&
          errorInfo == other.errorInfo &&
          floor == other.floor &&
          gpsAccuracyStatus == other.gpsAccuracyStatus &&
          isFixLastLocation == other.isFixLastLocation &&
          isMock == other.isMock &&
          isOffset == other.isOffset &&
          latitude == other.latitude &&
          locationDetail == other.locationDetail &&
          locationQualityReport == other.locationQualityReport &&
          locationType == other.locationType &&
          longitude == other.longitude &&
          poiName == other.poiName &&
          provider == other.provider &&
          province == other.province &&
          satellites == other.satellites &&
          speed == other.speed &&
          street == other.street &&
          streetNum == other.streetNum &&
          trustedLevel == other.trustedLevel;

  @override
  int get hashCode =>
      accuracy.hashCode ^
      adCode.hashCode ^
      address.hashCode ^
      altitude.hashCode ^
      aoiName.hashCode ^
      bearing.hashCode ^
      buildingId.hashCode ^
      city.hashCode ^
      cityCode.hashCode ^
      coordType.hashCode ^
      country.hashCode ^
      district.hashCode ^
      errorCode.hashCode ^
      errorInfo.hashCode ^
      floor.hashCode ^
      gpsAccuracyStatus.hashCode ^
      isFixLastLocation.hashCode ^
      isMock.hashCode ^
      isOffset.hashCode ^
      latitude.hashCode ^
      locationDetail.hashCode ^
      locationQualityReport.hashCode ^
      locationType.hashCode ^
      longitude.hashCode ^
      poiName.hashCode ^
      provider.hashCode ^
      province.hashCode ^
      satellites.hashCode ^
      speed.hashCode ^
      street.hashCode ^
      streetNum.hashCode ^
      trustedLevel.hashCode;

  @override
  String toString() {
    return JsonEncoder.withIndent('  ').convert(toJson());
  }
}

class LocationQualityReport {
  String adviseMessage;
  num gpsSatellites;
  num gpsStatus;
  bool isWifiAble;
  num netUseTime;
  String networkType;

  LocationQualityReport({
    this.adviseMessage,
    this.gpsSatellites,
    this.gpsStatus,
    this.isWifiAble,
    this.netUseTime,
    this.networkType,
  });

  LocationQualityReport.fromJson(Map<String, dynamic> json) {
    adviseMessage = json['adviseMessage'] as String;
    gpsSatellites = json['gpsSatellites'] as int;
    gpsStatus = json['gpsStatus'] as int;
    isWifiAble = json['isWifiAble'] as bool;
    netUseTime = json['netUseTime'] as int;
    networkType = json['networkType'] as String;
  }

  Map<String, dynamic> toJson() {
    final data = <String, dynamic>{};
    data['adviseMessage'] = this.adviseMessage;
    data['gpsSatellites'] = this.gpsSatellites;
    data['gpsStatus'] = this.gpsStatus;
    data['isWifiAble'] = this.isWifiAble;
    data['netUseTime'] = this.netUseTime;
    data['networkType'] = this.networkType;
    return data;
  }

  LocationQualityReport copyWith({
    String adviseMessage,
    num gpsSatellites,
    num gpsStatus,
    bool isWifiAble,
    num netUseTime,
    String networkType,
  }) {
    return LocationQualityReport(
      adviseMessage: adviseMessage ?? this.adviseMessage,
      gpsSatellites: gpsSatellites ?? this.gpsSatellites,
      gpsStatus: gpsStatus ?? this.gpsStatus,
      isWifiAble: isWifiAble ?? this.isWifiAble,
      netUseTime: netUseTime ?? this.netUseTime,
      networkType: networkType ?? this.networkType,
    );
  }

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is LocationQualityReport &&
          runtimeType == other.runtimeType &&
          adviseMessage == other.adviseMessage &&
          gpsSatellites == other.gpsSatellites &&
          gpsStatus == other.gpsStatus &&
          isWifiAble == other.isWifiAble &&
          netUseTime == other.netUseTime &&
          networkType == other.networkType;

  @override
  int get hashCode =>
      adviseMessage.hashCode ^
      gpsSatellites.hashCode ^
      gpsStatus.hashCode ^
      isWifiAble.hashCode ^
      netUseTime.hashCode ^
      networkType.hashCode;

  @override
  String toString() {
    return JsonEncoder.withIndent('  ').convert(toJson());
  }
}
