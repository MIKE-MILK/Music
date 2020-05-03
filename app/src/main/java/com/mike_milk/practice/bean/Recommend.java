package com.mike_milk.practice.bean;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：
 */
public class Recommend {
    private String name;
    private String id;
    private String trackCount;
    private String coverImgUrl;
    public Recommend(String name,String id,String trackCount,String coverImgUrl){
        this.name=name;
        this.trackCount=trackCount;
        this.id=id;
        this.coverImgUrl=coverImgUrl;
    }
    public static class Creator{
        private String userId;
        private String userType;
        private String nickname;
        private String avatarUrl;
        public Creator(String userId,String userType,String nickname,String avatarUrl){
            this.nickname=nickname;
            this.userId=userId;
            this.userType=userType;
            this.avatarUrl=avatarUrl;
        }

        public String getNickname() {
            return nickname;
        }

        public String getUserId() {
            return userId;
        }

        public String getUserType() {
            return userType;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(String trackCount) {
        this.trackCount = trackCount;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }
}
