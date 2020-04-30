package com.xnote.client.common.service.impl;

import com.xnote.client.common.service.BaseService;
import com.xnote.client.module.system.bean.SystemConfig;
import com.xnote.client.module.user.bean.UserFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseServiceImpl implements BaseService {

    //    系统配置map
    public Map<String, SystemConfig> sysCfgMap = new HashMap<String, SystemConfig>();
    //    系统配置map
    public List<UserFunction> funcList = new ArrayList<UserFunction>();
}
