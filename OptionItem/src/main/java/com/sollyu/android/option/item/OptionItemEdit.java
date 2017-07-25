package com.sollyu.android.option.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * 作者：Sollyu
 * 日期：2017/7/25
 * 说明：
 */
public class OptionItemEdit extends OptionItemBase {

    private AppCompatEditText mRightEditText = null;

    public OptionItemEdit(Context context) {
        super(context);
        initView(context);
    }

    public OptionItemEdit(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    @Override
    protected void initView(Context context) {
        super.initView(context);
        mRightEditText = new AppCompatEditText(context);
        mRightEditText.setTextAppearance(context, android.R.style.TextAppearance_DeviceDefault_Small);

        LayoutParams rightTextViewLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightTextViewLayoutParams.rightMargin = dip2px(context, 15.0f);

        this.addView(mRightEditText, rightTextViewLayoutParams);
    }

    @Override
    protected void initView(Context context, @Nullable AttributeSet attrs) {
        super.initView(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OptionItemEdit);
        mRightEditText.setText(typedArray.getText(R.styleable.OptionItemEdit_rightText));
        mRightEditText.setHint(typedArray.getText(R.styleable.OptionItemEdit_hintText));
        typedArray.recycle();
    }

    public EditText getRightEdit() {
        return mRightEditText;
    }

    public CharSequence getRightEditText() {
        return getRightEdit().getText();
    }

    public void setRightEditText(CharSequence text) {
        getRightEdit().setText(text);
    }

    public void setRightEditText(@StringRes int resid) {
        getRightEdit().setText(resid);
    }

    public void setRightEditHint(CharSequence hint) {
        getRightEdit().setHint(hint);
    }

    public void setRightEditHint(@StringRes int resid) {
        getRightEdit().setHint(resid);
    }
}
