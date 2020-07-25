package com.xnote.client.module.note.controller;

import com.xnote.client.common.bean.Result;
import com.xnote.client.common.controller.BaseController;
import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.common.utils.common.UUIDUtils;
import com.xnote.client.core.constant.ProjectConstant;
import com.xnote.client.module.note.bean.*;
import com.xnote.client.module.note.service.NoteCommentService;
import com.xnote.client.module.note.service.NoteService;
import com.xnote.client.module.note.service.NoteStarService;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class NoteController extends BaseController
{
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteStarService noteStarService;
    @Autowired
    private NoteCommentService noteCommentService;

    /**
     *  加载首页
     * @param model
     * @return
     */
    @GetMapping({"/","/index","/index.html"})
    public String index(Model model)
    {
        return "index";
    }

    /**
     *  根据id加载笔记
     * @param model
     * @param noteId
     * @return
     */
    @GetMapping("/note/details/{noteId}")
    public String noteDescribe(Model model, @PathVariable("noteId") String noteId)
    {
        Note note = noteService.getNoteById(noteId);
        noteService.assembleNote(note);

        model.addAttribute("note", note);

        return DETAILS_PATH + "details";
    }

    /**
     * 查询全部笔记数
     * @return
     */
    @GetMapping("/note/getNoteCount")
    @ResponseBody
    public Result getNotesCount(){
        Integer count = noteService.getNotesCount();
        return result.success(count);
    };

    /**
     * 分页加载全部笔记
     * @param pageCode
     * @param pageSize
     * @return
     */
    @GetMapping("/note/getPagination")
    @ResponseBody
    public Result getNotePagination(@RequestParam("pageCode") Integer pageCode, @RequestParam("pageSize") Integer pageSize)
    {
        List<Note> notes = new ArrayList<>();

        if(ObjectUtils.isEmpty(pageCode))
        {
            notes = noteService.getAllNotes();
        } else {
            notes = noteService.getNotePagination((pageCode-1) * pageSize, pageSize);
        }

        for (Note note: notes)
        {
            noteService.assembleNote(note);
        }

        Map<String, Object> resMap = new HashMap<>();
        resMap.put("count", notes.size());
        resMap.put("notes",notes);

        return result.success(resMap);
    }

    /**
     * 点赞
     * @return
     */
    @GetMapping("/note/giveALike/{noteId}")
    @ResponseBody
    public Result giveALikeByNoteId(@PathVariable("noteId") String noteId)
    {
        if (StringUtils.isEmpty(noteId))
        {
            return result.failed(GIVELIVE_FAILED_CODE_110, GIVELIVE_FAILED_MESSAGE_110);
        }

        Note note = noteService.getNoteById(noteId);
        if(ObjectUtils.isEmpty(note))
        {
            return result.failed(GIVELIVE_FAILED_CODE_111, GIVELIVE_FAILED_MESSAGE_111);
        }

        NoteStar noteStar = noteStarService.getLikeByNoteId(noteId);
        if(ObjectUtils.isEmpty(noteStar) || ObjectUtils.isEmpty(noteStar.getNoteStar()))
        {
            return result.failed(GIVELIVE_FAILED_CODE_112, GIVELIVE_FAILED_MESSAGE_112);
        }

        Date date = DateUtils.getNowDate();
        noteStar.setNoteStar(noteStar.getNoteStar()+1);
        noteStar.setUpdateTime(date);
        noteStar.setUpdateTimestamp(DateUtils.getTimeStamp(date));

        Integer row = noteStarService.updateLikeByNoteId(noteStar);
        if(ProjectConstant.ZERO_CONSTANT.intValue().equals(row))
        {
            return result.failed(GIVELIVE_FAILED_CODE_113, GIVELIVE_FAILED_MESSAGE_113);
        }

        Integer star = noteStar.getNoteStar();
        return result.success(GIVELIVE_SUCCESS_CODE, GIVELIVE_SUCCESS_MESSAGE, star);
    };

    /**
     * 添加评论
     * @param noteId
     * @param commText
     * @return
     */
    @PostMapping("/note/addComment")
    @ResponseBody
    public Result addComment(@RequestParam("noteId")String noteId, @RequestParam("commText") String commText)
    {
        if(StringUtils.isEmpty(noteId) || StringUtils.isEmpty(commText))
        {
            return result.failed(COMMENT_FAILED_CODE_120, COMMENT_FAILED_MESSAGE_120);
        }

        Note note = noteService.getNoteById(noteId);
        if(ObjectUtils.isEmpty(note))
        {
            return result.failed(COMMENT_FAILED_CODE_121, COMMENT_FAILED_MESSAGE_121);
        }

        NoteComment noteComment = new NoteComment();
        noteComment.setId(UUIDUtils.getUUID());
        noteComment.setUserId("20664ca2453a414fa6784f0ca225c4bb");
        noteComment.setUserName("test");
        noteComment.setNoteId(noteId);
        noteComment.setCommCate(
                StringUtils.isEmpty(noteComment.getNoteId()) ?
                        ProjectConstant.ABNORMAL_CONSTANT.intValue() : ProjectConstant.ZERO_CONSTANT.intValue()
        );
        noteComment.setCommText(commText);

        Date date = DateUtils.getNowDate();
        noteComment.setCreateTime(date);
        noteComment.setCreateTimestamp(DateUtils.getTimeStamp(date));

        Integer row = noteCommentService.addCommentByNoteId(noteComment);
        if(ProjectConstant.ZERO_CONSTANT.intValue().equals(row))
        {
            return result.failed(COMMENT_FAILED_CODE_123, COMMENT_FAILED_MESSAGE_123);
        }

        List<NoteComment> noteComments = noteCommentService.getCommentByNoteId(noteId);

        return result.success(COMMENT_SUCCESS_CODE, COMMENT_SUCCESS_MESSAGE, noteComments);
    }
}
