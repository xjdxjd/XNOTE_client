package com.xnote.client.module.user.service;

import com.xnote.client.common.service.BaseService;
import com.xnote.client.module.user.bean.UserFunction;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @DESC:
 * @ClassName: UserFunctionService
 * @Author: xiaojundi_xx
 */
public interface UserFunctionService extends BaseService {

    public List<UserFunction> getFunction();
}
