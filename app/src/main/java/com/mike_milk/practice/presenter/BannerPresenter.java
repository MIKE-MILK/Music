package com.mike_milk.practice.presenter;

import android.nfc.Tag;
import android.os.Handler;
import android.os.Message;

import com.mike_milk.practice.base.BasePresenter;
import com.mike_milk.practice.bean.Banner;
import com.mike_milk.practice.contract.BannerContract;
import com.mike_milk.practice.model.BannerModel;
import com.mike_milk.practice.util.LogUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：
 */
public class BannerPresenter extends BasePresenter<BannerContract.Model,BannerContract.View>implements BannerContract.Presenter {
    private final static String TAG="bannerPresenter";
    private List<Banner>bannerList=new ArrayList<>();
    public BannerPresenter(BannerContract.View view) {
        super(view);
    }

    @Override
    public BannerContract.Model initModel(Handler handler) {
        return new BannerModel(handler);
    }

    @Override
    public void modelResponse(Message msg) {
        switch (msg.what){
            case 101:
                parseBanner(msg.obj.toString());
                break;
        }
    }

    @Override
    public void getAlbum() {
        mModel.getAlbum();
    }
    //数据分析
    private void parseBanner(String response){
        JSONArray jsonArray;
        JSONArray jsonArray1;
        try{
            JSONObject object=new JSONObject(response);
            LogUtil.d(TAG,"数据分析");
            if ("200".equals(object.getString("code"))){
                jsonArray=new JSONArray(new JSONObject(response).getJSONObject("albums").toString());
                for (int i=0;i<jsonArray.length();i++){
                    String name=object.getString("name");
                    String id=object.getString("id");
                    Banner banner=new Banner(name,id);
                    LogUtil.d(TAG,"id"+id);
                    mView.onAlbums(banner);
                    JSONObject object1=new JSONObject(response);
                    String id1=object1.getJSONObject("artist").getString("name");
                    String name1=object1.getJSONObject("artist").getString("id");
                    Banner.Artist artist=new Banner.Artist(name1,id1);
                    mView.onArtist(artist);
                    LogUtil.d(TAG,"artist");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
