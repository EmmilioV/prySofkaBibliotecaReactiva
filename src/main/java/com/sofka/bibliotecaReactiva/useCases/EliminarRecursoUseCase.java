package com.sofka.bibliotecaReactiva.useCases;

import com.sofka.bibliotecaReactiva.Mapper.MapperUtils;
import com.sofka.bibliotecaReactiva.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class EliminarRecursoUseCase implements Function<String, Mono<Void>> {

    private final RecursoRepository repositorio;
    private final MapperUtils mapperUtils;

    @Autowired
    public EliminarRecursoUseCase(MapperUtils mapperUtils, RecursoRepository repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<Void> apply(String id) {
        Objects.requireNonNull(id, "Id is required");
        return repositorio.deleteById(id);
    }
}
