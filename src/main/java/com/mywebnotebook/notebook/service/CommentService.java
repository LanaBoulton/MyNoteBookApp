package com.mywebnotebook.notebook.service;

import com.mywebnotebook.notebook.dto.CommentDto;

public interface CommentService {
    void createComment(String noteUrl, CommentDto commentDto);
}
