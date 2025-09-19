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

    private String assignedSection;
}