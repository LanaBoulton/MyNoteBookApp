package com.mywebnotebook.notebook.service;

import com.mywebnotebook.notebook.dto.NoteDto;

import java.util.List;

public interface NoteService {
  List<NoteDto> findAllNotes();

  void createNote(NoteDto noteDto);

  NoteDto findNoteById(Long noteId);

  void updateNote (NoteDto noteDto);

  void deleteNote(Long noteId);

  NoteDto findNoteByUrl(String noteUrl);

  List<NoteDto> searchNotes(String query);
}