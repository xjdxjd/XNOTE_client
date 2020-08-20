package com.xnote.client.module.message.mapper;

import com.xnote.client.module.message.bean.XMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 留言映射
 */
@Mapper
public interface XMessageMapper
{
    /**
     * 获取全部评论
     * @return
     */
    List<XMessage> getMessages();

    /**
     * 添加评论
     * @param message
     * @return
     */
    Integer addMessage(XMessage message);





    int deleteByPrimaryKey(String mesId);
    int insert(XMessage record);
    int insertSelective(XMessage record);
    XMessage selectByPrimaryKey(String mesId);
    int updateByPrimaryKeySelective(XMessage record);
    int updateByPrimaryKey(XMessage record);

}