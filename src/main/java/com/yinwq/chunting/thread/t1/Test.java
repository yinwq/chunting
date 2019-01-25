package com.yinwq.chunting.thread.t1;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/4 15:19
 */
public class Test {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        myThread2.setName("myThread");
        myThread2.start();
        for (int i = 0; i < 10; i++){
            try {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
