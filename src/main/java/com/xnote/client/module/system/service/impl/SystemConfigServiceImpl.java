package com.xnote.client.module.system.service.impl;

import com.xnote.client.common.service.impl.BaseServiceImpl;
import com.xnote.client.core.constant.ProjectConstant;
import com.xnote.client.module.system.bean.SystemConfig;
import com.xnote.client.module.system.mapper.SystemConfigMapper;
import com.xnote.client.module.system.service.SystemConfigService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @DESC:
 * @ClassName: SystemConfigServiceImpl
 * @Author: xiaojundi_xx
 */
@Service
public class SystemConfigServiceImpl extends BaseServiceImpl implements SystemConfigService {

    @Resource
    private SystemConfigMapper systemConfigMapper;

    @Override
    public Map<String, SystemConfig> getConfig(Integer configType) {
        List<SystemConfig> clientConfigList = new ArrayList<>();

       /* clientConfigList = systemConfigMapper.getConfigForCache(configType);
        if(CollectionUtils.isEmpty(clientConfigList))
        {

        }*/
        clientConfigList = systemConfigMapper.getAllClientConfig(configType);
        for (SystemConfig systemConfig: clientConfigList) {

            sysCfgMap.put(systemConfig.getConfigCode(), systemConfig);
        }
        return sysCfgMap;
    }
}
