package com.yinwq.chunting.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/12/6 16:59
 */
public abstract class EndPoint {
    protected Channel channel;
    protected Connection connection;
    protected String endPointName;

    public EndPoint(String endpointName) throws Exception {

        this.endPointName = endpointName;

        //创建一个连接工厂 connection factory
        ConnectionFactory factory = new ConnectionFactory();

        //设置rabbitmq-server服务IP地址
        factory.setHost("172.30.221.119");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);
        factory.setVirtualHost("/");

        //得到 连接
        connection = factory.newConnection();

        //创建 channel实例
        channel = connection.createChannel();

        channel.queueDeclare(endpointName, false, false, false, null);

    }

    /**
     * 关闭channel和connection。并非必须，因为隐含是自动调用的。
     * @throws java.io.IOException
     */
    public void close() throws Exception{
        this.channel.close();
        this.connection.close();
    }
}
