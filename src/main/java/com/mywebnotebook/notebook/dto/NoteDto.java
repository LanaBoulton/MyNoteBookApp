package com.mywebnotebook.notebook.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder //to generate builder pattern for this class
@NoArgsConstructor
@AllArgsConstructor
//Post DTO will be used to transfer data between view and controller layer
//acts as a Model in spring MVC web application
//HTML form will use this model to bind form data
//controller will use it to send data to the view
public class NoteDto {
    private Long id;
    @NotEmpty(message = "Note title should not be empty")
    private String title;
    private String url;
    @NotEmpty(message = "Note content should not be empty")
    private String content;
    @NotEmpty(message = "Note content should not be empty")
    private String shortDescription;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
