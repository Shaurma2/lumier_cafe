package com.lumier.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
public class Controller {

    @GetMapping("/api/welcome")
    public String welcome() {
        return "Lumier Cafe API: Сервер запущен. Привет, React!";
    }
}