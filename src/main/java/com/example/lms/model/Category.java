package com.example.lms.model;


import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // اسم التصنيف
    @Column(nullable = false)
    private String name;

    // هيكل هرمي: ممكن يبقى التصنيف ابن من تصنيف تاني
//    @ManyToOne
//    @JoinColumn(name = "parent_id")
//    private Category parentCategory;
}