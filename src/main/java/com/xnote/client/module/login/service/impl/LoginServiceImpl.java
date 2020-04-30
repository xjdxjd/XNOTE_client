package com.xnote.client.module.login.service.impl;

import com.xnote.client.common.service.impl.BaseServiceImpl;
import com.xnote.client.module.user.bean.User;
import com.xnote.client.module.user.mapper.UserMapper;
import com.xnote.client.module.login.service.LoginService;
import com.xnote.client.common.utils.login.UpdateforLoginUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("loginService")
public class LoginServiceImpl extends BaseServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private UserMapper userMapper;
    @Override
    public User getLoginUserByLoginName(String loginName)
    {

        User loginUser = userMapper.getLoginUserByLoginName(loginName);
        return loginUser;
    }

    @Override
    public void updateFirstLoginUser(User loginUser) {

        User user = UpdateforLoginUtils.updateFirstLogin(loginUser);
        userMapper.updateLoginUser(user);
        logger.info("登录状态改变");
    }
    @Override
    public void updateLoginUser(User loginUser) {

        User user = UpdateforLoginUtils.updateforLogin(loginUser);
        userMapper.updateLoginUser(user);
        logger.info("登录状态改变");
    }

    @Override
    public void logout(User loginUser) {
        User user = UpdateforLoginUtils.logout(loginUser);
        userMapper.updateLoginUser(user);
        logger.info("登录状态改变");
    }
}
