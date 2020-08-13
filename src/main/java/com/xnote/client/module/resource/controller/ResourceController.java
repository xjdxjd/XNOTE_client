package com.xnote.client.module.resource.controller;

import com.xnote.client.common.bean.Result;
import com.xnote.client.common.controller.BaseController;
import com.xnote.client.common.utils.common.FileUtils;
import com.xnote.client.module.resource.bean.XResource;
import com.xnote.client.module.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/res")
public class ResourceController extends BaseController
{
    @Value("${xnote.resIconPath}")
    private String RESOURCE_ICON_PATH;

    @Value("${xnote.resStorePath}")
    private String RESOURCE_STORE_PATH;

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/resource")
    public String resDownView(Model model)
    {
        List<XResource> ress = resourceService.getResources();
        if(CollectionUtils.isEmpty(ress))
        {
            model.addAttribute("resList",null);
        }
        else
        {
            model.addAttribute("resList",ress);
        }
        return RESDOWN_PATH + "resourceDownLoad";
    }

    @GetMapping("/down/{id}")
    public void downRes(@PathVariable("id") String id,HttpServletResponse response)
    {
        if(!StringUtils.isEmpty(id))
        {
            XResource xres = resourceService.getResourceById(id);
            if(!ObjectUtils.isEmpty(xres) || !StringUtils.isEmpty(xres.getResUrl()))
            {
                File file = new File(RESOURCE_STORE_PATH + xres.getResUrl());
                if(file.exists())
                {
                    FileUtils.downFile(xres.getResUrl(), file, response);
                }
            }
            resourceService.addDownNubById(xres.getDownNub() + 1, id);
        }
    }

    @GetMapping("/downFile")
    public void respFaild(@RequestParam("url") String url, HttpServletResponse response)
    {
        if(!StringUtils.isEmpty(url))
        {
            File file = new File(RESOURCE_STORE_PATH + url);
            if(file.exists())
            {
                FileUtils.downFile(url, file, response);
            }
        }
//        return "";
    }
}
