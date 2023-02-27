package com.mywebnotebook.notebook.mapper;

import com.mywebnotebook.notebook.dto.NoteDto;
import com.mywebnotebook.notebook.entity.Note;

public class NoteMapper {
    //make static so we don't need to create an object of NoteMapper class,
    //we will just simply use a class name to call static methods
    //map Note entity to PostDto

    public static NoteDto mapToNoteDto(Note note){
        return NoteDto.builder()
                .id(note.getId())
                .title(note.getTitle())
                .url(note.getUrl())
                .content(note.getContent())
                .shortDescription(note.getShortDescription())
                .createdOn(note.getCreatedOn())
                .updatedOn(note.getUpdatedOn())
                .build();
//        NoteDto noteDto = NoteDto.builder().
//                id(note.getId())
//                .title(note.getTitle())
//                .content(note.getContent())
//                .shortDescription(note.getShortDescription())
//                .createdOn(note.getCreatedOn())
//                .updatedOn(note.getUpdatedOn())
//                .build();
//        return noteDto;
    }

    //map NoteDto to Note Entity
    public static Note mapToNote(NoteDto noteDto){
        return Note.builder().
                id(noteDto.getId())
                .title(noteDto.getTitle())
                .content(noteDto.getContent())
                .url(noteDto.getUrl())
                .shortDescription(noteDto.getShortDescription())
                .createdOn(noteDto.getCreatedOn())
                .updatedOn(noteDto.getUpdatedOn())
                .build();
    }
}
