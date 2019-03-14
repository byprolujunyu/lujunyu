package com.bm.container.module.personal.bean;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nfmomo on 17/5/11.
 */

public class OrderBean implements Parcelable {

    /**
     * bidOrder :
     * bidOrderId : 07710017-a42c-4a94-930d-32fd6ce23695
     * buyOrder :
     * buyOrderId :
     * container : {"billCheque":"","billContent":"","billTelephone":"","billType":"","billTypeName":"","city":1,"cityName":"上海","containerStatus":1,"containerStatusName":"正在进行中","containerType":1,"containerTypeName":"20英尺X8英尺X8英尺6寸（20尺货柜）","count":2,"country":1,"countryName":"中国","createTime":"2017-04-24 17:41:20","createUser":"4e9f8a6b-cb8a-4a9a-b1eb-e86757d15d97","deadLineTime":"2017-05-30 18:41:22","id":"db502423-45f7-453a-b881-5be40440bd89","imageUrl":"","isSpecialPrice":"","isSupportBill":"","isTop":0,"price":"","scanCount":0,"specialPrice":"","specialRemark":"no","statusType":4,"statusTypeName":"全新","timeType":1,"timeTypeName":"1小时","tradeType":"","tradeTypeName":"","type":0,"updateTime":"","updateUser":""}
     * containerId : db502423-45f7-453a-b881-5be40440bd89
     * containerNo : 123,56
     * count : 2
     * createTime : 2017-04-25 11:25:50
     * createUser : 4e9f8a6b-cb8a-4a9a-b1eb-e86757d15d97
     * createUserInfo : {"accountName":"","accountSource":"Shanghai","address":"Shanghai hongkou","appUserType":0,"appUserTypeName":"个人","bankAccount":"620111111111111111223333","cities":"59,153","citiesName":"","city":1,"cityName":"上海","companyAddress":"","companyName":"","companyPerson":"","companyTelephone":"","contact":"13564793107","country":1,"countryName":"中国","createTime":"2017-04-11 14:33:25","createUser":"","id":"e9eaa785-762a-4df6-be21-6c31015e0f66","imageUrl":"/upload/20170426/file0_20170426025638.png","isBan":0,"isReceiveMessage":1,"isVerify":1,"lawyerPerson":"","password":"96e79218965eb72c92a549dd5a330112","qq":"","telephone":"13564793107","updateTime":"","updateUser":"","userFlag":1,"userFlagName":"卖家","userId":"SHTU277","userName":"Wangyan","weixin":""}
     * id : 9b4ed398-2dd8-44fc-be87-25ed582582fd
     * orderNo : FX201704251125000057
     * orderStatusType : 5
     * orderStatusTypeName : 已取消
     * paidUser : 0a846e77-c42a-4bfe-b4e1-fa6484857ad5
     * paidUserInfo : {"accountName":"nfmomo","accountSource":"建设银行","address":"虹口水电路","appUserType":0,"appUserTypeName":"个人","bankAccount":"5665774555668874556","cities":"","citiesName":"","city":1,"cityName":"上海","companyAddress":"","companyName":"","companyPerson":"","companyTelephone":"","contact":"15962099596","country":1,"countryName":"中国","createTime":"2017-04-11 17:44:29","createUser":"0a846e77-c42a-4bfe-b4e1-fa6484857ad5","id":"0a846e77-c42a-4bfe-b4e1-fa6484857ad5","imageUrl":"/upload/20170427/Luban_1493283795820_20170427050306.jpg","isBan":0,"isReceiveMessage":1,"isVerify":1,"lawyerPerson":"","password":"96e79218965eb72c92a549dd5a330112","qq":"779674059","telephone":"15962099596","updateTime":"","updateUser":"","userFlag":0,"userFlagName":"买家","userId":"SHRU1SD","userName":"王文舜","weixin":"nfmomo"}
     * payType : 1
     * payTypeName : 微信
     * price : 116
     * receiveTime :
     * remark :
     * transcationId :
     * updateTime :
     * updateUser :
     */

//	private String bidOrder;
    private String bidOrderId;
    //	private String buyOrder;
    private String buyOrderId;
    private String isDelivery;
    private ContainerBean container;
    private String containerId;
    private String containerNo;
    private String count;
    private String createTime;
    private String finishTime;
    private String createUser;
    private CreateUserInfoBean createUserInfo;
    private String id;
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
    private String transcationId;
    private String updateTime;
    private String updateUser;

//	public String getBidOrder() {
//		return bidOrder;
//	}
//
//	public void setBidOrder(String bidOrder) {
//		this.bidOrder = bidOrder;
//	}

    public String getBidOrderId() {
        return bidOrderId;
    }

    public void setBidOrderId(String bidOrderId) {
        this.bidOrderId = bidOrderId;
    }

//	public String getBuyOrder() {
//		return buyOrder;
//	}
//
//	public void setBuyOrder(String buyOrder) {
//		this.buyOrder = buyOrder;
//	}

    public String getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(String buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public String getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(String isDelivery) {
        this.isDelivery = isDelivery;
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

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTranscationId() {
        return transcationId;
    }

    public void setTranscationId(String transcationId) {
        this.transcationId = transcationId;
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

    public static class ContainerBean implements Parcelable {
        /**
         * billCheque :
         * billContent :
         * billTelephone :
         * billType :
         * billTypeName :
         * city : 1
         * cityName : 上海
         * containerStatus : 1
         * containerStatusName : 正在进行中
         * containerType : 1
         * containerTypeName : 20英尺X8英尺X8英尺6寸（20尺货柜）
         * count : 2
         * country : 1
         * countryName : 中国
         * createTime : 2017-04-24 17:41:20
         * createUser : 4e9f8a6b-cb8a-4a9a-b1eb-e86757d15d97
         * deadLineTime : 2017-05-30 18:41:22
         * id : db502423-45f7-453a-b881-5be40440bd89
         * imageUrl :
         * isSpecialPrice :
         * isSupportBill :
         * isTop : 0
         * price :
         * scanCount : 0
         * specialPrice :
         * specialRemark : no
         * statusType : 4
         * statusTypeName : 全新
         * timeType : 1
         * timeTypeName : 1小时
         * tradeType :
         * tradeTypeName :
         * type : 0
         * updateTime :
         * updateUser :
         */

        private String billCheque;
        private String billContent;
        private String billTelephone;
        private String billType;
        private String billTypeName;

        private String billNo;
        private String billBankAccount;
        private String billAccountSource;
        private String billAddress;

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
        private String scanCount;
        private String specialPrice;
        private String specialRemark;
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
        private String price;
        private String startPrice;

        public String getStartPrice() {
            return startPrice;
        }

        public void setStartPrice(String startPrice) {
            this.startPrice = startPrice;
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

        public String getBillNo() {
            return billNo;
        }

        public void setBillNo(String billNo) {
            this.billNo = billNo;
        }

        public String getBillBankAccount() {
            return billBankAccount;
        }

        public void setBillBankAccount(String billBankAccount) {
            this.billBankAccount = billBankAccount;
        }

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.billCheque);
            dest.writeString(this.billContent);
            dest.writeString(this.billTelephone);
            dest.writeString(this.billType);
            dest.writeString(this.billTypeName);
            dest.writeString(this.billNo);
            dest.writeString(this.billBankAccount);
            dest.writeString(this.billAccountSource);
            dest.writeString(this.billAddress);
            dest.writeString(this.city);
            dest.writeString(this.cityName);
            dest.writeString(this.containerStatus);
            dest.writeString(this.containerStatusName);
            dest.writeString(this.containerType);
            dest.writeString(this.containerTypeName);
            dest.writeString(this.count);
            dest.writeString(this.country);
            dest.writeString(this.countryName);
            dest.writeString(this.createTime);
            dest.writeString(this.createUser);
            dest.writeString(this.deadLineTime);
            dest.writeString(this.id);
            dest.writeString(this.imageUrl);
            dest.writeString(this.isSpecialPrice);
            dest.writeString(this.isSupportBill);
            dest.writeString(this.isTop);
            dest.writeString(this.price);
            dest.writeString(this.scanCount);
            dest.writeString(this.specialPrice);
            dest.writeString(this.specialRemark);
            dest.writeString(this.statusType);
            dest.writeString(this.statusTypeName);
            dest.writeString(this.timeType);
            dest.writeString(this.timeTypeName);
            dest.writeString(this.title);
            dest.writeString(this.tradeType);
            dest.writeString(this.tradeTypeName);
            dest.writeString(this.type);
            dest.writeString(this.updateTime);
            dest.writeString(this.updateUser);
        }

        public ContainerBean() {
        }

        protected ContainerBean(Parcel in) {
            this.billCheque = in.readString();
            this.billContent = in.readString();
            this.billTelephone = in.readString();
            this.billType = in.readString();
            this.billTypeName = in.readString();
            this.billNo = in.readString();
            this.billBankAccount = in.readString();
            this.billAccountSource = in.readString();
            this.billAddress = in.readString();
            this.city = in.readString();
            this.cityName = in.readString();
            this.containerStatus = in.readString();
            this.containerStatusName = in.readString();
            this.containerType = in.readString();
            this.containerTypeName = in.readString();
            this.count = in.readString();
            this.country = in.readString();
            this.countryName = in.readString();
            this.createTime = in.readString();
            this.createUser = in.readString();
            this.deadLineTime = in.readString();
            this.id = in.readString();
            this.imageUrl = in.readString();
            this.isSpecialPrice = in.readString();
            this.isSupportBill = in.readString();
            this.isTop = in.readString();
            this.price = in.readString();
            this.scanCount = in.readString();
            this.specialPrice = in.readString();
            this.specialRemark = in.readString();
            this.statusType = in.readString();
            this.statusTypeName = in.readString();
            this.timeType = in.readString();
            this.timeTypeName = in.readString();
            this.title = in.readString();
            this.tradeType = in.readString();
            this.tradeTypeName = in.readString();
            this.type = in.readString();
            this.updateTime = in.readString();
            this.updateUser = in.readString();
        }

        public static final Parcelable.Creator<ContainerBean> CREATOR = new Parcelable.Creator<ContainerBean>() {
            @Override
            public ContainerBean createFromParcel(Parcel source) {
                return new ContainerBean(source);
            }

            @Override
            public ContainerBean[] newArray(int size) {
                return new ContainerBean[size];
            }
        };
    }

    public static class CreateUserInfoBean implements Parcelable {
        /**
         * accountName :
         * accountSource : Shanghai
         * address : Shanghai hongkou
         * appUserType : 0
         * appUserTypeName : 个人
         * bankAccount : 620111111111111111223333
         * cities : 59,153
         * citiesName :
         * city : 1
         * cityName : 上海
         * companyAddress :
         * companyName :
         * companyPerson :
         * companyTelephone :
         * contact : 13564793107
         * country : 1
         * countryName : 中国
         * createTime : 2017-04-11 14:33:25
         * createUser :
         * id : e9eaa785-762a-4df6-be21-6c31015e0f66
         * imageUrl : /upload/20170426/file0_20170426025638.png
         * isBan : 0
         * isReceiveMessage : 1
         * isVerify : 1
         * lawyerPerson :
         * password : 96e79218965eb72c92a549dd5a330112
         * qq :
         * telephone : 13564793107
         * updateTime :
         * updateUser :
         * userFlag : 1
         * userFlagName : 卖家
         * userId : SHTU277
         * userName : Wangyan
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
        private String isBan;
        private String isReceiveMessage;
        private String isVerify;
        private String lawyerPerson;
        private String password;
        private String qq;
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.accountName);
            dest.writeString(this.accountSource);
            dest.writeString(this.address);
            dest.writeString(this.appUserType);
            dest.writeString(this.appUserTypeName);
            dest.writeString(this.bankAccount);
            dest.writeString(this.cities);
            dest.writeString(this.citiesName);
            dest.writeString(this.city);
            dest.writeString(this.cityName);
            dest.writeString(this.companyAddress);
            dest.writeString(this.companyName);
            dest.writeString(this.companyPerson);
            dest.writeString(this.companyTelephone);
            dest.writeString(this.contact);
            dest.writeString(this.country);
            dest.writeString(this.countryName);
            dest.writeString(this.createTime);
            dest.writeString(this.createUser);
            dest.writeString(this.id);
            dest.writeString(this.imageUrl);
            dest.writeString(this.isBan);
            dest.writeString(this.isReceiveMessage);
            dest.writeString(this.isVerify);
            dest.writeString(this.lawyerPerson);
            dest.writeString(this.password);
            dest.writeString(this.qq);
            dest.writeString(this.telephone);
            dest.writeString(this.updateTime);
            dest.writeString(this.updateUser);
            dest.writeString(this.userFlag);
            dest.writeString(this.userFlagName);
            dest.writeString(this.userId);
            dest.writeString(this.userName);
            dest.writeString(this.weixin);
        }

        public CreateUserInfoBean() {
        }

        protected CreateUserInfoBean(Parcel in) {
            this.accountName = in.readString();
            this.accountSource = in.readString();
            this.address = in.readString();
            this.appUserType = in.readString();
            this.appUserTypeName = in.readString();
            this.bankAccount = in.readString();
            this.cities = in.readString();
            this.citiesName = in.readString();
            this.city = in.readString();
            this.cityName = in.readString();
            this.companyAddress = in.readString();
            this.companyName = in.readString();
            this.companyPerson = in.readString();
            this.companyTelephone = in.readString();
            this.contact = in.readString();
            this.country = in.readString();
            this.countryName = in.readString();
            this.createTime = in.readString();
            this.createUser = in.readString();
            this.id = in.readString();
            this.imageUrl = in.readString();
            this.isBan = in.readString();
            this.isReceiveMessage = in.readString();
            this.isVerify = in.readString();
            this.lawyerPerson = in.readString();
            this.password = in.readString();
            this.qq = in.readString();
            this.telephone = in.readString();
            this.updateTime = in.readString();
            this.updateUser = in.readString();
            this.userFlag = in.readString();
            this.userFlagName = in.readString();
            this.userId = in.readString();
            this.userName = in.readString();
            this.weixin = in.readString();
        }

        public static final Parcelable.Creator<CreateUserInfoBean> CREATOR = new Parcelable.Creator<CreateUserInfoBean>() {
            @Override
            public CreateUserInfoBean createFromParcel(Parcel source) {
                return new CreateUserInfoBean(source);
            }

            @Override
            public CreateUserInfoBean[] newArray(int size) {
                return new CreateUserInfoBean[size];
            }
        };
    }

    public static class PaidUserInfoBean implements Parcelable {
        /**
         * accountName : nfmomo
         * accountSource : 建设银行
         * address : 虹口水电路
         * appUserType : 0
         * appUserTypeName : 个人
         * bankAccount : 5665774555668874556
         * cities :
         * citiesName :
         * city : 1
         * cityName : 上海
         * companyAddress :
         * companyName :
         * companyPerson :
         * companyTelephone :
         * contact : 15962099596
         * country : 1
         * countryName : 中国
         * createTime : 2017-04-11 17:44:29
         * createUser : 0a846e77-c42a-4bfe-b4e1-fa6484857ad5
         * id : 0a846e77-c42a-4bfe-b4e1-fa6484857ad5
         * imageUrl : /upload/20170427/Luban_1493283795820_20170427050306.jpg
         * isBan : 0
         * isReceiveMessage : 1
         * isVerify : 1
         * lawyerPerson :
         * password : 96e79218965eb72c92a549dd5a330112
         * qq : 779674059
         * telephone : 15962099596
         * updateTime :
         * updateUser :
         * userFlag : 0
         * userFlagName : 买家
         * userId : SHRU1SD
         * userName : 王文舜
         * weixin : nfmomo
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
        private String isBan;
        private String isReceiveMessage;
        private String isVerify;
        private String lawyerPerson;
        private String password;
        private String qq;
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.accountName);
            dest.writeString(this.accountSource);
            dest.writeString(this.address);
            dest.writeString(this.appUserType);
            dest.writeString(this.appUserTypeName);
            dest.writeString(this.bankAccount);
            dest.writeString(this.cities);
            dest.writeString(this.citiesName);
            dest.writeString(this.city);
            dest.writeString(this.cityName);
            dest.writeString(this.companyAddress);
            dest.writeString(this.companyName);
            dest.writeString(this.companyPerson);
            dest.writeString(this.companyTelephone);
            dest.writeString(this.contact);
            dest.writeString(this.country);
            dest.writeString(this.countryName);
            dest.writeString(this.createTime);
            dest.writeString(this.createUser);
            dest.writeString(this.id);
            dest.writeString(this.imageUrl);
            dest.writeString(this.isBan);
            dest.writeString(this.isReceiveMessage);
            dest.writeString(this.isVerify);
            dest.writeString(this.lawyerPerson);
            dest.writeString(this.password);
            dest.writeString(this.qq);
            dest.writeString(this.telephone);
            dest.writeString(this.updateTime);
            dest.writeString(this.updateUser);
            dest.writeString(this.userFlag);
            dest.writeString(this.userFlagName);
            dest.writeString(this.userId);
            dest.writeString(this.userName);
            dest.writeString(this.weixin);
        }

        public PaidUserInfoBean() {
        }

        protected PaidUserInfoBean(Parcel in) {
            this.accountName = in.readString();
            this.accountSource = in.readString();
            this.address = in.readString();
            this.appUserType = in.readString();
            this.appUserTypeName = in.readString();
            this.bankAccount = in.readString();
            this.cities = in.readString();
            this.citiesName = in.readString();
            this.city = in.readString();
            this.cityName = in.readString();
            this.companyAddress = in.readString();
            this.companyName = in.readString();
            this.companyPerson = in.readString();
            this.companyTelephone = in.readString();
            this.contact = in.readString();
            this.country = in.readString();
            this.countryName = in.readString();
            this.createTime = in.readString();
            this.createUser = in.readString();
            this.id = in.readString();
            this.imageUrl = in.readString();
            this.isBan = in.readString();
            this.isReceiveMessage = in.readString();
            this.isVerify = in.readString();
            this.lawyerPerson = in.readString();
            this.password = in.readString();
            this.qq = in.readString();
            this.telephone = in.readString();
            this.updateTime = in.readString();
            this.updateUser = in.readString();
            this.userFlag = in.readString();
            this.userFlagName = in.readString();
            this.userId = in.readString();
            this.userName = in.readString();
            this.weixin = in.readString();
        }

        public static final Parcelable.Creator<PaidUserInfoBean> CREATOR = new Parcelable.Creator<PaidUserInfoBean>() {
            @Override
            public PaidUserInfoBean createFromParcel(Parcel source) {
                return new PaidUserInfoBean(source);
            }

            @Override
            public PaidUserInfoBean[] newArray(int size) {
                return new PaidUserInfoBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//		dest.writeString(this.bidOrder);
        dest.writeString(this.bidOrderId);
//		dest.writeString(this.buyOrder);
        dest.writeString(this.buyOrderId);
        dest.writeString(this.isDelivery);
        dest.writeParcelable(this.container, flags);
        dest.writeString(this.containerId);
        dest.writeString(this.containerNo);
        dest.writeString(this.finishTime);
        dest.writeString(this.count);
        dest.writeString(this.createTime);
        dest.writeString(this.createUser);
        dest.writeParcelable(this.createUserInfo, flags);
        dest.writeString(this.id);
        dest.writeString(this.orderNo);
        dest.writeString(this.orderStatusType);
        dest.writeString(this.orderStatusTypeName);
        dest.writeString(this.paidUser);
        dest.writeParcelable(this.paidUserInfo, flags);
        dest.writeString(this.payType);
        dest.writeString(this.payTypeName);
        dest.writeString(this.price);
        dest.writeString(this.receiveTime);
        dest.writeString(this.remark);
        dest.writeString(this.transcationId);
        dest.writeString(this.updateTime);
        dest.writeString(this.updateUser);
    }

    protected OrderBean(Parcel in) {
//		this.bidOrder = in.readString();
        this.bidOrderId = in.readString();
//		this.buyOrder = in.readString();
        this.buyOrderId = in.readString();
        this.isDelivery = in.readString();
        this.container = in.readParcelable(ContainerBean.class.getClassLoader());
        this.containerId = in.readString();
        this.containerNo = in.readString();
        this.finishTime = in.readString();
        this.count = in.readString();
        this.createTime = in.readString();
        this.createUser = in.readString();
        this.createUserInfo = in.readParcelable(CreateUserInfoBean.class.getClassLoader());
        this.id = in.readString();
        this.orderNo = in.readString();
        this.orderStatusType = in.readString();
        this.orderStatusTypeName = in.readString();
        this.paidUser = in.readString();
        this.paidUserInfo = in.readParcelable(PaidUserInfoBean.class.getClassLoader());
        this.payType = in.readString();
        this.payTypeName = in.readString();
        this.price = in.readString();
        this.receiveTime = in.readString();
        this.remark = in.readString();
        this.transcationId = in.readString();
        this.updateTime = in.readString();
        this.updateUser = in.readString();
    }

    public static final Parcelable.Creator<OrderBean> CREATOR = new Parcelable.Creator<OrderBean>() {
        @Override
        public OrderBean createFromParcel(Parcel source) {
            return new OrderBean(source);
        }

        @Override
        public OrderBean[] newArray(int size) {
            return new OrderBean[size];
        }
    };
}