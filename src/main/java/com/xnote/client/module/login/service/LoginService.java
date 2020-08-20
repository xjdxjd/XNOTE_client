package com.xnote.client.module.login.service;

import com.xnote.client.module.user.bean.User;

public interface LoginService
{

    /**
     * 根据登录名获取用户
     * @param loginName
     * @return
     */
    User getLoginUserByLoginName(String loginName);

    void updateFirstLoginUser(User loginUser);

    void updateLoginUser(User loginUser);

    /**
     * @ClassName: logout
     * @Desc:   登出操作，改变登录状态
     * @Author: xiaojundi_xx
     * @Param: [loginUser]
     * @Return: void
     **/
    void logout(User loginUser);
}
