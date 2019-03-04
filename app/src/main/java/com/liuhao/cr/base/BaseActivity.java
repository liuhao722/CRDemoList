package com.liuhao.cr.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import module.liuhao.common.helper.FastClickHelper;

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    2018/12/29 --> 下午2:44
 * Description: BaseActivity 简述：基类Activity
 */
public class BaseActivity<X extends ViewDataBinding> extends AppCompatActivity implements View.OnClickListener {
    protected final String TAG = this.getClass().getSimpleName();
    protected X binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        beforeBinding();
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, setLayoutId());
        afterBinding();
        initView();
        initListener();
        initLocalCacheData();
        requestData();
    }

    /**
     * 在binding之前
     */
    protected void beforeBinding() {
    }

    /**
     * 设置activity的LayoutId
     */
    protected int setLayoutId() {
        return 0;
    }

    /**
     * binding完数据
     */
    protected void afterBinding() {
    }

    /**
     * 初始化View的一些状态
     */
    protected void initView() {
    }

    /**
     * 设置监听器
     */
    protected void initListener() {
    }

    /**
     * 手动添加点击事件
     */
    protected void setClickView(View view) {
        view.setOnClickListener(this);
    }

    /**
     * 初始化本地数据进行展示数据
     */
    protected void initLocalCacheData() {
    }

    /**
     * 请求远程数据
     */
    protected void requestData() {

    }


    @Override
    public void onClick(View v) {
        if (FastClickHelper.doubleClick() || v == null) return;
        normalClick(v);
    }

    /**
     * 点击事件重写该方法
     */
    protected void normalClick(View view) {

    }
}
