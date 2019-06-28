package com.liuhao.cr;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;

import com.liuhao.cr.base.BaseActivity;
import com.liuhao.cr.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
//        testFor();
        testForeach();
//        testMap();
    }


    public void result() {
        initList();
        System.out.println("������foreach������List");

        Iterator localIterator1 = list.iterator();
        Iterator localIterator2 = list.iterator();
        String str;
        while (localIterator2.hasNext()) {
            localIterator2.next();
            str = (String) localIterator1.next();
            localIterator1.remove();
            System.out.println(str);
        }


        localIterator1 = list.iterator();
        localIterator2 = list.iterator();
        while (localIterator2.hasNext()) {
            str = (String) localIterator1.next();
            localIterator1.remove();
            System.out.println(str);
        }

    }


    /**
     * 测试foreach
     */
    public static void testForeach() {
        initList();
        System.out.println("使用foreach遍历List");

        Iterator<String> iterator1 = list.iterator();

        for (Object item : list) {
            String next = iterator1.next();
            iterator1.remove();
            System.out.println(next);
        }


        Iterator<String> iterator2 = list.iterator();
        Iterator iterator3 = list.iterator();
        while (iterator3.hasNext()) {
            String next = iterator2.next();
            iterator2.remove();
            System.out.println(next);
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

    public static void testMap() {
        Map map = new HashMap();
        Set keySet = map.keySet();
        Iterator keySetIterator = keySet.iterator();

        Collection values = map.values();
        Iterator valuesIterator = values.iterator();

        Set entrySet = map.entrySet();
        Iterator entrySetIterator = entrySet.iterator();
    }

    /////////////////////////////////////////////

    public static void initList() {
        list.clear();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
    }

}
