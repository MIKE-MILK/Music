package com.mike_milk.practice.view.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.mike_milk.practice.R;
import com.mike_milk.practice.base.BaseActivity;
import com.mike_milk.practice.bean.Play;
import com.mike_milk.practice.contract.PlayContract;
import com.mike_milk.practice.presenter.PlayPresenter;

import java.util.List;
import java.util.Timer;

/**
 * 时间：2020/5/3
 * 创建者：MIKE-MILK
 * 描述：
 */
public class PlayActivity extends BaseActivity<PlayPresenter>implements PlayContract.View {
    private MediaPlayer mediaPlayer;
    private ImageView picImage;
    private ImageView stop;
    private TextView MusicName;
    private TextView creator;
    //互斥变量，防止进度条与定时器冲突。
    private boolean isSeekBarChanging;
    //当前音乐播放的进度
    private int currentPosition;
    private SeekBar seekBar;
    private Timer timer;
    private static final String TAG = "MediaActivity";
    private List<Play>plays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initView();
        intData();
    }

    public void initView(){
        mediaPlayer=new MediaPlayer();
        seekBar=(SeekBar)findViewById(R.id.playSeekBar);
        picImage=(ImageView)findViewById(R.id.play_iv);
        stop=(ImageView)findViewById(R.id.play);
        MusicName=(TextView)findViewById(R.id.music_name);
        creator=(TextView)findViewById(R.id.creator_name);
    }

    public void intData(){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isSeekBarChanging=true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                isSeekBarChanging=false;
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.mipmap.zanting:
                currentPosition = mediaPlayer.getCurrentPosition();//记录播放的位置
                mediaPlayer.stop();//暂停状态
                stop.setImageResource(R.mipmap.play);
                timer.purge();//移除所有任务;
                break;
                    case R.mipmap.play:
                        mediaPlayer.reset();
                        stop.setImageResource(R.mipmap.zanting);
                        play();
                        break;
                }
            }
        });

    }

    public void play(){

    }


    @Override
    public PlayPresenter initPresenter() {
        return new PlayPresenter(this);
    }

    @Override
    public void onMusic() {
        String qid="336897539";
        mPresenter.getMusic(qid);
    }

    @Override
    public void onGetMusic(Play play) {
        this.plays.add(play);
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        timer.cancel();
        timer = null;
        mediaPlayer = null;
        super.onDestroy();
    }
}
