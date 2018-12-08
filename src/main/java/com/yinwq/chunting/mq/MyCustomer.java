package com.yinwq.chunting.mq;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/12/6 18:48
 */
public class MyCustomer extends EndPoint {
    public MyCustomer(String endpointName) throws Exception {
        super(endpointName);
    }

    public void receiveMessage() throws Exception {

        //声明要关注的队列
        channel.queueDeclare(endPointName, false, false, false, null);
        System.out.println("Customer Waiting Received messages");

        // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException
            {
                String message = new String(body, "UTF-8");
                System.out.println("Customer Received '" + message + "'");
            }
        };
        //自动回复队列应答 -- RabbitMQ中的消息确认机制
        channel.basicConsume(endPointName, true, consumer);
    }

}
