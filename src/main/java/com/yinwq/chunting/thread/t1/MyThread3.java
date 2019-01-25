package com.yinwq.chunting.thread.t1;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/4 11:45
 */
public class MyThread3 extends Thread  {
    private int i;

    public MyThread3(int i) {
        super();
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}
