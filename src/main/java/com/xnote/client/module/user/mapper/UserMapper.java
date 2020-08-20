package com.xnote.client.module.user.mapper;

import com.xnote.client.common.mapper.BaseMapper;
import com.xnote.client.module.user.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper
{
    /**
     * 添加用户
     * @param user
     * @return
     */
    Integer insertUser(User user);

    User getLoginUserByLoginName(String loginName);

    void updateLoginUser(User loginUser);

    /**
     * 查询最大的用户排序
     */
    Integer getUserMaxSort();
}
