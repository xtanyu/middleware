package com.xtyu.rabbitmqdemo.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 默认交换机Direct消费者监听
 * @author: 小熊
 * @date: 2021/7/30 22:40
 * @description:phone 17521111022
 */
@Component
public class DirectReceive {
    /**
     * 监听默认交换机队列1
     * @param msg
     */
    @RabbitListener(queues = "testDirectQueue")
    public void test1(String msg){
        System.out.println("获取到Direct交换机消息1 " + msg);
    }

    /**
     * 监听默认交换机队列2
     * @param msg
     */
    @RabbitListener(queues = "testDirectQueue")
    public void test2(String msg){
        System.out.println("获取到Direct交换机消息2 " + msg);
    }

}
