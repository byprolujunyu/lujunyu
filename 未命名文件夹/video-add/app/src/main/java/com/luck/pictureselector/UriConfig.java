package com.luck.pictureselector;

/**
 * Created by toplu1015 on 2018/5/25.
 */

public interface UriConfig {
    //主ip
    String URL_IP = "http://116.62.168.251:8080/";
    //列表接口返回全部
    String URL_FIND_ALL = "http://116.62.168.251:8080/VideoOperation/video/queryList.do";
    String URL_UPDATE_MD5 = URL_IP + "VideoOperation/updateByMd5.do";
    String URL_ADD_ITEM = URL_IP + "VideoOperation/addVideo.do";
    String URL_ADD_NEW = "";
    String URL_ADD_ROLE = "http://47.96.78.67:7070/video/add/role";

    String URL_UPDATE_DELETE = URL_IP + "VideoOperation/updateByDelete.do";
    String URL_UPDATE_MEANS = URL_IP + "VideoOperation/updateByMeans.do";
    String URL_ADD_NAJIE = URL_IP + "NanJieAblum/add.do";
    String URL_QUERY_NAJIE = URL_IP + "NanJieAblum/findAll.do";
    String URL_ADD_NAJIE2 = "http://116.62.168.251:8080/Nanjie/add.do";
    String URL_ADD = "http://116.62.168.251:8080/Gallery/add.do";
}
