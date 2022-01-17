package com.sofka.bibliotecaReactiva.routers;

import com.sofka.bibliotecaReactiva.useCases.EliminarRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EliminarRecursoRouter {
    @Bean
    public RouterFunction<ServerResponse> eliminarRecurso(EliminarRecursoUseCase eliminarRecursoUseCase){
        return route(
                DELETE("/eliminarRecurso/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(eliminarRecursoUseCase.apply(request.pathVariable("id")), Void.class))
        );
    }
}
