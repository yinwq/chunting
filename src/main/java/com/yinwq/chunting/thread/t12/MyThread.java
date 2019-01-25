package com.yinwq.chunting.thread.t12;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/18 11:46
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0 ; i < 5000 ; i++){
            System.out.println("i=" + (i + 1));
        }
    }
}
