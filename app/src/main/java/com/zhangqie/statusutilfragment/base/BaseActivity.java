package com.zhangqie.statusutilfragment.base;

import android.support.v7.app.AppCompatActivity;

import com.jaeger.library.StatusBarUtil;
import com.zhangqie.statusutilfragment.R;

/**
 * Created by zhangqie on 2016/6/26.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setStatusBar();
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }

}
