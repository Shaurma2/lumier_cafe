package com.lumier.backend;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final DishRepository dishRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Data
    public static class OrderRequest {
        private String customerName;
        private List<Long> dishIds;
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        List<Dish> selectedDishes = dishRepository.findAllById(request.getDishIds());

        Double total = selectedDishes.stream()
                .mapToDouble(Dish::getPrice)
                .sum();

        Order order = new Order();
        order.setCustomerName(request.getCustomerName()); // Устанавливаем имя
        order.setDishes(selectedDishes);
        order.setTotalAmount(total);
        order.setOrderTime(LocalDateTime.now());
        order.setStatus("PENDING");

        return orderRepository.save(order);
    }
}