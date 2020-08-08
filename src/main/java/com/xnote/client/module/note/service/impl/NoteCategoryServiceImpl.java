package com.xnote.client.module.note.service.impl;

import com.xnote.client.module.note.bean.NoteCategory;
import com.xnote.client.module.note.mapper.NoteCategoryMapper;
import com.xnote.client.module.note.service.NoteCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoteCategoryServiceImpl implements NoteCategoryService
{
    @Resource
    private NoteCategoryMapper noteCategoryMapper;

    @Override
    public List<NoteCategory> getNoteCategory()
    {
        List<NoteCategory> cates = noteCategoryMapper.getNoteCategory();
        if(CollectionUtils.isEmpty(cates))
        {
            return null;
        }
        return cates;
    }
}
