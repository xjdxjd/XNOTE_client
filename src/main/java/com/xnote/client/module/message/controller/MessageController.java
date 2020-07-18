package com.xnote.client.module.message.controller;

import com.xnote.client.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController extends BaseController
{
    @RequestMapping("/message")
    public String messageView()
    {
        return MESSAGE_PATH + "message";
    }
}
