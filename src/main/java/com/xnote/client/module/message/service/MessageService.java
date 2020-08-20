package com.xnote.client.module.message.service;


import com.xnote.client.module.message.bean.XMesComment;
import com.xnote.client.module.message.bean.XMessage;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 留言事务管理层
 */
public interface MessageService
{
    /**
     * 获取留言列表
     * @return
     */
    List<XMessage> getMessages(String mess);

    /**
     * 添加留言
     * @param mess
     * @param message
     * @return
     */
    List<XMessage> addMessage(String mess, XMessage message);

    /**
     * 添加留言评论
     * @param mess
     * @param comment
     * @return
     */
    List<XMessage> addMesComment(String mess, XMesComment comment);
}
