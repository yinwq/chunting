package com.yinwq.chunting.thread.t8;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/18 10:23
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("run threadName=" + this.currentThread().getName() + " begin " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("run threadName=" + this.currentThread().getName() + " end   " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
