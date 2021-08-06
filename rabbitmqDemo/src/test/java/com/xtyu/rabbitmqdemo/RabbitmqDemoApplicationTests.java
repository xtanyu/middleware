package com.xtyu.rabbitmqdemo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqDemoApplicationTests {

    @Autowired
    AmqpTemplate amqpTemplate;


    @Test
    void contextPushDirectQueue() {
        //发送消息给默认(Direct)交换机的队列。连接该队列的消费者按顺序接收，消息只会被某个
        amqpTemplate.convertAndSend("testDirectQueue","测试默认消息");
        System.out.println("消息发送成功");
    }

    @Test
    void contextPushFanoutQueue() {
        amqpTemplate.convertAndSend("xtYu.fanou.Exchange","core","测试fanou消息Exchange");
        System.out.println("消息发送成功");
    }

    @Test
    void contextPushTopicQueue() {
        amqpTemplate.convertAndSend("xtYu.topic.Exchange","xtYu.test.123","测试topic消息Exchange");
        System.out.println("消息发送成功");
    }
}
