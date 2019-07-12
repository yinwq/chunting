package com.yinwq.chunting.study;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2019/5/17 16:51
 */
public class SortTest {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 4, 6, -1, 2);
        //升序
        list.sort(( Integer ord1, Integer ord2) -> ord1.compareTo(ord2));
        //降序
        //list.sort(( Integer ord1, Integer ord2) -> ord2.compareTo(ord1));
        System.err.println(list);

    }

    private static void add(int num) {
        num++;
    }

}
