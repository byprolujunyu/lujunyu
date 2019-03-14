package com.bm.container.entity;

/**
 * Created by kec on 2017/6/30.
 */

public class SaveSaleOfferInfoEntity {


    /**
     * currentPage :
     * data : {"billCheque":"","billContent":"","billTelephone":"","billType":"","billTypeName":"","containerId":"6bc1f902-6a8e-4123-b98a-fc048e5b6408","createTime":"","createUser":"","createUserName":"","id":"2365ae69-7ec7-421c-ac8a-e9b16f5ae252","price":500,"updateTime":"","updateUser":""}
     * error :
     * msg : 您有5次出价机会，目前已使用了1次出价机会，如再想出价，请谨慎考虑好再出价。
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
         * billCheque :
         * billContent :
         * billTelephone :
         * billType :
         * billTypeName :
         * containerId : 6bc1f902-6a8e-4123-b98a-fc048e5b6408
         * createTime :
         * createUser :
         * createUserName :
         * id : 2365ae69-7ec7-421c-ac8a-e9b16f5ae252
         * price : 500.0
         * updateTime :
         * updateUser :
         */

        private String billCheque;
        private String billContent;
        private String billTelephone;
        private String billType;
        private String billTypeName;
        private String containerId;
        private String createTime;
        private String createUser;
        private String createUserName;
        private String id;
        private String price;
        private String updateTime;
        private String updateUser;

        public String getBillCheque() {
            return billCheque;
        }

        public void setBillCheque(String billCheque) {
            this.billCheque = billCheque;
        }

        public String getBillContent() {
            return billContent;
        }

        public void setBillContent(String billContent) {
            this.billContent = billContent;
        }

        public String getBillTelephone() {
            return billTelephone;
        }

        public void setBillTelephone(String billTelephone) {
            this.billTelephone = billTelephone;
        }

        public String getBillType() {
            return billType;
        }

        public void setBillType(String billType) {
            this.billType = billType;
        }

        public String getBillTypeName() {
            return billTypeName;
        }

        public void setBillTypeName(String billTypeName) {
            this.billTypeName = billTypeName;
        }

        public String getContainerId() {
            return containerId;
        }

        public void setContainerId(String containerId) {
            this.containerId = containerId;
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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
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
