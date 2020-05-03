package com.mike_milk.practice.bean;

import com.mike_milk.practice.util.SevenUtil;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：
 */
public class User {
    private String UserName;
    private String UserPassWord;

    public User(String userName,String userPassWord){
        this.UserName=userName;
        this.UserPassWord=userPassWord;
    }

    public String toString(){
        return "UserName="+UserName+"UserPassword="+UserPassWord;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassWord() {
        return UserPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        UserPassWord = userPassWord;
    }
}
