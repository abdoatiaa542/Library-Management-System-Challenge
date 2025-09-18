package com.example.lms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BookRequest {
    private String title;
    private String isbn;
    private Integer publicationYear;
    private String edition;
    private String summary;
    private String coverImageUrl;
    private Set<Long> authorIds;
    private Set<Long> categoryIds;
    private Long publisherId;
}