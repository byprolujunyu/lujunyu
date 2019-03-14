package com.bm.container.entity;

/**
 * Created by kec on 2017/8/7.
 */

public class AlipayBaenEntity {


    /**
     * currentPage :
     * data : timestamp=2017-08-07+13%3A45%3A20&biz_content=%7B%22body%22%3A%22%E9%9B%86%E8%A3%85%E7%AE%B1%E4%BA%A4%E6%98%93%22%2C%22out_trade_no%22%3A%22FX201708071345000020%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E9%9B%86%E8%A3%85%E7%AE%B1%22%2C%22timeout_express%22%3A%221c%22%2C%22total_amount%22%3A%221111.00%22%7D&sign_type=RSA2&charset=utf-8&method=alipay.trade.app.pay&app_id=2017051507240955&version=1.0&sign=CDgIStWcSoVMxCIGwGDcF%2BpQgtePSPNH8nl0JaSRd6N3l0foJePe8E%2BcIEnTWgCI9H5JB%2FGc%2BwcX%2BBuSAcsEz1OHCkhrAfsTmItI8r8ZkG2Nr3ngwQjfbt5FTzW8mYrst1d3bwHtLmtlmmQeGKngmaLxDq3pH2Lix4sUxTVfSw8%2FIvviFBwWL%2FS6QI9Hf5J5BUC3K6t93yDw0FK3SWZYtZ51eQeZuVANoaKpbu6EZlKnHqyAJcq%2FWmT1ChP%2F8I524k3O7MINHLK%2FIcGMcUOxKdbd4FXBlYEY3%2Bnw49oU8F2y%2F8yjZ25qC9VnkR1WruqoqGIdoJ8O38dHTpWcaF4e9A%3D%3D
     * error :
     * msg : 操作成功
     * pageCount :
     * pageData :
     * pageSize :
     * recordsTotal :
     * status : 1
     */

    private String currentPage;
    private String data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
}
