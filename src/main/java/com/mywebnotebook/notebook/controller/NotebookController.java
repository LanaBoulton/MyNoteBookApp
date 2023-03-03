package com.mywebnotebook.notebook.controller;

import com.mywebnotebook.notebook.dto.CommentDto;
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

    //starter page
    //http://localhost:8080/
    @GetMapping("/")
    public String welcome() {
        return "welcome_page";
    }

    //search page
    //http://localhost:8080/search
    @GetMapping("/search")
    public String guestSearch() {
        return "notebook/search";
    }

    //view all notes from visitor side
    //anybody can see it
    //http://localhost:8080/main
    @GetMapping("/main")
    public String viewNotebookNotes(Model model) {
        List<NoteDto> notesResponse = noteService.findAllNotes();
        model.addAttribute("notesResponse", notesResponse);
        return "notebook/view_notes";
    }

    //view post request
    //http://localhost:8080/note/name-of-the-note
    @GetMapping("/note/{noteUrl}")
    private String showNote(@PathVariable("noteUrl") String noteUrl,
                            Model model) {
        NoteDto noteDto = noteService.findNoteByUrl(noteUrl);
        //adding comment section
        CommentDto commentDto = new CommentDto();
        model.addAttribute("comment", commentDto);
        //
        model.addAttribute("note", noteDto);
        return "notebook/notebook_note";
    }

    //notebook search request for visitor
    //localhost:8080/page/search?query=java
    @GetMapping("/page/search")
    public String searchNotes(@RequestParam(value = "query") String query,
                              Model model) {
        List<NoteDto> notesResponse = noteService.searchNotes(query);
        model.addAttribute("notesResponse", notesResponse);
        return "notebook/view_notes";
    }
}