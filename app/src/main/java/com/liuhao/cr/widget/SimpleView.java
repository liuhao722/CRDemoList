package com.liuhao.cr.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    2019/3/4 --> 4:06 PM
 * Description: SimpleView 简述：
 */
public class SimpleView extends View {
    public SimpleView(Context context) {
        this(context, null);
    }

    public SimpleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //MinSDK=21
//    public SimpleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
