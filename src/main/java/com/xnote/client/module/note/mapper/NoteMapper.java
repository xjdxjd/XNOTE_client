package com.xnote.client.module.note.mapper;

import com.xnote.client.module.note.bean.Note;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 笔记bean映射类
 */
@Mapper
public interface NoteMapper {

    /**
     * 查询全部笔记数
     * @return
     */
    public Integer getNotesCount(@Param("title") String title);

    /**
     * 查询全部笔记
     * @return
     */
    public List<Note> getNotes();

    /**
     * 根据标题进行模糊查询
     * @param title
     * @return
     */
    List<Note> getNotesByCondition(@Param("title") String title);

    /**
     * 根据ID查询笔记
     * @param noteId
     * @return
     */
    public Note getNoteById(String noteId);

    /**
     * 组装笔记的属性
     * @param pageCode
     * @param pageSize
     * @return
     */
    List<Note> getNotePagination(@Param("title") String title, @Param("code") Integer pageCode, @Param("size") Integer pageSize);

    /**
     * 添加笔记
     * @param note
     * @return
     */
    Integer addNote(Note note);












    int deleteByPrimaryKey(String noteId);
    int insert(Note record);
    int insertSelective(Note record);
    Note selectByPrimaryKey(String noteId);
    int updateByPrimaryKeySelective(Note record);
    int updateByPrimaryKey(Note record);

}