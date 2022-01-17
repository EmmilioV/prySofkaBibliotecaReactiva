package com.sofka.bibliotecaReactiva.useCases;

import com.sofka.bibliotecaReactiva.Mapper.MapperUtils;
import com.sofka.bibliotecaReactiva.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class ConsultarDisponibilidadUseCase implements Function<String, Mono<String>> {

    private final RecursoRepository repositorio;
    private final MapperUtils mapperUtils;

    @Autowired
    public ConsultarDisponibilidadUseCase(MapperUtils mapperUtils, RecursoRepository repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<String> apply(String id) {
        return repositorio.findById(id)
                .map(recurso -> recurso.getDisponible()
                        ? "El recurso está disponible"
                        : "El recurso no se encuentra disponible. Ultima fecha de prestamo: " + recurso.getUltimaFechaPrestamo()
                    );
    }
}
