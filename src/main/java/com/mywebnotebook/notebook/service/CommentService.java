package com.mywebnotebook.notebook.service;

import com.mywebnotebook.notebook.dto.CommentDto;

import java.util.List;

public interface CommentService {
    void createComment(String noteUrl, CommentDto commentDto);

    List<CommentDto> findAllComments();

    void deleteComment(Long commentId);
}
