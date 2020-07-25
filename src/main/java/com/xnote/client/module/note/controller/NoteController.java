package com.xnote.client.module.note.controller;

import com.xnote.client.common.controller.BaseController;
import com.xnote.client.module.note.bean.Note;
import com.xnote.client.module.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class NoteController extends BaseController
{
    @Autowired
    private NoteService noteService;

    @GetMapping({"/","/index","/index.html"})
    public String index(Model model)
    {
        List<Note> notes = noteService.getAllNotes();
        model.addAttribute("notes", notes);

        return "index";
    }

    @GetMapping("/note/details/{noteId}")
    public String noteDescribe(Model model, @PathVariable("noteId") String noteId)
    {
        Note note = noteService.getNoteById(noteId);
        model.addAttribute("note", note);

        return DETAILS_PATH + "details";
    }

}
