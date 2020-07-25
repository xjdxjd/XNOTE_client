package com.xnote.client.module.note.service;

import com.xnote.client.common.controller.BaseController;
import com.xnote.client.module.note.bean.Note;
import com.xnote.client.module.note.bean.NoteStar;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface NoteStarService
{
    public NoteStar getLikeByNoteId(String noteId);

    public Integer updateLikeByNoteId(NoteStar noteStar);
}
