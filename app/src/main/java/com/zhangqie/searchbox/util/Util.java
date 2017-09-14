package com.zhangqie.searchbox.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;

/**
 * Created by zhangqie on 2017/6/12.
 */

public class Util {

    /***
     * 图片颜色修改
     * @param context
     * @param image
     * @param colors
     * @return
     */
    public static Drawable tintDrawable(Context context, int image, ColorStateList colors) {
        Drawable drawable = context.getResources().getDrawable(image);
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, colors);
        return wrappedDrawable;
    }

}
