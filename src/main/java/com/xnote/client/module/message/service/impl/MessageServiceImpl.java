package com.xnote.client.module.message.service.impl;

import com.xnote.client.core.constant.ProjectConstant;
import com.xnote.client.module.message.bean.XMesComment;
import com.xnote.client.module.message.bean.XMesContent;
import com.xnote.client.module.message.bean.XMessage;
import com.xnote.client.module.message.mapper.XMesCommentMapper;
import com.xnote.client.module.message.mapper.XMesContentMapper;
import com.xnote.client.module.message.mapper.XMessageMapper;
import com.xnote.client.module.message.service.MessageService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 留言事务管理层实现
 */
@Service
public class MessageServiceImpl implements MessageService
{
    @Resource
    private XMessageMapper messageMapper;
    @Resource
    private XMesContentMapper contentMapper;
    @Resource
    private XMesCommentMapper commentMapper;


    @Override
    @Cacheable(value = "Messages", key = "#p0")
    public List<XMessage> getMessages(String mess)
    {
        List<XMessage> messages = messageMapper.getMessages();
        for (XMessage msg : messages)
        {
            //  获取留言内容
            XMesContent content = contentMapper.getContentById(msg.getContId());
            msg.setXContent(content);

            //  获取评论列表
            List<XMesComment> comments = commentMapper.getComments(msg.getMesId());
            msg.setComments(comments);
        }
        return messages;
    }

    @Override
    @CachePut(value = "Messages", key = "#p0")
    public List<XMessage> addMessage(String mess, XMessage message)
    {
        Integer row;
        List<XMessage> messages = new ArrayList<>();
        if(ObjectUtils.isEmpty(message.getMesId()))
        {
            message.assemble();
        }

        row = contentMapper.addContent(message.getXContent());
        if(ProjectConstant.ONE_CONSTANT.code().equals(row))
        {
            row = messageMapper.addMessage(message);
        }

        if(ProjectConstant.ONE_CONSTANT.code().equals(row))
        {
            messages = messageMapper.getMessages();
            for (XMessage msg : messages)
            {
                //  获取留言内容
                XMesContent content = contentMapper.getContentById(msg.getContId());
                msg.setXContent(content);

                //  获取评论列表
                List<XMesComment> comments = commentMapper.getComments(msg.getMesId());
                msg.setComments(comments);
            }
        }

        return messages;
    }

    @Override
    @CachePut(value = "Messages", key = "#p0")
    public List<XMessage> addMesComment(String mess, XMesComment comment)
    {
        Integer row;
        List<XMessage> messages = new ArrayList<>();
        if(ObjectUtils.isEmpty(comment.getMesId()))
        {
            comment.assemble();
        }

        row = commentMapper.addComment(comment);
        if(ProjectConstant.ONE_CONSTANT.code().equals(row))
        {
            messages = messageMapper.getMessages();
            for (XMessage msg : messages)
            {
                //  获取留言内容
                XMesContent content = contentMapper.getContentById(msg.getContId());
                msg.setXContent(content);

                //  获取评论列表
                List<XMesComment> comments = commentMapper.getComments(msg.getMesId());
                msg.setComments(comments);
            }
        }
        return messages;
    }
}
