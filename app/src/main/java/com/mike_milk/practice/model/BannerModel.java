package com.mike_milk.practice.model;

import android.os.Handler;
import android.os.Message;
import android.widget.SeekBar;

import com.mike_milk.practice.base.BaseModel;
import com.mike_milk.practice.contract.BannerContract;
import com.mike_milk.practice.util.LogUtil;
import com.mike_milk.practice.util.httprequesthelper.Callback;
import com.mike_milk.practice.util.httprequesthelper.NetUtil;
import com.mike_milk.practice.util.httprequesthelper.Request;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：
 */
public class BannerModel extends BaseModel implements BannerContract.Model {
    private final static String TAG="banner";
    private static String baseUrl="http://47.99.165.194";
    private static String BannerUrl="/album/newest?id=336897539";
    private String url="http://47.99.165.194/album/newest?id=336897539";
    public BannerModel(Handler handler) {
        super(handler);
    }

    @Override
    public void getAlbum() {
        final Request request=new Request.
                Builder(baseUrl+baseUrl)
                .Method("GET")
                .builder();
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
                LogUtil.d(TAG,"failed");
            }
        });
    }
}
