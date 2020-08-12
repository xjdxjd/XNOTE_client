package com.xnote.client.module.note.service.impl;


import com.xnote.client.core.constant.ProjectConstant;
import com.xnote.client.module.note.bean.Note;
import com.xnote.client.module.note.bean.NoteStar;
import com.xnote.client.module.note.mapper.NoteStarMapper;
import com.xnote.client.module.note.service.NoteStarService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class NoteStarServiceImpl implements NoteStarService
{
    @Resource
    private NoteStarMapper noteStarMapper;

    @Override
    public NoteStar getLikeByNoteId(String noteId)
    {
        if (StringUtils.isEmpty(noteId))
        {
            return null;
        }

        NoteStar noteStar = noteStarMapper.getStarByNoteId(noteId);
        return noteStar;
    }

    @Override
    public Integer updateLikeByNoteId(NoteStar noteStar)
    {
        if (ObjectUtils.isEmpty(noteStar) || StringUtils.isEmpty(noteStar.getNoteId()))
        {
            return 0;
        }

        Integer row = noteStarMapper.updateStarByNoteId(noteStar);
        return row;
    }

    @Override
    public Integer addNoteStar(NoteStar star)
    {
        if(ObjectUtils.isEmpty(star))
        {
            return ProjectConstant.ZERO_CONSTANT.code();
        }
        Integer row = noteStarMapper.addNoteStar(star);
        return row;
    }
}
