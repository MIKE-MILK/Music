package com.mike_milk.practice.bean;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：
 */
public class Banner {
    private String name;
    private String id;
    private String size;
    private String picUrl;
    public Banner(String name, String id){
        this.name=name;
        this.id=id;
    }
    public static class Artist{
        private String name;
        private String id;
        private String albumSize;
        private String musicSize;

        public Artist(String name, String id){
            this.name=name;
            this.id=id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setAlbumSize(String albumSize) {
            this.albumSize = albumSize;
        }

        public String getAlbumSize() {
            return albumSize;
        }

        public void setMusicSize(String musicSize) {
            this.musicSize = musicSize;
        }

        public String getMusicSize() {
            return musicSize;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
