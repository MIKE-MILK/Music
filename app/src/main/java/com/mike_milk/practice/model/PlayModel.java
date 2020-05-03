package com.mike_milk.practice.model;

import android.os.Handler;
import android.os.Message;

import com.mike_milk.practice.base.BaseModel;
import com.mike_milk.practice.contract.PlayContract;
import com.mike_milk.practice.util.LogUtil;
import com.mike_milk.practice.util.httprequesthelper.Callback;
import com.mike_milk.practice.util.httprequesthelper.NetUtil;
import com.mike_milk.practice.util.httprequesthelper.Request;

/**
 * 时间：2020/5/3
 * 创建者：MIKE-MILK
 * 描述：
 */
public class PlayModel extends BaseModel implements PlayContract.Model {
    private final static String TAG="PlayModel";
    private static String baseUrl="http://47.99.165.194";
    private static String songUrl="/song/url?id=336897539";

    public PlayModel(Handler handler) {
        super(handler);
    }

    @Override
    public void getMusic(String qid) {
        final Request request=new Request.Builder(baseUrl+songUrl).Method("GET").builder();
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
