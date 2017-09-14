package com.zhangqie.searchbox;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import com.zhangqie.searchbox.activity.SearchActivity;
import com.zhangqie.searchbox.util.Util;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.home_left_scan)
    ImageButton homeLeftScan;
    @Bind(R.id.home_right_more)
    ImageButton homeRightMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        //图标颜色改变
        homeRightMore.setImageDrawable(Util.tintDrawable(this,R.mipmap.icon_more, ColorStateList.valueOf(Color.WHITE)));
        homeLeftScan.setImageDrawable(Util.tintDrawable(this,R.mipmap.icon_scan, ColorStateList.valueOf(Color.WHITE)));

    }


    @OnClick(R.id.home_search)
    public void onClick() {
        Intent intent=new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);
    }
}
