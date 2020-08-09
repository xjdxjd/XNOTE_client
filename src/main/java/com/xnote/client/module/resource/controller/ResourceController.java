package com.xnote.client.module.resource.controller;

import com.xnote.client.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourceController extends BaseController
{
    @RequestMapping("/resource")
    public String resDownView()
    {
        return RESDOWN_PATH + "resourceDownLoad";
    }
}
