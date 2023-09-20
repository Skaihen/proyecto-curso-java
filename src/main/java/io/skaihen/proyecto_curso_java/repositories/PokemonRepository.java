package io.skaihen.proyecto_curso_java.repositories;

import io.skaihen.proyecto_curso_java.entities.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    Pokemon findById(long id);
}
