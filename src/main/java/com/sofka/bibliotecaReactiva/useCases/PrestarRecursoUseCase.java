package com.sofka.bibliotecaReactiva.useCases;

import com.sofka.bibliotecaReactiva.Mapper.MapperUtils;
import com.sofka.bibliotecaReactiva.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.function.Function;

@Service
@Validated
public class PrestarRecursoUseCase implements Function<String, Mono<String>> {
    private final RecursoRepository repositorio;
    private final MapperUtils mapperUtils;

    @Autowired
    public PrestarRecursoUseCase(MapperUtils mapperUtils, RecursoRepository repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<String> apply(String id) {
        return repositorio.findById(id)
                .map(recurso -> {
                            if(!recurso.getDisponible()){
                                return "No se puede prestar, el recurso está prestado";
                            }
                            recurso.setDisponible(true);
                            recurso.setUltimaFechaPrestamo(LocalDate.now());
                            repositorio.save(recurso);
                            return "Recurso prestado con exito";
                        }
                );
    }
}
