package com.xnote.client.module.message.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.common.utils.common.UUIDUtils;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

public class XMessage {
    private String mesId;

    private String mesUserId;

    private String mesUserName;

    private String contId;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date timeliness;

    private Long timestamp;

    private XMesContent xContent;

    private List<XMesComment> comments;

    public String getMesId() {
        return mesId;
    }

    public void setMesId(String mesId) {
        this.mesId = mesId == null ? null : mesId.trim();
    }

    public String getMesUserId() {
        return mesUserId;
    }

    public void setMesUserId(String mesUserId) {
        this.mesUserId = mesUserId == null ? null : mesUserId.trim();
    }

    public String getMesUserName() {
        return mesUserName;
    }

    public void setMesUserName(String mesUserName) {
        this.mesUserName = mesUserName == null ? null : mesUserName.trim();
    }

    public String getContId() {
        return contId;
    }

    public void setContId(String contId) {
        this.contId = contId == null ? null : contId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getTimeliness() {
        return timeliness;
    }

    public void setTimeliness(Date timeliness) {
        this.timeliness = timeliness;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public XMesContent getXContent() {
        return xContent;
    }

    public void setXContent(XMesContent xContent) {
        this.xContent = xContent;
    }

    public List<XMesComment> getComments() {
        return comments;
    }

    public void setComments(List<XMesComment> comments) {
        this.comments = comments;
    }

    /**
     * 组装留言基本属性
     * @return
     */
    public void assemble()
    {
        Date now = DateUtils.getNowDate();
        if(ObjectUtils.isEmpty(this.mesId)) { this.mesId = UUIDUtils.getUUID(); }
        if(ObjectUtils.isEmpty(this.createTime)) { this.createTime = now; }
        if(ObjectUtils.isEmpty(this.timeliness)) { this.timeliness = DateUtils.getSpecifiedDate(now, 3); }
        if(ObjectUtils.isEmpty(this.timestamp)) { this.timestamp = DateUtils.getTimeStamp(now); }
    };
}