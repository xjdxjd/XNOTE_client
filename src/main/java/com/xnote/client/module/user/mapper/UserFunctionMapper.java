package com.xnote.client.module.user.mapper;

import com.xnote.client.common.mapper.BaseMapper;
import com.xnote.client.module.user.bean.UserFunction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserFunctionMapper extends BaseMapper {

    /**
     * 获取功能列表
     * @return
     */
    public List<UserFunction> getUserFunction();

    /**
     * 更新客户端功能开关
     * @param userFuncs 客户端功能
     * @return
     */
    public void updateUserFuncSwitch(@Param(value = "userFuncs")List<UserFunction> userFuncs);

}
