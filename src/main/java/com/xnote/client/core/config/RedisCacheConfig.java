package com.xnote.client.core.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.core.constant.LogConstant;
import com.xnote.client.module.log.bean.ClientRunLog;
import com.xnote.client.module.log.service.ClientRunLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;


/**
 * redis自定义配置
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport
{
    private final static Logger logger = LoggerFactory.getLogger(RedisCacheConfig.class);
    private ClientRunLog log = new ClientRunLog();

    @Autowired
    private ClientRunLogService clientRunLogService;

    /**
     * retemplate相关配置
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory)
    {
        logger.info("==> Redis缓存配置，创建redis模板");
        try {

            RedisTemplate<String, Object> template = new RedisTemplate<>();
            // 配置连接工厂
            template.setConnectionFactory(factory);

            //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
            Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);

            ObjectMapper om = new ObjectMapper();
            // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jacksonSeial.setObjectMapper(om);

            // 值采用json序列化
            template.setValueSerializer(jacksonSeial);
            //使用StringRedisSerializer来序列化和反序列化redis的key值
            template.setKeySerializer(new StringRedisSerializer());

            // 设置hash key 和value序列化模式
            template.setHashKeySerializer(new StringRedisSerializer());
            template.setHashValueSerializer(jacksonSeial);
            template.afterPropertiesSet();

            String logContent = "Redis缓存配置，创建redis模板成功。运行类: " + RedisCacheConfig.class
                    + " 创建时间: "+ DateUtils.getFormatNowDate();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_SUCCESS.code(), LogConstant.RUN_FAILURECAUSE_SUCCESS.msg(), logContent);
            logger.info(logContent);
            clientRunLogService.save(log);

            return template;
        }
        catch (Exception ex)
        {
            String logContent = "Redis缓存配置，创建redis模板失败。运行类: " + RedisCacheConfig.class
                    + " 创建时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " + ex.getMessage();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_FAILURE.code(), ex.getMessage(), logContent);
            logger.error(logContent);
            clientRunLogService.save(log);

            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 配置使用注解的时候缓存配置，默认是序列化反序列化的形式，加上此配置则为 json 形式
     * @param factory
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory)
    {
        try
        {
            RedisSerializer<String> redisSerializer = new StringRedisSerializer();
            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

            //解决查询缓存转换异常的问题
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jackson2JsonRedisSerializer.setObjectMapper(om);

            // 配置序列化（解决乱码的问题）,过期时间30秒
            RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofSeconds(30))
                    .entryTtl(Duration.ofSeconds(-1))  //设置过期时间：-1为永久有效
                    .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                    .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                    .disableCachingNullValues();

            RedisCacheManager cacheManager = RedisCacheManager.builder(factory)
                    .cacheDefaults(config)
                    .build();

            String logContent = "Redis缓存配置，创建缓存管理器成功。运行类: " + RedisCacheConfig.class
                    + " 创建时间: "+ DateUtils.getFormatNowDate();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_SUCCESS.code(), LogConstant.RUN_FAILURECAUSE_SUCCESS.msg(), logContent);
            logger.info(logContent);
            clientRunLogService.save(log);

            return cacheManager;
        }
        catch (Exception ex)
        {
            String logContent = "Redis缓存配置，创建缓存管理器失败。运行类: " + RedisCacheConfig.class
                    + " 创建时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " + ex.getMessage();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_FAILURE.code(), ex.getMessage(), logContent);
            logger.error(logContent);
            clientRunLogService.save(log);

            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 对hash类型的数据操作
     * @param redisTemplate
     * @return
     */
    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate)
    {
        try
        {
            HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();

            String logContent = "Redis缓存配置，创建Hash类型数据操作策略成功。运行类: " + RedisCacheConfig.class
                    + " 创建时间: "+ DateUtils.getFormatNowDate();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_SUCCESS.code(), LogConstant.RUN_FAILURECAUSE_SUCCESS.msg(), logContent);
            logger.info(logContent);
            clientRunLogService.save(log);

            return hashOperations;
        }
        catch (Exception ex)
        {
            String logContent = "Redis缓存配置，创建Hash类型数据操作策略失败。运行类: " + RedisCacheConfig.class
                    + " 创建时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " + ex.getMessage();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_FAILURE.code(), ex.getMessage(), logContent);
            logger.error(logContent);
            clientRunLogService.save(log);

            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 对redis字符串类型数据操作
     * @param redisTemplate
     * @return
     */
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate)
    {
        try
        {
            ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();

            String logContent = "Redis缓存配置，创建String类型数据操作策略成功。运行类: " + RedisCacheConfig.class
                    + " 创建时间: "+ DateUtils.getFormatNowDate();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_SUCCESS.code(), LogConstant.RUN_FAILURECAUSE_SUCCESS.msg(), logContent);
            logger.info(logContent);
            clientRunLogService.save(log);

            return valueOperations;
        }
        catch (Exception ex)
        {
            String logContent = "Redis缓存配置，创建String类型数据操作策略失败。运行类: " + RedisCacheConfig.class
                    + " 创建时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " + ex.getMessage();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_FAILURE.code(), ex.getMessage(), logContent);
            logger.error(logContent);
            clientRunLogService.save(log);

            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 对链表类型的数据操作
     * @param redisTemplate
     * @return
     */
    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate)
    {
        try
        {
            ListOperations<String, Object> listOperations = redisTemplate.opsForList();

            String logContent = "Redis缓存配置，创建List类型数据操作策略成功。运行类: " + RedisCacheConfig.class
                    + " 创建时间: "+ DateUtils.getFormatNowDate();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_SUCCESS.code(), LogConstant.RUN_FAILURECAUSE_SUCCESS.msg(), logContent);
            logger.info(logContent);
            clientRunLogService.save(log);

            return listOperations;
        }
        catch (Exception ex)
        {
            String logContent = "Redis缓存配置，创建List类型数据操作策略失败。运行类: " + RedisCacheConfig.class
                    + " 创建时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " + ex.getMessage();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_FAILURE.code(), ex.getMessage(), logContent);
            logger.error(logContent);
            clientRunLogService.save(log);

            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 对无序集合类型的数据操作
     * @param redisTemplate
     * @return
     */
    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate)
    {
        try
        {
            SetOperations<String, Object> setOperations = redisTemplate.opsForSet();

            String logContent = "Redis缓存配置，创建Set(无序集合)类型数据操作策略成功。运行类: " + RedisCacheConfig.class
                    + " 创建时间: "+ DateUtils.getFormatNowDate();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_SUCCESS.code(), LogConstant.RUN_FAILURECAUSE_SUCCESS.msg(), logContent);
            logger.info(logContent);
            clientRunLogService.save(log);

            return setOperations;
        }
        catch (Exception ex)
        {
            String logContent = "Redis缓存配置，创建Set(无序集合)类型数据操作策略失败。运行类: " + RedisCacheConfig.class
                    + " 创建时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " + ex.getMessage();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_FAILURE.code(), ex.getMessage(), logContent);
            logger.error(logContent);
            clientRunLogService.save(log);

            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 对有序集合类型的数据操作
     * @param redisTemplate
     * @return
     */
    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate)
    {
        try
        {
            ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();

            String logContent = "Redis缓存配置，创建zSet(有序集合)类型数据操作策略成功。运行类: " + RedisCacheConfig.class
                    + " 创建时间: "+ DateUtils.getFormatNowDate();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_SUCCESS.code(), LogConstant.RUN_FAILURECAUSE_SUCCESS.msg(), logContent);
            logger.info(logContent);
            clientRunLogService.save(log);

            return zSetOperations;
        }
        catch (Exception ex)
        {
            String logContent = "Redis缓存配置，创建zSet(有序集合)类型数据操作策略失败。运行类: " + RedisCacheConfig.class
                    + " 创建时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " + ex.getMessage();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_FAILURE.code(), ex.getMessage(), logContent);
            logger.error(logContent);
            clientRunLogService.save(log);

            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 缓存生成器
     * @return
     */
    @Override
//    @Bean("keyGenerator")
    public KeyGenerator keyGenerator()
    {

        try
        {
            KeyGenerator keyGenerator = new KeyGenerator() {
                @Override
                public Object generate(Object target, Method method, Object... params) {
                    return method.getName() + "[" + Arrays.asList(params).toString() + "]";
                }
            };

            String logContent = "Redis缓存配置，创建缓存键（key)生成器成功。运行类: " + RedisCacheConfig.class
                    + " 创建时间: "+ DateUtils.getFormatNowDate();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_SUCCESS.code(), LogConstant.RUN_FAILURECAUSE_SUCCESS.msg(), logContent);
            logger.info(logContent);
            clientRunLogService.save(log);

            return keyGenerator;
        }
        catch (Exception ex)
        {
            String logContent = "Redis缓存配置，创建缓存键（key)生成器生成器失败。运行类: " + RedisCacheConfig.class
                    + " 创建时间: " + DateUtils.getFormatNowDate()
                    + " 错误原因: " + ex.getMessage();
            log.assembleLog(LogConstant.RUN_TYPE_CONFIG.code(), LogConstant.RUN_RESULT_FAILURE.code(), ex.getMessage(), logContent);
            logger.error(logContent);
            clientRunLogService.save(log);

            ex.printStackTrace();
            return null;
        }
    }
}
