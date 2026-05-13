package com.lumier.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dishes")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DishController {

    private final DishRepository dishRepository;

    // Получить все блюда
    @GetMapping
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    // отправьте данные блюда, и они сохранятся в базу
    @PostMapping
    public Dish createDish(@RequestBody Dish dish) {
        return dishRepository.save(dish);
    }

    //удаление по айди
    @DeleteMapping("/{id}")
    public void deleteDish(@PathVariable Long id) {
        dishRepository.deleteById(id);
    }
}