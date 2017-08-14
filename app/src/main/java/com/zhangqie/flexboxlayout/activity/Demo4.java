package com.zhangqie.flexboxlayout.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.flexbox.FlexboxLayout;
import com.zhangqie.flexboxlayout.R;


/**
 * Created by zhangqie on 2017/8/13.
 *
 * alignContent
 */

public class Demo4 extends AppCompatActivity implements View.OnClickListener{

    FlexboxLayout flexboxLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flexlayout4);
        initView();
    }

    private void initView() {
        flexboxLayout = (FlexboxLayout) findViewById(R.id.flexbox_layout);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                flexboxLayout.setAlignContent(FlexboxLayout.ALIGN_CONTENT_FLEX_END);
                break;
            case R.id.btn2:
                flexboxLayout.setAlignContent(FlexboxLayout.ALIGN_CONTENT_CENTER);
                break;
            case R.id.btn3:
                flexboxLayout.setAlignContent(FlexboxLayout.ALIGN_CONTENT_SPACE_BETWEEN);
                break;
            case R.id.btn4:
                flexboxLayout.setAlignContent(FlexboxLayout.ALIGN_CONTENT_SPACE_AROUND);
                break;
        }
    }

}
