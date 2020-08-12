package com.xnote.client.module.resource.service.impl;

import com.xnote.client.common.service.impl.BaseServiceImpl;
import com.xnote.client.module.resource.bean.XResource;
import com.xnote.client.module.resource.mapper.XResourceMapper;
import com.xnote.client.module.resource.service.ResourceService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResourceServiceImpl extends BaseServiceImpl implements ResourceService
{
    @Resource
    private XResourceMapper xResourceMapper;

    @Override
    public List<XResource> getResources()
    {
        List<XResource> resList = xResourceMapper.getResources();
        return resList;
    }

    @Override
    public XResource getResourceById(String id)
    {
        if(StringUtils.isEmpty(id))
        {
            return null;
        }

        XResource res = xResourceMapper.getResourceById(id);
        if(ObjectUtils.isEmpty(res))
        {
            return null;
        }
        return res;
    }
}
