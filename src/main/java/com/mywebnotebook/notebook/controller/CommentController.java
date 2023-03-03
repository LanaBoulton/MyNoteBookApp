package com.mywebnotebook.notebook.controller;

import com.mywebnotebook.notebook.dto.CommentDto;
import com.mywebnotebook.notebook.dto.NoteDto;
import com.mywebnotebook.notebook.service.CommentService;
import com.mywebnotebook.notebook.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    private CommentService commentService;
    private NoteService noteService;

    public CommentController(CommentService commentService, NoteService noteService) {
        this.noteService = noteService;
        this.commentService = commentService;
    }

    //create form submit request
    @PostMapping("/{noteUrl}/comments")
    public String createComment(@PathVariable("noteUrl") String noteUrl,
                                @Valid @ModelAttribute("comment") CommentDto commentDto,
                                BindingResult result,
                                Model model){
        NoteDto noteDto = noteService.findNoteByUrl(noteUrl);
        if(result.hasErrors()){
            model.addAttribute("note", noteDto);
            model.addAttribute("comment", commentDto);
            return "notebook/notebook_note";
        }
        commentService.createComment(noteUrl, commentDto);
        return "redirect:/note/"+noteUrl;

    }
}
