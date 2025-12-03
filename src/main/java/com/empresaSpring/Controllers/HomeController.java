package com.empresaSpring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Muestra la página de inicio
    @GetMapping("/")
    public String home() {
        return "index"; // Thymeleaf buscará templates/index.html
    }
}