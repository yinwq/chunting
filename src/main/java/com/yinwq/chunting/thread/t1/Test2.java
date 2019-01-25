package com.yinwq.chunting.thread.t1;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/4 15:19
 */
public class Test2 {
    public static void main(String[] args) {
        MyThread3 myThread1 = new MyThread3(1);
        MyThread3 myThread2 = new MyThread3(2);
        MyThread3 myThread3 = new MyThread3(3);
        MyThread3 myThread4 = new MyThread3(4);
        MyThread3 myThread5 = new MyThread3(5);
        MyThread3 myThread6 = new MyThread3(6);
        MyThread3 myThread7 = new MyThread3(7);
        MyThread3 myThread8 = new MyThread3(8);
        MyThread3 myThread9 = new MyThread3(9);
        MyThread3 myThread10 = new MyThread3(10);
        MyThread3 myThread11 = new MyThread3(11);
        MyThread3 myThread12 = new MyThread3(12);
        MyThread3 myThread13 = new MyThread3(13);
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
        myThread6.start();
        myThread7.start();
        myThread8.start();
        myThread9.start();
        myThread10.start();
        myThread11.start();
        myThread12.start();
        myThread13.start();
    }
}