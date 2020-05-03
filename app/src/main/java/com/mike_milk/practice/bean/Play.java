package com.mike_milk.practice.bean;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：
 */
public class Play {
    private String id;
    private String url;
    private String size;
    private String fee;
    private String level;
    public Play(String id,String url,String size,String fee,String level){
        this.fee=fee;
        this.id=id;
        this.level=level;
        this.url=url;
        this.size=size;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    public String getFree() {
        return fee;
    }

    public String getLevel() {
        return level;
    }

    public String getUrl() {
        return url;
    }

    public void setFree(String free) {
        this.fee = free;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
