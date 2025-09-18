package com.example.lms.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // اسم المؤلف
    @Column(nullable = false)
    private String name;

    // سيرة قصيرة
    @Column(columnDefinition = "TEXT")
    private String biography;
}