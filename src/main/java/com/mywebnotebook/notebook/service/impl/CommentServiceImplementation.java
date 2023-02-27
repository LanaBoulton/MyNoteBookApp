package com.mywebnotebook.notebook.service.impl;

import com.mywebnotebook.notebook.dto.CommentDto;
import com.mywebnotebook.notebook.entity.Comment;
import com.mywebnotebook.notebook.entity.Note;
import com.mywebnotebook.notebook.mapper.CommentMapper;
import com.mywebnotebook.notebook.repository.CommentRepository;
import com.mywebnotebook.notebook.repository.NoteRepository;
import com.mywebnotebook.notebook.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<CommentDto> findAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(CommentMapper::mapToCommentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
