package com.yinwq.chunting.thread.t3;

import com.yinwq.chunting.thread.t2.MyRunnable;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/4 16:22
 */
public class Run {
    public static void main(String[] args) {
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();
    }
}
