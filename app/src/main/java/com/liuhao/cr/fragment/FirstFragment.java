package com.liuhao.cr.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuhao.cr.R;

import androidx.navigation.Navigation;

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    2019/3/6 --> 4:29 PM
 * Description: FirstFragment 简述：
 */
public class FirstFragment extends Fragment {
    private View viewRoot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (viewRoot == null) {
            viewRoot = inflater.inflate(R.layout.fragment_first, container, false);
        }
        viewRoot.findViewById(R.id.btn_first).setOnClickListener(
                v -> {
                    //  携带参数跳转
                    FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
                    action.setName("刘浩");
                    Navigation.findNavController(v).navigate(action);

                    //  普通跳转
//                    NavHostFragment.findNavController(FirstFragment.this)
//                            .navigate(R.id.action_firstFragment_to_secondFragment);
                }
        );
        return viewRoot;
    }

}
