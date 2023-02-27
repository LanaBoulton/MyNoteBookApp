package com.mywebnotebook.notebook.controller;

import com.mywebnotebook.notebook.dto.NoteDto;
import com.mywebnotebook.notebook.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    //handler method to handle new note request
    @GetMapping("/admin/notes/newnote")
    public String newNoteForm (Model model) {
        NoteDto noteDto = new NoteDto();
        model.addAttribute("note", noteDto);
        return "admin/create_note";
    }


    //handler method to handle form submit
    @PostMapping("/admin/notes")
    public String createNote(@Valid @ModelAttribute("note") NoteDto noteDto,
                             BindingResult result,
                             Model model){
        if (result.hasErrors()){
            model.addAttribute("note", noteDto);
            return "admin/create_note";
        }
        noteDto.setUrl(getUrl(noteDto.getTitle()));
        noteService.createNote(noteDto);
        return "redirect:/admin/notes";
    }
    //handler method to handle edit post request
    @GetMapping("/admin/notes/{noteId}/edit")
    public String editNoteForm(@PathVariable("noteId") Long noteId, Model model){
        NoteDto noteDto = noteService.findNoteById(noteId);
        model.addAttribute("note", noteDto);
        return "admin/edit_note";
    }

    //handler method to handle edit post form submit request
    @PostMapping("/admin/notes/{noteId}")
    public String updateNote(@PathVariable("noteId") Long noteId,
                             @Valid @ModelAttribute("note") NoteDto noteDto,
                             BindingResult result,
                             Model model){
        if (result.hasErrors()){
            model.addAttribute("note", noteDto);
            return "admin/edit_note";
        }
        noteDto.setId(noteId);
        noteService.updateNote(noteDto);
        return "redirect:/admin/notes";
    }

    //handler method to handle delete note request
    @GetMapping("/admin/notes/{noteId}/delete")
    public String deleteNote(@PathVariable("noteId") Long noteId){
        noteService.deleteNote(noteId);
        return "redirect:/admin/notes";
    }

    //handler method to handle view note request
    @GetMapping("/admin/notes/{noteUrl}/view")
    public String viewNote(@PathVariable("noteUrl") String noteUrl,
                           Model model){
        NoteDto noteDto = noteService.findNoteByUrl(noteUrl);
        model.addAttribute("note", noteDto);
        return "admin/view_note";
    }

    //handler method to handle search notes
    //localhost:8080/admin/posts/search?query=java
    @GetMapping("/admin/notes/search")
    public String searchNotes(@RequestParam(value = "query") String query,
                              Model model){
        List<NoteDto> notes = noteService.searchNotes(query);
        model.addAttribute("notes", notes);
        return "admin/notes";
    }
    private static String getUrl (String noteTitle){
        //Today's Lecture
        //to convert to url style like:
        //today-s-lecture
        String title = noteTitle.trim().toLowerCase();
        String url = title.replaceAll("\\s+", "-"); //replace all spaces with "-"
        url=url.replaceAll("[^A-Za-z0-9]", "-");//replace all symbols with "-"
        return url;
    }
}
