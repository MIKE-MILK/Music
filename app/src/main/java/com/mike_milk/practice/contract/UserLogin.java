package com.mike_milk.practice.contract;

import com.mike_milk.practice.bean.User;

/**
 * 时间：2020/3/17
 * 创建者：MIKE-MILK
 * 描述：
 */
public interface UserLogin {
    void login(User user, LoginListener login);
}
