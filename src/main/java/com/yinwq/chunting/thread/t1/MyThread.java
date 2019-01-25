package com.yinwq.chunting.thread.t1;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/4 11:45
 */
public class MyThread extends Thread  {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }
}
