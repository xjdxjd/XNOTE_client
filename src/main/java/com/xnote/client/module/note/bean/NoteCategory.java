package com.xnote.client.module.note.bean;

import java.util.Date;

/**
 * 笔记分类
 */
public class NoteCategory {
    private String cateId;

    private String cateCode;

    private String cateName;

    private String cateParentId;

    private Integer cateSort;

    private Date createTime;

    private Date updateTime;

    private Long timestamp;

    public String getId() {
        return cateId;
    }

    public void setId(String cateId) {
        this.cateId = cateId == null ? null : cateId.trim();
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode == null ? null : cateCode.trim();
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }

    public String getCateParentId() {
        return cateParentId;
    }

    public void setCateParentId(String cateParentId) {
        this.cateParentId = cateParentId == null ? null : cateParentId.trim();
    }

    public Integer getCateSort() {
        return cateSort;
    }

    public void setCateSort(Integer cateSort) {
        this.cateSort = cateSort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}