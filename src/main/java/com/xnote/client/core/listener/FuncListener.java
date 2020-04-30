package com.xnote.client.core.listener;

import com.xnote.client.module.system.bean.SystemConfig;
import com.xnote.client.module.system.service.SystemConfigService;
import com.xnote.client.module.user.bean.UserFunction;
import com.xnote.client.module.user.service.UserFunctionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;

/**
 * @DESC:
 * @ClassName: FuncListener
 * @Author: xiaojundi_xx
 */
@Component
public class FuncListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        ApplicationContext context = event.getApplicationContext();
        UserFunctionService UserFunctionService = context.getBean(UserFunctionService.class);

        List<UserFunction> funcList = UserFunctionService.getFunction();

        ServletContext application = context.getBean(ServletContext.class);
        application.setAttribute("funcList", funcList);
    }
}
