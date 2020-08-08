package com.xnote.client.note;


import com.xnote.client.module.login.service.LoginService;
import com.xnote.client.module.note.bean.Note;
import com.xnote.client.module.note.service.NoteService;
import com.xnote.client.module.user.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NoteTest
{

    @Autowired
    private NoteService noteService;

    @Test
    public void getAllNotes()
    {
        System.out.println("===================================================================================");

        List<Note> notes = noteService.getNotes("sss");
        for (Note note : notes) {
            System.out.println(note.getNoteTitle());
        }

        System.out.println("===================================================================================");
    }

    @Test
    public void getNotePagination()
    {
        System.out.println("===================================================================================");

        List<Note> notes = noteService.getNotePagination("sss",0,10);
        for (Note note : notes) {
            System.out.println(note.getNoteTitle());
        }

        System.out.println("===================================================================================");
    }
}
