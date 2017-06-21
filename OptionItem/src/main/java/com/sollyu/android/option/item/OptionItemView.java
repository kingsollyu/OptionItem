package com.sollyu.android.option.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 作者：Sollyu
 * 日期：2017/6/21
 * 说明：
 */

public class OptionItemView extends LinearLayout {

    private TextView rightTextView = null;
    private TextView leftTextView = null;
    private TextView middleTextView = null;

    public OptionItemView(Context context) {
        super(context);
        initView(context);
    }

    public OptionItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context) {
        rightTextView  = new TextView(context);
        leftTextView   = new TextView(context);
        middleTextView = new TextView(context);

        LayoutParams rightTextViewLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightTextViewLayoutParams.leftMargin = dip2px(context, 15.0f);

        LayoutParams middleTextViewLayoutParams = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
        middleTextViewLayoutParams.leftMargin = dip2px(context, 15.0f);

        LayoutParams leftTextViewLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftTextViewLayoutParams.rightMargin = dip2px(context, 15.0f);

        rightTextView.setTextColor(context.getResources().getColor(android.R.color.black));
        leftTextView.setTextColor(context.getResources().getColor(android.R.color.darker_gray));

        rightTextView.setSingleLine(true);
        leftTextView.setSingleLine(true);
        leftTextView.setSelected(true);
        leftTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);

        this.addView(rightTextView , rightTextViewLayoutParams);
        this.addView(middleTextView, middleTextViewLayoutParams);
        this.addView(leftTextView  , leftTextViewLayoutParams);

        this.setBackgroundColor(context.getResources().getColor(android.R.color.white));
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setGravity(Gravity.CENTER_VERTICAL);
        this.setClickable(true);
    }

    private void initView(Context context, @Nullable AttributeSet attrs) {
        initView(context);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OptionItemView);
        rightTextView.setText(typedArray.getText(R.styleable.OptionItemView_rightText));
        leftTextView.setText(typedArray.getText(R.styleable.OptionItemView_leftText));
        typedArray.recycle();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    private int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public TextView getLeftTextView() {
        return leftTextView;
    }

    public TextView getRightTextView() {
        return rightTextView;
    }

    public String getLeftText() {
        return getLeftTextView().getText().toString();
    }

    public String getRightText() {
        return getRightTextView().getText().toString();
    }

    public void setLeftText(CharSequence text) {
        getLeftTextView().setText(text);
    }

    public void setLeftText(@StringRes int resid) {
        getLeftTextView().setText(resid);
    }

    public void setRightText(CharSequence text) {
        getRightTextView().setText(text);
    }

    public void setRightText(@StringRes int resid) {
        getRightTextView().setText(resid);
    }
}
