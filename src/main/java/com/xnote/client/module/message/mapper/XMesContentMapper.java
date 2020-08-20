package com.xnote.client.module.message.mapper;

import com.xnote.client.module.message.bean.XMesContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 留言内容映射
 */
@Mapper
public interface XMesContentMapper
{
    /**
     * 根据内容ID获取留言内容
     * @param connId
     * @return
     */
    XMesContent getContentById(@Param("id") String connId);

    /**
     * 添加留言内容
     * @param content
     * @return
     */
    Integer addContent(XMesContent content);












    int deleteByPrimaryKey(String contId);
    int insert(XMesContent record);
    int insertSelective(XMesContent record);
    XMesContent selectByPrimaryKey(String contId);
    int updateByPrimaryKeySelective(XMesContent record);
    int updateByPrimaryKeyWithBLOBs(XMesContent record);

}