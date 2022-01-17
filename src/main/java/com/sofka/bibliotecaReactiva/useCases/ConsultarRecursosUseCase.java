package com.sofka.bibliotecaReactiva.useCases;

import com.sofka.bibliotecaReactiva.Mapper.MapperUtils;
import com.sofka.bibliotecaReactiva.models.RecursoDto;
import com.sofka.bibliotecaReactiva.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class ConsultarRecursosUseCase implements Supplier<Flux<RecursoDto>> {

    private final RecursoRepository repositorio;
    private final MapperUtils mapperUtils;

    @Autowired
    public ConsultarRecursosUseCase(MapperUtils mapperUtils, RecursoRepository repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Flux<RecursoDto> get() {
        return repositorio.findAll().map(recurso -> mapperUtils.mapRecursoToDto().apply(recurso));
    }
}
