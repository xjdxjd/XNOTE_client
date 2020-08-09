package com.xnote.client.core.config;

import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.core.constant.LogConstant;
import com.xnote.client.module.log.bean.ClientRunLog;
import com.xnote.client.module.log.service.ClientRunLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig
{
    private final Logger logger = LoggerFactory.getLogger(RabbitMQConfig.class);
    private ClientRunLog log = new ClientRunLog();

    @Autowired
    private ClientRunLogService clientRunLogService;

    @Bean
    public MessageConverter messageConverter()
    {
        logger.info("==> RabbitMQ配置，创建自定义消息转换器");
        try
        {
            Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();

            String logContent = "RabbitMQ配置，创建自定义消息转换器成功。运行类: " + RabbitMQConfig.class
                    + " 加载时间: "+ DateUtils.getFormatNowDate();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_SUCCESS.code(), LogConstant.RUN_FAILURECAUSE_SUCCESS.msg(), logContent);
            logger.info(logContent);
            clientRunLogService.save(log);

            return jackson2JsonMessageConverter;
        }
        catch (Exception ex)
        {
            String logContent = "RabbitMQ配置，创建自定义消息转换器失败。运行类: " + RabbitMQConfig.class
                    + " 加载时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " +ex.getMessage();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_FAILURE.code(), ex.getMessage(), logContent);
            logger.error(logContent);
            clientRunLogService.save(log);

            ex.printStackTrace();
            return null;
        }
    }
}
