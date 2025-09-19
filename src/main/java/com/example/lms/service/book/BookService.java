package com.example.lms.service.book;


import com.example.lms.dto.ApiResponse;
import com.example.lms.dto.BookRequest;

public interface BookService {
    ApiResponse addBook(BookRequest request);

    ApiResponse getAllBooks();

    ApiResponse getBookById(Long id);

    ApiResponse updateBook(Long id, BookRequest request);

    ApiResponse deleteBook(Long id);
}
