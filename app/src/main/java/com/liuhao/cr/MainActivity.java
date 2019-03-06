package com.liuhao.cr;

import android.support.v4.app.Fragment;
import android.view.View;

import com.liuhao.cr.base.BaseActivity;
import com.liuhao.cr.databinding.ActivityMainBinding;

import androidx.navigation.fragment.NavHostFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {
        setClickView(binding.rlRoot);
    }

    @Override
    protected void normalClick(View view) {
        switch (view.getId()) {
            case R.id.rl_root:
                break;
        }
    }

    //重写onSupportNavigateUp（）方法，目的是将back事件委托出去。若栈中有两个以上Fragment，点击back键就会返回到上一个Fragment。
    @Override
    public boolean onSupportNavigateUp() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.nav_fragment);
        return NavHostFragment.findNavController(fragment).navigateUp();
    }
}
