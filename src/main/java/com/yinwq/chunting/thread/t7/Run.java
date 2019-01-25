package com.yinwq.chunting.thread.t7;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/17 14:58
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("begin ==" + myThread.isAlive());
        myThread.start();
        System.out.println("end ==" + myThread.isAlive());
    }
}
