package com.xnote.client.module.system.service;

import com.xnote.client.common.service.BaseService;
import com.xnote.client.module.system.bean.SystemConfig;

import java.util.Map;

/**
 * @DESC:   系统配置service
 * @InterfaceName: SystemConfigService
 * @Author: xiaojundi_xx
 */
public interface SystemConfigService extends BaseService {

    public Map<String, SystemConfig> getConfig();
}
