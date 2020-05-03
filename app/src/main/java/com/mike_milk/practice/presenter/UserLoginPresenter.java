package com.mike_milk.practice.presenter;

import android.content.Context;

import com.mike_milk.practice.bean.User;
import com.mike_milk.practice.contract.LoginListener;
import com.mike_milk.practice.contract.UserLogin;
import com.mike_milk.practice.model.mUserLogin;
import com.mike_milk.practice.view.login.UserLoginView;

/**
 * 时间：2020/3/18
 * 创建者：MIKE-MILK
 * 描述：
 */
public class UserLoginPresenter {
   private UserLogin userLogin;
   private UserLoginView userLoginView;
   private Context context;

   public UserLoginPresenter(UserLoginView userLoginView){
       this.userLoginView=userLoginView;
       this.userLogin=new mUserLogin();
   }

   public void login(){
       User user=new User(userLoginView.getUserName(),userLoginView.getUserPassword());
       userLogin.login(user, new LoginListener() {
           @Override
           public void Success() {
           if (userLoginView.getUserName()!=null&&userLoginView.getUserPassword()!=null){
               System.out.println("Success");
               userLoginView.skiptohome();
           }
           }

           @Override
           public void Failed() {
               System.out.println("Failed");
           }
       });
   }
}
