package com.sollyu.android.option.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者：Sollyu
 * 日期：2017/6/21
 * 说明：
 */

public class OptionItemLine extends View {
    public OptionItemLine(Context context) {
        super(context);
        initView(context);
    }

    public OptionItemLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);

        int[] set = {
                android.R.attr.background
        };

        TypedArray typedArray = context.obtainStyledAttributes(attrs, set);
        typedArray.recycle();
    }

    private void initView(Context context) {
        this.setBackgroundColor(Color.parseColor("#D2D2D2"));
    }
}
