package com.example.lms.model.users;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "staff")
public class Staff extends User {
    // خصائص خاصة بالـ Staff
    private String shiftTime; // مثال: Morning / Evening
}