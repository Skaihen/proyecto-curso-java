package io.skaihen.proyecto_curso_java;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.skaihen.proyecto_curso_java.model.Pokemon;
import io.skaihen.proyecto_curso_java.repositories.PokemonRepository;

@Component
public class Initializer implements CommandLineRunner {
    private final PokemonRepository pokemonRepository;

    public Initializer(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public void run(String... args) {
        Stream.of("Bulbasaur", "Squirtle", "Charmander").forEach(name -> {
            Pokemon pokemon = new Pokemon();
            pokemon.setName(name);
            pokemonRepository.save(pokemon);
        });

        pokemonRepository.findAll().forEach(System.out::println);
    }
}
