package com.example.lms.mapper;


import com.example.lms.dto.BookResponse;
import com.example.lms.model.Book;

import java.util.stream.Collectors;

public class BookMapper {
    public static BookResponse toResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .publicationYear(book.getPublicationYear())
                .edition(book.getEdition())
                .summary(book.getSummary())
                .coverImageUrl(book.getCoverImageUrl())
                .authors(book.getAuthors().stream()
                        .map(a -> a.getName())
                        .collect(Collectors.toSet()))
                .categories(book.getCategories().stream()
                        .map(c -> c.getName())
                        .collect(Collectors.toSet()))
                .publisher(book.getPublisher() != null ? book.getPublisher().getName() : null)
                .build();
    }
}
