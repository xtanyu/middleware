package com.xtyu.rabbitmqdemo.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: 小熊
 * @date: 2021/8/2 11:36
 * @description:phone 17521111022
 */
@Component
public class TopicReceive {
    @RabbitListener(queues = "topicQueue")
    public void getTopicQueue(String msg){
        System.out.println("topicQueue:"+msg);
    }

    @RabbitListener(queues = "topicQueue2")
    public void getTopicQueue1(String msg){
        System.out.println("topicQueue2:"+msg);
    }
}
