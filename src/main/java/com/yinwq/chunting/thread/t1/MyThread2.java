package com.yinwq.chunting.thread.t1;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/4 15:13
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0 ; i < 10; i++){
            try {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run=" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
