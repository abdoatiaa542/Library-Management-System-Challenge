package com.example.lms.service;

import com.example.lms.dto.ApiResponse;
import com.example.lms.dto.BorrowRequest;

public interface BorrowingTransactionService {
    ApiResponse borrowBook(BorrowRequest request);
    ApiResponse returnBook(Long transactionId);
    ApiResponse getAllTransactions();
    ApiResponse getTransactionById(Long id);
}