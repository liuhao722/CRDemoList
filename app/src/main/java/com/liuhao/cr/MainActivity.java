package com.liuhao.cr;

import android.view.View;

import com.liuhao.cr.base.BaseActivity;
import com.liuhao.cr.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {
        setClickView(binding.tvContent);
    }

    @Override
    protected void normalClick(View view) {
        switch (view.getId()) {
            case R.id.tv_content:
                break;
        }
    }
}
