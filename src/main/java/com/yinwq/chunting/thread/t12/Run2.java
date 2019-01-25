package com.yinwq.chunting.thread.t12;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/18 15:59
 */
public class Run2 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止 1? =" + Thread.interrupted());
        System.out.println("是否停止 2? =" + Thread.interrupted());
        System.out.println("end");
    }
}
