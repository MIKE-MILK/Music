package com.mike_milk.practice.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * 时间：2020/3/27
 * 创建者：MIKE-MILK
 * 描述：
 */
public abstract class BaseQuickAdapter<K, B extends RecyclerView.ViewHolder>extends RecyclerView.Adapter<BaseViewHolder> {
        private List<K> data;
        private int layoutId;

        //暴露给用户的接口,绑定数据
        public abstract void convert(BaseViewHolder baseViewHolder, K itemData);

        public BaseQuickAdapter(List<K> data, int layoutId) {
            this.data = data;
            this.layoutId = layoutId;
        }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        if (data == null || data.size() == 0)
            return;
        convert(holder, data.get(position));//注意：convert方法必须在onBindViewHolder中调用，将ViewHolder和数据给用户进行绑定
    }

    @Override
        public int getItemCount() {
            return data == null ? 0 : data.size();
        }

    public interface OnItemClickListener {
        void onItemClick(BaseQuickAdapter adapter, View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;
    public BaseQuickAdapter<K, B> setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
        return this;
    }

    public List<K> getData() {
        return data;
    }
}


