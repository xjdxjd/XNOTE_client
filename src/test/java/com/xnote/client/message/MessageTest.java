package com.xnote.client.message;

import com.xnote.client.common.utils.common.UUIDUtils;
import com.xnote.client.module.message.bean.XMesComment;
import com.xnote.client.module.message.bean.XMesContent;
import com.xnote.client.module.message.bean.XMessage;
import com.xnote.client.module.message.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageTest
{
    @Autowired
    private MessageService messageService;

    @Test
    public void addMessage()
    {
        System.out.println("==========================");
        XMessage xMessage = new XMessage();
        xMessage.setMesUserId("20664ca2453a414fa6784f0ca225c4bb");
        xMessage.setMesUserName("test");
        xMessage.assemble();

        XMesContent content = new XMesContent();
        content.setContent("sssssssssssssssssssssssssssssssssssssssssssssssssss");
        xMessage.setXContent(content);

        xMessage.setContId(content.getContId());
        xMessage.setXContent(content);

        List<XMessage> messages = messageService.addMessage("mess", xMessage);
        System.out.println("row = " + messages.size());
        System.out.println("==========================");
    }

    @Test
    public void assembleXMesComment()
    {
        XMesComment xMesComment = new XMesComment();
        xMesComment.assemble();
    }
}
