package com.bm.container.module.personal.bean;

/**
 * Created by kec on 2017/7/12.
 */

public class OrderDetailBean {


    /**
     * currentPage :
     * data : {"bidOrder":"","bidOrderId":"","buyOrder":{"billAccountSource":"额你以为了晚自习","billAddress":"一直一组YY","billBankAccount":"6949 4959 9595 9595 959","billCheque":"农民一X5","billContent":"333333","billNo":"333333","billTelephone":"02966464","billType":1,"billTypeName":"公司","containerId":"8903bd22-2f43-4404-87bf-4ed932753160","createTime":"2017-07-13 15:59:32","createUser":"c64bead6-fe6f-41c4-b4ee-d707bff705ef","createUserName":"BJZWK9Q","id":"262452a3-8ed3-4d0b-adcb-14a15ac58c4e","price":100,"updateTime":"","updateUser":""},"buyOrderId":"262452a3-8ed3-4d0b-adcb-14a15ac58c4e","container":{"billAccountSource":"","billAddress":"","billBankAccount":"","billCheque":"","billContent":"","billNo":"","billTelephone":"","billType":"","billTypeName":"","city":2,"cityName":"北京","containerStatus":5,"containerStatusName":"已完成","containerType":2,"containerTypeName":"20HC","count":94,"country":1,"countryName":"中国","createTime":"2017-07-13 15:58:08","createUser":"c64bead6-fe6f-41c4-b4ee-d707bff705ef","deadLineTime":"2017-07-13 16:58:12","id":"8903bd22-2f43-4404-87bf-4ed932753160","imageUrl":"","isSpecialPrice":"","isSupportBill":1,"isTop":0,"price":"","remark":"","scanCount":4,"specialPrice":"","specialRemark":"嘻嘻嘻why","startPrice":"","statusType":5,"statusTypeName":"全新","timeType":1,"timeTypeName":"1小时","title":"退伍","tradeType":"","tradeTypeName":"","type":0,"updateTime":"","updateUser":""},"containerId":"8903bd22-2f43-4404-87bf-4ed932753160","containerNo":"","count":94,"createTime":"2017-07-13 15:59:32","createUser":"523cd76c-28a5-4004-afd4-48b314435ea4","createUserInfo":{"accountName":"五天哦了旅游呀我","accountSource":"中国建设银行","address":"","appUserType":1,"appUserTypeName":"公司","bankAccount":"9555 8895 5899 5666 656","cities":"2,","citiesName":"","city":2,"cityName":"北京","companyAddress":"天咯做最在真转","companyName":"旅途T恤","companyPerson":"来咯一www","companyTelephone":"858999","contact":"","country":1,"countryName":"中国","createTime":"2017-06-29 16:36:17","createUser":"523cd76c-28a5-4004-afd4-48b314435ea4","id":"523cd76c-28a5-4004-afd4-48b314435ea4","imageUrl":"/upload/20170703/Luban_1499062666332_20170703021730.jpg","img":"/upload/20170629/mmexport1498623943090_20170629043617.jpg","isBan":0,"isReceiveMessage":1,"isVerify":1,"lawyerPerson":"","password":"96e79218965eb72c92a549dd5a330112","qq":"","regId":"100d85590976d06170b","telephone":"15012345678","updateTime":"","updateUser":"","userFlag":1,"userFlagName":"卖家","userId":"BJ35MH0","userName":"","weixin":""},"deadLineTime":"","finishTime":"2017-07-13 15:59:43","id":"6823c089-ad67-48c0-adba-7b1e21e4c0c5","isDelivery":"","orderNo":"FX201707131559000035","orderStatusType":2,"orderStatusTypeName":"已付款","paidUser":"c64bead6-fe6f-41c4-b4ee-d707bff705ef","paidUserInfo":{"accountName":"","accountSource":"","address":"","appUserType":1,"appUserTypeName":"公司","bankAccount":"","cities":"","citiesName":"","city":2,"cityName":"北京","companyAddress":"用咯我下咯空","companyName":"莫咯咯咙","companyPerson":"倪X5X5我","companyTelephone":"9979595955","contact":"","country":1,"countryName":"中国","createTime":"2017-06-29 16:41:26","createUser":"c64bead6-fe6f-41c4-b4ee-d707bff705ef","id":"c64bead6-fe6f-41c4-b4ee-d707bff705ef","imageUrl":"","img":"","isBan":0,"isReceiveMessage":1,"isVerify":1,"lawyerPerson":"","password":"96e79218965eb72c92a549dd5a330112","qq":"","regId":"120c83f76012ba2a3a2","telephone":"15012345677","updateTime":"","updateUser":"","userFlag":0,"userFlagName":"买家","userId":"BJZWK9Q","userName":"","weixin":""},"payType":1,"payTypeName":"微信","price":100,"receiveTime":"","remark":"","transactionId":"4006372001201707130521255577","updateTime":"","updateUser":""}
     * error :
     * msg : 操作成功
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
         * bidOrder :
         * bidOrderId :
         * buyOrder : {"billAccountSource":"额你以为了晚自习","billAddress":"一直一组YY","billBankAccount":"6949 4959 9595 9595 959","billCheque":"农民一X5","billContent":"333333","billNo":"333333","billTelephone":"02966464","billType":1,"billTypeName":"公司","containerId":"8903bd22-2f43-4404-87bf-4ed932753160","createTime":"2017-07-13 15:59:32","createUser":"c64bead6-fe6f-41c4-b4ee-d707bff705ef","createUserName":"BJZWK9Q","id":"262452a3-8ed3-4d0b-adcb-14a15ac58c4e","price":100,"updateTime":"","updateUser":""}
         * buyOrderId : 262452a3-8ed3-4d0b-adcb-14a15ac58c4e
         * container : {"billAccountSource":"","billAddress":"","billBankAccount":"","billCheque":"","billContent":"","billNo":"","billTelephone":"","billType":"","billTypeName":"","city":2,"cityName":"北京","containerStatus":5,"containerStatusName":"已完成","containerType":2,"containerTypeName":"20HC","count":94,"country":1,"countryName":"中国","createTime":"2017-07-13 15:58:08","createUser":"c64bead6-fe6f-41c4-b4ee-d707bff705ef","deadLineTime":"2017-07-13 16:58:12","id":"8903bd22-2f43-4404-87bf-4ed932753160","imageUrl":"","isSpecialPrice":"","isSupportBill":1,"isTop":0,"price":"","remark":"","scanCount":4,"specialPrice":"","specialRemark":"嘻嘻嘻why","startPrice":"","statusType":5,"statusTypeName":"全新","timeType":1,"timeTypeName":"1小时","title":"退伍","tradeType":"","tradeTypeName":"","type":0,"updateTime":"","updateUser":""}
         * containerId : 8903bd22-2f43-4404-87bf-4ed932753160
         * containerNo :
         * count : 94
         * createTime : 2017-07-13 15:59:32
         * createUser : 523cd76c-28a5-4004-afd4-48b314435ea4
         * createUserInfo : {"accountName":"五天哦了旅游呀我","accountSource":"中国建设银行","address":"","appUserType":1,"appUserTypeName":"公司","bankAccount":"9555 8895 5899 5666 656","cities":"2,","citiesName":"","city":2,"cityName":"北京","companyAddress":"天咯做最在真转","companyName":"旅途T恤","companyPerson":"来咯一www","companyTelephone":"858999","contact":"","country":1,"countryName":"中国","createTime":"2017-06-29 16:36:17","createUser":"523cd76c-28a5-4004-afd4-48b314435ea4","id":"523cd76c-28a5-4004-afd4-48b314435ea4","imageUrl":"/upload/20170703/Luban_1499062666332_20170703021730.jpg","img":"/upload/20170629/mmexport1498623943090_20170629043617.jpg","isBan":0,"isReceiveMessage":1,"isVerify":1,"lawyerPerson":"","password":"96e79218965eb72c92a549dd5a330112","qq":"","regId":"100d85590976d06170b","telephone":"15012345678","updateTime":"","updateUser":"","userFlag":1,"userFlagName":"卖家","userId":"BJ35MH0","userName":"","weixin":""}
         * deadLineTime :
         * finishTime : 2017-07-13 15:59:43
         * id : 6823c089-ad67-48c0-adba-7b1e21e4c0c5
         * isDelivery :
         * orderNo : FX201707131559000035
         * orderStatusType : 2
         * orderStatusTypeName : 已付款
         * paidUser : c64bead6-fe6f-41c4-b4ee-d707bff705ef
         * paidUserInfo : {"accountName":"","accountSource":"","address":"","appUserType":1,"appUserTypeName":"公司","bankAccount":"","cities":"","citiesName":"","city":2,"cityName":"北京","companyAddress":"用咯我下咯空","companyName":"莫咯咯咙","companyPerson":"倪X5X5我","companyTelephone":"9979595955","contact":"","country":1,"countryName":"中国","createTime":"2017-06-29 16:41:26","createUser":"c64bead6-fe6f-41c4-b4ee-d707bff705ef","id":"c64bead6-fe6f-41c4-b4ee-d707bff705ef","imageUrl":"","img":"","isBan":0,"isReceiveMessage":1,"isVerify":1,"lawyerPerson":"","password":"96e79218965eb72c92a549dd5a330112","qq":"","regId":"120c83f76012ba2a3a2","telephone":"15012345677","updateTime":"","updateUser":"","userFlag":0,"userFlagName":"买家","userId":"BJZWK9Q","userName":"","weixin":""}
         * payType : 1
         * payTypeName : 微信
         * price : 100.0
         * receiveTime :
         * remark :
         * transactionId : 4006372001201707130521255577
         * updateTime :
         * updateUser :
         */

        private Object bidOrder;
        private String bidOrderId;
        private BuyOrderBean buyOrder;
        private String buyOrderId;
        private ContainerBean container;
        private String containerId;
        private String containerNo;
        private String count;
        private String createTime;
        private String createUser;
        private CreateUserInfoBean createUserInfo;
        private String deadLineTime;
        private String finishTime;
        private String id;
        private String isDelivery;
        private String orderNo;
        private String orderStatusType;
        private String orderStatusTypeName;
        private String paidUser;
        private PaidUserInfoBean paidUserInfo;
        private String payType;
        private String payTypeName;
        private String price;
        private String receiveTime;
        private String remark;
        private String transactionId;
        private String updateTime;
        private String updateUser;

        public Object getBidOrder() {
            return bidOrder;
        }

        public void setBidOrder(Object bidOrder) {
            this.bidOrder = bidOrder;
        }

        public String getBidOrderId() {
            return bidOrderId;
        }

        public void setBidOrderId(String bidOrderId) {
            this.bidOrderId = bidOrderId;
        }

        public BuyOrderBean getBuyOrder() {
            return buyOrder;
        }

        public void setBuyOrder(BuyOrderBean buyOrder) {
            this.buyOrder = buyOrder;
        }

        public String getBuyOrderId() {
            return buyOrderId;
        }

        public void setBuyOrderId(String buyOrderId) {
            this.buyOrderId = buyOrderId;
        }

        public ContainerBean getContainer() {
            return container;
        }

        public void setContainer(ContainerBean container) {
            this.container = container;
        }

        public String getContainerId() {
            return containerId;
        }

        public void setContainerId(String containerId) {
            this.containerId = containerId;
        }

        public String getContainerNo() {
            return containerNo;
        }

        public void setContainerNo(String containerNo) {
            this.containerNo = containerNo;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
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

        public CreateUserInfoBean getCreateUserInfo() {
            return createUserInfo;
        }

        public void setCreateUserInfo(CreateUserInfoBean createUserInfo) {
            this.createUserInfo = createUserInfo;
        }

        public String getDeadLineTime() {
            return deadLineTime;
        }

        public void setDeadLineTime(String deadLineTime) {
            this.deadLineTime = deadLineTime;
        }

        public String getFinishTime() {
            return finishTime;
        }

        public void setFinishTime(String finishTime) {
            this.finishTime = finishTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIsDelivery() {
            return isDelivery;
        }

        public void setIsDelivery(String isDelivery) {
            this.isDelivery = isDelivery;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getOrderStatusType() {
            return orderStatusType;
        }

        public void setOrderStatusType(String orderStatusType) {
            this.orderStatusType = orderStatusType;
        }

        public String getOrderStatusTypeName() {
            return orderStatusTypeName;
        }

        public void setOrderStatusTypeName(String orderStatusTypeName) {
            this.orderStatusTypeName = orderStatusTypeName;
        }

        public String getPaidUser() {
            return paidUser;
        }

        public void setPaidUser(String paidUser) {
            this.paidUser = paidUser;
        }

        public PaidUserInfoBean getPaidUserInfo() {
            return paidUserInfo;
        }

        public void setPaidUserInfo(PaidUserInfoBean paidUserInfo) {
            this.paidUserInfo = paidUserInfo;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public String getPayTypeName() {
            return payTypeName;
        }

        public void setPayTypeName(String payTypeName) {
            this.payTypeName = payTypeName;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getReceiveTime() {
            return receiveTime;
        }

        public void setReceiveTime(String receiveTime) {
            this.receiveTime = receiveTime;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
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

        public static class BuyOrderBean {
            /**
             * billAccountSource : 额你以为了晚自习
             * billAddress : 一直一组YY
             * billBankAccount : 6949 4959 9595 9595 959
             * billCheque : 农民一X5
             * billContent : 333333
             * billNo : 333333
             * billTelephone : 02966464
             * billType : 1
             * billTypeName : 公司
             * containerId : 8903bd22-2f43-4404-87bf-4ed932753160
             * createTime : 2017-07-13 15:59:32
             * createUser : c64bead6-fe6f-41c4-b4ee-d707bff705ef
             * createUserName : BJZWK9Q
             * id : 262452a3-8ed3-4d0b-adcb-14a15ac58c4e
             * price : 100.0
             * updateTime :
             * updateUser :
             */

            private String billAccountSource;
            private String billAddress;
            private String billBankAccount;
            private String billCheque;
            private String billContent;
            private String billNo;
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

            public String getBillAccountSource() {
                return billAccountSource;
            }

            public void setBillAccountSource(String billAccountSource) {
                this.billAccountSource = billAccountSource;
            }

            public String getBillAddress() {
                return billAddress;
            }

            public void setBillAddress(String billAddress) {
                this.billAddress = billAddress;
            }

            public String getBillBankAccount() {
                return billBankAccount;
            }

            public void setBillBankAccount(String billBankAccount) {
                this.billBankAccount = billBankAccount;
            }

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

            public String getBillNo() {
                return billNo;
            }

            public void setBillNo(String billNo) {
                this.billNo = billNo;
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

        public static class ContainerBean {
            /**
             * billAccountSource :
             * billAddress :
             * billBankAccount :
             * billCheque :
             * billContent :
             * billNo :
             * billTelephone :
             * billType :
             * billTypeName :
             * city : 2
             * cityName : 北京
             * containerStatus : 5
             * containerStatusName : 已完成
             * containerType : 2
             * containerTypeName : 20HC
             * count : 94
             * country : 1
             * countryName : 中国
             * createTime : 2017-07-13 15:58:08
             * createUser : c64bead6-fe6f-41c4-b4ee-d707bff705ef
             * deadLineTime : 2017-07-13 16:58:12
             * id : 8903bd22-2f43-4404-87bf-4ed932753160
             * imageUrl :
             * isSpecialPrice :
             * isSupportBill : 1
             * isTop : 0
             * price :
             * remark :
             * scanCount : 4
             * specialPrice :
             * specialRemark : 嘻嘻嘻why
             * startPrice :
             * statusType : 5
             * statusTypeName : 全新
             * timeType : 1
             * timeTypeName : 1小时
             * title : 退伍
             * tradeType :
             * tradeTypeName :
             * type : 0
             * updateTime :
             * updateUser :
             */

            private String billAccountSource;
            private String billAddress;
            private String billBankAccount;
            private String billCheque;
            private String billContent;
            private String billNo;
            private String billTelephone;
            private String billType;
            private String billTypeName;
            private String city;
            private String cityName;
            private String containerStatus;
            private String containerStatusName;
            private String containerType;
            private String containerTypeName;
            private String count;
            private String country;
            private String countryName;
            private String createTime;
            private String createUser;
            private String deadLineTime;
            private String id;
            private String imageUrl;
            private String isSpecialPrice;
            private String isSupportBill;
            private String isTop;
            private String price;
            private String remark;
            private String scanCount;
            private String specialPrice;
            private String specialRemark;
            private String startPrice;
            private String statusType;
            private String statusTypeName;
            private String timeType;
            private String timeTypeName;
            private String title;
            private String tradeType;
            private String tradeTypeName;
            private String type;
            private String updateTime;
            private String updateUser;

            public String getBillAccountSource() {
                return billAccountSource;
            }

            public void setBillAccountSource(String billAccountSource) {
                this.billAccountSource = billAccountSource;
            }

            public String getBillAddress() {
                return billAddress;
            }

            public void setBillAddress(String billAddress) {
                this.billAddress = billAddress;
            }

            public String getBillBankAccount() {
                return billBankAccount;
            }

            public void setBillBankAccount(String billBankAccount) {
                this.billBankAccount = billBankAccount;
            }

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

            public String getBillNo() {
                return billNo;
            }

            public void setBillNo(String billNo) {
                this.billNo = billNo;
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

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getContainerStatus() {
                return containerStatus;
            }

            public void setContainerStatus(String containerStatus) {
                this.containerStatus = containerStatus;
            }

            public String getContainerStatusName() {
                return containerStatusName;
            }

            public void setContainerStatusName(String containerStatusName) {
                this.containerStatusName = containerStatusName;
            }

            public String getContainerType() {
                return containerType;
            }

            public void setContainerType(String containerType) {
                this.containerType = containerType;
            }

            public String getContainerTypeName() {
                return containerTypeName;
            }

            public void setContainerTypeName(String containerTypeName) {
                this.containerTypeName = containerTypeName;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getCountryName() {
                return countryName;
            }

            public void setCountryName(String countryName) {
                this.countryName = countryName;
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

            public String getDeadLineTime() {
                return deadLineTime;
            }

            public void setDeadLineTime(String deadLineTime) {
                this.deadLineTime = deadLineTime;
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

            public String getIsSpecialPrice() {
                return isSpecialPrice;
            }

            public void setIsSpecialPrice(String isSpecialPrice) {
                this.isSpecialPrice = isSpecialPrice;
            }

            public String getIsSupportBill() {
                return isSupportBill;
            }

            public void setIsSupportBill(String isSupportBill) {
                this.isSupportBill = isSupportBill;
            }

            public String getIsTop() {
                return isTop;
            }

            public void setIsTop(String isTop) {
                this.isTop = isTop;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getScanCount() {
                return scanCount;
            }

            public void setScanCount(String scanCount) {
                this.scanCount = scanCount;
            }

            public String getSpecialPrice() {
                return specialPrice;
            }

            public void setSpecialPrice(String specialPrice) {
                this.specialPrice = specialPrice;
            }

            public String getSpecialRemark() {
                return specialRemark;
            }

            public void setSpecialRemark(String specialRemark) {
                this.specialRemark = specialRemark;
            }

            public String getStartPrice() {
                return startPrice;
            }

            public void setStartPrice(String startPrice) {
                this.startPrice = startPrice;
            }

            public String getStatusType() {
                return statusType;
            }

            public void setStatusType(String statusType) {
                this.statusType = statusType;
            }

            public String getStatusTypeName() {
                return statusTypeName;
            }

            public void setStatusTypeName(String statusTypeName) {
                this.statusTypeName = statusTypeName;
            }

            public String getTimeType() {
                return timeType;
            }

            public void setTimeType(String timeType) {
                this.timeType = timeType;
            }

            public String getTimeTypeName() {
                return timeTypeName;
            }

            public void setTimeTypeName(String timeTypeName) {
                this.timeTypeName = timeTypeName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTradeType() {
                return tradeType;
            }

            public void setTradeType(String tradeType) {
                this.tradeType = tradeType;
            }

            public String getTradeTypeName() {
                return tradeTypeName;
            }

            public void setTradeTypeName(String tradeTypeName) {
                this.tradeTypeName = tradeTypeName;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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

        public static class CreateUserInfoBean {
            /**
             * accountName : 五天哦了旅游呀我
             * accountSource : 中国建设银行
             * address :
             * appUserType : 1
             * appUserTypeName : 公司
             * bankAccount : 9555 8895 5899 5666 656
             * cities : 2,
             * citiesName :
             * city : 2
             * cityName : 北京
             * companyAddress : 天咯做最在真转
             * companyName : 旅途T恤
             * companyPerson : 来咯一www
             * companyTelephone : 858999
             * contact :
             * country : 1
             * countryName : 中国
             * createTime : 2017-06-29 16:36:17
             * createUser : 523cd76c-28a5-4004-afd4-48b314435ea4
             * id : 523cd76c-28a5-4004-afd4-48b314435ea4
             * imageUrl : /upload/20170703/Luban_1499062666332_20170703021730.jpg
             * img : /upload/20170629/mmexport1498623943090_20170629043617.jpg
             * isBan : 0
             * isReceiveMessage : 1
             * isVerify : 1
             * lawyerPerson :
             * password : 96e79218965eb72c92a549dd5a330112
             * qq :
             * regId : 100d85590976d06170b
             * telephone : 15012345678
             * updateTime :
             * updateUser :
             * userFlag : 1
             * userFlagName : 卖家
             * userId : BJ35MH0
             * userName :
             * weixin :
             */

            private String accountName;
            private String accountSource;
            private String address;
            private String appUserType;
            private String appUserTypeName;
            private String bankAccount;
            private String cities;
            private String citiesName;
            private String city;
            private String cityName;
            private String companyAddress;
            private String companyName;
            private String companyPerson;
            private String companyTelephone;
            private String contact;
            private String country;
            private String countryName;
            private String createTime;
            private String createUser;
            private String id;
            private String imageUrl;
            private String img;
            private String isBan;
            private String isReceiveMessage;
            private String isVerify;
            private String lawyerPerson;
            private String password;
            private String qq;
            private String regId;
            private String telephone;
            private String updateTime;
            private String updateUser;
            private String userFlag;
            private String userFlagName;
            private String userId;
            private String userName;
            private String weixin;

            public String getAccountName() {
                return accountName;
            }

            public void setAccountName(String accountName) {
                this.accountName = accountName;
            }

            public String getAccountSource() {
                return accountSource;
            }

            public void setAccountSource(String accountSource) {
                this.accountSource = accountSource;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getAppUserType() {
                return appUserType;
            }

            public void setAppUserType(String appUserType) {
                this.appUserType = appUserType;
            }

            public String getAppUserTypeName() {
                return appUserTypeName;
            }

            public void setAppUserTypeName(String appUserTypeName) {
                this.appUserTypeName = appUserTypeName;
            }

            public String getBankAccount() {
                return bankAccount;
            }

            public void setBankAccount(String bankAccount) {
                this.bankAccount = bankAccount;
            }

            public String getCities() {
                return cities;
            }

            public void setCities(String cities) {
                this.cities = cities;
            }

            public String getCitiesName() {
                return citiesName;
            }

            public void setCitiesName(String citiesName) {
                this.citiesName = citiesName;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getCompanyAddress() {
                return companyAddress;
            }

            public void setCompanyAddress(String companyAddress) {
                this.companyAddress = companyAddress;
            }

            public String getCompanyName() {
                return companyName;
            }

            public void setCompanyName(String companyName) {
                this.companyName = companyName;
            }

            public String getCompanyPerson() {
                return companyPerson;
            }

            public void setCompanyPerson(String companyPerson) {
                this.companyPerson = companyPerson;
            }

            public String getCompanyTelephone() {
                return companyTelephone;
            }

            public void setCompanyTelephone(String companyTelephone) {
                this.companyTelephone = companyTelephone;
            }

            public String getContact() {
                return contact;
            }

            public void setContact(String contact) {
                this.contact = contact;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getCountryName() {
                return countryName;
            }

            public void setCountryName(String countryName) {
                this.countryName = countryName;
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

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getIsBan() {
                return isBan;
            }

            public void setIsBan(String isBan) {
                this.isBan = isBan;
            }

            public String getIsReceiveMessage() {
                return isReceiveMessage;
            }

            public void setIsReceiveMessage(String isReceiveMessage) {
                this.isReceiveMessage = isReceiveMessage;
            }

            public String getIsVerify() {
                return isVerify;
            }

            public void setIsVerify(String isVerify) {
                this.isVerify = isVerify;
            }

            public String getLawyerPerson() {
                return lawyerPerson;
            }

            public void setLawyerPerson(String lawyerPerson) {
                this.lawyerPerson = lawyerPerson;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getQq() {
                return qq;
            }

            public void setQq(String qq) {
                this.qq = qq;
            }

            public String getRegId() {
                return regId;
            }

            public void setRegId(String regId) {
                this.regId = regId;
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

            public String getUserFlag() {
                return userFlag;
            }

            public void setUserFlag(String userFlag) {
                this.userFlag = userFlag;
            }

            public String getUserFlagName() {
                return userFlagName;
            }

            public void setUserFlagName(String userFlagName) {
                this.userFlagName = userFlagName;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getWeixin() {
                return weixin;
            }

            public void setWeixin(String weixin) {
                this.weixin = weixin;
            }
        }

        public static class PaidUserInfoBean {
            /**
             * accountName :
             * accountSource :
             * address :
             * appUserType : 1
             * appUserTypeName : 公司
             * bankAccount :
             * cities :
             * citiesName :
             * city : 2
             * cityName : 北京
             * companyAddress : 用咯我下咯空
             * companyName : 莫咯咯咙
             * companyPerson : 倪X5X5我
             * companyTelephone : 9979595955
             * contact :
             * country : 1
             * countryName : 中国
             * createTime : 2017-06-29 16:41:26
             * createUser : c64bead6-fe6f-41c4-b4ee-d707bff705ef
             * id : c64bead6-fe6f-41c4-b4ee-d707bff705ef
             * imageUrl :
             * img :
             * isBan : 0
             * isReceiveMessage : 1
             * isVerify : 1
             * lawyerPerson :
             * password : 96e79218965eb72c92a549dd5a330112
             * qq :
             * regId : 120c83f76012ba2a3a2
             * telephone : 15012345677
             * updateTime :
             * updateUser :
             * userFlag : 0
             * userFlagName : 买家
             * userId : BJZWK9Q
             * userName :
             * weixin :
             */

            private String accountName;
            private String accountSource;
            private String address;
            private String appUserType;
            private String appUserTypeName;
            private String bankAccount;
            private String cities;
            private String citiesName;
            private String city;
            private String cityName;
            private String companyAddress;
            private String companyName;
            private String companyPerson;
            private String companyTelephone;
            private String contact;
            private String country;
            private String countryName;
            private String createTime;
            private String createUser;
            private String id;
            private String imageUrl;
            private String img;
            private String isBan;
            private String isReceiveMessage;
            private String isVerify;
            private String lawyerPerson;
            private String password;
            private String qq;
            private String regId;
            private String telephone;
            private String updateTime;
            private String updateUser;
            private String userFlag;
            private String userFlagName;
            private String userId;
            private String userName;
            private String weixin;

            public String getAccountName() {
                return accountName;
            }

            public void setAccountName(String accountName) {
                this.accountName = accountName;
            }

            public String getAccountSource() {
                return accountSource;
            }

            public void setAccountSource(String accountSource) {
                this.accountSource = accountSource;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getAppUserType() {
                return appUserType;
            }

            public void setAppUserType(String appUserType) {
                this.appUserType = appUserType;
            }

            public String getAppUserTypeName() {
                return appUserTypeName;
            }

            public void setAppUserTypeName(String appUserTypeName) {
                this.appUserTypeName = appUserTypeName;
            }

            public String getBankAccount() {
                return bankAccount;
            }

            public void setBankAccount(String bankAccount) {
                this.bankAccount = bankAccount;
            }

            public String getCities() {
                return cities;
            }

            public void setCities(String cities) {
                this.cities = cities;
            }

            public String getCitiesName() {
                return citiesName;
            }

            public void setCitiesName(String citiesName) {
                this.citiesName = citiesName;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getCompanyAddress() {
                return companyAddress;
            }

            public void setCompanyAddress(String companyAddress) {
                this.companyAddress = companyAddress;
            }

            public String getCompanyName() {
                return companyName;
            }

            public void setCompanyName(String companyName) {
                this.companyName = companyName;
            }

            public String getCompanyPerson() {
                return companyPerson;
            }

            public void setCompanyPerson(String companyPerson) {
                this.companyPerson = companyPerson;
            }

            public String getCompanyTelephone() {
                return companyTelephone;
            }

            public void setCompanyTelephone(String companyTelephone) {
                this.companyTelephone = companyTelephone;
            }

            public String getContact() {
                return contact;
            }

            public void setContact(String contact) {
                this.contact = contact;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getCountryName() {
                return countryName;
            }

            public void setCountryName(String countryName) {
                this.countryName = countryName;
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

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getIsBan() {
                return isBan;
            }

            public void setIsBan(String isBan) {
                this.isBan = isBan;
            }

            public String getIsReceiveMessage() {
                return isReceiveMessage;
            }

            public void setIsReceiveMessage(String isReceiveMessage) {
                this.isReceiveMessage = isReceiveMessage;
            }

            public String getIsVerify() {
                return isVerify;
            }

            public void setIsVerify(String isVerify) {
                this.isVerify = isVerify;
            }

            public String getLawyerPerson() {
                return lawyerPerson;
            }

            public void setLawyerPerson(String lawyerPerson) {
                this.lawyerPerson = lawyerPerson;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getQq() {
                return qq;
            }

            public void setQq(String qq) {
                this.qq = qq;
            }

            public String getRegId() {
                return regId;
            }

            public void setRegId(String regId) {
                this.regId = regId;
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

            public String getUserFlag() {
                return userFlag;
            }

            public void setUserFlag(String userFlag) {
                this.userFlag = userFlag;
            }

            public String getUserFlagName() {
                return userFlagName;
            }

            public void setUserFlagName(String userFlagName) {
                this.userFlagName = userFlagName;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getWeixin() {
                return weixin;
            }

            public void setWeixin(String weixin) {
                this.weixin = weixin;
            }
        }
    }
}
