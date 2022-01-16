package com.sofka.bibliotecaReactiva.Mapper;

import com.sofka.bibliotecaReactiva.collections.Recurso;
import com.sofka.bibliotecaReactiva.models.RecursoDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtils {
    public Function<RecursoDto, Recurso> mapperToRecurso(String id) {
        return updateDato -> {
            var recurso = new Recurso();
            recurso.setId(id);
            recurso.setNombre(updateDato.getNombre());
            recurso.setUltimaFechaPrestamo(updateDato.getUltimaFechaPrestamo());
            recurso.setDisponible(updateDato.getDisponible());
            recurso.setTipo(updateDato.getTipo());
            recurso.setTematica(updateDato.getTematica());
            return recurso;
        };
    }

    public Function<Recurso, RecursoDto> mapRecursoToDto() {
        return entity -> new RecursoDto(
                entity.getId(),
                entity.getNombre(),
                entity.getUltimaFechaPrestamo(),
                entity.getDisponible(),
                entity.getTipo(),
                entity.getTematica()
        );
    }
}
