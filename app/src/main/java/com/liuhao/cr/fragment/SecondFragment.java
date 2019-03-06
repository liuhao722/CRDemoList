package com.liuhao.cr.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.liuhao.cr.R;

import androidx.navigation.fragment.NavHostFragment;

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    2019/3/6 --> 4:29 PM
 * Description: FirstFragment 简述：
 */
public class SecondFragment extends Fragment {
    private View viewRoot;
    private Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (viewRoot == null) {
            viewRoot = inflater.inflate(R.layout.fragment_second, container, false);
        }
        String name = SecondFragmentArgs.fromBundle(getArguments()).getName();
        btn = viewRoot.findViewById(R.id.btn_second);
        btn.setText(btn.getText().toString() + ":--->" + name);
        viewRoot.findViewById(R.id.btn_second).setOnClickListener(
                v -> NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_secondFragment_to_firstFragment)
        );
        return viewRoot;
    }
}
