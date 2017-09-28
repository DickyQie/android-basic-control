package com.zhangqie.bottomnavigationbar;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zhangqie.bottomnavigationbar.fragment.FourFragment;
import com.zhangqie.bottomnavigationbar.fragment.OneFragment;
import com.zhangqie.bottomnavigationbar.fragment.ThreeFragment;
import com.zhangqie.bottomnavigationbar.fragment.TowFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Fragment mCurrentFragment;
    private BottomNavigationBar mBottomNavigationBar;
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    BadgeItem badgeItem;
    FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        mFragmentManager=getSupportFragmentManager();
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

    /**
     * Mode
     xml：bnbMode
     方法：setMode()
     包含3种Mode:

     MODE_DEFAULT
     如果Item的个数<=3就会使用MODE_FIXED模式，否则使用MODE_SHIFTING模式

     MODE_FIXED （固定大小）
     。填充模式，未选中的Item会显示文字，没有换挡动画。
     。宽度=总宽度/action个数
     。最大宽度: 168dp
     。最小宽度: 80dp
     。Padding：6dp（8dp）、10dp、12dp
     。字体大小：12sp、14sp

     MODE_SHIFTING （不固定大小）
     。换挡模式，未选中的Item不会显示文字，选中的会显示文字。在切换的时候会有一个像换挡的动画

     Background Style

     方法：setBackgroundStyles()
     包含3种Style:

     BACKGROUND_STYLE_DEFAULT
     如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC 。如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。

     BACKGROUND_STYLE_STATIC
     。点击的时候没有水波纹效果
     。航条的背景色是白色，加上setBarBackgroundColor（）可以设置成你所需要的任何背景颜色

     BACKGROUND_STYLE_RIPPLE
     。点击的时候有水波纹效果
     。导航条的背景色是你设置的处于选中状态的 Item的颜色（ActiveColor），也就是setActiveColorResource这个设置的颜色
     */


}
