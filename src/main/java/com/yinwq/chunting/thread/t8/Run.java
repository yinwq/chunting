package com.yinwq.chunting.thread.t8;

import javax.xml.transform.Source;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/18 10:33
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("begin " + System.currentTimeMillis());
        myThread.run();
//        myThread.start();
        System.out.println("end   " + System.currentTimeMillis());

        Thread runThread = Thread.currentThread();
        System.out.println(runThread.getName() + " " + runThread.getId());


    }
}
