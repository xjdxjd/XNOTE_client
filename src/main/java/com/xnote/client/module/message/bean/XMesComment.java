package com.xnote.client.module.message.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.common.utils.common.UUIDUtils;
import org.springframework.util.ObjectUtils;

import java.util.Date;

public class XMesComment {
    private String connId;

    private String mesId;

    private String publisherId;

    private String publisher;

    private String observerId;

    private String observer;

    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private Long timestamp;

    public String getConnId() {
        return connId;
    }

    public void setConnId(String connId) {
        this.connId = connId == null ? null : connId.trim();
    }

    public String getMesId() {
        return mesId;
    }

    public void setMesId(String mesId) {
        this.mesId = mesId == null ? null : mesId.trim();
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId == null ? null : publisherId.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getObserverId() {
        return observerId;
    }

    public void setObserverId(String observerId) {
        this.observerId = observerId == null ? null : observerId.trim();
    }

    public String getObserver() {
        return observer;
    }

    public void setObserver(String observer) {
        this.observer = observer == null ? null : observer.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "XMesComment{" +
                "connId='" + connId + '\'' +
                ", mesId='" + mesId + '\'' +
                ", publisherId='" + publisherId + '\'' +
                ", publisher='" + publisher + '\'' +
                ", observerId='" + observerId + '\'' +
                ", observer='" + observer + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", timestamp=" + timestamp +
                '}';
    }

    /**
     * 组装评论基本属性
     * @param
     * @return
     */
    public void assemble()
    {
        if(ObjectUtils.isEmpty(this.connId)) { this.connId = UUIDUtils.getUUID(); }
        if(ObjectUtils.isEmpty(this.createTime)) { this.createTime = DateUtils.getNowDate(); }
        if(ObjectUtils.isEmpty(this.timestamp)) { this.timestamp = DateUtils.getTimeStamp(); }
    };
}