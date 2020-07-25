package com.xnote.client.module.note.mapper;

import com.xnote.client.module.note.bean.NoteCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoteCategoryMapper
{
    public List<NoteCategory> getCategoryByCates(List<String> cates);




















    int insert(NoteCategory record);
    int insertSelective(NoteCategory record);
}