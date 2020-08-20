package com.xnote.client.module.user.service.impl;

import com.xnote.client.module.user.bean.User;
import com.xnote.client.module.user.mapper.UserMapper;
import com.xnote.client.module.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService
{
    @Resource
    private UserMapper userMapper;

    @Override
    public Integer addUser(User user)
    {
        Integer row = userMapper.insertUser(user);
        return row;
    }

    @Override
    public Integer getUserMaxSort()
    {
        Integer maxSort = userMapper.getUserMaxSort();
        return maxSort;
    }

}
