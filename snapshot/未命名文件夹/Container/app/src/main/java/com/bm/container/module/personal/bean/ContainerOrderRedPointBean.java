package com.bm.container.module.personal.bean;

/**
 * Created by kec on 2017/6/27.
 */

public class ContainerOrderRedPointBean {


    /**
     * currentPage :
     * data : {"allCount":0,"noCount":0,"okCount":0,"deliveryCount":0,"finishCount":0}
     * error :
     * msg :
     * pageCount :
     * pageData :
     * pageSize :
     * recordsTotal :
     * status : 1
     */

    private String currentPage;
    private DataBean data;
    private String error;
    private String msg;
    private String pageCount;
    private String pageData;
    private String pageSize;
    private String recordsTotal;
    private String status;

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean {
        /**
         * allCount : 0
         * noCount : 0
         * okCount : 0
         * deliveryCount : 0
         * finishCount : 0
         * cancelCount : 0
         */

        private int allCount;
        private int noCount;
        private int okCount;
        private int deliveryCount;
        private int finishCount;
        private int cancelCount;

        public int getAllCount() {
            return allCount;
        }

        public void setAllCount(int allCount) {
            this.allCount = allCount;
        }

        public int getNoCount() {
            return noCount;
        }

        public void setNoCount(int noCount) {
            this.noCount = noCount;
        }

        public int getOkCount() {
            return okCount;
        }

        public void setOkCount(int okCount) {
            this.okCount = okCount;
        }

        public int getDeliveryCount() {
            return deliveryCount;
        }

        public void setDeliveryCount(int deliveryCount) {
            this.deliveryCount = deliveryCount;
        }

        public int getFinishCount() {
            return finishCount;
        }

        public void setFinishCount(int finishCount) {
            this.finishCount = finishCount;
        }

        public int getCancelCount() {
            return cancelCount;
        }

        public void setCancelCount(int cancelCount) {
            this.cancelCount = cancelCount;
        }

    }
}
