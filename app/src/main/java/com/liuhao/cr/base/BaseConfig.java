package com.liuhao.cr.base;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/**
 * 配置类
 * Created by hao on 2016/5/9.
 */
public class BaseConfig {
    private volatile static BaseConfig instance;

    public static BaseConfig ins(Context context) {
        if (instance == null) {
            synchronized (BaseConfig.class) {
                if (instance == null) {
                    instance = new BaseConfig();
                }
            }
        }
        return instance;
    }


    //获取当前屏幕宽度
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    //获取当前手机的高度
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 针对9.0以后的手机出现刘海屏还有部分手机底部虚拟键盘，导致获取的尺寸不准确的问题进行修改
     */
    public static int getRealScreenHeight(Context context) {
        return getPoint(context).y;
    }

    public static int getRealScreenWidth(Context context) {
        return getPoint(context).x;
    }

    static Point getPoint(Context context) {
        WindowManager windowManager =
                (WindowManager) context.getSystemService(Context.
                        WINDOW_SERVICE);
        final Display display = windowManager.getDefaultDisplay();
        Point outPoint = new Point();
        if (Build.VERSION.SDK_INT >= 19) {
            // 可能有虚拟按键的情况
            display.getRealSize(outPoint);
        } else {
            // 不可能有虚拟按键
            display.getSize(outPoint);
        }
        return outPoint;
    }

    //获取当前手机的像素密度
    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }
}