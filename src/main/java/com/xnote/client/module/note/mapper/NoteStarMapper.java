package com.xnote.client.module.note.mapper;

import com.xnote.client.module.note.bean.NoteStar;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoteStarMapper
{
    public NoteStar getStarByNoteId(String noteId);

    public Integer updateStarByNoteId(NoteStar noteStar);











    int deleteByPrimaryKey(String starId);
    int insert(NoteStar record);
    int insertSelective(NoteStar record);
    NoteStar selectByPrimaryKey(String starId);
    int updateByPrimaryKeySelective(NoteStar record);
    int updateByPrimaryKey(NoteStar record);

}