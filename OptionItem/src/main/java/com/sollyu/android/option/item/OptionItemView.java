package com.sollyu.android.option.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 作者：Sollyu
 * 日期：2017/6/21
 * 说明：
 */

public class OptionItemView extends OptionItemBase {

    private TextView mRightTextView = null;

    public OptionItemView(Context context) {
        super(context);
        initView(context);
    }

    public OptionItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    @Override
    protected void initView(Context context) {
        super.initView(context);

        mRightTextView = new TextView(context);
        LayoutParams leftTextViewLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftTextViewLayoutParams.rightMargin = dip2px(context, 15.0f);

        mRightTextView.setTextColor(context.getResources().getColor(android.R.color.darker_gray));

        mRightTextView.setSingleLine(true);
        mRightTextView.setSelected(true);
        mRightTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);

        this.addView(mRightTextView, leftTextViewLayoutParams);
    }

    @Override
    protected void initView(Context context, @Nullable AttributeSet attrs) {
        super.initView(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OptionItemView);
        mRightTextView.setText(typedArray.getText(R.styleable.OptionItemView_rightText));
        typedArray.recycle();
    }

    public TextView getRightTextView() {
        return mRightTextView;
    }

    public String getRightText() {
        return getRightTextView().getText().toString();
    }

    public void setRightText(CharSequence text) {
        getRightTextView().setText(text);
    }

    public void setRightText(@StringRes int resid) {
        getRightTextView().setText(resid);
    }
}
