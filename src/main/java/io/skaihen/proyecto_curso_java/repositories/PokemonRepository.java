package io.skaihen.proyecto_curso_java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.skaihen.proyecto_curso_java.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Pokemon findByName(String name);
}
