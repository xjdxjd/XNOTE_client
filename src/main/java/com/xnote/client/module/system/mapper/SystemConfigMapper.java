package com.xnote.client.module.system.mapper;

import com.xnote.client.common.mapper.BaseMapper;
import com.xnote.client.module.system.bean.SystemConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @DESC:   系统配置mapper
 * @InterfaceName: SystemConfigMapper
 * @Author: xiaojundi_xx
 */
@Mapper
public interface SystemConfigMapper extends BaseMapper
{
    /**
     * 获取所有的客户端系统配置
     * @param configType 客户端配置标识
     * @return
     */
    public List<SystemConfig> getAllClientConfig(@Param(value = "configType")Integer configType);

    @Cacheable(value = "systemConfig", key = "#p0")
    public List<SystemConfig> getConfigForCache(Integer configType);
}
