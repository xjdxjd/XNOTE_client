package com.xnote.client.core.listener;

import com.xnote.client.module.system.bean.SystemConfig;
import com.xnote.client.module.system.service.SystemConfigService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.Map;


/**
 * @DESC:
 * @ClassName: SysServletListener
 * @Author: xiaojundi_xx
 */
@Component
public class SysConfigListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        ApplicationContext context = event.getApplicationContext();
        SystemConfigService systemConfigService = context.getBean(SystemConfigService.class);
        Map<String, SystemConfig> clientConfig = systemConfigService.getConfig();
        ServletContext application = context.getBean(ServletContext.class);

        application.setAttribute("config", clientConfig);
    }
}
