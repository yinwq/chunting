package com.yinwq.chunting.thread.t7;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/17 14:34
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("run=" + this.isAlive());
    }
}
