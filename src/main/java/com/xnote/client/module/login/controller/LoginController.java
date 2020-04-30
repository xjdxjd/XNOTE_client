package com.xnote.client.module.login.controller;

import com.xnote.client.common.bean.Result;
import com.xnote.client.common.controller.BaseController;
import com.xnote.client.module.login.service.LoginService;
import com.xnote.client.module.user.bean.User;
import com.xnote.client.common.utils.security.SecuritySHA1Utils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController("loginController")
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Resource
    private LoginService loginService;
    /**
     * @ClassName: login
     * @Desc:   账号密码登录操作
     * @Author: xiaojundi_xx
     * @Param: [loginName, password, verifyCode, time, request]
     * @Return: Result  操作结果bean
     **/
    @PostMapping("/accountLogin/{loginName}/{password}/{verifyCode}/{time}")
    public Result login(@PathVariable("loginName")String loginName, @PathVariable("password")String password,@PathVariable("verifyCode")String verifyCode, @PathVariable("time")String time,HttpServletRequest request){
        if(StringUtils.isEmpty(loginName))
        {
            return result.failed(LOGIN_FAILED_CODE_100, LOGIN_FAILED_MESSAGE_100);
        }else if(StringUtils.isEmpty(password))
        {
            return result.failed(LOGIN_FAILED_CODE_101, LOGIN_FAILED_MESSAGE_101);
        }
//      验证User
        User loginUser = loginService.getLoginUserByLoginName(loginName);
        if(ObjectUtils.isEmpty(loginUser))
        {
            return result.failed(LOGIN_FAILED_CODE_103, LOGIN_FAILED_MESSAGE_103);
        }

        if (loginUser.getUserStatus() != 0)
        {
            return result.failed(LOGIN_FAILED_CODE_104, LOGIN_FAILED_MESSAGE_104);
        }

//      验证password
        if(SecuritySHA1Utils.passwordVerify(password,loginUser.getPassword()))
        {
            return result.failed(LOGIN_FAILED_CODE_105, LOGIN_FAILED_MESSAGE_105);
        }
        Integer firstLogin = loginUser.getFirstLogin();
        if(firstLogin == 0){
            loginService.updateFirstLoginUser(loginUser);
            request.getSession().setAttribute("user",loginUser);
            return super.result.success(FIRST_LOGIN_SUCCESS_MESSAGE);
        }else{
            loginService.updateLoginUser(loginUser);
            request.getSession().setAttribute("user",loginUser);
            return super.result.success(LOGIN_SUCCESS_CODE,LOGIN_SUCCESS_MESSAGE+loginUser.getLoginName());
        }
    }

    /**
     * @ClassName: verifyCode
     * @Desc:   校验验证码
     * @Author: xiaojundi_xx
     * @Param: [verifyCode]
     * @Return: com.xnote.client.core.bean.Result
     **/
    @PostMapping("/accountLogin/vcode/{vCode}/{time}")
    public Result verifyCode(@PathVariable("vCode") String verifyCode, HttpSession session){
        if("____".equals(verifyCode)){
            return result.failed(LOGIN_FAILED_CODE_106, LOGIN_FAILED_MESSAGE_106);
        }
        String vCode = (String)session.getAttribute("vCode");
        if(StringUtils.isEmpty(vCode)){
            return result.failed(LOGIN_FAILED_CODE_107,LOGIN_FAILED_MESSAGE_107);
        }
        if(!vCode.equals(verifyCode)){
            return result.failed(LOGIN_FAILED_CODE_108, LOGIN_FAILED_MESSAGE_108);
        }
        return result.success("");
    }

    /**
     * @ClassName: checkLogined
     * @Desc:   检查用户是否登录
     * @Author: xiaojundi_xx
     * @Param: session
     * @Return: Result  操作结果bean
     **/
    @GetMapping("/checklogined")
    public Result checkLogined(HttpSession session){

        User user = (User) session.getAttribute("user");
        if(ObjectUtils.isEmpty(user)){
            return result.failed(LOGIN_FAILED_CODE_109, LOGIN_FAILED_MESSAGE_109);
        }else{
            return result.success();
        }
    }
    /*
     * @ClassName: logout
     * @Desc:   退出登录
     * @Author: xiaojundi_xx
     * @Param: [id, session]
     * @Return: com.xnote.client.core.bean.Result
     **/
    @GetMapping("/login/logout/{userId}")
    public Result logout(@PathVariable("userId") String id, HttpSession session){

        User user = (User) session.getAttribute("user");
        if(ObjectUtils.isEmpty(user)){
            return result.failed("退出失败，用户已经退出!");
        }
        loginService.logout(user);
        session.invalidate();
        return result.success("成功退出！");
    }
}
