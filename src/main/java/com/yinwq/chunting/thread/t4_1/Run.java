package com.yinwq.chunting.thread.t4_1;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/11 19:53
 */
public class Run {
    public static void main(String[] args) {
        ALogin a = new ALogin();
        a.start();
        BLogin b = new BLogin();
        b.start();
    }
}
