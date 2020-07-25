package main.java.com.xnote.client.module.note.mapper;

import main.java.com.xnote.client.module.note.bean.NoteStar;

public interface NoteStarMapper {
    int deleteByPrimaryKey(String starId);

    int insert(NoteStar record);

    int insertSelective(NoteStar record);

    NoteStar selectByPrimaryKey(String starId);

    int updateByPrimaryKeySelective(NoteStar record);

    int updateByPrimaryKey(NoteStar record);
}