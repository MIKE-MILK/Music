package com.mike_milk.practice.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mike_milk.practice.R;
import com.mike_milk.practice.bean.User;
import com.mike_milk.practice.presenter.UserLoginPresenter;
import com.mike_milk.practice.view.fragment.BannerFragment;
import com.mike_milk.practice.view.login.UserLoginView;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：实现伪登录，没有使用到网络请求
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener, UserLoginView {
    private UserLoginPresenter userLoginPresenter;
    EditText editTextName;
    EditText editTextPassword;
    Button Login;
    private User user;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
//        initData();
    }

    private void initView(){
        Login=(Button)findViewById(R.id.login_bt);
        editTextName=(EditText)findViewById(R.id.login_account_et);
        editTextPassword=(EditText)findViewById(R.id.login_password_et);
        Login.setOnClickListener(this);
        userLoginPresenter=new UserLoginPresenter(this);
    }

//    private void initData(){
//        Intent intent=getIntent();
//        String accountValue=intent.getStringExtra("accountKey");
//        String passwordValue=intent.getStringExtra("password");
//        editTextName.setText(accountValue);
//        editTextPassword.setText(passwordValue);
//    }

    @Override
    public void onClick(View v) {
        userLoginPresenter.login();
        //ToastUtil.shortToast(context,"登录成功");
    }

    @Override
    public String getUserName() {
        return editTextName.getText().toString();
    }

    @Override
    public String getUserPassword() {
            return editTextPassword.getText().toString();
    }

    @Override
    public void skiptohome() {
        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
