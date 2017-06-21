package com.sollyu.android.option.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.kyleduo.switchbutton.SwitchButton;


/**
 * author: sollyu
 * time  : 2017/6/21
 * mail  : sollyu@qq.com
 */
public class OptionItemSwitch extends OptionItemBase {
    private SwitchButton mRightSwitch = null;

    public OptionItemSwitch(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    @Override
    protected void initView(Context context) {
        super.initView(context);
    }

    @Override
    protected void initView(Context context, @Nullable AttributeSet attrs) {
        super.initView(context, attrs);

        mRightSwitch = new SwitchButton(context, attrs);

        LayoutParams rightTextViewLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightTextViewLayoutParams.rightMargin = dip2px(context, 15.0f);

        this.addView(mRightSwitch, rightTextViewLayoutParams);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OptionItemSwitch);
        typedArray.recycle();
    }

    public SwitchButton getSwitch() {
        return mRightSwitch;
    }

    public void setChecked(boolean checked) {
        getSwitch().setChecked(checked);
    }

    public boolean isChecked() {
        return getSwitch().isChecked();
    }
}
