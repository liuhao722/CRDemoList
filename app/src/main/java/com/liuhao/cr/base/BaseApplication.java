package com.liuhao.cr.base;

import android.app.Application;

import com.liuhao.cr.BuildConfig;

import module.liuhao.common.preference.Share;

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    2018/12/29 --> 下午4:47
 * Description: BaseApplication 简述：
 */
public class BaseApplication extends Application {
    private static final String TAG = "BaseApplication";
    public boolean isRelease = false;          //  true==正式环境,false==测试环境
    private static BaseApplication mInstance;

    int ENV_PRODUCT = 1;                                                                            //  正式环境
    int ENV_TEST = 2;                                                                               //  测试环境

    public static synchronized BaseApplication ins() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initModel();                            //  初始化当前的模式 是debug还是release
        Share.init(this);
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
