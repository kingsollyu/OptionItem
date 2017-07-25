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
    private OnClickListener onClickListener = null;

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

        if (onClickListener != null) {
            mRightSwitch.setOnClickListener(onClickListener);
        }

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

    public void setCheckedImmediatelyNoEvent(boolean checked) {
        getSwitch().setCheckedImmediatelyNoEvent(checked);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        onClickListener = l;
        if (getSwitch() != null) {
            getSwitch().setOnClickListener(l);
        }
    }
}
