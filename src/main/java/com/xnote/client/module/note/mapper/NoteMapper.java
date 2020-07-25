package main.java.com.xnote.client.module.note.mapper;

import main.java.com.xnote.client.module.note.bean.Note;

public interface NoteMapper {
    int deleteByPrimaryKey(String noteId);

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(String noteId);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);
}