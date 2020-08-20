package com.xnote.client.core.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.core.constant.LogConstant;
import com.xnote.client.core.constant.ProjectConstant;
import com.xnote.client.module.log.bean.ClientRunLog;
import com.xnote.client.module.log.service.ClientRunLogService;
import com.xnote.client.module.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.*;

@Configuration
public class XNOTEDBConfig
{
    private final Logger logger = LoggerFactory.getLogger(XNOTEDBConfig.class);
    private ClientRunLog log = new ClientRunLog();

    @Autowired
    private ClientRunLogService clientRunLogService;

    /**
     * 创建Druid数据源
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        try
        {
            DruidDataSource druidDataSource = new DruidDataSource();
            List<Filter> filterList = new ArrayList<>();
            filterList.add(wallFilter());
            druidDataSource.setProxyFilters(filterList);

            String logContent = "Druid数据源配置，创建数据源成功。运行类: " + XNOTEDBConfig.class
                    + " 加载时间: "+ DateUtils.getFormatNowDate();
            logger.info(logContent);

            return druidDataSource;
        }
        catch (Exception ex)
        {
            String logContent = "Druid数据源配置，创建数据源失败。运行类: " + XNOTEDBConfig.class
                    + " 加载时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " +ex.getMessage();
            logger.error(logContent);

            ex.printStackTrace();
            return null;
        }
    }

    /**
     *  配置Druid监控
     * 1、配置一个管理后台的servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet()
    {
        try
        {
            ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

            Map<String, String> initParems = new HashMap<>();
            initParems.put("loginUsername", "admin");
            initParems.put("password","123456");
            initParems.put("allow","localhost");//  默认允许所有
            initParems.put("deny", "192.168.31.1");
            bean.setInitParameters(initParems);

            String logContent = "Druid数据源配置，配置管理端servlet成功。运行类: " + XNOTEDBConfig.class
                    + " 加载时间: "+ DateUtils.getFormatNowDate();
            logger.info(logContent);

            return bean;
        }
        catch (Exception ex)
        {
            String logContent = "Druid数据源配置，配置管理端servlet失败。运行类: " + XNOTEDBConfig.class
                    + " 加载时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " +ex.getMessage();
            logger.error(logContent);

            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 2、配置一个web监控的filter
     * @return
     */
//    @Bean
    public FilterRegistrationBean webStatFilter()
    {
        try
        {
            FilterRegistrationBean bean = new FilterRegistrationBean();

            Map<String, String> initParems = new HashMap<>();
            initParems.put("exclusions", "*.js,*.css,/druid/*");

            bean.setInitParameters(initParems);
            bean.setUrlPatterns(Arrays.asList("/*"));

            String logContent = "Druid数据源配置，配置web监控filter成功。运行类: " + XNOTEDBConfig.class
                    + " 加载时间: "+ DateUtils.getFormatNowDate();
            logger.info(logContent);

            return bean;
        }
        catch (Exception ex)
        {
            String logContent = "Druid数据源配置，配置web监控filter失败。运行类: " + XNOTEDBConfig.class
                    + " 加载时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " +ex.getMessage();
            logger.error(logContent);

            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 3、配置防火墙过滤器
     * @return
     */
    @Bean
    public WallFilter wallFilter()
    {
        try
        {
            WallFilter wallFilter = new WallFilter();
            wallFilter.setConfig(wallConfig());

            String logContent = "Druid数据源配置，配置防火墙监控filter成功。运行类: " + XNOTEDBConfig.class
                    + " 加载时间: "+ DateUtils.getFormatNowDate();
            logger.info(logContent);

            return wallFilter;
        }
        catch (Exception ex)
        {
            String logContent = "Druid数据源配置，配置防火墙监控filter失败。运行类: " + XNOTEDBConfig.class
                    + " 加载时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " +ex.getMessage();
            logger.error(logContent);

            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 4、配置防火墙
     * @return
     */
    @Bean
    public WallConfig wallConfig()
    {
        try
        {
            WallConfig config = new WallConfig();
            config.setMultiStatementAllow(true);
            config.setNoneBaseStatementAllow(true);

            String logContent = "Druid数据源配置，配置防火墙成功。运行类: " + XNOTEDBConfig.class
                    + " 加载时间: "+ DateUtils.getFormatNowDate();
            logger.info(logContent);

            return config;
        }
        catch (Exception ex)
        {
            String logContent = "Druid数据源配置，配置防火墙失败。运行类: " + XNOTEDBConfig.class
                    + " 加载时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " +ex.getMessage();
            logger.error(logContent);

            ex.printStackTrace();
            return null;
        }
    }
}
