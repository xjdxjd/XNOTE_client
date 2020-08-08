package com.xnote.client.module.log.service;

import com.xnote.client.module.log.bean.UserLoginLog;
import java.util.List;

public interface UserLoginLogService
{
    Integer saveUserLoginLog(UserLoginLog log);
    /**
     * 获取日志总数
     * @return
     */
    Integer getCount();

    /**
     * 获取全部日志记录
     * @return
     */
    List<UserLoginLog> getLogs(Integer pageCode, Integer pageSize);

    /**
     * 保存日志
     * @param userLoginLog
     * @return
     */
    Integer saveLoginLog(UserLoginLog userLoginLog);
}
