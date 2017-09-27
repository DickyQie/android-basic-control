package com.zhangqie.statusutilfragment.ui;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhangqie.statusutilfragment.R;

/**
 * Created by zhangqie on 2016/6/26.
 */

public class SimpleFragment extends Fragment {

    private TextView mTvTitle;
    private View mFakeStatusBar;
    private TextView mTvContext;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.simple_fragement, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        mFakeStatusBar = view.findViewById(R.id.fake_status_bar);
        mTvContext= (TextView) view.findViewById(R.id.tv_content);
    }

    public void setTvTitleBackgroundColor(@ColorInt int color) {
        mTvTitle.setBackgroundColor(color);
        mFakeStatusBar.setBackgroundColor(color);
        mTvContext.setTextColor(color);
    }

}
