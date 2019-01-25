package com.yinwq.chunting.thread.t6;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/17 14:58
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        //myThread.run();
    }
}
