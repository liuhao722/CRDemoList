package com.lib.testjava;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyClass {
    public static void main(String[] args) {
        test();
    }

    static HashMap map = new HashMap<>();

    static ArrayList list = new ArrayList<>();
    static ConcurrentLinkedDeque<String> concurrentLinkedDeque = new ConcurrentLinkedDeque();

    public static void test() {
//        testFor();
        testForeach();
//        testConcurrentLinkedDequeForeach();
//        testStream();
//        testIterator();
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

        Iterator<String> iterator1 = list.iterator();

//        for (Object item : list) {
//           String next =  iterator1.next();
//            iterator1.remove();
//            System.out.println(next);
////            System.out.println(item);
////            if (item.equals("B")) {
////                list.remove(item);
////            }
//        }


        Iterator<String> iterator2 = list.iterator();
        Iterator iterator3 = list.iterator();
        while (iterator3.hasNext()) {
            iterator3.next();
            String next = iterator2.next();
            iterator2.remove();
            System.out.println(next);
        }


//        System.out.println(list.toString() + "\t" + list.size());
//        while (iterator.hasNext()) {
//
//            System.out.println(next);
////            String str = (String) localIterator.next();
////            if (str.equals("B")) {
////                list.remove(str);
////            }
//        }


//
//        for (Object item : list) {
////            System.out.println(item);
//            if (item.equals("B")) {
//                list.remove(item);  //  错误的移除方式
////                list.add(item);     //  错误的添加方式
//            }
//        }
//        PrintStream out = System.out;
//        Consumer<String> fun2 = out::println;
//        fun2.accept("hello beijing");
    }


    public static void testStream() {
        initList();
        Stream<String> stream = list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("B");
            }
        });

        List<String> filterList = stream.collect(Collectors.<String>toList());

        for (int i = 0; i < filterList.size(); i++) {
            System.out.println(filterList.get(i));
        }
    }

    public static void testIterator() {
        initList();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("B")) {
                iterator.remove();
            }
//            System.out.println(item);
        }
        print(list);
        print(list.iterator());
    }

    public static void print(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    public static void print(Iterator<String> iterator) {
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
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
