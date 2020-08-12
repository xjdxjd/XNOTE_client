package com.xnote.client.module.resource.service;

import com.xnote.client.common.service.BaseService;
import com.xnote.client.module.resource.bean.XResource;

import java.util.List;

/**
 * 资源service类
 */
public interface ResourceService extends BaseService
{
    /**
     * 获取下载资源列表
     * @return
     */
    List<XResource> getResources();

    /**
     * 根据ID获取资源记录
     * @param id
     * @return
     */
    XResource getResourceById(String id);

}
