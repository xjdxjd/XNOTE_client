package com.xnote.client.module.resource.controller;

import com.xnote.client.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/res")
public class ResourceController extends BaseController
{
    @GetMapping("/resource")
    public String resDownView(Model model)
    {

        model.addAttribute("","");
        return RESDOWN_PATH + "resourceDownLoad";
    }

    @GetMapping("/down/{id}")
    public void downRes(@PathParam("id") String id){

    }
}
