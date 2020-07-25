package com.xnote.client.module.note.service;


import com.xnote.client.module.note.bean.NoteComment;

import java.util.List;

public interface NoteCommentService
{
    /**
     * 添加笔记评论
     * @param noteComment
     * @return
     */
    public Integer addCommentByNoteId(NoteComment noteComment);

    /**
     * 根据noteId获取文章全部评论
     * @param noteId
     * @return
     */
    public List<NoteComment> getCommentByNoteId(String noteId);
}
