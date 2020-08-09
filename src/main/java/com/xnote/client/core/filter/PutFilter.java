package com.xnote.client.core.filter;


import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.core.config.RabbitMQConfig;
import com.xnote.client.core.constant.LogConstant;
import com.xnote.client.module.log.bean.ClientRunLog;
import com.xnote.client.module.log.service.ClientRunLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.FormContentFilter;

@Component
public class PutFilter extends FormContentFilter
{
    private final Logger logger = LoggerFactory.getLogger(PutFilter.class);
    private ClientRunLog log = new ClientRunLog();

    @Autowired
    private ClientRunLogService clientRunLogService;

    /**
     * 解决PUT获取不到参数的问题
     * @return
     */
    @Bean
    public FormContentFilter formContentFilter()
    {
        logger.info("==> 表单内容过滤器配置，创建表单内容过滤器");
        try
        {
            FormContentFilter formContentFilter = new FormContentFilter();

            String logContent = "表单内容过滤器配置，表单内容过滤器创建成功。运行类: " + PutFilter.class
                    + " 加载时间: "+ DateUtils.getFormatNowDate();
            log.assembleLog(LogConstant.RUN_TYPE_FILTER.code(), LogConstant.RUN_RESULT_SUCCESS.code(), LogConstant.RUN_FAILURECAUSE_SUCCESS.msg(), logContent);
            logger.info(logContent);
            clientRunLogService.save(log);

            return formContentFilter;
        }
        catch (Exception ex)
        {
            String logContent = "表单内容过滤器配置，表单内容过滤器创建失败。运行类: " + PutFilter.class
                    + " 加载时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " +ex.getMessage();
            log.assembleLog(LogConstant.RUN_TYPE_FILTER.code(), LogConstant.RUN_RESULT_FAILURE.code(), ex.getMessage(), logContent);
            logger.error(logContent);
            clientRunLogService.save(log);

            ex.printStackTrace();
            return null;
        }
    }
}
