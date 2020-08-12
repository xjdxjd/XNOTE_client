package com.xnote.client.core.constant;

public enum ProjectConstant
{
    /**
     * 标识：正常
     * 标识：更新失败、插入失败、删除失败
     * 标识：日志--类型
     * 标识：日志--状态
     */
    ZERO_CONSTANT(0),

    /**
     * 标识：异常
     * 标识：更新正常、插入正常、删除正常
     * 标识：日志--类型
     * 标识：日志--状态
     */
    ONE_CONSTANT(1),

    /**
     * 标识：系统配置类型--客户端
     */
    SYSCFG_TYPE_CLIENT(1),

    /**
     * 标识：不正常
     * 标识：
     */
    ABNORMAL_CONSTANT(-1),

    /**
     * AES加密--密钥
     */
    AES_SECRET_KEY("XnOtE@WwW!CatWAnT!CLuBXnOtE@WwW!CatWAnT!CLuBXnOtE@WwW!CatWAnT!CLuB"),

    /**
     * 交换机名称--系统配置
     */
    XNOTE_SYSTEM_EXCHANGE("xnote.sysCfg_exchange"),

    /**
     * 队列名称--系统配置
     */
    XNOTE_SYSTEM_QUEUE("xnote.sysCfg_queue"),

    /**
     * 队列名称--客户端功能
     */
    XNOTE_CLIFUNC_QUEUE("xnote.cliFunc_queue"),

    /**
     * 系统配置KEY--系统前台配置
     */
    XNOTE_SYSCFG_CLIENT_RABBITMQ_MESSAGE_KEY("xnote.clientCfg"),

    /**
     * 系统配置KEY--前台功能配置
     */
    XNOTE_CLIENT_FUNC_MESSAGE_KEY("xnote.clientfunc"),

    /**
     * 系统配置KEY--系统后台配置
     */
    XNOTE_SYSCFG_MANAGE_RABBITMQ_MESSAGE_KEY("xnote.ManageCfg"),

    /**
     * 分页初始常量
     */
    PAGINATION_CONSTANT(1);




    private Integer intValue;
    ProjectConstant(Integer intValue) { this.intValue = intValue; }
    public Integer code() { return intValue; }

    private String stringValue;

    ProjectConstant(String stringValue) { this.stringValue = stringValue; }
    public String msg() {
        return stringValue;
    }
}
