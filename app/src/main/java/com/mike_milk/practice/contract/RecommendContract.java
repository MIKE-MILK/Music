package com.mike_milk.practice.contract;

import com.mike_milk.practice.base.IModel;
import com.mike_milk.practice.base.IPresenter;
import com.mike_milk.practice.base.IView;
import com.mike_milk.practice.bean.Recommend;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：
 */
public interface RecommendContract {
    interface View extends IView{
        void onGetPlayList();
        void onPlayList(Recommend recommend);
        void onCreator(String id);
        void onCreator(Recommend.Creator creator);
    }
    interface Model extends IModel{
        void getPlayList();
    }
    interface Presenter extends IPresenter{
        void getPlayList();
    }
}
