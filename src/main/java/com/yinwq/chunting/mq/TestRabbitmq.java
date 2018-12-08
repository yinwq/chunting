package com.yinwq.chunting.mq;

import java.util.HashMap;

import com.alibaba.fastjson.JSON;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/12/6 17:06
 */
public class TestRabbitmq {
    public static void main(String[] args) {
        send();
        //receive();
    }

    private static void receive() {
        try {
            MyCustomer myCustomer = new MyCustomer("queue");
            myCustomer.receiveMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void send() {
        try{

            Producer producer = new Producer("queue");

            HashMap message = new HashMap();
            message.put("message content", "hello rabbitmq");
            producer.sendMessage(JSON.toJSONString(message));
            producer.close();
            System.out.println("message content "+ "hello rabbitmq" +" sent.");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
