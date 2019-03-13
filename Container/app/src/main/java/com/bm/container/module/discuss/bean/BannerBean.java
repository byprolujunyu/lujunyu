package com.bm.container.module.discuss.bean;

import java.util.List;

/**
 * Created by nfmomo on 17/4/12.
 */

public class BannerBean {

    /**
     * currentPage : 1
     * data : [{"content":"测试数据","createTime":"2017-04-12 16:29:01","createUser":"","endTime":"2017-04-28 16:28:44","id":"0a846e77-cc2a-4bfe-b4e1-fa64848t7ad5","imageUrl":"","linkedUrl":"http://175.102.18.39:8081/young","startTime":"2017-04-12 16:28:40","status":0,"title":"测试数据","updateTime":"","updateUser":""}]
     * error :
     * msg : 操作成功
     * pageCount : 1
     * pageData :
     * pageSize : 3
     * recordsTotal : 1
     * status : 1
     */

    private String currentPage;
    private String error;
    private String msg;
    private String pageCount;
    private String pageData;
    private String pageSize;
    private String recordsTotal;
    private String status;
    private List<DataBean> data;

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getPageData() {
        return pageData;
    }

    public void setPageData(String pageData) {
        this.pageData = pageData;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(String recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * content : 测试数据
         * createTime : 2017-04-12 16:29:01
         * createUser :
         * endTime : 2017-04-28 16:28:44
         * id : 0a846e77-cc2a-4bfe-b4e1-fa64848t7ad5
         * imageUrl :
         * linkedUrl : http://175.102.18.39:8081/young
         * startTime : 2017-04-12 16:28:40
         * status : 0
         * title : 测试数据
         * updateTime :
         * updateUser :
         */

        private String content;
        private String createTime;
        private String createUser;
        private String endTime;
        private String id;
        private String imageUrl;
        private String linkedUrl;
        private String startTime;
        private String status;
        private String title;
        private String updateTime;
        private String updateUser;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreateUser() {
            return createUser;
        }

        public void setCreateUser(String createUser) {
            this.createUser = createUser;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getLinkedUrl() {
            return linkedUrl;
        }

        public void setLinkedUrl(String linkedUrl) {
            this.linkedUrl = linkedUrl;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getUpdateUser() {
            return updateUser;
        }

        public void setUpdateUser(String updateUser) {
            this.updateUser = updateUser;
        }
    }
}
