package com.xnote.client.common.service;

public interface BaseService {

    //////////////////////////////////////////////////////【 登陆操作 】//////////////////////////////////////////////////////
    public final static Integer LOGIN_SUCCESS_CODE = 0;
    public final static String LOGIN_SUCCESS_MESSAGE = "登陆成功！";

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
    public final static String LOGIN_FAILED_MESSAGE_106 = "登录失败，验证码填写错误1";
    public final static Integer LOGIN_FAILED_CODE_107 = 107;
    public final static String LOGIN_FAILED_MESSAGE_107 = "";

    public final static Integer LOGIN_ERROR_CODE = -1;
    public final static String LOGIN_ERROR_MESSAGE = "";

//////////////////////////////////////////////////////【 登陆操作 】//////////////////////////////////////////////////////

//////////////////////////////////////////////////////【 登陆操作 】//////////////////////////////////////////////////////

}
