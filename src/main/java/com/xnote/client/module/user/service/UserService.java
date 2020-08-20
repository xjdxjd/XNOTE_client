package com.xnote.client.module.user.service;

import com.xnote.client.module.user.bean.User;

public interface UserService
{
    /**
     * 添加用户
     * @param user
     * @return
     */
    Integer addUser(User user);

    /**
     * 查询最大的用户排序
     */
    Integer getUserMaxSort();
}
