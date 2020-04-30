package com.xnote.client.module.user.mapper;

import com.xnote.client.common.mapper.BaseMapper;
import com.xnote.client.module.user.bean.UserFunction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserFunctionMapper extends BaseMapper {

    public List<UserFunction> getFunction();
}
