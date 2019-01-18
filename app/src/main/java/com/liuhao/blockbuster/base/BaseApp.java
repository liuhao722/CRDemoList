package com.liuhao.blockbuster.base;

import android.app.Application;

import com.liuhao.blockbuster.BuildConfig;

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    2018/12/29 --> 下午4:47
 * Description: BaseApp 简述：
 */
public class BaseApp extends Application {
    private static final String TAG = "BaseApp";
    public boolean isRelease = false;          //  true==正式环境,false==测试环境
    private static BaseApp mInstance;

    int ENV_PRODUCT = 1;                                                                            //  正式环境
    int ENV_TEST = 2;                                                                               //  测试环境

    public static synchronized BaseApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initModel();                            //  初始化当前的模式 是debug还是release
    }

    /**
     * 初始化model--测试还是正式环境
     */
    public void initModel() {
        int env = BuildConfig.SERVER_HOST;
        if (env == ENV_PRODUCT) {
            isRelease = true;
        } else if (env == ENV_TEST) {
            isRelease = false;
        }
    }
}
