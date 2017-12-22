package com.zhangqie.buttonvoice;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zhangqie.buttonvoice.fragment.FourFragment;
import com.zhangqie.buttonvoice.fragment.OneFragment;
import com.zhangqie.buttonvoice.fragment.ThreeFragment;
import com.zhangqie.buttonvoice.fragment.TowFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Fragment mCurrentFragment;
    private BottomNavigationBar mBottomNavigationBar;
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    BadgeItem badgeItem;
    FragmentManager mFragmentManager;

    MediaPlayer music = null;// 播放器引用

    SoundPool soundPool;
    int soundID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        mFragmentManager=getSupportFragmentManager();
        initSound();
        initFragment();
        showFragment(0);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setBarBackgroundColor(android.R.color.white);
        badgeItem = new BadgeItem()
                .setBackgroundColor(Color.RED).setText("99")
                .setHideOnSelect(true); //设置被选中时隐藏角标
        mBottomNavigationBar
                .setActiveColor(R.color.colorBottomBack) //设置选中的颜色
                .setInActiveColor(R.color.colorActive);//未选中

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.icon_home_normal, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.icon_shop_normal, "店铺"))
                .addItem(new BottomNavigationItem(R.drawable.icon_cart_normal, "购物车"))
                .addItem(new BottomNavigationItem(R.drawable.icon_my_normal, "我的").setBadgeItem(badgeItem))
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){

            @Override
            public void onTabSelected(int position) {
                //PlayMusic(R.raw.qipao);//方式1
                playSound();//方式二
                showFragment(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }


    private void initFragment(){
        mFragmentList.add(new OneFragment());
        mFragmentList.add(new TowFragment());
        mFragmentList.add(new ThreeFragment());
        mFragmentList.add(new FourFragment());
    }
    private void showFragment(int page) {
        FragmentTransaction mFragmentTransaction = mFragmentManager
                .beginTransaction();
        if (mCurrentFragment != null) {
            mFragmentTransaction.hide(mCurrentFragment);
        }
        mCurrentFragment = mFragmentList.get(page);
        if (mCurrentFragment.isAdded())
        {
            mFragmentTransaction.show(mCurrentFragment);
        }else {
            mFragmentTransaction.add(R.id.fragment, mCurrentFragment);
        }
        mFragmentTransaction.commitAllowingStateLoss();
    }

    private void PlayMusic(int MusicId) {
        music = MediaPlayer.create(this, MusicId);
        music.start();
    }


    @SuppressLint("NewApi")
    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundID = soundPool.load(this, R.raw.qipao, 1);
    }
    private void playSound() {
        soundPool.play(
                soundID,
                0.9f,   //左耳道音量【0~1】
                0.9f,   //右耳道音量【0~1】
                0,     //播放优先级【0表示最低优先级】
                0,     //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1     //播放速度【1是正常，范围从0~2】
        );
    }


}
