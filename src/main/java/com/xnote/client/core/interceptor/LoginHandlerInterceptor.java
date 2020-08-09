package com.xnote.client.core.interceptor;

import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.core.constant.LogConstant;
import com.xnote.client.core.filter.PutFilter;
import com.xnote.client.module.log.bean.ClientRunLog;
import com.xnote.client.module.log.service.ClientRunLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginHandlerInterceptor implements HandlerInterceptor
{
    private final Logger logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);
    private ClientRunLog log = new ClientRunLog();

    @Autowired
    private ClientRunLogService clientRunLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    {
        try
        {
            boolean result;
            Object loginUser = request.getSession().getAttribute("User");
            if(loginUser == null)
            {
                //未登陆，返回登陆页面
                request.setAttribute("msg","请先登陆");
                request.getRequestDispatcher("/index.html").forward(request,response);
                result = false;
            }else{
                //已登陆，放行请求
                result = true;
            }
            return result;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
