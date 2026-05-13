package com.lumier.backend;
import com.lumier.backend.DishRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final DishRepository dishRepository;

    @Override
    public void run(String... args) throws Exception {
        if (dishRepository.count() == 0) {
            dishRepository.saveAll(List.of(
                    new Dish(null, "Lumier Burger", 2500.0, "Main Course", 15),
                    new Dish(null, "Classic Pizza", 3200.0, "Main Course", 20),
                    new Dish(null, "Cappuccino", 1200.0, "Drinks", 5),
                    new Dish(null, "Green Tea", 800.0, "Drinks", 3),
                    new Dish(null, "Cheesecake", 1800.0, "Desserts", 10),
                    new Dish(null, "Caesar Salad", 2100.0, "Salads", 12)
            ));
            System.out.println("База данных наполнена: добавлено 6 позиций меню!");
        }
    }
}