package com.xnote.client.common.utils.login;

import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.module.user.bean.User;

import javax.servlet.http.HttpServletRequest;

public class LoginUtils {
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
        user.setLastLoginTime(DateUtils.getNowDate());
        user.setUpdateTime(DateUtils.getNowDate());
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

    /**
     * 获取登录IP
     * @param request
     * @return
     */
    public static String getLoginIP(HttpServletRequest request)
    {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }
}
