package com.xnote.client.module.message.controller;

import com.xnote.client.common.bean.Result;
import com.xnote.client.common.controller.BaseController;
import com.xnote.client.module.message.bean.XMesComment;
import com.xnote.client.module.message.bean.XMesContent;
import com.xnote.client.module.message.bean.XMessage;
import com.xnote.client.module.message.service.MessageService;
import com.xnote.client.module.user.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MessageController extends BaseController
{
    @Autowired
    private MessageService messageService;

    /**
     * 跳转留言页面
     * @param model
     * @return
     */
    @RequestMapping("/message")
    public String messageView(Model model)
    {
        List<XMessage> messages = messageService.getMessages("mess");
        model.addAttribute("mess", messages);

        return MESSAGE_PATH + "message";
    }

    /**
     * 添加留言页面
     * @param model
     * @return
     */
    @RequestMapping("/reply")
    public String replayView(Model model)
    {

        return MESSAGE_PATH + "reply";
    }

    /**
     * 添加留言
     * @param xMesContent
     * @param xMessage
     * @param session
     * @return
     */
    @PutMapping("/mes/addmess")
    @ResponseBody
    public Result addMess(XMesContent xMesContent, XMessage xMessage, HttpSession session)
    {
       if(ObjectUtils.isEmpty(session.getAttribute("user")))
        {
            return result.failed(MESS_FAILED_CODE_130, MESS_FAILED_MESSAGE_130);
        }
        else
        {
            if(!StringUtils.isEmpty(xMesContent.getContent()))
            {
                xMesContent.assemble();
            }
            else
            {
                return result.failed(MESS_FAILED_CODE_131, MESS_FAILED_MESSAGE_131);
            }

            User user = (User) session.getAttribute("user");
            if(!ObjectUtils.isEmpty(xMessage))
            {
                xMessage.setMesUserId(user.getId());
                xMessage.setMesUserName(user.getLoginName());
                xMessage.setContId(xMesContent.getContId());
                xMessage.setXContent(xMesContent);
                xMessage.assemble();
            }
            else
            {
                return result.failed(MESS_FAILED_CODE_132, MESS_FAILED_MESSAGE_132);
            }

            List<XMessage> messages = messageService.addMessage("mess", xMessage);
            return result.success(MESS_SUCCESS_CODE, MESS_SUCCESS_MESSAGE, messages);
        }
    }

    /**
     * 添加留言评论
     * @param xMesComment
     * @return
     */
    @PutMapping("/mes/addcomment")
    @ResponseBody
    public Result addComment(HttpSession session, XMesComment xMesComment)
    {
        if(!ObjectUtils.isEmpty(xMesComment.getContent()))
        {
            xMesComment.assemble();
        }
        else
        {
            return result.failed(MESS_FAILED_CODE_134, MESS_FAILED_MESSAGE_134);
        }

        if(!ObjectUtils.isEmpty(session.getAttribute("user")))
        {
            User user = (User) session.getAttribute("user");
            xMesComment.setPublisherId(user.getId());
            xMesComment.setPublisher(user.getLoginName());
        }
        else
        {
            return result.failed(MESS_FAILED_CODE_135, MESS_FAILED_MESSAGE_135);
        }

        List<XMessage> messages = messageService.addMesComment("mess", xMesComment);
        if(CollectionUtils.isEmpty(messages))
        {
            return result.failed(MESS_FAILED_CODE_137, MESS_FAILED_MESSAGE_137);
        }
        return result.success(MESS_SUCCESS_CODE, MESS_SUCCESS_MESSAGE, messages);
    }

    /**
     * 回复评论
     * @param xMesComment
     * @return
     */
    @PutMapping("/mes/addreply")
    @ResponseBody
    public Result addreply(HttpSession session, XMesComment xMesComment)
    {
        if(!ObjectUtils.isEmpty(xMesComment.getContent()))
        {
            xMesComment.assemble();
        }
        else
        {
            return result.failed(MESS_FAILED_CODE_134, MESS_FAILED_MESSAGE_134);
        }

        if(!ObjectUtils.isEmpty(session.getAttribute("user")))
        {
            User user = (User) session.getAttribute("user");
            xMesComment.setPublisherId(user.getId());
            xMesComment.setPublisher(user.getLoginName());
        }
        else
        {
            return result.failed(MESS_FAILED_CODE_135, MESS_FAILED_MESSAGE_135);
        }

        List<XMessage> messages = messageService.addMesComment("mess", xMesComment);
        if(CollectionUtils.isEmpty(messages))
        {
            return result.failed(MESS_FAILED_CODE_137, MESS_FAILED_MESSAGE_137);
        }
        return result.success(MESS_SUCCESS_CODE, MESS_SUCCESS_MESSAGE, messages);
    }
}