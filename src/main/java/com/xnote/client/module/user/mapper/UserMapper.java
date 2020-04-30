package com.xnote.client.module.user.mapper;

import com.xnote.client.common.mapper.BaseMapper;
import com.xnote.client.module.user.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper {

    public User getLoginUserByLoginName(String loginName);

    public void updateLoginUser(User loginUser);
}
