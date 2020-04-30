package com.xnote.client.module.user.service.impl;

import com.xnote.client.common.service.impl.BaseServiceImpl;
import com.xnote.client.module.user.bean.UserFunction;
import com.xnote.client.module.user.mapper.UserFunctionMapper;
import com.xnote.client.module.user.service.UserFunctionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @DESC:
 * @ClassName: UserFunctionServiceImpl
 * @Author: xiaojundi_xx
 */
@Service
public class UserFunctionServiceImpl extends BaseServiceImpl implements UserFunctionService {
    
    @Resource
    private UserFunctionMapper userFunctionMapper;
    
    @Override
    public List<UserFunction> getFunction() {

        funcList = userFunctionMapper.getFunction();

        return funcList;
    }
}
