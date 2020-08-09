package com.xnote.client.common.utils.log;

import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.common.utils.common.UUIDUtils;
import com.xnote.client.module.log.bean.UserLoginLog;
import com.xnote.client.module.user.bean.User;
import org.springframework.util.ObjectUtils;
import oshi.SystemInfo;
import oshi.hardware.NetworkIF;

import java.util.Date;

public class LogUtils {

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

    public static String getLocalIPv4addr()
    {
        String ip = null;

        SystemInfo systemInfo = new SystemInfo();
        NetworkIF[] networkIFs = systemInfo.getHardware().getNetworkIFs();
        for (NetworkIF net: networkIFs)
        {
            String[] iPv4addr = net.getIPv4addr();
            for (String ipp : iPv4addr)
            {
                ip = ipp;
            }
        }
        return ip;
    }
}
