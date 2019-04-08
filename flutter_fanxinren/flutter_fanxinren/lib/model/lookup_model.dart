class LookUpModel {
  int status;
  String message;
  int last;
  int countsize;
  int countpage;
  List<LookUpModel_Data> data;

  LookUpModel(
      {this.status,
        this.message,
        this.last,
        this.countsize,
        this.countpage,
        this.data});

  LookUpModel.fromJson(Map<String, dynamic> json) {
    status = json['status'];
    message = json['message'];
    last = json['last'];
    countsize = json['countsize'];
    countpage = json['countpage'];
    if (json['data'] != null) {
      data = new List<LookUpModel_Data>();
      json['data'].forEach((v) {
        data.add(new LookUpModel_Data.fromJson(v));
      });
    }
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['status'] = this.status;
    data['message'] = this.message;
    data['last'] = this.last;
    data['countsize'] = this.countsize;
    data['countpage'] = this.countpage;
    if (this.data != null) {
      data['data'] = this.data.map((v) => v.toJson()).toList();
    }
    return data;
  }
}

class LookUpModel_Data {
  int uid;
  String uname;
  String uimg;
  int ustate;
  int fid;
  String ftitletext;
  List<Filedynamicids> filedynamicids;
  String timage;
  String faddressexame;
  String fuptime;
  int likecount;
  int replycount;
  Null cycount;
  int likeb;
  String type;
  Null examine;

  LookUpModel_Data(
      {this.uid,
        this.uname,
        this.uimg,
        this.ustate,
        this.fid,
        this.ftitletext,
        this.filedynamicids,
        this.timage,
        this.faddressexame,
        this.fuptime,
        this.likecount,
        this.replycount,
        this.cycount,
        this.likeb,
        this.type,
        this.examine});

  LookUpModel_Data.fromJson(Map<String, dynamic> json) {
    uid = json['uid'];
    uname = json['uname'];
    uimg = json['uimg'];
    ustate = json['ustate'];
    fid = json['fid'];
    ftitletext = json['ftitletext'];
    if (json['filedynamicids'] != null) {
      filedynamicids = new List<Filedynamicids>();
      json['filedynamicids'].forEach((v) {
        filedynamicids.add(new Filedynamicids.fromJson(v));
      });
    }
    timage = json['timage'];
    faddressexame = json['faddressexame'];
    fuptime = json['fuptime'];
    likecount = json['likecount'];
    replycount = json['replycount'];
    cycount = json['cycount'];
    likeb = json['likeb'];
    type = json['type'];
    examine = json['examine'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['uid'] = this.uid;
    data['uname'] = this.uname;
    data['uimg'] = this.uimg;
    data['ustate'] = this.ustate;
    data['fid'] = this.fid;
    data['ftitletext'] = this.ftitletext;
    if (this.filedynamicids != null) {
      data['filedynamicids'] =
          this.filedynamicids.map((v) => v.toJson()).toList();
    }
    data['timage'] = this.timage;
    data['faddressexame'] = this.faddressexame;
    data['fuptime'] = this.fuptime;
    data['likecount'] = this.likecount;
    data['replycount'] = this.replycount;
    data['cycount'] = this.cycount;
    data['likeb'] = this.likeb;
    data['type'] = this.type;
    data['examine'] = this.examine;
    return data;
  }
}

class Filedynamicids {
  int imageid;
  String filed;
  String filedytype;

  Filedynamicids({this.imageid, this.filed, this.filedytype});

  Filedynamicids.fromJson(Map<String, dynamic> json) {
    imageid = json['imageid'];
    filed = json['filed'];
    filedytype = json['filedytype'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['imageid'] = this.imageid;
    data['filed'] = this.filed;
    data['filedytype'] = this.filedytype;
    return data;
  }
}