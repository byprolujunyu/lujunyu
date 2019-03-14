package com.bm.container.module.market.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nfmomo on 17/5/5.
 */

public class OfferBean implements Parcelable {
    /**
     * bidCount : 2
     * containerId : 1e3c9c85-6489-4b11-a42d-879d2bfafae6
     * createTime : 2017-04-24 17:51:02
     * createUser : 4e9f8a6b-cb8a-4a9a-b1eb-e86757d15d97
     * createUserName : SH4BGJM
     * id : db502423-45f7-453a-b881-5be40440bd88
     * imageUrl : /upload/20170427/file3_20170427101910.png,/upload/20170427/file4_20170427101910.png,/upload/20170427/file5_20170427101910.png
     * isSpecialPrice : 1
     * isSupportBill : 1
     * price : 58
     * specialPrice : 58
     * updateTime :
     * updateUser :
     */

    private String bidCount;
    private String containerId;
    private String createTime;
    private String createUser;
    private String createUserName;
    private String id;
    private String imageUrl;
    private String isSpecialPrice;
    private String isSupportBill;
    private String price;
    private String specialPrice;
    private String updateTime;
    private String updateUser;

    public String getBidCount() {
        return bidCount;
    }

    public void setBidCount(String bidCount) {
        this.bidCount = bidCount;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(String specialPrice) {
        this.specialPrice = specialPrice;
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
        dest.writeString(this.bidCount);
        dest.writeString(this.containerId);
        dest.writeString(this.createTime);
        dest.writeString(this.createUser);
        dest.writeString(this.createUserName);
        dest.writeString(this.id);
        dest.writeString(this.imageUrl);
        dest.writeString(this.isSpecialPrice);
        dest.writeString(this.isSupportBill);
        dest.writeString(this.price);
        dest.writeString(this.specialPrice);
        dest.writeString(this.updateTime);
        dest.writeString(this.updateUser);
    }

    public OfferBean() {
    }

    protected OfferBean(Parcel in) {
        this.bidCount = in.readString();
        this.containerId = in.readString();
        this.createTime = in.readString();
        this.createUser = in.readString();
        this.createUserName = in.readString();
        this.id = in.readString();
        this.imageUrl = in.readString();
        this.isSpecialPrice = in.readString();
        this.isSupportBill = in.readString();
        this.price = in.readString();
        this.specialPrice = in.readString();
        this.updateTime = in.readString();
        this.updateUser = in.readString();
    }

    public static final Parcelable.Creator<OfferBean> CREATOR = new Parcelable.Creator<OfferBean>() {
        @Override
        public OfferBean createFromParcel(Parcel source) {
            return new OfferBean(source);
        }

        @Override
        public OfferBean[] newArray(int size) {
            return new OfferBean[size];
        }
    };
}
