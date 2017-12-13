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

        if (typedArray.getResourceId(R.styleable.OptionItemView_rightStyle, 0) != 0) {
            mRightTextView.setTextAppearance(context, typedArray.getResourceId(R.styleable.OptionItemView_rightStyle, 0));
        }

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
