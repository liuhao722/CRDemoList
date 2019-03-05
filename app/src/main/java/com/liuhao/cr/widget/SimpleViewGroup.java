package com.liuhao.cr.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.liuhao.cr.R;

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    2019/3/4 --> 4:19 PM
 * Description: SimpleViewGroup 简述：
 */
public class SimpleViewGroup extends ViewGroup {
    private int count, gravity, textColor;
    private boolean showText;
    private float textSize;
    private Drawable src;

    public SimpleViewGroup(Context context) {
        this(context, null);
    }

    public SimpleViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.MyCustomView);
        if (ta == null) return;
        showText = ta.getBoolean(R.styleable.MyCustomView_showText, false);
        textColor = ta.getColor(R.styleable.MyCustomView_textColor, getResources().getColor(R.color.colorAccent));
        textSize = ta.getDimension(R.styleable.MyCustomView_textSize, 15);
        count = ta.getInt(R.styleable.MyCustomView_count, 0);
        gravity = ta.getInt(R.styleable.MyCustomView_gravity, 0);
        src = ta.getDrawable(R.styleable.MyCustomView_src);
        //。。。
        ta.recycle();
    }

//    public SimpleViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMeasureModeSize = MeasureSpec.makeMeasureSpec(widthSize, mode);

    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
