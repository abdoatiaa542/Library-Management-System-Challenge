package com.example.lms.controller;

import com.example.lms.dto.BookRequest;
import com.example.lms.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','LIBRARIAN')")
    public ResponseEntity<?> addBook(@RequestBody BookRequest request) {
        log.info("Adding new book: {}", request.getTitle());
        return ResponseEntity.ok(bookService.addBook(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        log.info("Fetching all books");
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        log.info("Fetching book with ID: {}", id);
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','LIBRARIAN')")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookRequest request) {
        log.info("Updating book with ID: {}", id);
        return ResponseEntity.ok(bookService.updateBook(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','LIBRARIAN')")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        log.info("Deleting book with ID: {}", id);
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
}
