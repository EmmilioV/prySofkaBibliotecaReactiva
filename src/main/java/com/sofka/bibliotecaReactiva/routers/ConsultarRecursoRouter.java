package com.sofka.bibliotecaReactiva.routers;

import com.sofka.bibliotecaReactiva.models.RecursoDto;
import com.sofka.bibliotecaReactiva.useCases.ConsultarRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultarRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> consultarRecurso(ConsultarRecursoUseCase consultarRecursoUseCase){
        return route(
                GET("/consultarRecurso/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(consultarRecursoUseCase.apply(request.pathVariable("id")), RecursoDto.class))
        );
    }
}
