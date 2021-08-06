package com.xtyu.rabbitmqdemo.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: 小熊
 * @date: 2021/7/31 17:20
 * @description:phone 17521111022
 */
@Component
public class FanoutReceive {
    @RabbitListener(queues = "fanoutQueue")
    public void getFanoutQueue(String msg){
        System.out.println("获取到扇形交换机(fanout)的fanoutQuere队列消息:"+msg);
    }

    @RabbitListener(queues = "fanoutQueue1")
    public void getFanoutQueue1(String msg){
        System.out.println("获取到扇形交换机(fanout)的fanoutQuere1队列消息:"+msg);
    }
}
