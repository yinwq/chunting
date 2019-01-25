package com.yinwq.chunting.thread.t2;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/4 16:22
 */
public class Run {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束。。。");
    }
}
