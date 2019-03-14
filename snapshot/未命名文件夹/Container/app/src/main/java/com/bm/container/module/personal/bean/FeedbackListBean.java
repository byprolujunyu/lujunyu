package com.bm.container.module.personal.bean;

import java.util.List;

/**
 * Created by nfmomo on 17/4/20.
 */

public class FeedbackListBean {

    /**
     * currentPage : 1
     * data : [{"content":"测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试","createTime":"2017-04-15 13:54:21","createUser":"测试","feedBackContent":"","id":"3fc512d7-378a-4b2f-a157-da3a25cb0071","status":0,"telephone":"15021534566","updateTime":"","updateUser":""},{"content":"Wohhlahkhahklhalkhlf;ahlkfhalhflahfhahfahkfhahfhaklhklafhlkahlkhfahwwhhwhhwjhwlhawhwhwahwhwhwhwhwa.hwahwajhwajhwajhjhhjhhvjhvjvhvhahahvjhvahajhvajhvahv;lhaahvahvvhaahahvahhahvvakhvahavhvahvhvva","createTime":"2017-04-12 12:53:48","createUser":"Wangyan","feedBackContent":"","id":"6c807537-40b5-44f6-ba54-464ab3a61087","status":0,"telephone":"13564793107","updateTime":"","updateUser":""},{"content":"测试","createTime":"2017-04-15 13:52:57","createUser":"测试","feedBackContent":"","id":"88f3d9d9-bf8d-4bc4-b825-1dc49ff04dc9","status":0,"telephone":"15021534566","updateTime":"","updateUser":""},{"content":"Craig Cree. E e33333","createTime":"2017-04-12 11:26:34","createUser":"Wangyan","feedBackContent":"","id":"ad4e08bf-8957-45fe-a171-23fd57cb808a","status":0,"telephone":"13564793107","updateTime":"","updateUser":""},{"content":"Craig Cree. E e","createTime":"2017-04-12 11:26:05","createUser":"Wangyan","feedBackContent":"","id":"dc8bc5e3-9ba6-4781-9d56-2eead5071eee","status":0,"telephone":"13564793107","updateTime":"","updateUser":""}]
     * error :
     * msg : 操作成功
     * pageCount : 1
     * pageData :
     * pageSize : 10
     * recordsTotal : 5
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
         * content : 测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试
         * createTime : 2017-04-15 13:54:21
         * createUser : 测试
         * feedBackContent :
         * id : 3fc512d7-378a-4b2f-a157-da3a25cb0071
         * status : 0
         * telephone : 15021534566
         * updateTime :
         * updateUser :
         */

        private String content;
        private String createTime;
        private String createUser;
        private String feedBackContent;
        private String id;
        private String status;
        private String telephone;
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

        public String getFeedBackContent() {
            return feedBackContent;
        }

        public void setFeedBackContent(String feedBackContent) {
            this.feedBackContent = feedBackContent;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
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
