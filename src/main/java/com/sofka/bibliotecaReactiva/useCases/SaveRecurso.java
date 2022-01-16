package com.sofka.bibliotecaReactiva.useCases;

import com.sofka.bibliotecaReactiva.models.RecursoDto;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface SaveRecurso {
    public Mono<String> apply(RecursoDto recursoDto);
}