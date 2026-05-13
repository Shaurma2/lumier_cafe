package com.lumier.backend;

import jakarta.persistence.*;
import lombok.AllArgsConstructor; // Добавь это
import lombok.Data;
import lombok.NoArgsConstructor;  // Добавь это

@Entity
@Data
@NoArgsConstructor  // Нужен для Hibernate
@AllArgsConstructor // Нужен для DataInitializer (создает конструктор со всеми полями)
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String category;
    private Integer preparationTime;
}