package com.luck.pictureselector;

import java.io.Serializable;

/**
 * Created by toplu1015 on 2018/5/24.
 */

public class Video implements Serializable {
    private String id;
    private String uri;
    private String date;
    private Integer flagDelete;
    private String means;
    private String imguri;
    private String md5;

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Video(String id, String uri, String date, Integer flagDelete, String means, String imguri) {
        this.id = id;
        this.uri = uri;
        this.date = date;
        this.flagDelete = flagDelete;
        this.means = means;
        this.imguri = imguri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Integer flagDelete) {
        this.flagDelete = flagDelete;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means;
    }

    public String getImguri() {
        return imguri;
    }

    public void setImguri(String imguri) {
        this.imguri = imguri;
    }
}
