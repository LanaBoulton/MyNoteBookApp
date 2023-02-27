package com.mywebnotebook.notebook.repository;

import com.mywebnotebook.notebook.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
