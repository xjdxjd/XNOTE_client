package com.xnote.client.module.log.mapper;

import com.xnote.client.module.log.bean.ClientOperLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientOperLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(ClientOperLog record);

    int insertSelective(ClientOperLog record);

    ClientOperLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(ClientOperLog record);

    int updateByPrimaryKeyWithBLOBs(ClientOperLog record);

    int updateByPrimaryKey(ClientOperLog record);
}