package com.mywebnotebook.notebook.repository;

import com.mywebnotebook.notebook.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Note - entity type
//Long -data type of the primary key
public interface NoteRepository extends JpaRepository <Note, Long> {
    Optional<Note> findByUrl(String url); //query(finder) methd in spring data JPA
}
