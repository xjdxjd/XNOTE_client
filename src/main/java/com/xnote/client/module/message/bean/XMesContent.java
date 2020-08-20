package com.xnote.client.module.message.bean;

import com.xnote.client.common.utils.common.UUIDUtils;
import org.springframework.util.StringUtils;

public class XMesContent {
    private String contId;

    private String content;

    public String getContId() {
        return contId;
    }

    public void setContId(String contId) {
        this.contId = contId == null ? null : contId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 组装留言内容基本属性
     * @return
     */
    public void assemble()
    {
        if(StringUtils.isEmpty(this.contId)) { this.contId = UUIDUtils.getUUID(); }
    };
}