package com.xnote.client.core.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig
{
    @Bean
    public MessageConverter messageConverter()
    {
        System.out.println("===创建自定义消息转换器===");
        return new Jackson2JsonMessageConverter();
    }
}
