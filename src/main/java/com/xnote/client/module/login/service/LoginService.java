package com.xnote.client.module.login.service;

import com.xnote.client.common.service.BaseService;
import com.xnote.client.module.user.bean.User;

public interface LoginService extends BaseService {

    public User getLoginUserByLoginName(String loginName);

    public void updateFirstLoginUser(User loginUser);

    public void updateLoginUser(User loginUser);

    /**
     * @ClassName: logout
     * @Desc:   登出操作，改变登录状态
     * @Author: xiaojundi_xx
     * @Param: [loginUser]
     * @Return: void
     **/
    public void logout(User loginUser);
}
