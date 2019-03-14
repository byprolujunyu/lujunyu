package com.bm.container.module.market.bean;

import java.util.List;

/**
 * Created by nfmomo on 17/5/4.
 */

public class OfferBuyListBean {


    /**
     * currentPage : 1
     * data : [{"bidCount":2,"containerId":"1e3c9c85-6489-4b11-a42d-879d2bfafae6","createTime":"2017-04-24 17:51:02","createUser":"4e9f8a6b-cb8a-4a9a-b1eb-e86757d15d97","createUserName":"SH4BGJM","id":"db502423-45f7-453a-b881-5be40440bd88","imageUrl":"/upload/20170427/file3_20170427101910.png,/upload/20170427/file4_20170427101910.png,/upload/20170427/file5_20170427101910.png","isSpecialPrice":1,"isSupportBill":1,"price":58,"specialPrice":58,"updateTime":"","updateUser":""}]
     * error :
     * msg : 操作成功
     * pageCount : 1
     * pageData :
     * pageSize : 100
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
    private List<OfferBuyBean> data;

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

    public List<OfferBuyBean> getData() {
        return data;
    }

    public void setData(List<OfferBuyBean> data) {
        this.data = data;
    }

}
