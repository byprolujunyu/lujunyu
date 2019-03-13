package com.bm.container.module.market.bean;

import java.util.List;

/**
 * Created by nfmomo on 17/4/27.
 */

public class SaleListBean {

    /**
     * currentPage : 1
     * data : [{"billCheque":"","billContent":"","billTelephone":"","billType":"","billTypeName":"","city":1,"cityName":"上海","containerStatus":1,"containerStatusName":"正在进行中","containerType":1,"containerTypeName":"20英尺X8英尺X8英尺6寸（20尺货柜）","count":2,"country":1,"countryName":"中国","createTime":"2017-04-26 15:20:21","createUser":"e9eaa785-762a-4df6-be21-6c31015e0f66","deadLineTime":"2017-04-26 17:20:21","id":"1495aa30-05c0-4769-83ed-39f13d2cd4c1","imageUrl":"","isSpecialPrice":"","isSupportBill":"","isTop":0,"price":"","scanCount":0,"specialPrice":"","specialRemark":"Ft","statusType":5,"statusTypeName":"二手","timeType":2,"timeTypeName":"2小时","tradeType":"","tradeTypeName":"","type":0,"updateTime":"","updateUser":""},{"billCheque":"","billContent":"","billTelephone":"","billType":"","billTypeName":"","city":1,"cityName":"上海","containerStatus":2,"containerStatusName":"竞标中","containerType":1,"containerTypeName":"20英尺X8英尺X8英尺6寸（20尺货柜）","count":3,"country":1,"countryName":"中国","createTime":"2017-04-24 17:45:29","createUser":"4e9f8a6b-cb8a-4a9a-b1eb-e86757d15d97","deadLineTime":"2017-04-24 18:45:36","id":"315c4c38-7e18-4f3a-a3eb-916cfa428f2d","imageUrl":"","isSpecialPrice":1,"isSupportBill":1,"isTop":0,"price":50.01,"scanCount":0,"specialPrice":50.2,"specialRemark":"","statusType":4,"statusTypeName":"全新","timeType":1,"timeTypeName":"1小时","tradeType":1,"tradeTypeName":"竞标","type":1,"updateTime":"","updateUser":""},{"billCheque":"","billContent":"","billTelephone":"","billType":"","billTypeName":"","city":1,"cityName":"上海","containerStatus":3,"containerStatusName":"销售中","containerType":1,"containerTypeName":"20英尺X8英尺X8英尺6寸（20尺货柜）","count":3,"country":1,"countryName":"中国","createTime":"2017-04-24 17:45:21","createUser":"4e9f8a6b-cb8a-4a9a-b1eb-e86757d15d97","deadLineTime":"2017-04-24 18:45:27","id":"a1944a33-d70b-46e5-b7d7-00693763fbf8","imageUrl":"","isSpecialPrice":1,"isSupportBill":1,"isTop":0,"price":50.01,"scanCount":0,"specialPrice":50.2,"specialRemark":"","statusType":4,"statusTypeName":"全新","timeType":1,"timeTypeName":"1小时","tradeType":0,"tradeTypeName":"出售","type":1,"updateTime":"","updateUser":""},{"billCheque":"","billContent":"","billTelephone":"","billType":"","billTypeName":"","city":1,"cityName":"上海","containerStatus":3,"containerStatusName":"销售中","containerType":1,"containerTypeName":"20英尺X8英尺X8英尺6寸（20尺货柜）","count":3,"country":1,"countryName":"中国","createTime":"2017-04-27 10:19:10","createUser":"e9eaa785-762a-4df6-be21-6c31015e0f66","deadLineTime":"2017-05-04 23:39:10","id":"b32308cd-0b41-4042-b59a-66f801e6a8f4","imageUrl":"/upload/20170427/file0_20170427101910.png,/upload/20170427/file1_20170427101910.png,/upload/20170427/file2_20170427101910.png,/upload/20170427/file3_20170427101910.png,/upload/20170427/file4_20170427101910.png,/upload/20170427/file5_20170427101910.png","isSpecialPrice":1,"isSupportBill":1,"isTop":0,"price":3,"scanCount":0,"specialPrice":"","specialRemark":"","statusType":4,"statusTypeName":"全新","timeType":9,"timeTypeName":"一周","tradeType":0,"tradeTypeName":"出售","type":1,"updateTime":"","updateUser":""},{"billCheque":"","billContent":"","billTelephone":"","billType":"","billTypeName":"","city":1,"cityName":"上海","containerStatus":1,"containerStatusName":"正在进行中","containerType":1,"containerTypeName":"20英尺X8英尺X8英尺6寸（20尺货柜）","count":2,"country":1,"countryName":"中国","createTime":"2017-04-24 17:41:20","createUser":"4e9f8a6b-cb8a-4a9a-b1eb-e86757d15d97","deadLineTime":"2017-04-24 18:41:22","id":"db502423-45f7-453a-b881-5be40440bd89","imageUrl":"","isSpecialPrice":"","isSupportBill":"","isTop":0,"price":"","scanCount":0,"specialPrice":"","specialRemark":"no","statusType":4,"statusTypeName":"全新","timeType":1,"timeTypeName":"1小时","tradeType":"","tradeTypeName":"","type":0,"updateTime":"","updateUser":""},{"billCheque":"","billContent":"","billTelephone":"","billType":"","billTypeName":"","city":2,"cityName":"北京","containerStatus":1,"containerStatusName":"正在进行中","containerType":1,"containerTypeName":"20英尺X8英尺X8英尺6寸（20尺货柜）","count":36,"country":1,"countryName":"中国","createTime":"2017-04-26 15:12:22","createUser":"e9eaa785-762a-4df6-be21-6c31015e0f66","deadLineTime":"2017-04-26 16:12:29","id":"d23ffbb0-47e6-4f9a-8210-7a292565d648","imageUrl":"","isSpecialPrice":"","isSupportBill":"","isTop":0,"price":"","scanCount":0,"specialPrice":"","specialRemark":"Ttt","statusType":5,"statusTypeName":"二手","timeType":1,"timeTypeName":"1小时","tradeType":"","tradeTypeName":"","type":0,"updateTime":"","updateUser":""}]
     * error :
     * msg : 操作成功
     * pageCount : 1
     * pageData :
     * pageSize : 10
     * recordsTotal : 6
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
    private String remark;
    private String title;
    private List<InfoBean> data;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<InfoBean> getData() {
        return data;
    }

    public void setData(List<InfoBean> data) {
        this.data = data;
    }

}
