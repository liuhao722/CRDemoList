package com.liuhao.cr;

import android.support.v4.app.Fragment;
import android.view.View;

import androidx.navigation.fragment.NavHostFragment;

import com.liuhao.cr.base.BaseActivity;
import com.liuhao.cr.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {
        setClickView(binding.rlRoot);

        // 3D旋转效果
        binding.scalpel.setLayerInteractionEnabled(true);               //  配置是否开启3d效果
        binding.scalpel.setDrawViews(true);                             //  配置是否绘制真实的View, 如果为false则仅绘制布局线框图
        binding.scalpel.setDrawIds(true);                               //  配置是否在界面上显示控件的Id.
        binding.scalpel.setChromeColor(R.color.colorAccent);            //
        binding.scalpel.setChromeShadowColor(R.color.colorPrimary);     //  配置线框图颜色

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
