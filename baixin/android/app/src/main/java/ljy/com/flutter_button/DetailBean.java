package ljy.com.flutter_button;

import java.util.List;

public class DetailBean {


    /**
     * code : 0
     * message : success
     * data : {"goodInfo":{"image5":"","amount":10000,"image3":"","image4":"","goodsId":"035b55e444db4d308fd963543c7d884f","isOnline":"yes","image1":"http://images.baixingliangfan.cn/shopGoodsImg/20190118/20190118101813_9360.jpg","image2":"","goodsSerialNumber":"6920794458051","oriPrice":3.3,"presentPrice":3,"comPic":"http://images.baixingliangfan.cn/compressedPic/20190118101813_9360.jpg","state":1,"shopId":"402880e860166f3c0160167897d60002","goodsName":"京宫二锅头56°100ml","goodsDetail":"<img src=\"http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_6791.jpg\" width=\"100%\" height=\"auto\" alt=\"\" /><img src=\"http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_1891.jpg\" width=\"100%\" height=\"auto\" alt=\"\" /><img src=\"http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_908.jpg\" width=\"100%\" height=\"auto\" alt=\"\" /><img src=\"http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_5209.jpg\" width=\"100%\" height=\"auto\" alt=\"\" /><img src=\"http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_6593.jpg\" width=\"100%\" height=\"auto\" alt=\"\" />"},"goodComments":[{"SCORE":5,"comments":"第一次在网上的超市购买商品，很有意思，赞���","userName":"155******30","discussTime":1549168700664}],"advertesPicture":{"PICTURE_ADDRESS":"http://images.baixingliangfan.cn/advertesPicture/20190113/20190113134955_5825.jpg","TO_PLACE":"1"}}
     */

    private String code;
    private String message;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * goodInfo : {"image5":"","amount":10000,"image3":"","image4":"","goodsId":"035b55e444db4d308fd963543c7d884f","isOnline":"yes","image1":"http://images.baixingliangfan.cn/shopGoodsImg/20190118/20190118101813_9360.jpg","image2":"","goodsSerialNumber":"6920794458051","oriPrice":3.3,"presentPrice":3,"comPic":"http://images.baixingliangfan.cn/compressedPic/20190118101813_9360.jpg","state":1,"shopId":"402880e860166f3c0160167897d60002","goodsName":"京宫二锅头56°100ml","goodsDetail":"<img src=\"http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_6791.jpg\" width=\"100%\" height=\"auto\" alt=\"\" /><img src=\"http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_1891.jpg\" width=\"100%\" height=\"auto\" alt=\"\" /><img src=\"http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_908.jpg\" width=\"100%\" height=\"auto\" alt=\"\" /><img src=\"http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_5209.jpg\" width=\"100%\" height=\"auto\" alt=\"\" /><img src=\"http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_6593.jpg\" width=\"100%\" height=\"auto\" alt=\"\" />"}
         * goodComments : [{"SCORE":5,"comments":"第一次在网上的超市购买商品，很有意思，赞���","userName":"155******30","discussTime":1549168700664}]
         * advertesPicture : {"PICTURE_ADDRESS":"http://images.baixingliangfan.cn/advertesPicture/20190113/20190113134955_5825.jpg","TO_PLACE":"1"}
         */

        private GoodInfoBean goodInfo;
        private AdvertesPictureBean advertesPicture;
        private List<GoodCommentsBean> goodComments;

        public GoodInfoBean getGoodInfo() {
            return goodInfo;
        }

        public void setGoodInfo(GoodInfoBean goodInfo) {
            this.goodInfo = goodInfo;
        }

        public AdvertesPictureBean getAdvertesPicture() {
            return advertesPicture;
        }

        public void setAdvertesPicture(AdvertesPictureBean advertesPicture) {
            this.advertesPicture = advertesPicture;
        }

        public List<GoodCommentsBean> getGoodComments() {
            return goodComments;
        }

        public void setGoodComments(List<GoodCommentsBean> goodComments) {
            this.goodComments = goodComments;
        }

        public static class GoodInfoBean {
            /**
             * image5 :
             * amount : 10000
             * image3 :
             * image4 :
             * goodsId : 035b55e444db4d308fd963543c7d884f
             * isOnline : yes
             * image1 : http://images.baixingliangfan.cn/shopGoodsImg/20190118/20190118101813_9360.jpg
             * image2 :
             * goodsSerialNumber : 6920794458051
             * oriPrice : 3.3
             * presentPrice : 3
             * comPic : http://images.baixingliangfan.cn/compressedPic/20190118101813_9360.jpg
             * state : 1
             * shopId : 402880e860166f3c0160167897d60002
             * goodsName : 京宫二锅头56°100ml
             * goodsDetail : <img src="http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_6791.jpg" width="100%" height="auto" alt="" /><img src="http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_1891.jpg" width="100%" height="auto" alt="" /><img src="http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_908.jpg" width="100%" height="auto" alt="" /><img src="http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_5209.jpg" width="100%" height="auto" alt="" /><img src="http://images.baixingliangfan.cn/shopGoodsDetailImg/20190118/20190118101819_6593.jpg" width="100%" height="auto" alt="" />
             */

            private String image5;
            private int amount;
            private String image3;
            private String image4;
            private String goodsId;
            private String isOnline;
            private String image1;
            private String image2;
            private String goodsSerialNumber;
            private double oriPrice;
            private int presentPrice;
            private String comPic;
            private int state;
            private String shopId;
            private String goodsName;
            private String goodsDetail;

            public String getImage5() {
                return image5;
            }

            public void setImage5(String image5) {
                this.image5 = image5;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getImage3() {
                return image3;
            }

            public void setImage3(String image3) {
                this.image3 = image3;
            }

            public String getImage4() {
                return image4;
            }

            public void setImage4(String image4) {
                this.image4 = image4;
            }

            public String getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(String goodsId) {
                this.goodsId = goodsId;
            }

            public String getIsOnline() {
                return isOnline;
            }

            public void setIsOnline(String isOnline) {
                this.isOnline = isOnline;
            }

            public String getImage1() {
                return image1;
            }

            public void setImage1(String image1) {
                this.image1 = image1;
            }

            public String getImage2() {
                return image2;
            }

            public void setImage2(String image2) {
                this.image2 = image2;
            }

            public String getGoodsSerialNumber() {
                return goodsSerialNumber;
            }

            public void setGoodsSerialNumber(String goodsSerialNumber) {
                this.goodsSerialNumber = goodsSerialNumber;
            }

            public double getOriPrice() {
                return oriPrice;
            }

            public void setOriPrice(double oriPrice) {
                this.oriPrice = oriPrice;
            }

            public int getPresentPrice() {
                return presentPrice;
            }

            public void setPresentPrice(int presentPrice) {
                this.presentPrice = presentPrice;
            }

            public String getComPic() {
                return comPic;
            }

            public void setComPic(String comPic) {
                this.comPic = comPic;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public String getShopId() {
                return shopId;
            }

            public void setShopId(String shopId) {
                this.shopId = shopId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public String getGoodsDetail() {
                return goodsDetail;
            }

            public void setGoodsDetail(String goodsDetail) {
                this.goodsDetail = goodsDetail;
            }
        }

        public static class AdvertesPictureBean {
            /**
             * PICTURE_ADDRESS : http://images.baixingliangfan.cn/advertesPicture/20190113/20190113134955_5825.jpg
             * TO_PLACE : 1
             */

            private String PICTURE_ADDRESS;
            private String TO_PLACE;

            public String getPICTURE_ADDRESS() {
                return PICTURE_ADDRESS;
            }

            public void setPICTURE_ADDRESS(String PICTURE_ADDRESS) {
                this.PICTURE_ADDRESS = PICTURE_ADDRESS;
            }

            public String getTO_PLACE() {
                return TO_PLACE;
            }

            public void setTO_PLACE(String TO_PLACE) {
                this.TO_PLACE = TO_PLACE;
            }
        }

        public static class GoodCommentsBean {
            /**
             * SCORE : 5
             * comments : 第一次在网上的超市购买商品，很有意思，赞���
             * userName : 155******30
             * discussTime : 1549168700664
             */

            private int SCORE;
            private String comments;
            private String userName;
            private long discussTime;

            public int getSCORE() {
                return SCORE;
            }

            public void setSCORE(int SCORE) {
                this.SCORE = SCORE;
            }

            public String getComments() {
                return comments;
            }

            public void setComments(String comments) {
                this.comments = comments;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public long getDiscussTime() {
                return discussTime;
            }

            public void setDiscussTime(long discussTime) {
                this.discussTime = discussTime;
            }
        }
    }
}
