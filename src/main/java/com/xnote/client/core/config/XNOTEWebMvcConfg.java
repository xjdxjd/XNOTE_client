package com.xnote.client.core.config;

import com.xnote.client.core.interceptor.XnoteInterceptor;
import com.xnote.client.module.system.bean.SystemConfig;
import com.xnote.client.module.user.bean.UserFunction;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class XNOTEWebMvcConfg extends WebMvcConfigurationSupport
{
    @Autowired
    private ServletContext application;

    @Autowired
    private XnoteInterceptor xnoteInterceptor;
/*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(xnoteInterceptor);

    }*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
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

    }

    /**
     * 获取最新功能点
     * @param funcList
     */
    @RabbitListener(queues = "xnote.cliFunc_queue")
    public void getCliFunc(List<UserFunction> funcList)
    {
        System.out.println("====[ 客户端功能更新，获取最新功能点 ]====");

        Map<String, UserFunction> userFuncMap = new HashMap<>();
        for (UserFunction userFunc: funcList)
        {
            userFuncMap.put(userFunc.getFuncCode(), userFunc);
        }

        application.setAttribute("funcs", userFuncMap);
    }

    /**
     * 获取最新配置
     * @param clientConfigList
     */
    @RabbitListener(queues = "xnote.sysCfg_queue")
    public void getMessage(List<SystemConfig> clientConfigList)
    {
        System.out.println("====[ 客户端配置更新，获取最新配置 ]====");

        Map<String, SystemConfig> clientConfigMap = new HashMap<>();
        for (SystemConfig cliCfg: clientConfigList)
        {
            clientConfigMap.put(cliCfg.getConfigCode(), cliCfg);
        }

        application.setAttribute("config", clientConfigMap);
    }
}
