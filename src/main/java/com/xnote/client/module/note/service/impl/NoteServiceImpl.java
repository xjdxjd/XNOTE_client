package com.xnote.client.module.note.service.impl;

import com.xnote.client.core.constant.ProjectConstant;
import com.xnote.client.module.note.bean.*;
import com.xnote.client.module.note.mapper.*;
import com.xnote.client.module.note.service.NoteService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("noteService")
public class NoteServiceImpl implements NoteService
{
    @Resource
    private NoteMapper noteMapper;
    @Resource
    private NoteContentMapper noteContentMapper;
    @Resource
    private NoteCategoryMapper noteCategoryMapper;
    @Resource
    private NoteCommentMapper noteCommentMapper;
    @Resource
    private NoteStarMapper noteStarMapper;

    @Override
    public Integer getNotesCount(String title) {
        Integer count = noteMapper.getNotesCount(title);
        return count;
    }

    @Override
    public List<Note> getNotes(String title)
    {
        List<Note> notes;
        if(StringUtils.isEmpty(title))
        {
            notes = noteMapper.getNotes();
        }
        else
        {
            notes = noteMapper.getNotesByCondition(title);
        }
        return notes;
    }

    @Override
    public Note getNoteById(String noteId)
    {
        if(StringUtils.isEmpty(noteId))
        {
            return null;
        }

        Note note = noteMapper.getNoteById(noteId);

        return note;
    }

    @Override
    public List<Note> getNotePagination(String title, Integer pageCode, Integer pageSize)
    {
        List<Note> notes = noteMapper.getNotePagination(title, pageCode, pageSize);
        return notes;
    }

    @Override
    public void assembleNote(Note note)
    {
        //  组装笔记内容
        NoteContent content = noteContentMapper.getContentByContId(note.getNoteCont());
        note.setNoteContent(content);

        //  组装笔记分类
        Map<String, NoteCategory> cateMap = new HashMap<>();
        List<String> cates = String2List(note.getNoteCate());
        List<NoteCategory> categorys = noteCategoryMapper.getCategoryByCates(cates);
        for (NoteCategory category: categorys)
        {
            cateMap.put(category.getCateCode(), category);
        }
        note.setNoteCategory(cateMap);

        //  组装笔记评论
        List<NoteComment> comments = noteCommentMapper.getCommentByNoteId(note.getId());
        note.setComments(comments);

        //  组装点赞量
        NoteStar star = noteStarMapper.getStarByNoteId(note.getId());
        note.setNoteStar(star);
    }

    @Override
    public Integer addNote(Note note)
    {
        if(ObjectUtils.isEmpty(note))
        {
            return ProjectConstant.ZERO_CONSTANT.intValue();
        }
        Integer row = noteMapper.addNote(note);
        return row;
    }

    @Override
    public Integer addNoteContent(NoteContent content)
    {
        if(ObjectUtils.isEmpty(content))
        {
            return ProjectConstant.ZERO_CONSTANT.intValue();
        }
        Integer row = noteContentMapper.addNoteContent(content);
        return row;
    }


    public static List<String> String2List(String str)
    {
        List<String> strs = new ArrayList<>();

        String[] strings = str.split(",");
        for (String s : strings) {
            strs.add(s);
        }
        return strs;
    }
}
