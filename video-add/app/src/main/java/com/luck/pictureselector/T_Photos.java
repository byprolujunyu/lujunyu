package com.luck.pictureselector;

import java.util.List;

/**
 * Created by toplu1015 on 2018/2/1.
 */

public class T_Photos {


    private List<TNewPhotosBean> T_New_Photos;

    public List<TNewPhotosBean> getT_New_Photos() {
        return T_New_Photos;
    }

    public void setT_New_Photos(List<TNewPhotosBean> T_New_Photos) {
        this.T_New_Photos = T_New_Photos;
    }

    public static class TNewPhotosBean {
        /**
         * rowid : 17400
         * imguri : 440852c7-0a88-4c13-baa5-44e3fef28d1b
         * createtime : 2017-10-07T00:33:53Z
         * means : 鸡蛋清
         * md5 : 2e739476b3c8f917597a7269e59bf04b
         * width : 563.0
         * height : 1000.0
         * uristart : http://116.62.168.251:8080/newPhoto/
         * uriend : .jpg
         * isDelete : 1
         * random : BB3026DE-14A5-4158-8FED-9C7F20572A48
         */

        private Integer rowid;
        private String imguri;
        private String createtime;
        private String means;
        private String md5;
        private Double width;
        private Double height;
        private String uristart;
        private String uriend;
        private Integer isDelete;
        private String random;

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
    }
}
