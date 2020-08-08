package com.xnote.client.common.utils.log;

import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.common.utils.common.UUIDUtils;
import com.xnote.client.module.log.bean.UserLoginLog;
import com.xnote.client.module.user.bean.User;
import org.springframework.util.ObjectUtils;

import java.util.Date;

public class LogUtis {

    public static UserLoginLog assembleLoginLog(String ipaddr, Integer type, Integer status, String content, User user)
    {
        UserLoginLog log = new UserLoginLog();

        log.setLogId(UUIDUtils.getUUID());
        if(ObjectUtils.isEmpty(user)){
            log.setAccount(null);
            log.setLoginIp(null);
        } else {
            log.setAccount(user.getLoginName());
            log.setLoginIp(ipaddr);
        }

        log.setLoginType(type);
        log.setLoginStatus(status);
        log.setLogContent(content);

        Date now = DateUtils.getNowDate();
        log.setCreateTime(now);
        log.setTimestamp(DateUtils.getTimeStamp(now));

        return log;
    }
}
