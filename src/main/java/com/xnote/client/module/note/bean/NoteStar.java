package com.xnote.client.module.note.bean;

import java.util.Date;

/**
 * 笔记点赞量
 */
public class NoteStar {
    private String starId;

    private String noteId;

    private Integer noteStar;

    private Date updateTime;

    private Long updateTimestamp;

    public String getId() {
        return starId;
    }

    public void setId(String starId) {
        this.starId = starId == null ? null : starId.trim();
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId == null ? null : noteId.trim();
    }

    public Integer getNoteStar() {
        return noteStar;
    }

    public void setNoteStar(Integer noteStar) {
        this.noteStar = noteStar;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Long updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}