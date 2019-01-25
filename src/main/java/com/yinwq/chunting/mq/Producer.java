package com.yinwq.chunting.mq;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/12/6 17:01
 */
public class Producer extends EndPoint {

    public Producer(String routingKey) throws Exception {
        super(routingKey);
    }

    public void sendMessage(String object) throws Exception {
        channel.basicPublish("quote", routingKey, null, object.getBytes("UTF-8"));
    }
}
