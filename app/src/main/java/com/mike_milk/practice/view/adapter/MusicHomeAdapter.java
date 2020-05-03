package com.mike_milk.practice.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mike_milk.practice.R;
import com.mike_milk.practice.bean.Recommend;
import com.mike_milk.practice.util.LogUtil;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：
 */
public class MusicHomeAdapter extends RecyclerView.Adapter<MusicHomeAdapter.ViewHolder>implements View.OnClickListener {
    private final static String TAG="playlist";
    private OnItemClickListener onItemClickListener;
    private Context context;
    private List<Recommend>recommendList=new ArrayList<>();
    private List<JSONObject>jsonObjectList;
    private int type;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private String iv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void setData(Object o){
            ImageView imageView=itemView.findViewById(R.id.item_music);
            try {
                Picasso.with(itemView.getContext()).load(iv).into(imageView);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public MusicHomeAdapter(List<Recommend>list){
        recommendList=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(jsonObjectList.get(position));
    }

    @Override
    public int getItemCount() {
        //LogUtil.d(TAG,"NUM"+recommendList.size());
        return  recommendList == null ? 0 : type == 1 ? 6 : recommendList.size();
    }

    @Override
    public void onClick(View v) {

    }
    public interface OnItemClickListener {
        void onItemClick(View v,int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
