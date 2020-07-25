package main.java.com.xnote.client.module.note.bean;

import java.util.Date;

public class NoteComment {
    private String commId;

    private String noteId;

    private String commCId;

    private Integer commCate;

    private Date createTime;

    private Long createTimestamp;

    private String commText;

    public String getCommId() {
        return commId;
    }

    public void setCommId(String commId) {
        this.commId = commId == null ? null : commId.trim();
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId == null ? null : noteId.trim();
    }

    public String getCommCId() {
        return commCId;
    }

    public void setCommCId(String commCId) {
        this.commCId = commCId == null ? null : commCId.trim();
    }

    public Integer getCommCate() {
        return commCate;
    }

    public void setCommCate(Integer commCate) {
        this.commCate = commCate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getCommText() {
        return commText;
    }

    public void setCommText(String commText) {
        this.commText = commText == null ? null : commText.trim();
    }
}