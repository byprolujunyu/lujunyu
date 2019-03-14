package com.bm.container.module.personal.bean;

import java.util.List;

/**
 * Created by nfmomo on 17/4/24.
 */

public class MessageList {

    /**
     * currentPage : 1
     * data : [{"content":"测试数据","createUserName":"","id":"0a846e77-c42a-4bfe-b4e1-fa6484854ad5","isRead":0,"sendTime":"2017-04-24 11:14:33","sendType":2,"targetId":"","targetName":"","title":"测试数据"},{"content":"测试数据","createUserName":"","id":"0a846e77-c42a-4bfe-b4e1-fa6484854cd5","isRead":0,"sendTime":"2017-04-24 11:14:33","sendType":1,"targetId":"0a846e77-c42a-4bfe-b4e1-fa6484857ad5","targetName":"SHRU1SD","title":"测试数据"}]
     * error :
     * msg : 操作成功
     * pageCount : 1
     * pageData :
     * pageSize : 10
     * recordsTotal : 2
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
         * createUserName :
         * id : 0a846e77-c42a-4bfe-b4e1-fa6484854ad5
         * isRead : 0
         * sendTime : 2017-04-24 11:14:33
         * sendType : 2
         * targetId :
         * targetName :
         * title : 测试数据
         */

        private String content;
        private String createUserName;
        private String id;
        private String isRead;
        private String sendTime;
        private String sendType;
        private String targetId;
        private String targetName;
        private String title;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateUserName() {
            return createUserName;
        }

        public void setCreateUserName(String createUserName) {
            this.createUserName = createUserName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIsRead() {
            return isRead;
        }

        public void setIsRead(String isRead) {
            this.isRead = isRead;
        }

        public String getSendTime() {
            return sendTime;
        }

        public void setSendTime(String sendTime) {
            this.sendTime = sendTime;
        }

        public String getSendType() {
            return sendType;
        }

        public void setSendType(String sendType) {
            this.sendType = sendType;
        }

        public String getTargetId() {
            return targetId;
        }

        public void setTargetId(String targetId) {
            this.targetId = targetId;
        }

        public String getTargetName() {
            return targetName;
        }

        public void setTargetName(String targetName) {
            this.targetName = targetName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
