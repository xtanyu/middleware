package com.xtyu.rabbitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 扇形交换机
 * @author: 小熊
 * @date: 2021/7/31 17:14
 * @description:phone 17521111022
 */
@Configuration
public class RabbitmqFanoutConfig {
    @Bean
    public Queue fanoutQueue(){
        return new Queue("fanoutQueue");
    }

    @Bean
    public Queue fanoutQueue1(){
        return new Queue("fanoutQueue1");
    }


    @Bean
    public FanoutExchange getFanoutExchange(){
        return new FanoutExchange("xtYu.fanou.Exchange");
    }

    @Bean
    public Binding binding(Queue fanoutQueue,FanoutExchange getFanoutExchange){
        return BindingBuilder.bind(fanoutQueue).to(getFanoutExchange);
    }

    @Bean
    public Binding binding1(Queue fanoutQueue1,FanoutExchange getFanoutExchange){
        return BindingBuilder.bind(fanoutQueue1).to(getFanoutExchange);
    }
}
