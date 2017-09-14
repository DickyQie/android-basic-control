package com.zhangqie.searchbox.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zhangqie on 2017/6/12.
 */

public class DrawableTextView extends TextView {

    public DrawableTextView(Context context, AttributeSet attrs,
                            int defStyle) {
        super(context, attrs, defStyle);
    }

    public DrawableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawableTextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        // 得到drawableLeft设置的drawable对象
        Drawable leftDrawable = drawables[0];
        if (leftDrawable != null) {
            // 得到leftDrawable的宽度
            int leftDrawableWidth = leftDrawable.getIntrinsicWidth();
            // 得到drawable与text之间的间距
            int drawablePadding = getCompoundDrawablePadding();
            // 得到文本的宽度
            int textWidth = (int) getPaint().measureText(getText().toString().trim());
            int bodyWidth = leftDrawableWidth + drawablePadding + textWidth;
            canvas.save();
            canvas.translate((getWidth() - bodyWidth) / 2, 0);
        }
        super.onDraw(canvas);
    }
}
