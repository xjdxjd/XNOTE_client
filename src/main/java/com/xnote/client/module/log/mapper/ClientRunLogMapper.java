package com.xnote.client.module.log.mapper;

import com.xnote.client.module.log.bean.ClientRunLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientRunLogMapper
{
    /**
     * 保存日志
     * @param log
     */
    void save(ClientRunLog log);









    int deleteByPrimaryKey(String logId);
    int insert(ClientRunLog record);
    int insertSelective(ClientRunLog record);
    ClientRunLog selectByPrimaryKey(String logId);
    int updateByPrimaryKeySelective(ClientRunLog record);
    int updateByPrimaryKeyWithBLOBs(ClientRunLog record);
    int updateByPrimaryKey(ClientRunLog record);

}