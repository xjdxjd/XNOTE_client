package com.xnote.client.common.controller;

import com.xnote.client.common.bean.IdentifyCode;
import com.xnote.client.module.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoadController extends BaseController{

    @GetMapping("/login")
    public String login()
    {
        return LOGIN_PATH + "login";
    }

    @GetMapping("/register")
    public String register()
    {
        return LOGIN_PATH + "register";
    }

    @GetMapping("/load/verifyCode")
    public void loadVerifyCode(String time, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        try{
            // 设置响应的类型格式为图片格式
            response.setContentType("image/jpeg");
            // 禁止图像缓存。
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);

            // 自定义宽、高、字数和干扰线的条数
            IdentifyCode code = new IdentifyCode(100, 38, 4, 10);
            // 存入session
            session.setAttribute("vCode", code.getCode());
            // 响应图片
            ServletOutputStream out = response.getOutputStream();
            code.write(out);
            try {
                out.flush();
            } finally {
                out.close();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
