package com.yinwq.chunting.mq;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/12/6 17:01
 */
public class Producer extends EndPoint {

    public Producer(String endpointName) throws Exception {
        super(endpointName);
    }

    public void sendMessage(String object) throws Exception {
        channel.basicPublish("exchange_1", endPointName, null, object.getBytes("UTF-8"));
    }
}
