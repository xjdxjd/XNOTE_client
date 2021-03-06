package com.xnote.client.core.config;

import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.core.constant.LogConstant;
import com.xnote.client.core.constant.ProjectConstant;
import com.xnote.client.core.interceptor.XnoteInterceptor;
import com.xnote.client.module.log.bean.ClientRunLog;
import com.xnote.client.module.log.service.ClientRunLogService;
import com.xnote.client.module.system.bean.SystemConfig;
import com.xnote.client.module.user.bean.UserFunction;
import com.xnote.client.module.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class XNOTEWebMvcConfig extends WebMvcConfigurationSupport
{
    private final static Logger logger = LoggerFactory.getLogger(XNOTEWebMvcConfig.class);
    private ClientRunLog log = new ClientRunLog();

    @Value("${xnote.resIconPath}")
    private String RESOURCE_ICON_PATH;

    @Value("${xnote.resStorePath}")
    private String RESOURCE_STORE_PATH;

    @Autowired
    private UserService userService;
    @Autowired
    private ClientRunLogService clientRunLogService;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        try
        {
            registry.addResourceHandler("/css/**")
                    .addResourceLocations("classpath:/static/css/");

            registry.addResourceHandler("/js/**")
                    .addResourceLocations("classpath:/static/js/");

            registry.addResourceHandler("/img/**")
                    .addResourceLocations("classpath:/static/img/");

            registry.addResourceHandler("/icon/**")
                    .addResourceLocations("classpath:/static/icon/");

            registry.addResourceHandler("/plugin/**")
                    .addResourceLocations("classpath:/static/plugin/");

            registry.addResourceHandler("/webjars/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/");

            registry.addResourceHandler("/resDownIcon/**")
                    .addResourceLocations("file:"+ RESOURCE_ICON_PATH);

            registry.addResourceHandler("/resDownStore/**")
                    .addResourceLocations("file:"+ RESOURCE_STORE_PATH);

            String logContent = "web模块配置，静态资源映射添加成功。运行类: " + XNOTEWebMvcConfig.class
                    + " 获取时间: "+ DateUtils.getFormatNowDate();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_SUCCESS.code(), LogConstant.RUN_FAILURECAUSE_SUCCESS.msg(), logContent);
            logger.info(logContent);
            clientRunLogService.save(log);
        }
        catch (Exception ex)
        {
            String logContent = "web模块配置，静态资源映射添加失败。运行类: " + XNOTEWebMvcConfig.class
                    + " 获取时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " +ex.getMessage();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_FAILURE.code(), ex.getMessage(), logContent);
            logger.error(logContent);
            clientRunLogService.save(log);
            ex.printStackTrace();
        }
    }

    @Bean
    public void getUserMaxSort()
    {
        Integer userMaxSort = userService.getUserMaxSort();
        ProjectConstant.MAX_SORT_CONSTANT.setCode(userMaxSort);
    }
}
