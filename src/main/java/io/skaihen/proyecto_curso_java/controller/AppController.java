package io.skaihen.proyecto_curso_java.controller;

import io.skaihen.proyecto_curso_java.entities.Pokemon;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class AppController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "index";
    }

    @PostMapping("/addPokemon")
    public String addPokemon(@Valid Pokemon pokemon, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index";
        }
        return "redirect:/";
    }
}
