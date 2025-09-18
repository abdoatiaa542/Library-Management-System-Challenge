package com.example.lms.dto;


import lombok.Builder;

import java.util.Set;

@Builder
public record BookResponse(
        Long id,
        String title,
        String isbn,
        Integer publicationYear,
        String edition,
        String summary,
        String coverImageUrl,
        Set<String> authors,
        Set<String> categories,
        String publisher
) {}
