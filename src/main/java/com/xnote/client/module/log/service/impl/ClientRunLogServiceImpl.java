package com.xnote.client.module.log.service.impl;

import com.xnote.client.module.log.bean.ClientRunLog;
import com.xnote.client.module.log.mapper.ClientRunLogMapper;
import com.xnote.client.module.log.service.ClientRunLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;

@Service
public class ClientRunLogServiceImpl implements ClientRunLogService
{
    @Resource
    private ClientRunLogMapper clientRunLogMapper;

    @Override
    public void save(ClientRunLog log)
    {
        if(!ObjectUtils.isEmpty(log) && !StringUtils.isEmpty(log.getLogId()) && !StringUtils.isEmpty(log.getLogContent()))
        {
            clientRunLogMapper.save(log);
        }
    }
}
