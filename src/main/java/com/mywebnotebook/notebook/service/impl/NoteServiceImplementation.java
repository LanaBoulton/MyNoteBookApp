package com.mywebnotebook.notebook.service.impl;

import com.mywebnotebook.notebook.dto.NoteDto;
import com.mywebnotebook.notebook.entity.Note;
import com.mywebnotebook.notebook.mapper.NoteMapper;
import com.mywebnotebook.notebook.repository.NoteRepository;
import com.mywebnotebook.notebook.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/* this service layer created for retrieving a list of posts from dara base table */
@Service //this class registered as a spring bean to the application context
public class NoteServiceImplementation implements NoteService {

    //creating instance variable
    private NoteRepository noteRepository;

    //creating constructor
    //omitting @Autowired annotation because we have only one constructor
    public NoteServiceImplementation(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<NoteDto> findAllNotes() {
        List<Note> notes = noteRepository.findAll();
        return notes.stream().map(NoteMapper::mapToNoteDto)
                .collect(Collectors.toList());
        //implementing the logic to convert the list of JPA entities to list of DTOs

    }

    @Override
    public void createNote(NoteDto noteDto) {
        Note note = NoteMapper.mapToNote(noteDto);
        noteRepository.save(note);
    }

    @Override
    public NoteDto findNoteById(Long noteId) {
        Note note = noteRepository.findById(noteId).get();
        return NoteMapper.mapToNoteDto(note);
    }

    @Override
    public void updateNote(NoteDto noteDto) {
        Note note = NoteMapper.mapToNote(noteDto);
        noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }

    @Override
    public NoteDto findNoteByUrl(String noteUrl) {
        Note note = noteRepository.findByUrl(noteUrl).get();
        return NoteMapper.mapToNoteDto(note);
    }

    @Override
    public List<NoteDto> searchNotes(String query) {
        List<Note> notes = noteRepository.searchNotes(query);
        return notes.stream()
                .map(NoteMapper::mapToNoteDto)
                .collect(Collectors.toList());
    }
}
