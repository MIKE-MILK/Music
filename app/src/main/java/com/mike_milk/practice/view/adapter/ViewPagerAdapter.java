package com.mike_milk.practice.view.adapter;

import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mike_milk.practice.R;
import com.mike_milk.practice.bean.Banner;
import com.mike_milk.practice.util.httprequesthelper.NetUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：
 */
public class ViewPagerAdapter extends PagerAdapter {
    private List<Banner> images;
    private ViewPager viewPager;

    public ViewPagerAdapter(List<Banner> images, ViewPager viewPager) {
        this.images  = images;
        this.viewPager = viewPager;
    }

    @Override
    public int getCount() {
        //返回一个无限大的值，可以 无限循环
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
       final View view=View.inflate(container.getContext(), R.layout.item_bannner,null);
       final ImageView imageView=view.findViewById(R.id.iv_banner);
       view.post(new Runnable() {
           @Override
           public void run() {
               String id ="";
               RequestOptions options = new RequestOptions()
                       .placeholder(R.color.colorAccent)
                       .error(R.color.colorAccent)
                       .override(view.getWidth(), view.getWidth() / 9 * 5);
               Glide.with(imageView.getContext()).load(images.get(position).getPicUrl()).apply(options).into(imageView);
               imageView.setDrawingCacheEnabled(true);
               images.get(position).setId(id);
               imageView.setDrawingCacheEnabled(false);
           }
       });
       container.addView(view);
       return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // 把ImageView从ViewPager中移除掉
       container.removeView((View)object);
    }
}
