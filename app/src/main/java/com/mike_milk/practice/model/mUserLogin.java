package com.mike_milk.practice.model;

import com.mike_milk.practice.bean.User;
import com.mike_milk.practice.contract.LoginListener;
import com.mike_milk.practice.contract.UserLogin;

/**
 * 时间：2020/3/17
 * 创建者：MIKE-MILK
 * 描述：
 */
public class mUserLogin implements UserLogin {

    @Override
    public void login(final User user, final LoginListener login) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if (user.getUserName().equals("1564551739")&& user.getUserPassWord().equals("123456789")){
                    //回调
                    login.Success();

                }else {

                    login.Failed();
                }
            }
        }.start();
    }
}
