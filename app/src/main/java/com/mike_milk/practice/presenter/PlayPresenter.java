package com.mike_milk.practice.presenter;

import android.os.Handler;
import android.os.Message;

import com.mike_milk.practice.base.BasePresenter;
import com.mike_milk.practice.bean.Play;
import com.mike_milk.practice.contract.PlayContract;
import com.mike_milk.practice.model.PlayModel;
import com.mike_milk.practice.util.LogUtil;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 时间：2020/5/3
 * 创建者：MIKE-MILK
 * 描述：
 */
public class PlayPresenter extends BasePresenter<PlayContract.Model,PlayContract.View>implements PlayContract.Presenter {
    private final static String TAG="PlayPresenter";
    private JSONObject jsonObject;
    public PlayPresenter(PlayContract.View view) {
        super(view);
    }

    @Override
    public PlayContract.Model initModel(Handler handler) {
        return new PlayModel(handler);
    }

    @Override
    public void modelResponse(Message msg) {
        switch (msg.what){
            case 101:
                parsePlay(msg.obj.toString());
                break;
        }
    }

    public void parsePlay(String response){
        try {
            JSONArray jsonArray=new JSONArray(new JSONObject(response).getJSONObject("data").toString());
            for (int i=0;i<jsonArray.length();i++){
                jsonObject=jsonArray.getJSONObject(i);
                String id=jsonObject.getString("id");
                String url=jsonObject.getString("url");
                String fee=jsonObject.getString("fee");
                String level=jsonObject.getString("level");
                String size=jsonObject.getString("size");
                Play play=new Play(id,url,size,fee,level);
                mView.onGetMusic(play);
                LogUtil.d(TAG,"play");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void getMusic(String qid) {
        mModel.getMusic(qid);
    }
}
