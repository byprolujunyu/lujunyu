package com.luck.pictureselector;

/**
 * Created by toplu1015 on 2018/5/25.
 */

public interface config {
    //主ip
    String URL_IP = "http://116.62.168.251:8080/";
    //列表接口返回全部
    String URL_FIND_ALL = "http://116.62.168.251:8080/VideoOperation/video/queryList.do";
    String URL_UPDATE_MD5 = URL_IP + "VideoOperation/updateByMd5.do";
    String URL_ADD_ITEM = URL_IP + "VideoOperation/addVideo.do";
    String URL_UPDATE_DELETE = URL_IP + "VideoOperation/updateByDelete.do";
    String URL_UPDATE_MEANS = URL_IP + "VideoOperation/updateByMeans.do";

    //新增参数
    //.add("videoUri", name)
    //.add("picUri", name1)
    //.add("md5", name2)
    String name = "http://oss-toplu1015.oss-cn-hangzhou.aliyuncs.com/";

    String endpoint = "oss-cn-hangzhou.aliyuncs.com";
    String accessKeyId = "LTAI1hHwGmsLvt2j";
    String accessKeySecret = "ZUsmXEyBmR9pZT7mog8S7ktuwit1ou";

    //PutObjectRequest put = new PutObjectRequest("oss-toplu1015", fileName, filpath);
    //PutObjectRequest putpic = new PutObjectRequest("oss-toplu1015", filePicName, path);
    //randomStr = java.util.UUID.randomUUID().toString();
    //fileName = "video/" + randomStr + ".mp4";mp4
    //filePicName = "picture/" + randomStr + ".jpg";
}
