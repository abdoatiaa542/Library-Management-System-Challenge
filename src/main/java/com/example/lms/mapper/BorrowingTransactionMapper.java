package com.example.lms.mapper;

import com.example.lms.dto.BorrowResponse;
import com.example.lms.model.BorrowingTransaction;

public class BorrowingTransactionMapper {

    public static BorrowResponse toResponse(BorrowingTransaction tx) {
        return new BorrowResponse(
                tx.getId(),
                tx.getBook().getId(),
                tx.getBook().getTitle(),
                tx.getMember().getId(),
                tx.getMember().getFullName(),
                tx.getProcessedBy().getId(),
                tx.getProcessedBy().getUsername(),
                tx.getBorrowDate(),
                tx.getDueDate()
//                tx.getReturnDate()
        );
    }
}