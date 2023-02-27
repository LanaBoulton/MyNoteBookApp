package com.mywebnotebook.notebook.service.impl;

import com.mywebnotebook.notebook.dto.CommentDto;
import com.mywebnotebook.notebook.entity.Comment;
import com.mywebnotebook.notebook.entity.Note;
import com.mywebnotebook.notebook.mapper.CommentMapper;
import com.mywebnotebook.notebook.repository.CommentRepository;
import com.mywebnotebook.notebook.repository.NoteRepository;
import com.mywebnotebook.notebook.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImplementation implements CommentService {

    //injecting dependencies
    private CommentRepository commentRepository;
    private NoteRepository noteRepository;

    public CommentServiceImplementation(CommentRepository commentRepository, NoteRepository noteRepository) {
        this.commentRepository = commentRepository;
        this.noteRepository = noteRepository;
    }

    @Override
    public void createComment(String noteUrl, CommentDto commentDto) {

        Note note =noteRepository.findByUrl(noteUrl).get();
        Comment comment = CommentMapper.mapToComment(commentDto);
        comment.setNote(note);
        commentRepository.save(comment);

    }
}
