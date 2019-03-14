package com.luck.pictureselector;

import java.util.List;

/**
 * Created by toplu1015 on 2018/2/14.
 */

public class Image {

    private List<TNewPhotoBean> t_new_photo;

    public List<TNewPhotoBean> getT_new_photo() {
        return t_new_photo;
    }

    public void setT_new_photo(List<TNewPhotoBean> t_new_photo) {
        this.t_new_photo = t_new_photo;
    }

    public static class TNewPhotoBean {
        /**
         * rowid : 17400
         * imguri : 440852c7-0a88-4c13-baa5-44e3fef28d1b
         * createtime : 2017-10-07 08:33:53.753
         * means : 鸡蛋清
         * md5 : 2e739476b3c8f917597a7269e59bf04b
         * width : 563.0
         * height : 1000.0
         * uristart : http://116.62.168.251:8080/newPhoto/
         * uriend : .jpg
         * isDelete : 1
         * random : BB3026DE-14A5-4158-8FED-9C7F20572A48
         * newUri : http://116.62.168.251:8080/newPhoto/440852c7-0a88-4c13-baa5-44e3fef28d1b.jpg
         */

        private int rowid;
        private String imguri;
        private String createtime;
        private String means;
        private String md5;
        private double width;
        private double height;
        private String uristart;
        private String uriend;
        private int isDelete;
        private String random;
        private String newUri;

        public int getRowid() {
            return rowid;
        }

        public void setRowid(int rowid) {
            this.rowid = rowid;
        }

        public String getImguri() {
            return imguri;
        }

        public void setImguri(String imguri) {
            this.imguri = imguri;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getMeans() {
            return means;
        }

        public void setMeans(String means) {
            this.means = means;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public String getUristart() {
            return uristart;
        }

        public void setUristart(String uristart) {
            this.uristart = uristart;
        }

        public String getUriend() {
            return uriend;
        }

        public void setUriend(String uriend) {
            this.uriend = uriend;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public String getRandom() {
            return random;
        }

        public void setRandom(String random) {
            this.random = random;
        }

        public String getNewUri() {
            return newUri;
        }

        public void setNewUri(String newUri) {
            this.newUri = newUri;
        }
    }
}
