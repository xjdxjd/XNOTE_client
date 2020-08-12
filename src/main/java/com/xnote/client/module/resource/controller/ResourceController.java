package com.xnote.client.module.resource.controller;

import com.xnote.client.common.bean.Result;
import com.xnote.client.common.controller.BaseController;
import com.xnote.client.module.resource.bean.XResource;
import com.xnote.client.module.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/res")
public class ResourceController extends BaseController
{
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
    @ResponseBody
    public Result downRes(@PathParam("id") String id)
    {

        return result.success();
    }
}
