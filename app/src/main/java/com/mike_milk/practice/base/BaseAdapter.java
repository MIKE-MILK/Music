package com.mike_milk.practice.base;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * 时间：2020/5/3
 * 创建者：MIKE-MILK
 * 描述：
 */
public abstract class BaseAdapter<VH extends RecyclerView.ViewHolder, T> extends RecyclerView.Adapter<VH> {

    protected static final int VIEW_TYPE_EMPETY = 0;
    protected static final int VIEW_TYPE_ITEM = 1;

    private LayoutInflater mInflater;
    private Context mContext;

    public BaseAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public LayoutInflater getInflater() {
        return mInflater;
    }

    public abstract void notifyDataSetChanged(List<T> dataList);
}
