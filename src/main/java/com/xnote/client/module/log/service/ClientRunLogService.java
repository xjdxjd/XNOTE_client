package com.xnote.client.module.log.service;

import com.xnote.client.module.log.bean.ClientRunLog;

public interface ClientRunLogService
{
    /**
     * 保存客户端运行日志
     * @param log
     */
    void save(ClientRunLog log);
}
