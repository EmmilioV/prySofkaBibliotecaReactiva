package com.sofka.bibliotecaReactiva.repositories;

import com.sofka.bibliotecaReactiva.collections.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RecursoRepository extends ReactiveMongoRepository<Recurso, String> {
}
