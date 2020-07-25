package main.java.com.xnote.client.module.note.mapper;

import main.java.com.xnote.client.module.note.bean.NoteCategory;

public interface NoteCategoryMapper {
    int insert(NoteCategory record);

    int insertSelective(NoteCategory record);
}