package com.zhangqie.searchbox.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhangqie.searchbox.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhangqie on 2017/6/12.
 */

public class SearchActivity extends AppCompatActivity {

    @Bind(R.id.search_text)
    EditText searchText;
    @Bind(R.id.search_close)
    TextView searchClose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId == 0 || actionId == 3) && event != null) {
                    Toast.makeText(SearchActivity.this,searchText.getText().toString(),Toast.LENGTH_LONG).show();
                    //可以跳转搜索页面
                   /* Intent intent= new Intent(SearchActivity.this,SearchWebViewActivity.class);
                    intent.putExtra("model",model);
                    intent.putExtra("search",searchText.getText().toString());
                    startActivity(intent);
                    finish();*/
                }
                return false;
            }
        });

        //删除按钮
        searchText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 得到一个长度为4的数组，分别表示左右上下四张图片
                Drawable drawable = searchText.getCompoundDrawables()[2];
                if (drawable == null)
                    return false;
                if (event.getAction() != MotionEvent.ACTION_UP)//  //如果不是按下事件，不再处理
                    return false;
                if (event.getX() > searchText.getWidth()
                        - searchText.getPaddingRight()
                        - drawable.getIntrinsicWidth()){
                    searchText.setText("");
                }
                return false;
            }
        });
    }

    @OnClick(R.id.search_close)
    public void onClick() {
       finish();
    }

}
