package com.yinwq.chunting.thread.t4;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/4 18:56
 */
public class MyThread extends Thread {

    private int count = 5;

    @Override
    public synchronized void run() {
        super.run();
        while (count > 0){
            count--;
            System.out.println("由" + this.currentThread().getName() + "计算. count=" + count);
        }
    }
}
