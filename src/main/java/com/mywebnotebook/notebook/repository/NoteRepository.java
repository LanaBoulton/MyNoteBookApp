package com.mywebnotebook.notebook.repository;

import com.mywebnotebook.notebook.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

//Note - entity type
//Long -data type of the primary key
public interface NoteRepository extends JpaRepository <Note, Long> {
    Optional<Note> findByUrl(String url); //query(finder) method in spring data JPA
    @Query("Select n from Note n WHERE n.title LIKE CONCAT('%', :query, '%') OR " +
            "n.shortDescription LIKE CONCAT('%', :query, '%')")
    List<Note> searchNotes(String query);
}
