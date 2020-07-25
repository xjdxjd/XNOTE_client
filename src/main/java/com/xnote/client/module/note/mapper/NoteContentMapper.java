package main.java.com.xnote.client.module.note.mapper;

import main.java.com.xnote.client.module.note.bean.NoteContent;

public interface NoteContentMapper {
    int deleteByPrimaryKey(String centId);

    int insert(NoteContent record);

    int insertSelective(NoteContent record);

    NoteContent selectByPrimaryKey(String centId);

    int updateByPrimaryKeySelective(NoteContent record);

    int updateByPrimaryKeyWithBLOBs(NoteContent record);

    int updateByPrimaryKey(NoteContent record);
}