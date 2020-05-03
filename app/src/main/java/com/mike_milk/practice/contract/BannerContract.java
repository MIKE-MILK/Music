package com.mike_milk.practice.contract;

import com.mike_milk.practice.base.IModel;
import com.mike_milk.practice.base.IPresenter;
import com.mike_milk.practice.base.IView;
import com.mike_milk.practice.bean.Banner;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：
 */
public interface BannerContract {
    interface View extends IView{
        //p对v的回应
        //第一层
        void onGetAlbums();
        void onAlbums(Banner banner);
        //第二层
        void onGetArtist(String id);
        void onArtist(Banner.Artist artist);
    }
    interface Model extends IModel{
        //p调用m
        void getAlbum();
    }
    interface Presenter extends IPresenter{
        //v调用p
        void getAlbum();
    }
}
