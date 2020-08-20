package com.xnote.client.module.message.mapper;

import com.xnote.client.module.message.bean.XMesComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 留言评论映射
 */
@Mapper
public interface XMesCommentMapper
{
    /**
     * 根据留言ID获取全部留言评论
     * @param mesId
     * @return
     */
    List<XMesComment> getComments(@Param("mesId") String mesId);

    /**
     * 添加留言评论
     * @param comment
     * @return
     */
    Integer addComment(XMesComment comment);




    int deleteByPrimaryKey(String connId);
    int insert(XMesComment record);
    int insertSelective(XMesComment record);
    XMesComment selectByPrimaryKey(String connId);
    int updateByPrimaryKeySelective(XMesComment record);
    int updateByPrimaryKey(XMesComment record);

}