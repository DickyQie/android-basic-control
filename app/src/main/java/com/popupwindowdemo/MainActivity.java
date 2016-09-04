package com.popupwindowdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

/*****
        *
        * PopupWindow
        *
        * @author zq
        *
        */
public class MainActivity extends Activity implements OnClickListener {


    private PopupWindow mPopWindow;
    private View parentView;
    private Context context;
    ImageView mImageViewBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        context = this;
        initView();
    }

    private void initView() {
        // TODO Auto-generated method stub
        parentView = getLayoutInflater().inflate(R.layout.activity_main, null);
        mImageViewBar = (ImageView) findViewById(R.id.menu);
        mImageViewBar.setOnClickListener(this);
        showPopupWindow();
    }

    private void showPopupWindow() {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.popuplayout, null);
        mPopWindow = new PopupWindow(contentView);
        mPopWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopWindow = new PopupWindow();
        // 设置SelectPicPopupWindow的View
        mPopWindow.setContentView(contentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        mPopWindow.setWidth(LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        mPopWindow.setHeight(LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        mPopWindow.setFocusable(true);
        mPopWindow.setOutsideTouchable(true);
        // 刷新状态
        mPopWindow.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        mPopWindow.setBackgroundDrawable(dw);
        contentView.findViewById(R.id.memu1).setOnClickListener(this);
        contentView.findViewById(R.id.memu2).setOnClickListener(this);
        contentView.findViewById(R.id.memu3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.menu:
                mPopWindow.showAsDropDown(mImageViewBar);
                break;
            case R.id.memu1: {
                Toast.makeText(context, "消息", Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
            }
            break;
            case R.id.memu2: {
                Toast.makeText(context, "收藏", Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
            }
            break;
            case R.id.memu3: {
                Toast.makeText(context, "首页", Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
            }
            break;
        }
    }
}

