package io.skaihen.proyecto_curso_java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.skaihen.proyecto_curso_java.entities.Pokemon;
import io.skaihen.proyecto_curso_java.repositories.PokemonRepository;
import jakarta.validation.Valid;

@Controller
public class PokemonController {
    PokemonRepository pokemonRepository;
    String redirectIndex = "redirect:/index";

    @GetMapping("/newpokemon")
    public String showAddPokemonForm(Pokemon pokemon, BindingResult result, Model model) {
        return "add-pokemon";
    }

    @PostMapping("/addpokemon")
    public String addPokemon(@Valid Pokemon pokemon, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-pokemon";
        }

        pokemonRepository.save(pokemon);
        return redirectIndex;
    }

    @GetMapping("/index")
    public String showPokemonList(Model model) {
        model.addAttribute("pokemons", pokemonRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Pokemon pokemon = pokemonRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pokemon Id:" + id));

        model.addAttribute("pokemon", pokemon);
        return "update-pokemon";
    }

    @PostMapping("/update/{id}")
    public String updatePokemon(@PathVariable("id") long id, @Valid Pokemon pokemon, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            pokemon.setId(id);
            return "update-pokemon";
        }

        pokemonRepository.save(pokemon);
        return redirectIndex;
    }

    @GetMapping("/delete/{id}")
    public String deletePokemon(@PathVariable("id") long id, Model model) {
        Pokemon pokemon = pokemonRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pokemon Id:" + id));
        pokemonRepository.delete(pokemon);
        return redirectIndex;
    }

}
