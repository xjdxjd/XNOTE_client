package com.xnote.client.module.note.mapper;

import com.xnote.client.module.note.bean.Note;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 笔记bean映射类
 */
@Mapper
public interface NoteMapper {

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















    int deleteByPrimaryKey(String noteId);
    int insert(Note record);
    int insertSelective(Note record);
    Note selectByPrimaryKey(String noteId);
    int updateByPrimaryKeySelective(Note record);
    int updateByPrimaryKey(Note record);
}