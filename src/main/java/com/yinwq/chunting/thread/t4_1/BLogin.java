package com.yinwq.chunting.thread.t4_1;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/7/11 19:52
 */
public class BLogin extends Thread {

    @Override
    public void run() {
        LoginServlet.doPost("b","bb");
    }
}
