package com.yinwq.chunting.designmode.proxy;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/9/10 17:25
 */
public class Proxy extends Subject {

    RealSubject realSubject;

    @Override
    public void Request() {
        if(realSubject == null){
            realSubject = new RealSubject();
        }
        realSubject.Request();
    }
}
