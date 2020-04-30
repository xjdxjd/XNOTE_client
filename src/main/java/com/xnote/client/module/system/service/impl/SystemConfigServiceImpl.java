package com.xnote.client.module.system.service.impl;

import com.xnote.client.common.service.impl.BaseServiceImpl;
import com.xnote.client.module.system.bean.SystemConfig;
import com.xnote.client.module.system.mapper.SystemConfigMapper;
import com.xnote.client.module.system.service.SystemConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public Map<String, SystemConfig> getConfig() {

        List<SystemConfig> clientConfigList = systemConfigMapper.getAllClientConfig();
        for (SystemConfig systemConfig: clientConfigList) {

            sysCfgMap.put(systemConfig.getConfigCode(), systemConfig);
        }
        return sysCfgMap;
    }
}
