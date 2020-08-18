package com.xnote.client.module.note.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.crypto.provider.AESKeyGenerator;
import com.xnote.client.common.bean.Result;
import com.xnote.client.common.controller.BaseController;
import com.xnote.client.common.utils.Note.NoteUtils;
import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.common.utils.common.UUIDUtils;
import com.xnote.client.core.constant.ProjectConstant;
import com.xnote.client.module.note.bean.*;
import com.xnote.client.module.note.service.NoteCategoryService;
import com.xnote.client.module.note.service.NoteCommentService;
import com.xnote.client.module.note.service.NoteService;
import com.xnote.client.module.note.service.NoteStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.crypto.KeyGenerator;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
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
    @Autowired
    private NoteCategoryService noteCategoryService;


    @GetMapping("/ss")
    public String ss(){
        return null;
    }
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
    public Result getNotesCount(@RequestParam(value = "title", required = false)String title){
        Integer count = noteService.getNotesCount(title);
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
    public Result getNotePagination(
            @RequestParam(value = "title", required = false)String title,
            @RequestParam(value = "pageCode", required = false) Integer pageCode,
            @RequestParam("pageSize") Integer pageSize)
    {
        List<Note> notes;

        if(ObjectUtils.isEmpty(pageCode))
        {
            notes = noteService.getNotes(title);
        } else {
            notes = noteService.getNotePagination(title,(pageCode-1) * pageSize, pageSize);
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
        if(ProjectConstant.ZERO_CONSTANT.code().equals(row))
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
                        ProjectConstant.ABNORMAL_CONSTANT.code() : ProjectConstant.ZERO_CONSTANT.code()
        );
        noteComment.setCommText(commText);

        Date date = DateUtils.getNowDate();
        noteComment.setCreateTime(date);
        noteComment.setCreateTimestamp(DateUtils.getTimeStamp(date));

        Integer row = noteCommentService.addCommentByNoteId(noteComment);
        if(ProjectConstant.ZERO_CONSTANT.code().equals(row))
        {
            return result.failed(COMMENT_FAILED_CODE_123, COMMENT_FAILED_MESSAGE_123);
        }

        List<NoteComment> noteComments = noteCommentService.getCommentByNoteId(noteId);

        return result.success(COMMENT_SUCCESS_CODE, COMMENT_SUCCESS_MESSAGE, noteComments);
    }

    /**
     * 获取全部的笔记分类
     * @return
     */
    @GetMapping("/note/getNoteCategory")
    @ResponseBody
    public Result getNoteCategory()
    {
        List<NoteCategory> cates = noteCategoryService.getNoteCategory();
        if(CollectionUtils.isEmpty(cates))
        {
            return result.failed();
        }

        Map<String, Object> cateMap = new HashMap<>();
        cateMap.put("count", cates.size());
        cateMap.put("data", cates);

        return result.success(cateMap);
    }

    @GetMapping("/addnote")
    public String addNote(HttpSession session)
    {
        if(ObjectUtils.isEmpty(session.getAttribute("user")))
        {
            return "redirect:/index";
        }
        return NOTE_PATH + "noteadd";
    }

    @PutMapping("/addnote")
    @ResponseBody
    public Result addNote(@RequestParam("note")String notedata) throws JsonProcessingException
    {
        if(StringUtils.isEmpty(notedata))
        {
            return result.failed();
        }

        Note note = new Note();
        NoteContent content = new NoteContent();
        NoteStar star = new NoteStar();
        Map<String, String> noteDataMap = new ObjectMapper().readValue(notedata, Map.class);
        if(CollectionUtils.isEmpty(noteDataMap))
        {
            return result.failed();
        }

        //  组装页面传回数据
        note.setNoteTitle(noteDataMap.get("noteTitle"));
        note.setNoteCate(noteDataMap.get("noteCate"));
        content.setNoteContext(noteDataMap.get("content"));

        note = NoteUtils.assembleNote(note);
        content = NoteUtils.assembleNoteContent(note.getNoteCont(), note.getId(), content);
        star = NoteUtils.assembleNoteStar(note.getId(), star);

        Integer noteRow = noteService.addNote(note);
        if(ProjectConstant.ZERO_CONSTANT.equals(noteRow))
        {
            return result.failed();
        }

        Integer contentRow = noteService.addNoteContent(content);
        if(ProjectConstant.ZERO_CONSTANT.equals(contentRow))
        {
            return result.failed();
        }

        Integer starRow = noteStarService.addNoteStar(star);
        if(ProjectConstant.ZERO_CONSTANT.equals(starRow))
        {
            return result.failed();
        }

        return result.success();
    }
}
