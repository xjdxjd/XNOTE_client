package main.java.com.xnote.client.module.note.bean;

import java.util.Date;

public class Note {
    private String noteId;

    private String noteTitle;

    private String noteCont;

    private String noteCate;

    private Date createTime;

    private Date updateTime;

    private Long timestamp;

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId == null ? null : noteId.trim();
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle == null ? null : noteTitle.trim();
    }

    public String getNoteCont() {
        return noteCont;
    }

    public void setNoteCont(String noteCont) {
        this.noteCont = noteCont == null ? null : noteCont.trim();
    }

    public String getNoteCate() {
        return noteCate;
    }

    public void setNoteCate(String noteCate) {
        this.noteCate = noteCate == null ? null : noteCate.trim();
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