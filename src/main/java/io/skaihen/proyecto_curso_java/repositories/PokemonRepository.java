package io.skaihen.proyecto_curso_java.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.skaihen.proyecto_curso_java.entities.Pokemon;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
}
