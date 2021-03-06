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

    //  添加笔记页面路径
    public final static String NOTE_PATH = "note/";

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

    public final static Integer LOGOUT_SUCCESS_CODE = 1;
    public final static String LOGOUT_SUCCESS_MESSAGE = "成功退出登录！";
    public final static Integer LOGOUT_FAILED_CODE_201 = 201;
    public final static String LOGOUT_FAILED_MESSAGE_201 = "退出失败，用户已经退出!";

//////////////////////////////////////////////////////【 笔记操作 】//////////////////////////////////////////////////////

    public final static Integer GIVELIVE_SUCCESS_CODE = 0;
    public final static String GIVELIVE_SUCCESS_MESSAGE = "点赞成功！";

    public final static Integer GIVELIVE_FAILED_CODE_110 = 110;
    public final static String GIVELIVE_FAILED_MESSAGE_110 = "点赞失败，参数为空！";

    public final static Integer GIVELIVE_FAILED_CODE_111 = 111;
    public final static String GIVELIVE_FAILED_MESSAGE_111 = "此笔记不存在！";

    public final static Integer GIVELIVE_FAILED_CODE_112 = 112;
    public final static String GIVELIVE_FAILED_MESSAGE_112 = "此笔记点赞数据没有找到！";

    public final static Integer GIVELIVE_FAILED_CODE_113 = 113;
    public final static String GIVELIVE_FAILED_MESSAGE_113 = "点赞失败,请联系博主！";

//////////////////////////////////////////////////////【 评论操作 】//////////////////////////////////////////////////////

    public final static Integer COMMENT_SUCCESS_CODE = 0;
    public final static String COMMENT_SUCCESS_MESSAGE = "评论成功！";

    public final static Integer COMMENT_FAILED_CODE_120 = 120;
    public final static String COMMENT_FAILED_MESSAGE_120 = "评论失败，参数为空！";

    public final static Integer COMMENT_FAILED_CODE_121 = 121;
    public final static String COMMENT_FAILED_MESSAGE_121 = "此笔记不存在！";

    public final static Integer COMMENT_FAILED_CODE_122 = 122;
    public final static String COMMENT_FAILED_MESSAGE_122 = "此笔记点赞数据没有找到！";

    public final static Integer COMMENT_FAILED_CODE_123 = 123;
    public final static String COMMENT_FAILED_MESSAGE_123 = "评论失败,请联系博主！";



//////////////////////////////////////////////////////【 留言操作 】//////////////////////////////////////////////////////
    public final static Integer MESS_SUCCESS_CODE = 0;
    public final static String MESS_SUCCESS_MESSAGE = "留言成功!";

    public final static Integer MESS_FAILED_CODE_130 = 130;
    public final static String MESS_FAILED_MESSAGE_130 = "留言失败,请先登录!";

    public final static Integer MESS_FAILED_CODE_131 = 131;
    public final static String MESS_FAILED_MESSAGE_131 = "留言失败,未获取到留言内容!";

    public final static Integer MESS_FAILED_CODE_132 = 132;
    public final static String MESS_FAILED_MESSAGE_132 = "留言失败,内部错误!";

    public final static Integer MESS_FAILED_CODE_133 = 133;
    public final static String MESS_FAILED_MESSAGE_133 = "评论失败,请联系博主!";

    public final static Integer MESC_SUCCESS_CODE = 0;
    public final static String MESC_SUCCESS_MESSAGE = "留言评论成功!";

    public final static Integer MESS_FAILED_CODE_134 = 134;
    public final static String MESS_FAILED_MESSAGE_134 = "留言评论失败,评论内容为空!";

    public final static Integer MESS_FAILED_CODE_135 = 135;
    public final static String MESS_FAILED_MESSAGE_135 = "留言评论失败,请先登录!";

    public final static Integer MESS_FAILED_CODE_136 = 136;
    public final static String MESS_FAILED_MESSAGE_136 = "留言评论失败,未获取到留言用户!";

    public final static Integer MESS_FAILED_CODE_137 = 137;
    public final static String MESS_FAILED_MESSAGE_137 = "留言评论失败,未获取到最新评论!";

//////////////////////////////////////////////////////【 注册操作 】//////////////////////////////////////////////////////

    public final static Integer REGIST_SUCCESS_CODE = 0;
    public final static String REGIST_SUCCESS_MESSAGE = "注册用户成功！";

    public final static Integer REGIST_FAILED_CODE_140 = 140;
    public final static String REGIST_FAILED_MESSAGE_140 = "登录账号或密码未填写，请填写后再次注册！";
    public final static Integer REGIST_FAILED_CODE_141 = 141;
    public final static String REGIST_FAILED_MESSAGE_141 = "此用户已存在，请更换登录账号！";
    public final static Integer REGIST_FAILED_CODE_142 = 142;
    public final static String REGIST_FAILED_MESSAGE_142 = "账号注册失败，请重新注册或联系管理员解决！";
    public final static Integer REGIST_FAILED_CODE_143 = 143;
    public final static String REGIST_FAILED_MESSAGE_143 = "登录账号长度或格式不符合要求，请重新填写！";














}
