package com.sofka.bibliotecaReactiva.useCases;

import com.sofka.bibliotecaReactiva.Mapper.MapperUtils;
import com.sofka.bibliotecaReactiva.models.RecursoDto;
import com.sofka.bibliotecaReactiva.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class ConsultarRecursoUseCase implements Function<String, Mono<RecursoDto>> {

    private final RecursoRepository repositorio;
    private final MapperUtils mapperUtils;

    @Autowired
    public ConsultarRecursoUseCase(MapperUtils mapperUtils, RecursoRepository repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }


    @Override
    public Mono<RecursoDto> apply(String id) {
        return repositorio.findById(id)
                .map(recurso -> mapperUtils.mapRecursoToDto().apply(recurso)) ;
    }
}
