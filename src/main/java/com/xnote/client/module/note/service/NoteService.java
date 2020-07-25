package com.xnote.client.module.note.service;

import com.xnote.client.module.note.bean.Note;

import java.util.List;

public interface NoteService
{
    /**
     * 查询全部笔记
     * @return
     */
    public List<Note> getAllNotes();

    /**
     * 根据ID查询笔记
     * @param noteId
     * @return
     */
    public Note getNoteById(String noteId);
}
