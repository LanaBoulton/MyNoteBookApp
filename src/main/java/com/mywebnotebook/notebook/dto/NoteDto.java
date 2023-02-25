package com.mywebnotebook.notebook.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder //to generate builder pattern for this class
//Post DTO will be used to transfer data between view and controller layer
//acts as a Model in spring MVC web application
//HTML form will use this model to bind form data
//controller will use it to send data to the view
public class NoteDto {
    private Long id;
    private String title;
    private String url;
    private String content;
    private String shortDescription;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
