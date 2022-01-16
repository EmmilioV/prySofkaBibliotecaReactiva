package com.sofka.bibliotecaReactiva.routers;

import com.sofka.bibliotecaReactiva.models.RecursoDto;
import com.sofka.bibliotecaReactiva.useCases.CrearRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class crearRecursoRoute {
    @Bean
    public RouterFunction<ServerResponse> crearRecurso(CrearRecursoUseCase crearRecursoUseCase){
        return route(POST("/crearRecurso").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RecursoDto.class)
                        .flatMap(recursoDto -> crearRecursoUseCase.apply(recursoDto)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.TEXT_PLAIN)
                                        .bodyValue(result)))
                );
    }
}
