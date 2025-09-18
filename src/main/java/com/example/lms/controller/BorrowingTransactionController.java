package com.example.lms.controller;


import com.example.lms.dto.BorrowRequest;
import com.example.lms.model.*;
import com.example.lms.service.BorrowingTransactionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class BorrowingTransactionController {

    private final BorrowingTransactionService transactionService;
    private static final Logger log = LoggerFactory.getLogger(BorrowingTransactionController.class);

    @PostMapping("/borrow")
    @PreAuthorize("hasRole('MEMBER')")
    public ResponseEntity<?> borrowBook(@RequestBody BorrowRequest request) {
        log.info("Member {} borrowing book ID: {}", request.memberId(), request.bookId());
        return ResponseEntity.ok(transactionService.borrowBook(request));
    }

    @PostMapping("/return/{id}")
    @PreAuthorize("hasRole('MEMBER')")
    public ResponseEntity<?> returnBook(@PathVariable Long id) {
        log.info("Returning transaction ID: {}", id);
        return ResponseEntity.ok(transactionService.returnBook(id));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','LIBRARIAN','STAFF')")
    public ResponseEntity<?> getAllTransactions() {
        log.info("Fetching all borrowing transactions");
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','LIBRARIAN','STAFF','MEMBER')")
    public ResponseEntity<?> getTransactionById(@PathVariable Long id) {
        log.info("Fetching transaction with ID: {}", id);
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }
}
