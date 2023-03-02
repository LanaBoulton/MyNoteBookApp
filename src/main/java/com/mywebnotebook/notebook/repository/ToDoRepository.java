package com.mywebnotebook.notebook.repository;

import com.mywebnotebook.notebook.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository <ToDo, Long> {
}
