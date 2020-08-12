package com.xnote.client.common.utils.Note;

import com.xnote.client.common.utils.common.DateUtils;
import com.xnote.client.common.utils.common.UUIDUtils;
import com.xnote.client.core.constant.ProjectConstant;
import com.xnote.client.module.note.bean.Note;
import com.xnote.client.module.note.bean.NoteCategory;
import com.xnote.client.module.note.bean.NoteContent;
import com.xnote.client.module.note.bean.NoteStar;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.util.StringUtils;

/**
 * 笔记工具类
 */
public class NoteUtils
{
    /**
     * 组装笔记类
     * @param note
     * @return
     */
    public static Note assembleNote(Note note)
    {
        if(StringUtils.isEmpty(note.getId())){
            note.setId(UUIDUtils.getUUID());
        }

        if(StringUtils.isEmpty(note.getNoteCont())){
            note.setNoteCont(UUIDUtils.getUUID());
        }

        if(ObjectUtils.isEmpty(note.getCreateTime())){
            note.setCreateTime(DateUtils.getNowDate());
        }

        if(ObjectUtils.isEmpty(note.getUpdateTime())){
            note.setUpdateTime(DateUtils.getNowDate());
        }

        if(ObjectUtils.isEmpty(note.getTimestamp())){
            note.setTimestamp(DateUtils.getTimeStamp());
        }
        return note;
    }

    /**
     * 组装笔记内容类
     * @param contentId
     * @param noteId
     * @param content
     * @return
     */
    public static NoteContent assembleNoteContent(String contentId, String noteId, NoteContent content)
    {
        if(StringUtils.isEmpty(contentId)){
            return null;
        }

        if(StringUtils.isEmpty(noteId)){
            return null;
        }

        if(StringUtils.isEmpty(content.getId())){
            content.setId(contentId);
        }

        if(StringUtils.isEmpty(content.getNoteId())){
            content.setNoteId(noteId);
        }

        return content;
    }

    /**
     * 组装笔记点赞类
     * @param noteId
     * @param star
     * @return
     */
    public static NoteStar assembleNoteStar(String noteId, NoteStar star)
    {
        if(StringUtils.isEmpty(noteId)){
            return null;
        }

        if(StringUtils.isEmpty(star.getId())){
            star.setId(UUIDUtils.getUUID());
        }

        if(StringUtils.isEmpty(star.getNoteId())){
            star.setNoteId(noteId);
        }

        if(ObjectUtils.isEmpty(star.getNoteStar())){
            star.setNoteStar(ProjectConstant.ZERO_CONSTANT.code());
        }

        if(ObjectUtils.isEmpty(star.getUpdateTime())){
            star.setUpdateTime(DateUtils.getNowDate());
        }

        if(ObjectUtils.isEmpty(star.getUpdateTimestamp())){
            star.setUpdateTimestamp(DateUtils.getTimeStamp());
        }

        return star;
    }

    /**
     * 组装笔记分类bean
     * @param category
     * @return
     */
    public static NoteCategory assembleNoteCate(NoteCategory category)
    {
        if(StringUtils.isEmpty(category.getId())){
            category.setId(UUIDUtils.getUUID());
        }

        if(ObjectUtils.isEmpty(category.getCreateTime())){
            category.setCreateTime(DateUtils.getNowDate());
        }

        if(ObjectUtils.isEmpty(category.getUpdateTime())){
            category.setUpdateTime(DateUtils.getNowDate());
        }

        if(ObjectUtils.isEmpty(category.getTimestamp())){
            category.setTimestamp(DateUtils.getTimeStamp());
        }

        return category;
    }
}