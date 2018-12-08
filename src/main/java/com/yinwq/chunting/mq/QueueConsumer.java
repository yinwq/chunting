package com.yinwq.chunting.mq;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2018/12/6 17:02
 */
public class QueueConsumer extends EndPoint implements Runnable, Consumer{
    private Logger LOGGER = Logger.getLogger(QueueConsumer.class);

    public QueueConsumer(String endpointName) throws Exception {
        super(endpointName);
    }

    public void handleConsumeOk(String s) {

    }

    public void handleCancelOk(String s) {

    }

    public void handleCancel(String s) throws IOException {

    }

    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    public void handleRecoverOk(String s) {
        LOGGER.info("Consumer "+s +" registered");
    }

    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        /*Map map = (HashMap) SerializationUtils.deserialize(bytes);
        LOGGER.info("Message Number "+ map.get("message number") + " received.");*/
    }

    public void run() {
        try{
            channel.basicConsume(endPointName, true,this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
