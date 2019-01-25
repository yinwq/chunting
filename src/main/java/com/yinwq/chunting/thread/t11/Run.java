package com.yinwq.chunting.thread.t11;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/18 15:59
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(2000);
            myThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
