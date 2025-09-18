package com.example.lms.dto;


import java.time.LocalDate;

public record BorrowRequest(
        Long bookId,
        Long memberId,
        Long processedById,
        LocalDate dueDate
) {}
