package com.lumier.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dishes") // Теперь адрес будет: /api/dishes
@CrossOrigin(origins = "*")
@RequiredArgsConstructor // Это создаст конструктор для dishRepository
public class DishController {

    private final DishRepository dishRepository;

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }
}