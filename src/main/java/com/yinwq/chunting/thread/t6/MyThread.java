package com.yinwq.chunting.thread.t6;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/17 14:34
 */
public class MyThread extends Thread {
    public MyThread() {
        System.out.println("构造方法打印：" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run 方法打印：" + Thread.currentThread().getName());
    }
}
