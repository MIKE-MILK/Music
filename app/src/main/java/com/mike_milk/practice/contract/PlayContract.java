package com.mike_milk.practice.contract;

import com.mike_milk.practice.base.IModel;
import com.mike_milk.practice.base.IPresenter;
import com.mike_milk.practice.base.IView;
import com.mike_milk.practice.bean.Play;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：
 */
public interface PlayContract {
    interface View extends IView {
        void onMusic();
        void onGetMusic(Play play);
    }
    interface Model extends IModel {
        void getMusic(String qid);
    }
    interface Presenter extends IPresenter {
        void getMusic(String qid);
    }
}
