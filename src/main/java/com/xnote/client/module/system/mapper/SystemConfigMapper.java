package com.xnote.client.module.system.mapper;

import com.xnote.client.common.mapper.BaseMapper;
import com.xnote.client.module.system.bean.SystemConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @DESC:   系统配置mapper
 * @InterfaceName: SystemConfigMapper
 * @Author: xiaojundi_xx
 */
@Mapper
public interface SystemConfigMapper extends BaseMapper {

   /*
    * @MethodName: getAClientConfig
    * @Desc:   获取所有的客户端系统配置
    * @Author: xiaojundi_xx
    * @Param: []
    * @Return: List<SystemConfig>
    **/
    public List<SystemConfig> getAllClientConfig();
}
