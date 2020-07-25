package com.xnote.client.module.note.mapper;

import com.xnote.client.module.note.bean.NoteComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoteCommentMapper {

    public List<NoteComment> getCommentByNoteId(String noteId);

    public List<NoteComment> getCommentByCommCId(String commCId);










    int deleteByPrimaryKey(String commId);
    int insert(NoteComment record);
    int insertSelective(NoteComment record);
    NoteComment selectByPrimaryKey(String commId);
    int updateByPrimaryKeySelective(NoteComment record);
    int updateByPrimaryKeyWithBLOBs(NoteComment record);
    int updateByPrimaryKey(NoteComment record);
}