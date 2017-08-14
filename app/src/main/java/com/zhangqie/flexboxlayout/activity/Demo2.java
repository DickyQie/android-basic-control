package com.zhangqie.flexboxlayout.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;
import com.zhangqie.flexboxlayout.R;
import com.zhangqie.flexboxlayout.entity.Book;
import com.zhangqie.flexboxlayout.util.Util;

/**
 * Created by zhangqie on 2017/8/8.
 */

public class Demo2 extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flexlayout2);
        initView();
    }

    private void initView() {
        String[] tags = {"散文", "设计", "那点事儿", "影视天堂", "大学生活", "美人说", "运动和健身", "生活家", "程序员", "想法", "短篇小说", "美食", "教育", "心理", "奇思妙想", "美食", "摄影"};
        FlexboxLayout flexboxLayout = (FlexboxLayout) findViewById(R.id.flexbox_layout);
        for (int i = 0; i < tags.length; i++) {
            Book model = new Book();
            model.setId(i);
            model.setName(tags[i]);
            flexboxLayout.addView(createNewFlexItemTextView(model));
        }


    }


    /**
     * 动态创建TextView
     * @param book
     * @return
     */
    private TextView createNewFlexItemTextView(final Book book) {
        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);
        textView.setText(book.getName());
        textView.setTextSize(12);
        textView.setTextColor(getResources().getColor(R.color.colorAccent));
        textView.setBackgroundResource(R.drawable.border_greey_roval_share);
        textView.setTag(book.getId());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("tag", book.getName());
                Toast.makeText(Demo2.this,book.getName(),Toast.LENGTH_LONG).show();
            }
        });
        int padding = Util.dpToPixel(this, 4);
        int paddingLeftAndRight = Util.dpToPixel(this, 8);
        ViewCompat.setPaddingRelative(textView, paddingLeftAndRight, padding, paddingLeftAndRight, padding);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        int margin = Util.dpToPixel(this, 6);
        int marginTop = Util.dpToPixel(this, 16);
        layoutParams.setMargins(margin, marginTop, margin, 0);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

}

