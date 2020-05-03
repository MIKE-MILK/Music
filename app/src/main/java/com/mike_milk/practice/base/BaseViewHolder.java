package com.mike_milk.practice.base;

import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * 时间：2020/3/27
 * 创建者：MIKE-MILK
 * 描述：
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private View convertView;
    private SparseArray<View> views;//item view缓存

    public BaseViewHolder(View itemView) {
        super(itemView);
        convertView = itemView;
        views = new SparseArray<>();
    }

    //从SparseArray<View> views中查找，有则返回view，无则先缓存再返回view;
    private View getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return view;
    }

    //TextView setText
    public void setText(int viewId, String content) {
        ((TextView) getView(viewId)).setText(content);
    }

    //ImageView 设置背景图
    public void setImageResource(int viewId, int drawableId) {
        View view = getView(viewId);
        if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(drawableId);
        } else
            return;
    }
    //....其他各种set、get方法.....
}


