package com.mike_milk.practice.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.mike_milk.practice.R;
import com.mike_milk.practice.base.BaseActivity;
import com.mike_milk.practice.base.BaseFragment;
import com.mike_milk.practice.bean.Banner;
import com.mike_milk.practice.contract.BannerContract;
import com.mike_milk.practice.presenter.BannerPresenter;
import com.mike_milk.practice.view.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：.
 */
public class BannerFragment extends BaseFragment<BannerPresenter> implements View.OnClickListener, BannerContract.View {
    private ViewPager viewPager;
    private TextView textView;
    private List<Banner>imageViews=new ArrayList<>();
    private int previousPosition=0;
    private List<Banner>bannerList=new ArrayList<>();
    private List<Banner.Artist>artists=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_homgpage,container,false);
        viewPager=(ViewPager)view.findViewById(R.id.home_viewPager);
        init();
        return view;
    }
    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_homgpage);
//        imageViews.add(R.id.pager_image1);
//        init();
//    }

    public void init(){
        //initData();
        initView();
//        autoPlayView();
    }

//    public void initData(){
//
//    }

    public void initView(){
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(imageViews,viewPager);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int newPosition=position%imageViews.size();
                previousPosition=newPosition;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setFirstLocation();
    }
    private void setFirstLocation() {
        // 把ViewPager设置为默认选中Integer.MAX_VALUE / t2，从十几亿次开始轮播图片，达到无限循环目的;
        int m = (Integer.MAX_VALUE / 2) % imageViews.size();
        int currentPosition = Integer.MAX_VALUE / 2 - m;
        viewPager.setCurrentItem(currentPosition);
    }

//    public void autoPlayView(){
//        //自动播放图片
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                boolean isStop=false;
//                while (!isStop){
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
//                        }
//                    });
//                    SystemClock.sleep(5000);
//                }
//            }
//        }).start();
//   }

    @Override
    public void onClick(View v) {
        //banner的点击的情况
        switch (v.getId()){

        }
    }

    @Override
    public BannerPresenter initPresenter() {
        return new BannerPresenter(this);
    }

    @Override
    public void onGetAlbums() {
        mPresenter.getAlbum();
    }

    @Override
    public void onAlbums(Banner banner) {
        this.bannerList.add(banner);
    }

    @Override
    public void onGetArtist(String id) {
        mPresenter.getAlbum();
    }

    @Override
    public void onArtist(Banner.Artist artist) {
        this.artists.add(artist);
    }
}
