package com.xnote.client.module.login.controller;

import com.xnote.client.common.bean.Result;
import com.xnote.client.common.controller.BaseController;
import com.xnote.client.common.utils.log.LogUtis;
import com.xnote.client.common.utils.login.LoginUtils;
import com.xnote.client.core.constant.ProjectConstant;
import com.xnote.client.module.log.bean.UserLoginLog;
import com.xnote.client.module.log.service.UserLoginLogService;
import com.xnote.client.module.login.service.LoginService;
import com.xnote.client.module.user.bean.User;
import com.xnote.client.common.utils.security.SecuritySHA1Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController("loginController")
@RequestMapping("/login")
public class LoginController extends BaseController
{
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private LoginService loginService;
    @Autowired
    private UserLoginLogService userLoginLogService;


    /**
     * @ClassName: login
     * @Desc:   账号密码登录操作
     * @Author: xiaojundi_xx
     * @Param: [loginName, password, verifyCode, time, request]
     * @Return: Result  操作结果bean
     **/
    @PostMapping("/accountLogin/{loginName}/{password}/{verifyCode}/{time}")
    public Result login(HttpServletRequest request, @PathVariable("loginName")String loginName, @PathVariable("password")String password,@PathVariable("verifyCode")String verifyCode){
        if(StringUtils.isEmpty(loginName))
        {
            String content = "用户登录，用户登录失败。"
                    + ", 错误码：" + LOGIN_FAILED_CODE_100
                    + ", 错误信息：" + LOGIN_FAILED_MESSAGE_100;
            logger.error(content);
            UserLoginLog log = LogUtis.assembleLoginLog(LoginUtils.getLoginIP(request), ProjectConstant.ZERO_CONSTANT.intValue(), ProjectConstant.ONE_CONSTANT.intValue(), content, null);
            Integer row = userLoginLogService.saveUserLoginLog(log);

            return result.failed(LOGIN_FAILED_CODE_100, LOGIN_FAILED_MESSAGE_100);
        }else if(StringUtils.isEmpty(password))
        {
            String content = "用户登录，用户登录失败。"
                    + ", 错误码：" + LOGIN_FAILED_CODE_101
                    + ", 错误信息：" + LOGIN_FAILED_MESSAGE_101;
            logger.error(content);
            UserLoginLog log = LogUtis.assembleLoginLog(LoginUtils.getLoginIP(request), ProjectConstant.ZERO_CONSTANT.intValue(), ProjectConstant.ONE_CONSTANT.intValue(), content, null);
            Integer row = userLoginLogService.saveUserLoginLog(log);

            return result.failed(LOGIN_FAILED_CODE_101, LOGIN_FAILED_MESSAGE_101);
        }

//      验证User
        User loginUser = loginService.getLoginUserByLoginName(loginName);
        if(ObjectUtils.isEmpty(loginUser))
        {
            String content = "用户登录，用户登录失败。"
                    + ", 错误码：" + LOGIN_FAILED_CODE_103
                    + ", 错误信息：" + LOGIN_FAILED_MESSAGE_103;
            logger.error(content);
            UserLoginLog log = LogUtis.assembleLoginLog(LoginUtils.getLoginIP(request), ProjectConstant.ZERO_CONSTANT.intValue(), ProjectConstant.ONE_CONSTANT.intValue(), content, null);
            Integer row = userLoginLogService.saveUserLoginLog(log);

            return result.failed(LOGIN_FAILED_CODE_103, LOGIN_FAILED_MESSAGE_103);
        }

        if (loginUser.getUserStatus() != 0)
        {
            String content = "用户登录，用户登录失败。"
                    + ", 错误码：" + LOGIN_FAILED_CODE_104
                    + ", 错误信息：" + LOGIN_FAILED_MESSAGE_104;
            logger.error(content);
            UserLoginLog log = LogUtis.assembleLoginLog(LoginUtils.getLoginIP(request), ProjectConstant.ZERO_CONSTANT.intValue(), ProjectConstant.ONE_CONSTANT.intValue(), content, loginUser);
            Integer row = userLoginLogService.saveUserLoginLog(log);

            return result.failed(LOGIN_FAILED_CODE_104, LOGIN_FAILED_MESSAGE_104);
        }

//      验证password
        if(SecuritySHA1Utils.passwordVerify(password,loginUser.getPassword()))
        {
            String content = "用户登录，用户登录失败。"
                    + ", 错误码：" + LOGIN_FAILED_CODE_105
                    + ", 错误信息：" + LOGIN_FAILED_MESSAGE_105;
            logger.error(content);
            UserLoginLog log = LogUtis.assembleLoginLog(LoginUtils.getLoginIP(request), ProjectConstant.ZERO_CONSTANT.intValue(), ProjectConstant.ONE_CONSTANT.intValue(), content, loginUser);
            Integer row = userLoginLogService.saveUserLoginLog(log);

            return result.failed(LOGIN_FAILED_CODE_105, LOGIN_FAILED_MESSAGE_105);
        }

        Integer firstLogin = loginUser.getFirstLogin();
        if(firstLogin == 0)
        {
            loginService.updateFirstLoginUser(loginUser);
            request.getSession().setAttribute("user",loginUser);

            String content = "用户登录，用户登录成功。"
                    + ", 状态码：" + LOGIN_SUCCESS_CODE
                    + ", 状态信息：" + FIRST_LOGIN_SUCCESS_MESSAGE;
            logger.info(content);
            UserLoginLog log = LogUtis.assembleLoginLog(LoginUtils.getLoginIP(request), ProjectConstant.ZERO_CONSTANT.intValue(), ProjectConstant.ZERO_CONSTANT.intValue(), content, loginUser);
            Integer row = userLoginLogService.saveUserLoginLog(log);

            return super.result.success(FIRST_LOGIN_SUCCESS_MESSAGE);
        }
        else
        {
            loginService.updateLoginUser(loginUser);
            request.getSession().setAttribute("user",loginUser);

            String content = "用户登录，用户登录成功。"
                    + ", 状态码：" + LOGIN_SUCCESS_CODE
                    + ", 状态信息：" + LOGIN_SUCCESS_MESSAGE;
            logger.info(content);
            UserLoginLog log = LogUtis.assembleLoginLog(LoginUtils.getLoginIP(request), ProjectConstant.ZERO_CONSTANT.intValue(), ProjectConstant.ZERO_CONSTANT.intValue(), content, loginUser);
            Integer row = userLoginLogService.saveUserLoginLog(log);

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

    /**
     * 退出登录
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public Result logout(HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");
        if(ObjectUtils.isEmpty(user)){
            String content = "用户退出，用户退出失败。"
                    + ", 状态码：" + LOGOUT_FAILED_CODE_201
                    + ", 状态信息：" + LOGOUT_FAILED_MESSAGE_201;
            logger.info(content);
            UserLoginLog log = LogUtis.assembleLoginLog(LoginUtils.getLoginIP(request), ProjectConstant.ONE_CONSTANT.intValue(), ProjectConstant.ONE_CONSTANT.intValue(), content, null);
            Integer row = userLoginLogService.saveUserLoginLog(log);

            return result.failed(LOGOUT_FAILED_CODE_201, LOGOUT_FAILED_MESSAGE_201);
        }
        loginService.logout(user);
        request.getSession().invalidate();

        String content = "用户退出，用户退出成功。"
                + ", 状态码：" + LOGOUT_SUCCESS_CODE
                + ", 状态信息：" + LOGOUT_SUCCESS_MESSAGE;
        logger.info(content);
        UserLoginLog log = LogUtis.assembleLoginLog(LoginUtils.getLoginIP(request), ProjectConstant.ONE_CONSTANT.intValue(), ProjectConstant.ZERO_CONSTANT.intValue(), content, user);
        Integer row = userLoginLogService.saveUserLoginLog(log);

        return result.success(LOGOUT_SUCCESS_MESSAGE);
    }
}
