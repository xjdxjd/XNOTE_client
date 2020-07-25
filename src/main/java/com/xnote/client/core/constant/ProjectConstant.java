package com.xnote.client.core.constant;

public enum ProjectConstant
{
    /**
     * 标识：正常
     * 标识：更新失败、插入失败、删除失败
     */
    ZERO_CONSTANT(0),

    /**
     * 标识：不正常
     * 标识：
     */
    ABNORMAL_CONSTANT(-1),

    //  分页初始常量
    PAGINATION_CONSTANT(1);

    private Integer intValue;
    ProjectConstant(Integer intValue) { this.intValue = intValue; }
    public Integer intValue() { return intValue; }
}
