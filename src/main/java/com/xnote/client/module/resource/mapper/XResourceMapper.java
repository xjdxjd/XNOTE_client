package com.xnote.client.module.resource.mapper;

import com.xnote.client.module.resource.bean.XResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface XResourceMapper
{
    /**
     * 获取下载资源列表
     * @return
     */
    List<XResource> getResources();

    /**
     * 根据ID获取资源记录
     * @param id
     * @return
     */
    XResource getResourceById(@Param("id") String id);

    /**
     * 根据ID添加下载量
     * @param id
     * @return
     */
    Integer addDownNubById(@Param("downNub") Integer downNub, @Param("id") String id);







    int deleteByPrimaryKey(String resId);
    int insert(XResource record);
    int insertSelective(XResource record);
    XResource selectByPrimaryKey(String resId);
    int updateByPrimaryKeySelective(XResource record);
    int updateByPrimaryKey(XResource record);

}