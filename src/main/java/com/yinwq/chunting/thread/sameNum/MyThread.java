package com.yinwq.chunting.thread.sameNum;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/17 14:34
 */
public class MyThread extends Thread {
    private  int i = 5;

    @Override
    public void run() {
        System.out.println("i=" + (i--) + " threadName=" + Thread.currentThread().getName());
    }
}
