package com.liuhao.cr;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;

import com.liuhao.cr.base.BaseActivity;
import com.liuhao.cr.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

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

    static List<String> list = new ArrayList<>();

    public static void test() {
        testFor();
        testForeach();
    }

    /**
     * 测试foreach
     */
    public static void testForeach() {
        initList();
        System.out.println("使用foreach遍历List");
        for (String item : list) {
            System.out.println(item);
            if (item.equals("B")) {
                list.remove(item);
            }
        }
    }

    public static void testFor() {
        initList();
        System.out.println("使用for循环遍历List");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if (list.get(i).equals("B")) {
                list.remove(i);
            }
        }
    }

    /////////////////////////////////////////////

    public static void initList() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
    }
}
