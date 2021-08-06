package com.xtyu.rabbitmqdemo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 初始化默认交换机连接
 * @author: 小熊
 * @date: 2021/7/31 15:15
 * @description:phone 17521111022
 */
@Configuration
public class RabbitmqDirectConfig {
    @Bean
    protected Queue testDirectQueue(){
        return new Queue("testDirectQueue");
    }
}
