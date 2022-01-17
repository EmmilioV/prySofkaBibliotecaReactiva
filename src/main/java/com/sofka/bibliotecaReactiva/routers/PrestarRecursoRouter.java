package com.sofka.bibliotecaReactiva.routers;

import com.sofka.bibliotecaReactiva.models.RecursoDto;
import com.sofka.bibliotecaReactiva.useCases.PrestarRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PrestarRecursoRouter {
    @Bean
    public RouterFunction<ServerResponse> prestarRecurso(PrestarRecursoUseCase prestarRecursoUseCase){
        return route(PUT("/prestarRecurso/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> prestarRecursoUseCase.apply(request.pathVariable("id"))
                        .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.TEXT_PLAIN)
                                        .bodyValue(result))
        );
    }
}
