package com.sofka.bibliotecaReactiva.useCases;

import com.sofka.bibliotecaReactiva.Mapper.MapperUtils;
import com.sofka.bibliotecaReactiva.collections.Recurso;
import com.sofka.bibliotecaReactiva.models.RecursoDto;
import com.sofka.bibliotecaReactiva.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class ActualizarRecursoUseCase implements SaveRecurso{

    private final RecursoRepository repositorio;
    private final MapperUtils mapperUtils;

    @Autowired
    public ActualizarRecursoUseCase(MapperUtils mapperUtils, RecursoRepository repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<String> apply(RecursoDto recursoDto) {
        return repositorio.save(mapperUtils.mapperToRecurso(recursoDto.getId()).apply(recursoDto))
                .map(Recurso::getId);
    }
}
