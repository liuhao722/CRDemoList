package com.liuhao.cr.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.liuhao.cr.R;

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    2019/3/5 --> 4:06 PM
 * Description: SimpleView 简述：
 */
public class SimpleView extends View {
    private int count, gravity, textColor;
    private boolean showText;
    private float textSize;
    private Drawable src;

    private Paint paint = new Paint();

    public SimpleView(Context context) {
        this(context, null);
    }

    public SimpleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    //min API level=21
//    public SimpleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    private void init(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.MyCustomView);
        if (ta != null) {
            showText = ta.getBoolean(R.styleable.MyCustomView_showText, false);
            textColor = ta.getColor(R.styleable.MyCustomView_textColor, getResources().getColor(R.color.colorAccent));
            textSize = ta.getDimension(R.styleable.MyCustomView_textSize, 15);
            count = ta.getInt(R.styleable.MyCustomView_count, 0);
            gravity = ta.getInt(R.styleable.MyCustomView_gravity, 0);
            src = ta.getDrawable(R.styleable.MyCustomView_src);
            //。。。
            ta.recycle();
        }

        initPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = MeasureSpec.getMode(widthMeasureSpec);               //  获取控件的测量模式
        int realWidthSize = MeasureSpec.getSize(widthMeasureSpec);      //  获取控件的实际尺寸
        int realHeightSize = MeasureSpec.getSize(widthMeasureSpec);

        setMeasuredDimension(realWidthSize, realHeightSize);            //  设置测量完成的尺寸

        //  根据mode 和实际测量的尺寸获取模式尺寸
        int widthMeasureSpecSize = MeasureSpec.makeMeasureSpec(realWidthSize, mode);
        int heightMeasureSpecSize = MeasureSpec.makeMeasureSpec(realHeightSize, mode);

    }

//    @Override
//    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//        super.onLayout(changed, left, top, right, bottom);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawBitmap();
//        canvas.drawPath();
//        canvas.drawArc();
//        canvas.drawARGB();
//        canvas.drawCircle();
//        ……
    }


    //滤镜过滤器
    BlurMaskFilter maskFilter = new BlurMaskFilter(0.1f, BlurMaskFilter.Blur.INNER);

    /**
     * 初始化paint；
     *
     * @setMaskFilter: MaskFilter类可以为Paint分配边缘效果。
     * 对MaskFilter的扩展可以对一个Paint边缘的alpha通道应用转换。
     * <p>
     * Android包含了下面几种MaskFilter：
     * BlurMaskFilter：      指定了一个模糊的样式和半径来处理Paint的边缘。
     * EmbossMaskFilter：    指定了光源的方向和环境光强度来添加浮雕效果。
     * <p>
     * 要应用一个MaskFilter，可以使用setMaskFilter方法，并传递给它一个MaskFilter对象。
     */
    private void initPaint() {
        paint.setStyle(Paint.Style.STROKE);//只绘制图形轮廓（描边）
        paint.setAntiAlias(true);//设置是否使用抗锯齿功能，会消耗较大资源，绘制图形速度会变慢。
        paint.setDither(true);//设定是否使用图像抖动处理，会使绘制出来的图片颜色更加平滑和饱满，图像更加清晰
        paint.setMaskFilter(maskFilter);//设置MaskFilter，可以用不同的MaskFilter实现滤镜的效果，如滤化，立体等
        paint.setColorFilter(null);////设置颜色过滤器，可以在绘制颜色时实现不用颜色的变换效果
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(textColor);
        paint.setTextSize(textSize);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
