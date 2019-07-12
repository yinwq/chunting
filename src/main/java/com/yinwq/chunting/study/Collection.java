package com.yinwq.chunting.study;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2019/5/5 17:07
 */
public class Collection {

    public static void main(String[] args) {
        queue();

        stack();

        collection();
    }

    private static void collection() {
        HashSet<Integer> integerHashSet = new HashSet<>();
        integerHashSet.add(12121);//添加
        integerHashSet.contains(121);//是否包含
        integerHashSet.size();//集合大小
        integerHashSet.isEmpty();//是否为空
    }

    private static void stack() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(12);//尾部入栈
        stack.push(16);//尾部入栈
        //int tail = stack.pop();//尾部出栈，并删除该元素
        int tail = stack.peek();//尾部出栈，不删除该元素
    }

    private static void queue() {
        Deque<Integer> integerDeque = new LinkedList<>();
        // 尾部入队，区别在于如果失败了
        // add方法会抛出一个IllegalStateException异常，而offer方法返回false
        integerDeque.offer(122);
        integerDeque.add(123);
        // 头部出队,区别在于如果失败了
        // remove方法抛出一个NoSuchElementException异常，而poll方法返回false
        //int head = integerDeque.poll();//返回第一个元素，并在队列中删除
        //head = integerDeque.remove();//返回第一个元素，并在队列中删除
        // 头部出队，区别在于如果失败了
        // element方法抛出一个NoSuchElementException异常，而peek方法返回null。
        int head = integerDeque.peek();//返回第一个元素，不删除
        head = integerDeque.element();//返回第一个元素，不删除
    }
}
