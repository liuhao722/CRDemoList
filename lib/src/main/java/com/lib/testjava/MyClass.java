package com.lib.testjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MyClass {
    public static void main(String[] args) {
        test();
    }

    static HashMap map = new HashMap<>();

    static ArrayList<String> list = new ArrayList<>();
    static ConcurrentLinkedDeque<String> concurrentLinkedDeque = new ConcurrentLinkedDeque();

    public static void test() {
        testFor();
        testForeach();
        testConcurrentLinkedDequeForeach();
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

    /**
     * 测试foreach
     */
    public static void testForeach() {
        initList();
        System.out.println("使用foreach遍历List");
        for (String item : list) {
            System.out.println(item);
            if (item.equals("B")) {
                list.remove(item);  //  错误的移除方式
                list.add(item);     //  错误的添加方式
            }
        }
    }

    /**
     * 测试安全的foreach
     */
    public static void testConcurrentLinkedDequeForeach() {
        initList();
        System.out.println("使用foreach遍历List");
        for (String item : concurrentLinkedDeque) {
            System.out.println(item);
            if (item.equals("B")) {
                concurrentLinkedDeque.remove(item);
            }
        }
    }

    //////////////////////反编译后~for和增强for循环这个语法糖进行解糖结果--start///////////////////////
    public static void testForRealCode() {
        initList();
        System.out.println("������for������������List");
        int i = 0;
        while (i < list.size()) {
            System.out.println((String) list.get(i));
            if (((String) list.get(i)).equals("B")) {
                list.remove(i);
            }
            i += 1;
        }
    }

    public static void testForeachRealCode() {
        initList();
        System.out.println("������foreach������List");
        Iterator localIterator = list.iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            System.out.println(str);
            if (str.equals("B")) {
                list.remove(str);
            }
        }
    }

    //////////////////////反编译后~for和增强for循环这个语法糖进行解糖结果--end///////////////////////

    public static void initList() {
        concurrentLinkedDeque.clear();
        concurrentLinkedDeque.add("A");
        concurrentLinkedDeque.add("B");
        concurrentLinkedDeque.add("C");
        concurrentLinkedDeque.add("D");

        list.clear();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
    }
}
