package com.xnote.client.module.log.service.impl;

import com.xnote.client.core.constant.ProjectConstant;
import com.xnote.client.module.log.bean.UserLoginLog;
import com.xnote.client.module.log.mapper.UserLoginLogMapper;
import com.xnote.client.module.log.service.UserLoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserLoginLogServiceImpl implements UserLoginLogService
{
    @Resource
    private UserLoginLogMapper userLoginLogMapper;

    @Override
    public Integer saveUserLoginLog(UserLoginLog log)
    {
        if(ObjectUtils.isEmpty(log))
        {
            return ProjectConstant.ZERO_CONSTANT.code();
        }
        Integer row = userLoginLogMapper.saveLoginLog(log);
        return row;
    }

    @Override
    public Integer getCount() {
        return userLoginLogMapper.getCount();
    }

    @Override
    public List<UserLoginLog> getLogs(Integer pageCode, Integer pageSize)
    {
        if(ObjectUtils.isEmpty(pageCode))
        {
            return null;
        }

        List<UserLoginLog> logs = userLoginLogMapper.getLogs((pageCode - 1) * pageSize, pageSize);

        return logs;
    }

    @Override
    public Integer saveLoginLog(UserLoginLog userLoginLog)
    {
        if(ObjectUtils.isEmpty(userLoginLog))
        {
            return ProjectConstant.ZERO_CONSTANT.code();
        }
        Integer row = userLoginLogMapper.saveLoginLog(userLoginLog);
        return row;
    }
}
