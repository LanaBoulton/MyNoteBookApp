package com.mywebnotebook.notebook.controller;

import com.mywebnotebook.notebook.dto.NoteDto;
import com.mywebnotebook.notebook.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    //create handler method, GET request and return model and view
    //http://localhost:8080//admin/notes
    @GetMapping("/admin/notes")
    public String notes(Model model) {
        List<NoteDto> notes = noteService.findAllNotes();
        model.addAttribute("notes", notes);
        return "/admin/notes";
    }
}
