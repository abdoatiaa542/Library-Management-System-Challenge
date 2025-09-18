package com.example.lms.model.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "librarians")
public class Librarian extends User {
    // خصائص خاصة بالمكتبي
    private String assignedSection; // مثال: قسم الروايات / قسم التاريخ
}