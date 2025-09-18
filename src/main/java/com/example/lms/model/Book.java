package com.example.lms.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // عنوان الكتاب
    @Column(nullable = false)
    private String title;

    // رقم ISBN مميز
    @Column(unique = true, nullable = false, length = 20)
    private String isbn;

    // سنة النشر
    @Column(name = "publication_year")
    private Integer publicationYear;

    // رقم الطبعة
    private String edition;

    // ملخص الكتاب
    @Column(columnDefinition = "TEXT")
    private String summary;

    // لينك لصورة الغلاف
    private String coverImageUrl;

    // Book ↔ Authors (Many-to-Many)
    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    // Book ↔ Categories (Many-to-Many)
    @ManyToMany
    @JoinTable(
            name = "book_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    // Book ↔ Publisher (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
