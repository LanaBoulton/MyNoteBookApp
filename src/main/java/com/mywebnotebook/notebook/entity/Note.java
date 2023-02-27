package com.mywebnotebook.notebook.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // - column is not null
    private String title;
    private String url;

    @Column(nullable = false, columnDefinition = "longtext") // allow big text inside
    private String content;
    private String shortDescription;

    @CreationTimestamp //help automatically populate the value for this field
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @OneToMany(mappedBy = "note", cascade = CascadeType.REMOVE) //if note deleted, hibernate will delete it automatically
    private Set<Comment> comments = new HashSet<>();
}
