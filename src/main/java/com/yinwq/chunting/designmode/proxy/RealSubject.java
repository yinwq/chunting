package com.yinwq.chunting.designmode.proxy;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/9/10 17:16
 */
public class RealSubject extends Subject {
    @Override
    public void Request() {
        System.err.println("真实请求");
    }
}
