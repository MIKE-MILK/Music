package com.mike_milk.practice.presenter;

import android.os.Handler;
import android.os.Message;

import com.mike_milk.practice.base.BasePresenter;
import com.mike_milk.practice.bean.Recommend;
import com.mike_milk.practice.contract.RecommendContract;
import com.mike_milk.practice.model.RecommendModel;
import com.mike_milk.practice.util.LogUtil;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 时间：2020/5/3
 * 创建者：MIKE-MILK
 * 描述：
 */
public class RecommendPresenter extends BasePresenter<RecommendContract.Model,RecommendContract.View>implements RecommendContract.Presenter {
    private final static String TAG="Recommend";
    private JSONObject jsonObject;
    public RecommendPresenter(RecommendContract.View view) {
        super(view);
    }

    @Override
    public RecommendContract.Model initModel(Handler handler) {
        return new RecommendModel(handler);
    }

    @Override
    public void modelResponse(Message msg) {
        switch (msg.what){
            case 101:
                parsePlaylist(msg.obj.toString());
                break;
        }
    }
    public void parsePlaylist(String response){
        try {
            JSONArray jsonArray=new JSONArray(new JSONObject(response).getJSONObject("playlists").toString());
            for (int i = 0; i<jsonArray.length(); i++){
                jsonObject=jsonArray.getJSONObject(i);
                String name=jsonObject.getString("name");
                String id=jsonObject.getString("id");
                String coverImgUrl=jsonObject.getString("coverImgUrl");
                String trackCount=jsonObject.getString("trackCount");
                Recommend recommend=new Recommend(name,id,trackCount,coverImgUrl);
                LogUtil.d(TAG,"response");
                mView.onPlayList(recommend);
            }
            String userId=jsonObject.getString("userId");
            String nickname=jsonObject.getString("nickname");
            String avatarUrl=jsonObject.getString("avatarUrl");
            String userType=jsonObject.getString("userType");
            LogUtil.d(TAG,"creator");
            Recommend.Creator creator=new Recommend.Creator(userId,userType,nickname,avatarUrl);
            mView.onCreator(creator);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void getPlayList() {
        mModel.getPlayList();
    }

}
