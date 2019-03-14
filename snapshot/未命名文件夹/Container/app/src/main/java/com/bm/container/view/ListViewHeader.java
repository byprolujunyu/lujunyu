/*
 * Copyright (C) 2012 www.amsoft.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bm.container.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bm.container.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * © 2012 amsoft.cn
 * 名称：ListViewHeader.java
 * 描述：下拉刷新的Header View类.
 *
 * @author 还如一梦中
 * @version v1.0
 * @date：2013-01-17 下午11:52:13
 */
public class ListViewHeader extends LinearLayout {

    /**
     * 上下文.
     */
    private Context mContext;

    /**
     * 主View.
     */
    private LinearLayout headerView;


    /**
     * 文本提示的View.
     */
    private TextView tipsTextview;


    /**
     * 当前状态.
     */
    private int mState = -1;

    /**
     * 向上的动画.
     */
    private Animation mRotateUpAnim;

    /**
     * 向下的动画.
     */
    private Animation mRotateDownAnim;

    /**
     * 动画时间.
     */
    private final int ROTATE_ANIM_DURATION = 180;

    /**
     * 显示 下拉刷新.
     */
    public final static int STATE_NORMAL = 0;

    /**
     * 显示 松开刷新.
     */
    public final static int STATE_READY = 1;

    /**
     * 显示 正在刷新....
     */
    public final static int STATE_REFRESHING = 2;

    /**
     * 保存上一次的刷新时间.
     */
    private String lastRefreshTime = null;

    /**
     * Header的高度.
     */
    private int headerHeight;

    /**
     * 初始化Header.
     *
     * @param context the context
     */
    public ListViewHeader(Context context) {
        super(context);
        initView(context);
    }

    /**
     * 初始化Header.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public ListViewHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    /**
     * 初始化View.
     *
     * @param context the context
     */
    private void initView(Context context) {

        mContext = context;

        //顶部刷新栏整体内容
        headerView = new LinearLayout(context);
        headerView.setOrientation(LinearLayout.HORIZONTAL);
        headerView.setGravity(Gravity.CENTER);

        ViewUtil.setPadding(headerView, 0, 10, 0, 10);

        LayoutParams layoutParamsWW = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParamsWW.gravity = Gravity.CENTER;
        layoutParamsWW.width = ViewUtil.scaleValue(mContext, 50);
        layoutParamsWW.height = ViewUtil.scaleValue(mContext, 50);

        //顶部刷新栏文本内容
        LinearLayout headTextLayout = new LinearLayout(context);
        tipsTextview = new TextView(context);
        headTextLayout.setOrientation(LinearLayout.VERTICAL);
        headTextLayout.setGravity(Gravity.CENTER_VERTICAL);
        ViewUtil.setPadding(headTextLayout, 0, 0, 0, 0);
        LayoutParams layoutParamsWW2 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        headTextLayout.addView(tipsTextview, layoutParamsWW2);
        tipsTextview.setTextColor(Color.rgb(107, 107, 107));
        ViewUtil.setTextSize(tipsTextview, 20);

        LayoutParams layoutParamsWW3 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParamsWW3.gravity = Gravity.CENTER;
        layoutParamsWW3.rightMargin = ViewUtil.scaleValue(mContext, 10);

        LinearLayout headerLayout = new LinearLayout(context);
        headerLayout.setOrientation(LinearLayout.HORIZONTAL);
        headerLayout.setGravity(Gravity.CENTER);

        headerLayout.addView(headTextLayout, layoutParamsWW3);

        LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.BOTTOM;
        //添加大布局
        headerView.addView(headerLayout, lp);

        this.addView(headerView, lp);
        //获取View的高度
        ViewUtil.measureView(this);
        headerHeight = this.getMeasuredHeight();

        mRotateUpAnim = new RotateAnimation(0.0f, -180.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        mRotateUpAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateUpAnim.setFillAfter(true);
        mRotateDownAnim = new RotateAnimation(-180.0f, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        mRotateDownAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateDownAnim.setFillAfter(true);

        setState(STATE_NORMAL);
    }

    /**
     * 设置状态.
     *
     * @param state the new state
     */
    public void setState(int state) {
        if (state == mState) return;

        switch (state) {
            case STATE_NORMAL:

                tipsTextview.setText(R.string.purchase_up);

                break;
            case STATE_READY:
                if (mState != STATE_READY) {
                    tipsTextview.setText(R.string.purchase_up);
                    lastRefreshTime = getCurrentDate(dateFormatHMS);

                }
                break;
            case STATE_REFRESHING:
                tipsTextview.setText(R.string.purchase_up);
                break;
            default:
        }

        mState = state;
    }

    /**
     * 设置header可见的高度.
     *
     * @param height the new visiable height
     */
    public void setVisiableHeight(int height) {
        if (height < 0) height = 0;
        LayoutParams lp = (LayoutParams) headerView.getLayoutParams();
        lp.height = height;
        headerView.setLayoutParams(lp);
    }

    /**
     * 获取header可见的高度.
     *
     * @return the visiable height
     */
    public int getVisiableHeight() {
        LayoutParams lp = (LayoutParams) headerView.getLayoutParams();
        return lp.height;
    }

    /**
     * 描述：获取HeaderView.
     *
     * @return the header view
     */
    public LinearLayout getHeaderView() {
        return headerView;
    }

    /**
     * 获取header的高度.
     *
     * @return 高度
     */
    public int getHeaderHeight() {
        return headerHeight;
    }

    /**
     * 描述：设置字体颜色.
     *
     * @param color the new text color
     */
    public void setTextColor(int color) {
        tipsTextview.setTextColor(color);
    }

    /**
     * 描述：设置背景颜色.
     *
     * @param color the new background color
     */
    public void setBackgroundColor(int color) {
        headerView.setBackgroundColor(color);
    }

    /**
     * 描述：得到当前状态.
     *
     * @return the state
     */
    public int getState() {
        return mState;
    }

    /**
     * 设置提示状态文字的大小.
     *
     * @param size the new state text size
     */
    public void setStateTextSize(int size) {
        tipsTextview.setTextSize(size);
    }

    /**
     * 时分秒.
     */
    private final String dateFormatHMS = "HH:mm:ss";

    /**
     * 描述：获取表示当前日期时间的字符串.
     *
     * @param format 格式化字符串，如："yyyy-MM-dd HH:mm:ss"
     * @return String String类型的当前日期时间
     */
    private String getCurrentDate(String format) {

        String curDateTime = null;
        try {
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
            Calendar c = new GregorianCalendar();
            curDateTime = mSimpleDateFormat.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return curDateTime;

    }

}
