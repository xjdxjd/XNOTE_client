package com.xnote.client.module.note.mapper;

import com.xnote.client.module.note.bean.NoteContent;
import com.xnote.client.module.note.bean.NoteStar;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoteContentMapper
{
    public NoteContent getContentByContId(String contId);

    public NoteContent getContentByNoteId(String noteId);




















    int deleteByPrimaryKey(String centId);
    int insert(NoteContent record);
    int insertSelective(NoteContent record);
    NoteContent selectByPrimaryKey(String centId);
    int updateByPrimaryKeySelective(NoteContent record);
    int updateByPrimaryKeyWithBLOBs(NoteContent record);
    int updateByPrimaryKey(NoteContent record);
}