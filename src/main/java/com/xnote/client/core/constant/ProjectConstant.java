package com.xnote.client.core.constant;

public enum ProjectConstant
{
    /**
     * 标识：正常
     * 标识：更新失败、插入失败、删除失败
     */
    ZERO_CONSTANT(0),

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
     * 交换机名称--系统配置
     */
    XNOTE_SYSTEM_EXCHANGE("xnote.sysCfg_exchange"),

    /**
     * 队列名称--系统配置
     */
    XNOTE_SYSTEM_QUEUE("xnote.sysCfg_queue"),

    /**
     * 系统配置KEY--系统前台配置
     */
    XNOTE_SYSCFG_CLIENT_RABBITMQ_MESSAGE_KEY("xnote.clientCfg"),
    /**
     * 系统配置KEY--系统后台配置
     */
    XNOTE_SYSCFG_MANAGE_RABBITMQ_MESSAGE_KEY("xnote.ManageCfg"),
    //  分页初始常量
    PAGINATION_CONSTANT(1);

    private Integer intValue;
    ProjectConstant(Integer intValue) { this.intValue = intValue; }
    public Integer intValue() { return intValue; }

    private String stringValue;

    ProjectConstant(String stringValue) { this.stringValue = stringValue; }
    public String stringValue() {
        return stringValue;
    }
}
