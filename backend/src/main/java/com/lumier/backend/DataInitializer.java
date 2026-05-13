package com.lumier.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final DishRepository dishRepository;

    @Override
    public void run(String... args) {
        if (dishRepository.count() == 0) {
            Dish burger = new Dish();
            burger.setName("Lumier Burger");
            burger.setPrice(2500.0);
            burger.setCategory("Food");
            burger.setTime(15);

            dishRepository.save(burger);
            System.out.println("База данных наполнена начальными блюдами!");
        }
    }
}