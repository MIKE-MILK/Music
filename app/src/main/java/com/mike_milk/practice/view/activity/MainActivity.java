package com.mike_milk.practice.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.mike_milk.practice.R;
import com.mike_milk.practice.base.BaseFragment;
import com.mike_milk.practice.view.fragment.BannerFragment;
import com.mike_milk.practice.view.fragment.HomeFragment;

/**
 * 时间：2020/5/3
 * 创建者：MIKE-MILK
 * 描述：
 */
public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment;
    private BannerFragment bannerFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        homeFragment = new HomeFragment();
        bannerFragment=new BannerFragment();
        transaction.add(R.id.fragment_container, homeFragment);
        transaction.add(R.id.fragment_container,bannerFragment);
        transaction.show(bannerFragment);
        transaction.show(homeFragment);
        transaction.commit();
    }
}
