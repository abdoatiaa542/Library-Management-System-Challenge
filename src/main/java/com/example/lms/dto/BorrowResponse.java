package com.example.lms.dto;

import java.time.LocalDate;

public record BorrowResponse(
        Long id,
        Long bookId,
        String bookTitle,
        Long memberId,
        String memberName,
        Long processedById,
        String processedByName,
        LocalDate borrowDate,
        LocalDate dueDate
//        LocalDate returnDate
) {}