package com.xnote.client.module.user.controller;

import com.xnote.client.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController extends BaseController
{
    @RequestMapping("/about")
    public String userAboutView()
    {
        return ABOUT_PATH + "about";
    }
}
