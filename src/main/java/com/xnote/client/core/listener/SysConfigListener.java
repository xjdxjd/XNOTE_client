package com.xnote.client.core.listener;

import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.core.constant.LogConstant;
import com.xnote.client.core.constant.ProjectConstant;
import com.xnote.client.core.filter.PutFilter;
import com.xnote.client.module.log.bean.ClientRunLog;
import com.xnote.client.module.log.service.ClientRunLogService;
import com.xnote.client.module.system.bean.SystemConfig;
import com.xnote.client.module.system.service.SystemConfigService;
import com.xnote.client.module.user.bean.UserFunction;
import com.xnote.client.module.user.service.UserFunctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @DESC:
 * @ClassName: SysServletListener
 * @Author: xiaojundi_xx
 */
@Component
public class SysConfigListener implements ApplicationListener<ContextRefreshedEvent>
{
    private final Logger logger = LoggerFactory.getLogger(SysConfigListener.class);
    private ClientRunLog log = new ClientRunLog();

    @Autowired
    private ClientRunLogService clientRunLogService;

    /**
     * 初始化客户端配置
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        try
        {
            ApplicationContext context = event.getApplicationContext();
            SystemConfigService systemConfigService = context.getBean(SystemConfigService.class);

            Map<String, SystemConfig> clientConfig = systemConfigService.getConfig(ProjectConstant.SYSCFG_TYPE_CLIENT.code());
            ServletContext application = context.getBean(ServletContext.class);

            application.setAttribute("config", clientConfig);

            String logContent = "初始化客户端配置监听，客户端配置获取成功。运行类: " + SysConfigListener.class
                    + " 执行时间: "+ DateUtils.getFormatNowDate();
            log.assembleLog(LogConstant.RUN_TYPE_LISTENER.code(), LogConstant.RUN_RESULT_SUCCESS.code(), LogConstant.RUN_FAILURECAUSE_SUCCESS.msg(), logContent);
            logger.info(logContent);
            clientRunLogService.save(log);

        }
        catch (Exception ex)
        {
            String logContent = "初始化客户端配置监听，客户端配置获取失败。运行类: " + SysConfigListener.class
                    + " 执行时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " +ex.getMessage();
            log.assembleLog(LogConstant.RUN_TYPE_LISTENER.code(), LogConstant.RUN_RESULT_FAILURE.code(), ex.getMessage(), logContent);
            logger.error(logContent);
            clientRunLogService.save(log);

            ex.printStackTrace();
        }
    }
}
