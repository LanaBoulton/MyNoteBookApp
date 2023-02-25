package com.mywebnotebook.notebook.service;

import com.mywebnotebook.notebook.dto.NoteDto;

import java.util.List;

public interface NoteService {
  List<NoteDto> findAllNotes();
}