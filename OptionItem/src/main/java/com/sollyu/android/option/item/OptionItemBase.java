/*
 * Copyright 2017 Sollyu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sollyu.android.option.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * author: sollyu
 * time  : 2017/6/21
 * mail  : sollyu@qq.com
 */
class OptionItemBase extends LinearLayout {
    private TextView mLeftTextView = null;
    private CheckBox mLeftCheckBox = null;

    public OptionItemBase(Context context) {
        super(context);
    }

    public OptionItemBase(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    protected void initView(Context context) {
        mLeftTextView = new TextView(context);
        mLeftCheckBox = new CheckBox(context);

        TextView middleTextView = new TextView(context);

        LayoutParams rightTextViewLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightTextViewLayoutParams.leftMargin = dip2px(context, 15.0f);

        LayoutParams middleTextViewLayoutParams = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
        middleTextViewLayoutParams.leftMargin = dip2px(context, 15.0f);

        middleTextView.setClickable(false);
        mLeftTextView.setTextColor(context.getResources().getColor(android.R.color.black));
        mLeftTextView.setClickable(false);
        mLeftTextView.setSingleLine(true);
        mLeftCheckBox.setVisibility(GONE);

        this.addView(mLeftCheckBox, rightTextViewLayoutParams);
        this.addView(mLeftTextView, rightTextViewLayoutParams);
        this.addView(middleTextView, middleTextViewLayoutParams);

        this.setBackgroundColor(context.getResources().getColor(android.R.color.white));
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setGravity(Gravity.CENTER_VERTICAL);
        this.setBackgroundResource(R.drawable.option_item_selector_background);
    }

    protected void initView(Context context, @Nullable AttributeSet attrs) {
        initView(context);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OptionItemBase);
        mLeftTextView.setText(typedArray.getText(R.styleable.OptionItemBase_leftText));
        mLeftCheckBox.setChecked(typedArray.getBoolean(R.styleable.OptionItemBase_leftCheck, false));
        if (mLeftCheckBox.isChecked()) mLeftCheckBox.setVisibility(VISIBLE);
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

    public CheckBox getLeftCheckBox() {
        return mLeftCheckBox;
    }

    public boolean isChecked() {
        return mLeftCheckBox.isChecked();
    }

    public void setChecked(boolean checked) {
        mLeftCheckBox.setChecked(checked);
    }
}
