package com.yinwq.chunting.thread.t1;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/4 15:10
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("运行结束");
    }
}
