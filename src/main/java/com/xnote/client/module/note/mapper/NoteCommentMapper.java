package main.java.com.xnote.client.module.note.mapper;

import main.java.com.xnote.client.module.note.bean.NoteComment;

public interface NoteCommentMapper {
    int deleteByPrimaryKey(String commId);

    int insert(NoteComment record);

    int insertSelective(NoteComment record);

    NoteComment selectByPrimaryKey(String commId);

    int updateByPrimaryKeySelective(NoteComment record);

    int updateByPrimaryKeyWithBLOBs(NoteComment record);

    int updateByPrimaryKey(NoteComment record);
}