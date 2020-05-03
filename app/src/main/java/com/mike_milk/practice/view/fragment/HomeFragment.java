package com.mike_milk.practice.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.mike_milk.practice.R;
import com.mike_milk.practice.base.BaseFragment;
import com.mike_milk.practice.bean.Recommend;
import com.mike_milk.practice.contract.RecommendContract;
import com.mike_milk.practice.presenter.RecommendPresenter;
import com.mike_milk.practice.view.adapter.MusicHomeAdapter;

import java.util.List;
import java.util.logging.Handler;

/**
 * 时间：2020/5/2
 * 创建者：MIKE-MILK
 * 描述：
 */
public class HomeFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.View {
    private static final String TAG="HomeFragment";
    private RecyclerView recyclerView;
    private List<Recommend>recommendList;
    private List<Recommend.Creator>creators;
    //banner当前位置
    private int currentPosition = 1;
    //banner之前位置
    private int previousPosition = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_homgpage,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.home_rv);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        MusicHomeAdapter adapter=new MusicHomeAdapter(recommendList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public RecommendPresenter initPresenter() {
        return new RecommendPresenter(this);
    }

    @Override
    public void onGetPlayList() {
        mPresenter.getPlayList();
    }

    @Override
    public void onCreator(String id) {
        mPresenter.getPlayList();
    }

    @Override
    public void onPlayList(Recommend recommend) {
        this.recommendList.add(recommend);
    }

    @Override
    public void onCreator(Recommend.Creator creator) {
        this.creators.add(creator);
    }

}
