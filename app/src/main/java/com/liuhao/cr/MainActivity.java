package com.liuhao.cr;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;

import com.liuhao.cr.base.BaseActivity;
import com.liuhao.cr.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private ScrollView scrollView;
    private RecyclerView recyclerView;
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
