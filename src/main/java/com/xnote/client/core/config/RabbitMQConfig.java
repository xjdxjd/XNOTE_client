package com.xnote.client.core.config;

import com.xnote.client.core.constant.ProjectConstant;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Bean("systemExchange")
    public Exchange systemExchange()
    {
        return ExchangeBuilder.topicExchange(ProjectConstant.XNOTE_SYSTEM_EXCHANGE.stringValue()).durable(true).build();
    }

    /**
     * 声明队列
     * @return
     */
    @Bean("clientCfgQueue")
    public Queue systemQueue(){return QueueBuilder.durable(ProjectConstant.XNOTE_SYSTEM_QUEUE.stringValue()).build();}

    /**
     * 声明队列
     * @return
     */
    @Bean("clientFuncQueue")
    public Queue clientQueue(){return QueueBuilder.durable(ProjectConstant.XNOTE_CLIFUNC_QUEUE.stringValue()).build();}

    /**
     * 绑定队列和交换机
     * @return
     */
    @Bean
    public Binding systemQueueExchange(@Qualifier("clientCfgQueue") Queue queue,
                                       @Qualifier("systemExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ProjectConstant.XNOTE_SYSCFG_CLIENT_RABBITMQ_MESSAGE_KEY.stringValue()).noargs();
    }

    /**
     * 绑定队列和交换机
     * @return
     */
    @Bean
    public Binding clientQueueExchange(@Qualifier("clientFuncQueue") Queue queue,
                                       @Qualifier("systemExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ProjectConstant.XNOTE_CLIENT_FUNC_MESSAGE_KEY.stringValue()).noargs();
    }
}
