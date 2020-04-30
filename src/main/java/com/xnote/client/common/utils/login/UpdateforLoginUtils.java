package com.xnote.client.common.utils.login;

import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.module.user.bean.User;

public class UpdateforLoginUtils {
    /**
     * @ClassName: updateforLogin
     * @Desc:   首次登录更新
     * @Author: xiaojundi_xx
     * @Param: [user]
     * @Return: com.xnote.client.module.user.bean.User
     **/
    public static User updateFirstLogin(User user)
    {
        user.setFirstLogin(1);
        user = updateforLogin(user);
        return user;
    }

    /**
     * @ClassName: updateforLogin
     * @Desc:       登录状态更新
     * @Author: xiaojundi_xx
     * @Param: [user]
     * @Return: com.xnote.client.module.user.bean.User
     **/
    public static User updateforLogin(User user)
    {
        user.setLoginStatus(0);
        user.setLastLoginTime(DateUtils.getNewDate());
        user.setUpdateTime(DateUtils.getNewDate());
        user.setTimestamp(DateUtils.getTimeStamp());
        return user;
    }

    /**
     * @ClassName: logout
     * @Desc:   退出登录改变登录状态
     * @Author: xiaojundi_xx
     * @Param: [user]
     * @Return: com.xnote.client.module.user.bean.User
     **/
    public static User logout(User user){

        user.setLoginStatus(1);
        return user;
    }
}
