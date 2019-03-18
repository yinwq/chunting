package com.yinwq.chunting.study.jdk1_8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2019/1/25 14:57
 */
public class lambda {

    public static void main(String[] args) {

        test1();
        testLamda1();
        testLamda2();

    }
    public static void test1() {
        List<String> list = Arrays.asList("aaa", "fsa", "ser", "eere");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for (String string : list) {
            System.out.println(string);
        }
    }

    //这是带参数类型的Lambda的写法
    public static void testLamda1() {
        List<String> list = Arrays.asList("aaa", "fsa", "ser", "eere");
        Collections.sort(list, (Comparator<? super String>) (String a, String b) -> {
                    return b.compareTo(a);
                }
        );
        for (String string : list) {
            System.out.println(string);
        }
    }

    //这是不带参数的lambda的写法
    public static void testLamda2() {
        List<String> list = Arrays.asList("aaa", "fsa", "ser", "eere");
        Collections.sort(list, (a, b) -> b.compareTo(a)
        );
        for (String string : list) {
            System.out.println(string);
        }
    }
}
