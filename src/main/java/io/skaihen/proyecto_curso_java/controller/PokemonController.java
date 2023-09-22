package io.skaihen.proyecto_curso_java.controller;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.skaihen.proyecto_curso_java.model.Pokemon;
import io.skaihen.proyecto_curso_java.repositories.PokemonRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PokemonController {
    private final Logger log = LoggerFactory.getLogger(PokemonController.class);
    private PokemonRepository pokemonRepository;

    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @CrossOrigin
    @GetMapping("/pokemons")
    Collection<Pokemon> getPokemons() {
        return pokemonRepository.findAll();
    }

    @GetMapping("/pokemon/{id}")
    ResponseEntity<Pokemon> getPokemonById(@PathVariable Long id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        return pokemon.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/pokemon")
    ResponseEntity<Pokemon> createPokemon(@Valid @RequestBody Pokemon pokemon) {
        log.info("Request to create pokemon: {}", pokemon);
        Pokemon result = pokemonRepository.save(pokemon);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/pokemon/{id}")
    ResponseEntity<Pokemon> updatePokemon(@Valid @RequestBody Pokemon pokemon) {
        log.info("Request to update pokemon: {}", pokemon);
        Pokemon result = pokemonRepository.save(pokemon);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> deletePokemon(@PathVariable Long id) {
        log.info("Request to delete pokemon: {}", id);
        pokemonRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
