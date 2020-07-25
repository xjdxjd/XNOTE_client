package main.java.com.xnote.client.module.note.bean;

public class NoteContent {
    private String centId;

    private String noteId;

    private String noteContext;

    public String getCentId() {
        return centId;
    }

    public void setCentId(String centId) {
        this.centId = centId == null ? null : centId.trim();
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId == null ? null : noteId.trim();
    }

    public String getNoteContext() {
        return noteContext;
    }

    public void setNoteContext(String noteContext) {
        this.noteContext = noteContext == null ? null : noteContext.trim();
    }
}