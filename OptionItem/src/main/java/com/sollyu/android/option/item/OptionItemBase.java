package com.sollyu.android.option.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * author: sollyu
 * time  : 2017/6/21
 * mail  : sollyu@qq.com
 */
public class OptionItemBase extends LinearLayout {
    private TextView mLeftTextView = null;

    public OptionItemBase(Context context) {
        super(context);
    }

    public OptionItemBase(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    protected void initView(Context context) {
        mLeftTextView = new TextView(context);

        TextView middleTextView = new TextView(context);

        LayoutParams rightTextViewLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightTextViewLayoutParams.leftMargin = dip2px(context, 15.0f);

        LayoutParams middleTextViewLayoutParams = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
        middleTextViewLayoutParams.leftMargin = dip2px(context, 15.0f);

        mLeftTextView.setTextColor(context.getResources().getColor(android.R.color.black));

        mLeftTextView.setSingleLine(true);

        this.addView(mLeftTextView, rightTextViewLayoutParams);
        this.addView(middleTextView, middleTextViewLayoutParams);

        this.setBackgroundColor(context.getResources().getColor(android.R.color.white));
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setGravity(Gravity.CENTER_VERTICAL);
    }

    protected void initView(Context context, @Nullable AttributeSet attrs) {
        initView(context);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OptionItemBase);
        mLeftTextView.setText(typedArray.getText(R.styleable.OptionItemBase_leftText));
        typedArray.recycle();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    protected int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public TextView getLeftTextView() {
        return mLeftTextView;
    }

    public String getLeftText() {
        return getLeftTextView().getText().toString();
    }

    public void setLeftText(CharSequence text) {
        getLeftTextView().setText(text);
    }

    public void setLeftText(@StringRes int resid) {
        getLeftTextView().setText(resid);
    }

}
