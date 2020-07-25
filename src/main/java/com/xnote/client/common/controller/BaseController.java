package com.xnote.client.common.controller;

import com.xnote.client.common.bean.Result;

public class BaseController {

//////////////////////////////////////////////////////【 页面路径 】//////////////////////////////////////////////////////

    //  登录页面路径
    public final static String LOGIN_PATH = "login/";

    //  错误页面路径
    public final static String ERROR_PATH = "error/";

    //  留言页面路径
    public final static String MESSAGE_PATH = "message/";

    //  详情页面路径
    public final static String DETAILS_PATH = "details/";

    //  资源下载页面路径
    public final static String RESDOWN_PATH = "resource/";

    //  资源下载页面路径
    public final static String ABOUT_PATH = "about/";

//////////////////////////////////////////////////////【 操作结果 】//////////////////////////////////////////////////////

    public Result result = new Result<>();
//////////////////////////////////////////////////////【 登陆操作 】//////////////////////////////////////////////////////

    public final static Integer LOGIN_SUCCESS_CODE = 0;
    public final static String FIRST_LOGIN_SUCCESS_MESSAGE = "登陆成功！";
    public final static String LOGIN_SUCCESS_MESSAGE = "欢迎回来！";

    public final static Integer LOGIN_FAILED_CODE_100 = 100;
    public final static String LOGIN_FAILED_MESSAGE_100 = "登录名未填写，请填写登录名！";
    public final static Integer LOGIN_FAILED_CODE_101 = 101;
    public final static String LOGIN_FAILED_MESSAGE_101 = "密码未填写，请填写密码！";
    public final static Integer LOGIN_FAILED_CODE_102 = 102;
    public final static String LOGIN_FAILED_MESSAGE_102 = "验证码未填写，请填写验证码！";
    public final static Integer LOGIN_FAILED_CODE_103 = 103;
    public final static String LOGIN_FAILED_MESSAGE_103 = "登录失败，此账号不存在，请检查登录名是否填写正确！";
    public final static Integer LOGIN_FAILED_CODE_104 = 104;
    public final static String LOGIN_FAILED_MESSAGE_104 = "登录失败，此账号已锁定或不可用！";
    public final static Integer LOGIN_FAILED_CODE_105 = 105;
    public final static String LOGIN_FAILED_MESSAGE_105 = "登录失败，密码错误！";
    public final static Integer LOGIN_FAILED_CODE_106 = 106;
    public final static String LOGIN_FAILED_MESSAGE_106 = "验证码为空，请填写验证码！";
    public final static Integer LOGIN_FAILED_CODE_107 = 107;
    public final static String LOGIN_FAILED_MESSAGE_107 = "验证失败，验证码已刷新，请重新填写！";
    public final static Integer LOGIN_FAILED_CODE_108 = 108;
    public final static String LOGIN_FAILED_MESSAGE_108 = "验证码填写错误，请重新填写！";
    public final static Integer LOGIN_FAILED_CODE_109 = 109;
    public final static String LOGIN_FAILED_MESSAGE_109 = "登录才能使用此功能！";

    public final static Integer LOGIN_ERROR_CODE = -1;
    public final static String LOGIN_ERROR_MESSAGE = "";

//////////////////////////////////////////////////////【 登陆操作 】//////////////////////////////////////////////////////

//////////////////////////////////////////////////////【 登陆操作 】//////////////////////////////////////////////////////

}
