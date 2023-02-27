package com.mywebnotebook.notebook.controller;

import com.mywebnotebook.notebook.dto.NoteDto;
import com.mywebnotebook.notebook.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NotebookController {
    private NoteService noteService;

    public NotebookController(NoteService noteService) {
        this.noteService = noteService;
    }

    //handler method to handle http://localhost:8080/
    @GetMapping("/")
    public String viewNotebookNotes(Model model) {
        List<NoteDto> notesResponse = noteService.findAllNotes();
        model.addAttribute("notesResponse", notesResponse);
        return "notebook/view_notes";
    }

    //handler method to handle view post request
    //http://localhost:8080/note/name-of-the-note
    @GetMapping("/note/{noteUrl}")
    private String showNote(@PathVariable("noteUrl") String noteUrl,
                            Model model) {
        NoteDto noteDto = noteService.findNoteByUrl(noteUrl);
        model.addAttribute("note", noteDto);
        return "notebook/notebook_note";
    }

    //handler method to handle notebook search request
    //localhost:8080/page/search?query=java
    @GetMapping("/page/search")
    public String searchNotes(@RequestParam(value = "query") String query,
                              Model model) {
        List<NoteDto> notesResponse = noteService.searchNotes(query);
        model.addAttribute("notesResponse", notesResponse);
        return "notebook/view_notes";
    }
}