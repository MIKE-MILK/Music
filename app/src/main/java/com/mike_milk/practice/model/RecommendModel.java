package com.mike_milk.practice.model;

import android.os.Handler;
import android.os.Message;

import com.mike_milk.practice.base.BaseModel;
import com.mike_milk.practice.contract.RecommendContract;
import com.mike_milk.practice.util.LogUtil;
import com.mike_milk.practice.util.httprequesthelper.Callback;
import com.mike_milk.practice.util.httprequesthelper.NetUtil;
import com.mike_milk.practice.util.httprequesthelper.Request;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：
 */
public class RecommendModel extends BaseModel implements RecommendContract.Model {
    private final static String TAG="recommend";
    private static String baseUrl="http://47.99.165.194";
    private static String treeUrl="/top/playlist?id=336897539";

    public RecommendModel(Handler handler) {
        super(handler);
    }

    @Override
    public void getPlayList() {
        final Request request=new Request.Builder(baseUrl+treeUrl).
                Method("GET").builder();
        NetUtil.getInstance().execute(request, new Callback() {
            @Override
            public void onResponse(String response) {
                Message message=new Message();
                message.what=101;
                message.obj=response;
                LogUtil.d(TAG,"Response"+message);
                sendMessage(message);
                LogUtil.d(TAG,"GET");
            }

            @Override
            public void onFailed(Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
