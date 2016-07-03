package com.example.sh.ghgank.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by sh on 2016/6/6.
 */
public class UnScrolledViewPager extends ViewPager{

    public UnScrolledViewPager(Context context) {
        super(context);
    }

    public UnScrolledViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    //    //禁用滑动事件

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    //必须要写这个方法，这个方法可以保证子控件不受onTOuchEvent的禁用影响
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
