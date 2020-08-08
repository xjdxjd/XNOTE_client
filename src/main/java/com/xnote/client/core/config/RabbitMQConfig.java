package com.xnote.client.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig
{
    private final Logger logger = LoggerFactory.getLogger(RabbitMQConfig.class);
    @Bean
    public MessageConverter messageConverter()
    {
        logger.info("==> 创建自定义消息转换器");
        try {
            logger.info("创建自定义消息转换器成功 ==>");
            return new Jackson2JsonMessageConverter();
        }catch (Exception ex){
            logger.error("创建自定义消息转换器失败==>");
            ex.printStackTrace();
            return null;
        }
    }

}
