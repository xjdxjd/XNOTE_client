package com.xnote.client.module.note.service.impl;

import com.xnote.client.module.note.bean.NoteComment;
import com.xnote.client.module.note.mapper.NoteCommentMapper;
import com.xnote.client.module.note.service.NoteCommentService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoteCommentServiceImpl implements NoteCommentService
{

    @Resource
    private NoteCommentMapper noteCommentMapper;

    @Override
    public Integer addCommentByNoteId(NoteComment noteComment)
    {
        if(ObjectUtils.isEmpty(noteComment) || StringUtils.isEmpty(noteComment.getId()))
        {
            return 0;
        }

        Integer row = noteCommentMapper.addCommentByNoteId(noteComment);
        return row;
    }

    @Override
    public List<NoteComment> getCommentByNoteId(String noteId)
    {
        if(StringUtils.isEmpty(noteId))
        {
            return null;
        }

        List<NoteComment> comments = noteCommentMapper.getCommentByNoteId(noteId);
        return comments;
    }
}
