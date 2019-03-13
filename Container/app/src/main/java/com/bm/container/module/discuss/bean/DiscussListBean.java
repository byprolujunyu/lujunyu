package com.bm.container.module.discuss.bean;

import java.util.List;

/**
 * Created by nfmomo on 17/4/13.
 */

public class DiscussListBean {

    /**
     * currentPage : 1
     * data : [{"commentCount":1,"commentList":[{"content":"测试评论过！！！！！！","createTime":"2017-04-13 10:47:49","createUser":"","createUserName":"YXM","id":"7ad9a17c-9e11-40b2-8786-71db5ac69b1e","parentForumId":"9c1ad608-6773-450f-885e-42d7ca8d1a97","targetUserId":"","targetUserName":"","telephone":"13564607860","updateTime":"","updateUser":""}],"content":"测试论坛数据","createTime":"2017-04-12 16:42:21","createUser":"4e9f8a6b-cb8a-4a9a-b1eb-e86757d15d97","createUserName":"YXM","headImageUrl":"http://adfadfasdf","id":"9c1ad608-6773-450f-885e-42d7ca8d1a97","imageUrl":"http://www.k73.com/up/allimg/120906/22-120Z6140234L9.jpg,http://www.k73.com/up/allimg/120906/22-120Z6140234L9.jpg,http://www.k73.com/up/allimg/120906/22-120Z6140234L9.jpg","isZan":0,"telephone":"13564607860","updateTime":"","updateUser":"","zanCount":0}]
     * error :
     * msg : 操作成功
     * pageCount : 1
     * pageData :
     * pageSize : 10
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
         * commentCount : 1
         * commentList : [{"content":"测试评论过！！！！！！","createTime":"2017-04-13 10:47:49","createUser":"","createUserName":"YXM","id":"7ad9a17c-9e11-40b2-8786-71db5ac69b1e","parentForumId":"9c1ad608-6773-450f-885e-42d7ca8d1a97","targetUserId":"","targetUserName":"","telephone":"13564607860","updateTime":"","updateUser":""}]
         * content : 测试论坛数据
         * createTime : 2017-04-12 16:42:21
         * createUser : 4e9f8a6b-cb8a-4a9a-b1eb-e86757d15d97
         * createUserName : YXM
         * headImageUrl : http://adfadfasdf
         * id : 9c1ad608-6773-450f-885e-42d7ca8d1a97
         * imageUrl : http://www.k73.com/up/allimg/120906/22-120Z6140234L9.jpg,http://www.k73.com/up/allimg/120906/22-120Z6140234L9.jpg,http://www.k73.com/up/allimg/120906/22-120Z6140234L9.jpg
         * isZan : 0
         * telephone : 13564607860
         * updateTime :
         * updateUser :
         * zanCount : 0
         */

        private String commentCount;
        private String content;
        private String createTime;
        private String createUser;
        private String createUserName;
        private String headImageUrl;
        private String id;
        private String imageUrl;
        private String isZan;
        private String telephone;
        private String updateTime;
        private String updateUser;
        private String zanCount;
        private List<CommentListBean> commentList;

        public String getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(String commentCount) {
            this.commentCount = commentCount;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public String getHeadImageUrl() {
            return headImageUrl;
        }

        public void setHeadImageUrl(String headImageUrl) {
            this.headImageUrl = headImageUrl;
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

        public String getIsZan() {
            return isZan;
        }

        public void setIsZan(String isZan) {
            this.isZan = isZan;
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

        public String getZanCount() {
            return zanCount;
        }

        public void setZanCount(String zanCount) {
            this.zanCount = zanCount;
        }

        public List<CommentListBean> getCommentList() {
            return commentList;
        }

        public void setCommentList(List<CommentListBean> commentList) {
            this.commentList = commentList;
        }

        public static class CommentListBean {
            /**
             * content : 测试评论过！！！！！！
             * createTime : 2017-04-13 10:47:49
             * createUser :
             * createUserName : YXM
             * id : 7ad9a17c-9e11-40b2-8786-71db5ac69b1e
             * parentForumId : 9c1ad608-6773-450f-885e-42d7ca8d1a97
             * targetUserId :
             * targetUserName :
             * telephone : 13564607860
             * updateTime :
             * updateUser :
             */

            private String content;
            private String createTime;
            private String createUser;
            private String createUserName;
            private String id;
            private String parentForumId;
            private String targetUserId;
            private String targetUserName;
            private String telephone;
            private String updateTime;
            private String updateUser;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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

            public String getParentForumId() {
                return parentForumId;
            }

            public void setParentForumId(String parentForumId) {
                this.parentForumId = parentForumId;
            }

            public String getTargetUserId() {
                return targetUserId;
            }

            public void setTargetUserId(String targetUserId) {
                this.targetUserId = targetUserId;
            }

            public String getTargetUserName() {
                return targetUserName;
            }

            public void setTargetUserName(String targetUserName) {
                this.targetUserName = targetUserName;
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
        }
    }
}
