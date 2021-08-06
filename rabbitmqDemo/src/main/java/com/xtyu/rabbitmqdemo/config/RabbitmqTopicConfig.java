package com.xtyu.rabbitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 小熊
 * @date: 2021/8/2 11:29
 * @description:phone 17521111022
 */
@Configuration
public class RabbitmqTopicConfig {
    @Bean
    public Queue topicQueue(){
        return new Queue("topicQueue");
    }
    @Bean
    public Queue topicQueue2(){
        return new Queue("topicQueue2");
    }
    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange("xtYu.topic.Exchange");
    }
    @Bean
    public Binding topicBinding(Queue topicQueue,TopicExchange getTopicExchange){
        return BindingBuilder.bind(topicQueue).to(getTopicExchange).with("xtYu.*");
    }
    @Bean
    public Binding topicBinding2(Queue topicQueue2,TopicExchange getTopicExchange){
        return BindingBuilder.bind(topicQueue2).to(getTopicExchange).with("xtYu.test.*");
    }
}
