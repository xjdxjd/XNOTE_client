package com.xnote.client.core.constant;

public enum LogConstant {

    /**
     * 客户端运行日志--系统行为类型
     */
    RUN_TYPE_CONFIG(0),
    RUN_TYPE_FILTER(1),
    RUN_TYPE_LISTENER(2),
    RUN_TYPE_INTERCEPTOR(3),

    /**
     * 客户端运行日志--系统运行结果
     */
    RUN_RESULT_SUCCESS(0),
    RUN_RESULT_FAILURE(1),

    /**
     * 客户端运行日志--成功原因
     */
    RUN_FAILURECAUSE_SUCCESS("");

/******************************************************/
    private String msg;
    private Integer code;
    LogConstant(Integer code) { this.code = code; }
    public Integer code() { return code; }
    LogConstant(String msg) { this.msg = msg; }
    public String msg() { return msg; }
}
